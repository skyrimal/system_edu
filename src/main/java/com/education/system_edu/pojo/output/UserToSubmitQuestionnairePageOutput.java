package com.education.system_edu.pojo.output;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月15日 9:44
 */
public class UserToSubmitQuestionnairePageOutput {
    private String code;
    private String questionCode;
    private String title;
    private String endTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
