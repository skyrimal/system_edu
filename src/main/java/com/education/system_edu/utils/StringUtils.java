package com.education.system_edu.utils;

import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 首字母大写
     *
     * @param s
     * @return
     */
    public static String capitalized(String s) {
        return s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase());
    }

    /**
     * 长度控制方法
     * @param str
     * @param length
     * @return
     */
    public static String lengthControl(String str, Integer length) {
        if (length - str.length() > -1) {
            StringBuilder strAdd = new StringBuilder();
            for (int i = 0; i < length - str.length(); i++){
             strAdd.append("0");
            }
            return strAdd+str;
        }
        return "error";
    }

}
