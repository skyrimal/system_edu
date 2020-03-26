package com.education.system_edu.pojo.insert;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月25日 11:01
 */

public class QuestionnaireMsgInsert {
    private String titleName;
    private String astractWord;
    private String qType;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getAstractWord() {
        return astractWord;
    }

    public void setAstractWord(String astractWord) {
        this.astractWord = astractWord;
    }

    public String getqType() {
        return qType;
    }

    public void setqType(String qType) {
        this.qType = qType;
    }
}
