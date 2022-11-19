package com.saif.enrollmentdetails.utils;

/**
 * @author saifuzzaman
 */
public interface Constants {

    int MAX_NAME_LENGTH = 50;
    int MAX_EMAIL_LENGTH = 20;
    int MAX_PHONE_LENGTH = 11;
    int MAX_CODE_LENGTH = 6;
    int MAX_TITLE_LENGTH = 50;
    int MAX_PASSWORD_LENGTH = 130;
    int MIN_CREDIT = 2;
    int MAX_CREDIT = 10;
    int MIN_ID = 1;
    String SESSION_USER = "SESSION_USER";
    String ALREADY_ENROLLED = "This trainee is already enrolled in this course!";
    String NOT_ENROLLED = "This trainee is not enrolled in this course!";
    String SUCCESS = "The operation successfully completed!";
    String FAILURE = "The operation can't be completed!";
    String ERROR_MESSAGE = "An Error Occurred!";
    String NO_RECORD_FOUND = "No record found!";
}
