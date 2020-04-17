package com.education.system_edu.controller;

import com.education.system_edu.pojo.User;
import com.education.system_edu.utils.ImgMaker;
import com.education.system_edu.utils.SubjectUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;

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
    @RequiresRoles({"manager"})
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
    @RequiresRoles({"student"})
    @RequestMapping("stu_course")
    public String stu_course() {
        return "/stu_course";
    }

    @RequiresRoles({"student"})
    @RequestMapping("stu_main")
    public String stu_main() {
        return "/stu_main";
    }

    @RequiresRoles({"student"})
    @RequestMapping("stu_message")
    public String stu_message() {
        return "/stu_message";
    }


    /**
     * *********************************************************************
     * *********************************************************************
     * *********************************************************************
     * 老师
     * *********************************************************************
     * *********************************************************************
     */
    @RequiresRoles({"teacher"})
    @RequestMapping("t_course")
    public String t_course() {
        return "/t_course";
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_main")
    public ModelAndView t_main() {
        ModelAndView modelAndView = new ModelAndView("/t_main");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();

        return modelAndView;
    }

    @RequestMapping("error/error")
    public ModelAndView error(@RequestParam(required = false) String msg) {
        ModelAndView modelAndView = new ModelAndView("/error");
        if (msg != null) {
            modelAndView.addObject("msg", msg);
        }else{
            modelAndView.addObject("msg", "访问出错");
        }
        return modelAndView;
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_message")
    public String t_message() {
        return "/t_message";
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_questionnaire")
    public String t_questionnaire() {
        return "/t_questionnaire";
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_sign")
    public String t_sign() {
        return "/t_sign";
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_tesk")
    public String t_tesk() {
        return "/t_tesk";
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

    /**
     * 下载文件
     *
     * @param request
     * @param response
     */
    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        String path = "D:\\file";
        //下载
        try (InputStream inputStream = new FileInputStream(new File(path, fileName));
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
