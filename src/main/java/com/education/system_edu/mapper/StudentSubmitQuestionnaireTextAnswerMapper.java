package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentSubmitQuestionnaireTextAnswer;
import com.education.system_edu.pojo.StudentSubmitQuestionnaireTextAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentSubmitQuestionnaireTextAnswerMapper {
    long countByExample(StudentSubmitQuestionnaireTextAnswerExample example);

    int deleteByExample(StudentSubmitQuestionnaireTextAnswerExample example);

    int deleteByPrimaryKey(String code);

    int insert(StudentSubmitQuestionnaireTextAnswer record);

    int insertSelective(StudentSubmitQuestionnaireTextAnswer record);

    List<StudentSubmitQuestionnaireTextAnswer> selectByExample(StudentSubmitQuestionnaireTextAnswerExample example);

    StudentSubmitQuestionnaireTextAnswer selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") StudentSubmitQuestionnaireTextAnswer record, @Param("example") StudentSubmitQuestionnaireTextAnswerExample example);

    int updateByExample(@Param("record") StudentSubmitQuestionnaireTextAnswer record, @Param("example") StudentSubmitQuestionnaireTextAnswerExample example);

    int updateByPrimaryKeySelective(StudentSubmitQuestionnaireTextAnswer record);

    int updateByPrimaryKey(StudentSubmitQuestionnaireTextAnswer record);
}