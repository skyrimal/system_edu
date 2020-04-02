package com.education.system_edu.utils;

import com.education.system_edu.pojo.SysModelClass;
import com.education.system_edu.pojo.SysModelCourse;
import com.education.system_edu.pojo.User;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月01日 11:58
 */
public class ClassesUtils {

    public static SysModelClass madeCourseClass(String grade,
                                          String loginUser_loginCode,
                                          SysModelCourse course,
                                          int i,
                                          User teacher){
        SysModelClass sysModelClass = new SysModelClass();
        sysModelClass.setCode(UU3D.uu3d());
        sysModelClass.setClassCode("c"+grade + RandomUtils.getRandomClassNo() + StringUtils.lengthControl(i + "", 3));
        sysModelClass.setType((short)1);
        sysModelClass.setTeacherType((short)1);
        sysModelClass.setTeacherCode(teacher.getCode());
        sysModelClass.setTeacherLoginCode(teacher.getLoginCode());
        sysModelClass.setCourseCodeNo(course.getCourseCode());
        sysModelClass.setCourseCode(course.getCode());
        sysModelClass.setGrade(grade);
        sysModelClass.setSysCollegeNodeCode(course.getSysNodeCode());
        //要注意
        sysModelClass.setSysCollegeNodeType(course.getSysNodeType());
        sysModelClass.setAssistant("");
        sysModelClass.setStudentNo("");
        sysModelClass.setStudentNum(0);
        ClassUtils<SysModelClass> classUtils = new ClassUtils<SysModelClass> ();
        sysModelClass = classUtils.addUserCreateUseInfo(sysModelClass,loginUser_loginCode);
        return sysModelClass;
    }
}
