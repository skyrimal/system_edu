package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelQuestionnaireQuestionOptionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionOptionRepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelQuestionnaireQuestionOptionRepositoryMapper {
    long countByExample(SysModelQuestionnaireQuestionOptionRepositoryExample example);

    int deleteByExample(SysModelQuestionnaireQuestionOptionRepositoryExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelQuestionnaireQuestionOptionRepository record);

    int insertSelective(SysModelQuestionnaireQuestionOptionRepository record);

    List<SysModelQuestionnaireQuestionOptionRepository> selectByExample(SysModelQuestionnaireQuestionOptionRepositoryExample example);

    SysModelQuestionnaireQuestionOptionRepository selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelQuestionnaireQuestionOptionRepository record, @Param("example") SysModelQuestionnaireQuestionOptionRepositoryExample example);

    int updateByExample(@Param("record") SysModelQuestionnaireQuestionOptionRepository record, @Param("example") SysModelQuestionnaireQuestionOptionRepositoryExample example);

    int updateByPrimaryKeySelective(SysModelQuestionnaireQuestionOptionRepository record);

    int updateByPrimaryKey(SysModelQuestionnaireQuestionOptionRepository record);

    int insertListList(List<List<SysModelQuestionnaireQuestionOptionRepository>> optionses);
}