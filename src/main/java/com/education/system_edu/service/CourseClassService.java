package com.education.system_edu.service;

import com.education.system_edu.pojo.output.CourseClassTeamOutput;
import com.education.system_edu.pojo.output.HomMsgsAndTeanMsgs;

import java.text.ParseException;
import java.util.List;

public interface CourseClassService {
    Integer madeTeam(String courseClassCode, Integer memberNum, String loginCode);

    List<CourseClassTeamOutput> getCourseClassTeamByCourseClassCode(String courseClassCode);

    HomMsgsAndTeanMsgs getHomworkMSGsAndTeamMSGs(String courseClassCode, String loginCode) throws ParseException;

    String studentSign(String signCode, String loginCode);
}
