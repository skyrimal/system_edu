package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.List;

public class AssignmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssignmentExample() {
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

        public Criteria andIsteamIsNull() {
            addCriterion("isteam is null");
            return (Criteria) this;
        }

        public Criteria andIsteamIsNotNull() {
            addCriterion("isteam is not null");
            return (Criteria) this;
        }

        public Criteria andIsteamEqualTo(String value) {
            addCriterion("isteam =", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamNotEqualTo(String value) {
            addCriterion("isteam <>", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamGreaterThan(String value) {
            addCriterion("isteam >", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamGreaterThanOrEqualTo(String value) {
            addCriterion("isteam >=", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamLessThan(String value) {
            addCriterion("isteam <", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamLessThanOrEqualTo(String value) {
            addCriterion("isteam <=", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamLike(String value) {
            addCriterion("isteam like", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamNotLike(String value) {
            addCriterion("isteam not like", value, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamIn(List<String> values) {
            addCriterion("isteam in", values, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamNotIn(List<String> values) {
            addCriterion("isteam not in", values, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamBetween(String value1, String value2) {
            addCriterion("isteam between", value1, value2, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsteamNotBetween(String value1, String value2) {
            addCriterion("isteam not between", value1, value2, "isteam");
            return (Criteria) this;
        }

        public Criteria andIsacessIsNull() {
            addCriterion("isacess is null");
            return (Criteria) this;
        }

        public Criteria andIsacessIsNotNull() {
            addCriterion("isacess is not null");
            return (Criteria) this;
        }

        public Criteria andIsacessEqualTo(String value) {
            addCriterion("isacess =", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessNotEqualTo(String value) {
            addCriterion("isacess <>", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessGreaterThan(String value) {
            addCriterion("isacess >", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessGreaterThanOrEqualTo(String value) {
            addCriterion("isacess >=", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessLessThan(String value) {
            addCriterion("isacess <", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessLessThanOrEqualTo(String value) {
            addCriterion("isacess <=", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessLike(String value) {
            addCriterion("isacess like", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessNotLike(String value) {
            addCriterion("isacess not like", value, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessIn(List<String> values) {
            addCriterion("isacess in", values, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessNotIn(List<String> values) {
            addCriterion("isacess not in", values, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessBetween(String value1, String value2) {
            addCriterion("isacess between", value1, value2, "isacess");
            return (Criteria) this;
        }

        public Criteria andIsacessNotBetween(String value1, String value2) {
            addCriterion("isacess not between", value1, value2, "isacess");
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