package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserHomeWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserHomeWorkExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusIsNull() {
            addCriterion("task_statius is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusIsNotNull() {
            addCriterion("task_statius is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusEqualTo(Integer value) {
            addCriterion("task_statius =", value, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusNotEqualTo(Integer value) {
            addCriterion("task_statius <>", value, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusGreaterThan(Integer value) {
            addCriterion("task_statius >", value, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_statius >=", value, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusLessThan(Integer value) {
            addCriterion("task_statius <", value, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusLessThanOrEqualTo(Integer value) {
            addCriterion("task_statius <=", value, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusIn(List<Integer> values) {
            addCriterion("task_statius in", values, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusNotIn(List<Integer> values) {
            addCriterion("task_statius not in", values, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusBetween(Integer value1, Integer value2) {
            addCriterion("task_statius between", value1, value2, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskStatiusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_statius not between", value1, value2, "taskStatius");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlIsNull() {
            addCriterion("task_submit_url is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlIsNotNull() {
            addCriterion("task_submit_url is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlEqualTo(String value) {
            addCriterion("task_submit_url =", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlNotEqualTo(String value) {
            addCriterion("task_submit_url <>", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlGreaterThan(String value) {
            addCriterion("task_submit_url >", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("task_submit_url >=", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlLessThan(String value) {
            addCriterion("task_submit_url <", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlLessThanOrEqualTo(String value) {
            addCriterion("task_submit_url <=", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlLike(String value) {
            addCriterion("task_submit_url like", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlNotLike(String value) {
            addCriterion("task_submit_url not like", value, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlIn(List<String> values) {
            addCriterion("task_submit_url in", values, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlNotIn(List<String> values) {
            addCriterion("task_submit_url not in", values, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlBetween(String value1, String value2) {
            addCriterion("task_submit_url between", value1, value2, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitUrlNotBetween(String value1, String value2) {
            addCriterion("task_submit_url not between", value1, value2, "taskSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescIsNull() {
            addCriterion("task_submit_desc is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescIsNotNull() {
            addCriterion("task_submit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescEqualTo(String value) {
            addCriterion("task_submit_desc =", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescNotEqualTo(String value) {
            addCriterion("task_submit_desc <>", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescGreaterThan(String value) {
            addCriterion("task_submit_desc >", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescGreaterThanOrEqualTo(String value) {
            addCriterion("task_submit_desc >=", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescLessThan(String value) {
            addCriterion("task_submit_desc <", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescLessThanOrEqualTo(String value) {
            addCriterion("task_submit_desc <=", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescLike(String value) {
            addCriterion("task_submit_desc like", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescNotLike(String value) {
            addCriterion("task_submit_desc not like", value, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescIn(List<String> values) {
            addCriterion("task_submit_desc in", values, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescNotIn(List<String> values) {
            addCriterion("task_submit_desc not in", values, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescBetween(String value1, String value2) {
            addCriterion("task_submit_desc between", value1, value2, "taskSubmitDesc");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitDescNotBetween(String value1, String value2) {
            addCriterion("task_submit_desc not between", value1, value2, "taskSubmitDesc");
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

        public Criteria andTaskScoreIsNull() {
            addCriterion("task_score is null");
            return (Criteria) this;
        }

        public Criteria andTaskScoreIsNotNull() {
            addCriterion("task_score is not null");
            return (Criteria) this;
        }

        public Criteria andTaskScoreEqualTo(Integer value) {
            addCriterion("task_score =", value, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreNotEqualTo(Integer value) {
            addCriterion("task_score <>", value, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreGreaterThan(Integer value) {
            addCriterion("task_score >", value, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_score >=", value, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreLessThan(Integer value) {
            addCriterion("task_score <", value, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreLessThanOrEqualTo(Integer value) {
            addCriterion("task_score <=", value, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreIn(List<Integer> values) {
            addCriterion("task_score in", values, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreNotIn(List<Integer> values) {
            addCriterion("task_score not in", values, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreBetween(Integer value1, Integer value2) {
            addCriterion("task_score between", value1, value2, "taskScore");
            return (Criteria) this;
        }

        public Criteria andTaskScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("task_score not between", value1, value2, "taskScore");
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

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
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