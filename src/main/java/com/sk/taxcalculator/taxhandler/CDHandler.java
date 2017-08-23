/**
 * 
 */
package com.sk.taxcalculator.taxhandler;

import com.sk.taxcalculator.model.Product;
import com.sk.taxcalculator.model.ProductType;
import com.sk.taxcalculator.util.Utilities;

/**
 * @author Sandeep Kaul
 *
 *         Handler for products of type CD.
 */
public class CDHandler implements ProductHandler {

  public double getTaxForProduct(Product product) {

    double bill = product.getQuantity() * product.getPricePerItem();
    double tax = bill * 0.175;
    if (ProductType.CD.equals(product.getType())) {
      double cdExtra = 1.25 * product.getQuantity();
      tax = tax + cdExtra;
    }
    // tax = ((int)((int)tax*100))/100;
    tax = Utilities.getRoundedTax(tax);
    return tax;
  }

}
