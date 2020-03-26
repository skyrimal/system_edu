package com.education.system_edu.controller.questionaier;

import com.education.system_edu.pojo.User;
import com.education.system_edu.service.QuestionnaireService;
import com.education.system_edu.utils.SubjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("questionaier")
public class QuestionnaireController {
    QuestionnaireService questionnaireService;

    @Autowired
    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }


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
    public String addq(String msg, String qAndAss) {
        SubjectUtils result = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) result.getPrincipal();
        questionnaireService.addAQuestionnaire(msg, qAndAss,user.getLoginCode());
        //questionnaireService.addAQuestionnaire(msg, qAndAss,"2000000000");
        return "/m_manage_questionnaire_qm";
    }


}
