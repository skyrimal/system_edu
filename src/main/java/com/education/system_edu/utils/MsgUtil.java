package com.education.system_edu.utils;

public class MsgUtil {
    public static String addMsj(int flag) {
        if (flag == 0) {
            return "添加失败";
        } else {
            return "添加成功";
        }
    }

    public static String editMsj(int flag) {
        if (flag == 0) {
            return "修改失败";
        } else {
            return "修改成功";
        }
    }

    public static String addMsj(Boolean flag) {
        if (!flag) {
            return "添加失败";
        } else {
            return "添加成功";
        }
    }

    public static String editMsj(Boolean flag) {
        if (!flag) {
            return "修改失败";
        } else {
            return "修改成功";
        }
    }
}
