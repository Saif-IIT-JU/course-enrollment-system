package com.saif.enrollmentdetails.validators;

import com.saif.enrollmentdetails.model.Trainee;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author saifuzzaman
 */
@Service
public class EmailValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Trainee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "email can't be empty");
    }
}
