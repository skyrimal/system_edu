package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.UserExample;
import com.education.system_edu.pojo.insert.ClassAddInsert;
import com.education.system_edu.pojo.insert.ClassInsert;
import com.education.system_edu.pojo.insert.ClassSearchInsert;
import com.education.system_edu.pojo.model.Page;
import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.pojo.output.ClassSearchOutput;
import com.education.system_edu.pojo.pojo.Department;
import com.education.system_edu.pojo.pojo.Faculty;
import com.education.system_edu.service.FacultyService;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.service.PageService;
import com.education.system_edu.utils.FacultyFactory;
import com.education.system_edu.utils.MsgUtil;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.UserInfoUtils;
import com.education.system_edu.utils.value.PageValue;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("manage/faculty")
public class FacultyController {
    FacultyService facultyService;
    PageService pageService;
    MajorService majorService;

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    /**
     * 查看学院信息
     *
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("m_manage_faculty_faculty")
    public String m_manage_faculty_faculty(Model model, HttpSession httpSession) {
        List<Faculty> faculties = facultyService.findFaculty(1);
        model.addAttribute("faculties", faculties);
        model.addAttribute("msg", httpSession.getAttribute("msg"));
        httpSession.removeAttribute("msg");
        return "/m_manage_faculty_faculty";
    }

    /**
     * 查看系下部门
     *
     * @param facultyId
     * @param model
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("checkDepartment")
    @ResponseBody
    public List<Department> checkDepartment(@RequestParam("facultyId") String facultyId,
                                            Model model) {
        return facultyService.findDepartment(facultyId, 2);
    }

    /**
     * 通过id查看部门
     *
     * @param departmentId
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("checkDepartmentByDepartmentId")
    @ResponseBody
    public Department checkDepartment(@RequestParam("facultyId") String departmentId) {
        return facultyService.findDepartmentByDepartmentId(departmentId);
    }

    /**
     * 添加部门
     *
     * @param parentCode
     * @param department
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("addDepartment")
    public String addDepartment(@RequestParam("parentCode") String parentCode,
                                Department department,
                                HttpSession httpSession) {
        System.out.println("进入添加department方法");
        //初始化userinfo工具
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        //获取username填入department
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(department.getManagerCode());
        department.setManagerName(pageService.findUser(userForSearch).getUserName());

        int flag = facultyService.addDepartment(parentCode
                , department
                , userInfoUtils.getLoginCode());
        httpSession.setAttribute("msg", MsgUtil.addMsj(flag));
        return "redirect:/manage/faculty/m_manage_faculty_faculty";
    }

    /**
     * 删除部门
     *
     * @param departmentCode
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("deleteDepartment")
    public ModelAndView deleteDepartment(@RequestParam("departmentCode") String departmentCode) {
        int flag = facultyService.deleteDepartment(departmentCode);
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/manage/faculty/m_manage_faculty_faculty"));
        return modelAndView;
    }

    /**
     * 修改部门
     *
     * @param departmentCode
     * @param department
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("changeDepartment")
    public String updateDepartment(@RequestParam("departmentCode") String departmentCode,
                                   Department department,
                                   HttpSession httpSession) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        int flag;
        department.setCode(departmentCode);

        flag = facultyService.updateDepartment(department, userInfoUtils.getLoginCode());
        httpSession.setAttribute("msg", MsgUtil.editMsj(flag));
        return "redirect:/manage/faculty/m_manage_faculty_faculty";
    }


    /**
     * 跳转并显示专业
     *
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @GetMapping("m_manage_faculty_major")
    public String m_manage_faculty_major(Model model,
                                         HttpSession httpSession) {
        model.addAttribute("major", null);
        model.addAttribute("msg", httpSession.getAttribute("msg"));
        httpSession.removeAttribute("msg");
        return "/m_manage_faculty_major";
    }

    /**
     * ajax联级查询学院和专业
     *
     * @return
     */
    @GetMapping("initSearch")
    @ResponseBody
    public List<String[]> initSearch() {
        return FacultyFactory.returnFactoryNameList(facultyService.findFaculty(1));
    }


    /**
     * 初次进入行政班级管理页面
     * @param model
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("m_manage_faculty_class")
    public String m_manage_faculty_class(Model model) {
        ClassSearchInsert classSearchInsert = new ClassSearchInsert();
        classSearchInsert.init();
        List<ClassSearchOutput> classSearchOutput = majorService.searchClassByClassInsert(classSearchInsert);
        model.addAttribute("classSearchOutput", classSearchOutput);
        model.addAttribute("classSearchInsert", classSearchInsert);
        PageMsg page = PageUtils.madePageMsg(classSearchInsert.getPageNum(),classSearchInsert.getPageSize(),
                                             majorService.countPageByPageSizeAndClassSearchInsert(classSearchInsert,PageValue.PAGE_SIZE));
        if (!PageUtils.sendPageMsgToModel(model,page)){
            return "/error";
        }
        return "/m_manage_faculty_class";
    }

    /**
     * 查询班级信息
     * @param classSearchInsert
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("searchClass/{pageNum}/{pageSize}")
    public String searchClass(ClassSearchInsert classSearchInsert,
                              Model model,
                              @PathVariable("pageNum") Integer pageNum,
                              @PathVariable("pageSize") Integer pageSize) {
        classSearchInsert.setPageSize(pageSize);
        classSearchInsert.setPageNum(pageNum);
        List<ClassSearchOutput> classSearchOutput = majorService.searchClassByClassInsert(classSearchInsert);
        model.addAttribute("classSearchOutput", classSearchOutput);
        model.addAttribute("classSearchInsert", classSearchInsert);
        PageMsg page = PageUtils.madePageMsg(pageNum,pageSize,
                                             majorService.countPageByPageSizeAndClassSearchInsert(classSearchInsert,PageValue.PAGE_SIZE));
        if (!PageUtils.sendPageMsgToModel(model,page)){
            return "/error";
        }
        return "/m_manage_faculty_class";
    }

    /**
     * 添加一个班级
     * @param classInsert
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("addClass")
    public String addClass(ClassInsert classInsert) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        majorService.addClass(classInsert, userInfoUtils.getLoginCode());
        return "redirect:/manage/faculty/m_manage_faculty_class";
    }
}
