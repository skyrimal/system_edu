package com.education.system_edu.pojo.output;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月30日 17:11
 */
public class CourseOutput {
    private String code;
    private String name;
    private String type;
    private String parentCode;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
