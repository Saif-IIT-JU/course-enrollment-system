package com.saif.enrollmentdetails.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author saifuzzaman
 */
@Controller
public class MessageController {

    public static String alert;
    private static final String SHOW_MESSAGE_PAGE = "showMessage";

    @GetMapping("/message")
    public String viewAlert(Model model) {
        model.addAttribute("alert", alert);

        return SHOW_MESSAGE_PAGE;
    }
}
