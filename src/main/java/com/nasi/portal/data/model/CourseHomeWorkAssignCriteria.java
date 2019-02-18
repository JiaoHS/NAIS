package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseHomeWorkAssignCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public CourseHomeWorkAssignCriteria() {
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

        public Criteria andWorkNameIsNull() {
            addCriterion("work_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNotNull() {
            addCriterion("work_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNameEqualTo(String value) {
            addCriterion("work_name =", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotEqualTo(String value) {
            addCriterion("work_name <>", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThan(String value) {
            addCriterion("work_name >", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_name >=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThan(String value) {
            addCriterion("work_name <", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThanOrEqualTo(String value) {
            addCriterion("work_name <=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLike(String value) {
            addCriterion("work_name like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotLike(String value) {
            addCriterion("work_name not like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameIn(List<String> values) {
            addCriterion("work_name in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotIn(List<String> values) {
            addCriterion("work_name not in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameBetween(String value1, String value2) {
            addCriterion("work_name between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotBetween(String value1, String value2) {
            addCriterion("work_name not between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(Integer value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(Integer value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(Integer value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(Integer value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(List<Integer> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(List<Integer> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(Integer value1, Integer value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(Integer value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(Integer value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(Integer value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(Integer value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(Integer value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<Integer> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<Integer> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(Integer value1, Integer value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("work_type not between", value1, value2, "workType");
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

        public Criteria andDeadLineTimeIsNull() {
            addCriterion("dead_line_time is null");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeIsNotNull() {
            addCriterion("dead_line_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeEqualTo(Date value) {
            addCriterion("dead_line_time =", value, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeNotEqualTo(Date value) {
            addCriterion("dead_line_time <>", value, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeGreaterThan(Date value) {
            addCriterion("dead_line_time >", value, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dead_line_time >=", value, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeLessThan(Date value) {
            addCriterion("dead_line_time <", value, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeLessThanOrEqualTo(Date value) {
            addCriterion("dead_line_time <=", value, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeIn(List<Date> values) {
            addCriterion("dead_line_time in", values, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeNotIn(List<Date> values) {
            addCriterion("dead_line_time not in", values, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeBetween(Date value1, Date value2) {
            addCriterion("dead_line_time between", value1, value2, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andDeadLineTimeNotBetween(Date value1, Date value2) {
            addCriterion("dead_line_time not between", value1, value2, "deadLineTime");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreIsNull() {
            addCriterion("work_total_score is null");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreIsNotNull() {
            addCriterion("work_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreEqualTo(Integer value) {
            addCriterion("work_total_score =", value, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreNotEqualTo(Integer value) {
            addCriterion("work_total_score <>", value, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreGreaterThan(Integer value) {
            addCriterion("work_total_score >", value, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_total_score >=", value, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreLessThan(Integer value) {
            addCriterion("work_total_score <", value, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("work_total_score <=", value, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreIn(List<Integer> values) {
            addCriterion("work_total_score in", values, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreNotIn(List<Integer> values) {
            addCriterion("work_total_score not in", values, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("work_total_score between", value1, value2, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("work_total_score not between", value1, value2, "workTotalScore");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNull() {
            addCriterion("work_desc is null");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNotNull() {
            addCriterion("work_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDescEqualTo(String value) {
            addCriterion("work_desc =", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotEqualTo(String value) {
            addCriterion("work_desc <>", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThan(String value) {
            addCriterion("work_desc >", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThanOrEqualTo(String value) {
            addCriterion("work_desc >=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThan(String value) {
            addCriterion("work_desc <", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThanOrEqualTo(String value) {
            addCriterion("work_desc <=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLike(String value) {
            addCriterion("work_desc like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotLike(String value) {
            addCriterion("work_desc not like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescIn(List<String> values) {
            addCriterion("work_desc in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotIn(List<String> values) {
            addCriterion("work_desc not in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescBetween(String value1, String value2) {
            addCriterion("work_desc between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotBetween(String value1, String value2) {
            addCriterion("work_desc not between", value1, value2, "workDesc");
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