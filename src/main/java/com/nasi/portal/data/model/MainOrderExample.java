package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MainOrderExample() {
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

        public Criteria andPaymentSeqIsNull() {
            addCriterion("payment_seq is null");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqIsNotNull() {
            addCriterion("payment_seq is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqEqualTo(String value) {
            addCriterion("payment_seq =", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNotEqualTo(String value) {
            addCriterion("payment_seq <>", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqGreaterThan(String value) {
            addCriterion("payment_seq >", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqGreaterThanOrEqualTo(String value) {
            addCriterion("payment_seq >=", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqLessThan(String value) {
            addCriterion("payment_seq <", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqLessThanOrEqualTo(String value) {
            addCriterion("payment_seq <=", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqLike(String value) {
            addCriterion("payment_seq like", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNotLike(String value) {
            addCriterion("payment_seq not like", value, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqIn(List<String> values) {
            addCriterion("payment_seq in", values, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNotIn(List<String> values) {
            addCriterion("payment_seq not in", values, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqBetween(String value1, String value2) {
            addCriterion("payment_seq between", value1, value2, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNotBetween(String value1, String value2) {
            addCriterion("payment_seq not between", value1, value2, "paymentSeq");
            return (Criteria) this;
        }

        public Criteria andOrderVersionIsNull() {
            addCriterion("order_version is null");
            return (Criteria) this;
        }

        public Criteria andOrderVersionIsNotNull() {
            addCriterion("order_version is not null");
            return (Criteria) this;
        }

        public Criteria andOrderVersionEqualTo(Integer value) {
            addCriterion("order_version =", value, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionNotEqualTo(Integer value) {
            addCriterion("order_version <>", value, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionGreaterThan(Integer value) {
            addCriterion("order_version >", value, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_version >=", value, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionLessThan(Integer value) {
            addCriterion("order_version <", value, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionLessThanOrEqualTo(Integer value) {
            addCriterion("order_version <=", value, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionIn(List<Integer> values) {
            addCriterion("order_version in", values, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionNotIn(List<Integer> values) {
            addCriterion("order_version not in", values, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionBetween(Integer value1, Integer value2) {
            addCriterion("order_version between", value1, value2, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("order_version not between", value1, value2, "orderVersion");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNull() {
            addCriterion("order_source is null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNotNull() {
            addCriterion("order_source is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceEqualTo(Integer value) {
            addCriterion("order_source =", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotEqualTo(Integer value) {
            addCriterion("order_source <>", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThan(Integer value) {
            addCriterion("order_source >", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_source >=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThan(Integer value) {
            addCriterion("order_source <", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThanOrEqualTo(Integer value) {
            addCriterion("order_source <=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIn(List<Integer> values) {
            addCriterion("order_source in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotIn(List<Integer> values) {
            addCriterion("order_source not in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceBetween(Integer value1, Integer value2) {
            addCriterion("order_source between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_source not between", value1, value2, "orderSource");
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Long value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Long value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Long value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Long value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Long> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Long> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Long value1, Long value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountIsNull() {
            addCriterion("cash_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashAmountIsNotNull() {
            addCriterion("cash_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashAmountEqualTo(Long value) {
            addCriterion("cash_amount =", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotEqualTo(Long value) {
            addCriterion("cash_amount <>", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThan(Long value) {
            addCriterion("cash_amount >", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("cash_amount >=", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThan(Long value) {
            addCriterion("cash_amount <", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThanOrEqualTo(Long value) {
            addCriterion("cash_amount <=", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountIn(List<Long> values) {
            addCriterion("cash_amount in", values, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotIn(List<Long> values) {
            addCriterion("cash_amount not in", values, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountBetween(Long value1, Long value2) {
            addCriterion("cash_amount between", value1, value2, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotBetween(Long value1, Long value2) {
            addCriterion("cash_amount not between", value1, value2, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(Long value) {
            addCriterion("discount_amount =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(Long value) {
            addCriterion("discount_amount <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(Long value) {
            addCriterion("discount_amount >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("discount_amount >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(Long value) {
            addCriterion("discount_amount <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("discount_amount <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<Long> values) {
            addCriterion("discount_amount in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<Long> values) {
            addCriterion("discount_amount not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("discount_amount between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("discount_amount not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelIsNull() {
            addCriterion("payment_channel is null");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelIsNotNull() {
            addCriterion("payment_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelEqualTo(Integer value) {
            addCriterion("payment_channel =", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelNotEqualTo(Integer value) {
            addCriterion("payment_channel <>", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelGreaterThan(Integer value) {
            addCriterion("payment_channel >", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_channel >=", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelLessThan(Integer value) {
            addCriterion("payment_channel <", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelLessThanOrEqualTo(Integer value) {
            addCriterion("payment_channel <=", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelIn(List<Integer> values) {
            addCriterion("payment_channel in", values, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelNotIn(List<Integer> values) {
            addCriterion("payment_channel not in", values, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelBetween(Integer value1, Integer value2) {
            addCriterion("payment_channel between", value1, value2, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_channel not between", value1, value2, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeIsNull() {
            addCriterion("payment_success_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeIsNotNull() {
            addCriterion("payment_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeEqualTo(Date value) {
            addCriterion("payment_success_time =", value, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeNotEqualTo(Date value) {
            addCriterion("payment_success_time <>", value, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeGreaterThan(Date value) {
            addCriterion("payment_success_time >", value, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_success_time >=", value, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeLessThan(Date value) {
            addCriterion("payment_success_time <", value, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_success_time <=", value, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeIn(List<Date> values) {
            addCriterion("payment_success_time in", values, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeNotIn(List<Date> values) {
            addCriterion("payment_success_time not in", values, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeBetween(Date value1, Date value2) {
            addCriterion("payment_success_time between", value1, value2, "paymentSuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaymentSuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_success_time not between", value1, value2, "paymentSuccessTime");
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

        public Criteria andPaymenRemarkIsNull() {
            addCriterion("paymen_remark is null");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkIsNotNull() {
            addCriterion("paymen_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkEqualTo(String value) {
            addCriterion("paymen_remark =", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkNotEqualTo(String value) {
            addCriterion("paymen_remark <>", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkGreaterThan(String value) {
            addCriterion("paymen_remark >", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("paymen_remark >=", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkLessThan(String value) {
            addCriterion("paymen_remark <", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkLessThanOrEqualTo(String value) {
            addCriterion("paymen_remark <=", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkLike(String value) {
            addCriterion("paymen_remark like", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkNotLike(String value) {
            addCriterion("paymen_remark not like", value, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkIn(List<String> values) {
            addCriterion("paymen_remark in", values, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkNotIn(List<String> values) {
            addCriterion("paymen_remark not in", values, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkBetween(String value1, String value2) {
            addCriterion("paymen_remark between", value1, value2, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andPaymenRemarkNotBetween(String value1, String value2) {
            addCriterion("paymen_remark not between", value1, value2, "paymenRemark");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepIsNull() {
            addCriterion("manual_paid_rep is null");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepIsNotNull() {
            addCriterion("manual_paid_rep is not null");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepEqualTo(String value) {
            addCriterion("manual_paid_rep =", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepNotEqualTo(String value) {
            addCriterion("manual_paid_rep <>", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepGreaterThan(String value) {
            addCriterion("manual_paid_rep >", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepGreaterThanOrEqualTo(String value) {
            addCriterion("manual_paid_rep >=", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepLessThan(String value) {
            addCriterion("manual_paid_rep <", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepLessThanOrEqualTo(String value) {
            addCriterion("manual_paid_rep <=", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepLike(String value) {
            addCriterion("manual_paid_rep like", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepNotLike(String value) {
            addCriterion("manual_paid_rep not like", value, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepIn(List<String> values) {
            addCriterion("manual_paid_rep in", values, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepNotIn(List<String> values) {
            addCriterion("manual_paid_rep not in", values, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepBetween(String value1, String value2) {
            addCriterion("manual_paid_rep between", value1, value2, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andManualPaidRepNotBetween(String value1, String value2) {
            addCriterion("manual_paid_rep not between", value1, value2, "manualPaidRep");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNull() {
            addCriterion("receipt is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNotNull() {
            addCriterion("receipt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptEqualTo(String value) {
            addCriterion("receipt =", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotEqualTo(String value) {
            addCriterion("receipt <>", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThan(String value) {
            addCriterion("receipt >", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThanOrEqualTo(String value) {
            addCriterion("receipt >=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThan(String value) {
            addCriterion("receipt <", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThanOrEqualTo(String value) {
            addCriterion("receipt <=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLike(String value) {
            addCriterion("receipt like", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotLike(String value) {
            addCriterion("receipt not like", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptIn(List<String> values) {
            addCriterion("receipt in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotIn(List<String> values) {
            addCriterion("receipt not in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptBetween(String value1, String value2) {
            addCriterion("receipt between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotBetween(String value1, String value2) {
            addCriterion("receipt not between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNull() {
            addCriterion("created_user is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNotNull() {
            addCriterion("created_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserEqualTo(Long value) {
            addCriterion("created_user =", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotEqualTo(Long value) {
            addCriterion("created_user <>", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThan(Long value) {
            addCriterion("created_user >", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThanOrEqualTo(Long value) {
            addCriterion("created_user >=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThan(Long value) {
            addCriterion("created_user <", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThanOrEqualTo(Long value) {
            addCriterion("created_user <=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIn(List<Long> values) {
            addCriterion("created_user in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotIn(List<Long> values) {
            addCriterion("created_user not in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserBetween(Long value1, Long value2) {
            addCriterion("created_user between", value1, value2, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotBetween(Long value1, Long value2) {
            addCriterion("created_user not between", value1, value2, "createdUser");
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