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
import com.education.system_edu.pojo.output.CourseClassTeamOutput;
import com.education.system_edu.pojo.output.CourseClassUserStudentOutPut;
import com.education.system_edu.pojo.output.TeacherCourseClassLineInfoOutput;
import com.education.system_edu.service.CourseClassService;
import com.education.system_edu.service.HomeworkService;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.FileUtils;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.UU3D;
import com.education.system_edu.utils.value.PageValue;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    ClassPublishAssignmentActionMapper classPublishAssignmentActionMapper;

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

    @GetMapping("course")
    @ResponseBody
    public List<TeacherCourseClassLineInfoOutput> getTeachersCourse() {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        return majorService.getTeacherCourse(user.getLoginCode());
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

    private ModelAndView teacherSearchStudent(TeacherSearchStudentInsert teacherSearchStudentInsert, String courseClassCode) {
        ModelAndView modelAndView = new ModelAndView();
        List<CourseClassUserStudentOutPut> students = userService.getUserByTeacherSearchStudentInsert(teacherSearchStudentInsert, courseClassCode);
        modelAndView.addObject("CourseClassUserStudentOutPut", students);
        modelAndView.addObject("teacherSearchStudentInsert", teacherSearchStudentInsert);
        PageMsg page = PageUtils.madePageMsg(teacherSearchStudentInsert.getPageNum(), teacherSearchStudentInsert.getPageSize(),
                                             PageUtils.coutPageSize(userService.countCourseByCourseSearchInsert(teacherSearchStudentInsert, PageValue.PAGE_SIZE, courseClassCode), PageValue.PAGE_SIZE));
        modelAndView.addObject(PageValue.PAGE_MODEL_KEY, page);
        modelAndView.setViewName("t_course");
        return modelAndView;
    }

    @PostMapping("homework/sendHomwork")
    public String sendHomework(HomeworkModelInsert homeworkModel,
                               @RequestParam(value = "loadFile", required = false) MultipartFile[] file) {
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        homeworkModel.setFile(homeworkModel.getClassCode()
                                      + ",.," + (classPublishAssignmentActionMapper.countByExample(new ClassPublishAssignmentActionExample()) + 1)
                                      + ",.," + UU3D.uu3d());
        if (file.length != 0) {
            FileUtils.approvalFile(file[0], homeworkModel.getFile());
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
}
