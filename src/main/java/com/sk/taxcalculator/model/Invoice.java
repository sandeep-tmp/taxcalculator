/**
 * 
 */
package com.sk.taxcalculator.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sandeep Kaul
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

  private List<Product> products;
  private double serviceTax;
  private double totalBill;

}
