package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}