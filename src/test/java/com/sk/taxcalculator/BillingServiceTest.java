package com.sk.taxcalculator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sk.taxcalculator.exception.CustomException;
import com.sk.taxcalculator.exception.ErrorCode;
import com.sk.taxcalculator.model.Invoice;
import com.sk.taxcalculator.model.Product;
import com.sk.taxcalculator.model.ProductType;
import com.sk.taxcalculator.service.BillingService;

import junit.framework.TestCase;

public class BillingServiceTest extends TestCase {

  private BillingService billingService = new BillingService();;


  public void testNullProducts() {
    
    try {
      billingService.generateBill(null);
      Assert.assertFalse(false);
    } catch (CustomException e) {
      Assert.assertEquals(e.getErrorCode(), ErrorCode.INVALID_DATA);
    }
  }

  @Test
  public void testEmptyProducts() {

    List<Product> products = new ArrayList<Product>();
    try {
      billingService.generateBill(products);
      Assert.assertFalse(false);
    } catch (CustomException e) {
      Assert.assertEquals(e.getErrorCode(), ErrorCode.INVALID_DATA);
    }
  }

  public void testInvalidUseCase() {

    List<Product> products = new ArrayList<Product>();
    products.add(new Product(1, "book", ProductType.OTHERS, 1, -1, 0, 0));
    products.add(new Product(2, "music CD", ProductType.CD, 1, 15.99, 0, 0));
    products.add(new Product(3, "chocalate", ProductType.OTHERS, 1, 0.75, 0, 0));
    try {
    billingService.generateBill(products);
    } catch (CustomException e) {
      Assert.assertEquals(e.getErrorCode(), ErrorCode.INVALID_DATA);
    }
   
  }
  
  public void testBaseUseCase() {

    List<Product> products = new ArrayList<Product>();
    products.add(new Product(1, "book", ProductType.MEDICINE, 1, 500, 0, 0));
    Invoice invoice = billingService.generateBill(products);

    Assert.assertEquals("Incorrect Sales Tax", 0.0, invoice.getServiceTax(), 0.1);
    Assert.assertEquals("Incorrect Bill", 500, invoice.getTotalBill(), 0.1);
    Assert.assertEquals("Incorrect Bill", 1, invoice.getProducts().size());
    Assert.assertEquals("Incorrect Bill", 500, invoice.getProducts().get(0).getPriceWithTax(),
        0.01);
  }
  
  public void testUseCase1() {

    List<Product> products = new ArrayList<Product>();
    products.add(new Product(1, "book", ProductType.OTHERS, 1, 29.49, 0, 0));
    products.add(new Product(2, "music CD", ProductType.CD, 1, 15.99, 0, 0));
    products.add(new Product(3, "chocalate", ProductType.OTHERS, 1, 0.75, 0, 0));
    Invoice invoice = billingService.generateBill(products);

    Assert.assertEquals("Incorrect Sales Tax", 9.4, invoice.getServiceTax(), 0.1);
    Assert.assertEquals("Incorrect Bill", 55.63, invoice.getTotalBill(), 0.1);
    Assert.assertEquals("Incorrect Bill", 55.63, invoice.getTotalBill(), 0.1);
    Assert.assertEquals("Incorrect Bill", 3, invoice.getProducts().size());
    Assert.assertEquals("Incorrect Bill", 34.69, invoice.getProducts().get(0).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 20.04, invoice.getProducts().get(1).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 0.90, invoice.getProducts().get(2).getPriceWithTax(),
        0.01);
  }

  public void testUseCase2() {

    List<Product> products = new ArrayList<Product>();
    products.add(new Product(1, "wine", ProductType.OTHERS, 1, 20.99, 0, 0));
    products.add(new Product(2, "pills", ProductType.MEDICINE, 1, 4.15, 0, 0));
    products.add(new Product(3, "pins", ProductType.OTHERS, 1, 11.25, 0, 0));
    products.add(new Product(4, "CD", ProductType.CD, 1, 14.99, 0, 0));
    Invoice invoice = billingService.generateBill(products);

    Assert.assertEquals("Incorrect Sales Tax", 9.60, invoice.getServiceTax(), 0.1);
    Assert.assertEquals("Incorrect Bill", 60.98, invoice.getTotalBill(), 0.1);
    Assert.assertEquals("Incorrect Bill", 60.98, invoice.getTotalBill(), 0.1);
    Assert.assertEquals("Incorrect Bill", 4, invoice.getProducts().size());
    Assert.assertEquals("Incorrect Bill", 24.69, invoice.getProducts().get(0).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 4.15, invoice.getProducts().get(1).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 13.25, invoice.getProducts().get(2).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 18.89, invoice.getProducts().get(3).getPriceWithTax(),
        0.01);
  }


  public void testUseCase3() {


    List<Product> products = new ArrayList<Product>();
    products.add(new Product(1, "wine", ProductType.OTHERS, 2, 20.99, 0, 0));
    products.add(new Product(2, "pills", ProductType.MEDICINE, 3, 4.15, 0, 0));
    products.add(new Product(3, "pins", ProductType.OTHERS, 2, 11.25, 0, 0));
    products.add(new Product(4, "CD", ProductType.CD, 3, 14.99, 0, 0));
    Invoice invoice = billingService.generateBill(products);


    Assert.assertEquals("Incorrect Bill", 49.33, invoice.getProducts().get(0).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 12.45, invoice.getProducts().get(1).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 26.45, invoice.getProducts().get(2).getPriceWithTax(),
        0.01);
    Assert.assertEquals("Incorrect Bill", 56.62, invoice.getProducts().get(3).getPriceWithTax(),
        0.01);

    Assert.assertEquals("Incorrect Sales Tax", 22.95, invoice.getServiceTax(), 0.1);
    Assert.assertEquals("Incorrect Bill", 144.85, invoice.getTotalBill(), 0.1);
    Assert.assertEquals("Incorrect Bill", 4, invoice.getProducts().size());


  }

}
