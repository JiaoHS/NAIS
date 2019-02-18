package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseHomeWorkCommitCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public CourseHomeWorkCommitCriteria() {
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

        public Criteria andAssignIdIsNull() {
            addCriterion("assign_id is null");
            return (Criteria) this;
        }

        public Criteria andAssignIdIsNotNull() {
            addCriterion("assign_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssignIdEqualTo(Long value) {
            addCriterion("assign_id =", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotEqualTo(Long value) {
            addCriterion("assign_id <>", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThan(Long value) {
            addCriterion("assign_id >", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assign_id >=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThan(Long value) {
            addCriterion("assign_id <", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThanOrEqualTo(Long value) {
            addCriterion("assign_id <=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdIn(List<Long> values) {
            addCriterion("assign_id in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotIn(List<Long> values) {
            addCriterion("assign_id not in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdBetween(Long value1, Long value2) {
            addCriterion("assign_id between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotBetween(Long value1, Long value2) {
            addCriterion("assign_id not between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignNameIsNull() {
            addCriterion("assign_name is null");
            return (Criteria) this;
        }

        public Criteria andAssignNameIsNotNull() {
            addCriterion("assign_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssignNameEqualTo(String value) {
            addCriterion("assign_name =", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameNotEqualTo(String value) {
            addCriterion("assign_name <>", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameGreaterThan(String value) {
            addCriterion("assign_name >", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameGreaterThanOrEqualTo(String value) {
            addCriterion("assign_name >=", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameLessThan(String value) {
            addCriterion("assign_name <", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameLessThanOrEqualTo(String value) {
            addCriterion("assign_name <=", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameLike(String value) {
            addCriterion("assign_name like", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameNotLike(String value) {
            addCriterion("assign_name not like", value, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameIn(List<String> values) {
            addCriterion("assign_name in", values, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameNotIn(List<String> values) {
            addCriterion("assign_name not in", values, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameBetween(String value1, String value2) {
            addCriterion("assign_name between", value1, value2, "assignName");
            return (Criteria) this;
        }

        public Criteria andAssignNameNotBetween(String value1, String value2) {
            addCriterion("assign_name not between", value1, value2, "assignName");
            return (Criteria) this;
        }

        public Criteria andArrangeIdIsNull() {
            addCriterion("arrange_id is null");
            return (Criteria) this;
        }

        public Criteria andArrangeIdIsNotNull() {
            addCriterion("arrange_id is not null");
            return (Criteria) this;
        }

        public Criteria andArrangeIdEqualTo(Long value) {
            addCriterion("arrange_id =", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdNotEqualTo(Long value) {
            addCriterion("arrange_id <>", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdGreaterThan(Long value) {
            addCriterion("arrange_id >", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("arrange_id >=", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdLessThan(Long value) {
            addCriterion("arrange_id <", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdLessThanOrEqualTo(Long value) {
            addCriterion("arrange_id <=", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdIn(List<Long> values) {
            addCriterion("arrange_id in", values, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdNotIn(List<Long> values) {
            addCriterion("arrange_id not in", values, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdBetween(Long value1, Long value2) {
            addCriterion("arrange_id between", value1, value2, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdNotBetween(Long value1, Long value2) {
            addCriterion("arrange_id not between", value1, value2, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnIsNull() {
            addCriterion("student_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnIsNotNull() {
            addCriterion("student_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnEqualTo(String value) {
            addCriterion("student_name_cn =", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnNotEqualTo(String value) {
            addCriterion("student_name_cn <>", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnGreaterThan(String value) {
            addCriterion("student_name_cn >", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("student_name_cn >=", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnLessThan(String value) {
            addCriterion("student_name_cn <", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnLessThanOrEqualTo(String value) {
            addCriterion("student_name_cn <=", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnLike(String value) {
            addCriterion("student_name_cn like", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnNotLike(String value) {
            addCriterion("student_name_cn not like", value, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnIn(List<String> values) {
            addCriterion("student_name_cn in", values, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnNotIn(List<String> values) {
            addCriterion("student_name_cn not in", values, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnBetween(String value1, String value2) {
            addCriterion("student_name_cn between", value1, value2, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameCnNotBetween(String value1, String value2) {
            addCriterion("student_name_cn not between", value1, value2, "studentNameCn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnIsNull() {
            addCriterion("student_name_en is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnIsNotNull() {
            addCriterion("student_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnEqualTo(String value) {
            addCriterion("student_name_en =", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnNotEqualTo(String value) {
            addCriterion("student_name_en <>", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnGreaterThan(String value) {
            addCriterion("student_name_en >", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("student_name_en >=", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnLessThan(String value) {
            addCriterion("student_name_en <", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnLessThanOrEqualTo(String value) {
            addCriterion("student_name_en <=", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnLike(String value) {
            addCriterion("student_name_en like", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnNotLike(String value) {
            addCriterion("student_name_en not like", value, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnIn(List<String> values) {
            addCriterion("student_name_en in", values, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnNotIn(List<String> values) {
            addCriterion("student_name_en not in", values, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnBetween(String value1, String value2) {
            addCriterion("student_name_en between", value1, value2, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEnNotBetween(String value1, String value2) {
            addCriterion("student_name_en not between", value1, value2, "studentNameEn");
            return (Criteria) this;
        }

        public Criteria andCommitStatusIsNull() {
            addCriterion("commit_status is null");
            return (Criteria) this;
        }

        public Criteria andCommitStatusIsNotNull() {
            addCriterion("commit_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommitStatusEqualTo(Integer value) {
            addCriterion("commit_status =", value, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusNotEqualTo(Integer value) {
            addCriterion("commit_status <>", value, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusGreaterThan(Integer value) {
            addCriterion("commit_status >", value, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("commit_status >=", value, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusLessThan(Integer value) {
            addCriterion("commit_status <", value, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusLessThanOrEqualTo(Integer value) {
            addCriterion("commit_status <=", value, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusIn(List<Integer> values) {
            addCriterion("commit_status in", values, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusNotIn(List<Integer> values) {
            addCriterion("commit_status not in", values, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusBetween(Integer value1, Integer value2) {
            addCriterion("commit_status between", value1, value2, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("commit_status not between", value1, value2, "commitStatus");
            return (Criteria) this;
        }

        public Criteria andCommitTypeIsNull() {
            addCriterion("commit_type is null");
            return (Criteria) this;
        }

        public Criteria andCommitTypeIsNotNull() {
            addCriterion("commit_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTypeEqualTo(Integer value) {
            addCriterion("commit_type =", value, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeNotEqualTo(Integer value) {
            addCriterion("commit_type <>", value, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeGreaterThan(Integer value) {
            addCriterion("commit_type >", value, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("commit_type >=", value, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeLessThan(Integer value) {
            addCriterion("commit_type <", value, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeLessThanOrEqualTo(Integer value) {
            addCriterion("commit_type <=", value, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeIn(List<Integer> values) {
            addCriterion("commit_type in", values, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeNotIn(List<Integer> values) {
            addCriterion("commit_type not in", values, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeBetween(Integer value1, Integer value2) {
            addCriterion("commit_type between", value1, value2, "commitType");
            return (Criteria) this;
        }

        public Criteria andCommitTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("commit_type not between", value1, value2, "commitType");
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

        public Criteria andWorkPathIsNull() {
            addCriterion("work_path is null");
            return (Criteria) this;
        }

        public Criteria andWorkPathIsNotNull() {
            addCriterion("work_path is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPathEqualTo(String value) {
            addCriterion("work_path =", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathNotEqualTo(String value) {
            addCriterion("work_path <>", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathGreaterThan(String value) {
            addCriterion("work_path >", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathGreaterThanOrEqualTo(String value) {
            addCriterion("work_path >=", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathLessThan(String value) {
            addCriterion("work_path <", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathLessThanOrEqualTo(String value) {
            addCriterion("work_path <=", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathLike(String value) {
            addCriterion("work_path like", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathNotLike(String value) {
            addCriterion("work_path not like", value, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathIn(List<String> values) {
            addCriterion("work_path in", values, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathNotIn(List<String> values) {
            addCriterion("work_path not in", values, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathBetween(String value1, String value2) {
            addCriterion("work_path between", value1, value2, "workPath");
            return (Criteria) this;
        }

        public Criteria andWorkPathNotBetween(String value1, String value2) {
            addCriterion("work_path not between", value1, value2, "workPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathIsNull() {
            addCriterion("commit_path is null");
            return (Criteria) this;
        }

        public Criteria andCommitPathIsNotNull() {
            addCriterion("commit_path is not null");
            return (Criteria) this;
        }

        public Criteria andCommitPathEqualTo(String value) {
            addCriterion("commit_path =", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathNotEqualTo(String value) {
            addCriterion("commit_path <>", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathGreaterThan(String value) {
            addCriterion("commit_path >", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathGreaterThanOrEqualTo(String value) {
            addCriterion("commit_path >=", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathLessThan(String value) {
            addCriterion("commit_path <", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathLessThanOrEqualTo(String value) {
            addCriterion("commit_path <=", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathLike(String value) {
            addCriterion("commit_path like", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathNotLike(String value) {
            addCriterion("commit_path not like", value, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathIn(List<String> values) {
            addCriterion("commit_path in", values, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathNotIn(List<String> values) {
            addCriterion("commit_path not in", values, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathBetween(String value1, String value2) {
            addCriterion("commit_path between", value1, value2, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitPathNotBetween(String value1, String value2) {
            addCriterion("commit_path not between", value1, value2, "commitPath");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreIsNull() {
            addCriterion("commit_total_score is null");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreIsNotNull() {
            addCriterion("commit_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreEqualTo(Integer value) {
            addCriterion("commit_total_score =", value, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreNotEqualTo(Integer value) {
            addCriterion("commit_total_score <>", value, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreGreaterThan(Integer value) {
            addCriterion("commit_total_score >", value, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("commit_total_score >=", value, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreLessThan(Integer value) {
            addCriterion("commit_total_score <", value, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("commit_total_score <=", value, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreIn(List<Integer> values) {
            addCriterion("commit_total_score in", values, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreNotIn(List<Integer> values) {
            addCriterion("commit_total_score not in", values, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("commit_total_score between", value1, value2, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("commit_total_score not between", value1, value2, "commitTotalScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreIsNull() {
            addCriterion("commit_this_score is null");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreIsNotNull() {
            addCriterion("commit_this_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreEqualTo(Integer value) {
            addCriterion("commit_this_score =", value, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreNotEqualTo(Integer value) {
            addCriterion("commit_this_score <>", value, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreGreaterThan(Integer value) {
            addCriterion("commit_this_score >", value, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("commit_this_score >=", value, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreLessThan(Integer value) {
            addCriterion("commit_this_score <", value, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreLessThanOrEqualTo(Integer value) {
            addCriterion("commit_this_score <=", value, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreIn(List<Integer> values) {
            addCriterion("commit_this_score in", values, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreNotIn(List<Integer> values) {
            addCriterion("commit_this_score not in", values, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreBetween(Integer value1, Integer value2) {
            addCriterion("commit_this_score between", value1, value2, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitThisScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("commit_this_score not between", value1, value2, "commitThisScore");
            return (Criteria) this;
        }

        public Criteria andCommitDescIsNull() {
            addCriterion("commit_desc is null");
            return (Criteria) this;
        }

        public Criteria andCommitDescIsNotNull() {
            addCriterion("commit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCommitDescEqualTo(String value) {
            addCriterion("commit_desc =", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescNotEqualTo(String value) {
            addCriterion("commit_desc <>", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescGreaterThan(String value) {
            addCriterion("commit_desc >", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescGreaterThanOrEqualTo(String value) {
            addCriterion("commit_desc >=", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescLessThan(String value) {
            addCriterion("commit_desc <", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescLessThanOrEqualTo(String value) {
            addCriterion("commit_desc <=", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescLike(String value) {
            addCriterion("commit_desc like", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescNotLike(String value) {
            addCriterion("commit_desc not like", value, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescIn(List<String> values) {
            addCriterion("commit_desc in", values, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescNotIn(List<String> values) {
            addCriterion("commit_desc not in", values, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescBetween(String value1, String value2) {
            addCriterion("commit_desc between", value1, value2, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitDescNotBetween(String value1, String value2) {
            addCriterion("commit_desc not between", value1, value2, "commitDesc");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("commit_time is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("commit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Date value) {
            addCriterion("commit_time =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Date value) {
            addCriterion("commit_time <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Date value) {
            addCriterion("commit_time >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commit_time >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Date value) {
            addCriterion("commit_time <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("commit_time <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Date> values) {
            addCriterion("commit_time in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Date> values) {
            addCriterion("commit_time not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Date value1, Date value2) {
            addCriterion("commit_time between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("commit_time not between", value1, value2, "commitTime");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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