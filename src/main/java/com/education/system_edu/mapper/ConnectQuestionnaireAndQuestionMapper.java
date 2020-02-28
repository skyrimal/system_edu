package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectQuestionnaireAndQuestion;
import com.education.system_edu.pojo.ConnectQuestionnaireAndQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectQuestionnaireAndQuestionMapper {
    long countByExample(ConnectQuestionnaireAndQuestionExample example);

    int deleteByExample(ConnectQuestionnaireAndQuestionExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectQuestionnaireAndQuestion record);

    int insertSelective(ConnectQuestionnaireAndQuestion record);

    List<ConnectQuestionnaireAndQuestion> selectByExample(ConnectQuestionnaireAndQuestionExample example);

    ConnectQuestionnaireAndQuestion selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectQuestionnaireAndQuestion record, @Param("example") ConnectQuestionnaireAndQuestionExample example);

    int updateByExample(@Param("record") ConnectQuestionnaireAndQuestion record, @Param("example") ConnectQuestionnaireAndQuestionExample example);

    int updateByPrimaryKeySelective(ConnectQuestionnaireAndQuestion record);

    int updateByPrimaryKey(ConnectQuestionnaireAndQuestion record);
}