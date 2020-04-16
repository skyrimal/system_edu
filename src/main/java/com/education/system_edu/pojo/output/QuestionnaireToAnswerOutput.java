package com.education.system_edu.pojo.output;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月13日 9:39
 */
public class QuestionnaireToAnswerOutput {
    private String code;
    private String assignmentCode;
    private String title;
    private String abstractWords;
    private String type;
    private List<QuestionOutput> questionOutputs;

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractWords() {
        return abstractWords;
    }

    public void setAbstractWords(String abstractWords) {
        this.abstractWords = abstractWords;
    }

    public List<QuestionOutput> getQuestionOutputs() {
        return questionOutputs;
    }

    public void setQuestionOutputs(List<QuestionOutput> questionOutputs) {
        this.questionOutputs = questionOutputs;
    }
}
