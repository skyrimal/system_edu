package com.education.system_edu.mapper;

import com.education.system_edu.pojo.Group;
import com.education.system_edu.pojo.GroupExample;
import java.util.List;

import com.education.system_edu.pojo.output.CourseClassTeamOutput;
import com.education.system_edu.pojo.output.TeamMsg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT\n" +
            "`group`.remarks AS teamNo,\n" +
            "stu.user_name AS stuName,\n" +
            "stu.login_code AS stuLoginCode,\n" +
            "`group`.class_code AS classCode\n" +
            "FROM\n" +
            "connect_class_group_student AS `group`\n" +
            "LEFT JOIN all_users AS stu ON `group`.student_code = stu.`code` ,\n" +
            "(\n" +
            "\tSELECT DISTINCT\n" +
            "\t\t`group`.class_code,\n" +
            "\t\t`group`.remarks\n" +
            "\tFROM\n" +
            "\t\tconnect_class_group_student AS `group`\n" +
            "\tLEFT JOIN all_users AS stu ON `group`.student_code = stu.`code`\n" +
            "\tWHERE\n" +
            "\t\tstu.login_code = '${loginCode}'\n" +
            ") AS a\n" +
            "WHERE\n" +
            "a.class_code = `group`.class_code AND\n" +
            "a.remarks = `group`.remarks AND\n" +
            "`group`.type = 1\n")
    List<TeamMsg> selectStudentTeamByStudentLoginCode(String loginCode);
}