package com.education.system_edu.service;

import com.education.system_edu.pojo.insert.HomeworkModelInsert;
import com.education.system_edu.pojo.output.HomeworkOutput;
import com.education.system_edu.pojo.output.SignHistory;
import com.education.system_edu.pojo.output.StudentSubmitHomeworkMSG;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月07日 19:52
 */
public interface HomeworkService {
    Integer sendHomwork(HomeworkModelInsert homeworkModel, String loginCode);

    String madeSign(String classCode, String loginCode);

    List<HomeworkOutput> getHomework(String loginCode);

    Integer studentSubmitHomwork(String context, String homeworkCode, String fileName, String loginCode);

    List<StudentSubmitHomeworkMSG> getHomeworkInfo(String assignmentCode);

    String correctHomework(String submitCode, String finalScore, String loginCode);
}
