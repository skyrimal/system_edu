package com.education.system_edu.utils;


import com.education.system_edu.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserUtils {
    public static String TEACHER = "老师";
    public static String STUDENT = "学生";
    public static String MANAGER = "管理员";

    public static String getUserType(String userType) {
        switch (userType) {
            case "1":
                return TEACHER;
            case "2":
                return STUDENT;
            case "3":
                return MANAGER;
            default:
                return "error";
        }
    }

    public static Map<String, String> userForLeftBar(User user) {
        Map<String, String> _user = new HashMap<>();
        _user.put("user_type", getUserType(user.getUserType()));
        _user.put("user_name", user.getUserName());
        return _user;
    }

    public static Map<String, Object> create(String loginCode) {
        Map<String, Object> map = new HashMap<>();

        map.put(Entry.CREATE_BY, loginCode);
        map.put(Entry.CREATE_TIME, new Date());
        return map;
    }

    public static Map<String, Object> update(String loginCode) {
        Map<String, Object> map = new HashMap<>();

        map.put(Entry.UPDATE_BY, loginCode);
        map.put(Entry.UPDATE_TIME, new Date());
        return map;
    }


}
