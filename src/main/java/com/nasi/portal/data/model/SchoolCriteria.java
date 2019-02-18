package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public SchoolCriteria() {
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

        public Criteria andSchoolNameCnIsNull() {
            addCriterion("school_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnIsNotNull() {
            addCriterion("school_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnEqualTo(String value) {
            addCriterion("school_name_cn =", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotEqualTo(String value) {
            addCriterion("school_name_cn <>", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnGreaterThan(String value) {
            addCriterion("school_name_cn >", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("school_name_cn >=", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnLessThan(String value) {
            addCriterion("school_name_cn <", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnLessThanOrEqualTo(String value) {
            addCriterion("school_name_cn <=", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnLike(String value) {
            addCriterion("school_name_cn like", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotLike(String value) {
            addCriterion("school_name_cn not like", value, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnIn(List<String> values) {
            addCriterion("school_name_cn in", values, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotIn(List<String> values) {
            addCriterion("school_name_cn not in", values, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnBetween(String value1, String value2) {
            addCriterion("school_name_cn between", value1, value2, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameCnNotBetween(String value1, String value2) {
            addCriterion("school_name_cn not between", value1, value2, "schoolNameCn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIsNull() {
            addCriterion("school_name_en is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIsNotNull() {
            addCriterion("school_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnEqualTo(String value) {
            addCriterion("school_name_en =", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotEqualTo(String value) {
            addCriterion("school_name_en <>", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnGreaterThan(String value) {
            addCriterion("school_name_en >", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("school_name_en >=", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLessThan(String value) {
            addCriterion("school_name_en <", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLessThanOrEqualTo(String value) {
            addCriterion("school_name_en <=", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLike(String value) {
            addCriterion("school_name_en like", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotLike(String value) {
            addCriterion("school_name_en not like", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIn(List<String> values) {
            addCriterion("school_name_en in", values, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotIn(List<String> values) {
            addCriterion("school_name_en not in", values, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnBetween(String value1, String value2) {
            addCriterion("school_name_en between", value1, value2, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotBetween(String value1, String value2) {
            addCriterion("school_name_en not between", value1, value2, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnIsNull() {
            addCriterion("school_desc_cn is null");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnIsNotNull() {
            addCriterion("school_desc_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnEqualTo(String value) {
            addCriterion("school_desc_cn =", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnNotEqualTo(String value) {
            addCriterion("school_desc_cn <>", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnGreaterThan(String value) {
            addCriterion("school_desc_cn >", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnGreaterThanOrEqualTo(String value) {
            addCriterion("school_desc_cn >=", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnLessThan(String value) {
            addCriterion("school_desc_cn <", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnLessThanOrEqualTo(String value) {
            addCriterion("school_desc_cn <=", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnLike(String value) {
            addCriterion("school_desc_cn like", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnNotLike(String value) {
            addCriterion("school_desc_cn not like", value, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnIn(List<String> values) {
            addCriterion("school_desc_cn in", values, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnNotIn(List<String> values) {
            addCriterion("school_desc_cn not in", values, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnBetween(String value1, String value2) {
            addCriterion("school_desc_cn between", value1, value2, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescCnNotBetween(String value1, String value2) {
            addCriterion("school_desc_cn not between", value1, value2, "schoolDescCn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnIsNull() {
            addCriterion("school_desc_en is null");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnIsNotNull() {
            addCriterion("school_desc_en is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnEqualTo(String value) {
            addCriterion("school_desc_en =", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnNotEqualTo(String value) {
            addCriterion("school_desc_en <>", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnGreaterThan(String value) {
            addCriterion("school_desc_en >", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnGreaterThanOrEqualTo(String value) {
            addCriterion("school_desc_en >=", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnLessThan(String value) {
            addCriterion("school_desc_en <", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnLessThanOrEqualTo(String value) {
            addCriterion("school_desc_en <=", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnLike(String value) {
            addCriterion("school_desc_en like", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnNotLike(String value) {
            addCriterion("school_desc_en not like", value, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnIn(List<String> values) {
            addCriterion("school_desc_en in", values, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnNotIn(List<String> values) {
            addCriterion("school_desc_en not in", values, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnBetween(String value1, String value2) {
            addCriterion("school_desc_en between", value1, value2, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolDescEnNotBetween(String value1, String value2) {
            addCriterion("school_desc_en not between", value1, value2, "schoolDescEn");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceIsNull() {
            addCriterion("school_provice is null");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceIsNotNull() {
            addCriterion("school_provice is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceEqualTo(String value) {
            addCriterion("school_provice =", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotEqualTo(String value) {
            addCriterion("school_provice <>", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceGreaterThan(String value) {
            addCriterion("school_provice >", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceGreaterThanOrEqualTo(String value) {
            addCriterion("school_provice >=", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceLessThan(String value) {
            addCriterion("school_provice <", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceLessThanOrEqualTo(String value) {
            addCriterion("school_provice <=", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceLike(String value) {
            addCriterion("school_provice like", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotLike(String value) {
            addCriterion("school_provice not like", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceIn(List<String> values) {
            addCriterion("school_provice in", values, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotIn(List<String> values) {
            addCriterion("school_provice not in", values, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceBetween(String value1, String value2) {
            addCriterion("school_provice between", value1, value2, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotBetween(String value1, String value2) {
            addCriterion("school_provice not between", value1, value2, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolCityIsNull() {
            addCriterion("school_city is null");
            return (Criteria) this;
        }

        public Criteria andSchoolCityIsNotNull() {
            addCriterion("school_city is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolCityEqualTo(String value) {
            addCriterion("school_city =", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotEqualTo(String value) {
            addCriterion("school_city <>", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityGreaterThan(String value) {
            addCriterion("school_city >", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityGreaterThanOrEqualTo(String value) {
            addCriterion("school_city >=", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityLessThan(String value) {
            addCriterion("school_city <", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityLessThanOrEqualTo(String value) {
            addCriterion("school_city <=", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityLike(String value) {
            addCriterion("school_city like", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotLike(String value) {
            addCriterion("school_city not like", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityIn(List<String> values) {
            addCriterion("school_city in", values, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotIn(List<String> values) {
            addCriterion("school_city not in", values, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityBetween(String value1, String value2) {
            addCriterion("school_city between", value1, value2, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotBetween(String value1, String value2) {
            addCriterion("school_city not between", value1, value2, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSeasonStartIsNull() {
            addCriterion("season_start is null");
            return (Criteria) this;
        }

        public Criteria andSeasonStartIsNotNull() {
            addCriterion("season_start is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonStartEqualTo(Date value) {
            addCriterion("season_start =", value, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartNotEqualTo(Date value) {
            addCriterion("season_start <>", value, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartGreaterThan(Date value) {
            addCriterion("season_start >", value, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartGreaterThanOrEqualTo(Date value) {
            addCriterion("season_start >=", value, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartLessThan(Date value) {
            addCriterion("season_start <", value, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartLessThanOrEqualTo(Date value) {
            addCriterion("season_start <=", value, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartIn(List<Date> values) {
            addCriterion("season_start in", values, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartNotIn(List<Date> values) {
            addCriterion("season_start not in", values, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartBetween(Date value1, Date value2) {
            addCriterion("season_start between", value1, value2, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonStartNotBetween(Date value1, Date value2) {
            addCriterion("season_start not between", value1, value2, "seasonStart");
            return (Criteria) this;
        }

        public Criteria andSeasonEndIsNull() {
            addCriterion("season_end is null");
            return (Criteria) this;
        }

        public Criteria andSeasonEndIsNotNull() {
            addCriterion("season_end is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonEndEqualTo(Date value) {
            addCriterion("season_end =", value, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndNotEqualTo(Date value) {
            addCriterion("season_end <>", value, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndGreaterThan(Date value) {
            addCriterion("season_end >", value, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndGreaterThanOrEqualTo(Date value) {
            addCriterion("season_end >=", value, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndLessThan(Date value) {
            addCriterion("season_end <", value, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndLessThanOrEqualTo(Date value) {
            addCriterion("season_end <=", value, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndIn(List<Date> values) {
            addCriterion("season_end in", values, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndNotIn(List<Date> values) {
            addCriterion("season_end not in", values, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndBetween(Date value1, Date value2) {
            addCriterion("season_end between", value1, value2, "seasonEnd");
            return (Criteria) this;
        }

        public Criteria andSeasonEndNotBetween(Date value1, Date value2) {
            addCriterion("season_end not between", value1, value2, "seasonEnd");
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

        public Criteria andShowOrderIsNull() {
            addCriterion("show_order is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNotNull() {
            addCriterion("show_order is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderEqualTo(Integer value) {
            addCriterion("show_order =", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotEqualTo(Integer value) {
            addCriterion("show_order <>", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThan(Integer value) {
            addCriterion("show_order >", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_order >=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThan(Integer value) {
            addCriterion("show_order <", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThanOrEqualTo(Integer value) {
            addCriterion("show_order <=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderIn(List<Integer> values) {
            addCriterion("show_order in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotIn(List<Integer> values) {
            addCriterion("show_order not in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderBetween(Integer value1, Integer value2) {
            addCriterion("show_order between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("show_order not between", value1, value2, "showOrder");
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