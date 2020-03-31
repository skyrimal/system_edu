package com.education.system_edu.controller;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;
import com.education.system_edu.pojo.output.OutputUserForEditUserAction;
import com.education.system_edu.service.PageService;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.MsgUtil;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.UserInfoUtils;
import com.education.system_edu.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

/**
 * 后端进行分析，
 * 由前端进行判断后页面进行跳转
 * 负责与user增删改查相关功能
 */
@Controller()
@RequestMapping("/user")
public class UserController {

    PageService pageService;
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    /**
     * 判断用户信息是否正确
     *
     * @param loginUsername
     * @param loginPassword
     * @param verificationCode
     * @param httpSession
     * @return
     */
    @RequiresGuest
    @PostMapping("/login")
    @ResponseBody
    public String checkUser(@RequestParam("loginUsername") String loginUsername,
                            @RequestParam("loginPassword") String loginPassword,
                            @RequestParam("verificationCode") String verificationCode,
                            Model model,
                            HttpSession httpSession) {
        String str = (String) httpSession.getAttribute("verificationCode");
        //验证验证码，计划后期改到拦截器上
//        if (verificationCode.toLowerCase().equals(str.toLowerCase())) {
        if (true) {
            //清除httpSession保存的验证码
            httpSession.removeAttribute("verificationCode");
            //1.获取subject
            Subject shiroSubject = SecurityUtils.getSubject();
            //2.判断subject是否被认证
            if (!shiroSubject.isAuthenticated()) {
                //判断用户名、密码是否正确
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginUsername, loginPassword);
                usernamePasswordToken.setRememberMe(true);
                //User user = RandomStudentMaker.madeAStudent();
                //3.登录
                shiroSubject.login(usernamePasswordToken);
                System.out.println("是否登录成功==》" + shiroSubject.isAuthenticated());
                //4.控制跳转页面
                UserExample userForSearch = new UserExample();
                userForSearch.createCriteria().andLoginCodeEqualTo(loginUsername);
                User user = pageService.findUser(userForSearch);
                model.addAttribute("user_name", user.getUserName());
                System.out.println("跳转的主页面" + PageUtils.findPageByUserType(user.getUserType(), "main"));
                return PageUtils.findPageByUserType(user.getUserType(), "main");
            } else {
                UserExample userForSearch = new UserExample();
                userForSearch.createCriteria().andLoginCodeEqualTo(loginUsername);
                User user = pageService.findUser(userForSearch);
                return PageUtils.findPageByUserType(user.getUserType(), "main");
            }

        }
        return "false";
    }

    /**
     * 用户修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @param httpSession
     * @param modelAndView
     * @return
     */
    @RequiresAuthentication
    @PostMapping("/edit/password")
    public ModelAndView changePassword(@RequestParam("oldPassword") String oldPassword,
                                       @RequestParam("newPassword") String newPassword,
                                       HttpSession httpSession,
                                       ModelAndView modelAndView) {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        String loginCode = userInfoUtils.getLoginCode();
        boolean flag = userService.updatePassword(loginCode, oldPassword, newPassword);
        httpSession.setAttribute("msg", MsgUtil.addMsj(flag));
        modelAndView.setViewName("redirect:/user/rewrite_password");
        return modelAndView;

    }

    /**
     * HttpSession当作临时线程储存使用
     *
     * @param model
     * @param httpSession
     * @return
     */
    @RequiresGuest
    @RequestMapping("/rewrite_password")
    public String rewrite_password(Model model, HttpSession httpSession) {
        model.addAttribute("msg", httpSession.getAttribute("msg"));
        httpSession.removeAttribute("msg");
        return "/rewrite_password";
    }

    /**
     * 显示用户基础信息 -- 用户名和用户类型
     *
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/user_message")
    @ResponseBody
    public Map<String, String> user() {
        UserInfoUtils userInfoUtils = new UserInfoUtils(SecurityUtils.getSubject());
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(userInfoUtils.getLoginCode());
        return UserUtils.userForLeftBar(pageService.findUser(userForSearch));
    }

    /**
     * 显示用户基础信息 -- 用户名和用户类型
     *
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/user_message/{loginCode}")
    @ResponseBody
    public OutputUserForEditUserAction user(@PathVariable("loginCode") String loginCode) {
        return userService.getOutputUserForEditUserActionBy(loginCode);
    }
}
