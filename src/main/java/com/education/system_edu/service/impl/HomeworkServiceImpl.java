package com.education.system_edu.service.impl;

import java.util.Date;

import com.education.system_edu.mapper.ClassPublishAssignmentActionMapper;
import com.education.system_edu.mapper.SysModelClassAssignmentMapper;
import com.education.system_edu.pojo.ClassPublishAssignmentAction;
import com.education.system_edu.pojo.SysModelClassAssignment;
import com.education.system_edu.pojo.insert.HomeworkModelInsert;
import com.education.system_edu.service.HomeworkService;
import com.education.system_edu.utils.ClassUtils;
import com.education.system_edu.utils.UU3D;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月07日 19:52
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Resource
    SysModelClassAssignmentMapper sysModelClassAssignmentMapper;

    @Override
    public Integer sendHomwork(HomeworkModelInsert homeworkModel, String loginCode) {

        ClassUtils<SysModelClassAssignment> sysModelClassAssignmentClassUtils = new ClassUtils<>();
        Date date = new Date();
        SysModelClassAssignment sysModelClassAssignment = new SysModelClassAssignment();
        sysModelClassAssignment.setCode(UU3D.uu3d());
        sysModelClassAssignment.setClassCode(homeworkModel.getClassCode());
        sysModelClassAssignment.setTitle(homeworkModel.getTeam() + ",.," + homeworkModel.getAcess() + ",.," + homeworkModel.getTitle());
        sysModelClassAssignment.setType((short) 1);
        sysModelClassAssignment.setContext(homeworkModel.getTip());
        sysModelClassAssignment.setSysCollegeNodeCode("");
        sysModelClassAssignment.setSysCollegeNodeType((short) 0);
        sysModelClassAssignment.setStarttime(date);
        sysModelClassAssignment.setEndtime(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        sysModelClassAssignment = sysModelClassAssignmentClassUtils.addUserCreateUseInfo(sysModelClassAssignment, loginCode);

        return sysModelClassAssignmentMapper.insert(sysModelClassAssignment);
    }

    @Override
    public String madeSign(String classCode, String loginCode) {
        ClassUtils<SysModelClassAssignment> sysModelClassAssignmentClassUtils = new ClassUtils<>();
        Date date = new Date();
        SysModelClassAssignment sysModelClassAssignment = new SysModelClassAssignment();
        sysModelClassAssignment.setCode(UU3D.uu3d());
        sysModelClassAssignment.setClassCode(classCode);
        sysModelClassAssignment.setTitle("签到");
        sysModelClassAssignment.setType((short) 1);
        sysModelClassAssignment.setContext("");
        sysModelClassAssignment.setSysCollegeNodeCode("");
        sysModelClassAssignment.setSysCollegeNodeType((short) 0);
        sysModelClassAssignment.setStarttime(date);
        sysModelClassAssignment.setEndtime(new Date(date.getTime() + 30 * 60 * 1000));
        sysModelClassAssignment = sysModelClassAssignmentClassUtils.addUserCreateUseInfo(sysModelClassAssignment, loginCode);
        int flag = sysModelClassAssignmentMapper.insert(sysModelClassAssignment);
        if (flag == 0) {
            return "error";
        } else {
            return "success";
        }
    }
}
