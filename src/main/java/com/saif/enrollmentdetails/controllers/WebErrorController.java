package com.saif.enrollmentdetails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.saif.enrollmentdetails.utils.Utils.redirectTo;

/**
 * @author saifuzzaman
 */
@Controller
public class WebErrorController implements ErrorController {

    @Autowired
    private MessageSource messageSource;

    private static final String  MESSAGE_VIEW_PAGE = "message";

    @GetMapping("/error")
    public String handleError() {
        MessageController.alert = messageSource.getMessage("error.message", null, LocaleContextHolder.getLocale());
        
        return redirectTo(MESSAGE_VIEW_PAGE);
    }
}
