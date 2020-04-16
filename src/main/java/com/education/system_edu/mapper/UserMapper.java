package com.education.system_edu.mapper;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;

import java.util.List;

import com.education.system_edu.pojo.dbpojo.UserInSchoolMSG;
import com.education.system_edu.pojo.insert.TeacherSearchStudentInsert;
import com.education.system_edu.pojo.output.CourseClassUserStudentOutPut;
import com.education.system_edu.pojo.output.OutputUserForEditUserAction;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    long countByExample(UserExample example);

    long countByPageUser(PageUser pageUser);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String code);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    /**
     * 按条件查找用户信息
     *
     * @param user
     * @return
     */
    List<PageUserOutput> selectSelectedByUser(PageUser user);

    User selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    OutputUserForEditUserAction selectOutputUserForEditUserActionByLoginCode(@Param("loginCode") String loginCode);

    @Select("SELECT\n" +
            "`user`.`code`,\n" +
            "`user`.login_code,\n" +
            "`user`.user_name,\n" +
            "major.`name` as major,\n" +
            "department.`name` as department,\n" +
            "factory.`name` as factory,\n" +
            "class.class_code\n" +
            "FROM\n" +
            "all_users AS `user`\n" +
            "LEFT JOIN connect_user_and_major AS a_u_m ON `user`.`code` = a_u_m.use_code\n" +
            "LEFT JOIN sys_data_tree AS major ON a_u_m.sys_node_code = major.`code`\n" +
            "LEFT JOIN sys_data_tree AS department ON major.parent_node = department.`code`\n" +
            "LEFT JOIN sys_data_tree AS factory ON department.parent_node = factory.`code`\n" +
            "LEFT JOIN connect_user_student_and_class AS c_ustu_c ON c_ustu_c.student_code = `user`.`code`\n" +
            "LEFT JOIN sys_model_class AS class ON c_ustu_c.class_code = class.`code`\n" +
            "WHERE\n" +
            "class.class_code = \"${courseClassCode}\";")
    List<CourseClassUserStudentOutPut> getUserMsgForCourseClassOutput(String courseClassCode);

    @Select("SELECT\n" +
            "u.`code`,\n" +
            "u.login_code,\n" +
            "u.user_name,\n" +
            "u.user_type,\n" +
            "u.avatar,\n" +
            "u.sign,\n" +
            "u.sex\n" +
            "FROM\n" +
            "connect_user_and_major AS c_u_m\n" +
            "LEFT JOIN all_users AS u ON u.`code` = c_u_m.use_code\n" +
            "LEFT JOIN sys_data_tree AS maj ON c_u_m.sys_node_code = maj.`code`\n" +
            "LEFT JOIN sys_data_tree AS dep ON maj.parent_node = dep.`code`\n" +
            "LEFT JOIN sys_data_tree AS fac ON dep.parent_node = fac.`code`\n" +
            "WHERE\n" +
            "fac.`code` = '${facultyCode}'")
    List<User> selectStudentByFactoryCode(String facultyCode);

    @Select("SELECT\n" +
            "users.`code`,\n" +
            "users.login_code,\n" +
            "users.user_name,\n" +
            "users.`password`,\n" +
            "users.email,\n" +
            "users.mobile,\n" +
            "users.phone,\n" +
            "users.sex,\n" +
            "users.avatar,\n" +
            "users.sign,\n" +
            "users.user_type,\n" +
            "users.mgr_type,\n" +
            "users.pwd_update_date,\n" +
            "users.pwd_update_record,\n" +
            "users.pwd_question,\n" +
            "users.pwd_question_answer,\n" +
            "users.pwd_question_2,\n" +
            "users.pwd_question_answer_2,\n" +
            "users.pwd_question_3,\n" +
            "users.pwd_question_answer_3,\n" +
            "users.pwd_quest_update_date,\n" +
            "users.last_login_ip,\n" +
            "users.last_login_date,\n" +
            "users.freeze_date,\n" +
            "users.freeze_cause,\n" +
            "users.`status`,\n" +
            "users.create_by,\n" +
            "users.create_date,\n" +
            "users.update_by,\n" +
            "users.update_date\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_teacher_course AS c_t_c ON users.`code` = c_t_c.teacher_code\n" +
            "WHERE\n" +
            "c_t_c.course_code = '${str}'")
    List<User> selectTeacherByCoueseCode(String str);

    @Select("SELECT\n" +
            "users.`code`,\n" +
            "users.login_code,\n" +
            "users.user_name,\n" +
            "users.`password`,\n" +
            "users.email,\n" +
            "users.mobile,\n" +
            "users.phone,\n" +
            "users.sex,\n" +
            "users.avatar,\n" +
            "users.sign,\n" +
            "users.user_type,\n" +
            "users.mgr_type,\n" +
            "users.pwd_update_date,\n" +
            "users.pwd_update_record,\n" +
            "users.pwd_question,\n" +
            "users.pwd_question_answer,\n" +
            "users.pwd_question_2,\n" +
            "users.pwd_question_answer_2,\n" +
            "users.pwd_question_3,\n" +
            "users.pwd_question_answer_3,\n" +
            "users.pwd_quest_update_date,\n" +
            "users.last_login_ip,\n" +
            "users.last_login_date,\n" +
            "users.freeze_date,\n" +
            "users.freeze_cause,\n" +
            "users.`status`,\n" +
            "users.create_by,\n" +
            "users.create_date,\n" +
            "users.update_by,\n" +
            "users.update_date\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_and_major AS c_u_m ON c_u_m.use_code = users.`code`\n" +
            "LEFT JOIN sys_data_tree AS maj ON c_u_m.sys_node_code = maj.`code`\n" +
            "LEFT JOIN sys_data_tree AS dep ON maj.parent_node = dep.`code`\n" +
            "LEFT JOIN sys_data_tree AS fac ON dep.parent_node = fac.`code`\n" +
            "WHERE\n" +
            "dep.`code` = '${departmentCode}'\n")
    List<User> selectStudentByDepartmentCode(String departmentCode);

    @Select("SELECT \n" +
            "users.`code`,\n" +
            "users.login_code,\n" +
            "users.user_name,\n" +
            "users.`password`,\n" +
            "users.email,\n" +
            "users.mobile,\n" +
            "users.phone,\n" +
            "users.sex,\n" +
            "users.avatar,\n" +
            "users.sign,\n" +
            "users.user_type,\n" +
            "users.mgr_type,\n" +
            "users.pwd_update_date,\n" +
            "users.pwd_update_record,\n" +
            "users.pwd_question,\n" +
            "users.pwd_question_answer,\n" +
            "users.pwd_question_2,\n" +
            "users.pwd_question_answer_2,\n" +
            "users.pwd_question_3,\n" +
            "users.pwd_question_answer_3,\n" +
            "users.pwd_quest_update_date,\n" +
            "users.last_login_ip,\n" +
            "users.last_login_date,\n" +
            "users.freeze_date,\n" +
            "users.freeze_cause,\n" +
            "users.`status`,\n" +
            "users.create_by,\n" +
            "users.create_date,\n" +
            "users.update_by,\n" +
            "users.update_date\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_and_major AS c_u_m ON c_u_m.use_code = users.`code`\n" +
            "LEFT JOIN sys_data_tree AS maj ON c_u_m.sys_node_code = maj.`code`\n" +
            "LEFT JOIN sys_data_tree AS dep ON maj.parent_node = dep.`code`\n" +
            "LEFT JOIN sys_data_tree AS fac ON dep.parent_node = fac.`code`\n" +
            "WHERE\n" +
            "maj.`code` = '${majorCode}'\n")
    List<User> selectStudentByMajorCode(String majorCode);

    @Select("SELECT\n" +
            "users.`code`,\n" +
            "users.login_code,\n" +
            "users.user_name,\n" +
            "users.`password`,\n" +
            "users.email,\n" +
            "users.mobile,\n" +
            "users.phone,\n" +
            "users.sex,\n" +
            "users.avatar,\n" +
            "users.sign,\n" +
            "users.user_type,\n" +
            "users.mgr_type,\n" +
            "users.pwd_update_date,\n" +
            "users.pwd_update_record,\n" +
            "users.pwd_question,\n" +
            "users.pwd_question_answer,\n" +
            "users.pwd_question_2,\n" +
            "users.pwd_question_answer_2,\n" +
            "users.pwd_question_3,\n" +
            "users.pwd_question_answer_3,\n" +
            "users.pwd_quest_update_date,\n" +
            "users.last_login_ip,\n" +
            "users.last_login_date,\n" +
            "users.freeze_date,\n" +
            "users.freeze_cause,\n" +
            "users.`status`,\n" +
            "users.create_by,\n" +
            "users.create_date,\n" +
            "users.update_by,\n" +
            "users.update_date\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_student_and_class AS c_u_s_c ON c_u_s_c.student_code = users.`code`\n" +
            "LEFT JOIN sys_model_class AS course_class ON c_u_s_c.class_code = course_class.`code`\n" +
            "WHERE\n" +
            "course_class.class_code ='${courseClassCode}'\n" +
            "ORDER BY users.login_code " +
            "LIMIT ${start},${end}")
    List<User> selectByCourseClassCode(String courseClassCode, Integer start, Integer end);

    @Select("SELECT\n" +
            "users.`code`,\n" +
            "users.login_code,\n" +
            "users.user_name,\n" +
            "users.`password`,\n" +
            "users.email,\n" +
            "users.mobile,\n" +
            "users.phone,\n" +
            "users.sex,\n" +
            "users.avatar,\n" +
            "users.sign,\n" +
            "users.user_type,\n" +
            "users.mgr_type,\n" +
            "users.pwd_update_date,\n" +
            "users.pwd_update_record,\n" +
            "users.pwd_question,\n" +
            "users.pwd_question_answer,\n" +
            "users.pwd_question_2,\n" +
            "users.pwd_question_answer_2,\n" +
            "users.pwd_question_3,\n" +
            "users.pwd_question_answer_3,\n" +
            "users.pwd_quest_update_date,\n" +
            "users.last_login_ip,\n" +
            "users.last_login_date,\n" +
            "users.freeze_date,\n" +
            "users.freeze_cause,\n" +
            "users.`status`,\n" +
            "users.create_by,\n" +
            "users.create_date,\n" +
            "users.update_by,\n" +
            "users.update_date\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_student_and_class AS c_u_s_c ON c_u_s_c.student_code = users.`code`\n" +
            "LEFT JOIN sys_model_class AS course_class ON c_u_s_c.class_code = course_class.`code`\n" +
            "WHERE\n" +
            "course_class.class_code ='${courseClassCode}' AND\n" +
            "users.user_name LIKE '%${studentName}%'\n" +
            "ORDER BY users.login_code " +
            "LIMIT ${start},${end}")
    List<User> selectByCourseClassCodeAndName(String courseClassCode, String studentName, Integer start, Integer end);

    @Select("SELECT\n" +
            "count(users.`code`)\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_student_and_class AS c_u_s_c ON c_u_s_c.student_code = users.`code`\n" +
            "LEFT JOIN sys_model_class AS course_class ON c_u_s_c.class_code = course_class.`code`\n" +
            "WHERE\n" +
            "course_class.class_code ='${courseClassCode}'")
    Integer countSelectByCourseClassCode(String courseClassCode);

    @Select("SELECT\n" +
            "count(users.`code`)\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_student_and_class AS c_u_s_c ON c_u_s_c.student_code = users.`code`\n" +
            "LEFT JOIN sys_model_class AS course_class ON c_u_s_c.class_code = course_class.`code`\n" +
            "WHERE\n" +
            "course_class.class_code ='${courseClassCode}' AND\n" +
            "users.user_name LIKE '%${studentName}%'")
    Integer countSelectByCourseClassCodeAndName(String courseClassCode, String studentName);

    @Select("SELECT\n" +
            "users.`code`,\n" +
            "users.login_code,\n" +
            "users.user_name,\n" +
            "users.`password`,\n" +
            "users.email,\n" +
            "users.mobile,\n" +
            "users.phone,\n" +
            "users.sex,\n" +
            "users.avatar,\n" +
            "users.sign,\n" +
            "users.user_type,\n" +
            "users.mgr_type,\n" +
            "users.pwd_update_date,\n" +
            "users.pwd_update_record,\n" +
            "users.pwd_question,\n" +
            "users.pwd_question_answer,\n" +
            "users.pwd_question_2,\n" +
            "users.pwd_question_answer_2,\n" +
            "users.pwd_question_3,\n" +
            "users.pwd_question_answer_3,\n" +
            "users.pwd_quest_update_date,\n" +
            "users.last_login_ip,\n" +
            "users.last_login_date,\n" +
            "users.freeze_date,\n" +
            "users.freeze_cause,\n" +
            "users.`status`,\n" +
            "users.create_by,\n" +
            "users.create_date,\n" +
            "users.update_by,\n" +
            "users.update_date\n" +
            "FROM\n" +
            "all_users AS users\n" +
            "LEFT JOIN connect_user_student_and_class AS c_u_s_c ON c_u_s_c.student_code = users.`code`\n" +
            "LEFT JOIN sys_model_class AS course_class ON c_u_s_c.class_code = course_class.`code`\n" +
            "WHERE\n" +
            "course_class.class_code ='${courseClassCode}' \n" +
            "ORDER BY users.login_code ")
    List<User> selectAllByCourseClassCode(String courseClassCode);

    @Select("SELECT DISTINCT\n" +
            "cls.class_code AS cls,\n" +
            "cls.grade,\n" +
            "all_users.login_code,\n" +
            "maj.`code` AS maj,\n" +
            "dep.`code` AS dep,\n" +
            "fac.`code` AS fac\n" +
            "FROM\n" +
            "sys_model_class AS cls\n" +
            "INNER JOIN sys_data_tree AS maj ON cls.sys_college_node_code = maj.`code` AND cls.type = '2'\n" +
            "INNER JOIN sys_data_tree AS dep ON maj.parent_node = dep.`code`\n" +
            "INNER JOIN sys_data_tree AS fac ON dep.parent_node = fac.`code`\n" +
            "INNER JOIN connect_user_student_and_class AS csu ON csu.class_code = cls.`code`\n" +
            "INNER JOIN all_users ON csu.student_no = all_users.login_code AND all_users.login_code = '2020001001'\n")
    List<UserInSchoolMSG> selectSchoolMSGByLoginCode(String loginCode);

    @Select("SELECT DISTINCT\n" +
            "\tsys_model_class.class_code,\n" +
            "\tall_users.login_code\n" +
            "FROM\n" +
            "\tsys_model_class\n" +
            "INNER JOIN connect_user_student_and_class ON sys_model_class.`code` = connect_user_student_and_class.class_code\n" +
            "AND sys_model_class.type = '1'\n" +
            "INNER JOIN all_users ON connect_user_student_and_class.student_no = all_users.login_code\n" +
            "AND all_users.login_code = '${loginCode}'")
    List<String> selectClassByLoginCode(String loginCode);
}