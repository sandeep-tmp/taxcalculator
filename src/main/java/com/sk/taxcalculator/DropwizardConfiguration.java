package com.sk.taxcalculator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.dropwizard.Configuration;
import lombok.Getter;

/**
 * 
 * @author sandeep kaul
 *
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropwizardConfiguration extends Configuration {

  
}
