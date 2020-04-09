package com.education.system_edu.service;

import com.education.system_edu.pojo.insert.HomeworkModelInsert;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月07日 19:52
 */
public interface HomeworkService {
    Integer sendHomwork(HomeworkModelInsert homeworkModel, String loginCode);

    String madeSign(String classCode, String loginCode);
}
