package com.education.system_edu.service;

import com.education.system_edu.pojo.output.CourseClassTeamOutput;
import com.education.system_edu.pojo.output.HomMsgsAndTeanMsgs;
import com.education.system_edu.pojo.output.SignPageMsg;
import com.education.system_edu.pojo.output.StudentSignInfo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface CourseClassService {
    Integer madeTeam(String courseClassCode, Integer memberNum, String loginCode);

    List<CourseClassTeamOutput> getCourseClassTeamByCourseClassCode(String courseClassCode);

    HomMsgsAndTeanMsgs getHomworkMSGsAndTeamMSGs(String courseClassCode, String loginCode) throws ParseException;

    String studentSign(String signCode, String loginCode);

    List<StudentSignInfo> getStudentsSignInfo(String loginCode);

    SignPageMsg getPageMsg(String loginCode);

    String checkSignInfo(Map<String, String> map,String loginCode);

    String getMsg(String loginCode);
}
