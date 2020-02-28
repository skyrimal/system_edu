package com.education.system_edu.pojo;

import java.util.Date;

public class User {
    private String code;

    private String loginCode;

    private String userName;

    private String password;

    private String email;

    private String mobile;

    private String phone;

    private String sex;

    private String avatar;

    private String sign;

    private String userType;

    private String mgrType;

    private Date pwdUpdateDate;

    private String pwdUpdateRecord;

    private String pwdQuestion;

    private String pwdQuestionAnswer;

    private String pwdQuestion2;

    private String pwdQuestionAnswer2;

    private String pwdQuestion3;

    private String pwdQuestionAnswer3;

    private Date pwdQuestUpdateDate;

    private String lastLoginIp;

    private Date lastLoginDate;

    private Date freezeDate;

    private String freezeCause;

    private String status;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode == null ? null : loginCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getMgrType() {
        return mgrType;
    }

    public void setMgrType(String mgrType) {
        this.mgrType = mgrType == null ? null : mgrType.trim();
    }

    public Date getPwdUpdateDate() {
        return pwdUpdateDate;
    }

    public void setPwdUpdateDate(Date pwdUpdateDate) {
        this.pwdUpdateDate = pwdUpdateDate;
    }

    public String getPwdUpdateRecord() {
        return pwdUpdateRecord;
    }

    public void setPwdUpdateRecord(String pwdUpdateRecord) {
        this.pwdUpdateRecord = pwdUpdateRecord == null ? null : pwdUpdateRecord.trim();
    }

    public String getPwdQuestion() {
        return pwdQuestion;
    }

    public void setPwdQuestion(String pwdQuestion) {
        this.pwdQuestion = pwdQuestion == null ? null : pwdQuestion.trim();
    }

    public String getPwdQuestionAnswer() {
        return pwdQuestionAnswer;
    }

    public void setPwdQuestionAnswer(String pwdQuestionAnswer) {
        this.pwdQuestionAnswer = pwdQuestionAnswer == null ? null : pwdQuestionAnswer.trim();
    }

    public String getPwdQuestion2() {
        return pwdQuestion2;
    }

    public void setPwdQuestion2(String pwdQuestion2) {
        this.pwdQuestion2 = pwdQuestion2 == null ? null : pwdQuestion2.trim();
    }

    public String getPwdQuestionAnswer2() {
        return pwdQuestionAnswer2;
    }

    public void setPwdQuestionAnswer2(String pwdQuestionAnswer2) {
        this.pwdQuestionAnswer2 = pwdQuestionAnswer2 == null ? null : pwdQuestionAnswer2.trim();
    }

    public String getPwdQuestion3() {
        return pwdQuestion3;
    }

    public void setPwdQuestion3(String pwdQuestion3) {
        this.pwdQuestion3 = pwdQuestion3 == null ? null : pwdQuestion3.trim();
    }

    public String getPwdQuestionAnswer3() {
        return pwdQuestionAnswer3;
    }

    public void setPwdQuestionAnswer3(String pwdQuestionAnswer3) {
        this.pwdQuestionAnswer3 = pwdQuestionAnswer3 == null ? null : pwdQuestionAnswer3.trim();
    }

    public Date getPwdQuestUpdateDate() {
        return pwdQuestUpdateDate;
    }

    public void setPwdQuestUpdateDate(Date pwdQuestUpdateDate) {
        this.pwdQuestUpdateDate = pwdQuestUpdateDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }

    public String getFreezeCause() {
        return freezeCause;
    }

    public void setFreezeCause(String freezeCause) {
        this.freezeCause = freezeCause == null ? null : freezeCause.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}