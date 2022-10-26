package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationRegex {
    public static boolean isRegexEmail(String target) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }
    public final static String regexId = "^[a-z0-9_]{1,10}$";
    public final static String regexNickName = "^[가-힣]{1,5}$";
    public final static String regexPhone = "^[0-9]{11}$";
    public final static String regexPassword = "^[a-z0-9!?@#$%^&*():;+-=~{}<>\\_\\[\\]\\|\\\\\\\"\\'\\,\\.\\/\\`\\₩]{8,12}$";
}

