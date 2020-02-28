package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectUserAndDepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConnectUserAndDepartmentExample() {
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

        public Criteria andUseCodeIsNull() {
            addCriterion("use_code is null");
            return (Criteria) this;
        }

        public Criteria andUseCodeIsNotNull() {
            addCriterion("use_code is not null");
            return (Criteria) this;
        }

        public Criteria andUseCodeEqualTo(String value) {
            addCriterion("use_code =", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotEqualTo(String value) {
            addCriterion("use_code <>", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeGreaterThan(String value) {
            addCriterion("use_code >", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("use_code >=", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeLessThan(String value) {
            addCriterion("use_code <", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeLessThanOrEqualTo(String value) {
            addCriterion("use_code <=", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeLike(String value) {
            addCriterion("use_code like", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotLike(String value) {
            addCriterion("use_code not like", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeIn(List<String> values) {
            addCriterion("use_code in", values, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotIn(List<String> values) {
            addCriterion("use_code not in", values, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeBetween(String value1, String value2) {
            addCriterion("use_code between", value1, value2, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotBetween(String value1, String value2) {
            addCriterion("use_code not between", value1, value2, "useCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeIsNull() {
            addCriterion("sys_node_code is null");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeIsNotNull() {
            addCriterion("sys_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeEqualTo(String value) {
            addCriterion("sys_node_code =", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeNotEqualTo(String value) {
            addCriterion("sys_node_code <>", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeGreaterThan(String value) {
            addCriterion("sys_node_code >", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_node_code >=", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeLessThan(String value) {
            addCriterion("sys_node_code <", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_node_code <=", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeLike(String value) {
            addCriterion("sys_node_code like", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeNotLike(String value) {
            addCriterion("sys_node_code not like", value, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeIn(List<String> values) {
            addCriterion("sys_node_code in", values, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeNotIn(List<String> values) {
            addCriterion("sys_node_code not in", values, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeBetween(String value1, String value2) {
            addCriterion("sys_node_code between", value1, value2, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeCodeNotBetween(String value1, String value2) {
            addCriterion("sys_node_code not between", value1, value2, "sysNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeIsNull() {
            addCriterion("sys_node_type is null");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeIsNotNull() {
            addCriterion("sys_node_type is not null");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeEqualTo(Short value) {
            addCriterion("sys_node_type =", value, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeNotEqualTo(Short value) {
            addCriterion("sys_node_type <>", value, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeGreaterThan(Short value) {
            addCriterion("sys_node_type >", value, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("sys_node_type >=", value, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeLessThan(Short value) {
            addCriterion("sys_node_type <", value, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeLessThanOrEqualTo(Short value) {
            addCriterion("sys_node_type <=", value, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeIn(List<Short> values) {
            addCriterion("sys_node_type in", values, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeNotIn(List<Short> values) {
            addCriterion("sys_node_type not in", values, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeBetween(Short value1, Short value2) {
            addCriterion("sys_node_type between", value1, value2, "sysNodeType");
            return (Criteria) this;
        }

        public Criteria andSysNodeTypeNotBetween(Short value1, Short value2) {
            addCriterion("sys_node_type not between", value1, value2, "sysNodeType");
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