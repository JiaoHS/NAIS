package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeWorkTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeWorkTaskExample() {
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

        public Criteria andTaskCourseIdIsNull() {
            addCriterion("task_course_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdIsNotNull() {
            addCriterion("task_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdEqualTo(Long value) {
            addCriterion("task_course_id =", value, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdNotEqualTo(Long value) {
            addCriterion("task_course_id <>", value, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdGreaterThan(Long value) {
            addCriterion("task_course_id >", value, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_course_id >=", value, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdLessThan(Long value) {
            addCriterion("task_course_id <", value, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("task_course_id <=", value, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdIn(List<Long> values) {
            addCriterion("task_course_id in", values, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdNotIn(List<Long> values) {
            addCriterion("task_course_id not in", values, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdBetween(Long value1, Long value2) {
            addCriterion("task_course_id between", value1, value2, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("task_course_id not between", value1, value2, "taskCourseId");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeIsNull() {
            addCriterion("task_course_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeIsNotNull() {
            addCriterion("task_course_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeEqualTo(String value) {
            addCriterion("task_course_code =", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeNotEqualTo(String value) {
            addCriterion("task_course_code <>", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeGreaterThan(String value) {
            addCriterion("task_course_code >", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_course_code >=", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeLessThan(String value) {
            addCriterion("task_course_code <", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("task_course_code <=", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeLike(String value) {
            addCriterion("task_course_code like", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeNotLike(String value) {
            addCriterion("task_course_code not like", value, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeIn(List<String> values) {
            addCriterion("task_course_code in", values, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeNotIn(List<String> values) {
            addCriterion("task_course_code not in", values, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeBetween(String value1, String value2) {
            addCriterion("task_course_code between", value1, value2, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskCourseCodeNotBetween(String value1, String value2) {
            addCriterion("task_course_code not between", value1, value2, "taskCourseCode");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdIsNull() {
            addCriterion("task_arrange_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdIsNotNull() {
            addCriterion("task_arrange_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdEqualTo(Long value) {
            addCriterion("task_arrange_id =", value, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdNotEqualTo(Long value) {
            addCriterion("task_arrange_id <>", value, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdGreaterThan(Long value) {
            addCriterion("task_arrange_id >", value, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_arrange_id >=", value, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdLessThan(Long value) {
            addCriterion("task_arrange_id <", value, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdLessThanOrEqualTo(Long value) {
            addCriterion("task_arrange_id <=", value, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdIn(List<Long> values) {
            addCriterion("task_arrange_id in", values, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdNotIn(List<Long> values) {
            addCriterion("task_arrange_id not in", values, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdBetween(Long value1, Long value2) {
            addCriterion("task_arrange_id between", value1, value2, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskArrangeIdNotBetween(Long value1, Long value2) {
            addCriterion("task_arrange_id not between", value1, value2, "taskArrangeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIsNull() {
            addCriterion("task_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIsNotNull() {
            addCriterion("task_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeEqualTo(Date value) {
            addCriterion("task_start_time =", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotEqualTo(Date value) {
            addCriterion("task_start_time <>", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThan(Date value) {
            addCriterion("task_start_time >", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_start_time >=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThan(Date value) {
            addCriterion("task_start_time <", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_start_time <=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIn(List<Date> values) {
            addCriterion("task_start_time in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotIn(List<Date> values) {
            addCriterion("task_start_time not in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeBetween(Date value1, Date value2) {
            addCriterion("task_start_time between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_start_time not between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIsNull() {
            addCriterion("task_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIsNotNull() {
            addCriterion("task_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeEqualTo(Date value) {
            addCriterion("task_end_time =", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotEqualTo(Date value) {
            addCriterion("task_end_time <>", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThan(Date value) {
            addCriterion("task_end_time >", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_end_time >=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThan(Date value) {
            addCriterion("task_end_time <", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_end_time <=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIn(List<Date> values) {
            addCriterion("task_end_time in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotIn(List<Date> values) {
            addCriterion("task_end_time not in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeBetween(Date value1, Date value2) {
            addCriterion("task_end_time between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_end_time not between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlIsNull() {
            addCriterion("task_attach_url is null");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlIsNotNull() {
            addCriterion("task_attach_url is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlEqualTo(String value) {
            addCriterion("task_attach_url =", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlNotEqualTo(String value) {
            addCriterion("task_attach_url <>", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlGreaterThan(String value) {
            addCriterion("task_attach_url >", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlGreaterThanOrEqualTo(String value) {
            addCriterion("task_attach_url >=", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlLessThan(String value) {
            addCriterion("task_attach_url <", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlLessThanOrEqualTo(String value) {
            addCriterion("task_attach_url <=", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlLike(String value) {
            addCriterion("task_attach_url like", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlNotLike(String value) {
            addCriterion("task_attach_url not like", value, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlIn(List<String> values) {
            addCriterion("task_attach_url in", values, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlNotIn(List<String> values) {
            addCriterion("task_attach_url not in", values, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlBetween(String value1, String value2) {
            addCriterion("task_attach_url between", value1, value2, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskAttachUrlNotBetween(String value1, String value2) {
            addCriterion("task_attach_url not between", value1, value2, "taskAttachUrl");
            return (Criteria) this;
        }

        public Criteria andTaskDescIsNull() {
            addCriterion("task_desc is null");
            return (Criteria) this;
        }

        public Criteria andTaskDescIsNotNull() {
            addCriterion("task_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDescEqualTo(String value) {
            addCriterion("task_desc =", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotEqualTo(String value) {
            addCriterion("task_desc <>", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescGreaterThan(String value) {
            addCriterion("task_desc >", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescGreaterThanOrEqualTo(String value) {
            addCriterion("task_desc >=", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLessThan(String value) {
            addCriterion("task_desc <", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLessThanOrEqualTo(String value) {
            addCriterion("task_desc <=", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLike(String value) {
            addCriterion("task_desc like", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotLike(String value) {
            addCriterion("task_desc not like", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescIn(List<String> values) {
            addCriterion("task_desc in", values, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotIn(List<String> values) {
            addCriterion("task_desc not in", values, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescBetween(String value1, String value2) {
            addCriterion("task_desc between", value1, value2, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotBetween(String value1, String value2) {
            addCriterion("task_desc not between", value1, value2, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreIsNull() {
            addCriterion("task_total_score is null");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreIsNotNull() {
            addCriterion("task_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreEqualTo(Integer value) {
            addCriterion("task_total_score =", value, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreNotEqualTo(Integer value) {
            addCriterion("task_total_score <>", value, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreGreaterThan(Integer value) {
            addCriterion("task_total_score >", value, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_total_score >=", value, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreLessThan(Integer value) {
            addCriterion("task_total_score <", value, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("task_total_score <=", value, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreIn(List<Integer> values) {
            addCriterion("task_total_score in", values, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreNotIn(List<Integer> values) {
            addCriterion("task_total_score not in", values, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("task_total_score between", value1, value2, "taskTotalScore");
            return (Criteria) this;
        }

        public Criteria andTaskTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("task_total_score not between", value1, value2, "taskTotalScore");
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