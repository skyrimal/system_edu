package com.education.system_edu.pojo.pojo;

import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysNode;

import java.util.List;

public class Major {
    private SysDataTree sysDataTree;
    private SysDataTree parentSysDateTree;
    private List<SysNode> sysNodes;
    private String code;
    private String majorName;
    private String teacherCode;
    private String teacherName;
    private String departmentCode;

    public Major() {
    }

    public void setAllAttribute(List<SysNode> sysNodes, SysDataTree sysDataTree) {
        for (SysNode sysNode : sysNodes) {
            if (sysNode.getName().equals("manage_name")) {
                this.teacherName = sysNode.getRemarks();
            }
            if (sysNode.getName().equals("manage_login_code")) {
                this.teacherCode = sysNode.getRemarks();
            }
        }
        this.departmentCode = sysDataTree.getParentNode();
        this.majorName = sysDataTree.getName();
        this.sysDataTree = sysDataTree;
        this.sysNodes = sysNodes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SysNode> getSysNodes() {
        return sysNodes;
    }

    public void setSysNodes(List<SysNode> sysNodes) {
        this.sysNodes = sysNodes;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public SysDataTree getSysDataTree() {
        return sysDataTree;
    }

    public void setSysDataTree(SysDataTree sysDataTree) {
        this.sysDataTree = sysDataTree;
    }

    public SysDataTree getParentSysDateTree() {
        return parentSysDateTree;
    }

    public void setParentSysDateTree(SysDataTree parentSysDateTree) {
        this.parentSysDateTree = parentSysDateTree;
    }
}
