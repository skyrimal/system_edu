package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SendQuestionnaire;
import com.education.system_edu.pojo.SendQuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SendQuestionnaireMapper {
    long countByExample(SendQuestionnaireExample example);

    int deleteByExample(SendQuestionnaireExample example);

    int deleteByPrimaryKey(String code);

    int insert(SendQuestionnaire record);

    int insertSelective(SendQuestionnaire record);

    List<SendQuestionnaire> selectByExample(SendQuestionnaireExample example);

    SendQuestionnaire selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SendQuestionnaire record, @Param("example") SendQuestionnaireExample example);

    int updateByExample(@Param("record") SendQuestionnaire record, @Param("example") SendQuestionnaireExample example);

    int updateByPrimaryKeySelective(SendQuestionnaire record);

    int updateByPrimaryKey(SendQuestionnaire record);
}