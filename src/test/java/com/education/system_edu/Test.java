package com.education.system_edu;

import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.insert.ClassAddInsert;
import com.education.system_edu.utils.ClassUtils;
import com.education.system_edu.utils.StringUtils;

public class Test {
    public static void main(String[] args) {
        //test1();
        ClassAddInsert classAddInsert = new ClassAddInsert();
        System.out.println(classAddInsert.getClassClassCode()==null);

        System.out.println(StringUtils.outLast("单选,.,【单选】",",.,"));
    }

    private static void test1(){
        ClassUtils classUtils = new ClassUtils();
        SysDataTree sysDataTree = new SysDataTree();
        sysDataTree = (SysDataTree) classUtils.addUserCreateUseInfo(sysDataTree, "41602342");
        System.out.println(sysDataTree.getCreateDate());
        System.out.println(sysDataTree.getUpdateDate());
        System.out.println(sysDataTree.getCreateBy());
        System.out.println(sysDataTree.getUpdateBy());
        sysDataTree = (SysDataTree) classUtils.addUserUpdateUseInfo(sysDataTree, "41602323");
        System.out.println(sysDataTree.getCreateDate());
        System.out.println(sysDataTree.getUpdateDate());
        System.out.println(sysDataTree.getCreateBy());
        System.out.println(sysDataTree.getUpdateBy());
        System.out.println("".length());
        System.out.println(StringUtils.lengthControl("12345", 10));
        System.out.println(StringUtils.lengthControl("12345", 10).length());

    }
}
