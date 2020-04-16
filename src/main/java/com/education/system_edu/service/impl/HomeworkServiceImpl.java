package com.education.system_edu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.insert.HomeworkModelInsert;
import com.education.system_edu.pojo.output.HomeworkOutput;
import com.education.system_edu.pojo.output.SignHistory;
import com.education.system_edu.pojo.output.StudentSubmitHomeworkMSG;
import com.education.system_edu.service.HomeworkService;
import com.education.system_edu.utils.ClassUtils;
import com.education.system_edu.utils.RandomUtils;
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
    @Resource
    AssignmentMapper assignmentMapper;
    @Resource
    StudentLSubmitTaskActionMapper studentLSubmitTaskActionMapper;

    @Resource
    CorrectAssignmenrtActionMapper correctAssignmenrtActionMapper;
    @Override
    public Integer sendHomwork(HomeworkModelInsert homeworkModel, String loginCode) {

        ClassUtils<SysModelClassAssignment> sysModelClassAssignmentClassUtils = new ClassUtils<>();
        Date date = new Date();
        SysModelClassAssignment sysModelClassAssignment = new SysModelClassAssignment();
        sysModelClassAssignment.setCode(UU3D.uu3d());
        sysModelClassAssignment.setClassCode(homeworkModel.getClassCode());
        sysModelClassAssignment.setTitle(homeworkModel.getTitle());
        sysModelClassAssignment.setType((short) 1);
        sysModelClassAssignment.setContext(homeworkModel.getTip());
        sysModelClassAssignment.setSysCollegeNodeCode("");
        sysModelClassAssignment.setSysCollegeNodeType((short) 0);
        sysModelClassAssignment.setStarttime(date);
        sysModelClassAssignment.setEndtime(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        sysModelClassAssignment = sysModelClassAssignmentClassUtils.addUserCreateUseInfo(sysModelClassAssignment, loginCode);

        Assignment assignment = new Assignment();
        assignment.setAssignmentCode(sysModelClassAssignment.getCode());
        assignment.setScore(homeworkModel.getCount());
        assignment.setIsteam(homeworkModel.getTeam() + "");
        assignment.setIsacess(homeworkModel.getAcess() + "");
        assignment.setFilename(homeworkModel.getFile());


        return sysModelClassAssignmentMapper.insert(sysModelClassAssignment) + assignmentMapper.insert(assignment);
    }

    @Override
    public String madeSign(String classCode, String loginCode) {
        ClassUtils<SysModelClassAssignment> sysModelClassAssignmentClassUtils = new ClassUtils<>();
        Date date = new Date();
        String signCode = RandomUtils.getRandomStringNumber(4);
        SysModelClassAssignment sysModelClassAssignment = new SysModelClassAssignment();
        sysModelClassAssignment.setCode(signCode+UU3D.uu3d());
        sysModelClassAssignment.setClassCode(classCode);
        sysModelClassAssignment.setTitle("签到");
        sysModelClassAssignment.setType((short) 2);
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
            return "签到码为"+signCode;
        }
    }

    @Override
    public List<HomeworkOutput> getHomework(String loginCode) {
        return assignmentMapper.selectTeacherSendHomwork(loginCode);
    }

    @Override
    public Integer studentSubmitHomwork(String context, String homeworkCode, String fileName, String loginCode) {
        ClassUtils<StudentLSubmitTaskAction> studentLSubmitTaskActionClassUtils = new ClassUtils<>();
        //1.初始化StudentLSubmitTaskAction，准备提交
        StudentLSubmitTaskAction studentLSubmitTaskAction = new StudentLSubmitTaskAction();
        studentLSubmitTaskAction.setAssignmentCode(homeworkCode);
        studentLSubmitTaskAction.setStudentCode(loginCode);
        studentLSubmitTaskAction.setSubmitDatetime(new Date());
        studentLSubmitTaskAction.setIsSubmit("1");
        studentLSubmitTaskAction.setFilename(fileName);
        studentLSubmitTaskAction.setSysDataNodeCode("");
        studentLSubmitTaskAction.setSysDataNodeType((short) 0);
        studentLSubmitTaskAction.setContext(context);

        //2.判断该名学生有没有提交过作业
        StudentLSubmitTaskActionExample submitE = new StudentLSubmitTaskActionExample();
        submitE.createCriteria().andAssignmentCodeEqualTo(homeworkCode).andStudentCodeEqualTo(loginCode);
        List<StudentLSubmitTaskAction> submits = new ArrayList<>();
        submits =studentLSubmitTaskActionMapper.selectByExample(submitE);
        if (submits.size() > 0) {
            //2.1提交过
            //2.1.1获取提交code和次数，加入初始化StudentLSubmitTaskAction中
            studentLSubmitTaskAction.setCode(submits.get(0).getCode());
            studentLSubmitTaskAction.setSubmitTime(submits.get(0).getSubmitTime()+1);
            studentLSubmitTaskAction = studentLSubmitTaskActionClassUtils.addUserUpdateUseInfo(studentLSubmitTaskAction,loginCode);
            //2.1.2update数据库中的StudentLSubmitTaskAction
            return studentLSubmitTaskActionMapper.updateByPrimaryKey(studentLSubmitTaskAction);
        }else {
            //2.2没有提交过
            //2.2.1初始化code，插入次数为1
            studentLSubmitTaskAction.setCode(UU3D.uu3d());
            studentLSubmitTaskAction.setSubmitTime(1);
            //2.2.2插入数据库
            studentLSubmitTaskAction = studentLSubmitTaskActionClassUtils.addUserCreateUseInfo(studentLSubmitTaskAction, loginCode);
            return studentLSubmitTaskActionMapper.insert(studentLSubmitTaskAction);
        }
    }

    @Override
    public List<StudentSubmitHomeworkMSG> getHomeworkInfo(String assignmentCode) {

        return sysModelClassAssignmentMapper.getStudentSubmitHomworkMsgs(assignmentCode);
    }

    @Override
    public String correctHomework(String submitCode, String finalScore, String loginCode) {
        ClassUtils<CorrectAssignmenrtAction> correctAssignmenrtActionClassUtils = new ClassUtils<>();
        CorrectAssignmenrtAction correctAssignmenrtAction = new CorrectAssignmenrtAction();
        correctAssignmenrtAction.setCode(UU3D.uu3d());
        correctAssignmenrtAction.setUserCode(loginCode);
        correctAssignmenrtAction.setType((short)1);
        StudentLSubmitTaskAction studentLSubmitTaskAction = studentLSubmitTaskActionMapper.selectByPrimaryKey(submitCode);
        correctAssignmenrtAction.setAssignmentCode(studentLSubmitTaskAction.getAssignmentCode());
        correctAssignmenrtAction.setSubmitStudentCode(studentLSubmitTaskAction.getStudentCode());
        correctAssignmenrtAction.setSubmitActionCode(studentLSubmitTaskAction.getCode());
        correctAssignmenrtAction.setSysRoleNodeCode("");
        correctAssignmenrtAction.setSysRoleNodeType("");
        correctAssignmenrtAction.setFinallyScore(Integer.valueOf(finalScore));
        correctAssignmenrtAction.setQuestionNoScore("");
        correctAssignmenrtAction.setRemarks("");
        correctAssignmenrtAction=correctAssignmenrtActionClassUtils.addUserCreateUseInfo(correctAssignmenrtAction,loginCode);
        int flag = correctAssignmenrtActionMapper.insert(correctAssignmenrtAction);
        if(flag>0){
            return "批阅成功";
        }
        return "发生错误";
    }


}
