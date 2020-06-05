package com.education.system_edu.service.impl;


import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.dbpojo.UserInSchoolMSG;
import com.education.system_edu.pojo.output.*;
import com.education.system_edu.service.CourseClassService;
import com.education.system_edu.utils.ClassUtils;
import com.education.system_edu.utils.DateUtils;
import com.education.system_edu.utils.UU3D;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月03日 12:24
 */
@Service
public class CourseClassServiceImpl implements CourseClassService {

    @Resource
    UserMapper userMapper;

    @Resource
    GroupMapper groupMapper;

    @Resource
    AssignmentMapper assignmentMapper;

    @Resource
    StudentLSubmitTaskActionMapper studentLSubmitTaskActionMapper;

    @Resource
    CorrectAssignmenrtActionMapper correctAssignmenrtActionMapper;

    @Resource
    SysModelClassAssignmentMapper sysModelClassAssignmentMapper;

    @Resource
    StudentSignActionMapper studentSignActionMapper;

    @Override
    public Integer madeTeam(String courseClassCode, Integer memberNum, String loginCode) {
        List<User> student = userMapper.selectAllByCourseClassCode(courseClassCode);
        Integer stuNum = stuNum(student.size(), memberNum);
        ClassUtils<Group> classUtils = new ClassUtils<>();
        int flag = 0;
        for (int i = 0; i < memberNum; i++) {
            for (int j = i * stuNum; j < (i + 1) * stuNum && j < student.size(); j++) {
                Group group = new Group();
                group.setCode(UU3D.uu3d());
                group.setStudentCode(student.get(j).getCode());
                group.setClassCode(courseClassCode);
                group.setType((short) 1);
                group.setRemarks(i + "");
                group = classUtils.addUserCreateUseInfo(group, loginCode);
                flag += groupMapper.insert(group);
            }
        }
        return flag;
    }

    @Override
    public List<CourseClassTeamOutput> getCourseClassTeamByCourseClassCode(String courseClassCode) {
        return groupMapper.selectAllCourseClassGroupByCourseClassCode(courseClassCode);
    }


