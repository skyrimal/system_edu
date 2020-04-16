package com.education.system_edu.pojo.output;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月11日 13:00
 */
public class HomworkMsg {
    private String code;
    private String courseClassCode;
    private String startTime;
    private String endTime;
    private String title;
    private String context;
    private String score;
    private String finScore;//批阅后得分
    // 0- 不能提交
    // 0-1 没有提交，不能提交
    // 0-2 已经提交，不能提交
    // 0-3 已经提交，已经批阅
    // 1- 时间范围内 可以提交
    // 1-0 未提交，可以提交
    // 1-1 已提交，可以修改
    private String status;
    private String isAcess;
    private String isTeam;
    private String file;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFinScore() {
        return finScore;
    }

    public void setFinScore(String finScore) {
        this.finScore = finScore;
    }

    public String getCourseClassCode() {
        return courseClassCode;
    }

    public void setCourseClassCode(String courseClassCode) {
        this.courseClassCode = courseClassCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsAcess() {
        return isAcess;
    }

    public void setIsAcess(String isAcess) {
        this.isAcess = isAcess;
    }

    public String getIsTeam() {
        return isTeam;
    }

    public void setIsTeam(String isTeam) {
        this.isTeam = isTeam;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
