package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.AddCourseClassInsert;
import com.education.system_edu.pojo.insert.ClassSearchInsert;
import com.education.system_edu.pojo.insert.CourseAddInsert;
import com.education.system_edu.pojo.insert.CourseSearchInsert;
import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.pojo.output.*;
import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.utils.MsgUtil;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.UserInfoUtils;
import com.education.system_edu.utils.value.PageValue;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("manage/faculty/major")
public class MajorController {
    MajorService majorService;

    @Autowired
    public void setFacultyService(MajorService majorService) {
        this.majorService = majorService;
    }

    /**
     * 添加专业
     *
     * @param major
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("addMajor")
    public String addMajor(Major major, HttpSession httpSession) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        int flag = majorService.addMajor(major, userInfoUtils.getLoginCode());
        httpSession.setAttribute("msg", MsgUtil.addMsj(flag));
        return "redirect:/manage/faculty/m_manage_faculty_major";
    }

    /**
     * 搜索专业
     *
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("checkMajor")
    public String checkMajor(Model model,
                             HttpSession httpSession,
                             @RequestParam("departmentCode") String departmentCode,
                             @RequestParam("keyword") String keyword,
                             @RequestParam("facultyId") String faculty) {
        Major major = new Major();
        major.setDepartmentCode(departmentCode);
        model.addAttribute("major", majorService.findMajorByMajor(major, keyword, faculty));
        model.addAttribute("msg", httpSession.getAttribute("msg"));
        httpSession.removeAttribute("msg");
        return "/m_manage_faculty_major";
    }

    /**
     * ajax
     * 联级查询-搜索专业
     *
     * @return
     */
    @RequiresRoles({"manager"})
    @GetMapping("checkMajor")
    @ResponseBody
    public List<OutputMajor> checkMajor(@RequestParam("departmentCode") String departmentCode) {
        return majorService.findMajorByDepartmentCode(departmentCode);
    }

    /**
     * 获取一个专业信息
     *
     * @param majorCode
     * @return
     */
    @RequiresRoles({"manager"})
    @GetMapping("initChangeMajor")
    @ResponseBody
    public Major initChangeMajor(@RequestParam("majorCode") String majorCode) {
        return majorService.findMajorByMajorByMajorCode(majorCode);
    }

    /**
     * 修改专业信息
     *
     * @param major
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("changeMajor")
    public String changeMajor(Major major, HttpSession httpSession) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        int flag = majorService.updateMajor(major, userInfoUtils.getLoginCode());
        httpSession.setAttribute("msg", MsgUtil.addMsj(flag));
        return "redirect:/manage/faculty/m_manage_faculty_major";
    }

    /**
     * ajax
     * 联级查询--获取班级
     *
     * @param major
     * @return
     */
    @GetMapping("checkClassNo")
    @ResponseBody
    public List<OutputClass> checkClassNo(@RequestParam("majorId") String major,
                                          @RequestParam("grade") String grade) {
        return majorService.findClassByMajorCodeAndGrade(major, grade);
    }


    /**
     * 课程查看界面
     *
     * @param model
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("/m_manage_course_course")
    public String m_manage_course_course(Model model) {
        CourseSearchInsert courseSearchInsert = new CourseSearchInsert();
        courseSearchInsert.init();
        return searchCourseJump(model, courseSearchInsert);
    }

    /**
     * 查询课程 一页
     *
     * @param courseSearchInsert
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("searchCourse/{pageNum}/{pageSize}")
    public String searchCourse(CourseSearchInsert courseSearchInsert,
                               Model model,
                               @PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize) {
        courseSearchInsert.setPageSize(pageSize);
        courseSearchInsert.setPageNum(pageNum);
        return searchCourseJump(model, courseSearchInsert);
    }

    /**
     * 添加课程
     *
     * @param courseAddInsert
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("addCourse")
    public String addCourse(CourseAddInsert courseAddInsert) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        majorService.addCourse(courseAddInsert, userInfoUtils.getLoginCode());
        return "redirect:/manage/faculty/major/m_manage_course_course";
    }

    /**
     * 添加课程班级
     *
     * @param courseAddInsert
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("addCourseClass")
    public String addCourseClass(CourseAddInsert courseAddInsert) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        majorService.addCourse(courseAddInsert, userInfoUtils.getLoginCode());
        return "redirect:/manage/faculty/major/m_manage_course_course";
    }

    public String searchCourseJump(Model model, CourseSearchInsert courseSearchInsert) {
        List<CourseSearchOutput> courseSearchOutputs = majorService.searchCourseByCourseSearchInsert(courseSearchInsert);
        model.addAttribute("courseSearchOutputs", courseSearchOutputs);
        model.addAttribute("courseSearchInsert", courseSearchInsert);
        PageMsg page = PageUtils.madePageMsg(courseSearchInsert.getPageNum(), courseSearchInsert.getPageSize(),
                                             majorService.countCourseByCourseSearchInsert(courseSearchInsert, PageValue.PAGE_SIZE));
        if (!PageUtils.sendPageMsgToModel(model, page)) {
            return "/error";
        }
        return "/m_manage_course_course";
    }

    /**
     * 查询课程 一页
     *
     * @return
     */
    @RequiresRoles({"manager"})
    @GetMapping("searchCourses/{faculty}/{department}/{major}")
    @ResponseBody
    public List<CourseOutput> searchAllCourses(@PathVariable String department,
                                               @PathVariable String faculty,
                                               @PathVariable String major) {
        System.out.println(department);
        System.out.println(faculty);
        System.out.println(major);
        return majorService.chooseAllCourse(faculty, department, major);
    }

    @PostMapping("addCourseClass/course_class")
    public String addCouseClass(AddCourseClassInsert courseAddInsert) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        int i = majorService.addCourseClass(courseAddInsert,user.getLoginCode());
        return "redirect:/manage/m_manage_course_made_courseclass";
    }
}
