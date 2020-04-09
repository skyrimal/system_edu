package com.education.system_edu.pojo.insert;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月07日 19:38
 */
public class HomeworkModelInsert {
    private String classCode;
    private String title;
    private String tip;
    private Integer acess;
    private Integer team;
    private Integer count;
    private String file;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getAcess() {
        return acess;
    }

    public void setAcess(Integer acess) {
        this.acess = acess;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }
}
