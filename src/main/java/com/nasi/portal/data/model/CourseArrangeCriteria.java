package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseArrangeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public CourseArrangeCriteria() {
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

    public void setStart(Integer start) {
        this.start=start;
    }

    public Integer getStart() {
        return start;
    }

    public void setEnd(Integer end) {
        this.end=end;
    }

    public Integer getEnd() {
        return end;
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Integer value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Integer value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Integer value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Integer value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Integer> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Integer> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnIsNull() {
            addCriterion("school_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnIsNotNull() {
            addCriterion("school_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnEqualTo(String value) {
            addCriterion("school_name_cn =", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotEqualTo(String value) {
            addCriterion("school_name_cn <>", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnGreaterThan(String value) {
            addCriterion("school_name_cn >", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("school_name_cn >=", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnLessThan(String value) {
            addCriterion("school_name_cn <", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnLessThanOrEqualTo(String value) {
            addCriterion("school_name_cn <=", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnLike(String value) {
            addCriterion("school_name_cn like", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotLike(String value) {
            addCriterion("school_name_cn not like", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnIn(List<String> values) {
            addCriterion("school_name_cn in", values, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotIn(List<String> values) {
            addCriterion("school_name_cn not in", values, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnBetween(String value1, String value2) {
            addCriterion("school_name_cn between", value1, value2, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotBetween(String value1, String value2) {
            addCriterion("school_name_cn not between", value1, value2, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIsNull() {
            addCriterion("school_name_en is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIsNotNull() {
            addCriterion("school_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnEqualTo(String value) {
            addCriterion("school_name_en =", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotEqualTo(String value) {
            addCriterion("school_name_en <>", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnGreaterThan(String value) {
            addCriterion("school_name_en >", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("school_name_en >=", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLessThan(String value) {
            addCriterion("school_name_en <", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLessThanOrEqualTo(String value) {
            addCriterion("school_name_en <=", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLike(String value) {
            addCriterion("school_name_en like", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotLike(String value) {
            addCriterion("school_name_en not like", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIn(List<String> values) {
            addCriterion("school_name_en in", values, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotIn(List<String> values) {
            addCriterion("school_name_en not in", values, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnBetween(String value1, String value2) {
            addCriterion("school_name_en between", value1, value2, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotBetween(String value1, String value2) {
            addCriterion("school_name_en not between", value1, value2, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnIsNull() {
            addCriterion("course_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnIsNotNull() {
            addCriterion("course_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnEqualTo(String value) {
            addCriterion("course_name_cn =", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnNotEqualTo(String value) {
            addCriterion("course_name_cn <>", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnGreaterThan(String value) {
            addCriterion("course_name_cn >", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("course_name_cn >=", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnLessThan(String value) {
            addCriterion("course_name_cn <", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnLessThanOrEqualTo(String value) {
            addCriterion("course_name_cn <=", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnLike(String value) {
            addCriterion("course_name_cn like", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnNotLike(String value) {
            addCriterion("course_name_cn not like", value, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnIn(List<String> values) {
            addCriterion("course_name_cn in", values, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnNotIn(List<String> values) {
            addCriterion("course_name_cn not in", values, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnBetween(String value1, String value2) {
            addCriterion("course_name_cn between", value1, value2, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameCnNotBetween(String value1, String value2) {
            addCriterion("course_name_cn not between", value1, value2, "courseNameCn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnIsNull() {
            addCriterion("course_name_en is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnIsNotNull() {
            addCriterion("course_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnEqualTo(String value) {
            addCriterion("course_name_en =", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnNotEqualTo(String value) {
            addCriterion("course_name_en <>", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnGreaterThan(String value) {
            addCriterion("course_name_en >", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("course_name_en >=", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnLessThan(String value) {
            addCriterion("course_name_en <", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnLessThanOrEqualTo(String value) {
            addCriterion("course_name_en <=", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnLike(String value) {
            addCriterion("course_name_en like", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnNotLike(String value) {
            addCriterion("course_name_en not like", value, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnIn(List<String> values) {
            addCriterion("course_name_en in", values, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnNotIn(List<String> values) {
            addCriterion("course_name_en not in", values, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnBetween(String value1, String value2) {
            addCriterion("course_name_en between", value1, value2, "courseNameEn");
            return (Criteria) this;
        }

        public Criteria andCourseNameEnNotBetween(String value1, String value2) {
            addCriterion("course_name_en not between", value1, value2, "courseNameEn");
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

        public Criteria andProfessorIdIsNull() {
            addCriterion("professor_id is null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIsNotNull() {
            addCriterion("professor_id is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdEqualTo(Integer value) {
            addCriterion("professor_id =", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotEqualTo(Integer value) {
            addCriterion("professor_id <>", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThan(Integer value) {
            addCriterion("professor_id >", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("professor_id >=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThan(Integer value) {
            addCriterion("professor_id <", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThanOrEqualTo(Integer value) {
            addCriterion("professor_id <=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIn(List<Integer> values) {
            addCriterion("professor_id in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotIn(List<Integer> values) {
            addCriterion("professor_id not in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdBetween(Integer value1, Integer value2) {
            addCriterion("professor_id between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("professor_id not between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnIsNull() {
            addCriterion("professor_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnIsNotNull() {
            addCriterion("professor_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnEqualTo(String value) {
            addCriterion("professor_name_cn =", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotEqualTo(String value) {
            addCriterion("professor_name_cn <>", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnGreaterThan(String value) {
            addCriterion("professor_name_cn >", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("professor_name_cn >=", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnLessThan(String value) {
            addCriterion("professor_name_cn <", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnLessThanOrEqualTo(String value) {
            addCriterion("professor_name_cn <=", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnLike(String value) {
            addCriterion("professor_name_cn like", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotLike(String value) {
            addCriterion("professor_name_cn not like", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnIn(List<String> values) {
            addCriterion("professor_name_cn in", values, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotIn(List<String> values) {
            addCriterion("professor_name_cn not in", values, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnBetween(String value1, String value2) {
            addCriterion("professor_name_cn between", value1, value2, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotBetween(String value1, String value2) {
            addCriterion("professor_name_cn not between", value1, value2, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnIsNull() {
            addCriterion("professor_name_en is null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnIsNotNull() {
            addCriterion("professor_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnEqualTo(String value) {
            addCriterion("professor_name_en =", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotEqualTo(String value) {
            addCriterion("professor_name_en <>", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnGreaterThan(String value) {
            addCriterion("professor_name_en >", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("professor_name_en >=", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnLessThan(String value) {
            addCriterion("professor_name_en <", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnLessThanOrEqualTo(String value) {
            addCriterion("professor_name_en <=", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnLike(String value) {
            addCriterion("professor_name_en like", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotLike(String value) {
            addCriterion("professor_name_en not like", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnIn(List<String> values) {
            addCriterion("professor_name_en in", values, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotIn(List<String> values) {
            addCriterion("professor_name_en not in", values, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnBetween(String value1, String value2) {
            addCriterion("professor_name_en between", value1, value2, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotBetween(String value1, String value2) {
            addCriterion("professor_name_en not between", value1, value2, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnIsNull() {
            addCriterion("professor_from_school_cn is null");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnIsNotNull() {
            addCriterion("professor_from_school_cn is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnEqualTo(String value) {
            addCriterion("professor_from_school_cn =", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnNotEqualTo(String value) {
            addCriterion("professor_from_school_cn <>", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnGreaterThan(String value) {
            addCriterion("professor_from_school_cn >", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnGreaterThanOrEqualTo(String value) {
            addCriterion("professor_from_school_cn >=", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnLessThan(String value) {
            addCriterion("professor_from_school_cn <", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnLessThanOrEqualTo(String value) {
            addCriterion("professor_from_school_cn <=", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnLike(String value) {
            addCriterion("professor_from_school_cn like", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnNotLike(String value) {
            addCriterion("professor_from_school_cn not like", value, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnIn(List<String> values) {
            addCriterion("professor_from_school_cn in", values, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnNotIn(List<String> values) {
            addCriterion("professor_from_school_cn not in", values, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnBetween(String value1, String value2) {
            addCriterion("professor_from_school_cn between", value1, value2, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolCnNotBetween(String value1, String value2) {
            addCriterion("professor_from_school_cn not between", value1, value2, "professorFromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnIsNull() {
            addCriterion("professor_from_school_en is null");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnIsNotNull() {
            addCriterion("professor_from_school_en is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnEqualTo(String value) {
            addCriterion("professor_from_school_en =", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnNotEqualTo(String value) {
            addCriterion("professor_from_school_en <>", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnGreaterThan(String value) {
            addCriterion("professor_from_school_en >", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnGreaterThanOrEqualTo(String value) {
            addCriterion("professor_from_school_en >=", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnLessThan(String value) {
            addCriterion("professor_from_school_en <", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnLessThanOrEqualTo(String value) {
            addCriterion("professor_from_school_en <=", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnLike(String value) {
            addCriterion("professor_from_school_en like", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnNotLike(String value) {
            addCriterion("professor_from_school_en not like", value, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnIn(List<String> values) {
            addCriterion("professor_from_school_en in", values, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnNotIn(List<String> values) {
            addCriterion("professor_from_school_en not in", values, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnBetween(String value1, String value2) {
            addCriterion("professor_from_school_en between", value1, value2, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andProfessorFromSchoolEnNotBetween(String value1, String value2) {
            addCriterion("professor_from_school_en not between", value1, value2, "professorFromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeIsNull() {
            addCriterion("course_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeIsNotNull() {
            addCriterion("course_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("course_start_time =", value, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("course_start_time <>", value, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("course_start_time >", value, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("course_start_time >=", value, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("course_start_time <", value, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("course_start_time <=", value, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("course_start_time in", values, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("course_start_time not in", values, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("course_start_time between", value1, value2, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("course_start_time not between", value1, value2, "courseStartTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeIsNull() {
            addCriterion("course_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeIsNotNull() {
            addCriterion("course_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("course_end_time =", value, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("course_end_time <>", value, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("course_end_time >", value, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("course_end_time >=", value, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("course_end_time <", value, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("course_end_time <=", value, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("course_end_time in", values, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("course_end_time not in", values, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("course_end_time between", value1, value2, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andCourseEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("course_end_time not between", value1, value2, "courseEndTime");
            return (Criteria) this;
        }

        public Criteria andAttachPathIsNull() {
            addCriterion("attach_path is null");
            return (Criteria) this;
        }

        public Criteria andAttachPathIsNotNull() {
            addCriterion("attach_path is not null");
            return (Criteria) this;
        }

        public Criteria andAttachPathEqualTo(String value) {
            addCriterion("attach_path =", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathNotEqualTo(String value) {
            addCriterion("attach_path <>", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathGreaterThan(String value) {
            addCriterion("attach_path >", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathGreaterThanOrEqualTo(String value) {
            addCriterion("attach_path >=", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathLessThan(String value) {
            addCriterion("attach_path <", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathLessThanOrEqualTo(String value) {
            addCriterion("attach_path <=", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathLike(String value) {
            addCriterion("attach_path like", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathNotLike(String value) {
            addCriterion("attach_path not like", value, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathIn(List<String> values) {
            addCriterion("attach_path in", values, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathNotIn(List<String> values) {
            addCriterion("attach_path not in", values, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathBetween(String value1, String value2) {
            addCriterion("attach_path between", value1, value2, "attachPath");
            return (Criteria) this;
        }

        public Criteria andAttachPathNotBetween(String value1, String value2) {
            addCriterion("attach_path not between", value1, value2, "attachPath");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
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