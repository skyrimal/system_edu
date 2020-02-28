package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectQuestionnaireQuestionAndOption;
import com.education.system_edu.pojo.ConnectQuestionnaireQuestionAndOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectQuestionnaireQuestionAndOptionMapper {
    long countByExample(ConnectQuestionnaireQuestionAndOptionExample example);

    int deleteByExample(ConnectQuestionnaireQuestionAndOptionExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectQuestionnaireQuestionAndOption record);

    int insertSelective(ConnectQuestionnaireQuestionAndOption record);

    List<ConnectQuestionnaireQuestionAndOption> selectByExample(ConnectQuestionnaireQuestionAndOptionExample example);

    ConnectQuestionnaireQuestionAndOption selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectQuestionnaireQuestionAndOption record, @Param("example") ConnectQuestionnaireQuestionAndOptionExample example);

    int updateByExample(@Param("record") ConnectQuestionnaireQuestionAndOption record, @Param("example") ConnectQuestionnaireQuestionAndOptionExample example);

    int updateByPrimaryKeySelective(ConnectQuestionnaireQuestionAndOption record);

    int updateByPrimaryKey(ConnectQuestionnaireQuestionAndOption record);
}