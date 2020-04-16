package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepositoryExample;

import java.util.Collection;
import java.util.List;

import com.education.system_edu.pojo.dbpojo.UserInSchoolMSG;
import com.education.system_edu.pojo.output.UserToSubmitQuestionnairePageOutput;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysModelQuestionnaireQuestionRepositoryMapper {
    long countByExample(SysModelQuestionnaireQuestionRepositoryExample example);

    int deleteByExample(SysModelQuestionnaireQuestionRepositoryExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelQuestionnaireQuestionRepository record);

    int insertSelective(SysModelQuestionnaireQuestionRepository record);

    List<SysModelQuestionnaireQuestionRepository> selectByExample(SysModelQuestionnaireQuestionRepositoryExample example);

    SysModelQuestionnaireQuestionRepository selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelQuestionnaireQuestionRepository record, @Param("example") SysModelQuestionnaireQuestionRepositoryExample example);

    int updateByExample(@Param("record") SysModelQuestionnaireQuestionRepository record, @Param("example") SysModelQuestionnaireQuestionRepositoryExample example);

    int updateByPrimaryKeySelective(SysModelQuestionnaireQuestionRepository record);

    int updateByPrimaryKey(SysModelQuestionnaireQuestionRepository record);

    int insertList(List<SysModelQuestionnaireQuestionRepository> questions);

    @Select("SELECT\n" +
            "\tsend.`code`,\n" +
            "\tsend.questionnaire_code AS questionCode,\n" +
            "\tq.title,\n" +
            "\tsend.endtime AS end_time\n" +
            "FROM\n" +
            "\tsend_questionnaire AS send\n" +
            "INNER JOIN sys_model_questionnaire_repository AS q ON q.`code` = send.questionnaire_code\n" +
            "INNER JOIN sys_data_tree AS p ON send.remarks = p.`code`\n" +
            "AND p.`code` = '${pCode}'")
    List<UserToSubmitQuestionnairePageOutput> selectUserToSubmitQuestionnairePageOutputByUserInSchoolMSG(String pCode);

    @Select("SELECT\n" +
            "\tsend.`code`,\n" +
            "\tsend.questionnaire_code AS questionCode,\n" +
            "\tq.title,\n" +
            "\tsend.endtime,\n" +
            "\tsend.class_code\n" +
            "FROM\n" +
            "\tsend_questionnaire AS send\n" +
            "INNER JOIN sys_model_questionnaire_repository AS q ON q.`code` = send.questionnaire_code\n" +
            "AND send.class_code = '${str}'")
    List<UserToSubmitQuestionnairePageOutput> selectUserToSubmitQuestionnairePageOutputByClassCode(String str);

    @Select("SELECT\n" +
            "send.`code`,\n" +
            "send.questionnaire_code AS questionCode,\n" +
            "q.title,\n" +
            "send.endtime AS end_time,\n" +
            "send.grade\n" +
            "FROM\n" +
            "send_questionnaire AS send\n" +
            "INNER JOIN sys_model_questionnaire_repository AS q ON q.`code` = send.questionnaire_code  \n" +
            "AND send.grade = '${grade}'")
    List <UserToSubmitQuestionnairePageOutput> selectUserToSubmitQuestionnairePageOutputByGrade(String grade);
}