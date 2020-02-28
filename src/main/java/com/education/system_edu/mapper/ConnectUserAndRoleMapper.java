package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectUserAndRole;
import com.education.system_edu.pojo.ConnectUserAndRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectUserAndRoleMapper {
    long countByExample(ConnectUserAndRoleExample example);

    int deleteByExample(ConnectUserAndRoleExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectUserAndRole record);

    int insertSelective(ConnectUserAndRole record);

    List<ConnectUserAndRole> selectByExample(ConnectUserAndRoleExample example);

    ConnectUserAndRole selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectUserAndRole record, @Param("example") ConnectUserAndRoleExample example);

    int updateByExample(@Param("record") ConnectUserAndRole record, @Param("example") ConnectUserAndRoleExample example);

    int updateByPrimaryKeySelective(ConnectUserAndRole record);

    int updateByPrimaryKey(ConnectUserAndRole record);
}