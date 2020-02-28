package com.education.system_edu.controller.manage;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manage")
public class UserController {

    @RequiresRoles({"user", "manager"})
    @RequestMapping("userManage")
    public String userManageMain(){
        return "/m_manage_userManage";
    }
}
