package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.SysModelQuestionnaireQuestionOptionRepositoryMapper;
import com.education.system_edu.mapper.SysModelQuestionnaireQuestionRepositoryMapper;
import com.education.system_edu.mapper.SysModelQuestionnaireRepositoryMapper;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionOptionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireQuestionRepository;
import com.education.system_edu.pojo.SysModelQuestionnaireRepository;
import com.education.system_edu.service.QuestionnaireService;
import com.education.system_edu.utils.JsonUtils;
import com.education.system_edu.utils.QuestionnaireFactory;
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
}
