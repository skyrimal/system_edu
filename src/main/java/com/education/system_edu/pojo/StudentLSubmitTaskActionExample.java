package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentLSubmitTaskActionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentLSubmitTaskActionExample() {
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

        public Criteria andAssignmentCodeIsNull() {
            addCriterion("assignment_code is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeIsNotNull() {
            addCriterion("assignment_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeEqualTo(String value) {
            addCriterion("assignment_code =", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeNotEqualTo(String value) {
            addCriterion("assignment_code <>", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeGreaterThan(String value) {
            addCriterion("assignment_code >", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("assignment_code >=", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeLessThan(String value) {
            addCriterion("assignment_code <", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeLessThanOrEqualTo(String value) {
            addCriterion("assignment_code <=", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeLike(String value) {
            addCriterion("assignment_code like", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeNotLike(String value) {
            addCriterion("assignment_code not like", value, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeIn(List<String> values) {
            addCriterion("assignment_code in", values, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeNotIn(List<String> values) {
            addCriterion("assignment_code not in", values, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeBetween(String value1, String value2) {
            addCriterion("assignment_code between", value1, value2, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andAssignmentCodeNotBetween(String value1, String value2) {
            addCriterion("assignment_code not between", value1, value2, "assignmentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeIsNull() {
            addCriterion("student_code is null");
            return (Criteria) this;
        }

        public Criteria andStudentCodeIsNotNull() {
            addCriterion("student_code is not null");
            return (Criteria) this;
        }

        public Criteria andStudentCodeEqualTo(String value) {
            addCriterion("student_code =", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeNotEqualTo(String value) {
            addCriterion("student_code <>", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeGreaterThan(String value) {
            addCriterion("student_code >", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("student_code >=", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeLessThan(String value) {
            addCriterion("student_code <", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeLessThanOrEqualTo(String value) {
            addCriterion("student_code <=", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeLike(String value) {
            addCriterion("student_code like", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeNotLike(String value) {
            addCriterion("student_code not like", value, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeIn(List<String> values) {
            addCriterion("student_code in", values, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeNotIn(List<String> values) {
            addCriterion("student_code not in", values, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeBetween(String value1, String value2) {
            addCriterion("student_code between", value1, value2, "studentCode");
            return (Criteria) this;
        }

        public Criteria andStudentCodeNotBetween(String value1, String value2) {
            addCriterion("student_code not between", value1, value2, "studentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeIsNull() {
            addCriterion("submit_datetime is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeIsNotNull() {
            addCriterion("submit_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeEqualTo(Date value) {
            addCriterion("submit_datetime =", value, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeNotEqualTo(Date value) {
            addCriterion("submit_datetime <>", value, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeGreaterThan(Date value) {
            addCriterion("submit_datetime >", value, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_datetime >=", value, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeLessThan(Date value) {
            addCriterion("submit_datetime <", value, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_datetime <=", value, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeIn(List<Date> values) {
            addCriterion("submit_datetime in", values, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeNotIn(List<Date> values) {
            addCriterion("submit_datetime not in", values, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeBetween(Date value1, Date value2) {
            addCriterion("submit_datetime between", value1, value2, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_datetime not between", value1, value2, "submitDatetime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Integer value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Integer value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Integer value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Integer value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Integer value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Integer> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Integer> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Integer value1, Integer value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIsNull() {
            addCriterion("is_submit is null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIsNotNull() {
            addCriterion("is_submit is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitEqualTo(String value) {
            addCriterion("is_submit =", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotEqualTo(String value) {
            addCriterion("is_submit <>", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitGreaterThan(String value) {
            addCriterion("is_submit >", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitGreaterThanOrEqualTo(String value) {
            addCriterion("is_submit >=", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLessThan(String value) {
            addCriterion("is_submit <", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLessThanOrEqualTo(String value) {
            addCriterion("is_submit <=", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLike(String value) {
            addCriterion("is_submit like", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotLike(String value) {
            addCriterion("is_submit not like", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIn(List<String> values) {
            addCriterion("is_submit in", values, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotIn(List<String> values) {
            addCriterion("is_submit not in", values, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitBetween(String value1, String value2) {
            addCriterion("is_submit between", value1, value2, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotBetween(String value1, String value2) {
            addCriterion("is_submit not between", value1, value2, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
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