    /**
     * // 0- 不能提交
     * // 0-1 没有提交，不能提交
     * // 0-2 已经提交，不能提交
     * // 0-3 已经提交，已经批阅
     * // 1- 时间范围内 可以提交
     * // 1-0 未提交，可以提交
     * // 1-1 已提交，可以修改
     *
     * @param courseClassCode
     * @param loginCode
     * @return
     */
    @Override
    public HomMsgsAndTeanMsgs getHomworkMSGsAndTeamMSGs(String courseClassCode, String loginCode) throws ParseException {

        //1. 查询班级所有作业信息
        //1.1 根据courseClassCode查询当前班级所有作业
        List<HomworkMsg> homworkMsgs = assignmentMapper.selectAllClassHomeworkMGSsByCourseClassCode(courseClassCode);//查询结果
        List<HomworkMsg> _homworkMsgs = new ArrayList<>();//插入HomMsgsAndTeanMsgs结果
        for (HomworkMsg homworkMsg : homworkMsgs) {

            //1.1.1 判断作业时间，是否在时间范围内
            //1.1.1-1 在作业时间范围内，判断是否提交过作业
            StudentLSubmitTaskActionExample stuSubmitExample = new StudentLSubmitTaskActionExample();
            stuSubmitExample.createCriteria().andStudentCodeEqualTo(loginCode).andAssignmentCodeEqualTo(homworkMsg.getCode());
            //获取提交了给作业个数用来判断是否提交作业
            int isSubmit = (int) studentLSubmitTaskActionMapper.countByExample(stuSubmitExample);//等于0未提交，不等于0则已提交
            if (DateUtils.belongCalendarDateStringDate(new Date(),
                                                       homworkMsg.getStartTime(),
                                                       homworkMsg.getEndTime())) {
                //判断是否提交过作业
                if (isSubmit > 0) {
                    //1.1.1-1.1 提交过作业，作业状态1-1；
                    homworkMsg.setStatus("11");
                } else {
                    //1.1.1-1.2 未提交过作业，作业状态1-0；
                    homworkMsg.setStatus("10");
                }
                _homworkMsgs.add(homworkMsg);
            } else {
                //1.1.2-2 没在作业时间范围内
                //判断是否提交过作业
                if (isSubmit > 0) {
                    //1.1.2-2.1 提交过作业，判断作业是否批阅
                    CorrectAssignmenrtActionExample correctExample = new CorrectAssignmenrtActionExample();
                    correctExample.createCriteria().andAssignmentCodeEqualTo(homworkMsg.getCode())
                            .andSubmitStudentCodeEqualTo(loginCode);
                    List<CorrectAssignmenrtAction> correctList = correctAssignmenrtActionMapper.selectByExample(correctExample);
                    if (correctList.size() > 0) {
                        //1.1.2-2.1.1 已经批阅，作业状态0-3，finScore去批阅后得分
                        homworkMsg.setStatus("03");
                        homworkMsg.setFinScore(correctList.get(0).getFinallyScore() + "");
                    } else {
                        //1.1.2-2.1.2 未批阅，作业状态0-2
                        homworkMsg.setStatus("02");
                    }
                    _homworkMsgs.add(homworkMsg);
                } else {
                    //1.1.2-2.2 未提交过作业，作业状态0-1
                    homworkMsg.setStatus("01");
                }
                _homworkMsgs.add(homworkMsg);

            }
        }
        //2. 查询所有组队信息
        List<TeamMsg> teamMsgs = groupMapper.selectStudentTeamByStudentLoginCode(loginCode);
        //3. 将查询信息放入HomMsgsAndTeanMsgs后返回

        HomMsgsAndTeanMsgs msgs = new HomMsgsAndTeanMsgs();
        msgs.setHomworkMsgs(_homworkMsgs);
        msgs.setTeamMsgs(teamMsgs);
        return msgs;
    }

    @Override
    public String studentSign(String signCode, String loginCode) {
        ClassUtils<StudentSignAction> studentSignActionClassUtils = new ClassUtils<>();
        SysModelClassAssignment signAssignment = sysModelClassAssignmentMapper.selectTheClosedSignAssignment();
        //添加判断，用户是否已经签到
        StudentSignActionExample studentSignActionExample = new StudentSignActionExample();
        studentSignActionExample.createCriteria().andAssignmentCodeEqualTo(signAssignment.getCode()).andStudentCodeEqualTo(loginCode);
        int size = studentSignActionMapper.selectByExample(studentSignActionExample).size();
        if (size != 0) {
            return "已签到，不能重复签到";
        }
        //1.判断时间是否在签到范围内
        if (DateUtils.belongCalendar(new Date(),
                                     signAssignment.getStarttime(),
                                     signAssignment.getEndtime())) {
            //1-1在时间范围内
            //1-1.1从code中获取DB_signCode。
            String DB_signCode = signAssignment.getCode().substring(0, 4);
            //1-1.2比较DB_signCode与internet_signCode是否相等
            if (DB_signCode.equals(signCode)) {
                //1-1.2-1相等
                //1-1.2-1.1将签到记录存入数据库
                StudentSignAction studentSign = new StudentSignAction();
                studentSign.setCode(UU3D.uu3d());
                studentSign.setAssignmentCode(signAssignment.getCode());
                studentSign.setStudentCode(loginCode);
                studentSign.setClassCode(signAssignment.getClassCode());
                studentSign.setType((short) 1);
                studentSign.setSignDate(new Date());
                studentSign.setMapAddress("");
                studentSign.setIp("");
                studentSign.setStatus(1);
                studentSign.setRemark("");
                studentSign.setFilename("");
                studentSign.setSysDataCode("");
                studentSign.setSysDataType((short) 0);
                studentSign = studentSignActionClassUtils.addUserCreateUseInfo(studentSign, loginCode);
                int flag = studentSignActionMapper.insert(studentSign);
                //1-1.2-1.2返回-签到成功-
                if (flag > 0) {
                    return "签到成功";
                }
                return "未知错误";
            }
            //1-1.2-2不相等
            //1-1.2-2.1返回-签到码错误-
            return "签到码错误";
        }
        //1-2不在时间范围内
        //1-2.1返回-没有最近签到计划-
        return "最近没有签到计划";
    }

