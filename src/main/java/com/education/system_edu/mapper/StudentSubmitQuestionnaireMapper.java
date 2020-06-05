package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentSubmitQuestionnaire;
import com.education.system_edu.pojo.StudentSubmitQuestionnaireExample;
import java.util.List;

import com.education.system_edu.pojo.output.QuestionnaireHistoryOutput;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentSubmitQuestionnaireMapper {
    long countByExample(StudentSubmitQuestionnaireExample example);

    int deleteByExample(StudentSubmitQuestionnaireExample example);

    int deleteByPrimaryKey(String code);

    int insert(StudentSubmitQuestionnaire record);

    int insertSelective(StudentSubmitQuestionnaire record);

    List<StudentSubmitQuestionnaire> selectByExample(StudentSubmitQuestionnaireExample example);

    StudentSubmitQuestionnaire selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") StudentSubmitQuestionnaire record, @Param("example") StudentSubmitQuestionnaireExample example);

    int updateByExample(@Param("record") StudentSubmitQuestionnaire record, @Param("example") StudentSubmitQuestionnaireExample example);

    int updateByPrimaryKeySelective(StudentSubmitQuestionnaire record);

    int updateByPrimaryKey(StudentSubmitQuestionnaire record);

    @Select("SELECT DISTINCT\n" +
            "\tq.title,\n" +
            "\thistory.create_date AS finishDate,\n" +
            "\tsq.endtime AS endDate\n" +
            "FROM\n" +
            "\tstudent_submit_questionnaire AS history\n" +
            "INNER JOIN send_questionnaire AS sq ON history.sys_data_node_code = sq.`code`\n" +
            "INNER JOIN sys_model_questionnaire_repository AS q ON sq.questionnaire_code = q.`code`\n" +
            "INNER JOIN all_users AS u ON history.student_code = u.login_code\n" +
            "AND u.login_code = '${loginCode}'")
    List<QuestionnaireHistoryOutput> selectStudentSubmitHistory(String loginCode);

    @Select("SELECT\n" +
            "COUNT(`code`)\n" +
            "FROM\n" +
            "student_submit_questionnaire\n" +
            "WHERE\n" +
            "student_submit_questionnaire.sys_data_node_code = '${sendCode}' AND\n" +
            "student_submit_questionnaire.student_code = '${loginCode}' \n")
    int countSubmit(String loginCode, String sendCode);
}