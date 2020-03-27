package com.education.system_edu.controller.questionaier;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.CourseSearchInsert;
import com.education.system_edu.pojo.insert.SearchQuestionnaireInsert;
import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.pojo.output.CourseSearchOutput;
import com.education.system_edu.pojo.output.QuestionnaireOutput;
import com.education.system_edu.service.QuestionnaireService;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.value.PageValue;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @PostMapping("addq")
    public String addq(String msg, String qAndAss) {
        SubjectUtils result = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) result.getPrincipal();
        questionnaireService.addAQuestionnaire(msg, qAndAss,user.getLoginCode());
        //questionnaireService.addAQuestionnaire(msg, qAndAss,"2000000000");
        return "/m_manage_questionnaire_qm";
    }

    /**
     * 课程查看界面
     *
     * @param model
     * @return
     */
   // @RequiresRoles({"manager"})
    @RequestMapping("/m_manage_questionnaire_qm")
    public String m_manage_course_course(Model model) {
        SearchQuestionnaireInsert searchQuestionnaireInsert = new SearchQuestionnaireInsert();
        searchQuestionnaireInsert.init();
        return searchQuestionnaireJump(model,searchQuestionnaireInsert);
    }
    /**
     * 查询课程 一页
     * @param searchQuestionnaireInsert
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("searchCourse/{pageNum}/{pageSize}")
    public String searchCourse(SearchQuestionnaireInsert searchQuestionnaireInsert,
                               Model model,
                               @PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize) {
        searchQuestionnaireInsert.setPageSize(pageSize);
        searchQuestionnaireInsert.setPageNum(pageNum);
        return searchQuestionnaireJump(model,searchQuestionnaireInsert);
    }



    public String searchQuestionnaireJump(Model model,SearchQuestionnaireInsert searchQuestionnaireInsert){
        List<QuestionnaireOutput> questionnaireOutputs = questionnaireService.searchCourseBySearchQuestionnaireInsert(searchQuestionnaireInsert);
        model.addAttribute("questionnaireOutputs",questionnaireOutputs);
        model.addAttribute("SearchQuestionnaireInsert",searchQuestionnaireInsert);
        PageMsg page = PageUtils.madePageMsg(searchQuestionnaireInsert.getPageNum(), searchQuestionnaireInsert.getPageSize(),
                                             questionnaireService.countCourseByCourseSearchInsert(searchQuestionnaireInsert, PageValue.PAGE_SIZE));
        if (!PageUtils.sendPageMsgToModel(model,page)){
            return "/error";
        }
        return "/m_manage_questionnaire_qm";
    }
}
