package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysScheduleExample() {
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

        public Criteria andPublishAssignmentCodeIsNull() {
            addCriterion("publish_assignment_code is null");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeIsNotNull() {
            addCriterion("publish_assignment_code is not null");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeEqualTo(String value) {
            addCriterion("publish_assignment_code =", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeNotEqualTo(String value) {
            addCriterion("publish_assignment_code <>", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeGreaterThan(String value) {
            addCriterion("publish_assignment_code >", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("publish_assignment_code >=", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeLessThan(String value) {
            addCriterion("publish_assignment_code <", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeLessThanOrEqualTo(String value) {
            addCriterion("publish_assignment_code <=", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeLike(String value) {
            addCriterion("publish_assignment_code like", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeNotLike(String value) {
            addCriterion("publish_assignment_code not like", value, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeIn(List<String> values) {
            addCriterion("publish_assignment_code in", values, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeNotIn(List<String> values) {
            addCriterion("publish_assignment_code not in", values, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeBetween(String value1, String value2) {
            addCriterion("publish_assignment_code between", value1, value2, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andPublishAssignmentCodeNotBetween(String value1, String value2) {
            addCriterion("publish_assignment_code not between", value1, value2, "publishAssignmentCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeIsNull() {
            addCriterion("sys_execution_node_code is null");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeIsNotNull() {
            addCriterion("sys_execution_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeEqualTo(String value) {
            addCriterion("sys_execution_node_code =", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeNotEqualTo(String value) {
            addCriterion("sys_execution_node_code <>", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeGreaterThan(String value) {
            addCriterion("sys_execution_node_code >", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_execution_node_code >=", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeLessThan(String value) {
            addCriterion("sys_execution_node_code <", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_execution_node_code <=", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeLike(String value) {
            addCriterion("sys_execution_node_code like", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeNotLike(String value) {
            addCriterion("sys_execution_node_code not like", value, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeIn(List<String> values) {
            addCriterion("sys_execution_node_code in", values, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeNotIn(List<String> values) {
            addCriterion("sys_execution_node_code not in", values, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeBetween(String value1, String value2) {
            addCriterion("sys_execution_node_code between", value1, value2, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysExecutionNodeCodeNotBetween(String value1, String value2) {
            addCriterion("sys_execution_node_code not between", value1, value2, "sysExecutionNodeCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeIsNull() {
            addCriterion("assignment_type is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeIsNotNull() {
            addCriterion("assignment_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeEqualTo(Short value) {
            addCriterion("assignment_type =", value, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeNotEqualTo(Short value) {
            addCriterion("assignment_type <>", value, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeGreaterThan(Short value) {
            addCriterion("assignment_type >", value, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("assignment_type >=", value, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeLessThan(Short value) {
            addCriterion("assignment_type <", value, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeLessThanOrEqualTo(Short value) {
            addCriterion("assignment_type <=", value, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeIn(List<Short> values) {
            addCriterion("assignment_type in", values, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeNotIn(List<Short> values) {
            addCriterion("assignment_type not in", values, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeBetween(Short value1, Short value2) {
            addCriterion("assignment_type between", value1, value2, "assignmentType");
            return (Criteria) this;
        }

        public Criteria andAssignmentTypeNotBetween(Short value1, Short value2) {
            addCriterion("assignment_type not between", value1, value2, "assignmentType");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeIsNull() {
            addCriterion("sys_data_node_code is null");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeIsNotNull() {
            addCriterion("sys_data_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeEqualTo(String value) {
            addCriterion("sys_data_node_code =", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeNotEqualTo(String value) {
            addCriterion("sys_data_node_code <>", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeGreaterThan(String value) {
            addCriterion("sys_data_node_code >", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_data_node_code >=", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeLessThan(String value) {
            addCriterion("sys_data_node_code <", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_data_node_code <=", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeLike(String value) {
            addCriterion("sys_data_node_code like", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeNotLike(String value) {
            addCriterion("sys_data_node_code not like", value, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeIn(List<String> values) {
            addCriterion("sys_data_node_code in", values, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeNotIn(List<String> values) {
            addCriterion("sys_data_node_code not in", values, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeBetween(String value1, String value2) {
            addCriterion("sys_data_node_code between", value1, value2, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeCodeNotBetween(String value1, String value2) {
            addCriterion("sys_data_node_code not between", value1, value2, "sysDataNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeIsNull() {
            addCriterion("sys_data_node_type is null");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeIsNotNull() {
            addCriterion("sys_data_node_type is not null");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeEqualTo(Short value) {
            addCriterion("sys_data_node_type =", value, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeNotEqualTo(Short value) {
            addCriterion("sys_data_node_type <>", value, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeGreaterThan(Short value) {
            addCriterion("sys_data_node_type >", value, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("sys_data_node_type >=", value, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeLessThan(Short value) {
            addCriterion("sys_data_node_type <", value, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeLessThanOrEqualTo(Short value) {
            addCriterion("sys_data_node_type <=", value, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeIn(List<Short> values) {
            addCriterion("sys_data_node_type in", values, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeNotIn(List<Short> values) {
            addCriterion("sys_data_node_type not in", values, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeBetween(Short value1, Short value2) {
            addCriterion("sys_data_node_type between", value1, value2, "sysDataNodeType");
            return (Criteria) this;
        }

        public Criteria andSysDataNodeTypeNotBetween(Short value1, Short value2) {
            addCriterion("sys_data_node_type not between", value1, value2, "sysDataNodeType");
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

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNull() {
            addCriterion("interval is null");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNotNull() {
            addCriterion("interval is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalEqualTo(String value) {
            addCriterion("interval =", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotEqualTo(String value) {
            addCriterion("interval <>", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThan(String value) {
            addCriterion("interval >", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("interval >=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThan(String value) {
            addCriterion("interval <", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThanOrEqualTo(String value) {
            addCriterion("interval <=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLike(String value) {
            addCriterion("interval like", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotLike(String value) {
            addCriterion("interval not like", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalIn(List<String> values) {
            addCriterion("interval in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotIn(List<String> values) {
            addCriterion("interval not in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalBetween(String value1, String value2) {
            addCriterion("interval between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotBetween(String value1, String value2) {
            addCriterion("interval not between", value1, value2, "interval");
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