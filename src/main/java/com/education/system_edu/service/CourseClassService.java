package com.education.system_edu.service;

import com.education.system_edu.pojo.output.CourseClassTeamOutput;

import java.util.List;

public interface CourseClassService {
    Integer madeTeam(String courseClassCode, Integer memberNum, String loginCode);

    List<CourseClassTeamOutput> getCourseClassTeamByCourseClassCode(String courseClassCode);
}
