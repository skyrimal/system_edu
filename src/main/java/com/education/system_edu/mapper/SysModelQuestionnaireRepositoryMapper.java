package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelQuestionnaireRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireRepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelQuestionnaireRepositoryMapper {
    long countByExample(SysModelQuestionnaireRepositoryExample example);

    int deleteByExample(SysModelQuestionnaireRepositoryExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelQuestionnaireRepository record);

    int insertSelective(SysModelQuestionnaireRepository record);

    List<SysModelQuestionnaireRepository> selectByExample(SysModelQuestionnaireRepositoryExample example);

    SysModelQuestionnaireRepository selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelQuestionnaireRepository record, @Param("example") SysModelQuestionnaireRepositoryExample example);

    int updateByExample(@Param("record") SysModelQuestionnaireRepository record, @Param("example") SysModelQuestionnaireRepositoryExample example);

    int updateByPrimaryKeySelective(SysModelQuestionnaireRepository record);

    int updateByPrimaryKey(SysModelQuestionnaireRepository record);
}