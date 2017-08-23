/**
 * 
 */
package com.sk.taxcalculator.taxhandler;

import com.sk.taxcalculator.model.Product;

/**
 * @author Sandeep Kaul
 *
 *         Handler for products of type Medicine.
 */
public class MedicineHandler implements ProductHandler {

  public double getTaxForProduct(Product product) {

    return 0.0;
  }

}
