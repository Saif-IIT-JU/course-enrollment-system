package com.saif.enrollmentdetails.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author saifuzzaman
 */
@Controller
public class DashboardController {

    private static final String DASHBOARD_PAGE = "dashboard";

    @GetMapping("/dashboard")
    public String getDashboard() {
        return DASHBOARD_PAGE;
    }
}
