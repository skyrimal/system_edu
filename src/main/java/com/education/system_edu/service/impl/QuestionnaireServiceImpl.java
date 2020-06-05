package com.education.system_edu.service.impl;

import java.util.*;

import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.dbpojo.UserInSchoolMSG;
import com.education.system_edu.pojo.insert.QuestionnaireInsetToSend;
import com.education.system_edu.pojo.insert.SearchQuestionnaireInsert;
import com.education.system_edu.pojo.output.*;
import com.education.system_edu.service.QuestionnaireService;
import com.education.system_edu.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Resource
    UserMapper userMapper;
    @Resource
    SysModelQuestionnaireRepositoryMapper questionnaireRepositoryMapper;

    @Resource
    SysModelQuestionnaireQuestionRepositoryMapper questionRepositoryMapper;

    @Resource
    SysModelQuestionnaireQuestionOptionRepositoryMapper optionRepositoryMapper;

    @Resource
    SendQuestionnaireMapper sendQuestionnaireMapper;

    @Resource
    ConnectQuestionnaireAndQuestionMapper connectQuestionnaireAndQuestionMapper;
    @Resource
    ConnectQuestionnaireQuestionAndOptionMapper connectQuestionnaireQuestionAndOptionMapper;
    @Resource
    StudentSubmitQuestionnaireMapper studentSubmitQuestionnaireMapper;
    @Resource
    StudentSubmitQuestionnaireTextAnswerMapper studentSubmitQuestionnaireTextAnswerMapper;

    @Override
    public Integer addAQuestionnaire(String msg, String qAndAs, String loginCode) {
        JsonUtils jsonUtils = new JsonUtils();
        QuestionnaireFactory questionnaireFactory = new QuestionnaireFactory();
        questionnaireFactory.init(qAndAs, msg, loginCode);
        SysModelQuestionnaireRepository questionnaire =
                questionnaireFactory.releaseQuestionnaireWithCreateAndUpdateMsg();
        questionnaireRepositoryMapper.insert(questionnaire);

        List<SysModelQuestionnaireQuestionRepository> questions = questionnaireFactory.releaseQuestion();
        List<String> questionCodes = new ArrayList<>();
        int i = 0;
        for (SysModelQuestionnaireQuestionRepository repository :
                questions) {
            questionCodes.add(repository.getCode());
            ConnectQuestionnaireAndQuestion connectQuestionnaireAndQuestion = new ConnectQuestionnaireAndQuestion();
            connectQuestionnaireAndQuestion.setCode(UU3D.uu3d());
            connectQuestionnaireAndQuestion.setQuestionnaireCode(questionnaire.getCode());
            connectQuestionnaireAndQuestion.setQuestionCode(repository.getCode());
            connectQuestionnaireAndQuestion.setQuestionNo(i++);
            connectQuestionnaireAndQuestion.setScore(repository.getScore());
            connectQuestionnaireAndQuestion.setType(repository.getType());

            questionRepositoryMapper.insertSelective(repository);
            connectQuestionnaireAndQuestionMapper.insertSelective(connectQuestionnaireAndQuestion);
        }


        List<List<SysModelQuestionnaireQuestionOptionRepository>> optionses = questionnaireFactory.releaseOptionses();
        int j = 0;
        for (List<SysModelQuestionnaireQuestionOptionRepository> list :
                optionses) {
            String questionCode = questionCodes.get(j);
            int no = 0;
            for (SysModelQuestionnaireQuestionOptionRepository repository :
                    list) {
                ConnectQuestionnaireQuestionAndOption connectQuestionnaireQuestionAndOption = new ConnectQuestionnaireQuestionAndOption();
                connectQuestionnaireQuestionAndOption.setCode(UU3D.uu3d());
                connectQuestionnaireQuestionAndOption.setQuestionCode(questionCode);
                connectQuestionnaireQuestionAndOption.setOptionCode(repository.getCode());
                connectQuestionnaireQuestionAndOption.setQuestionnaireCode(questionnaire.getCode());
                connectQuestionnaireQuestionAndOption.setAnswerNo(no++);
                connectQuestionnaireQuestionAndOption.setScore(repository.getScore());
                connectQuestionnaireQuestionAndOption.setType(repository.getType());
                connectQuestionnaireQuestionAndOption.setComment(repository.getComment());
                optionRepositoryMapper.insert(repository);
                connectQuestionnaireQuestionAndOptionMapper.insert(connectQuestionnaireQuestionAndOption);
            }
            j++;
        }

        return null;
    }

    @Override
    public List<QuestionnaireOutput> searchCourseBySearchQuestionnaireInsert(SearchQuestionnaireInsert searchQuestionnaireInsert) {
        List<QuestionnaireOutput> result = questionnaireRepositoryMapper.selectBySearchQuestionnaireInsert(searchQuestionnaireInsert);
        List<QuestionnaireOutput> _result = new ArrayList<>();
        String type = "";
        for (QuestionnaireOutput output : result) {
            type = StringUtils.outPre(output.getTitle(), "#type#");
            output.setType(type);
            output.setTitle(StringUtils.outLast(output.getTitle(), "#type#"));
            _result.add(output);
        }
        return _result;
    }

    @Override
    public String sendQuestionnaire(QuestionnaireInsetToSend questionnaireInsetToSend, String loginCode) {
        String major = questionnaireInsetToSend.getMajor();
        String department = questionnaireInsetToSend.getDepartmentCode();
        String fac = questionnaireInsetToSend.getFacultyId();
        String grade = questionnaireInsetToSend.getGrade();
        String classCode = questionnaireInsetToSend.getClassNo();
        int flag = 0;
        //初始化
        ClassUtils<SendQuestionnaire> sendQuestionnaireClassUtils = new ClassUtils<>();
        Date date = new Date();
        SendQuestionnaire sendQuestionnaire = new SendQuestionnaire();
        sendQuestionnaire.setCode(UU3D.uu3d());
        sendQuestionnaire.setQuestionnaireCode(questionnaireInsetToSend.getqCode());
        sendQuestionnaire.setStarttime(date);
        sendQuestionnaire.setEndtime(new Date(date.getTime() + 24* 60 * 60 * 1000));
        sendQuestionnaire = sendQuestionnaireClassUtils.addUserCreateUseInfo(sendQuestionnaire, loginCode);
        sendQuestionnaire.setType("");
        sendQuestionnaire.setRemarks("");
        sendQuestionnaire.setClassCode("");

        if (!EmptyUtil.stringIsEmpty(grade)) {
            sendQuestionnaire.setGrade(questionnaireInsetToSend.getGrade());
        }
        //1.判断是否为全学院的问卷
        if (!EmptyUtil.stringIsEmpty(fac) && EmptyUtil.stringIsEmpty(department)) {
            //1-1是全学院的问卷
            //1-1.1 type为1，存入数据库
            sendQuestionnaire.setType("1");
            sendQuestionnaire.setRemarks(fac);
            flag += sendQuestionnaireMapper.insert(sendQuestionnaire);
        } else {
            //1-2.不是全学院的问卷
            if (!EmptyUtil.stringIsEmpty(department) && EmptyUtil.stringIsEmpty(major)) {
                //1-2.1是否为部门级问卷
                //1-2.1-1是部门级问卷
                //1-2.1-1.1 type值为2，存入数据库
                sendQuestionnaire.setType("2");
                sendQuestionnaire.setRemarks(department);
                flag += sendQuestionnaireMapper.insert(sendQuestionnaire);
            } else {
                //1-2.1-2不是部门级问卷
                if (!EmptyUtil.stringIsEmpty(major) && EmptyUtil.stringIsEmpty(classCode)) {
                    //1-2.1-2.1是否为专业级问卷
                    //1-2.1-2.1-1是专业级问卷
                    //1-2.1-2.1-1.1 type值为3，存入数据库
                    sendQuestionnaire.setType("3");
                    sendQuestionnaire.setRemarks(major);
                    flag += sendQuestionnaireMapper.insert(sendQuestionnaire);
                } else {
                    if (!EmptyUtil.stringIsEmpty(classCode)) {
                        //1-2.1-2.1-2不是专业级问卷
                        //1-2.1-2.1-2-1 是班级问卷 type为4 加入classcode存入数据库
                        sendQuestionnaire.setType("4");
                        sendQuestionnaire.setRemarks(major);
                        sendQuestionnaire.setClassCode(classCode);
                        flag += sendQuestionnaireMapper.insert(sendQuestionnaire);
                    } else {
                        //2 全部不是，则为年级问卷 type为5 存入数据库
                        sendQuestionnaire.setType("5");
                        flag += sendQuestionnaireMapper.insert(sendQuestionnaire);
                    }
                }
            }
        }
        if (flag > 0) {
            return "success";
        }
        return "fail";
    }

    @Override
    public QuestionnaireToAnswerOutput getAQuestionnaireByQuestionnaireCode(String loginCode, String sendCode,String questionnaireCode) {
        //1.获取问卷
        //2.获取问题
        //2.2获取问题匹配答案
        //逻辑在mapper用sql实现
        QuestionnaireToAnswerOutput questionnaireToAnswerOutput = new QuestionnaireToAnswerOutput();
        if(sendQuestionnaireMapper.countNotEnd(sendCode)>0){
            if(studentSubmitQuestionnaireMapper.countSubmit(loginCode,sendCode)==0){
                questionnaireToAnswerOutput = questionnaireRepositoryMapper.selectQuestionnaireToAnswerOutput(questionnaireCode);
            }
        }
        return questionnaireToAnswerOutput;
    }


    @Override
    public QuestionnaireToAnswerOutput getAQuestionnaireByQuestionnaireCode(String questionnaireCode) {
        //1.获取问卷
        //2.获取问题
        //2.2获取问题匹配答案
        //逻辑在mapper用sql实现
        QuestionnaireToAnswerOutput questionnaireToAnswerOutput = questionnaireRepositoryMapper.selectQuestionnaireToAnswerOutput(questionnaireCode);
        return questionnaireToAnswerOutput;
    }
    @Override
    public List<UserToSubmitQuestionnairePageOutput> getUserToSubmitQuestionnaireMSG(String loginCode) {
        List<UserToSubmitQuestionnairePageOutput> userToSubmitQuestionnairePageOutputs = new ArrayList<>();
        //1.获取用户的班级，专业，部门，学院，年级信息
        List<UserInSchoolMSG> userInSchoolMSGs = userMapper.selectSchoolMSGByLoginCode(loginCode);
        List<String> clss = userMapper.selectClassByLoginCode(loginCode);
        //2.获取用户所在班级，专业，部门，学院，年级发布的问卷
        UserInSchoolMSG userInSchoolMSG = userInSchoolMSGs.get(0);
        String pCode = "";
        //2-1班级不为空时直接进行班级查询
        if (!EmptyUtil.stringIsEmpty(userInSchoolMSG.getCls())) {
            userToSubmitQuestionnairePageOutputs.addAll(questionRepositoryMapper
                                                                .selectUserToSubmitQuestionnairePageOutputByClassCode(userInSchoolMSG.getCls()));
        }
        //2-2班级为空时，判断专业是否为空
        if (!EmptyUtil.stringIsEmpty(userInSchoolMSG.getMaj())) {
            userToSubmitQuestionnairePageOutputs.addAll(questionRepositoryMapper
                                                                .selectUserToSubmitQuestionnairePageOutputByUserInSchoolMSG(userInSchoolMSG.getMaj()));
        }
        //2-2-1专业为空时，判断部门是否为空
        if (!EmptyUtil.stringIsEmpty(userInSchoolMSG.getDep())) {
            userToSubmitQuestionnairePageOutputs.addAll(questionRepositoryMapper
                                                                .selectUserToSubmitQuestionnairePageOutputByUserInSchoolMSG(userInSchoolMSG.getDep()));
        }
        //2-2-1-1部门为空时，判断学院是否为空
        if (!EmptyUtil.stringIsEmpty(userInSchoolMSG.getFac())) {
            userToSubmitQuestionnairePageOutputs.addAll(questionRepositoryMapper
                                                                .selectUserToSubmitQuestionnairePageOutputByUserInSchoolMSG(userInSchoolMSG.getFac()));
        }
        //2-2-1-1-1学院为空时判断年级是否为空
        if (!EmptyUtil.stringIsEmpty(userInSchoolMSG.getGrade())) {
            userToSubmitQuestionnairePageOutputs.addAll(questionRepositoryMapper
                                                                .selectUserToSubmitQuestionnairePageOutputByGrade(userInSchoolMSG.getGrade()));
        }
        for (String str : clss) {
            userToSubmitQuestionnairePageOutputs.addAll(questionRepositoryMapper
                                                                .selectUserToSubmitQuestionnairePageOutputByClassCode(str));
        }
        Map<String,UserToSubmitQuestionnairePageOutput> qq = new HashMap<>();
        for( UserToSubmitQuestionnairePageOutput userToSubmitQuestionnairePageOutput:userToSubmitQuestionnairePageOutputs){
            qq.put(userToSubmitQuestionnairePageOutput.getCode(),userToSubmitQuestionnairePageOutput);
        }
        List<UserToSubmitQuestionnairePageOutput> newUserToSubmitQuestionnairePageOutputs1 = new ArrayList<>();
        for (String key : qq.keySet()) {
            System.out.println("key=" + key + ", value=" + qq.get(key));
            newUserToSubmitQuestionnairePageOutputs1.add(qq.get(key));
        }
        return newUserToSubmitQuestionnairePageOutputs1;
    }

    @Override
    public String submitQueationnaire(String loginCode, Map<String, Object> map) {
        int flag=0;
        ClassUtils<StudentSubmitQuestionnaire> studentSubmitQuestionnaireClassUtils = new ClassUtils<>();
        //1.创建学生提交问卷对象并存入数据库
        StudentSubmitQuestionnaire studentSubmitQuestionnaire = new StudentSubmitQuestionnaire();
        studentSubmitQuestionnaire.setCode(UU3D.uu3d());
        studentSubmitQuestionnaire.setStudentCode(loginCode);
        studentSubmitQuestionnaire.setQuestionnaireCode((String) map.get("questionnaireCode"));
        studentSubmitQuestionnaire.setSysDataNodeCode((String) map.get("assignmentCode"));
        studentSubmitQuestionnaire.setSysDataNodeType((short) 0);
        studentSubmitQuestionnaire.setIsSubmit("1");
        studentSubmitQuestionnaire = studentSubmitQuestionnaireClassUtils.addUserCreateUseInfo(studentSubmitQuestionnaire, loginCode);
        flag+=studentSubmitQuestionnaireMapper.insert(studentSubmitQuestionnaire);

        //2.根据学生提交问卷对象创建学生提交的问卷的问题与答案对象
        ClassUtils<StudentSubmitQuestionnaireTextAnswer> studentSubmitQuestionnaireTextAnswerClassUtils = new ClassUtils<>();
        StudentSubmitQuestionnaireTextAnswer studentSubmitQuestionnaireTextAnswer = new StudentSubmitQuestionnaireTextAnswer();

        studentSubmitQuestionnaireTextAnswer.setStudentCode(loginCode);
        studentSubmitQuestionnaireTextAnswer.setQuestionnaireCode(studentSubmitQuestionnaire.getCode());
        studentSubmitQuestionnaireTextAnswer = studentSubmitQuestionnaireTextAnswerClassUtils.addUserCreateUseInfo(studentSubmitQuestionnaireTextAnswer, loginCode);


        int i = 0;
        //2.1遍历map
        for (String key : map.keySet()) {
            if(!key.equals("questionnaireCode")&&!key.equals("assignmentCode")&&!key.equals("")){
                studentSubmitQuestionnaireTextAnswer.setCode(UU3D.uu3d());
                //2.1.1判断key
                studentSubmitQuestionnaireTextAnswer.setQuestionCode(key);
                studentSubmitQuestionnaireTextAnswer.setQuestionNo(i++);
                studentSubmitQuestionnaireTextAnswer.setContext((String) map.get(key));
                flag+=studentSubmitQuestionnaireTextAnswerMapper.insert(studentSubmitQuestionnaireTextAnswer);
            }
        }
        if (flag>0){
            return "successful";
        }else{
            return "fail";
        }
    }

    @Override
    public List<QuestionnaireHistoryOutput> getQuestionnaireHistory(String loginCode) {

        return studentSubmitQuestionnaireMapper.selectStudentSubmitHistory(loginCode);
    }

    @Override
    public List<QuestionnaireOutput> getQuestionReturn() {
        List<QuestionnaireOutput> questionnaireOutputs = new ArrayList<>();
        List<SendQuestionnaire> sendQuestionnaires= sendQuestionnaireMapper.selectByExample(new SendQuestionnaireExample());
        for(SendQuestionnaire sendQuestionnaire:sendQuestionnaires){
            SysModelQuestionnaireRepository sysModelQuestionnaireRepository = questionnaireRepositoryMapper.selectByPrimaryKey(sendQuestionnaire.getQuestionnaireCode());
            QuestionnaireOutput output = new QuestionnaireOutput();
            output.setCode(sendQuestionnaire.getCode());
            output.setTitle(sysModelQuestionnaireRepository.getTitle());
            questionnaireOutputs.add(output);
        }
        return questionnaireOutputs;
    }

    @Override
    public List<AnswerReturnOutput> getAnswerReturn(String questionnaireCode) {
        List<AnswerReturnOutput> answerReturnOutputs = new ArrayList<>();
        SysModelQuestionnaireRepository sysModelQuestionnaireRepository = questionnaireRepositoryMapper.selectByPrimaryKey(sendQuestionnaireMapper.
                selectByPrimaryKey(questionnaireCode).getQuestionnaireCode());
        ConnectQuestionnaireAndQuestionExample cqe = new ConnectQuestionnaireAndQuestionExample();
        cqe.createCriteria().andQuestionnaireCodeEqualTo(sysModelQuestionnaireRepository.getCode());
        List<ConnectQuestionnaireAndQuestion> cqs = connectQuestionnaireAndQuestionMapper.selectByExample(cqe);


        for(ConnectQuestionnaireAndQuestion cq:cqs){
            AnswerReturnOutput answerReturnOutput = new AnswerReturnOutput();
            SysModelQuestionnaireQuestionRepository q = questionRepositoryMapper.selectByPrimaryKey(cq.getQuestionCode());
            answerReturnOutput.setQuestion(q.getTitle());
            answerReturnOutput.setCode(q.getCode());

            ConnectQuestionnaireQuestionAndOptionExample cqae = new ConnectQuestionnaireQuestionAndOptionExample();
            cqae.createCriteria().andQuestionCodeEqualTo(q.getCode());

            List<ConnectQuestionnaireQuestionAndOption> cqas = connectQuestionnaireQuestionAndOptionMapper.selectByExample(cqae);
            int i = 0;
            for(ConnectQuestionnaireQuestionAndOption caq :cqas){


                StudentSubmitQuestionnaireTextAnswerExample ssae = new StudentSubmitQuestionnaireTextAnswerExample();
                ssae.createCriteria().andContextLike(caq.getOptionCode());
                List<StudentSubmitQuestionnaireTextAnswer> ssuba = studentSubmitQuestionnaireTextAnswerMapper.selectByExample(ssae);
                int num = ssuba.size();
                SysModelQuestionnaireQuestionOptionRepository answer = optionRepositoryMapper.selectByPrimaryKey(caq.getOptionCode());
                answerReturnOutput.setTitle(answer.getComment());
                AnswerReturnOutput _answerReturnOutput = null;
                if (num!=0){
                     _answerReturnOutput = new AnswerReturnOutput();
                    if (i==0){
                        _answerReturnOutput.setQuestion(answerReturnOutput.getQuestion());
                    }
                    _answerReturnOutput.setCode(answerReturnOutput.getCode());
                    _answerReturnOutput.setTitle(answerReturnOutput.getTitle().split(",.,")[0]);
                    _answerReturnOutput.setNum(num+"");
                    i++;
                }else{
                     _answerReturnOutput = new AnswerReturnOutput();
                     if (i==0){
                         _answerReturnOutput.setQuestion(answerReturnOutput.getQuestion());
                     }
                    _answerReturnOutput.setCode(answerReturnOutput.getCode());
                    _answerReturnOutput.setTitle(answerReturnOutput.getTitle().split(",.,")[0]);
                    _answerReturnOutput.setNum(0+"");
                    i++;
                }
                answerReturnOutputs.add(_answerReturnOutput);
            }
        }
        return answerReturnOutputs;
    }

    @Override
    public Integer countCourseByCourseSearchInsert(SearchQuestionnaireInsert searchQuestionnaireInsert, Integer pageSize) {
        int i = questionnaireRepositoryMapper.countBySearchQuestionnaireInsert(searchQuestionnaireInsert);
        return PageUtils.coutPageSize(i, pageSize);
    }
}
