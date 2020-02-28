package com.education.system_edu.pojo;

import java.util.Date;

public class SysModelClass {
    private String code;

    private String classCode;

    private Short type;

    private Short teacherType;

    private String teacherCode;

    private String teacherLoginCode;

    private String courseCodeNo;

    private String courseCode;

    private String grade;

    private String sysCollegeNodeCode;

    private Short sysCollegeNodeType;

    private String assistant;

    private String studentNo;

    private Integer studentNum;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(Short teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode == null ? null : teacherCode.trim();
    }

    public String getTeacherLoginCode() {
        return teacherLoginCode;
    }

    public void setTeacherLoginCode(String teacherLoginCode) {
        this.teacherLoginCode = teacherLoginCode == null ? null : teacherLoginCode.trim();
    }

    public String getCourseCodeNo() {
        return courseCodeNo;
    }

    public void setCourseCodeNo(String courseCodeNo) {
        this.courseCodeNo = courseCodeNo == null ? null : courseCodeNo.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getSysCollegeNodeCode() {
        return sysCollegeNodeCode;
    }

    public void setSysCollegeNodeCode(String sysCollegeNodeCode) {
        this.sysCollegeNodeCode = sysCollegeNodeCode == null ? null : sysCollegeNodeCode.trim();
    }

    public Short getSysCollegeNodeType() {
        return sysCollegeNodeType;
    }

    public void setSysCollegeNodeType(Short sysCollegeNodeType) {
        this.sysCollegeNodeType = sysCollegeNodeType;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant == null ? null : assistant.trim();
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}