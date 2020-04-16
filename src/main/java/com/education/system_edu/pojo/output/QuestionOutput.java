package com.education.system_edu.pojo.output;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月13日 9:43
 */
public class QuestionOutput {
    private String code;
    private String no;
    private String title;
    private String score;
    private String type;
    private List<AnswerOutput> answerOutputs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AnswerOutput> getAnswerOutputs() {
        return answerOutputs;
    }

    public void setAnswerOutputs(List<AnswerOutput> answerOutputs) {
        this.answerOutputs = answerOutputs;
    }
}
