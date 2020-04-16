package com.education.system_edu.pojo.dbpojo;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月15日 9:51
 */
public class UserInSchoolMSG {
    private String userLoginCode;
    private String grade;
    private String fac;
    private String dep;
    private String maj;
    private String cls;

    public String getUserLoginCode() {
        return userLoginCode;
    }

    public void setUserLoginCode(String userLoginCode) {
        this.userLoginCode = userLoginCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getMaj() {
        return maj;
    }

    public void setMaj(String maj) {
        this.maj = maj;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }
}
