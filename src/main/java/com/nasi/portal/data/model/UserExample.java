package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
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

        public Criteria andCouponCodeIsNull() {
            addCriterion("coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNotNull() {
            addCriterion("coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeEqualTo(Long value) {
            addCriterion("coupon_code =", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotEqualTo(Long value) {
            addCriterion("coupon_code <>", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThan(Long value) {
            addCriterion("coupon_code >", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_code >=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThan(Long value) {
            addCriterion("coupon_code <", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThanOrEqualTo(Long value) {
            addCriterion("coupon_code <=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIn(List<Long> values) {
            addCriterion("coupon_code in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotIn(List<Long> values) {
            addCriterion("coupon_code not in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeBetween(Long value1, Long value2) {
            addCriterion("coupon_code between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotBetween(Long value1, Long value2) {
            addCriterion("coupon_code not between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNull() {
            addCriterion("name_cn is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("name_cn =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("name_cn <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("name_cn >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("name_cn >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("name_cn <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("name_cn <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("name_cn like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("name_cn not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("name_cn in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("name_cn not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("name_cn between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("name_cn not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andTelCnIsNull() {
            addCriterion("tel_cn is null");
            return (Criteria) this;
        }

        public Criteria andTelCnIsNotNull() {
            addCriterion("tel_cn is not null");
            return (Criteria) this;
        }

        public Criteria andTelCnEqualTo(String value) {
            addCriterion("tel_cn =", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnNotEqualTo(String value) {
            addCriterion("tel_cn <>", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnGreaterThan(String value) {
            addCriterion("tel_cn >", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnGreaterThanOrEqualTo(String value) {
            addCriterion("tel_cn >=", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnLessThan(String value) {
            addCriterion("tel_cn <", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnLessThanOrEqualTo(String value) {
            addCriterion("tel_cn <=", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnLike(String value) {
            addCriterion("tel_cn like", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnNotLike(String value) {
            addCriterion("tel_cn not like", value, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnIn(List<String> values) {
            addCriterion("tel_cn in", values, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnNotIn(List<String> values) {
            addCriterion("tel_cn not in", values, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnBetween(String value1, String value2) {
            addCriterion("tel_cn between", value1, value2, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelCnNotBetween(String value1, String value2) {
            addCriterion("tel_cn not between", value1, value2, "telCn");
            return (Criteria) this;
        }

        public Criteria andTelEnIsNull() {
            addCriterion("tel_en is null");
            return (Criteria) this;
        }

        public Criteria andTelEnIsNotNull() {
            addCriterion("tel_en is not null");
            return (Criteria) this;
        }

        public Criteria andTelEnEqualTo(String value) {
            addCriterion("tel_en =", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnNotEqualTo(String value) {
            addCriterion("tel_en <>", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnGreaterThan(String value) {
            addCriterion("tel_en >", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnGreaterThanOrEqualTo(String value) {
            addCriterion("tel_en >=", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnLessThan(String value) {
            addCriterion("tel_en <", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnLessThanOrEqualTo(String value) {
            addCriterion("tel_en <=", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnLike(String value) {
            addCriterion("tel_en like", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnNotLike(String value) {
            addCriterion("tel_en not like", value, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnIn(List<String> values) {
            addCriterion("tel_en in", values, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnNotIn(List<String> values) {
            addCriterion("tel_en not in", values, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnBetween(String value1, String value2) {
            addCriterion("tel_en between", value1, value2, "telEn");
            return (Criteria) this;
        }

        public Criteria andTelEnNotBetween(String value1, String value2) {
            addCriterion("tel_en not between", value1, value2, "telEn");
            return (Criteria) this;
        }

        public Criteria andEmcUserIsNull() {
            addCriterion("emc_user is null");
            return (Criteria) this;
        }

        public Criteria andEmcUserIsNotNull() {
            addCriterion("emc_user is not null");
            return (Criteria) this;
        }

        public Criteria andEmcUserEqualTo(String value) {
            addCriterion("emc_user =", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserNotEqualTo(String value) {
            addCriterion("emc_user <>", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserGreaterThan(String value) {
            addCriterion("emc_user >", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserGreaterThanOrEqualTo(String value) {
            addCriterion("emc_user >=", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserLessThan(String value) {
            addCriterion("emc_user <", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserLessThanOrEqualTo(String value) {
            addCriterion("emc_user <=", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserLike(String value) {
            addCriterion("emc_user like", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserNotLike(String value) {
            addCriterion("emc_user not like", value, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserIn(List<String> values) {
            addCriterion("emc_user in", values, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserNotIn(List<String> values) {
            addCriterion("emc_user not in", values, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserBetween(String value1, String value2) {
            addCriterion("emc_user between", value1, value2, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcUserNotBetween(String value1, String value2) {
            addCriterion("emc_user not between", value1, value2, "emcUser");
            return (Criteria) this;
        }

        public Criteria andEmcTelIsNull() {
            addCriterion("emc_tel is null");
            return (Criteria) this;
        }

        public Criteria andEmcTelIsNotNull() {
            addCriterion("emc_tel is not null");
            return (Criteria) this;
        }

        public Criteria andEmcTelEqualTo(String value) {
            addCriterion("emc_tel =", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelNotEqualTo(String value) {
            addCriterion("emc_tel <>", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelGreaterThan(String value) {
            addCriterion("emc_tel >", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelGreaterThanOrEqualTo(String value) {
            addCriterion("emc_tel >=", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelLessThan(String value) {
            addCriterion("emc_tel <", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelLessThanOrEqualTo(String value) {
            addCriterion("emc_tel <=", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelLike(String value) {
            addCriterion("emc_tel like", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelNotLike(String value) {
            addCriterion("emc_tel not like", value, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelIn(List<String> values) {
            addCriterion("emc_tel in", values, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelNotIn(List<String> values) {
            addCriterion("emc_tel not in", values, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelBetween(String value1, String value2) {
            addCriterion("emc_tel between", value1, value2, "emcTel");
            return (Criteria) this;
        }

        public Criteria andEmcTelNotBetween(String value1, String value2) {
            addCriterion("emc_tel not between", value1, value2, "emcTel");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnIsNull() {
            addCriterion("from_school_cn is null");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnIsNotNull() {
            addCriterion("from_school_cn is not null");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnEqualTo(String value) {
            addCriterion("from_school_cn =", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnNotEqualTo(String value) {
            addCriterion("from_school_cn <>", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnGreaterThan(String value) {
            addCriterion("from_school_cn >", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnGreaterThanOrEqualTo(String value) {
            addCriterion("from_school_cn >=", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnLessThan(String value) {
            addCriterion("from_school_cn <", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnLessThanOrEqualTo(String value) {
            addCriterion("from_school_cn <=", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnLike(String value) {
            addCriterion("from_school_cn like", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnNotLike(String value) {
            addCriterion("from_school_cn not like", value, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnIn(List<String> values) {
            addCriterion("from_school_cn in", values, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnNotIn(List<String> values) {
            addCriterion("from_school_cn not in", values, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnBetween(String value1, String value2) {
            addCriterion("from_school_cn between", value1, value2, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolCnNotBetween(String value1, String value2) {
            addCriterion("from_school_cn not between", value1, value2, "fromSchoolCn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnIsNull() {
            addCriterion("from_school_en is null");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnIsNotNull() {
            addCriterion("from_school_en is not null");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnEqualTo(String value) {
            addCriterion("from_school_en =", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnNotEqualTo(String value) {
            addCriterion("from_school_en <>", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnGreaterThan(String value) {
            addCriterion("from_school_en >", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnGreaterThanOrEqualTo(String value) {
            addCriterion("from_school_en >=", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnLessThan(String value) {
            addCriterion("from_school_en <", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnLessThanOrEqualTo(String value) {
            addCriterion("from_school_en <=", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnLike(String value) {
            addCriterion("from_school_en like", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnNotLike(String value) {
            addCriterion("from_school_en not like", value, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnIn(List<String> values) {
            addCriterion("from_school_en in", values, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnNotIn(List<String> values) {
            addCriterion("from_school_en not in", values, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnBetween(String value1, String value2) {
            addCriterion("from_school_en between", value1, value2, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andFromSchoolEnNotBetween(String value1, String value2) {
            addCriterion("from_school_en not between", value1, value2, "fromSchoolEn");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostAddIsNull() {
            addCriterion("post_add is null");
            return (Criteria) this;
        }

        public Criteria andPostAddIsNotNull() {
            addCriterion("post_add is not null");
            return (Criteria) this;
        }

        public Criteria andPostAddEqualTo(String value) {
            addCriterion("post_add =", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddNotEqualTo(String value) {
            addCriterion("post_add <>", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddGreaterThan(String value) {
            addCriterion("post_add >", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddGreaterThanOrEqualTo(String value) {
            addCriterion("post_add >=", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddLessThan(String value) {
            addCriterion("post_add <", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddLessThanOrEqualTo(String value) {
            addCriterion("post_add <=", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddLike(String value) {
            addCriterion("post_add like", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddNotLike(String value) {
            addCriterion("post_add not like", value, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddIn(List<String> values) {
            addCriterion("post_add in", values, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddNotIn(List<String> values) {
            addCriterion("post_add not in", values, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddBetween(String value1, String value2) {
            addCriterion("post_add between", value1, value2, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostAddNotBetween(String value1, String value2) {
            addCriterion("post_add not between", value1, value2, "postAdd");
            return (Criteria) this;
        }

        public Criteria andPostUserIsNull() {
            addCriterion("post_user is null");
            return (Criteria) this;
        }

        public Criteria andPostUserIsNotNull() {
            addCriterion("post_user is not null");
            return (Criteria) this;
        }

        public Criteria andPostUserEqualTo(String value) {
            addCriterion("post_user =", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserNotEqualTo(String value) {
            addCriterion("post_user <>", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserGreaterThan(String value) {
            addCriterion("post_user >", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserGreaterThanOrEqualTo(String value) {
            addCriterion("post_user >=", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserLessThan(String value) {
            addCriterion("post_user <", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserLessThanOrEqualTo(String value) {
            addCriterion("post_user <=", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserLike(String value) {
            addCriterion("post_user like", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserNotLike(String value) {
            addCriterion("post_user not like", value, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserIn(List<String> values) {
            addCriterion("post_user in", values, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserNotIn(List<String> values) {
            addCriterion("post_user not in", values, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserBetween(String value1, String value2) {
            addCriterion("post_user between", value1, value2, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostUserNotBetween(String value1, String value2) {
            addCriterion("post_user not between", value1, value2, "postUser");
            return (Criteria) this;
        }

        public Criteria andPostTelIsNull() {
            addCriterion("post_tel is null");
            return (Criteria) this;
        }

        public Criteria andPostTelIsNotNull() {
            addCriterion("post_tel is not null");
            return (Criteria) this;
        }

        public Criteria andPostTelEqualTo(String value) {
            addCriterion("post_tel =", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelNotEqualTo(String value) {
            addCriterion("post_tel <>", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelGreaterThan(String value) {
            addCriterion("post_tel >", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelGreaterThanOrEqualTo(String value) {
            addCriterion("post_tel >=", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelLessThan(String value) {
            addCriterion("post_tel <", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelLessThanOrEqualTo(String value) {
            addCriterion("post_tel <=", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelLike(String value) {
            addCriterion("post_tel like", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelNotLike(String value) {
            addCriterion("post_tel not like", value, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelIn(List<String> values) {
            addCriterion("post_tel in", values, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelNotIn(List<String> values) {
            addCriterion("post_tel not in", values, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelBetween(String value1, String value2) {
            addCriterion("post_tel between", value1, value2, "postTel");
            return (Criteria) this;
        }

        public Criteria andPostTelNotBetween(String value1, String value2) {
            addCriterion("post_tel not between", value1, value2, "postTel");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andGiftCodeIsNull() {
            addCriterion("gift_code is null");
            return (Criteria) this;
        }

        public Criteria andGiftCodeIsNotNull() {
            addCriterion("gift_code is not null");
            return (Criteria) this;
        }

        public Criteria andGiftCodeEqualTo(String value) {
            addCriterion("gift_code =", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeNotEqualTo(String value) {
            addCriterion("gift_code <>", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeGreaterThan(String value) {
            addCriterion("gift_code >", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeGreaterThanOrEqualTo(String value) {
            addCriterion("gift_code >=", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeLessThan(String value) {
            addCriterion("gift_code <", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeLessThanOrEqualTo(String value) {
            addCriterion("gift_code <=", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeLike(String value) {
            addCriterion("gift_code like", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeNotLike(String value) {
            addCriterion("gift_code not like", value, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeIn(List<String> values) {
            addCriterion("gift_code in", values, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeNotIn(List<String> values) {
            addCriterion("gift_code not in", values, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeBetween(String value1, String value2) {
            addCriterion("gift_code between", value1, value2, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftCodeNotBetween(String value1, String value2) {
            addCriterion("gift_code not between", value1, value2, "giftCode");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyIsNull() {
            addCriterion("gift_money is null");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyIsNotNull() {
            addCriterion("gift_money is not null");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyEqualTo(Long value) {
            addCriterion("gift_money =", value, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyNotEqualTo(Long value) {
            addCriterion("gift_money <>", value, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyGreaterThan(Long value) {
            addCriterion("gift_money >", value, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("gift_money >=", value, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyLessThan(Long value) {
            addCriterion("gift_money <", value, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyLessThanOrEqualTo(Long value) {
            addCriterion("gift_money <=", value, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyIn(List<Long> values) {
            addCriterion("gift_money in", values, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyNotIn(List<Long> values) {
            addCriterion("gift_money not in", values, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyBetween(Long value1, Long value2) {
            addCriterion("gift_money between", value1, value2, "giftMoney");
            return (Criteria) this;
        }

        public Criteria andGiftMoneyNotBetween(Long value1, Long value2) {
            addCriterion("gift_money not between", value1, value2, "giftMoney");
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

        public Criteria andInviteCodeIsNull() {
            addCriterion("invite_code is null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIsNotNull() {
            addCriterion("invite_code is not null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeEqualTo(String value) {
            addCriterion("invite_code =", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotEqualTo(String value) {
            addCriterion("invite_code <>", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThan(String value) {
            addCriterion("invite_code >", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invite_code >=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThan(String value) {
            addCriterion("invite_code <", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThanOrEqualTo(String value) {
            addCriterion("invite_code <=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLike(String value) {
            addCriterion("invite_code like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotLike(String value) {
            addCriterion("invite_code not like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIn(List<String> values) {
            addCriterion("invite_code in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotIn(List<String> values) {
            addCriterion("invite_code not in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeBetween(String value1, String value2) {
            addCriterion("invite_code between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotBetween(String value1, String value2) {
            addCriterion("invite_code not between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andIsPaidIsNull() {
            addCriterion("is_paid is null");
            return (Criteria) this;
        }

        public Criteria andIsPaidIsNotNull() {
            addCriterion("is_paid is not null");
            return (Criteria) this;
        }

        public Criteria andIsPaidEqualTo(Integer value) {
            addCriterion("is_paid =", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidNotEqualTo(Integer value) {
            addCriterion("is_paid <>", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidGreaterThan(Integer value) {
            addCriterion("is_paid >", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_paid >=", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidLessThan(Integer value) {
            addCriterion("is_paid <", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidLessThanOrEqualTo(Integer value) {
            addCriterion("is_paid <=", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidIn(List<Integer> values) {
            addCriterion("is_paid in", values, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidNotIn(List<Integer> values) {
            addCriterion("is_paid not in", values, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidBetween(Integer value1, Integer value2) {
            addCriterion("is_paid between", value1, value2, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_paid not between", value1, value2, "isPaid");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNull() {
            addCriterion("cardType is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("cardType is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(Integer value) {
            addCriterion("cardType =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(Integer value) {
            addCriterion("cardType <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(Integer value) {
            addCriterion("cardType >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardType >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(Integer value) {
            addCriterion("cardType <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(Integer value) {
            addCriterion("cardType <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<Integer> values) {
            addCriterion("cardType in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<Integer> values) {
            addCriterion("cardType not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(Integer value1, Integer value2) {
            addCriterion("cardType between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cardType not between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andSchooladdressIsNull() {
            addCriterion("schoolAddress is null");
            return (Criteria) this;
        }

        public Criteria andSchooladdressIsNotNull() {
            addCriterion("schoolAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSchooladdressEqualTo(String value) {
            addCriterion("schoolAddress =", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotEqualTo(String value) {
            addCriterion("schoolAddress <>", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressGreaterThan(String value) {
            addCriterion("schoolAddress >", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressGreaterThanOrEqualTo(String value) {
            addCriterion("schoolAddress >=", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressLessThan(String value) {
            addCriterion("schoolAddress <", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressLessThanOrEqualTo(String value) {
            addCriterion("schoolAddress <=", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressLike(String value) {
            addCriterion("schoolAddress like", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotLike(String value) {
            addCriterion("schoolAddress not like", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressIn(List<String> values) {
            addCriterion("schoolAddress in", values, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotIn(List<String> values) {
            addCriterion("schoolAddress not in", values, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressBetween(String value1, String value2) {
            addCriterion("schoolAddress between", value1, value2, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotBetween(String value1, String value2) {
            addCriterion("schoolAddress not between", value1, value2, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andEmcroleIsNull() {
            addCriterion("emcRole is null");
            return (Criteria) this;
        }

        public Criteria andEmcroleIsNotNull() {
            addCriterion("emcRole is not null");
            return (Criteria) this;
        }

        public Criteria andEmcroleEqualTo(String value) {
            addCriterion("emcRole =", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleNotEqualTo(String value) {
            addCriterion("emcRole <>", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleGreaterThan(String value) {
            addCriterion("emcRole >", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleGreaterThanOrEqualTo(String value) {
            addCriterion("emcRole >=", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleLessThan(String value) {
            addCriterion("emcRole <", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleLessThanOrEqualTo(String value) {
            addCriterion("emcRole <=", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleLike(String value) {
            addCriterion("emcRole like", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleNotLike(String value) {
            addCriterion("emcRole not like", value, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleIn(List<String> values) {
            addCriterion("emcRole in", values, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleNotIn(List<String> values) {
            addCriterion("emcRole not in", values, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleBetween(String value1, String value2) {
            addCriterion("emcRole between", value1, value2, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcroleNotBetween(String value1, String value2) {
            addCriterion("emcRole not between", value1, value2, "emcrole");
            return (Criteria) this;
        }

        public Criteria andEmcgenderIsNull() {
            addCriterion("emcGender is null");
            return (Criteria) this;
        }

        public Criteria andEmcgenderIsNotNull() {
            addCriterion("emcGender is not null");
            return (Criteria) this;
        }

        public Criteria andEmcgenderEqualTo(Integer value) {
            addCriterion("emcGender =", value, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderNotEqualTo(Integer value) {
            addCriterion("emcGender <>", value, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderGreaterThan(Integer value) {
            addCriterion("emcGender >", value, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("emcGender >=", value, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderLessThan(Integer value) {
            addCriterion("emcGender <", value, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderLessThanOrEqualTo(Integer value) {
            addCriterion("emcGender <=", value, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderIn(List<Integer> values) {
            addCriterion("emcGender in", values, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderNotIn(List<Integer> values) {
            addCriterion("emcGender not in", values, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderBetween(Integer value1, Integer value2) {
            addCriterion("emcGender between", value1, value2, "emcgender");
            return (Criteria) this;
        }

        public Criteria andEmcgenderNotBetween(Integer value1, Integer value2) {
            addCriterion("emcGender not between", value1, value2, "emcgender");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("weChat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("weChat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("weChat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("weChat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("weChat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("weChat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("weChat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("weChat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("weChat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("weChat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("weChat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("weChat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("weChat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("weChat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andHomeaddressIsNull() {
            addCriterion("homeAddress is null");
            return (Criteria) this;
        }

        public Criteria andHomeaddressIsNotNull() {
            addCriterion("homeAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHomeaddressEqualTo(String value) {
            addCriterion("homeAddress =", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressNotEqualTo(String value) {
            addCriterion("homeAddress <>", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressGreaterThan(String value) {
            addCriterion("homeAddress >", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressGreaterThanOrEqualTo(String value) {
            addCriterion("homeAddress >=", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressLessThan(String value) {
            addCriterion("homeAddress <", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressLessThanOrEqualTo(String value) {
            addCriterion("homeAddress <=", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressLike(String value) {
            addCriterion("homeAddress like", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressNotLike(String value) {
            addCriterion("homeAddress not like", value, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressIn(List<String> values) {
            addCriterion("homeAddress in", values, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressNotIn(List<String> values) {
            addCriterion("homeAddress not in", values, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressBetween(String value1, String value2) {
            addCriterion("homeAddress between", value1, value2, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andHomeaddressNotBetween(String value1, String value2) {
            addCriterion("homeAddress not between", value1, value2, "homeaddress");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIsNull() {
            addCriterion("professor_id is null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIsNotNull() {
            addCriterion("professor_id is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdEqualTo(Long value) {
            addCriterion("professor_id =", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotEqualTo(Long value) {
            addCriterion("professor_id <>", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThan(Long value) {
            addCriterion("professor_id >", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("professor_id >=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThan(Long value) {
            addCriterion("professor_id <", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThanOrEqualTo(Long value) {
            addCriterion("professor_id <=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIn(List<Long> values) {
            addCriterion("professor_id in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotIn(List<Long> values) {
            addCriterion("professor_id not in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdBetween(Long value1, Long value2) {
            addCriterion("professor_id between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotBetween(Long value1, Long value2) {
            addCriterion("professor_id not between", value1, value2, "professorId");
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