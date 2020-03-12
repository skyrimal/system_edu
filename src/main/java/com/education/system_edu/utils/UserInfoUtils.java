package com.education.system_edu.utils;

import com.education.system_edu.pojo.User;
import org.apache.shiro.subject.Subject;

public class UserInfoUtils {
    private SubjectUtils subjectUtils;

    public UserInfoUtils(Subject subject) {
        this.subjectUtils = new SubjectUtils(subject);
    }

    private User getLoginUser() {
        return (User) subjectUtils.getPrincipal();
    }

    public String getLoginCode(){
        return getLoginUser().getLoginCode();
    }
}
