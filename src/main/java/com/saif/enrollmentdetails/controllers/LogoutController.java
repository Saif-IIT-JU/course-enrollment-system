package com.saif.enrollmentdetails.controllers;

import com.saif.enrollmentdetails.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author saifuzzaman
 */
@Controller
public class LogoutController {

    @Autowired
    private HttpSession session;
    private static final String HOME_PAGE = "home";

    @GetMapping("/logout")
    public String processLogout() {
        session.invalidate();

        return Utils.redirectTo(HOME_PAGE);
    }
}
