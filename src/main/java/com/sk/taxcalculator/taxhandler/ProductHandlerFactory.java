/**
 * 
 */
package com.sk.taxcalculator.taxhandler;

import com.sk.taxcalculator.model.ProductType;

/**
 * @author Sandeep Kaul
 *
 * This is  factory for getting the billing handlers for each product type.
 */
public class ProductHandlerFactory {

  private static CDHandler cdHandler;
  private static MedicineHandler medicineHandler;
  private static OtherHandler otherHandler;

  static {
    cdHandler = new CDHandler();
    medicineHandler = new MedicineHandler();
    otherHandler = new OtherHandler();
  }

  public static ProductHandler getProductHandler(ProductType productType) {
    switch (productType) {
      case CD:
        return cdHandler;
      case MEDICINE:
        return medicineHandler;
      default:
        return otherHandler;
    }
  }
}
