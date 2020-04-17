package com.education.system_edu.mapper;

import com.education.system_edu.pojo.output.MainMSGOutput;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MSGMapper {

    @Select("SELECT\n" +
            "\ta.courseNumForOneWeak,\n" +
            "\ta.courseNumForOneWeakMax,\n" +
            "\tb.sendQuestionnaireNumMax,\n" +
            "\tb.sendQuestionnaireNum,\n" +
            "\tc.homeworkUnCorrectNum,\n" +
            "\tc.homeworkUnCorrectNumMax,\n" +
            "\td.taskNum,\n" +
            "\td.taskNumMax\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCount(course_class.class_code) AS courseNumForOneWeak,\n" +
            "\t\t\tCount(course_class.class_code) AS courseNumForOneWeakMax\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_model_class AS course_class\n" +
            "\t\tINNER JOIN all_users AS u ON course_class.teacher_code = u.`code`\n" +
            "\t\tAND course_class.type = 1\n" +
            "\t\tAND u.login_code = '${loginCode}'\n" +
            "\t) a,\n" +
            "\t(\n" +
            "\t\tSELECT DISTINCT\n" +
            "\t\t\tCount(a.`code`) sendQuestionnaireNumMax,\n" +
            "\t\t\tCount(b.`code`) sendQuestionnaireNum\n" +
            "\t\tFROM\n" +
            "\t\t\tsend_questionnaire AS a\n" +
            "\t\tLEFT JOIN send_questionnaire AS b ON a.`code` = b.`code`\n" +
            "\t\tAND b.endtime >= '${date}'\n" +
            "\t\tWHERE a.create_by = '${loginCode}'\n" +
            "\t\tAND b.create_by = '${loginCode}'\n" +
            "\t) b,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(homework.`code`) homeworkUnCorrectNumMax,\n" +
            "\t\t\tCOUNT(homework1.`code`) homeworkUnCorrectNum\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_model_class_assignment AS homework\n" +
            "\t\tLEFT JOIN sys_model_class_assignment AS homework1 ON homework1.`code` = homework.`code`\n" +
            "\t\tAND homework.create_by = '${loginCode}'\n" +
            "\t\tAND homework1.endTime >= '${date}'\n" +
            "\t\tAND homework1.create_by = '${loginCode}'\n" +
            "\t\tWHERE\n" +
            "\t\t\thomework.type = 1\n" +
            "\t\tAND homework.type = 1\n" +
            "\t) c,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(homework.`code`) taskNumMax,\n" +
            "\t\t\tCOUNT(homework1.`code`) taskNum\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_model_class_assignment AS homework\n" +
            "\t\tLEFT JOIN sys_model_class_assignment AS homework1 ON homework1.`code` = homework.`code`\n" +
            "\t\tAND homework.create_by = '${loginCode}'\n" +
            "\t\tAND homework1.endTime >= '${date}'\n" +
            "\t\tAND homework1.create_by = '${loginCode}'\n" +
            "\t) d")
    MainMSGOutput selectTeacherMainMSG( String loginCode,String date);

    @Select("SELECT x.`name` from (SELECT\n" +
            "course.`name`,\n" +
            "couse_class.class_code,\n" +
            "u.user_name\n" +
            "FROM\n" +
            "sys_model_class AS couse_class\n" +
            "INNER JOIN sys_model_course AS course ON couse_class.course_code_no = course.course_code AND couse_class.type = 1\n" +
            "INNER JOIN all_users AS u ON couse_class.teacher_code = u.`code` AND u.login_code = '${loginCode}')x\n")
    List<String> selectTeachingCourseName(String loginCode);
}
