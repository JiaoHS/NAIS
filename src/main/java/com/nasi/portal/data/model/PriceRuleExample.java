package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceRuleExample() {
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

        public Criteria andCampusIdIsNull() {
            addCriterion("campus_id is null");
            return (Criteria) this;
        }

        public Criteria andCampusIdIsNotNull() {
            addCriterion("campus_id is not null");
            return (Criteria) this;
        }

        public Criteria andCampusIdEqualTo(Long value) {
            addCriterion("campus_id =", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotEqualTo(Long value) {
            addCriterion("campus_id <>", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThan(Long value) {
            addCriterion("campus_id >", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("campus_id >=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThan(Long value) {
            addCriterion("campus_id <", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThanOrEqualTo(Long value) {
            addCriterion("campus_id <=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdIn(List<Long> values) {
            addCriterion("campus_id in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotIn(List<Long> values) {
            addCriterion("campus_id not in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdBetween(Long value1, Long value2) {
            addCriterion("campus_id between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotBetween(Long value1, Long value2) {
            addCriterion("campus_id not between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusNameIsNull() {
            addCriterion("campus_name is null");
            return (Criteria) this;
        }

        public Criteria andCampusNameIsNotNull() {
            addCriterion("campus_name is not null");
            return (Criteria) this;
        }

        public Criteria andCampusNameEqualTo(String value) {
            addCriterion("campus_name =", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotEqualTo(String value) {
            addCriterion("campus_name <>", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameGreaterThan(String value) {
            addCriterion("campus_name >", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameGreaterThanOrEqualTo(String value) {
            addCriterion("campus_name >=", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameLessThan(String value) {
            addCriterion("campus_name <", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameLessThanOrEqualTo(String value) {
            addCriterion("campus_name <=", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameLike(String value) {
            addCriterion("campus_name like", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotLike(String value) {
            addCriterion("campus_name not like", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameIn(List<String> values) {
            addCriterion("campus_name in", values, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotIn(List<String> values) {
            addCriterion("campus_name not in", values, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameBetween(String value1, String value2) {
            addCriterion("campus_name between", value1, value2, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotBetween(String value1, String value2) {
            addCriterion("campus_name not between", value1, value2, "campusName");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeIsNull() {
            addCriterion("rule_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeIsNotNull() {
            addCriterion("rule_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeEqualTo(Date value) {
            addCriterion("rule_start_time =", value, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeNotEqualTo(Date value) {
            addCriterion("rule_start_time <>", value, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeGreaterThan(Date value) {
            addCriterion("rule_start_time >", value, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rule_start_time >=", value, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeLessThan(Date value) {
            addCriterion("rule_start_time <", value, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("rule_start_time <=", value, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeIn(List<Date> values) {
            addCriterion("rule_start_time in", values, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeNotIn(List<Date> values) {
            addCriterion("rule_start_time not in", values, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeBetween(Date value1, Date value2) {
            addCriterion("rule_start_time between", value1, value2, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("rule_start_time not between", value1, value2, "ruleStartTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeIsNull() {
            addCriterion("rule_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeIsNotNull() {
            addCriterion("rule_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeEqualTo(Date value) {
            addCriterion("rule_end_time =", value, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeNotEqualTo(Date value) {
            addCriterion("rule_end_time <>", value, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeGreaterThan(Date value) {
            addCriterion("rule_end_time >", value, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rule_end_time >=", value, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeLessThan(Date value) {
            addCriterion("rule_end_time <", value, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("rule_end_time <=", value, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeIn(List<Date> values) {
            addCriterion("rule_end_time in", values, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeNotIn(List<Date> values) {
            addCriterion("rule_end_time not in", values, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeBetween(Date value1, Date value2) {
            addCriterion("rule_end_time between", value1, value2, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("rule_end_time not between", value1, value2, "ruleEndTime");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountIsNull() {
            addCriterion("rule_course_count is null");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountIsNotNull() {
            addCriterion("rule_course_count is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountEqualTo(Long value) {
            addCriterion("rule_course_count =", value, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountNotEqualTo(Long value) {
            addCriterion("rule_course_count <>", value, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountGreaterThan(Long value) {
            addCriterion("rule_course_count >", value, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_course_count >=", value, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountLessThan(Long value) {
            addCriterion("rule_course_count <", value, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountLessThanOrEqualTo(Long value) {
            addCriterion("rule_course_count <=", value, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountIn(List<Long> values) {
            addCriterion("rule_course_count in", values, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountNotIn(List<Long> values) {
            addCriterion("rule_course_count not in", values, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountBetween(Long value1, Long value2) {
            addCriterion("rule_course_count between", value1, value2, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleCourseCountNotBetween(Long value1, Long value2) {
            addCriterion("rule_course_count not between", value1, value2, "ruleCourseCount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountIsNull() {
            addCriterion("rule_money_amount is null");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountIsNotNull() {
            addCriterion("rule_money_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountEqualTo(Long value) {
            addCriterion("rule_money_amount =", value, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountNotEqualTo(Long value) {
            addCriterion("rule_money_amount <>", value, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountGreaterThan(Long value) {
            addCriterion("rule_money_amount >", value, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_money_amount >=", value, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountLessThan(Long value) {
            addCriterion("rule_money_amount <", value, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountLessThanOrEqualTo(Long value) {
            addCriterion("rule_money_amount <=", value, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountIn(List<Long> values) {
            addCriterion("rule_money_amount in", values, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountNotIn(List<Long> values) {
            addCriterion("rule_money_amount not in", values, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountBetween(Long value1, Long value2) {
            addCriterion("rule_money_amount between", value1, value2, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleMoneyAmountNotBetween(Long value1, Long value2) {
            addCriterion("rule_money_amount not between", value1, value2, "ruleMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRuleDescIsNull() {
            addCriterion("rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andRuleDescIsNotNull() {
            addCriterion("rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRuleDescEqualTo(String value) {
            addCriterion("rule_desc =", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotEqualTo(String value) {
            addCriterion("rule_desc <>", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThan(String value) {
            addCriterion("rule_desc >", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThanOrEqualTo(String value) {
            addCriterion("rule_desc >=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThan(String value) {
            addCriterion("rule_desc <", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThanOrEqualTo(String value) {
            addCriterion("rule_desc <=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLike(String value) {
            addCriterion("rule_desc like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotLike(String value) {
            addCriterion("rule_desc not like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescIn(List<String> values) {
            addCriterion("rule_desc in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotIn(List<String> values) {
            addCriterion("rule_desc not in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescBetween(String value1, String value2) {
            addCriterion("rule_desc between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotBetween(String value1, String value2) {
            addCriterion("rule_desc not between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleStatusIsNull() {
            addCriterion("rule_status is null");
            return (Criteria) this;
        }

        public Criteria andRuleStatusIsNotNull() {
            addCriterion("rule_status is not null");
            return (Criteria) this;
        }

        public Criteria andRuleStatusEqualTo(Integer value) {
            addCriterion("rule_status =", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusNotEqualTo(Integer value) {
            addCriterion("rule_status <>", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusGreaterThan(Integer value) {
            addCriterion("rule_status >", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_status >=", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusLessThan(Integer value) {
            addCriterion("rule_status <", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("rule_status <=", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusIn(List<Integer> values) {
            addCriterion("rule_status in", values, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusNotIn(List<Integer> values) {
            addCriterion("rule_status not in", values, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusBetween(Integer value1, Integer value2) {
            addCriterion("rule_status between", value1, value2, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_status not between", value1, value2, "ruleStatus");
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