package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelCourse;
import com.education.system_edu.pojo.SysModelCourseExample;
import java.util.List;

import com.education.system_edu.pojo.insert.CourseSearchInsert;
import com.education.system_edu.pojo.output.CourseSearchOutput;
import org.apache.ibatis.annotations.Param;

public interface SysModelCourseMapper {
    long countByExample(SysModelCourseExample example);

    int deleteByExample(SysModelCourseExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelCourse record);

    int insertSelective(SysModelCourse record);

    List<SysModelCourse> selectByExample(SysModelCourseExample example);

    SysModelCourse selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelCourse record, @Param("example") SysModelCourseExample example);

    int updateByExample(@Param("record") SysModelCourse record, @Param("example") SysModelCourseExample example);

    int updateByPrimaryKeySelective(SysModelCourse record);

    int updateByPrimaryKey(SysModelCourse record);

    int countCourseSearchOutputBycourseSearchInsert(CourseSearchInsert courseSearchInsert);

    List<CourseSearchOutput> selectCourseSearchOutputBycourseSearchInsert(CourseSearchInsert courseSearchInsert);
}