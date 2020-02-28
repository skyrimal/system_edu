package com.education.system_edu.utils;

import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 首字母大写
     * @param s
     * @return
     */
    public static String capitalized(String s){
        return s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase());
    }
}
