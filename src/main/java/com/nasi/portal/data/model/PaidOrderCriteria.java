package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaidOrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public PaidOrderCriteria() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andRealMoneyIsNull() {
            addCriterion("real_money is null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNotNull() {
            addCriterion("real_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyEqualTo(Long value) {
            addCriterion("real_money =", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotEqualTo(Long value) {
            addCriterion("real_money <>", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThan(Long value) {
            addCriterion("real_money >", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("real_money >=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThan(Long value) {
            addCriterion("real_money <", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThanOrEqualTo(Long value) {
            addCriterion("real_money <=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIn(List<Long> values) {
            addCriterion("real_money in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotIn(List<Long> values) {
            addCriterion("real_money not in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyBetween(Long value1, Long value2) {
            addCriterion("real_money between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotBetween(Long value1, Long value2) {
            addCriterion("real_money not between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNull() {
            addCriterion("coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNotNull() {
            addCriterion("coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeEqualTo(String value) {
            addCriterion("coupon_code =", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotEqualTo(String value) {
            addCriterion("coupon_code <>", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThan(String value) {
            addCriterion("coupon_code >", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_code >=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThan(String value) {
            addCriterion("coupon_code <", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThanOrEqualTo(String value) {
            addCriterion("coupon_code <=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLike(String value) {
            addCriterion("coupon_code like", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotLike(String value) {
            addCriterion("coupon_code not like", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIn(List<String> values) {
            addCriterion("coupon_code in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotIn(List<String> values) {
            addCriterion("coupon_code not in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeBetween(String value1, String value2) {
            addCriterion("coupon_code between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotBetween(String value1, String value2) {
            addCriterion("coupon_code not between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIsNull() {
            addCriterion("coupon_money is null");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIsNotNull() {
            addCriterion("coupon_money is not null");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyEqualTo(Long value) {
            addCriterion("coupon_money =", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotEqualTo(Long value) {
            addCriterion("coupon_money <>", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyGreaterThan(Long value) {
            addCriterion("coupon_money >", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_money >=", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyLessThan(Long value) {
            addCriterion("coupon_money <", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyLessThanOrEqualTo(Long value) {
            addCriterion("coupon_money <=", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIn(List<Long> values) {
            addCriterion("coupon_money in", values, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotIn(List<Long> values) {
            addCriterion("coupon_money not in", values, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyBetween(Long value1, Long value2) {
            addCriterion("coupon_money between", value1, value2, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotBetween(Long value1, Long value2) {
            addCriterion("coupon_money not between", value1, value2, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyIsNull() {
            addCriterion("need_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyIsNotNull() {
            addCriterion("need_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyEqualTo(Long value) {
            addCriterion("need_pay_money =", value, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyNotEqualTo(Long value) {
            addCriterion("need_pay_money <>", value, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyGreaterThan(Long value) {
            addCriterion("need_pay_money >", value, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("need_pay_money >=", value, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyLessThan(Long value) {
            addCriterion("need_pay_money <", value, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyLessThanOrEqualTo(Long value) {
            addCriterion("need_pay_money <=", value, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyIn(List<Long> values) {
            addCriterion("need_pay_money in", values, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyNotIn(List<Long> values) {
            addCriterion("need_pay_money not in", values, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyBetween(Long value1, Long value2) {
            addCriterion("need_pay_money between", value1, value2, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andNeedPayMoneyNotBetween(Long value1, Long value2) {
            addCriterion("need_pay_money not between", value1, value2, "needPayMoney");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsIsNull() {
            addCriterion("subject_ids is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsIsNotNull() {
            addCriterion("subject_ids is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsEqualTo(String value) {
            addCriterion("subject_ids =", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsNotEqualTo(String value) {
            addCriterion("subject_ids <>", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsGreaterThan(String value) {
            addCriterion("subject_ids >", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsGreaterThanOrEqualTo(String value) {
            addCriterion("subject_ids >=", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsLessThan(String value) {
            addCriterion("subject_ids <", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsLessThanOrEqualTo(String value) {
            addCriterion("subject_ids <=", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsLike(String value) {
            addCriterion("subject_ids like", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsNotLike(String value) {
            addCriterion("subject_ids not like", value, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsIn(List<String> values) {
            addCriterion("subject_ids in", values, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsNotIn(List<String> values) {
            addCriterion("subject_ids not in", values, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsBetween(String value1, String value2) {
            addCriterion("subject_ids between", value1, value2, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andSubjectIdsNotBetween(String value1, String value2) {
            addCriterion("subject_ids not between", value1, value2, "subjectIds");
            return (Criteria) this;
        }

        public Criteria andPaidAccountIsNull() {
            addCriterion("paid_account is null");
            return (Criteria) this;
        }

        public Criteria andPaidAccountIsNotNull() {
            addCriterion("paid_account is not null");
            return (Criteria) this;
        }

        public Criteria andPaidAccountEqualTo(String value) {
            addCriterion("paid_account =", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountNotEqualTo(String value) {
            addCriterion("paid_account <>", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountGreaterThan(String value) {
            addCriterion("paid_account >", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountGreaterThanOrEqualTo(String value) {
            addCriterion("paid_account >=", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountLessThan(String value) {
            addCriterion("paid_account <", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountLessThanOrEqualTo(String value) {
            addCriterion("paid_account <=", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountLike(String value) {
            addCriterion("paid_account like", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountNotLike(String value) {
            addCriterion("paid_account not like", value, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountIn(List<String> values) {
            addCriterion("paid_account in", values, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountNotIn(List<String> values) {
            addCriterion("paid_account not in", values, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountBetween(String value1, String value2) {
            addCriterion("paid_account between", value1, value2, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidAccountNotBetween(String value1, String value2) {
            addCriterion("paid_account not between", value1, value2, "paidAccount");
            return (Criteria) this;
        }

        public Criteria andPaidUserIsNull() {
            addCriterion("paid_user is null");
            return (Criteria) this;
        }

        public Criteria andPaidUserIsNotNull() {
            addCriterion("paid_user is not null");
            return (Criteria) this;
        }

        public Criteria andPaidUserEqualTo(String value) {
            addCriterion("paid_user =", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserNotEqualTo(String value) {
            addCriterion("paid_user <>", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserGreaterThan(String value) {
            addCriterion("paid_user >", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserGreaterThanOrEqualTo(String value) {
            addCriterion("paid_user >=", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserLessThan(String value) {
            addCriterion("paid_user <", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserLessThanOrEqualTo(String value) {
            addCriterion("paid_user <=", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserLike(String value) {
            addCriterion("paid_user like", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserNotLike(String value) {
            addCriterion("paid_user not like", value, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserIn(List<String> values) {
            addCriterion("paid_user in", values, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserNotIn(List<String> values) {
            addCriterion("paid_user not in", values, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserBetween(String value1, String value2) {
            addCriterion("paid_user between", value1, value2, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidUserNotBetween(String value1, String value2) {
            addCriterion("paid_user not between", value1, value2, "paidUser");
            return (Criteria) this;
        }

        public Criteria andPaidBankIsNull() {
            addCriterion("paid_bank is null");
            return (Criteria) this;
        }

        public Criteria andPaidBankIsNotNull() {
            addCriterion("paid_bank is not null");
            return (Criteria) this;
        }

        public Criteria andPaidBankEqualTo(String value) {
            addCriterion("paid_bank =", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankNotEqualTo(String value) {
            addCriterion("paid_bank <>", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankGreaterThan(String value) {
            addCriterion("paid_bank >", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankGreaterThanOrEqualTo(String value) {
            addCriterion("paid_bank >=", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankLessThan(String value) {
            addCriterion("paid_bank <", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankLessThanOrEqualTo(String value) {
            addCriterion("paid_bank <=", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankLike(String value) {
            addCriterion("paid_bank like", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankNotLike(String value) {
            addCriterion("paid_bank not like", value, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankIn(List<String> values) {
            addCriterion("paid_bank in", values, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankNotIn(List<String> values) {
            addCriterion("paid_bank not in", values, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankBetween(String value1, String value2) {
            addCriterion("paid_bank between", value1, value2, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidBankNotBetween(String value1, String value2) {
            addCriterion("paid_bank not between", value1, value2, "paidBank");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyIsNull() {
            addCriterion("paid_money is null");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyIsNotNull() {
            addCriterion("paid_money is not null");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyEqualTo(Long value) {
            addCriterion("paid_money =", value, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyNotEqualTo(Long value) {
            addCriterion("paid_money <>", value, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyGreaterThan(Long value) {
            addCriterion("paid_money >", value, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("paid_money >=", value, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyLessThan(Long value) {
            addCriterion("paid_money <", value, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyLessThanOrEqualTo(Long value) {
            addCriterion("paid_money <=", value, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyIn(List<Long> values) {
            addCriterion("paid_money in", values, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyNotIn(List<Long> values) {
            addCriterion("paid_money not in", values, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyBetween(Long value1, Long value2) {
            addCriterion("paid_money between", value1, value2, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidMoneyNotBetween(Long value1, Long value2) {
            addCriterion("paid_money not between", value1, value2, "paidMoney");
            return (Criteria) this;
        }

        public Criteria andPaidDescIsNull() {
            addCriterion("paid_desc is null");
            return (Criteria) this;
        }

        public Criteria andPaidDescIsNotNull() {
            addCriterion("paid_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPaidDescEqualTo(String value) {
            addCriterion("paid_desc =", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescNotEqualTo(String value) {
            addCriterion("paid_desc <>", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescGreaterThan(String value) {
            addCriterion("paid_desc >", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescGreaterThanOrEqualTo(String value) {
            addCriterion("paid_desc >=", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescLessThan(String value) {
            addCriterion("paid_desc <", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescLessThanOrEqualTo(String value) {
            addCriterion("paid_desc <=", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescLike(String value) {
            addCriterion("paid_desc like", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescNotLike(String value) {
            addCriterion("paid_desc not like", value, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescIn(List<String> values) {
            addCriterion("paid_desc in", values, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescNotIn(List<String> values) {
            addCriterion("paid_desc not in", values, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescBetween(String value1, String value2) {
            addCriterion("paid_desc between", value1, value2, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidDescNotBetween(String value1, String value2) {
            addCriterion("paid_desc not between", value1, value2, "paidDesc");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneIsNull() {
            addCriterion("paid_phone is null");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneIsNotNull() {
            addCriterion("paid_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneEqualTo(String value) {
            addCriterion("paid_phone =", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneNotEqualTo(String value) {
            addCriterion("paid_phone <>", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneGreaterThan(String value) {
            addCriterion("paid_phone >", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("paid_phone >=", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneLessThan(String value) {
            addCriterion("paid_phone <", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneLessThanOrEqualTo(String value) {
            addCriterion("paid_phone <=", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneLike(String value) {
            addCriterion("paid_phone like", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneNotLike(String value) {
            addCriterion("paid_phone not like", value, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneIn(List<String> values) {
            addCriterion("paid_phone in", values, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneNotIn(List<String> values) {
            addCriterion("paid_phone not in", values, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneBetween(String value1, String value2) {
            addCriterion("paid_phone between", value1, value2, "paidPhone");
            return (Criteria) this;
        }

        public Criteria andPaidPhoneNotBetween(String value1, String value2) {
            addCriterion("paid_phone not between", value1, value2, "paidPhone");
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