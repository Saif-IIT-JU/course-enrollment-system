package com.saif.enrollmentdetails.validators;

import com.saif.enrollmentdetails.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author saifuzzaman
 */
@Service
public class CourseTitleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Course.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "Title can't be empty");
    }
}
