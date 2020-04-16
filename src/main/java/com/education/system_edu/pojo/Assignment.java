package com.education.system_edu.pojo;

public class Assignment {
    private String assignmentCode;

    private Integer score;

    private String isteam;

    private String isacess;

    private String filename;

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode == null ? null : assignmentCode.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIsteam() {
        return isteam;
    }

    public void setIsteam(String isteam) {
        this.isteam = isteam == null ? null : isteam.trim();
    }

    public String getIsacess() {
        return isacess;
    }

    public void setIsacess(String isacess) {
        this.isacess = isacess == null ? null : isacess.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }
}