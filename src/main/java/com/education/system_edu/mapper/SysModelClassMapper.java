package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelClass;
import com.education.system_edu.pojo.SysModelClassExample;
import java.util.List;

import com.education.system_edu.pojo.insert.ClassSearchInsert;
import com.education.system_edu.pojo.output.ClassSearchOutput;
import org.apache.ibatis.annotations.Param;

public interface SysModelClassMapper {
    long countByExample(SysModelClassExample example);

    int deleteByExample(SysModelClassExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelClass record);

    int insertSelective(SysModelClass record);

    List<SysModelClass> selectByExample(SysModelClassExample example);

    SysModelClass selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelClass record, @Param("example") SysModelClassExample example);

    int updateByExample(@Param("record") SysModelClass record, @Param("example") SysModelClassExample example);

    int updateByPrimaryKeySelective(SysModelClass record);

    int updateByPrimaryKey(SysModelClass record);

    List<ClassSearchOutput> selectByClassSearchInsert(ClassSearchInsert classSearchInsert);

    Integer countByClassSearchInsert(ClassSearchInsert classSearchInsert);
}