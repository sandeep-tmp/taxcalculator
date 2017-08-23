/**
 * 
 */
package com.sk.taxcalculator.taxhandler;

import com.sk.taxcalculator.model.Product;
import com.sk.taxcalculator.util.Utilities;

/**
 * @author Sandeep Kaul
 * 
 *         Default handler. This is executed when product type is Others/Unknown
 *
 */
public class OtherHandler implements ProductHandler {

  public double getTaxForProduct(Product product) {
    double bill = product.getQuantity()*product.getPricePerItem();
    double tax = bill*0.175;
    tax = Utilities.getRoundedTax(tax);
    return tax;
  }

 }
