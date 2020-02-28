package com.education.system_edu.pojo;

import java.util.Date;

public class StudentSubmitQuestionnaire {
    private String code;

    private String studentCode;

    private String questionnaireCode;

    private String sysDataNodeCode;

    private Short sysDataNodeType;

    private String isSubmit;

    private Integer submitTime;

    private String subOptions;

    private String subTextAnwer;

    private String subFileName;

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

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
    }

    public String getQuestionnaireCode() {
        return questionnaireCode;
    }

    public void setQuestionnaireCode(String questionnaireCode) {
        this.questionnaireCode = questionnaireCode == null ? null : questionnaireCode.trim();
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

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit == null ? null : isSubmit.trim();
    }

    public Integer getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Integer submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubOptions() {
        return subOptions;
    }

    public void setSubOptions(String subOptions) {
        this.subOptions = subOptions == null ? null : subOptions.trim();
    }

    public String getSubTextAnwer() {
        return subTextAnwer;
    }

    public void setSubTextAnwer(String subTextAnwer) {
        this.subTextAnwer = subTextAnwer == null ? null : subTextAnwer.trim();
    }

    public String getSubFileName() {
        return subFileName;
    }

    public void setSubFileName(String subFileName) {
        this.subFileName = subFileName == null ? null : subFileName.trim();
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