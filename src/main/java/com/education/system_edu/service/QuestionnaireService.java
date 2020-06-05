package com.education.system_edu.service;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.QuestionnaireInsetToSend;
import com.education.system_edu.pojo.insert.SearchQuestionnaireInsert;
import com.education.system_edu.pojo.output.*;

import java.util.List;
import java.util.Map;

public interface QuestionnaireService {
    Integer addAQuestionnaire(String msg, String qAndAs,String loginCode);


    Integer countCourseByCourseSearchInsert(SearchQuestionnaireInsert searchQuestionnaireInsert, Integer pageSize);

    List<QuestionnaireOutput> searchCourseBySearchQuestionnaireInsert(SearchQuestionnaireInsert searchQuestionnaireInsert);

    String sendQuestionnaire(QuestionnaireInsetToSend questionnaireInsetToSend, String loginCode);

    QuestionnaireToAnswerOutput getAQuestionnaireByQuestionnaireCode(String loginCode,String sendCode,String questionnaireCode);

    QuestionnaireToAnswerOutput getAQuestionnaireByQuestionnaireCode(String questionnaireCode);

    List<UserToSubmitQuestionnairePageOutput> getUserToSubmitQuestionnaireMSG(String loginCode);

    String submitQueationnaire(String loginCode, Map<String, Object> map);

    List<QuestionnaireHistoryOutput> getQuestionnaireHistory(String loginCode);

    List<QuestionnaireOutput> getQuestionReturn();

    List<AnswerReturnOutput> getAnswerReturn(String questionnaireCode);
}
