package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.MSGMapper;
import com.education.system_edu.pojo.output.MainMSGOutput;
import com.education.system_edu.pojo.output.TeacherMainMSGOutput;
import com.education.system_edu.service.MSGService;
import com.education.system_edu.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月16日 9:32
 */
@Service
public class MSGServiceImpl implements MSGService {
    @Resource
    MSGMapper msgMapper;

    @Override
    public TeacherMainMSGOutput getTeacherMainMSG(String loginCode) {
        MainMSGOutput mainMSGOutput = msgMapper.selectTeacherMainMSG(loginCode, DateUtils.dateToString(new Date()));
        List<String> courseNames = msgMapper.selectTeachingCourseName(loginCode);
        TeacherMainMSGOutput teacherMainMSGOutput = new TeacherMainMSGOutput();
        teacherMainMSGOutput.setMainMSGOutput(mainMSGOutput);
        teacherMainMSGOutput.setCourseClassNames(courseNames);
        return teacherMainMSGOutput;
    }
}
