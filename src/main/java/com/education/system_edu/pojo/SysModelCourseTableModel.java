package com.education.system_edu.pojo;

import java.util.Date;

public class SysModelCourseTableModel {
    private String code;

    private String grade;

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