package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.List;

public class WebConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebConfigExample() {
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

        public Criteria andKIsNull() {
            addCriterion("k is null");
            return (Criteria) this;
        }

        public Criteria andKIsNotNull() {
            addCriterion("k is not null");
            return (Criteria) this;
        }

        public Criteria andKEqualTo(String value) {
            addCriterion("k =", value, "k");
            return (Criteria) this;
        }

        public Criteria andKNotEqualTo(String value) {
            addCriterion("k <>", value, "k");
            return (Criteria) this;
        }

        public Criteria andKGreaterThan(String value) {
            addCriterion("k >", value, "k");
            return (Criteria) this;
        }

        public Criteria andKGreaterThanOrEqualTo(String value) {
            addCriterion("k >=", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLessThan(String value) {
            addCriterion("k <", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLessThanOrEqualTo(String value) {
            addCriterion("k <=", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLike(String value) {
            addCriterion("k like", value, "k");
            return (Criteria) this;
        }

        public Criteria andKNotLike(String value) {
            addCriterion("k not like", value, "k");
            return (Criteria) this;
        }

        public Criteria andKIn(List<String> values) {
            addCriterion("k in", values, "k");
            return (Criteria) this;
        }

        public Criteria andKNotIn(List<String> values) {
            addCriterion("k not in", values, "k");
            return (Criteria) this;
        }

        public Criteria andKBetween(String value1, String value2) {
            addCriterion("k between", value1, value2, "k");
            return (Criteria) this;
        }

        public Criteria andKNotBetween(String value1, String value2) {
            addCriterion("k not between", value1, value2, "k");
            return (Criteria) this;
        }

        public Criteria andVIsNull() {
            addCriterion("v is null");
            return (Criteria) this;
        }

        public Criteria andVIsNotNull() {
            addCriterion("v is not null");
            return (Criteria) this;
        }

        public Criteria andVEqualTo(String value) {
            addCriterion("v =", value, "v");
            return (Criteria) this;
        }

        public Criteria andVNotEqualTo(String value) {
            addCriterion("v <>", value, "v");
            return (Criteria) this;
        }

        public Criteria andVGreaterThan(String value) {
            addCriterion("v >", value, "v");
            return (Criteria) this;
        }

        public Criteria andVGreaterThanOrEqualTo(String value) {
            addCriterion("v >=", value, "v");
            return (Criteria) this;
        }

        public Criteria andVLessThan(String value) {
            addCriterion("v <", value, "v");
            return (Criteria) this;
        }

        public Criteria andVLessThanOrEqualTo(String value) {
            addCriterion("v <=", value, "v");
            return (Criteria) this;
        }

        public Criteria andVLike(String value) {
            addCriterion("v like", value, "v");
            return (Criteria) this;
        }

        public Criteria andVNotLike(String value) {
            addCriterion("v not like", value, "v");
            return (Criteria) this;
        }

        public Criteria andVIn(List<String> values) {
            addCriterion("v in", values, "v");
            return (Criteria) this;
        }

        public Criteria andVNotIn(List<String> values) {
            addCriterion("v not in", values, "v");
            return (Criteria) this;
        }

        public Criteria andVBetween(String value1, String value2) {
            addCriterion("v between", value1, value2, "v");
            return (Criteria) this;
        }

        public Criteria andVNotBetween(String value1, String value2) {
            addCriterion("v not between", value1, value2, "v");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
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