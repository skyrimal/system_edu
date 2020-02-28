package com.education.system_edu.pojo;

import java.util.Date;

public class SysModelCourseTableModelHasCourse {
    private String code;

    private String courseTableCode;

    private String courseName;

    private String courseCode;

    private String classCode;

    private String teacherCode;

    private Integer time;

    private String coueseTimeCode;

    private String sysCollegeNodeCode;

    private Short sysCollegeNodeType;

    private String sysRoleNodeCode;

    private Short sysRoleNodeType;

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

    public String getCourseTableCode() {
        return courseTableCode;
    }

    public void setCourseTableCode(String courseTableCode) {
        this.courseTableCode = courseTableCode == null ? null : courseTableCode.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode == null ? null : teacherCode.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getCoueseTimeCode() {
        return coueseTimeCode;
    }

    public void setCoueseTimeCode(String coueseTimeCode) {
        this.coueseTimeCode = coueseTimeCode == null ? null : coueseTimeCode.trim();
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

    public String getSysRoleNodeCode() {
        return sysRoleNodeCode;
    }

    public void setSysRoleNodeCode(String sysRoleNodeCode) {
        this.sysRoleNodeCode = sysRoleNodeCode == null ? null : sysRoleNodeCode.trim();
    }

    public Short getSysRoleNodeType() {
        return sysRoleNodeType;
    }

    public void setSysRoleNodeType(Short sysRoleNodeType) {
        this.sysRoleNodeType = sysRoleNodeType;
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