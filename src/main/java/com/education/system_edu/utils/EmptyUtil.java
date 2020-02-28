package com.education.system_edu.utils;

public class EmptyUtil {
    /**
     * 判断String是否为空
     * @param obj
     * @return
     */
    public static boolean stringIsEmpty(String obj) {
        if(obj==null){
            return true;
        }else return obj.equals("");
    }
}
