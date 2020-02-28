package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectUserAndDepartment;
import com.education.system_edu.pojo.ConnectUserAndDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectUserAndDepartmentMapper {
    long countByExample(ConnectUserAndDepartmentExample example);

    int deleteByExample(ConnectUserAndDepartmentExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectUserAndDepartment record);

    int insertSelective(ConnectUserAndDepartment record);

    List<ConnectUserAndDepartment> selectByExample(ConnectUserAndDepartmentExample example);

    ConnectUserAndDepartment selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectUserAndDepartment record, @Param("example") ConnectUserAndDepartmentExample example);

    int updateByExample(@Param("record") ConnectUserAndDepartment record, @Param("example") ConnectUserAndDepartmentExample example);

    int updateByPrimaryKeySelective(ConnectUserAndDepartment record);

    int updateByPrimaryKey(ConnectUserAndDepartment record);
}