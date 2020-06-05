package com.education.system_edu.controller.teacher;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import ch.qos.logback.core.util.FileUtil;
import com.education.system_edu.mapper.ClassPublishAssignmentActionMapper;
import com.education.system_edu.pojo.ClassPublishAssignmentActionExample;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.HomeworkModelInsert;
import com.education.system_edu.pojo.insert.TeacherSearchStudentInsert;
import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.pojo.output.*;
import com.education.system_edu.service.*;
import com.education.system_edu.utils.FileUtils;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.UU3D;
import com.education.system_edu.utils.value.PageValue;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月31日 11:22
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    MajorService majorService;

    UserService userService;

    CourseClassService courseClassService;

    HomeworkService homeworkService;

    MSGService msgService;
    @Resource
    ClassPublishAssignmentActionMapper classPublishAssignmentActionMapper;

    @Autowired
    public void setMsgService(MSGService msgService) {
        this.msgService = msgService;
    }

    @Autowired
    public void setCourseClassService(CourseClassService courseClassService) {
        this.courseClassService = courseClassService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setHomeworkService(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_main")
    public ModelAndView t_main() {
        ModelAndView modelAndView = new ModelAndView("/t_main");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        modelAndView.addObject("mainMSGs", msgService.getTeacherMainMSG(user.getLoginCode()));
        return modelAndView;
    }

    @GetMapping("course")
    @ResponseBody
    public List<TeacherCourseClassLineInfoOutput> getTeachersCourse() {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        List<TeacherCourseClassLineInfoOutput> teacherCourseClassLineInfoOutputs = majorService.getTeacherCourse(user.getLoginCode());
        return teacherCourseClassLineInfoOutputs;
    }

    @GetMapping("course/{courseClassCode}")
    public ModelAndView toCourseClassPage(@PathVariable String courseClassCode) {
        TeacherSearchStudentInsert teacherSearchStudentInsert = new TeacherSearchStudentInsert();
        teacherSearchStudentInsert.init();
        teacherSearchStudentInsert.setCourseCode(courseClassCode);
        return teacherSearchStudent(teacherSearchStudentInsert, courseClassCode);
    }

    @PostMapping("course/{courseClassCode}/{pageNum}/{pageSize}")
    public ModelAndView toJumpCourseClassPage(@PathVariable String courseClassCode,
                                              @PathVariable Integer pageSize,
                                              @PathVariable Integer pageNum,
                                              TeacherSearchStudentInsert teacherSearchStudentInsert) {

        teacherSearchStudentInsert.setPageNum(pageNum);
        teacherSearchStudentInsert.setPageSize(pageSize);
        teacherSearchStudentInsert.setCourseCode(courseClassCode);
        return teacherSearchStudent(teacherSearchStudentInsert, courseClassCode);
    }

    @PostMapping("made_team/{courseClassCode}")
    public String madeTeam(Integer memberNum, @PathVariable String courseClassCode) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User studentLoginning = (User) subjectUtils.getPrincipal();
        int flag = courseClassService.madeTeam(courseClassCode, memberNum, studentLoginning.getLoginCode());
        return "redirect:/teacher/course/" + courseClassCode;
    }

    @GetMapping("courseTeam/{courseClassCode}")
    public String getCourseClassTeam(@PathVariable String courseClassCode) {
        List<CourseClassTeamOutput> teams = courseClassService.getCourseClassTeamByCourseClassCode(courseClassCode);
        return null;
    }

    @PostMapping("homework/sendHomwork")
    public String sendHomework(HomeworkModelInsert homeworkModel,
                               @RequestParam(value = "loadFile", required = false) MultipartFile[] file) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        if (file.length != 0) {
            if (!file[0].getOriginalFilename().equals("")) {
                homeworkModel.setFile(UU3D.uu3d());
                FileUtils.approvalFile(file[0], homeworkModel.getFile());
            }
        }
        int flag = homeworkService.sendHomwork(homeworkModel, user.getLoginCode());
        return "redirect:/teacher/course/" + homeworkModel.getClassCode();
    }

    @GetMapping("madeSign/{classCode}")
    @ResponseBody
    public String madeSign(@PathVariable String classCode) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        return homeworkService.madeSign(classCode, user.getLoginCode());
    }


    @GetMapping("homework/getHomework")
    @ResponseBody
    public List<HomeworkOutput> getHomework() {

        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        List<HomeworkOutput> homeworkOutputlist = homeworkService.getHomework(user.getLoginCode());
        return homeworkOutputlist;

    }


    @GetMapping("/correctHomeworkInfo/{assignmentCode}")
    @ResponseBody
    public List<StudentSubmitHomeworkMSG> correctHomework(@PathVariable String assignmentCode) {
        List<StudentSubmitHomeworkMSG> studentSubmitHomeworkMSGS = homeworkService.getHomeworkInfo(assignmentCode);
        return studentSubmitHomeworkMSGS;
    }


    @GetMapping("/homework/correctHomework")
    @ResponseBody
    public String correctHomework(String submitCode, String finalScore) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        String msg = homeworkService.correctHomework(submitCode, finalScore, user.getLoginCode());
        return msg;
    }

    @RequiresRoles({"teacher"})
    @RequestMapping("t_sign")
    public ModelAndView t_sign(@RequestParam(required = false) String msg) {
        ModelAndView modelAndView = new ModelAndView("/t_sign");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        List<StudentSignInfo> studentSignInfos = courseClassService.getStudentsSignInfo(user.getLoginCode());
        SignPageMsg pageMsg = courseClassService.getPageMsg(user.getLoginCode());
        if (msg == null) {
            msg = courseClassService.getMsg(user.getLoginCode());
        }
        pageMsg.setMsg(msg);
        modelAndView.addObject("studentSignInfos", studentSignInfos);
        modelAndView.addObject("pageMsg", pageMsg);
        return modelAndView;
    }

    @PostMapping("/checkSignInfo")
    public ModelAndView checkSignInfo(@RequestParam Map<String, String> map) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/teacher/t_sign");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        String msg = courseClassService.checkSignInfo(map, user.getLoginCode());
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    private ModelAndView teacherSearchStudent(TeacherSearchStudentInsert teacherSearchStudentInsert, String courseClassCode) {
        ModelAndView modelAndView = new ModelAndView();
        List<CourseClassUserStudentOutPut> students = userService.getUserByTeacherSearchStudentInsert(teacherSearchStudentInsert, courseClassCode);
        modelAndView.addObject("CourseClassUserStudentOutPut", students);
        modelAndView.addObject("teacherSearchStudentInsert", teacherSearchStudentInsert);
        PageMsg page = PageUtils.madePageMsg(teacherSearchStudentInsert.getPageNum(), teacherSearchStudentInsert.getPageSize(),
                                             PageUtils.coutPageSize(userService.countCourseByCourseSearchInsert(teacherSearchStudentInsert, PageValue.PAGE_SIZE, courseClassCode), PageValue.PAGE_SIZE));
        modelAndView.addObject("historys", null);
        modelAndView.addObject(PageValue.PAGE_MODEL_KEY, page);
        modelAndView.setViewName("t_course");
        return modelAndView;
    }


}
