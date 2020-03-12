package com.education.system_edu.utils;

import org.apache.shiro.subject.Subject;

public class SubjectUtils {
    private Subject subject;

    public SubjectUtils(Subject subject) {
        this.subject = subject;
    }
    private Subject getSubject(){
        return subject;
    }
    public Object getPrincipal(){
        return subject.getPrincipal();
    }

}
