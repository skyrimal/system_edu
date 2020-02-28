package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ClassPublishAssignmentAction;
import com.education.system_edu.pojo.ClassPublishAssignmentActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassPublishAssignmentActionMapper {
    long countByExample(ClassPublishAssignmentActionExample example);

    int deleteByExample(ClassPublishAssignmentActionExample example);

    int deleteByPrimaryKey(String code);

    int insert(ClassPublishAssignmentAction record);

    int insertSelective(ClassPublishAssignmentAction record);

    List<ClassPublishAssignmentAction> selectByExample(ClassPublishAssignmentActionExample example);

    ClassPublishAssignmentAction selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ClassPublishAssignmentAction record, @Param("example") ClassPublishAssignmentActionExample example);

    int updateByExample(@Param("record") ClassPublishAssignmentAction record, @Param("example") ClassPublishAssignmentActionExample example);

    int updateByPrimaryKeySelective(ClassPublishAssignmentAction record);

    int updateByPrimaryKey(ClassPublishAssignmentAction record);
}