package com.education.system_edu.utils;


import com.education.system_edu.pojo.User;

import java.util.Date;
import java.util.Random;

/**
 * 随机生成用户信息
 */
public class RandomStudentMaker {
    private  Random random= new Random();
    public User madeAStudent(String no) {
        User user = new User();
        user.setCode(madeCode(no));
        user.setLoginCode(no);
        user.setUserName(madeUserName(2+random.nextInt(2)));
        user.setPassword(UserMessage.DEFAULT_PASSWORD);
        user.setUserType(UserMessage.STUDENT_TYPE);
        user.setMgrType("0");
        user.setLastLoginDate(new Date());
        user.setCreateDate(new Date());
        user.setCreateBy("system");
        user.setUpdateDate(new Date());
        user.setUpdateBy("system");
        return user;
    }

    public  String madeCode(String no) {
        return UU3D.uu3d() + no;
    }


    public  String madeUserName(Integer index) {
        String name = "";
        for (int i = 0; i < index; i++) {
            char cha = getRandomChar();
            name += String.valueOf(cha);
        }
        return name;
    }

    private  char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }


}
