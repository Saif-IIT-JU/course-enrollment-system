package com.saif.enrollmentdetails.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author saifuzzaman
 */
@Controller
public class IndexController {

    private static final String HOME_PAGE = "index";

    @GetMapping("/home")
    public String getIndex() {
        return HOME_PAGE;
    }
}
