package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelCourseTableModelHasCourse;
import com.education.system_edu.pojo.SysModelCourseTableModelHasCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelCourseTableModelHasCourseMapper {
    long countByExample(SysModelCourseTableModelHasCourseExample example);

    int deleteByExample(SysModelCourseTableModelHasCourseExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelCourseTableModelHasCourse record);

    int insertSelective(SysModelCourseTableModelHasCourse record);

    List<SysModelCourseTableModelHasCourse> selectByExample(SysModelCourseTableModelHasCourseExample example);

    SysModelCourseTableModelHasCourse selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelCourseTableModelHasCourse record, @Param("example") SysModelCourseTableModelHasCourseExample example);

    int updateByExample(@Param("record") SysModelCourseTableModelHasCourse record, @Param("example") SysModelCourseTableModelHasCourseExample example);

    int updateByPrimaryKeySelective(SysModelCourseTableModelHasCourse record);

    int updateByPrimaryKey(SysModelCourseTableModelHasCourse record);
}