package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMessageExample() {
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

        public Criteria andSendCodeIsNull() {
            addCriterion("send_code is null");
            return (Criteria) this;
        }

        public Criteria andSendCodeIsNotNull() {
            addCriterion("send_code is not null");
            return (Criteria) this;
        }

        public Criteria andSendCodeEqualTo(String value) {
            addCriterion("send_code =", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeNotEqualTo(String value) {
            addCriterion("send_code <>", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeGreaterThan(String value) {
            addCriterion("send_code >", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeGreaterThanOrEqualTo(String value) {
            addCriterion("send_code >=", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeLessThan(String value) {
            addCriterion("send_code <", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeLessThanOrEqualTo(String value) {
            addCriterion("send_code <=", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeLike(String value) {
            addCriterion("send_code like", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeNotLike(String value) {
            addCriterion("send_code not like", value, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeIn(List<String> values) {
            addCriterion("send_code in", values, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeNotIn(List<String> values) {
            addCriterion("send_code not in", values, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeBetween(String value1, String value2) {
            addCriterion("send_code between", value1, value2, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendCodeNotBetween(String value1, String value2) {
            addCriterion("send_code not between", value1, value2, "sendCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeIsNull() {
            addCriterion("send_sys_role_node_code is null");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeIsNotNull() {
            addCriterion("send_sys_role_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeEqualTo(String value) {
            addCriterion("send_sys_role_node_code =", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeNotEqualTo(String value) {
            addCriterion("send_sys_role_node_code <>", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeGreaterThan(String value) {
            addCriterion("send_sys_role_node_code >", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("send_sys_role_node_code >=", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeLessThan(String value) {
            addCriterion("send_sys_role_node_code <", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("send_sys_role_node_code <=", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeLike(String value) {
            addCriterion("send_sys_role_node_code like", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeNotLike(String value) {
            addCriterion("send_sys_role_node_code not like", value, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeIn(List<String> values) {
            addCriterion("send_sys_role_node_code in", values, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeNotIn(List<String> values) {
            addCriterion("send_sys_role_node_code not in", values, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeBetween(String value1, String value2) {
            addCriterion("send_sys_role_node_code between", value1, value2, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSendSysRoleNodeCodeNotBetween(String value1, String value2) {
            addCriterion("send_sys_role_node_code not between", value1, value2, "sendSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeIsNull() {
            addCriterion("accept_code is null");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeIsNotNull() {
            addCriterion("accept_code is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeEqualTo(String value) {
            addCriterion("accept_code =", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeNotEqualTo(String value) {
            addCriterion("accept_code <>", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeGreaterThan(String value) {
            addCriterion("accept_code >", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("accept_code >=", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeLessThan(String value) {
            addCriterion("accept_code <", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeLessThanOrEqualTo(String value) {
            addCriterion("accept_code <=", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeLike(String value) {
            addCriterion("accept_code like", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeNotLike(String value) {
            addCriterion("accept_code not like", value, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeIn(List<String> values) {
            addCriterion("accept_code in", values, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeNotIn(List<String> values) {
            addCriterion("accept_code not in", values, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeBetween(String value1, String value2) {
            addCriterion("accept_code between", value1, value2, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptCodeNotBetween(String value1, String value2) {
            addCriterion("accept_code not between", value1, value2, "acceptCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeIsNull() {
            addCriterion("accept_sys_role_node_code is null");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeIsNotNull() {
            addCriterion("accept_sys_role_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeEqualTo(String value) {
            addCriterion("accept_sys_role_node_code =", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeNotEqualTo(String value) {
            addCriterion("accept_sys_role_node_code <>", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeGreaterThan(String value) {
            addCriterion("accept_sys_role_node_code >", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("accept_sys_role_node_code >=", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeLessThan(String value) {
            addCriterion("accept_sys_role_node_code <", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("accept_sys_role_node_code <=", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeLike(String value) {
            addCriterion("accept_sys_role_node_code like", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeNotLike(String value) {
            addCriterion("accept_sys_role_node_code not like", value, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeIn(List<String> values) {
            addCriterion("accept_sys_role_node_code in", values, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeNotIn(List<String> values) {
            addCriterion("accept_sys_role_node_code not in", values, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeBetween(String value1, String value2) {
            addCriterion("accept_sys_role_node_code between", value1, value2, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andAcceptSysRoleNodeCodeNotBetween(String value1, String value2) {
            addCriterion("accept_sys_role_node_code not between", value1, value2, "acceptSysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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