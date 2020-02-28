package com.education.system_edu.utils;


import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysNode;
import com.education.system_edu.pojo.pojo.Department;
import com.education.system_edu.pojo.pojo.Faculty;
import com.education.system_edu.pojo.pojo.Major;

import java.util.ArrayList;
import java.util.List;


public class FacultyFactory {
    /**
     * 加工创建学院
     * @param sysDataTree
     * @param sysNodes
     * @return
     */
    public static Faculty builderFactory(SysDataTree sysDataTree, List<SysNode> sysNodes) {
        Faculty faculty = new Faculty();
        faculty.setAllAttribute(sysNodes, sysDataTree);
        return faculty;
    }
    /**
     * 加工创建部门
     * @param sysDataTree
     * @param sysNodes
     * @return
     */
    public static Department builderDepartment(SysDataTree sysDataTree, List<SysNode> sysNodes) {
        Department department = new Department();
        department.setAllAttribute(sysNodes, sysDataTree);
        return department;
    }

    /**
     * 给下拉框提取学院名
     * @param faculties
     * @return
     */
    public static List<String[]> returnFactoryNameList(List<Faculty> faculties) {
        List<String[]> factoryNames = new ArrayList<>();
        for (Faculty faculty : faculties) {
            factoryNames.add(new String[]{faculty.getSysDataTree().getCode(),faculty.getFacultyName()});
        }
        return factoryNames;
    }

    /**
     * 加工生成专业
     * @param sysDataTree
     * @param sysNodes
     * @return
     */
    public static Major sysDateTreeToMajor(SysDataTree sysDataTree,List<SysNode> sysNodes){
        Major major = new Major();
        major.setAllAttribute(sysNodes,sysDataTree);
        return major;
    }

}
