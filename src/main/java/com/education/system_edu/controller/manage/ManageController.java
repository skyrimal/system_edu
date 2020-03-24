package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.FacultyService;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.service.PageService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;


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

    MajorService majorService;

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    @RequiresRoles({"manager"})
    @RequestMapping("m_manage_course_info")
    public String m_manage_course_info() {
        return "/m_manage_course_info";
    }

    @RequiresRoles({"manager"})
    @RequestMapping("m_manage_course_made_courseclass")
    public String m_manage_course_made_courseclass() {
        return "/m_manage_course_made_courseclass";
    }

    @RequiresRoles({"manager"})
    @RequestMapping("m_manage_faculty_courseclass")
    public String m_manage_faculty_courseclass() {
        return "/m_manage_faculty_courseclass";
    }



    @RequiresRoles({"manager"})
    @GetMapping("get_major_info")
    @ResponseBody
    public Major getMajorInfo() {
        return null;
    }


}
