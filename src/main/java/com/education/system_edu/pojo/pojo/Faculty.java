package com.education.system_edu.pojo.pojo;


import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysNode;

import java.util.List;

public class Faculty {
    private List<SysNode> sysNodes;
    private SysDataTree sysDataTree;
    private String facultyName;
    private String presidentName;
    private String provostName;
    private String public_office;
    private String remarks;


    public void setAllAttribute(List<SysNode> sysNodes,SysDataTree sysDataTree) {
        for (SysNode sysNode : sysNodes) {
            if (sysNode.getName().equals("provost")) {
                this.provostName = sysNode.getRemarks();
            }
            if (sysNode.getName().equals("president")) {
                this.presidentName = sysNode.getRemarks();
            }
            if (sysNode.getName().equals("public_office")) {
                this.public_office = sysNode.getRemarks();
            }
        }
        this.facultyName = sysDataTree.getName();
        this.remarks = sysDataTree.getRemarks();
        this.sysDataTree = sysDataTree;
        this.sysNodes = sysNodes;
    }

    public Faculty() {
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

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getProvostName() {
        return provostName;
    }

    public void setProvostName(String provostName) {
        this.provostName = provostName;
    }

    public String getPublic_office() {
        return public_office;
    }

    public void setPublic_office(String public_office) {
        this.public_office = public_office;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
