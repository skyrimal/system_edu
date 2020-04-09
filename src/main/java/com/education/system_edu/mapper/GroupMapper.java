package com.education.system_edu.mapper;

import com.education.system_edu.pojo.Group;
import com.education.system_edu.pojo.GroupExample;
import java.util.List;

import com.education.system_edu.pojo.output.CourseClassTeamOutput;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(String code);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    List<CourseClassTeamOutput> selectAllCourseClassGroupByCourseClassCode(String courseClassCode);
}