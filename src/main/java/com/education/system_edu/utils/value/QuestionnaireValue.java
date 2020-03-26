package com.education.system_edu.utils.value;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月25日 11:50
 */
public class QuestionnaireValue {
    public static final short TEST = 2;
    public static final short QUESTIONNAIRE = 1;

    public static final short RADIO =1;
    public static final short CHECKBOX = 2;
    public static final short TEXT = 3;
    public static final short FILE = 4;
    public static final short TITLE = 5;


    public static short getType(String strType){
        switch(strType.trim()){
            case "【单选】":
                return RADIO;
            case "【多选】":
                return CHECKBOX;
            case "【问答】":
                return TEXT;
            case "【矩阵】":
                return FILE;
            case "TITLE":
                return TITLE;
            default:
                return (short)0;
        }
    }
}
