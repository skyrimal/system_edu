package com.education.system_edu.pojo.insert;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月31日 10:39
 */
public class AddCourseClassInsert {
    String departmentCode;
    String faculty;
    String major;
    String grade;
    List<String> publicCourse;
    List<String> majorCourse;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<String> getPublicCourse() {
        return publicCourse;
    }

    public void setPublicCourse(List<String> publicCourse) {
        this.publicCourse = publicCourse;
    }

    public List<String> getMajorCourse() {
        return majorCourse;
    }

    public void setMajorCourse(List<String> majorCourse) {
        this.majorCourse = majorCourse;
    }
}
