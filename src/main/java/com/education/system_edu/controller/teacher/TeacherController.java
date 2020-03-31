package com.education.system_edu.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月31日 11:22
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {

    @GetMapping("course")
    public List<String> getTeachersCourse(){

        return null;
    }
}
