package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectTeacherCourse;
import com.education.system_edu.pojo.ConnectTeacherCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectTeacherCourseMapper {
    long countByExample(ConnectTeacherCourseExample example);

    int deleteByExample(ConnectTeacherCourseExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectTeacherCourse record);

    int insertSelective(ConnectTeacherCourse record);

    List<ConnectTeacherCourse> selectByExample(ConnectTeacherCourseExample example);

    ConnectTeacherCourse selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectTeacherCourse record, @Param("example") ConnectTeacherCourseExample example);

    int updateByExample(@Param("record") ConnectTeacherCourse record, @Param("example") ConnectTeacherCourseExample example);

    int updateByPrimaryKeySelective(ConnectTeacherCourse record);

    int updateByPrimaryKey(ConnectTeacherCourse record);
}