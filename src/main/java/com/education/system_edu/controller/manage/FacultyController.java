package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.UserExample;
import com.education.system_edu.pojo.pojo.Department;
import com.education.system_edu.pojo.pojo.Faculty;
import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.FacultyService;
import com.education.system_edu.service.PageService;
import com.education.system_edu.utils.FacultyFactory;
import com.education.system_edu.utils.MsgUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("manage/faculty")
public class FacultyController {
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

    /**
     * 查看学院信息
     *
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresRoles({"user", "manager"})
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
    @RequiresRoles({"user", "manager"})
    @RequestMapping("checkDepartment")
    @ResponseBody
    public List<Department> checkDepartment(@RequestParam("facultyId") String facultyId,
                                            Model model) {
        List<Department> departments = facultyService.findDepartment(facultyId, 2);
        return departments;
    }

    /**
     * 通过id查看部门
     *
     * @param departmentId
     * @return
     */
    @RequiresRoles({"user", "manager"})
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
    @RequiresRoles({"user", "manager"})
    @PostMapping("addDepartment")
    public String addDepartment(@RequestParam("parentCode") String parentCode,
                                Department department,
                                HttpSession httpSession) {
        System.out.println("进入添加department方法");
        //获取username填入department
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(department.getManagerCode());
        department.setManagerName(pageService.findUser(userForSearch).getUserName());

        int flag = facultyService.addDepartment(parentCode
                , department
                , SecurityUtils.getSubject().getPrincipal().toString());
        httpSession.setAttribute("msg", MsgUtil.addMsj(flag));
        return "redirect:/manage/faculty/m_manage_faculty_faculty";
    }

    /**
     * 删除部门
     *
     * @param departmentCode
     * @param model
     * @return
     */
    @RequiresRoles({"user", "manager"})
    @RequestMapping("deleteDepartment")
    public String deleteDepartment(@RequestParam("departmentCode") String departmentCode,
                                   Model model) {
        facultyService.deleteDepartment(departmentCode);
        return "redirect:/manage/faculty/m_manage_faculty_faculty";
    }

    /**
     * 修改部门
     *
     * @param departmentCode
     * @param department
     * @param httpSession
     * @return
     */
    @RequiresRoles({"user", "manager"})
    @PostMapping("changeDepartment")
    public String updateDepartment(@RequestParam("departmentCode") String departmentCode,
                                   Department department,
                                   HttpSession httpSession) {
        int flag;
        department.setCode(departmentCode);

        flag = facultyService.updateDepartment(department, SecurityUtils.getSubject().getPrincipal().toString());
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
    @RequiresRoles({"user", "manager"})
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
    @RequiresRoles({"user", "manager"})
    @GetMapping("initSearch")
    @ResponseBody
    public List<String[]> initSearch() {
        return FacultyFactory.returnFactoryNameList(facultyService.findFaculty(1));
    }




}
