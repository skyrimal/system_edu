package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelCourseTime;
import com.education.system_edu.pojo.SysModelCourseTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelCourseTimeMapper {
    long countByExample(SysModelCourseTimeExample example);

    int deleteByExample(SysModelCourseTimeExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelCourseTime record);

    int insertSelective(SysModelCourseTime record);

    List<SysModelCourseTime> selectByExample(SysModelCourseTimeExample example);

    SysModelCourseTime selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelCourseTime record, @Param("example") SysModelCourseTimeExample example);

    int updateByExample(@Param("record") SysModelCourseTime record, @Param("example") SysModelCourseTimeExample example);

    int updateByPrimaryKeySelective(SysModelCourseTime record);

    int updateByPrimaryKey(SysModelCourseTime record);
}