package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysDataTreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDataTreeMapper {
    long countByExample(SysDataTreeExample example);

    int deleteByExample(SysDataTreeExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysDataTree record);

    int insertSelective(SysDataTree record);

    List<SysDataTree> selectByExample(SysDataTreeExample example);

    SysDataTree selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysDataTree record, @Param("example") SysDataTreeExample example);

    int updateByExample(@Param("record") SysDataTree record, @Param("example") SysDataTreeExample example);

    int updateByPrimaryKeySelective(SysDataTree record);

    int updateByPrimaryKey(SysDataTree record);
}