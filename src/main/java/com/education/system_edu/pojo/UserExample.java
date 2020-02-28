package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andLoginCodeIsNull() {
            addCriterion("login_code is null");
            return (Criteria) this;
        }

        public Criteria andLoginCodeIsNotNull() {
            addCriterion("login_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCodeEqualTo(String value) {
            addCriterion("login_code =", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotEqualTo(String value) {
            addCriterion("login_code <>", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeGreaterThan(String value) {
            addCriterion("login_code >", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeGreaterThanOrEqualTo(String value) {
            addCriterion("login_code >=", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeLessThan(String value) {
            addCriterion("login_code <", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeLessThanOrEqualTo(String value) {
            addCriterion("login_code <=", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeLike(String value) {
            addCriterion("login_code like", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotLike(String value) {
            addCriterion("login_code not like", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeIn(List<String> values) {
            addCriterion("login_code in", values, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotIn(List<String> values) {
            addCriterion("login_code not in", values, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeBetween(String value1, String value2) {
            addCriterion("login_code between", value1, value2, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotBetween(String value1, String value2) {
            addCriterion("login_code not between", value1, value2, "loginCode");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeIsNull() {
            addCriterion("mgr_type is null");
            return (Criteria) this;
        }

        public Criteria andMgrTypeIsNotNull() {
            addCriterion("mgr_type is not null");
            return (Criteria) this;
        }

        public Criteria andMgrTypeEqualTo(String value) {
            addCriterion("mgr_type =", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeNotEqualTo(String value) {
            addCriterion("mgr_type <>", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeGreaterThan(String value) {
            addCriterion("mgr_type >", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mgr_type >=", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeLessThan(String value) {
            addCriterion("mgr_type <", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeLessThanOrEqualTo(String value) {
            addCriterion("mgr_type <=", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeLike(String value) {
            addCriterion("mgr_type like", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeNotLike(String value) {
            addCriterion("mgr_type not like", value, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeIn(List<String> values) {
            addCriterion("mgr_type in", values, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeNotIn(List<String> values) {
            addCriterion("mgr_type not in", values, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeBetween(String value1, String value2) {
            addCriterion("mgr_type between", value1, value2, "mgrType");
            return (Criteria) this;
        }

        public Criteria andMgrTypeNotBetween(String value1, String value2) {
            addCriterion("mgr_type not between", value1, value2, "mgrType");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateIsNull() {
            addCriterion("pwd_update_date is null");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateIsNotNull() {
            addCriterion("pwd_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateEqualTo(Date value) {
            addCriterion("pwd_update_date =", value, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateNotEqualTo(Date value) {
            addCriterion("pwd_update_date <>", value, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateGreaterThan(Date value) {
            addCriterion("pwd_update_date >", value, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pwd_update_date >=", value, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateLessThan(Date value) {
            addCriterion("pwd_update_date <", value, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("pwd_update_date <=", value, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateIn(List<Date> values) {
            addCriterion("pwd_update_date in", values, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateNotIn(List<Date> values) {
            addCriterion("pwd_update_date not in", values, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateBetween(Date value1, Date value2) {
            addCriterion("pwd_update_date between", value1, value2, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("pwd_update_date not between", value1, value2, "pwdUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordIsNull() {
            addCriterion("pwd_update_record is null");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordIsNotNull() {
            addCriterion("pwd_update_record is not null");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordEqualTo(String value) {
            addCriterion("pwd_update_record =", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordNotEqualTo(String value) {
            addCriterion("pwd_update_record <>", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordGreaterThan(String value) {
            addCriterion("pwd_update_record >", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordGreaterThanOrEqualTo(String value) {
            addCriterion("pwd_update_record >=", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordLessThan(String value) {
            addCriterion("pwd_update_record <", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordLessThanOrEqualTo(String value) {
            addCriterion("pwd_update_record <=", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordLike(String value) {
            addCriterion("pwd_update_record like", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordNotLike(String value) {
            addCriterion("pwd_update_record not like", value, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordIn(List<String> values) {
            addCriterion("pwd_update_record in", values, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordNotIn(List<String> values) {
            addCriterion("pwd_update_record not in", values, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordBetween(String value1, String value2) {
            addCriterion("pwd_update_record between", value1, value2, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateRecordNotBetween(String value1, String value2) {
            addCriterion("pwd_update_record not between", value1, value2, "pwdUpdateRecord");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionIsNull() {
            addCriterion("pwd_question is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionIsNotNull() {
            addCriterion("pwd_question is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionEqualTo(String value) {
            addCriterion("pwd_question =", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionNotEqualTo(String value) {
            addCriterion("pwd_question <>", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionGreaterThan(String value) {
            addCriterion("pwd_question >", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("pwd_question >=", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionLessThan(String value) {
            addCriterion("pwd_question <", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionLessThanOrEqualTo(String value) {
            addCriterion("pwd_question <=", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionLike(String value) {
            addCriterion("pwd_question like", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionNotLike(String value) {
            addCriterion("pwd_question not like", value, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionIn(List<String> values) {
            addCriterion("pwd_question in", values, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionNotIn(List<String> values) {
            addCriterion("pwd_question not in", values, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionBetween(String value1, String value2) {
            addCriterion("pwd_question between", value1, value2, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionNotBetween(String value1, String value2) {
            addCriterion("pwd_question not between", value1, value2, "pwdQuestion");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerIsNull() {
            addCriterion("pwd_question_answer is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerIsNotNull() {
            addCriterion("pwd_question_answer is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerEqualTo(String value) {
            addCriterion("pwd_question_answer =", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerNotEqualTo(String value) {
            addCriterion("pwd_question_answer <>", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerGreaterThan(String value) {
            addCriterion("pwd_question_answer >", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("pwd_question_answer >=", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerLessThan(String value) {
            addCriterion("pwd_question_answer <", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerLessThanOrEqualTo(String value) {
            addCriterion("pwd_question_answer <=", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerLike(String value) {
            addCriterion("pwd_question_answer like", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerNotLike(String value) {
            addCriterion("pwd_question_answer not like", value, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerIn(List<String> values) {
            addCriterion("pwd_question_answer in", values, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerNotIn(List<String> values) {
            addCriterion("pwd_question_answer not in", values, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerBetween(String value1, String value2) {
            addCriterion("pwd_question_answer between", value1, value2, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswerNotBetween(String value1, String value2) {
            addCriterion("pwd_question_answer not between", value1, value2, "pwdQuestionAnswer");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2IsNull() {
            addCriterion("pwd_question_2 is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2IsNotNull() {
            addCriterion("pwd_question_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2EqualTo(String value) {
            addCriterion("pwd_question_2 =", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2NotEqualTo(String value) {
            addCriterion("pwd_question_2 <>", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2GreaterThan(String value) {
            addCriterion("pwd_question_2 >", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2GreaterThanOrEqualTo(String value) {
            addCriterion("pwd_question_2 >=", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2LessThan(String value) {
            addCriterion("pwd_question_2 <", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2LessThanOrEqualTo(String value) {
            addCriterion("pwd_question_2 <=", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2Like(String value) {
            addCriterion("pwd_question_2 like", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2NotLike(String value) {
            addCriterion("pwd_question_2 not like", value, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2In(List<String> values) {
            addCriterion("pwd_question_2 in", values, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2NotIn(List<String> values) {
            addCriterion("pwd_question_2 not in", values, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2Between(String value1, String value2) {
            addCriterion("pwd_question_2 between", value1, value2, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion2NotBetween(String value1, String value2) {
            addCriterion("pwd_question_2 not between", value1, value2, "pwdQuestion2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2IsNull() {
            addCriterion("pwd_question_answer_2 is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2IsNotNull() {
            addCriterion("pwd_question_answer_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2EqualTo(String value) {
            addCriterion("pwd_question_answer_2 =", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2NotEqualTo(String value) {
            addCriterion("pwd_question_answer_2 <>", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2GreaterThan(String value) {
            addCriterion("pwd_question_answer_2 >", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2GreaterThanOrEqualTo(String value) {
            addCriterion("pwd_question_answer_2 >=", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2LessThan(String value) {
            addCriterion("pwd_question_answer_2 <", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2LessThanOrEqualTo(String value) {
            addCriterion("pwd_question_answer_2 <=", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2Like(String value) {
            addCriterion("pwd_question_answer_2 like", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2NotLike(String value) {
            addCriterion("pwd_question_answer_2 not like", value, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2In(List<String> values) {
            addCriterion("pwd_question_answer_2 in", values, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2NotIn(List<String> values) {
            addCriterion("pwd_question_answer_2 not in", values, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2Between(String value1, String value2) {
            addCriterion("pwd_question_answer_2 between", value1, value2, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer2NotBetween(String value1, String value2) {
            addCriterion("pwd_question_answer_2 not between", value1, value2, "pwdQuestionAnswer2");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3IsNull() {
            addCriterion("pwd_question_3 is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3IsNotNull() {
            addCriterion("pwd_question_3 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3EqualTo(String value) {
            addCriterion("pwd_question_3 =", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3NotEqualTo(String value) {
            addCriterion("pwd_question_3 <>", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3GreaterThan(String value) {
            addCriterion("pwd_question_3 >", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3GreaterThanOrEqualTo(String value) {
            addCriterion("pwd_question_3 >=", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3LessThan(String value) {
            addCriterion("pwd_question_3 <", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3LessThanOrEqualTo(String value) {
            addCriterion("pwd_question_3 <=", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3Like(String value) {
            addCriterion("pwd_question_3 like", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3NotLike(String value) {
            addCriterion("pwd_question_3 not like", value, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3In(List<String> values) {
            addCriterion("pwd_question_3 in", values, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3NotIn(List<String> values) {
            addCriterion("pwd_question_3 not in", values, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3Between(String value1, String value2) {
            addCriterion("pwd_question_3 between", value1, value2, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestion3NotBetween(String value1, String value2) {
            addCriterion("pwd_question_3 not between", value1, value2, "pwdQuestion3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3IsNull() {
            addCriterion("pwd_question_answer_3 is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3IsNotNull() {
            addCriterion("pwd_question_answer_3 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3EqualTo(String value) {
            addCriterion("pwd_question_answer_3 =", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3NotEqualTo(String value) {
            addCriterion("pwd_question_answer_3 <>", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3GreaterThan(String value) {
            addCriterion("pwd_question_answer_3 >", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3GreaterThanOrEqualTo(String value) {
            addCriterion("pwd_question_answer_3 >=", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3LessThan(String value) {
            addCriterion("pwd_question_answer_3 <", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3LessThanOrEqualTo(String value) {
            addCriterion("pwd_question_answer_3 <=", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3Like(String value) {
            addCriterion("pwd_question_answer_3 like", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3NotLike(String value) {
            addCriterion("pwd_question_answer_3 not like", value, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3In(List<String> values) {
            addCriterion("pwd_question_answer_3 in", values, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3NotIn(List<String> values) {
            addCriterion("pwd_question_answer_3 not in", values, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3Between(String value1, String value2) {
            addCriterion("pwd_question_answer_3 between", value1, value2, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestionAnswer3NotBetween(String value1, String value2) {
            addCriterion("pwd_question_answer_3 not between", value1, value2, "pwdQuestionAnswer3");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateIsNull() {
            addCriterion("pwd_quest_update_date is null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateIsNotNull() {
            addCriterion("pwd_quest_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateEqualTo(Date value) {
            addCriterion("pwd_quest_update_date =", value, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateNotEqualTo(Date value) {
            addCriterion("pwd_quest_update_date <>", value, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateGreaterThan(Date value) {
            addCriterion("pwd_quest_update_date >", value, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pwd_quest_update_date >=", value, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateLessThan(Date value) {
            addCriterion("pwd_quest_update_date <", value, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("pwd_quest_update_date <=", value, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateIn(List<Date> values) {
            addCriterion("pwd_quest_update_date in", values, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateNotIn(List<Date> values) {
            addCriterion("pwd_quest_update_date not in", values, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateBetween(Date value1, Date value2) {
            addCriterion("pwd_quest_update_date between", value1, value2, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andPwdQuestUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("pwd_quest_update_date not between", value1, value2, "pwdQuestUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNull() {
            addCriterion("last_login_date is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNotNull() {
            addCriterion("last_login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateEqualTo(Date value) {
            addCriterion("last_login_date =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotEqualTo(Date value) {
            addCriterion("last_login_date <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThan(Date value) {
            addCriterion("last_login_date >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_date >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThan(Date value) {
            addCriterion("last_login_date <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("last_login_date <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIn(List<Date> values) {
            addCriterion("last_login_date in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotIn(List<Date> values) {
            addCriterion("last_login_date not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateBetween(Date value1, Date value2) {
            addCriterion("last_login_date between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("last_login_date not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateIsNull() {
            addCriterion("freeze_date is null");
            return (Criteria) this;
        }

        public Criteria andFreezeDateIsNotNull() {
            addCriterion("freeze_date is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeDateEqualTo(Date value) {
            addCriterion("freeze_date =", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateNotEqualTo(Date value) {
            addCriterion("freeze_date <>", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateGreaterThan(Date value) {
            addCriterion("freeze_date >", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("freeze_date >=", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateLessThan(Date value) {
            addCriterion("freeze_date <", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateLessThanOrEqualTo(Date value) {
            addCriterion("freeze_date <=", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateIn(List<Date> values) {
            addCriterion("freeze_date in", values, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateNotIn(List<Date> values) {
            addCriterion("freeze_date not in", values, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateBetween(Date value1, Date value2) {
            addCriterion("freeze_date between", value1, value2, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateNotBetween(Date value1, Date value2) {
            addCriterion("freeze_date not between", value1, value2, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseIsNull() {
            addCriterion("freeze_cause is null");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseIsNotNull() {
            addCriterion("freeze_cause is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseEqualTo(String value) {
            addCriterion("freeze_cause =", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseNotEqualTo(String value) {
            addCriterion("freeze_cause <>", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseGreaterThan(String value) {
            addCriterion("freeze_cause >", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseGreaterThanOrEqualTo(String value) {
            addCriterion("freeze_cause >=", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseLessThan(String value) {
            addCriterion("freeze_cause <", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseLessThanOrEqualTo(String value) {
            addCriterion("freeze_cause <=", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseLike(String value) {
            addCriterion("freeze_cause like", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseNotLike(String value) {
            addCriterion("freeze_cause not like", value, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseIn(List<String> values) {
            addCriterion("freeze_cause in", values, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseNotIn(List<String> values) {
            addCriterion("freeze_cause not in", values, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseBetween(String value1, String value2) {
            addCriterion("freeze_cause between", value1, value2, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andFreezeCauseNotBetween(String value1, String value2) {
            addCriterion("freeze_cause not between", value1, value2, "freezeCause");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}