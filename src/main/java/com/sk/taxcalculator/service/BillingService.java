/**
 * 
 */
package com.sk.taxcalculator.service;

import java.util.List;

import com.sk.taxcalculator.exception.CustomException;
import com.sk.taxcalculator.exception.ErrorCode;
import com.sk.taxcalculator.model.Invoice;
import com.sk.taxcalculator.model.Product;
import com.sk.taxcalculator.taxhandler.ProductHandler;
import com.sk.taxcalculator.taxhandler.ProductHandlerFactory;
import com.sk.taxcalculator.util.Utilities;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sandeep.kaul
 *
 */
@Slf4j
public class BillingService {


  public BillingService() {}

  /**
   * This will ideally take products and their counts
   * 
   * @param products
   * @return
   */
  public Invoice generateBill(List<Product> products) {


    Invoice invoice = new Invoice(products, 0, 0);
    if (products == null || products.isEmpty()) {
      log.info("Invalid Request:{}. Breaking out", products);
      throw new CustomException(ErrorCode.INVALID_DATA);
    }
    double billAmount = 0;
    double totalTax = 0;
    for (Product product : products) {
      if (product.getPricePerItem() < 0) {
        log.info("Product price cant be negative. Breaking out for request:{}", products);
        throw new CustomException(ErrorCode.INVALID_DATA);
      }
      double tax = getTaxForProduct(product);
      double bill = product.getQuantity() * product.getPricePerItem();
      product.setTax(tax);
      double priceWithTax = bill + tax;
      product.setPriceWithTax(Utilities.roundToTwoDecimals(priceWithTax));
      billAmount = billAmount + bill + tax;
      totalTax = totalTax + tax;
    }
    totalTax = Utilities.getRoundedTax(totalTax);
    invoice.setServiceTax(totalTax);
    invoice.setTotalBill(Utilities.roundToTwoDecimals(billAmount));
    log.info("Returning invoice:{} for request:{}",invoice, products);
    return invoice;
  }

  private double getTaxForProduct(Product product) {
    // This should call product Dao ideally for getting product price and type based on product id.

    // Gets the handler for each product, and lets them calculate tax seperately.
    ProductHandler handler = ProductHandlerFactory.getProductHandler(product.getType());
    double tax = handler.getTaxForProduct(product);
    return tax;
  }


}
