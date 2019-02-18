package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaidSubjectCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public PaidSubjectCriteria() {
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

        public Criteria andSubjectNameCnIsNull() {
            addCriterion("subject_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnIsNotNull() {
            addCriterion("subject_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnEqualTo(String value) {
            addCriterion("subject_name_cn =", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnNotEqualTo(String value) {
            addCriterion("subject_name_cn <>", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnGreaterThan(String value) {
            addCriterion("subject_name_cn >", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("subject_name_cn >=", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnLessThan(String value) {
            addCriterion("subject_name_cn <", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnLessThanOrEqualTo(String value) {
            addCriterion("subject_name_cn <=", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnLike(String value) {
            addCriterion("subject_name_cn like", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnNotLike(String value) {
            addCriterion("subject_name_cn not like", value, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnIn(List<String> values) {
            addCriterion("subject_name_cn in", values, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnNotIn(List<String> values) {
            addCriterion("subject_name_cn not in", values, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnBetween(String value1, String value2) {
            addCriterion("subject_name_cn between", value1, value2, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameCnNotBetween(String value1, String value2) {
            addCriterion("subject_name_cn not between", value1, value2, "subjectNameCn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnIsNull() {
            addCriterion("subject_name_en is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnIsNotNull() {
            addCriterion("subject_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnEqualTo(String value) {
            addCriterion("subject_name_en =", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnNotEqualTo(String value) {
            addCriterion("subject_name_en <>", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnGreaterThan(String value) {
            addCriterion("subject_name_en >", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("subject_name_en >=", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnLessThan(String value) {
            addCriterion("subject_name_en <", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnLessThanOrEqualTo(String value) {
            addCriterion("subject_name_en <=", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnLike(String value) {
            addCriterion("subject_name_en like", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnNotLike(String value) {
            addCriterion("subject_name_en not like", value, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnIn(List<String> values) {
            addCriterion("subject_name_en in", values, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnNotIn(List<String> values) {
            addCriterion("subject_name_en not in", values, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnBetween(String value1, String value2) {
            addCriterion("subject_name_en between", value1, value2, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEnNotBetween(String value1, String value2) {
            addCriterion("subject_name_en not between", value1, value2, "subjectNameEn");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("subject_type is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(Integer value) {
            addCriterion("subject_type =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(Integer value) {
            addCriterion("subject_type <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(Integer value) {
            addCriterion("subject_type >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_type >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(Integer value) {
            addCriterion("subject_type <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("subject_type <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<Integer> values) {
            addCriterion("subject_type in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<Integer> values) {
            addCriterion("subject_type not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("subject_type between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_type not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyIsNull() {
            addCriterion("subject_money is null");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyIsNotNull() {
            addCriterion("subject_money is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyEqualTo(Long value) {
            addCriterion("subject_money =", value, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyNotEqualTo(Long value) {
            addCriterion("subject_money <>", value, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyGreaterThan(Long value) {
            addCriterion("subject_money >", value, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("subject_money >=", value, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyLessThan(Long value) {
            addCriterion("subject_money <", value, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyLessThanOrEqualTo(Long value) {
            addCriterion("subject_money <=", value, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyIn(List<Long> values) {
            addCriterion("subject_money in", values, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyNotIn(List<Long> values) {
            addCriterion("subject_money not in", values, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyBetween(Long value1, Long value2) {
            addCriterion("subject_money between", value1, value2, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectMoneyNotBetween(Long value1, Long value2) {
            addCriterion("subject_money not between", value1, value2, "subjectMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusIsNull() {
            addCriterion("subject_status is null");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusIsNotNull() {
            addCriterion("subject_status is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusEqualTo(Integer value) {
            addCriterion("subject_status =", value, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusNotEqualTo(Integer value) {
            addCriterion("subject_status <>", value, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusGreaterThan(Integer value) {
            addCriterion("subject_status >", value, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_status >=", value, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusLessThan(Integer value) {
            addCriterion("subject_status <", value, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusLessThanOrEqualTo(Integer value) {
            addCriterion("subject_status <=", value, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusIn(List<Integer> values) {
            addCriterion("subject_status in", values, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusNotIn(List<Integer> values) {
            addCriterion("subject_status not in", values, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusBetween(Integer value1, Integer value2) {
            addCriterion("subject_status between", value1, value2, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_status not between", value1, value2, "subjectStatus");
            return (Criteria) this;
        }

        public Criteria andPageOrderIsNull() {
            addCriterion("page_order is null");
            return (Criteria) this;
        }

        public Criteria andPageOrderIsNotNull() {
            addCriterion("page_order is not null");
            return (Criteria) this;
        }

        public Criteria andPageOrderEqualTo(Integer value) {
            addCriterion("page_order =", value, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderNotEqualTo(Integer value) {
            addCriterion("page_order <>", value, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderGreaterThan(Integer value) {
            addCriterion("page_order >", value, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_order >=", value, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderLessThan(Integer value) {
            addCriterion("page_order <", value, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderLessThanOrEqualTo(Integer value) {
            addCriterion("page_order <=", value, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderIn(List<Integer> values) {
            addCriterion("page_order in", values, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderNotIn(List<Integer> values) {
            addCriterion("page_order not in", values, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderBetween(Integer value1, Integer value2) {
            addCriterion("page_order between", value1, value2, "pageOrder");
            return (Criteria) this;
        }

        public Criteria andPageOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("page_order not between", value1, value2, "pageOrder");
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