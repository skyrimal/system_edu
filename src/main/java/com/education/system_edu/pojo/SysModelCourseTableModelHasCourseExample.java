package com.education.system_edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysModelCourseTableModelHasCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysModelCourseTableModelHasCourseExample() {
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

        public Criteria andCourseTableCodeIsNull() {
            addCriterion("course_table_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeIsNotNull() {
            addCriterion("course_table_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeEqualTo(String value) {
            addCriterion("course_table_code =", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeNotEqualTo(String value) {
            addCriterion("course_table_code <>", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeGreaterThan(String value) {
            addCriterion("course_table_code >", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_table_code >=", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeLessThan(String value) {
            addCriterion("course_table_code <", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeLessThanOrEqualTo(String value) {
            addCriterion("course_table_code <=", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeLike(String value) {
            addCriterion("course_table_code like", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeNotLike(String value) {
            addCriterion("course_table_code not like", value, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeIn(List<String> values) {
            addCriterion("course_table_code in", values, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeNotIn(List<String> values) {
            addCriterion("course_table_code not in", values, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeBetween(String value1, String value2) {
            addCriterion("course_table_code between", value1, value2, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseTableCodeNotBetween(String value1, String value2) {
            addCriterion("course_table_code not between", value1, value2, "courseTableCode");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(String value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(String value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(String value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(String value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLike(String value) {
            addCriterion("course_code like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotLike(String value) {
            addCriterion("course_code not like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<String> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<String> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(String value1, String value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(String value1, String value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNull() {
            addCriterion("class_code is null");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNotNull() {
            addCriterion("class_code is not null");
            return (Criteria) this;
        }

        public Criteria andClassCodeEqualTo(String value) {
            addCriterion("class_code =", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotEqualTo(String value) {
            addCriterion("class_code <>", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThan(String value) {
            addCriterion("class_code >", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("class_code >=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThan(String value) {
            addCriterion("class_code <", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThanOrEqualTo(String value) {
            addCriterion("class_code <=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLike(String value) {
            addCriterion("class_code like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotLike(String value) {
            addCriterion("class_code not like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeIn(List<String> values) {
            addCriterion("class_code in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotIn(List<String> values) {
            addCriterion("class_code not in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeBetween(String value1, String value2) {
            addCriterion("class_code between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotBetween(String value1, String value2) {
            addCriterion("class_code not between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeIsNull() {
            addCriterion("teacher_code is null");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeIsNotNull() {
            addCriterion("teacher_code is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeEqualTo(String value) {
            addCriterion("teacher_code =", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotEqualTo(String value) {
            addCriterion("teacher_code <>", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeGreaterThan(String value) {
            addCriterion("teacher_code >", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_code >=", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeLessThan(String value) {
            addCriterion("teacher_code <", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeLessThanOrEqualTo(String value) {
            addCriterion("teacher_code <=", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeLike(String value) {
            addCriterion("teacher_code like", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotLike(String value) {
            addCriterion("teacher_code not like", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeIn(List<String> values) {
            addCriterion("teacher_code in", values, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotIn(List<String> values) {
            addCriterion("teacher_code not in", values, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeBetween(String value1, String value2) {
            addCriterion("teacher_code between", value1, value2, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotBetween(String value1, String value2) {
            addCriterion("teacher_code not between", value1, value2, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeIsNull() {
            addCriterion("couese_time_code is null");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeIsNotNull() {
            addCriterion("couese_time_code is not null");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeEqualTo(String value) {
            addCriterion("couese_time_code =", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeNotEqualTo(String value) {
            addCriterion("couese_time_code <>", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeGreaterThan(String value) {
            addCriterion("couese_time_code >", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("couese_time_code >=", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeLessThan(String value) {
            addCriterion("couese_time_code <", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeLessThanOrEqualTo(String value) {
            addCriterion("couese_time_code <=", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeLike(String value) {
            addCriterion("couese_time_code like", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeNotLike(String value) {
            addCriterion("couese_time_code not like", value, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeIn(List<String> values) {
            addCriterion("couese_time_code in", values, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeNotIn(List<String> values) {
            addCriterion("couese_time_code not in", values, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeBetween(String value1, String value2) {
            addCriterion("couese_time_code between", value1, value2, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andCoueseTimeCodeNotBetween(String value1, String value2) {
            addCriterion("couese_time_code not between", value1, value2, "coueseTimeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeIsNull() {
            addCriterion("sys_college_node_code is null");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeIsNotNull() {
            addCriterion("sys_college_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeEqualTo(String value) {
            addCriterion("sys_college_node_code =", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeNotEqualTo(String value) {
            addCriterion("sys_college_node_code <>", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeGreaterThan(String value) {
            addCriterion("sys_college_node_code >", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_college_node_code >=", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeLessThan(String value) {
            addCriterion("sys_college_node_code <", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_college_node_code <=", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeLike(String value) {
            addCriterion("sys_college_node_code like", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeNotLike(String value) {
            addCriterion("sys_college_node_code not like", value, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeIn(List<String> values) {
            addCriterion("sys_college_node_code in", values, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeNotIn(List<String> values) {
            addCriterion("sys_college_node_code not in", values, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeBetween(String value1, String value2) {
            addCriterion("sys_college_node_code between", value1, value2, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeCodeNotBetween(String value1, String value2) {
            addCriterion("sys_college_node_code not between", value1, value2, "sysCollegeNodeCode");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeIsNull() {
            addCriterion("sys_college_node_type is null");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeIsNotNull() {
            addCriterion("sys_college_node_type is not null");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeEqualTo(Short value) {
            addCriterion("sys_college_node_type =", value, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeNotEqualTo(Short value) {
            addCriterion("sys_college_node_type <>", value, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeGreaterThan(Short value) {
            addCriterion("sys_college_node_type >", value, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("sys_college_node_type >=", value, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeLessThan(Short value) {
            addCriterion("sys_college_node_type <", value, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeLessThanOrEqualTo(Short value) {
            addCriterion("sys_college_node_type <=", value, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeIn(List<Short> values) {
            addCriterion("sys_college_node_type in", values, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeNotIn(List<Short> values) {
            addCriterion("sys_college_node_type not in", values, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeBetween(Short value1, Short value2) {
            addCriterion("sys_college_node_type between", value1, value2, "sysCollegeNodeType");
            return (Criteria) this;
        }

        public Criteria andSysCollegeNodeTypeNotBetween(Short value1, Short value2) {
            addCriterion("sys_college_node_type not between", value1, value2, "sysCollegeNodeType");
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

        public Criteria andSysRoleNodeTypeEqualTo(Short value) {
            addCriterion("sys_role_node_type =", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotEqualTo(Short value) {
            addCriterion("sys_role_node_type <>", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeGreaterThan(Short value) {
            addCriterion("sys_role_node_type >", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("sys_role_node_type >=", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeLessThan(Short value) {
            addCriterion("sys_role_node_type <", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeLessThanOrEqualTo(Short value) {
            addCriterion("sys_role_node_type <=", value, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeIn(List<Short> values) {
            addCriterion("sys_role_node_type in", values, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotIn(List<Short> values) {
            addCriterion("sys_role_node_type not in", values, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeBetween(Short value1, Short value2) {
            addCriterion("sys_role_node_type between", value1, value2, "sysRoleNodeType");
            return (Criteria) this;
        }

        public Criteria andSysRoleNodeTypeNotBetween(Short value1, Short value2) {
            addCriterion("sys_role_node_type not between", value1, value2, "sysRoleNodeType");
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