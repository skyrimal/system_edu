package com.education.system_edu.utils;

public class PageUtils {
    public static String TEACHER = "t_";
    public static String STUDENT = "stu_";
    public static String MANAGER = "m_";

    public static String findPageByUserType(String userType, String lastUrlName) {
        switch (userType) {
            case "1":
                return TEACHER + lastUrlName;
            case "2":
                return STUDENT + lastUrlName;
            case "3":
                return MANAGER + lastUrlName;
            default:
                return "error";
        }
    }
}
