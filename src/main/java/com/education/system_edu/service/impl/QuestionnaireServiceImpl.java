package com.education.system_edu.service.impl;
import	java.util.ArrayList;

import com.education.system_edu.mapper.SysModelQuestionnaireQuestionOptionRepositoryMapper;
import com.education.system_edu.mapper.SysModelQuestionnaireQuestionRepositoryMapper;
import com.education.system_edu.mapper.SysModelQuestionnaireRepositoryMapper;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionOptionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireRepositoryExample;
import com.education.system_edu.pojo.insert.SearchQuestionnaireInsert;
import com.education.system_edu.pojo.output.QuestionnaireOutput;
import com.education.system_edu.service.QuestionnaireService;
import com.education.system_edu.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Resource
    SysModelQuestionnaireRepositoryMapper questionnaireRepositoryMapper;

    @Resource
    SysModelQuestionnaireQuestionRepositoryMapper questionRepositoryMapper;

    @Resource
    SysModelQuestionnaireQuestionOptionRepositoryMapper optionRepositoryMapper;

    @Override
    public Integer addAQuestionnaire(String msg, String qAndAs, String loginCode) {
        JsonUtils jsonUtils = new JsonUtils();
        QuestionnaireFactory questionnaireFactory = new QuestionnaireFactory();
        questionnaireFactory.init(qAndAs, msg,loginCode);
        SysModelQuestionnaireRepository questionnaire =
                questionnaireFactory.releaseQuestionnaireWithCreateAndUpdateMsg();
        questionnaireRepositoryMapper.insert(questionnaire);

        List<SysModelQuestionnaireQuestionRepository> questions = questionnaireFactory.releaseQuestion();
        for (SysModelQuestionnaireQuestionRepository repository:
        questions) {

            questionRepositoryMapper.insert(repository);
        }

        List<List<SysModelQuestionnaireQuestionOptionRepository>> optionses = questionnaireFactory.releaseOptionses();
        for (List<SysModelQuestionnaireQuestionOptionRepository> list:
                optionses) {
            for (SysModelQuestionnaireQuestionOptionRepository repository:
            list) {
                optionRepositoryMapper.insert(repository);
            }
        }

        return null;
    }

    @Override
    public List<QuestionnaireOutput> searchCourseBySearchQuestionnaireInsert(SearchQuestionnaireInsert searchQuestionnaireInsert) {
        List<QuestionnaireOutput> result = questionnaireRepositoryMapper.selectBySearchQuestionnaireInsert(searchQuestionnaireInsert);
        List<QuestionnaireOutput> _result = new ArrayList<> ();
        String type = "";
        for (QuestionnaireOutput output :result){
            type = StringUtils.outPre(output.getTitle(),"#type#");
            output.setType(type);
            output.setTitle(StringUtils.outLast(output.getTitle(),"#type#"));
            _result.add(output);
        }
        return _result;
    }

    @Override
    public Integer countCourseByCourseSearchInsert(SearchQuestionnaireInsert searchQuestionnaireInsert, Integer pageSize) {
        int i = questionnaireRepositoryMapper.countBySearchQuestionnaireInsert(searchQuestionnaireInsert);
        return PageUtils.coutPageSize(i,pageSize);
    }
}
