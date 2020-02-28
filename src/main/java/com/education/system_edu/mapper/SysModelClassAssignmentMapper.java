package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelClassAssignment;
import com.education.system_edu.pojo.SysModelClassAssignmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelClassAssignmentMapper {
    long countByExample(SysModelClassAssignmentExample example);

    int deleteByExample(SysModelClassAssignmentExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelClassAssignment record);

    int insertSelective(SysModelClassAssignment record);

    List<SysModelClassAssignment> selectByExample(SysModelClassAssignmentExample example);

    SysModelClassAssignment selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelClassAssignment record, @Param("example") SysModelClassAssignmentExample example);

    int updateByExample(@Param("record") SysModelClassAssignment record, @Param("example") SysModelClassAssignmentExample example);

    int updateByPrimaryKeySelective(SysModelClassAssignment record);

    int updateByPrimaryKey(SysModelClassAssignment record);
}