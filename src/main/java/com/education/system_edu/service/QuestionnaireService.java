package com.education.system_edu.service;

import com.education.system_edu.pojo.insert.SearchQuestionnaireInsert;
import com.education.system_edu.pojo.output.QuestionnaireOutput;

import java.util.List;

public interface QuestionnaireService {
    Integer addAQuestionnaire(String msg, String qAndAs,String loginCode);


    Integer countCourseByCourseSearchInsert(SearchQuestionnaireInsert searchQuestionnaireInsert, Integer pageSize);

    List<QuestionnaireOutput> searchCourseBySearchQuestionnaireInsert(SearchQuestionnaireInsert searchQuestionnaireInsert);
}
