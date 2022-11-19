package com.saif.enrollmentdetails.controllers;

import com.saif.enrollmentdetails.helper.AuthenticationHelper;
import com.saif.enrollmentdetails.utils.Constants;
import com.saif.enrollmentdetails.validators.UsernameValidator;
import com.saif.enrollmentdetails.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.saif.enrollmentdetails.utils.Utils.redirectTo;

/**
 * @author saifuzzaman
 */
@Controller
public class LoginController {

    @Autowired
    private AuthenticationHelper authenticationHelper;

    @Autowired
    private HttpSession session;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UsernameValidator usernameValidator;

    private static final String DASHBOARD_PAGE = "dashboard";
    private static final String LOGIN_FORM_PAGE = "loginForm";
    private static final String LOGIN_PAGE = "login";
    private static final String COMMAND= "user";

    @InitBinder(COMMAND)
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        dataBinder.addValidators(usernameValidator);
    }

    @GetMapping("/login")
    public String showLoginForm(ModelMap model) {
        model.addAttribute(COMMAND, new User());

        return LOGIN_FORM_PAGE;
    }

    @PostMapping("/login/process")
    public String processLogin(@Valid @ModelAttribute(COMMAND) User user, BindingResult bindingResult) {
        String username = user.getUsername();
        String password = user.getPassword();

        if (bindingResult.hasErrors()) {
            return LOGIN_FORM_PAGE;
        } else if (authenticationHelper.isValidCredential(username, password)) {
            session.setAttribute(Constants.SESSION_USER, username);
            return redirectTo(DASHBOARD_PAGE);
        } else {
            session.setAttribute("LoginAlert", messageSource
                    .getMessage("login.alert.incorrect.credential", null, LocaleContextHolder.getLocale()));

            return redirectTo(LOGIN_PAGE);
        }
    }
}
