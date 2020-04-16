package com.education.system_edu.mapper;

import com.education.system_edu.pojo.Assignment;
import com.education.system_edu.pojo.AssignmentExample;
import java.util.List;

import com.education.system_edu.pojo.output.HomeworkOutput;
import com.education.system_edu.pojo.output.HomworkMsg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AssignmentMapper {
    long countByExample(AssignmentExample example);

    int deleteByExample(AssignmentExample example);

    int insert(Assignment record);

    int insertSelective(Assignment record);

    List<Assignment> selectByExample(AssignmentExample example);

    int updateByExampleSelective(@Param("record") Assignment record, @Param("example") AssignmentExample example);

    int updateByExample(@Param("record") Assignment record, @Param("example") AssignmentExample example);

    @Select("SELECT\n" +
            "\thomwork.title,\n" +
            "\thomwork.starttime AS startTime,\n" +
            "\thomwork.endTime AS endTime,\n" +
            "\thomwork.class_code AS courseClassCode,\n" +
            "\tcourse.`name` AS courseName,\n" +
            "\t'' AS `status`,\n" +
            "\tass.score,\n" +
            "\tass.isteam AS isteam,\n" +
            "\tass.isacess AS isassi,\n" +
            "\tass.filename AS fileName,\n" +
            "\thomwork.`code`\n" +
            "FROM\n" +
            "\tsys_model_class_assignment AS homwork\n" +
            "LEFT JOIN all_users AS u ON homwork.create_by = u.login_code\n" +
            "LEFT JOIN sys_model_class AS course_class ON homwork.class_code = course_class.class_code\n" +
            "AND course_class.teacher_code = u.`code`\n" +
            "AND course_class.teacher_login_code = u.login_code\n" +
            "LEFT JOIN sys_model_course AS course ON course_class.course_code_no = course.course_code\n" +
            "AND course_class.course_code = course.`code`\n" +
            "LEFT JOIN assignment AS ass ON homwork.`code` = ass.assignment_code\n" +
            "WHERE\n" +
            "\tu.login_code = '${loginCode}'\n" +
            "AND homwork.title NOT LIKE '签到'\n ")
    List<HomeworkOutput> selectTeacherSendHomwork(String loginCode);


    @Select("SELECT\n" +
            "assignment.filename AS file,\n" +
            "assignment.isacess AS isAcess,\n" +
            "assignment.isteam AS isTeam,\n" +
            "assignment.score,\n" +
            "homwork.starttime AS startTime,\n" +
            "homwork.endTime AS endTime,\n" +
            "homwork.title,\n" +
            "homwork.context,\n" +
            "homwork.class_code AS courseClassCode,\n" +
            "'' AS finScore,\n" +
            "'' AS `status`,\n" +
            "homwork.`code`\n" +
            "FROM\n" +
            "sys_model_class_assignment AS homwork\n" +
            "LEFT JOIN assignment ON homwork.`code` = assignment.assignment_code\n" +
            "WHERE\n" +
            "homwork.title NOT LIKE '签到' AND\n" +
            "homwork.class_code = '${courseClassCode}'\n")
    List<HomworkMsg> selectAllClassHomeworkMGSsByCourseClassCode(String courseClassCode);
}