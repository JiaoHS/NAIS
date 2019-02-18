package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseWareCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public CourseWareCriteria() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWareNameCnIsNull() {
            addCriterion("ware_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andWareNameCnIsNotNull() {
            addCriterion("ware_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andWareNameCnEqualTo(String value) {
            addCriterion("ware_name_cn =", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnNotEqualTo(String value) {
            addCriterion("ware_name_cn <>", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnGreaterThan(String value) {
            addCriterion("ware_name_cn >", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("ware_name_cn >=", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnLessThan(String value) {
            addCriterion("ware_name_cn <", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnLessThanOrEqualTo(String value) {
            addCriterion("ware_name_cn <=", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnLike(String value) {
            addCriterion("ware_name_cn like", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnNotLike(String value) {
            addCriterion("ware_name_cn not like", value, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnIn(List<String> values) {
            addCriterion("ware_name_cn in", values, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnNotIn(List<String> values) {
            addCriterion("ware_name_cn not in", values, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnBetween(String value1, String value2) {
            addCriterion("ware_name_cn between", value1, value2, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameCnNotBetween(String value1, String value2) {
            addCriterion("ware_name_cn not between", value1, value2, "wareNameCn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnIsNull() {
            addCriterion("ware_name_en is null");
            return (Criteria) this;
        }

        public Criteria andWareNameEnIsNotNull() {
            addCriterion("ware_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andWareNameEnEqualTo(String value) {
            addCriterion("ware_name_en =", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnNotEqualTo(String value) {
            addCriterion("ware_name_en <>", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnGreaterThan(String value) {
            addCriterion("ware_name_en >", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("ware_name_en >=", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnLessThan(String value) {
            addCriterion("ware_name_en <", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnLessThanOrEqualTo(String value) {
            addCriterion("ware_name_en <=", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnLike(String value) {
            addCriterion("ware_name_en like", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnNotLike(String value) {
            addCriterion("ware_name_en not like", value, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnIn(List<String> values) {
            addCriterion("ware_name_en in", values, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnNotIn(List<String> values) {
            addCriterion("ware_name_en not in", values, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnBetween(String value1, String value2) {
            addCriterion("ware_name_en between", value1, value2, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameEnNotBetween(String value1, String value2) {
            addCriterion("ware_name_en not between", value1, value2, "wareNameEn");
            return (Criteria) this;
        }

        public Criteria andWareNameCountIsNull() {
            addCriterion("ware_name_count is null");
            return (Criteria) this;
        }

        public Criteria andWareNameCountIsNotNull() {
            addCriterion("ware_name_count is not null");
            return (Criteria) this;
        }

        public Criteria andWareNameCountEqualTo(Integer value) {
            addCriterion("ware_name_count =", value, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountNotEqualTo(Integer value) {
            addCriterion("ware_name_count <>", value, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountGreaterThan(Integer value) {
            addCriterion("ware_name_count >", value, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ware_name_count >=", value, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountLessThan(Integer value) {
            addCriterion("ware_name_count <", value, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountLessThanOrEqualTo(Integer value) {
            addCriterion("ware_name_count <=", value, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountIn(List<Integer> values) {
            addCriterion("ware_name_count in", values, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountNotIn(List<Integer> values) {
            addCriterion("ware_name_count not in", values, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountBetween(Integer value1, Integer value2) {
            addCriterion("ware_name_count between", value1, value2, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareNameCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ware_name_count not between", value1, value2, "wareNameCount");
            return (Criteria) this;
        }

        public Criteria andWareStatusIsNull() {
            addCriterion("ware_status is null");
            return (Criteria) this;
        }

        public Criteria andWareStatusIsNotNull() {
            addCriterion("ware_status is not null");
            return (Criteria) this;
        }

        public Criteria andWareStatusEqualTo(Integer value) {
            addCriterion("ware_status =", value, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusNotEqualTo(Integer value) {
            addCriterion("ware_status <>", value, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusGreaterThan(Integer value) {
            addCriterion("ware_status >", value, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ware_status >=", value, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusLessThan(Integer value) {
            addCriterion("ware_status <", value, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ware_status <=", value, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusIn(List<Integer> values) {
            addCriterion("ware_status in", values, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusNotIn(List<Integer> values) {
            addCriterion("ware_status not in", values, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusBetween(Integer value1, Integer value2) {
            addCriterion("ware_status between", value1, value2, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ware_status not between", value1, value2, "wareStatus");
            return (Criteria) this;
        }

        public Criteria andWareNameDescIsNull() {
            addCriterion("ware_name_desc is null");
            return (Criteria) this;
        }

        public Criteria andWareNameDescIsNotNull() {
            addCriterion("ware_name_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWareNameDescEqualTo(String value) {
            addCriterion("ware_name_desc =", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescNotEqualTo(String value) {
            addCriterion("ware_name_desc <>", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescGreaterThan(String value) {
            addCriterion("ware_name_desc >", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescGreaterThanOrEqualTo(String value) {
            addCriterion("ware_name_desc >=", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescLessThan(String value) {
            addCriterion("ware_name_desc <", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescLessThanOrEqualTo(String value) {
            addCriterion("ware_name_desc <=", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescLike(String value) {
            addCriterion("ware_name_desc like", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescNotLike(String value) {
            addCriterion("ware_name_desc not like", value, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescIn(List<String> values) {
            addCriterion("ware_name_desc in", values, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescNotIn(List<String> values) {
            addCriterion("ware_name_desc not in", values, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescBetween(String value1, String value2) {
            addCriterion("ware_name_desc between", value1, value2, "wareNameDesc");
            return (Criteria) this;
        }

        public Criteria andWareNameDescNotBetween(String value1, String value2) {
            addCriterion("ware_name_desc not between", value1, value2, "wareNameDesc");
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

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
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

        public Criteria andWarePathIsNull() {
            addCriterion("ware_path is null");
            return (Criteria) this;
        }

        public Criteria andWarePathIsNotNull() {
            addCriterion("ware_path is not null");
            return (Criteria) this;
        }

        public Criteria andWarePathEqualTo(String value) {
            addCriterion("ware_path =", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathNotEqualTo(String value) {
            addCriterion("ware_path <>", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathGreaterThan(String value) {
            addCriterion("ware_path >", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathGreaterThanOrEqualTo(String value) {
            addCriterion("ware_path >=", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathLessThan(String value) {
            addCriterion("ware_path <", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathLessThanOrEqualTo(String value) {
            addCriterion("ware_path <=", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathLike(String value) {
            addCriterion("ware_path like", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathNotLike(String value) {
            addCriterion("ware_path not like", value, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathIn(List<String> values) {
            addCriterion("ware_path in", values, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathNotIn(List<String> values) {
            addCriterion("ware_path not in", values, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathBetween(String value1, String value2) {
            addCriterion("ware_path between", value1, value2, "warePath");
            return (Criteria) this;
        }

        public Criteria andWarePathNotBetween(String value1, String value2) {
            addCriterion("ware_path not between", value1, value2, "warePath");
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