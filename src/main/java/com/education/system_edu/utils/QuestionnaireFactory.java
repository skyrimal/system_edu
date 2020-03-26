package com.education.system_edu.utils;



import com.education.system_edu.pojo.SysModelQuestionnaireQuestionOptionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireRepository;
import com.education.system_edu.pojo.insert.QuestionnaireInsert;
import com.education.system_edu.pojo.insert.QuestionnaireMsgInsert;
import com.education.system_edu.utils.value.QuestionnaireValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月24日 17:15
 */
@Slf4j
public class QuestionnaireFactory {
    //传入数据
    private String qAndAs;
    private String msg;
    private String loginCode;
    /********一次加工***********************/
    private QuestionnaireMsgInsert questionnaireMsgInsert;

    private List<QuestionnaireInsert> questionAndAnswerses;

    /********二次加工***********************/
    private SysModelQuestionnaireRepository questionnaire;

    private List<SysModelQuestionnaireQuestionRepository> questions;

    /********三次加工***********************/
    private List<List<SysModelQuestionnaireQuestionOptionRepository>> optionses;

    public void init(String qAndAs, String msg,String loginCode) {
        setter(qAndAs, msg,loginCode);
        //进行第一次数据加工
        addQuestionnaireMsg();
        addQuestionAndAnswer();
        //进行第二次数据加工
        madeQuestionnaire();
        madeQuestions();
        //进行第三次数据加工
        madeAnswerses();
    }


    private void setter(String qAndAs, String msg,String loginCode) {
        setqAndAs(qAndAs);
        setMsg(msg);
        setLoginCode(loginCode);
    }

    /**
     * 加工一次数据
     * 将msg解析为QuestionnaireMsgInsert
     */
    private void addQuestionnaireMsg() {
        JsonUtils<QuestionnaireMsgInsert> jsonUtils = new JsonUtils<>();
        setQuestionnaireMsgInsert(jsonStringToObject(msg));
    }

    /**
     * 加工一次数据
     * 将qAndAs解析为List<QuestionnaireInsert>
     */
    private void addQuestionAndAnswer() {
        JsonUtils<QuestionnaireInsert> jsonUtils = new JsonUtils<>();
        setQuestionAndAnswerses(jsonStringToListObject(qAndAs));
    }

    /**
     * 二次加工
     * 结合questionnaireMsgInsert与questionAndAnswers生成questionnaire
     */
    private void madeQuestionnaire() {
        questionnaire = new SysModelQuestionnaireRepository();
        questionnaire.setCode(UU3D.uu3d());
        questionnaire.setTitle(questionnaireMsgInsert.getTitleName());
        questionnaire.setType(QuestionnaireValue.QUESTIONNAIRE);
        questionnaire.setSubmitTime(60);
        questionnaire.setSysDataNodeCode("");
        questionnaire.setSysDataNodeType((short) 0);
        questionnaire.setQuestionNum(questionAndAnswerses.size());
        questionnaire.setTotalScore(0);
        questionnaire.setRemarks(questionnaireMsgInsert.getAstractWord());
    }
    /**
     * 二次加工
     * 结合questionAndAnswerses生成questions
     */
    private void madeQuestions() {
        questions = new ArrayList<>();
        SysModelQuestionnaireQuestionRepository question;
        for (QuestionnaireInsert questionAndAnswers:
        questionAndAnswerses) {
            question = new SysModelQuestionnaireQuestionRepository();
            question.setCode(UU3D.uu3d());
            question.setOptionNum(questionAndAnswers.getAnswers().size());
            question.setQuestionnaireType(QuestionnaireValue.QUESTIONNAIRE);
            question.setScore(0);
            question.setLevel(0);
            question.setGroup1(0);
            question.setGroup2(0);
            question.setType(QuestionnaireValue.getType(
                    StringUtils.outLast(questionAndAnswers.getQuestion(),",.,")));
            question.setTitle(
                    StringUtils.outPre(questionAndAnswers.getQuestion(),",.,"));
            question.setComment("");
            question.setRemarks(questionAndAnswers.getQuestion());
            ClassUtils<SysModelQuestionnaireQuestionRepository> classUtils = new ClassUtils<>();
            questions.add(classUtils.addUserCreateUseInfo(question,loginCode));
        }
    }

