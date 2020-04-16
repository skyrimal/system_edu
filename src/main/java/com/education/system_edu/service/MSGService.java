package com.education.system_edu.service;

import com.education.system_edu.pojo.output.MainMSGOutput;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月16日 9:32
 */
public interface MSGService {
    MainMSGOutput getTeacherMainMSG(String loginCode);
}
