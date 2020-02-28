package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentSubmitQuestionnaire;
import com.education.system_edu.pojo.StudentSubmitQuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}