    @Override
    public List<StudentSignInfo> getStudentsSignInfo(String loginCode) {
        //1.获取最近发布的签到
        List<SignInfo> signInfos = sysModelClassAssignmentMapper.selectCloserSign(loginCode);
        //2.获取发布的签到所在班级的所有学生
        List<User> students = studentSignActionMapper.selectAllStudentSignInfo(signInfos.get(0).getClassCode());
        Map<String,User> studentMap= new HashMap<>();
        for(User user:students){
            studentMap.put(user.getCode(),user);
        }
        List<UserInSchoolMSG> userInSchoolMSGS= new  ArrayList<>();
        //3.获取对该签到进行签到的学生的行为
        StudentSignActionExample studentSignActionExample;
        Map<String,StudentSignAction> studentSignActionsMap = new HashMap<>();
        for (User stu : students) {
            userInSchoolMSGS.add(userMapper.selectOneSchoolMSGByLoginCode(stu.getLoginCode()));
            studentSignActionExample = new StudentSignActionExample();
            studentSignActionExample.createCriteria().andStudentCodeEqualTo(stu.getLoginCode()).andAssignmentCodeEqualTo(signInfos.get(0).getCode());
            List<StudentSignAction> _studentSignActions= studentSignActionMapper.selectByExample(studentSignActionExample);
            if (_studentSignActions.size()>0){
                studentSignActionsMap.put(stu.getCode(),_studentSignActions.get(0));
            }else {
                studentSignActionsMap.put(stu.getCode(),null);
            }
        }
        Map<String, UserInSchoolMSG> userInSchoolMSGMap = new HashMap<>();
        for (UserInSchoolMSG userInSchoolMSG:userInSchoolMSGS) {
            userInSchoolMSGMap.put(userInSchoolMSG.getUserLoginCode(),userInSchoolMSG);
        }
        List<StudentSignInfo> studentSignInfos = new ArrayList<>();
        int i = 0;
        for (String key : studentSignActionsMap.keySet()) {
            System.out.println("key=" + key + ", value=" + studentSignActionsMap.get(key));
            StudentSignAction  _StudentSignAction = studentSignActionsMap.get(key);
            UserInSchoolMSG _UserInSchoolMSG;
            String stuLoginCode = studentMap.get(key).getLoginCode();
            _UserInSchoolMSG= userInSchoolMSGMap.get(stuLoginCode);

            StudentSignInfo studentSignInfo = new StudentSignInfo();
            studentSignInfo.setF(_UserInSchoolMSG.getFac());
            studentSignInfo.setD(_UserInSchoolMSG.getDep());
            studentSignInfo.setM(_UserInSchoolMSG.getMaj());
            studentSignInfo.setLoginCode(_UserInSchoolMSG.getUserLoginCode());
            studentSignInfo.setName(studentMap.get(key).getUserName());
            if (_StudentSignAction!=null){
                studentSignInfo.setCode(_StudentSignAction.getCode());
                studentSignInfo.setClassCode(_StudentSignAction.getClassCode());
                studentSignInfo.setStatus(_StudentSignAction.getStatus()+"");
            }else{
                studentSignInfo.setStatus(0+"");
            }
            studentSignInfos.add(studentSignInfo);
            i++;
        }
        //4.将2与3合并整理后返回
        return studentSignInfos;
    }

    @Override
    public SignPageMsg getPageMsg(String loginCode) {
        //1.获取最近发布的签到
        List<SignInfo> signInfos = sysModelClassAssignmentMapper.selectCloserSign(loginCode);
        SignPageMsg signPageMsg = new SignPageMsg();
        signPageMsg.setCode(signInfos.get(0).getCode());
        SysModelClassAssignment sysModelClassAssignment = sysModelClassAssignmentMapper.selectByPrimaryKey(signInfos.get(0).getCode());
        signPageMsg.setType(sysModelClassAssignment.getContext());
        return signPageMsg;
    }

