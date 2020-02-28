package com.education.system_edu.pojo;

import java.util.Date;

public class SysModelClassAssignment {
    private String code;

    private String classCode;

    private String title;

    private Short type;

    private String context;

    private String sysCollegeNodeCode;

    private Short sysCollegeNodeType;

    private Date starttime;

    private Date endtime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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