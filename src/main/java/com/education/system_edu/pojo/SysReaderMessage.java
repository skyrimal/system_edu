package com.education.system_edu.pojo;

import java.util.Date;

public class SysReaderMessage {
    private String code;

    private String readerCode;

    private String messageCode;

    private Short messageStatus;

    private String sysReaderRoleNodeCode;

    private Short sysReaderRoleNodeType;

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

    public String getReaderCode() {
        return readerCode;
    }

    public void setReaderCode(String readerCode) {
        this.readerCode = readerCode == null ? null : readerCode.trim();
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode == null ? null : messageCode.trim();
    }

    public Short getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Short messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getSysReaderRoleNodeCode() {
        return sysReaderRoleNodeCode;
    }

    public void setSysReaderRoleNodeCode(String sysReaderRoleNodeCode) {
        this.sysReaderRoleNodeCode = sysReaderRoleNodeCode == null ? null : sysReaderRoleNodeCode.trim();
    }

    public Short getSysReaderRoleNodeType() {
        return sysReaderRoleNodeType;
    }

    public void setSysReaderRoleNodeType(Short sysReaderRoleNodeType) {
        this.sysReaderRoleNodeType = sysReaderRoleNodeType;
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