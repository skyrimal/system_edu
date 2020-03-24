package com.education.system_edu.controller.questionaier;

import com.education.system_edu.pojo.insert.QuestionnaireInsert;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("questionaier")
public class QuestionnaireController {
    @RequiresRoles({"manager"})
    @RequestMapping("addqqq")
    public String addQuwstionaier() {
        return "/addqqq";
    }


    @RequiresRoles({"manager"})
    @RequestMapping("m_manage_questionnaire_qm")
    public String m_manage_questionnaire_qm() {
        return "/m_manage_questionnaire_qm";
    }


    @RequiresRoles({"manager"})
    @PostMapping("addq")
    public String addq(String q, String as) {

        return "/m_manage_questionnaire_qm";
    }


}
