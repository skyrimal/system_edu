package com.education.system_edu.pojo.insert;


public class ClassInsert {
    private String code;
    private String classClassCode;
    private String grade;
    private String major;
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public ClassInsert() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassClassCode() {
        return classClassCode;
    }

    public void setClassClassCode(String classClassCode) {
        this.classClassCode = classClassCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
