package com.sk.taxcalculator;



import com.sk.taxcalculator.exception.MyExceptionMapper;
import com.sk.taxcalculator.resources.BillingResource;
import com.sk.taxcalculator.service.BillingService;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * 
 * @author sandeep kaul
 *
 */
public class DropwizardApplication extends Application<DropwizardConfiguration> {

  public static void main(String[] args) throws Exception {
    new DropwizardApplication().run(args);
  }

  @Override
  public void run(DropwizardConfiguration configuration, Environment environment) throws Exception {

    // Services
    BillingService billingService = new BillingService();

    // Resources
    BillingResource billingResource = new BillingResource(billingService);
    
    // Resource Registration
    environment.jersey().register(billingResource);
    
    //Exception Mapper
    environment.jersey().register(new MyExceptionMapper());
  }
}
