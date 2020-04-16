package com.education.system_edu.controller.questionaier;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.CourseSearchInsert;
import com.education.system_edu.pojo.insert.QuestionnaireInsetToSend;
import com.education.system_edu.pojo.insert.SearchQuestionnaireInsert;
import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.pojo.output.CourseSearchOutput;
import com.education.system_edu.pojo.output.QuestionnaireHistoryOutput;
import com.education.system_edu.pojo.output.QuestionnaireOutput;
import com.education.system_edu.pojo.output.UserToSubmitQuestionnairePageOutput;
import com.education.system_edu.service.QuestionnaireService;
import com.education.system_edu.utils.PageUtils;
import com.education.system_edu.utils.SubjectUtils;
import com.education.system_edu.utils.value.PageValue;
import org.apache.ibatis.jdbc.Null;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

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
        questionnaireService.addAQuestionnaire(msg, qAndAss, user.getLoginCode());
        //questionnaireService.addAQuestionnaire(msg, qAndAss,"2000000000");
        return "/m_manage_questionnaire_qm";
    }

    /**
     * 课程查看界面
     *
     * @param model
     * @return
     */
    @RequiresRoles({"manager"})
    @RequestMapping("/m_manage_questionnaire_qm")
    public String m_manage_course_course(Model model,@RequestParam(required = false) String msg) {
        SearchQuestionnaireInsert searchQuestionnaireInsert = new SearchQuestionnaireInsert();
        searchQuestionnaireInsert.init();
        model.addAttribute("msg",msg);
        return searchQuestionnaireJump(model, searchQuestionnaireInsert);
    }

    /**
     * 查询课程 一页
     *
     * @param searchQuestionnaireInsert
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles({"manager"})
    @PostMapping("/searchCourse/{pageNum}/{pageSize}")
    public String searchCourse(SearchQuestionnaireInsert searchQuestionnaireInsert,
                               Model model,
                               @PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize) {
        searchQuestionnaireInsert.setPageSize(pageSize);
        searchQuestionnaireInsert.setPageNum(pageNum);
        return searchQuestionnaireJump(model, searchQuestionnaireInsert);
    }


    @PostMapping("/sendQuestionnaire")
    public ModelAndView sendAnQuestionnaireModeltTo(QuestionnaireInsetToSend questionnaireInsetToSend) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/questionaier/m_manage_questionnaire_qm"));
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User  user = (User) subjectUtils.getPrincipal();
        String msg = questionnaireService.sendQuestionnaire(questionnaireInsetToSend,user.getLoginCode());
        return modelAndView;
    }

    @GetMapping("/see/{questionnaireCode}")
    public ModelAndView seeQuestionnaire(@PathVariable String questionnaireCode) {
        ModelAndView modelAndView = new ModelAndView("/see_questionnaire");
        modelAndView.addObject("questionnaireData",
                               questionnaireService.getAQuestionnaireByQuestionnaireCode(questionnaireCode));
        return modelAndView;
    }

    @PostMapping("/submitQuestionnaire")
    public ModelAndView submitQuestionnaire(@RequestParam Map<String, Object> map) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/questionaier/m_manage_questionnaire_qm"));
        if(!map.get("assignmentCode").equals("")){
            modelAndView.addObject("msg","提交成功");
        }else{
            modelAndView.addObject("msg","提交问卷未发布");
        }
        return modelAndView;
    }



    @RequestMapping("/studentQuestionnaire")
    public ModelAndView studentQuestionnaire(@RequestParam(required = false) String msg) {
        ModelAndView modelAndView = new ModelAndView("stu_questionnaire");
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        List<UserToSubmitQuestionnairePageOutput> qs = questionnaireService.getUserToSubmitQuestionnaireMSG(user.getLoginCode());
        List<QuestionnaireHistoryOutput> qsHis = questionnaireService.getQuestionnaireHistory(user.getLoginCode());

        modelAndView.addObject("questionnaireMSGs",qs);
        modelAndView.addObject("questionnaireHistoryMSGs",qsHis);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @GetMapping("/stuSee/{questionnaireCode}/{sendCode}")
    public ModelAndView stuSeeQuestionnaire(@PathVariable String questionnaireCode, @PathVariable String sendCode) {
        ModelAndView modelAndView = new ModelAndView("/stuSee_questionnaire");
        modelAndView.addObject("questionnaireData",
                               questionnaireService.getAQuestionnaireByQuestionnaireCode(questionnaireCode));
        modelAndView.addObject("sendCode",
                               sendCode);
        return modelAndView;
    }

    @PostMapping("/stuSubmitQuestionnaire")
    public ModelAndView stuSubmitQuestionnaire(@RequestParam Map<String, Object> map) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/questionaier/studentQuestionnaire"));
        SubjectUtils subjectUtils = new SubjectUtils(SecurityUtils.getSubject());
        User user = (User) subjectUtils.getPrincipal();
        if(!map.get("assignmentCode").equals("")){
            modelAndView.addObject("msg",questionnaireService.submitQueationnaire(user.getLoginCode(),map));
        }else{
            modelAndView.addObject("msg","提交问卷未发布");
        }
        return modelAndView;
    }

    public String searchQuestionnaireJump(Model model, SearchQuestionnaireInsert searchQuestionnaireInsert) {
        List<QuestionnaireOutput> questionnaireOutputs = questionnaireService.searchCourseBySearchQuestionnaireInsert(searchQuestionnaireInsert);
        model.addAttribute("questionnaireOutputs", questionnaireOutputs);
        model.addAttribute("searchQuestionnaireInsert", searchQuestionnaireInsert);
        PageMsg page = PageUtils.madePageMsg(searchQuestionnaireInsert.getPageNum(), searchQuestionnaireInsert.getPageSize(),
                                             questionnaireService.countCourseByCourseSearchInsert(searchQuestionnaireInsert, PageValue.PAGE_SIZE));
        if (!PageUtils.sendPageMsgToModel(model, page)) {
            return "/error";
        }
        return "/m_manage_questionnaire_qm";
    }
}
