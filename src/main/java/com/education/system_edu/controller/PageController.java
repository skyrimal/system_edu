package com.education.system_edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PageController {
    @GetMapping("/success/main")
    public String toMain(){

        System.out.println("登录成功后");
        return "m_main";
    }
}
