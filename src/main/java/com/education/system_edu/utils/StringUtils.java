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
     *
     * @param str
     * @param length
     * @return
     */
    public static String lengthControl(String str, Integer length) {

        if (length > str.length()) {
            StringBuilder strAdd = new StringBuilder();
            for (int i = 0; i < length - str.length(); i++) {
                strAdd.append("0");
            }
            return strAdd + str;
        }else{
            return str.substring(str.length() - length, str.length());
        }
    }

    private static String[] splitString(String str, String splitStr) {
        return str.split(splitStr);
    }

    private static String stringPre(String[] str) {
        return str[0];
    }

    private static String stringLast(String[] str) {
        return str[str.length - 1];
    }

    public static String outPre(String str, String splitStr) {
        return stringPre(splitString(str, splitStr));
    }

    public static String outLast(String str, String splitStr) {
        return stringLast(splitString(str, splitStr));
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static void main(String[] args) {
        System.out.println(isEmpty(null));
    }
    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append("0").append(str);// 左补0
            // sb.append(str).append("0");//右补0
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }
}
