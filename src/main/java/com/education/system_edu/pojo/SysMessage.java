package com.education.system_edu.pojo;

import java.util.Date;

public class SysMessage {
    private String code;

    private String sendCode;

    private String sendSysRoleNodeCode;

    private String acceptCode;

    private String acceptSysRoleNodeCode;

    private String title;

    private String context;

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

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode == null ? null : sendCode.trim();
    }

    public String getSendSysRoleNodeCode() {
        return sendSysRoleNodeCode;
    }

    public void setSendSysRoleNodeCode(String sendSysRoleNodeCode) {
        this.sendSysRoleNodeCode = sendSysRoleNodeCode == null ? null : sendSysRoleNodeCode.trim();
    }

    public String getAcceptCode() {
        return acceptCode;
    }

    public void setAcceptCode(String acceptCode) {
        this.acceptCode = acceptCode == null ? null : acceptCode.trim();
    }

    public String getAcceptSysRoleNodeCode() {
        return acceptSysRoleNodeCode;
    }

    public void setAcceptSysRoleNodeCode(String acceptSysRoleNodeCode) {
        this.acceptSysRoleNodeCode = acceptSysRoleNodeCode == null ? null : acceptSysRoleNodeCode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
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