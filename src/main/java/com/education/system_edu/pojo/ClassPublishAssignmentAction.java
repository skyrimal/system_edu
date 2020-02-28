package com.education.system_edu.pojo;

import java.util.Date;

public class ClassPublishAssignmentAction {
    private String code;

    private String classCode;

    private Short classType;

    private String assignmentCode;

    private String assignmentTitle;

    private String sysDataNodeCode;

    private Short sysDataNodeType;

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

    public Short getClassType() {
        return classType;
    }

    public void setClassType(Short classType) {
        this.classType = classType;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode == null ? null : assignmentCode.trim();
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle == null ? null : assignmentTitle.trim();
    }

    public String getSysDataNodeCode() {
        return sysDataNodeCode;
    }

    public void setSysDataNodeCode(String sysDataNodeCode) {
        this.sysDataNodeCode = sysDataNodeCode == null ? null : sysDataNodeCode.trim();
    }

    public Short getSysDataNodeType() {
        return sysDataNodeType;
    }

    public void setSysDataNodeType(Short sysDataNodeType) {
        this.sysDataNodeType = sysDataNodeType;
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