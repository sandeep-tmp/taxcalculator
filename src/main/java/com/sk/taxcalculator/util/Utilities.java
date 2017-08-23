/**
 * 
 */
package com.sk.taxcalculator.util;

/**
 * @author Sandeep Kaul
 *
 */
public class Utilities {

  public static double getRoundedTax(double tax) {
    int taxInt = (int)(tax*100);
    int mod = taxInt%5;
    if(mod != 0) {
      taxInt = taxInt+5-mod;
    }
    return ((double)taxInt/100);
  }

  public static double roundToTwoDecimals(double number) {
    
    int intnumber = (int) (number * 100);
    number = (double) intnumber / 100;
    return number;
  }
}
