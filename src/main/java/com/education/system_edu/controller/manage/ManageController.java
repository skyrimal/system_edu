package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.FacultyService;
import com.education.system_edu.service.PageService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/manage")
public class ManageController {
    /**
     * *********************************************************************
     * *********************************************************************
     * *********************************************************************
     * 管理员
     * *********************************************************************
     * *********************************************************************
     */
    FacultyService facultyService;

    PageService pageService;

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }


    @RequiresRoles({"user", "manager"})
    @RequestMapping("/m_manage_course_course")
    public String m_manage_course_course() {
        return "/m_manage_course_course";
    }

    @RequiresRoles({"user", "manager"})
    @RequestMapping("m_manage_course_info")
    public String m_manage_course_info() {
        return "/m_manage_course_info";
    }

    @RequiresRoles({"user", "manager"})
    @RequestMapping("m_manage_course_made_courseclass")
    public String m_manage_course_made_courseclass() {
        return "/m_manage_course_made_courseclass";
    }

    @RequiresRoles({"user", "manager"})
    @RequestMapping("m_manage_faculty_courseclass")
    public String m_manage_faculty_courseclass() {
        return "/m_manage_faculty_courseclass";
    }

    @RequiresRoles({"user", "manager"})
    @RequestMapping("m_manage_questionnaire_qm")
    public String m_manage_questionnaire_qm() {
        return "/m_manage_questionnaire_qm";
    }

    @RequiresRoles({"user", "manager"})
    @GetMapping("get_major_info")
    @ResponseBody
    public Major getMajorInfo() {
        return null;
    }


}
