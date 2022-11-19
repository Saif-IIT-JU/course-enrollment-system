package com.saif.enrollmentdetails.utils;

/**
 * @author saifuzzaman
 */
public class Utils {

    public static String redirectTo(String path, int ... ids) {
        return "redirect:/" + path + (ids.length > 0 ? "?id=" + ids[0] : "");
    }
}
