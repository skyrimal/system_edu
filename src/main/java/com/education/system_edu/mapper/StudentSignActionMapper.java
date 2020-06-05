package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentSignAction;
import com.education.system_edu.pojo.StudentSignActionExample;
import java.util.List;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.output.SignHistory;
import com.education.system_edu.pojo.output.StudentSignInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentSignActionMapper {
    long countByExample(StudentSignActionExample example);

    int deleteByExample(StudentSignActionExample example);

    int deleteByPrimaryKey(String code);

    int insert(StudentSignAction record);

    int insertSelective(StudentSignAction record);

    List<StudentSignAction> selectByExample(StudentSignActionExample example);

    StudentSignAction selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") StudentSignAction record, @Param("example") StudentSignActionExample example);

    int updateByExample(@Param("record") StudentSignAction record, @Param("example") StudentSignActionExample example);

    int updateByPrimaryKeySelective(StudentSignAction record);

    int updateByPrimaryKey(StudentSignAction record);

    @Select("SELECT\n" +
            "course.`name` AS courseName,\n" +
            "sign.class_code AS courseClassCode,\n" +
            "sign.sign_date AS time,\n" +
            "sign.`status`\n" +
            "FROM\n" +
            "student_sign_action AS sign\n" +
            "LEFT JOIN sys_model_class AS course_class ON sign.class_code = course_class.class_code\n" +
            "LEFT JOIN sys_model_course AS course ON course_class.course_code_no = course.course_code AND course_class.course_code = course.`code`\n" +
            "WHERE\n" +
            "sign.student_code = '${loginCode}'\n" +
            " limit 0,5")
    List<SignHistory> selectSignHistoryByLoginCode(String loginCode);

    @Select("SELECT DISTINCT\n" +
            "all_users.user_name,\n" +
            "all_users.login_code,\n" +
            "all_users.`code`,\n" +
            "all_users.`password`,\n" +
            "all_users.email,\n" +
            "all_users.mobile,\n" +
            "all_users.phone,\n" +
            "all_users.sex,\n" +
            "all_users.avatar,\n" +
            "all_users.sign,\n" +
            "all_users.user_type,\n" +
            "all_users.mgr_type,\n" +
            "all_users.pwd_update_date,\n" +
            "all_users.pwd_update_record,\n" +
            "all_users.pwd_question,\n" +
            "all_users.pwd_question_answer,\n" +
            "all_users.pwd_question_2,\n" +
            "all_users.pwd_question_answer_2,\n" +
            "all_users.pwd_question_3,\n" +
            "all_users.pwd_question_answer_3,\n" +
            "all_users.pwd_quest_update_date,\n" +
            "all_users.last_login_ip,\n" +
            "all_users.last_login_date,\n" +
            "all_users.freeze_date,\n" +
            "all_users.freeze_cause,\n" +
            "all_users.`status`,\n" +
            "all_users.create_by,\n" +
            "all_users.create_date,\n" +
            "all_users.update_by,\n" +
            "all_users.update_date\n" +
            "FROM\n" +
            "sys_model_class_assignment\n" +
            "INNER JOIN sys_model_class ON sys_model_class_assignment.class_code = sys_model_class.class_code\n" +
            "INNER JOIN connect_user_student_and_class ON sys_model_class.`code` = connect_user_student_and_class.class_code\n" +
            "INNER JOIN all_users ON connect_user_student_and_class.student_no = all_users.login_code\n" +
            "WHERE\n" +
            "sys_model_class_assignment.class_code = '${classCode}'\n")
    List<User> selectAllStudentSignInfo(String classCode);


}