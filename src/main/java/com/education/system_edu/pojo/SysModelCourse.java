package com.education.system_edu.pojo;

import java.util.Date;

public class SysModelCourse {
    private String code;

    private String courseCode;

    private String name;

    private String grade;

    private Integer huors;

    private Integer credit;

    private String sysNodeCode;

    private Short sysNodeType;

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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getHuors() {
        return huors;
    }

    public void setHuors(Integer huors) {
        this.huors = huors;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getSysNodeCode() {
        return sysNodeCode;
    }

    public void setSysNodeCode(String sysNodeCode) {
        this.sysNodeCode = sysNodeCode == null ? null : sysNodeCode.trim();
    }

    public Short getSysNodeType() {
        return sysNodeType;
    }

    public void setSysNodeType(Short sysNodeType) {
        this.sysNodeType = sysNodeType;
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