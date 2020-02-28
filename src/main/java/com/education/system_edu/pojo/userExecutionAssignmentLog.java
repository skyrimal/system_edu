package com.education.system_edu.pojo;

import java.util.Date;

public class userExecutionAssignmentLog {
    private String code;

    private String userCode;

    private Short userType;

    private Short actionType;

    private String assignmentCode;

    private Short assignmentType;

    private Short resultType;

    private String resultTreeCode;

    private String remarks;

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getActionType() {
        return actionType;
    }

    public void setActionType(Short actionType) {
        this.actionType = actionType;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode == null ? null : assignmentCode.trim();
    }

    public Short getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(Short assignmentType) {
        this.assignmentType = assignmentType;
    }

    public Short getResultType() {
        return resultType;
    }

    public void setResultType(Short resultType) {
        this.resultType = resultType;
    }

    public String getResultTreeCode() {
        return resultTreeCode;
    }

    public void setResultTreeCode(String resultTreeCode) {
        this.resultTreeCode = resultTreeCode == null ? null : resultTreeCode.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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