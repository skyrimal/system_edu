package com.education.system_edu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JumpController {
    @RequestMapping("test")
    public String testJump(){
        return "成功将数据返回";
    }
}
