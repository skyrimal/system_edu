package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelCourse;
import com.education.system_edu.pojo.SysModelCourseExample;
import java.util.List;

import com.education.system_edu.pojo.insert.CourseSearchInsert;
import com.education.system_edu.pojo.output.CourseOutput;
import com.education.system_edu.pojo.output.CourseSearchOutput;
import com.education.system_edu.pojo.output.TeacherCourseClassLineInfoOutput;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT\n" +
            "course_class.class_code,\n" +
            "course.`name`\n" +
            "FROM\n" +
            "sys_model_class AS course_class\n" +
            "LEFT JOIN sys_model_course AS course ON course_class.course_code_no = course.course_code AND course_class.course_code = course.`code`\n" +
            "WHERE\n" +
            "course_class.teacher_login_code = '${loginCode}' AND\n" +
            "course_class.type = 1")
    List<TeacherCourseClassLineInfoOutput> getTeacherCourse(String loginCode);

    @Select("SELECT\n" +
            "course.`code`,\n" +
            "course.course_code,\n" +
            "course.`name`,\n" +
            "course.huors,\n" +
            "course.credit,\n" +
            "course.sys_node_code,\n" +
            "course.sys_node_type\n" +
            "FROM\n" +
            "sys_model_course AS course\n" +
            "WHERE \n" +
            "course.`code` = '${s}';")
    SysModelCourse selectByCourseCode(String s);

    @Select("SELECT\n" +
            "\tcourse_class.type,\n" +
            "\tcourse_class.class_code AS `code`,\n" +
            "\tcourse.`name`,\n" +
            "\tcourse.course_code AS parentCode\n" +
            "FROM\n" +
            "\tconnect_user_student_and_class AS c\n" +
            "LEFT JOIN sys_model_class AS course_class ON c.class_code = course_class.`code`\n" +
            "LEFT JOIN sys_model_course AS course ON course_class.course_code_no = course.course_code\n" +
            "WHERE\n" +
            "\tc.student_no = '${loginCode}'\n" +
            "AND course.`name` NOT LIKE '001'\n" +
            "AND course_class.type = 1")
    List<CourseOutput> selectByStudentLoginCode(String loginCode);
}