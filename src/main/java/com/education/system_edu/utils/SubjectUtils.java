package com.education.system_edu.utils;

import org.apache.shiro.subject.Subject;

public class SubjectUtils {
    private Subject subject;

    public SubjectUtils(Subject subject) {
        this.subject = subject;
    }
    public String getUserLoginCode(){
        return subject.getPrincipal().toString();
    }
}
