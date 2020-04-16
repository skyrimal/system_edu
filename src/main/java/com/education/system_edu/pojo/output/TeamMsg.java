package com.education.system_edu.pojo.output;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月11日 13:00
 */
public class TeamMsg {
    private String teamNo;
    private String stuName;
    private String stuLoginCode;
    private String classCode;

    public String getStuLoginCode() {
        return stuLoginCode;
    }

    public void setStuLoginCode(String stuLoginCode) {
        this.stuLoginCode = stuLoginCode;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(String teamNo) {
        this.teamNo = teamNo;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
}
