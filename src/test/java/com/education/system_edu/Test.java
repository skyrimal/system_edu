package com.education.system_edu;

import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.utils.ClassUtils;

public class Test {
    public static void main(String[] args) {
        ClassUtils classUtils = new ClassUtils();
        SysDataTree sysDataTree = new SysDataTree();
        sysDataTree = (SysDataTree) classUtils.addUserCreateUseInfo(sysDataTree, "41602342" );
        System.out.println(sysDataTree.getCreateDate());
        System.out.println(sysDataTree.getUpdateDate());
        System.out.println(sysDataTree.getCreateBy());
        System.out.println(sysDataTree.getUpdateBy());
        sysDataTree = (SysDataTree) classUtils.addUserUpdateUseInfo(sysDataTree, "41602323" );
        System.out.println(sysDataTree.getCreateDate());
        System.out.println(sysDataTree.getUpdateDate());
        System.out.println(sysDataTree.getCreateBy());
        System.out.println(sysDataTree.getUpdateBy());

    }
}
