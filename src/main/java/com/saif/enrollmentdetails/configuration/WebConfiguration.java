package com.saif.enrollmentdetails.configuration;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author saifuzzaman
 */
@Configuration
@ServletComponentScan(basePackages = {"com.saif.enrollmentdetails.filter"})
public class WebConfiguration {
}
