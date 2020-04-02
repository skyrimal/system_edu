package com.education.system_edu.pojo.model;

import com.education.system_edu.utils.value.PageValue;

public class Page {
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public void init(){
        setPageNum(1);
        setPageSize(PageValue.PAGE_SIZE);
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
