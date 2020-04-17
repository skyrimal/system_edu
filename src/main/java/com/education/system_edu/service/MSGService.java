package com.education.system_edu.service;

import com.education.system_edu.pojo.output.TeacherMainMSGOutput;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月16日 9:32
 */
public interface MSGService {
    TeacherMainMSGOutput getTeacherMainMSG(String loginCode);
}
