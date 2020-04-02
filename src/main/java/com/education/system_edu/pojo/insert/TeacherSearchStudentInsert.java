package com.education.system_edu.pojo.insert;

import com.education.system_edu.pojo.model.Page;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月02日 12:36
 */
public class TeacherSearchStudentInsert extends Page {
    private String studentLoginCode;
    private String studentName;
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }



    public String getStudentLoginCode() {
        return studentLoginCode;
    }

    public void setStudentLoginCode(String studentLoginCode) {
        this.studentLoginCode = studentLoginCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
