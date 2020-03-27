package com.education.system_edu.pojo.insert;

import com.education.system_edu.utils.value.PageValue;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月26日 9:19
 */
public class SearchQuestionnaireInsert {
    private String code;
    private String keyword;
    private String type;
    private Integer pageNum;
    private Integer pageSize;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SearchQuestionnaireInsert() {
    }
    public void init(){
        setPageNum(1);
        setPageSize(PageValue.PAGE_SIZE);
    }
}
