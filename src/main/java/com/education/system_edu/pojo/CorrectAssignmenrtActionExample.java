package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CorrectAssignmenrtActionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CorrectAssignmenrtActionExample() {
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

        public Criteria andUserCodeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("user_code =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("user_code >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("user_code <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("user_code like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("user_code not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("user_code in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "userCode");
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

        public Criteria andSubmitStudentCodeIsNull() {
            addCriterion("submit_student_code is null");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeIsNotNull() {
            addCriterion("submit_student_code is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeEqualTo(String value) {
            addCriterion("submit_student_code =", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeNotEqualTo(String value) {
            addCriterion("submit_student_code <>", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeGreaterThan(String value) {
            addCriterion("submit_student_code >", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("submit_student_code >=", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeLessThan(String value) {
            addCriterion("submit_student_code <", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeLessThanOrEqualTo(String value) {
            addCriterion("submit_student_code <=", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeLike(String value) {
            addCriterion("submit_student_code like", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeNotLike(String value) {
            addCriterion("submit_student_code not like", value, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeIn(List<String> values) {
            addCriterion("submit_student_code in", values, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeNotIn(List<String> values) {
            addCriterion("submit_student_code not in", values, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeBetween(String value1, String value2) {
            addCriterion("submit_student_code between", value1, value2, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitStudentCodeNotBetween(String value1, String value2) {
            addCriterion("submit_student_code not between", value1, value2, "submitStudentCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeIsNull() {
            addCriterion("submit_action_code is null");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeIsNotNull() {
            addCriterion("submit_action_code is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeEqualTo(String value) {
            addCriterion("submit_action_code =", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeNotEqualTo(String value) {
            addCriterion("submit_action_code <>", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeGreaterThan(String value) {
            addCriterion("submit_action_code >", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("submit_action_code >=", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeLessThan(String value) {
            addCriterion("submit_action_code <", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeLessThanOrEqualTo(String value) {
            addCriterion("submit_action_code <=", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeLike(String value) {
            addCriterion("submit_action_code like", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeNotLike(String value) {
            addCriterion("submit_action_code not like", value, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeIn(List<String> values) {
            addCriterion("submit_action_code in", values, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeNotIn(List<String> values) {
            addCriterion("submit_action_code not in", values, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeBetween(String value1, String value2) {
            addCriterion("submit_action_code between", value1, value2, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSubmitActionCodeNotBetween(String value1, String value2) {
            addCriterion("submit_action_code not between", value1, value2, "submitActionCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeIsNull() {
            addCriterion("sys_role_node_code is null");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeIsNotNull() {
            addCriterion("sys_role_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeEqualTo(String value) {
            addCriterion("sys_role_node_code =", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeNotEqualTo(String value) {
            addCriterion("sys_role_node_code <>", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeGreaterThan(String value) {
            addCriterion("sys_role_node_code >", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_role_node_code >=", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeLessThan(String value) {
            addCriterion("sys_role_node_code <", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_role_node_code <=", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeLike(String value) {
            addCriterion("sys_role_node_code like", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeNotLike(String value) {
            addCriterion("sys_role_node_code not like", value, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeIn(List<String> values) {
            addCriterion("sys_role_node_code in", values, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeNotIn(List<String> values) {
            addCriterion("sys_role_node_code not in", values, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeBetween(String value1, String value2) {
            addCriterion("sys_role_node_code between", value1, value2, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeCodeNotBetween(String value1, String value2) {
            addCriterion("sys_role_node_code not between", value1, value2, "sysRoleNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeIsNull() {
            addCriterion("sys_role_node_type is null");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeIsNotNull() {
            addCriterion("sys_role_node_type is not null");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeEqualTo(String value) {
            addCriterion("sys_role_node_type =", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotEqualTo(String value) {
            addCriterion("sys_role_node_type <>", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeGreaterThan(String value) {
            addCriterion("sys_role_node_type >", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_role_node_type >=", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeLessThan(String value) {
            addCriterion("sys_role_node_type <", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeLessThanOrEqualTo(String value) {
            addCriterion("sys_role_node_type <=", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeLike(String value) {
            addCriterion("sys_role_node_type like", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotLike(String value) {
            addCriterion("sys_role_node_type not like", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeIn(List<String> values) {
            addCriterion("sys_role_node_type in", values, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotIn(List<String> values) {
            addCriterion("sys_role_node_type not in", values, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeBetween(String value1, String value2) {
            addCriterion("sys_role_node_type between", value1, value2, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotBetween(String value1, String value2) {
            addCriterion("sys_role_node_type not between", value1, value2, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreIsNull() {
            addCriterion("finally_score is null");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreIsNotNull() {
            addCriterion("finally_score is not null");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreEqualTo(Integer value) {
            addCriterion("finally_score =", value, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreNotEqualTo(Integer value) {
            addCriterion("finally_score <>", value, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreGreaterThan(Integer value) {
            addCriterion("finally_score >", value, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("finally_score >=", value, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreLessThan(Integer value) {
            addCriterion("finally_score <", value, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreLessThanOrEqualTo(Integer value) {
            addCriterion("finally_score <=", value, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreIn(List<Integer> values) {
            addCriterion("finally_score in", values, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreNotIn(List<Integer> values) {
            addCriterion("finally_score not in", values, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreBetween(Integer value1, Integer value2) {
            addCriterion("finally_score between", value1, value2, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andFinallyScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("finally_score not between", value1, value2, "finallyScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreIsNull() {
            addCriterion("question_no_score is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreIsNotNull() {
            addCriterion("question_no_score is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreEqualTo(String value) {
            addCriterion("question_no_score =", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreNotEqualTo(String value) {
            addCriterion("question_no_score <>", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreGreaterThan(String value) {
            addCriterion("question_no_score >", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreGreaterThanOrEqualTo(String value) {
            addCriterion("question_no_score >=", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreLessThan(String value) {
            addCriterion("question_no_score <", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreLessThanOrEqualTo(String value) {
            addCriterion("question_no_score <=", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreLike(String value) {
            addCriterion("question_no_score like", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreNotLike(String value) {
            addCriterion("question_no_score not like", value, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreIn(List<String> values) {
            addCriterion("question_no_score in", values, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreNotIn(List<String> values) {
            addCriterion("question_no_score not in", values, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreBetween(String value1, String value2) {
            addCriterion("question_no_score between", value1, value2, "questionNoScore");
            return (Criteria) this;
        }

        public Criteria andQuestionNoScoreNotBetween(String value1, String value2) {
            addCriterion("question_no_score not between", value1, value2, "questionNoScore");
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