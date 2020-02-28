package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysNode;
import com.education.system_edu.pojo.SysNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNodeMapper {
    long countByExample(SysNodeExample example);

    int deleteByExample(SysNodeExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysNode record);

    int insertSelective(SysNode record);

    List<SysNode> selectByExample(SysNodeExample example);

    SysNode selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysNode record, @Param("example") SysNodeExample example);

    int updateByExample(@Param("record") SysNode record, @Param("example") SysNodeExample example);

    int updateByPrimaryKeySelective(SysNode record);

    int updateByPrimaryKey(SysNode record);
}