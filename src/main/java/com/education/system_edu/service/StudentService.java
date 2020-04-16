package com.education.system_edu.service;

import com.education.system_edu.pojo.output.CourseOutput;
import com.education.system_edu.pojo.output.SignHistory;

import java.util.List;

public interface StudentService {
    List<CourseOutput> searchLearningCourse(String loginCode);

    List<SignHistory> getSignHistory(String loginCode);
}
