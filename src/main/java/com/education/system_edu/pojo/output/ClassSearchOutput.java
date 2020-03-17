package com.education.system_edu.pojo.output;

public class ClassSearchOutput {
    private String code;
    private String classCode;
    private String grade;
    private String teacherLoginCode;
    private String teacherName;
    private String classClassCode;
    private String facultyName;
    private String departmentName;
    private String majorName;
    private Integer numberOfClass;

    public ClassSearchOutput() {
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeacherLoginCode() {
        return teacherLoginCode;
    }

    public void setTeacherLoginCode(String teacherLoginCode) {
        this.teacherLoginCode = teacherLoginCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassClassCode() {
        return classClassCode;
    }

    public void setClassClassCode(String classClassCode) {
        this.classClassCode = classClassCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getNumberOfClass() {
        return numberOfClass;
    }

    public void setNumberOfClass(Integer numberOfClass) {
        this.numberOfClass = numberOfClass;
    }
}
