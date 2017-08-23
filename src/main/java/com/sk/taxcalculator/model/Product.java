/**
 * 
 */
package com.sk.taxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sandeep.kaul
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private long productId;
  private String name;
  private ProductType type;
  private int quantity;
  private double pricePerItem;
  private double tax;
  private double priceWithTax;
  
}
