package com.education.system_edu.controller;

import com.education.system_edu.utils.ImgMaker;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class AllApiController {


    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/model")
    public String model() {
        return "/model";
    }

    @RequestMapping("/new_file")
    public String new_file() {
        return "/new_file";
    }

    @RequiresRoles({"user"})
    @RequestMapping("/person_info")
    public String person_info() {
        return "/person_info";
    }


    @RequestMapping("/apis")
    public String apis() {
        return "/apis";
    }

    /**
     * *********************************************************************
     * *********************************************************************
     * *********************************************************************
     * 管理员
     * *********************************************************************
     * *********************************************************************
     */
    @RequiresRoles({"user", "manager"})
    @RequestMapping("m_main")
    public String m_main() {
        return "/m_main";
    }
    /**
     * *********************************************************************
     * *********************************************************************
     * *********************************************************************
     * 学生
     * *********************************************************************
     * *********************************************************************
     */
    @RequiresRoles({"user", "student"})
    @RequestMapping("stu_course")
    public String stu_course() {
        return "/stu_course";
    }

    @RequiresRoles({"user", "student"})
    @RequestMapping("stu_main")
    public String stu_main() {
        return "/stu_main";
    }

    @RequiresRoles({"user", "student"})
    @RequestMapping("stu_message")
    public String stu_message() {
        return "/stu_message";
    }

    @RequiresRoles({"user", "student"})
    @RequestMapping("stu_sign")
    public String stu_sign() {
        return "/stu_sign";
    }

    /**
     * *********************************************************************
     * *********************************************************************
     * *********************************************************************
     * 老师
     * *********************************************************************
     * *********************************************************************
     */
    @RequiresRoles({"user", "teacher"})
    @RequestMapping("t_course")
    public String t_course() {
        return "/t_course";
    }

    @RequiresRoles({"user", "teacher"})
    @RequestMapping("t_main")
    public String t_main() {
        return "/t_main";
    }

    @RequiresRoles({"user", "teacher"})
    @RequestMapping("t_message")
    public String t_message() {
        return "/t_message";
    }

    @RequiresRoles({"user", "teacher"})
    @RequestMapping("t_questionnaire")
    public String t_questionnaire() {
        return "/t_questionnaire";
    }

    @RequiresRoles({"user", "teacher"})
    @RequestMapping("t_sign")
    public String t_sign() {
        return "/t_sign";
    }

    @RequiresRoles({"user", "teacher"})
    @RequestMapping("t_tesk")
    public String t_tesk() {
        return "/t_tesk";
    }

    @RequiresRoles({"user", "teacher"})
    @RequestMapping("addQuwstionaier")
    public String addQuwstionaier() {
        return "add_questionaire";
    }


    /**
     * 验证码生成
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("getVerifiCode")
    @ResponseBody
    public void getVerifiCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
             1.生成验证码
             2.把验证码上的文本存在session中
             3.把验证码图片发送给客户端
             */
        ImgMaker ivc = new ImgMaker();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = ivc.getImage();  //获取验证码
        request.getSession().setAttribute("verificationCode", ivc.getText()); //将验证码的文本存在session中
        ivc.output(image, response.getOutputStream());//将验证码图片响应给客户端
    }


}