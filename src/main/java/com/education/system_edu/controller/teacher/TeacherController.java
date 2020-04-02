package com.education.system_edu.controller.teacher;
import	java.util.List;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.TeacherSearchStudentInsert;
import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.pojo.output.CourseClassUserStudentOutPut;
import com.education.system_edu.pojo.output.TeacherCourseClassLineInfoOutput;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.value.PageValue;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
        return teacherSearchStudent(teacherSearchStudentInsert,courseClassCode);
    }
    @PostMapping("course/{courseClassCode}/{pageNum}/{pageSize}")
    public ModelAndView toJumpCourseClassPage(@PathVariable String courseClassCode,
                                              @PathVariable Integer pageSize,
                                              @PathVariable Integer pageNum,
                                              TeacherSearchStudentInsert teacherSearchStudentInsert) {

        teacherSearchStudentInsert.setPageNum(pageNum);
        teacherSearchStudentInsert.setPageSize(pageSize);
        teacherSearchStudentInsert.setCourseCode(courseClassCode);
        return teacherSearchStudent(teacherSearchStudentInsert,courseClassCode);
    }

    private ModelAndView teacherSearchStudent( TeacherSearchStudentInsert teacherSearchStudentInsert,String courseClassCode){
        ModelAndView modelAndView = new ModelAndView();
        List<CourseClassUserStudentOutPut> students = userService.getUserByTeacherSearchStudentInsert(teacherSearchStudentInsert,courseClassCode);
        modelAndView.addObject("CourseClassUserStudentOutPut", students);
        modelAndView.addObject("teacherSearchStudentInsert",teacherSearchStudentInsert);
        PageMsg page = PageUtils.madePageMsg(teacherSearchStudentInsert.getPageNum(), teacherSearchStudentInsert.getPageSize(),
                                             PageUtils.coutPageSize(userService.countCourseByCourseSearchInsert(teacherSearchStudentInsert, PageValue.PAGE_SIZE,courseClassCode),PageValue.PAGE_SIZE));
        modelAndView.addObject(PageValue.PAGE_MODEL_KEY, page);
        modelAndView.setViewName("t_course");
        return modelAndView;
    }
}
