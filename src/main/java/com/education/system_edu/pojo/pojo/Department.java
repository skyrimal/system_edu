package com.education.system_edu.pojo.pojo;


import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysNode;

import java.util.Date;
import java.util.List;

public class Department {
    private List<SysNode> sysNodes;
    private SysDataTree sysDataTree;
    private String code;
    private String departmentName;
    private String managerName;
    private String managerCode;
    private String remarks;
    private Date establishTime;

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public void setAllAttribute(List<SysNode> sysNodes, SysDataTree sysDataTree) {
        this.sysNodes = sysNodes;
        this.sysDataTree = sysDataTree;
        this.code = sysDataTree.getCode();
        this.departmentName = sysDataTree.getName();
        this.remarks = sysDataTree.getRemarks();
        this.establishTime = sysDataTree.getCreateDate();
        for (SysNode sysNode : sysNodes) {
            if(sysNode.getName().equals("manage_name")){
                this.managerName =sysNode.getRemarks();
            }
            if(sysNode.getName().equals("manage_login_code")){
                this.managerCode =sysNode.getRemarks();
            }
        }

    }

    public Department() {
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<SysNode> getSysNodes() {
        return sysNodes;
    }

    public void setSysNodes(List<SysNode> sysNodes) {
        this.sysNodes = sysNodes;
    }

    public SysDataTree getSysDataTree() {
        return sysDataTree;
    }

    public void setSysDataTree(SysDataTree sysDataTree) {
        this.sysDataTree = sysDataTree;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }
}
