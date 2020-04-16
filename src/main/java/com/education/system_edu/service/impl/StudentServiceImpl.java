package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.StudentSignActionMapper;
import com.education.system_edu.mapper.SysModelCourseMapper;
import com.education.system_edu.pojo.StudentSignAction;
import com.education.system_edu.pojo.output.CourseOutput;
import com.education.system_edu.pojo.output.SignHistory;
import com.education.system_edu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月11日 11:44
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    SysModelCourseMapper sysModelCourseMapper;

    @Resource
    StudentSignActionMapper studentSignActionMapper;

    @Override
    public List<CourseOutput> searchLearningCourse(String loginCode) {
        return sysModelCourseMapper.selectByStudentLoginCode(loginCode);
    }

    @Override
    public List<SignHistory> getSignHistory(String loginCode) {
        return studentSignActionMapper.selectSignHistoryByLoginCode(loginCode);
    }
}
