package com.education.system_edu.controller.manage;

import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.UserInfoUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller(value = "manageUserController")
@RequestMapping("manage/user")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 通过条件查询学生
     *
     * @param pageSize
     * @param pageNum
     * @param searchUserByFaculty
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("userSearch")
    public String userManageMain(@RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("pageNum") Integer pageNum,
                                 SearchUserByFaculty searchUserByFaculty,
                                 Model model, HttpSession httpSession) {
        model.addAttribute("users", userService.selectUsersByUser(searchUserByFaculty, pageSize, pageNum));
        model.addAttribute("pageCount", userService.getUserPageCount(searchUserByFaculty, pageSize));
        model.addAttribute("pageNextNum", pageNum + 1);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);

        httpSession.removeAttribute("searchUserByFaculty");
        httpSession.setAttribute("searchUserByFaculty", searchUserByFaculty);
        return "/m_manage_userManage";
    }

    /**
     * 查询所有学生
     *
     * @param pageSize
     * @param pageNum
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresRoles({"manager"})
    @GetMapping("userSearch")
    public String userManageMain(@RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("pageNum") Integer pageNum,
                                 Model model,
                                 HttpSession httpSession) {
        if (httpSession.getAttribute("searchUserByFaculty") != null && pageSize > 1) {
            SearchUserByFaculty searchUserByFaculty = (SearchUserByFaculty) httpSession.getAttribute("searchUserByFaculty");
            model.addAttribute("users", userService.selectUsersByUser(searchUserByFaculty, pageSize, pageNum));

            model.addAttribute("pageCount", userService.getUserPageCount(searchUserByFaculty, pageSize));
        } else {
            model.addAttribute("users", userService.selectUsersByUser(null, pageSize, pageNum));
            model.addAttribute("pageCount", userService.getUserPageCount(null, pageSize));
        }

        model.addAttribute("pageNextNum", pageNum + 1);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);
        return "/m_manage_userManage";
    }

    /**
     * 修改学生信息
     * @param userInModel
     * @return
     */
    @PostMapping("editUser")
    public String editUser(UserInModel userInModel) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        int flag = userService.editUser(userInModel, userInfoUtils.getLoginCode());
        if (flag < 4) {
            return "/error";
        }
        return "/m_manage_userManage";
    }

    /**
     * 添加用户信息
     * @param userInModel
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("addUser")
    public String addUser(UserInModel userInModel) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        int flag = userService.addUser(userInModel, userInfoUtils.getLoginCode());
        if (flag < 4) {
            return "/error";
        }
        return "/m_manage_userManage";
    }

    /**
     * 初始化用户密码
     * @param loginCode
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("initPassword/{loginCode}")
    @ResponseBody
    public String initPassword(@PathVariable("loginCode") String loginCode) {
        int flag = userService.initPassword(loginCode);
        return null;
    }
}
