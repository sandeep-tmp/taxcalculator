/**
 * 
 */
package com.sk.taxcalculator.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.sk.taxcalculator.model.Invoice;
import com.sk.taxcalculator.model.Product;
import com.sk.taxcalculator.service.BillingService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sandeep kaul
 *
 */
@Path("/billing")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {

  private final BillingService billingService;

  public BillingResource(BillingService billingService) {
    this.billingService = billingService;
  }

  /**
   * Sample Request: 
   * 
   * <pre>curl -X POST http://localhost:8090/billing/generate_bill -H 'content-type: application/json' -d '[{"productId":1,"name":"wine","type":"OTHERS","quantity":2,"pricePerItem":20.99,"tax":7.35,"priceWithTax":49.33},{"productId":2,"name":"pills","type":"MEDICINE","quantity":3,"pricePerItem":4.15,"tax":0.0,"priceWithTax":12.450000000000001},{"productId":3,"name":"pins","type":"OTHERS","quantity":2,"pricePerItem":11.25,"tax":3.95,"priceWithTax":26.45},{"productId":4,"name":"CD","type":"CD","quantity":3,"pricePerItem":14.99,"tax":11.65,"priceWithTax":56.62}] '</pre>
   * 
   * @param request
   * @param products
   * @return
   */
  @POST
  @Path("/generate_bill")
  @Timed
  @Metered(name = "generateBill.CallMeter")
  @ExceptionMetered(name = "generateBill.ExceptionMeter", cause = Exception.class)
  public Invoice generateBill(@Context HttpServletRequest request, @NotNull List<Product> products) {

    Invoice invoice = billingService.generateBill(products);
    return invoice;
  }


}