    @Override
    public String checkSignInfo(Map<String, String> map,String loginCode) {

        //1.获取最近发布的签到
        List<SignInfo> signInfos = sysModelClassAssignmentMapper.selectCloserSign(loginCode);
        SysModelClassAssignment sysModelClassAssignment =sysModelClassAssignmentMapper.selectByPrimaryKey(signInfos.get(0).getCode());

        if(!sysModelClassAssignment.getContext().equals("1")){
            sysModelClassAssignment.setContext("1");
            sysModelClassAssignmentMapper.updateByPrimaryKey(sysModelClassAssignment);
            StudentSignActionExample studentSignActionExample = new StudentSignActionExample();
            studentSignActionExample.createCriteria().andAssignmentCodeEqualTo(map.get("code"));
            List<StudentSignAction> studentSignActions = studentSignActionMapper.selectByExample(studentSignActionExample);
            Map<String,StudentSignAction> studentSignActionMap = new HashMap<>();
            for(StudentSignAction _studentSignAction:studentSignActions){
                studentSignActionMap.put(_studentSignAction.getStudentCode(),_studentSignAction);
            }
            List<StudentSignAction> updateStudentSignActions = new ArrayList<>();
            List<StudentSignAction> insertStudentSignActions = new ArrayList<>();
            String code = map.get("code");
            map.remove("code");
            ClassUtils<StudentSignAction> studentSignActionClassUtils = new ClassUtils<>();
            for (String key : map.keySet()) {
                StudentSignAction _StudentSignAction ;
                System.out.println("key=" + key + ", value=" + map.get(key));
                if (studentSignActionMap.get(key)!=null){
                    _StudentSignAction = studentSignActionMap.get(key);
                    _StudentSignAction.setStatus(Integer.valueOf(map.get(key)));
                    updateStudentSignActions.add(_StudentSignAction);
                    _StudentSignAction = studentSignActionClassUtils.addUserUpdateUseInfo(_StudentSignAction,loginCode);
                    studentSignActionMapper.updateByPrimaryKey(_StudentSignAction);
                    updateStudentSignActions.add(_StudentSignAction);
                }else{
                    _StudentSignAction = new StudentSignAction();
                    _StudentSignAction.setCode(UU3D.uu3d());
                    _StudentSignAction.setAssignmentCode(code);
                    _StudentSignAction.setClassCode(signInfos.get(0).getClassCode());
                    _StudentSignAction.setType((short)1);
                    _StudentSignAction.setStatus(Integer.valueOf(map.get(key)));
                    _StudentSignAction.setStudentCode(key);
                    _StudentSignAction.setSignDate(new Date());
                    _StudentSignAction= studentSignActionClassUtils.addUserCreateUseInfo(_StudentSignAction,loginCode);
                    studentSignActionMapper.insert(_StudentSignAction);
                    insertStudentSignActions.add(_StudentSignAction);
                }
            }
            return "提交成功";
        }else{
            return "签到已提交，不能重复提交";
        }

    }

    @Override
    public String getMsg(String loginCode) {

        List<SignInfo> signInfos = sysModelClassAssignmentMapper.selectCloserSign(loginCode);
        SignPageMsg signPageMsg = new SignPageMsg();
        signPageMsg.setCode(signInfos.get(0).getCode());
        SysModelClassAssignment sysModelClassAssignment = sysModelClassAssignmentMapper.selectByPrimaryKey(signInfos.get(0).getCode());
        if(!sysModelClassAssignment.getContext().equals("1")){
            return "未提交";
        }
        return "最近签到情况如下";
    }

    private Integer stuNum(int x, int y) {
        if (x % y == 0) {
            return x / y;
        }
        return x / y + 1;
    }

}
