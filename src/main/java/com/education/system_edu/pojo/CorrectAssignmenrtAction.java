package com.education.system_edu.pojo;

import java.util.Date;

public class CorrectAssignmenrtAction {
    private String code;

    private String userCode;

    private Short type;

    private String assignmentCode;

    private String submitStudentCode;

    private String submitActionCode;

    private String sysRoleNodeCode;

    private String sysRoleNodeType;

    private Integer finallyScore;

    private String questionNoScore;

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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode == null ? null : assignmentCode.trim();
    }

    public String getSubmitStudentCode() {
        return submitStudentCode;
    }

    public void setSubmitStudentCode(String submitStudentCode) {
        this.submitStudentCode = submitStudentCode == null ? null : submitStudentCode.trim();
    }

    public String getSubmitActionCode() {
        return submitActionCode;
    }

    public void setSubmitActionCode(String submitActionCode) {
        this.submitActionCode = submitActionCode == null ? null : submitActionCode.trim();
    }

    public String getSysRoleNodeCode() {
        return sysRoleNodeCode;
    }

    public void setSysRoleNodeCode(String sysRoleNodeCode) {
        this.sysRoleNodeCode = sysRoleNodeCode == null ? null : sysRoleNodeCode.trim();
    }

    public String getSysRoleNodeType() {
        return sysRoleNodeType;
    }

    public void setSysRoleNodeType(String sysRoleNodeType) {
        this.sysRoleNodeType = sysRoleNodeType == null ? null : sysRoleNodeType.trim();
    }

    public Integer getFinallyScore() {
        return finallyScore;
    }

    public void setFinallyScore(Integer finallyScore) {
        this.finallyScore = finallyScore;
    }

    public String getQuestionNoScore() {
        return questionNoScore;
    }

    public void setQuestionNoScore(String questionNoScore) {
        this.questionNoScore = questionNoScore == null ? null : questionNoScore.trim();
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