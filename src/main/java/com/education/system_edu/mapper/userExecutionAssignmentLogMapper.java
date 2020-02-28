package com.education.system_edu.mapper;

import com.education.system_edu.pojo.userExecutionAssignmentLog;
import com.education.system_edu.pojo.userExecutionAssignmentLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userExecutionAssignmentLogMapper {
    long countByExample(userExecutionAssignmentLogExample example);

    int deleteByExample(userExecutionAssignmentLogExample example);

    int deleteByPrimaryKey(String code);

    int insert(userExecutionAssignmentLog record);

    int insertSelective(userExecutionAssignmentLog record);

    List<userExecutionAssignmentLog> selectByExample(userExecutionAssignmentLogExample example);

    userExecutionAssignmentLog selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") userExecutionAssignmentLog record, @Param("example") userExecutionAssignmentLogExample example);

    int updateByExample(@Param("record") userExecutionAssignmentLog record, @Param("example") userExecutionAssignmentLogExample example);

    int updateByPrimaryKeySelective(userExecutionAssignmentLog record);

    int updateByPrimaryKey(userExecutionAssignmentLog record);
}