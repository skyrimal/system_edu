package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelClassAssignment;
import com.education.system_edu.pojo.SysModelClassAssignmentExample;
import java.util.List;

import com.education.system_edu.pojo.output.StudentSubmitHomeworkMSG;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysModelClassAssignmentMapper {
    long countByExample(SysModelClassAssignmentExample example);

    int deleteByExample(SysModelClassAssignmentExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelClassAssignment record);

    int insertSelective(SysModelClassAssignment record);

    List<SysModelClassAssignment> selectByExample(SysModelClassAssignmentExample example);

    SysModelClassAssignment selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelClassAssignment record, @Param("example") SysModelClassAssignmentExample example);

    int updateByExample(@Param("record") SysModelClassAssignment record, @Param("example") SysModelClassAssignmentExample example);

    int updateByPrimaryKeySelective(SysModelClassAssignment record);

    int updateByPrimaryKey(SysModelClassAssignment record);

    @Select("SELECT\n" +
            "assignmenr.`code`,\n" +
            "assignmenr.class_code,\n" +
            "assignmenr.title,\n" +
            "assignmenr.type,\n" +
            "assignmenr.context,\n" +
            "assignmenr.sys_college_node_code,\n" +
            "assignmenr.sys_college_node_type,\n" +
            "assignmenr.starttime,\n" +
            "assignmenr.endTime,\n" +
            "assignmenr.create_by,\n" +
            "assignmenr.create_date,\n" +
            "assignmenr.update_by,\n" +
            "assignmenr.update_date,\n" +
            "ABS(NOW() - startTime) AS diffTime\n" +
            "FROM\n" +
            "sys_model_class_assignment AS assignmenr\n" +
            "WHERE\n" +
            "assignmenr.type = '2'\n" +
            "ORDER BY\n" +
            "diffTime ASC\n" +
            "LIMIT 0, 1\n")
    SysModelClassAssignment selectTheClosedSignAssignment();

    @Select("SELECT\n" +
            "student_submit.`code`,\n" +
            "student_submit.student_code AS loginCode,\n" +
            "u.user_name AS stuName,\n" +
            "student_submit.filename AS fileName,\n" +
            "student_submit.context,\n" +
            "student_submit.is_submit AS `status`,\n" +
            "student_submit.submit_datetime AS updateTime,\n" +
            "corre.finally_score AS finalScore\n" +
            "FROM\n" +
            "\tstudent_submit_task_action AS student_submit\n" +
            "LEFT JOIN all_users AS u ON student_submit.student_code = u.login_code\n" +
            "LEFT JOIN correct_assignmenrt_action AS corre ON student_submit.student_code = corre.submit_student_code\n" +
            "AND student_submit.assignment_code = corre.assignment_code\n" +
            "WHERE\n" +
            "student_submit.assignment_code = '${assignmentCode}'\n" +
            "LIMIT 0,1\n")
    List<StudentSubmitHomeworkMSG> getStudentSubmitHomworkMsgs(String assignmentCode);
}