    /**
     * 三次加工
     * questionAndAnswerses结合questions生成optionses
     */
    private void madeAnswerses() {
        optionses = new ArrayList<> ();
        List<SysModelQuestionnaireQuestionOptionRepository> options;
        int qFlag = 0;
        for (QuestionnaireInsert questionAndAnswers:
                questionAndAnswerses) {
            options = new ArrayList<> ();
            //自动生成分数，后期修改
            int aFlag = 0;
            for (String answer:questionAndAnswers.getAnswers()) {
                SysModelQuestionnaireQuestionOptionRepository option;
                option = new SysModelQuestionnaireQuestionOptionRepository();
                option.setCode(UU3D.uu3d());
                option.setQuestionCode(questions.get(qFlag).getCode());
                option.setScore(aFlag);
                option.setType(QuestionnaireValue.QUESTIONNAIRE);
                option.setIsRight("");
                option.setComment(answer);
                ClassUtils<SysModelQuestionnaireQuestionOptionRepository> classUtils = new ClassUtils<>();
                options.add(classUtils.addUserCreateUseInfo(option,loginCode));
                aFlag++;
            }
            qFlag++;
            optionses.add(options);
        }
    }
    /**
     * 将工厂中的产品输出
     *
     * @return
     */
    public SysModelQuestionnaireRepository releaseQuestionnaireWithCreateAndUpdateMsg() {
        ClassUtils<SysModelQuestionnaireRepository> classUtils = new ClassUtils<>();
        return classUtils.addUserCreateUseInfo(questionnaire, loginCode);
    }

    public List<SysModelQuestionnaireQuestionRepository> releaseQuestion() {
        return questions;
    }

    public List<List<SysModelQuestionnaireQuestionOptionRepository>> releaseOptionses(){
        return optionses;
    }


    public String getqAndAs() {
        return qAndAs;
    }

    public void setqAndAs(String qAndAs) {
        this.qAndAs = qAndAs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public QuestionnaireMsgInsert getQuestionnaireMsgInsert() {
        return questionnaireMsgInsert;
    }

    public void setQuestionnaireMsgInsert(QuestionnaireMsgInsert questionnaireMsgInsert) {
        this.questionnaireMsgInsert = questionnaireMsgInsert;
    }

    public List<QuestionnaireInsert> getQuestionAndAnswerses() {
        return questionAndAnswerses;
    }

    public void setQuestionAndAnswerses(List<QuestionnaireInsert> questionAndAnswerses) {
        this.questionAndAnswerses = questionAndAnswerses;
    }

    public SysModelQuestionnaireRepository getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(SysModelQuestionnaireRepository questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<SysModelQuestionnaireQuestionRepository> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SysModelQuestionnaireQuestionRepository> questions) {
        this.questions = questions;
    }

    public List<List<SysModelQuestionnaireQuestionOptionRepository>> getOptionses() {
        return optionses;
    }

    public void setOptionses(List<List<SysModelQuestionnaireQuestionOptionRepository>> optionses) {
        this.optionses = optionses;
    }


    public QuestionnaireMsgInsert jsonStringToObject(String str) {
        ObjectMapper om = new ObjectMapper();
        QuestionnaireMsgInsert result =null;
        try {
            result =  om.readValue(str, QuestionnaireMsgInsert.class);
        } catch (JsonProcessingException e) {
            log.info("jackson在String转泛型时出错了");
        }
        return result;
    }

    public List<QuestionnaireInsert> jsonStringToListObject(String qAndAs) {
        ObjectMapper om = new ObjectMapper();
        List<QuestionnaireInsert> list = new ArrayList<>();
        try {
            list = om.readValue(qAndAs, new TypeReference<List<QuestionnaireInsert>>() {
            });
        } catch (JsonProcessingException e) {
            log.info("jackson在String转泛型时出错了");
        }
        return list;
    }
}
