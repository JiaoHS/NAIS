package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public CourseCriteria() {
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

        public Criteria andCourseDescCnIsNull() {
            addCriterion("course_desc_cn is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnIsNotNull() {
            addCriterion("course_desc_cn is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnEqualTo(String value) {
            addCriterion("course_desc_cn =", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnNotEqualTo(String value) {
            addCriterion("course_desc_cn <>", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnGreaterThan(String value) {
            addCriterion("course_desc_cn >", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnGreaterThanOrEqualTo(String value) {
            addCriterion("course_desc_cn >=", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnLessThan(String value) {
            addCriterion("course_desc_cn <", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnLessThanOrEqualTo(String value) {
            addCriterion("course_desc_cn <=", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnLike(String value) {
            addCriterion("course_desc_cn like", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnNotLike(String value) {
            addCriterion("course_desc_cn not like", value, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnIn(List<String> values) {
            addCriterion("course_desc_cn in", values, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnNotIn(List<String> values) {
            addCriterion("course_desc_cn not in", values, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnBetween(String value1, String value2) {
            addCriterion("course_desc_cn between", value1, value2, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescCnNotBetween(String value1, String value2) {
            addCriterion("course_desc_cn not between", value1, value2, "courseDescCn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnIsNull() {
            addCriterion("course_desc_en is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnIsNotNull() {
            addCriterion("course_desc_en is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnEqualTo(String value) {
            addCriterion("course_desc_en =", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnNotEqualTo(String value) {
            addCriterion("course_desc_en <>", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnGreaterThan(String value) {
            addCriterion("course_desc_en >", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnGreaterThanOrEqualTo(String value) {
            addCriterion("course_desc_en >=", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnLessThan(String value) {
            addCriterion("course_desc_en <", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnLessThanOrEqualTo(String value) {
            addCriterion("course_desc_en <=", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnLike(String value) {
            addCriterion("course_desc_en like", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnNotLike(String value) {
            addCriterion("course_desc_en not like", value, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnIn(List<String> values) {
            addCriterion("course_desc_en in", values, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnNotIn(List<String> values) {
            addCriterion("course_desc_en not in", values, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnBetween(String value1, String value2) {
            addCriterion("course_desc_en between", value1, value2, "courseDescEn");
            return (Criteria) this;
        }

        public Criteria andCourseDescEnNotBetween(String value1, String value2) {
            addCriterion("course_desc_en not between", value1, value2, "courseDescEn");
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