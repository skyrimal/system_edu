package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.SubjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller(value = "manageUserController")
@RequestMapping("manage/user")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequiresRoles({"user", "manager"})
    @PostMapping("userSearch")
    public String userManageMain(@RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("pageNum") Integer pageNum,
                                 SearchUserByFaculty searchUserByFaculty,
                                 Model model,HttpSession httpSession) {
        model.addAttribute("users", userService.selectUsersByUser(searchUserByFaculty, pageSize, pageNum));
        model.addAttribute("pageCount", userService.getUserPageCount(searchUserByFaculty,pageSize));
        model.addAttribute("pageNextNum", pageNum + 1);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);

        httpSession.removeAttribute("searchUserByFaculty");
        httpSession.setAttribute("searchUserByFaculty", searchUserByFaculty);
        return "/m_manage_userManage";
    }
    @RequiresRoles({"user", "manager"})
    @GetMapping("userSearch")
    public String userManageMain(@RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("pageNum") Integer pageNum,
                                 Model model,
                                 HttpSession httpSession) {
        if (httpSession.getAttribute("searchUserByFaculty")!=null){
            SearchUserByFaculty searchUserByFaculty = (SearchUserByFaculty) httpSession.getAttribute("searchUserByFaculty");
            model.addAttribute("users", userService.selectUsersByUser(searchUserByFaculty, pageSize, pageNum));

            model.addAttribute("pageCount", userService.getUserPageCount(searchUserByFaculty,pageSize));
        }else {
            model.addAttribute("users", userService.selectUsersByUser(null, pageSize, pageNum));
            model.addAttribute("pageCount", userService.getUserPageCount(null,pageSize));
        }

        model.addAttribute("pageNextNum", pageNum + 1);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);
        return "/m_manage_userManage";
    }

    @PostMapping("editUser")
    public String editUser(UserInModel userInModel){
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        int flag = userService.addUser(userInModel,subjectUtils.getUserLoginCode());
        if (flag<5){
            return "/error";
        }
        return "/m_manage_userManage";
    }

    @RequiresRoles({"user", "manager"})
    @PostMapping("addUser")
    public String addUser(UserInModel userInModel){

        return "/m_manage_userManage";
    }
}
