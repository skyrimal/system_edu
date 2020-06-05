package com.education.system_edu.controller.student;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.output.CourseOutput;
import com.education.system_edu.pojo.output.HomMsgsAndTeanMsgs;
import com.education.system_edu.pojo.output.SignHistory;
import com.education.system_edu.service.CourseClassService;
import com.education.system_edu.service.HomeworkService;
import com.education.system_edu.service.StudentService;
import com.education.system_edu.utils.FileUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.UU3D;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月10日 10:44
 */
@Controller
@RequestMapping("student")
public class StudentController {

    StudentService studentService;

    CourseClassService courseClassService;

    HomeworkService homeworkService;

    @Autowired
    public void setHomeworkService(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @Autowired
    public void setCourseClassService(CourseClassService courseClassService) {
        this.courseClassService = courseClassService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("course/courseClass")
    @ResponseBody
    public List<CourseOutput> getLearningCourse() {
        List<CourseOutput> courseOutputlist = new ArrayList();
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        courseOutputlist = studentService.searchLearningCourse(user.getLoginCode());
        return courseOutputlist;
    }

    @RequestMapping("course/into/{courseClassCode}")
    public ModelAndView intoCourse(@PathVariable String courseClassCode) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();

        ModelAndView modelAndView = new ModelAndView("/stu_course");
        HomMsgsAndTeanMsgs msgs = new HomMsgsAndTeanMsgs();
        try {
            msgs = courseClassService.getHomworkMSGsAndTeamMSGs(courseClassCode, user.getLoginCode());
        } catch (ParseException e) {
            modelAndView.setViewName("error");
            e.printStackTrace();
        }
        modelAndView.addObject("homeworkMSGs", msgs.getHomworkMsgs());
        modelAndView.addObject("teamMSGs", msgs.getTeamMsgs());
        return modelAndView;
    }

    @PostMapping("course/upHomework")
    public ModelAndView upHomework(String context, String homeworkCode,
                                   @RequestParam(value = "loadFile", required = false) MultipartFile[] file) {
        ModelAndView modelAndView = new ModelAndView("/stu_course");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        String fileName = UU3D.uu3d();
        if (file.length != 0) {
            if (!file[0].getOriginalFilename().equals("")) {
                FileUtils.approvalFile(file[0], fileName);
            }
        }
        int flag = homeworkService.studentSubmitHomwork(context, homeworkCode, fileName, user.getLoginCode());
        String msg = "";
        if (flag>0){
            msg = "成功";
        }else{
            msg = "失败";
        }
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    @RequiresRoles({"student"})
    @RequestMapping("stu_sign")
    public ModelAndView stu_sign(@ModelAttribute("msg") String msg) {
        ModelAndView modelAndView = new ModelAndView("/stu_sign");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("msgHistorys", studentService.getSignHistory(user.getLoginCode()));
        return modelAndView;
    }

    @GetMapping("/course/sign")
    public ModelAndView sign(String signCode) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        Map<String, String> msg = new HashMap<>();
        msg.put("msg", courseClassService.studentSign(signCode, user.getLoginCode()));
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/student/stu_sign"), msg);
        return modelAndView;
    }
}
