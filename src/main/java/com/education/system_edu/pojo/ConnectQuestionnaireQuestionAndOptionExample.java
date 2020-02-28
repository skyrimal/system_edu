package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectQuestionnaireQuestionAndOptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConnectQuestionnaireQuestionAndOptionExample() {
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

        public Criteria andQuestionCodeIsNull() {
            addCriterion("question_code is null");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeIsNotNull() {
            addCriterion("question_code is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeEqualTo(String value) {
            addCriterion("question_code =", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotEqualTo(String value) {
            addCriterion("question_code <>", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeGreaterThan(String value) {
            addCriterion("question_code >", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("question_code >=", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeLessThan(String value) {
            addCriterion("question_code <", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeLessThanOrEqualTo(String value) {
            addCriterion("question_code <=", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeLike(String value) {
            addCriterion("question_code like", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotLike(String value) {
            addCriterion("question_code not like", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeIn(List<String> values) {
            addCriterion("question_code in", values, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotIn(List<String> values) {
            addCriterion("question_code not in", values, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeBetween(String value1, String value2) {
            addCriterion("question_code between", value1, value2, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotBetween(String value1, String value2) {
            addCriterion("question_code not between", value1, value2, "questionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeIsNull() {
            addCriterion("option_code is null");
            return (Criteria) this;
        }

        public Criteria andOptionCodeIsNotNull() {
            addCriterion("option_code is not null");
            return (Criteria) this;
        }

        public Criteria andOptionCodeEqualTo(String value) {
            addCriterion("option_code =", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeNotEqualTo(String value) {
            addCriterion("option_code <>", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeGreaterThan(String value) {
            addCriterion("option_code >", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("option_code >=", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeLessThan(String value) {
            addCriterion("option_code <", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeLessThanOrEqualTo(String value) {
            addCriterion("option_code <=", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeLike(String value) {
            addCriterion("option_code like", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeNotLike(String value) {
            addCriterion("option_code not like", value, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeIn(List<String> values) {
            addCriterion("option_code in", values, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeNotIn(List<String> values) {
            addCriterion("option_code not in", values, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeBetween(String value1, String value2) {
            addCriterion("option_code between", value1, value2, "optionCode");
            return (Criteria) this;
        }

        public Criteria andOptionCodeNotBetween(String value1, String value2) {
            addCriterion("option_code not between", value1, value2, "optionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionNoIsNull() {
            addCriterion("question_no is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNoIsNotNull() {
            addCriterion("question_no is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNoEqualTo(Integer value) {
            addCriterion("question_no =", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotEqualTo(Integer value) {
            addCriterion("question_no <>", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoGreaterThan(Integer value) {
            addCriterion("question_no >", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_no >=", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoLessThan(Integer value) {
            addCriterion("question_no <", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoLessThanOrEqualTo(Integer value) {
            addCriterion("question_no <=", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoIn(List<Integer> values) {
            addCriterion("question_no in", values, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotIn(List<Integer> values) {
            addCriterion("question_no not in", values, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoBetween(Integer value1, Integer value2) {
            addCriterion("question_no between", value1, value2, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotBetween(Integer value1, Integer value2) {
            addCriterion("question_no not between", value1, value2, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeIsNull() {
            addCriterion("questionnaire_code is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeIsNotNull() {
            addCriterion("questionnaire_code is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeEqualTo(String value) {
            addCriterion("questionnaire_code =", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeNotEqualTo(String value) {
            addCriterion("questionnaire_code <>", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeGreaterThan(String value) {
            addCriterion("questionnaire_code >", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeGreaterThanOrEqualTo(String value) {
            addCriterion("questionnaire_code >=", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeLessThan(String value) {
            addCriterion("questionnaire_code <", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeLessThanOrEqualTo(String value) {
            addCriterion("questionnaire_code <=", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeLike(String value) {
            addCriterion("questionnaire_code like", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeNotLike(String value) {
            addCriterion("questionnaire_code not like", value, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeIn(List<String> values) {
            addCriterion("questionnaire_code in", values, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeNotIn(List<String> values) {
            addCriterion("questionnaire_code not in", values, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeBetween(String value1, String value2) {
            addCriterion("questionnaire_code between", value1, value2, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireCodeNotBetween(String value1, String value2) {
            addCriterion("questionnaire_code not between", value1, value2, "questionnaireCode");
            return (Criteria) this;
        }

        public Criteria andAnswerNoIsNull() {
            addCriterion("answer_no is null");
            return (Criteria) this;
        }

        public Criteria andAnswerNoIsNotNull() {
            addCriterion("answer_no is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerNoEqualTo(Integer value) {
            addCriterion("answer_no =", value, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoNotEqualTo(Integer value) {
            addCriterion("answer_no <>", value, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoGreaterThan(Integer value) {
            addCriterion("answer_no >", value, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_no >=", value, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoLessThan(Integer value) {
            addCriterion("answer_no <", value, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoLessThanOrEqualTo(Integer value) {
            addCriterion("answer_no <=", value, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoIn(List<Integer> values) {
            addCriterion("answer_no in", values, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoNotIn(List<Integer> values) {
            addCriterion("answer_no not in", values, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoBetween(Integer value1, Integer value2) {
            addCriterion("answer_no between", value1, value2, "answerNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNoNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_no not between", value1, value2, "answerNo");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andIsRightIsNull() {
            addCriterion("is_right is null");
            return (Criteria) this;
        }

        public Criteria andIsRightIsNotNull() {
            addCriterion("is_right is not null");
            return (Criteria) this;
        }

        public Criteria andIsRightEqualTo(String value) {
            addCriterion("is_right =", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightNotEqualTo(String value) {
            addCriterion("is_right <>", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightGreaterThan(String value) {
            addCriterion("is_right >", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightGreaterThanOrEqualTo(String value) {
            addCriterion("is_right >=", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightLessThan(String value) {
            addCriterion("is_right <", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightLessThanOrEqualTo(String value) {
            addCriterion("is_right <=", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightLike(String value) {
            addCriterion("is_right like", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightNotLike(String value) {
            addCriterion("is_right not like", value, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightIn(List<String> values) {
            addCriterion("is_right in", values, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightNotIn(List<String> values) {
            addCriterion("is_right not in", values, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightBetween(String value1, String value2) {
            addCriterion("is_right between", value1, value2, "isRight");
            return (Criteria) this;
        }

        public Criteria andIsRightNotBetween(String value1, String value2) {
            addCriterion("is_right not between", value1, value2, "isRight");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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