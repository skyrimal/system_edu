package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentSignAction;
import com.education.system_edu.pojo.StudentSignActionExample;
import java.util.List;

import com.education.system_edu.pojo.output.SignHistory;
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
            "limit 0,5")
    List<SignHistory> selectSignHistoryByLoginCode(String loginCode);
}