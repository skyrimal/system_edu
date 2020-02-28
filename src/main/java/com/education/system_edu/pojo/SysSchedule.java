package com.education.system_edu.pojo;

import java.util.Date;

public class SysSchedule {
    private String code;

    private String publishAssignmentCode;

    private String sysExecutionNodeCode;

    private Short assignmentType;

    private String title;

    private Short type;

    private String sysDataNodeCode;

    private Short sysDataNodeType;

    private Short status;

    private Date startTime;

    private String interval;

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

    public String getPublishAssignmentCode() {
        return publishAssignmentCode;
    }

    public void setPublishAssignmentCode(String publishAssignmentCode) {
        this.publishAssignmentCode = publishAssignmentCode == null ? null : publishAssignmentCode.trim();
    }

    public String getSysExecutionNodeCode() {
        return sysExecutionNodeCode;
    }

    public void setSysExecutionNodeCode(String sysExecutionNodeCode) {
        this.sysExecutionNodeCode = sysExecutionNodeCode == null ? null : sysExecutionNodeCode.trim();
    }

    public Short getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(Short assignmentType) {
        this.assignmentType = assignmentType;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval == null ? null : interval.trim();
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