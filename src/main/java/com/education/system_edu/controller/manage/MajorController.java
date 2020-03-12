package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.output.OutputClass;
import com.education.system_edu.pojo.output.OutputMajor;
import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.utils.MsgUtil;
import com.education.system_edu.utils.UserInfoUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @RequiresRoles({"user", "manager"})
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
    @RequiresRoles({"user", "manager"})
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
     * 搜索专业
     *
     * @return
     */
    @RequiresRoles({"user", "manager"})
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
    @RequiresRoles({"user", "manager"})
    @GetMapping("initChangeMajor")
    @ResponseBody
    public Major initChangeMajor(@RequestParam("majorCode") String majorCode) {
        return majorService.findMajorByMajorByMajorCode(majorCode);
    }

    /**
     * 获取一个专业信息
     *
     * @param major
     * @return
     */
    @RequiresRoles({"user", "manager"})
    @PostMapping("changeMajor")
    public String changeMajor(Major major, HttpSession httpSession) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        int flag = majorService.updateMajor(major, userInfoUtils.getLoginCode());
        httpSession.setAttribute("msg", MsgUtil.addMsj(flag));
        return "redirect:/manage/faculty/m_manage_faculty_major";
    }

    /**
     * ajax
     * 获取班级
     *
     * @param major
     * @return
     */
    @RequiresRoles({"user", "manager"})
    @GetMapping("checkClassNo")
    @ResponseBody
    public List<OutputClass> checkClassNo(@RequestParam("majorId") String major, @RequestParam("grade") String grade) {
        return majorService.findClassByMajorCodeAndGrade(major,grade);
    }

}
