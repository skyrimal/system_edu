package com.education.system_edu.pojo;

import java.util.Date;

public class ConnectUserAndRole {
    private String code;

    private String useCode;

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

    public String getUseCode() {
        return useCode;
    }

    public void setUseCode(String useCode) {
        this.useCode = useCode == null ? null : useCode.trim();
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