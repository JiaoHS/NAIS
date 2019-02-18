package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CampusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusExample() {
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

        public Criteria andCampusNameEnIsNull() {
            addCriterion("campus_name_en is null");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnIsNotNull() {
            addCriterion("campus_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnEqualTo(String value) {
            addCriterion("campus_name_en =", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnNotEqualTo(String value) {
            addCriterion("campus_name_en <>", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnGreaterThan(String value) {
            addCriterion("campus_name_en >", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("campus_name_en >=", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnLessThan(String value) {
            addCriterion("campus_name_en <", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnLessThanOrEqualTo(String value) {
            addCriterion("campus_name_en <=", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnLike(String value) {
            addCriterion("campus_name_en like", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnNotLike(String value) {
            addCriterion("campus_name_en not like", value, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnIn(List<String> values) {
            addCriterion("campus_name_en in", values, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnNotIn(List<String> values) {
            addCriterion("campus_name_en not in", values, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnBetween(String value1, String value2) {
            addCriterion("campus_name_en between", value1, value2, "campusNameEn");
            return (Criteria) this;
        }

        public Criteria andCampusNameEnNotBetween(String value1, String value2) {
            addCriterion("campus_name_en not between", value1, value2, "campusNameEn");
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

        public Criteria andCampusPhotoIsNull() {
            addCriterion("campus_photo is null");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoIsNotNull() {
            addCriterion("campus_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoEqualTo(String value) {
            addCriterion("campus_photo =", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoNotEqualTo(String value) {
            addCriterion("campus_photo <>", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoGreaterThan(String value) {
            addCriterion("campus_photo >", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("campus_photo >=", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoLessThan(String value) {
            addCriterion("campus_photo <", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoLessThanOrEqualTo(String value) {
            addCriterion("campus_photo <=", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoLike(String value) {
            addCriterion("campus_photo like", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoNotLike(String value) {
            addCriterion("campus_photo not like", value, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoIn(List<String> values) {
            addCriterion("campus_photo in", values, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoNotIn(List<String> values) {
            addCriterion("campus_photo not in", values, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoBetween(String value1, String value2) {
            addCriterion("campus_photo between", value1, value2, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusPhotoNotBetween(String value1, String value2) {
            addCriterion("campus_photo not between", value1, value2, "campusPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoIsNull() {
            addCriterion("campus_banner_photo is null");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoIsNotNull() {
            addCriterion("campus_banner_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoEqualTo(String value) {
            addCriterion("campus_banner_photo =", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoNotEqualTo(String value) {
            addCriterion("campus_banner_photo <>", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoGreaterThan(String value) {
            addCriterion("campus_banner_photo >", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("campus_banner_photo >=", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoLessThan(String value) {
            addCriterion("campus_banner_photo <", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoLessThanOrEqualTo(String value) {
            addCriterion("campus_banner_photo <=", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoLike(String value) {
            addCriterion("campus_banner_photo like", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoNotLike(String value) {
            addCriterion("campus_banner_photo not like", value, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoIn(List<String> values) {
            addCriterion("campus_banner_photo in", values, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoNotIn(List<String> values) {
            addCriterion("campus_banner_photo not in", values, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoBetween(String value1, String value2) {
            addCriterion("campus_banner_photo between", value1, value2, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andCampusBannerPhotoNotBetween(String value1, String value2) {
            addCriterion("campus_banner_photo not between", value1, value2, "campusBannerPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoIsNull() {
            addCriterion("hotel_photo is null");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoIsNotNull() {
            addCriterion("hotel_photo is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoEqualTo(String value) {
            addCriterion("hotel_photo =", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoNotEqualTo(String value) {
            addCriterion("hotel_photo <>", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoGreaterThan(String value) {
            addCriterion("hotel_photo >", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_photo >=", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoLessThan(String value) {
            addCriterion("hotel_photo <", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoLessThanOrEqualTo(String value) {
            addCriterion("hotel_photo <=", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoLike(String value) {
            addCriterion("hotel_photo like", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoNotLike(String value) {
            addCriterion("hotel_photo not like", value, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoIn(List<String> values) {
            addCriterion("hotel_photo in", values, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoNotIn(List<String> values) {
            addCriterion("hotel_photo not in", values, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoBetween(String value1, String value2) {
            addCriterion("hotel_photo between", value1, value2, "hotelPhoto");
            return (Criteria) this;
        }

        public Criteria andHotelPhotoNotBetween(String value1, String value2) {
            addCriterion("hotel_photo not between", value1, value2, "hotelPhoto");
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

        public Criteria andHoteladdressIsNull() {
            addCriterion("hoteladdress is null");
            return (Criteria) this;
        }

        public Criteria andHoteladdressIsNotNull() {
            addCriterion("hoteladdress is not null");
            return (Criteria) this;
        }

        public Criteria andHoteladdressEqualTo(String value) {
            addCriterion("hoteladdress =", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotEqualTo(String value) {
            addCriterion("hoteladdress <>", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressGreaterThan(String value) {
            addCriterion("hoteladdress >", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressGreaterThanOrEqualTo(String value) {
            addCriterion("hoteladdress >=", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressLessThan(String value) {
            addCriterion("hoteladdress <", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressLessThanOrEqualTo(String value) {
            addCriterion("hoteladdress <=", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressLike(String value) {
            addCriterion("hoteladdress like", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotLike(String value) {
            addCriterion("hoteladdress not like", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressIn(List<String> values) {
            addCriterion("hoteladdress in", values, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotIn(List<String> values) {
            addCriterion("hoteladdress not in", values, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressBetween(String value1, String value2) {
            addCriterion("hoteladdress between", value1, value2, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotBetween(String value1, String value2) {
            addCriterion("hoteladdress not between", value1, value2, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHotelimage1IsNull() {
            addCriterion("hotelimage1 is null");
            return (Criteria) this;
        }

        public Criteria andHotelimage1IsNotNull() {
            addCriterion("hotelimage1 is not null");
            return (Criteria) this;
        }

        public Criteria andHotelimage1EqualTo(String value) {
            addCriterion("hotelimage1 =", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1NotEqualTo(String value) {
            addCriterion("hotelimage1 <>", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1GreaterThan(String value) {
            addCriterion("hotelimage1 >", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1GreaterThanOrEqualTo(String value) {
            addCriterion("hotelimage1 >=", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1LessThan(String value) {
            addCriterion("hotelimage1 <", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1LessThanOrEqualTo(String value) {
            addCriterion("hotelimage1 <=", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1Like(String value) {
            addCriterion("hotelimage1 like", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1NotLike(String value) {
            addCriterion("hotelimage1 not like", value, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1In(List<String> values) {
            addCriterion("hotelimage1 in", values, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1NotIn(List<String> values) {
            addCriterion("hotelimage1 not in", values, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1Between(String value1, String value2) {
            addCriterion("hotelimage1 between", value1, value2, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage1NotBetween(String value1, String value2) {
            addCriterion("hotelimage1 not between", value1, value2, "hotelimage1");
            return (Criteria) this;
        }

        public Criteria andHotelimage2IsNull() {
            addCriterion("hotelimage2 is null");
            return (Criteria) this;
        }

        public Criteria andHotelimage2IsNotNull() {
            addCriterion("hotelimage2 is not null");
            return (Criteria) this;
        }

        public Criteria andHotelimage2EqualTo(String value) {
            addCriterion("hotelimage2 =", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2NotEqualTo(String value) {
            addCriterion("hotelimage2 <>", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2GreaterThan(String value) {
            addCriterion("hotelimage2 >", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2GreaterThanOrEqualTo(String value) {
            addCriterion("hotelimage2 >=", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2LessThan(String value) {
            addCriterion("hotelimage2 <", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2LessThanOrEqualTo(String value) {
            addCriterion("hotelimage2 <=", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2Like(String value) {
            addCriterion("hotelimage2 like", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2NotLike(String value) {
            addCriterion("hotelimage2 not like", value, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2In(List<String> values) {
            addCriterion("hotelimage2 in", values, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2NotIn(List<String> values) {
            addCriterion("hotelimage2 not in", values, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2Between(String value1, String value2) {
            addCriterion("hotelimage2 between", value1, value2, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotelimage2NotBetween(String value1, String value2) {
            addCriterion("hotelimage2 not between", value1, value2, "hotelimage2");
            return (Criteria) this;
        }

        public Criteria andHotalstarIsNull() {
            addCriterion("hotalstar is null");
            return (Criteria) this;
        }

        public Criteria andHotalstarIsNotNull() {
            addCriterion("hotalstar is not null");
            return (Criteria) this;
        }

        public Criteria andHotalstarEqualTo(String value) {
            addCriterion("hotalstar =", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarNotEqualTo(String value) {
            addCriterion("hotalstar <>", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarGreaterThan(String value) {
            addCriterion("hotalstar >", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarGreaterThanOrEqualTo(String value) {
            addCriterion("hotalstar >=", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarLessThan(String value) {
            addCriterion("hotalstar <", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarLessThanOrEqualTo(String value) {
            addCriterion("hotalstar <=", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarLike(String value) {
            addCriterion("hotalstar like", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarNotLike(String value) {
            addCriterion("hotalstar not like", value, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarIn(List<String> values) {
            addCriterion("hotalstar in", values, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarNotIn(List<String> values) {
            addCriterion("hotalstar not in", values, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarBetween(String value1, String value2) {
            addCriterion("hotalstar between", value1, value2, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHotalstarNotBetween(String value1, String value2) {
            addCriterion("hotalstar not between", value1, value2, "hotalstar");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIsNull() {
            addCriterion("hoteltype is null");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIsNotNull() {
            addCriterion("hoteltype is not null");
            return (Criteria) this;
        }

        public Criteria andHoteltypeEqualTo(String value) {
            addCriterion("hoteltype =", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotEqualTo(String value) {
            addCriterion("hoteltype <>", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeGreaterThan(String value) {
            addCriterion("hoteltype >", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeGreaterThanOrEqualTo(String value) {
            addCriterion("hoteltype >=", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLessThan(String value) {
            addCriterion("hoteltype <", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLessThanOrEqualTo(String value) {
            addCriterion("hoteltype <=", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLike(String value) {
            addCriterion("hoteltype like", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotLike(String value) {
            addCriterion("hoteltype not like", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIn(List<String> values) {
            addCriterion("hoteltype in", values, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotIn(List<String> values) {
            addCriterion("hoteltype not in", values, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeBetween(String value1, String value2) {
            addCriterion("hoteltype between", value1, value2, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotBetween(String value1, String value2) {
            addCriterion("hoteltype not between", value1, value2, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNull() {
            addCriterion("hotelname is null");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNotNull() {
            addCriterion("hotelname is not null");
            return (Criteria) this;
        }

        public Criteria andHotelnameEqualTo(String value) {
            addCriterion("hotelname =", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotEqualTo(String value) {
            addCriterion("hotelname <>", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThan(String value) {
            addCriterion("hotelname >", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelname >=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThan(String value) {
            addCriterion("hotelname <", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThanOrEqualTo(String value) {
            addCriterion("hotelname <=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLike(String value) {
            addCriterion("hotelname like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotLike(String value) {
            addCriterion("hotelname not like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameIn(List<String> values) {
            addCriterion("hotelname in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotIn(List<String> values) {
            addCriterion("hotelname not in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameBetween(String value1, String value2) {
            addCriterion("hotelname between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotBetween(String value1, String value2) {
            addCriterion("hotelname not between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceIsNull() {
            addCriterion("hoteldistance is null");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceIsNotNull() {
            addCriterion("hoteldistance is not null");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceEqualTo(String value) {
            addCriterion("hoteldistance =", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceNotEqualTo(String value) {
            addCriterion("hoteldistance <>", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceGreaterThan(String value) {
            addCriterion("hoteldistance >", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceGreaterThanOrEqualTo(String value) {
            addCriterion("hoteldistance >=", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceLessThan(String value) {
            addCriterion("hoteldistance <", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceLessThanOrEqualTo(String value) {
            addCriterion("hoteldistance <=", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceLike(String value) {
            addCriterion("hoteldistance like", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceNotLike(String value) {
            addCriterion("hoteldistance not like", value, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceIn(List<String> values) {
            addCriterion("hoteldistance in", values, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceNotIn(List<String> values) {
            addCriterion("hoteldistance not in", values, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceBetween(String value1, String value2) {
            addCriterion("hoteldistance between", value1, value2, "hoteldistance");
            return (Criteria) this;
        }

        public Criteria andHoteldistanceNotBetween(String value1, String value2) {
            addCriterion("hoteldistance not between", value1, value2, "hoteldistance");
            return (Criteria) this;
        }
        public Criteria andcampusDescIsNull() {
            addCriterion("campus_desc is null");
            return (Criteria) this;
        }

        public Criteria andcampusDescIsNotNull() {
            addCriterion("campus_desc is not null");
            return (Criteria) this;
        }

        public Criteria andcampusDescEqualTo(String value) {
            addCriterion("campus_desc =", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescNotEqualTo(String value) {
            addCriterion("campus_desc <>", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescGreaterThan(String value) {
            addCriterion("campus_desc >", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescGreaterThanOrEqualTo(String value) {
            addCriterion("campus_desc >=", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescLessThan(String value) {
            addCriterion("campus_desc <", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescLessThanOrEqualTo(String value) {
            addCriterion("campus_desc <=", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescLike(String value) {
            addCriterion("campus_desc like", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescNotLike(String value) {
            addCriterion("campus_desc not like", value, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescIn(List<String> values) {
            addCriterion("campus_desc in", values, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescNotIn(List<String> values) {
            addCriterion("campus_desc not in", values, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescBetween(String value1, String value2) {
            addCriterion("campus_desc between", value1, value2, "campusDesc");
            return (Criteria) this;
        }

        public Criteria andcampusDescNotBetween(String value1, String value2) {
            addCriterion("campus_desc not between", value1, value2, "campusDesc");
            return (Criteria) this;
        }



        public Criteria andadreesDescIsNull() {
            addCriterion("adreesDesc is null");
            return (Criteria) this;
        }

        public Criteria andadreesDescIsNotNull() {
            addCriterion("adreesDesc is not null");
            return (Criteria) this;
        }

        public Criteria andadreesDescEqualTo(String value) {
            addCriterion("adreesDesc =", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescNotEqualTo(String value) {
            addCriterion("adreesDesc <>", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescGreaterThan(String value) {
            addCriterion("adreesDesc >", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescGreaterThanOrEqualTo(String value) {
            addCriterion("adreesDesc >=", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescLessThan(String value) {
            addCriterion("adreesDesc <", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescLessThanOrEqualTo(String value) {
            addCriterion("adreesDesc <=", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescLike(String value) {
            addCriterion("adreesDesc like", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescNotLike(String value) {
            addCriterion("adreesDesc not like", value, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescIn(List<String> values) {
            addCriterion("adreesDesc in", values, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescNotIn(List<String> values) {
            addCriterion("adreesDesc not in", values, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescBetween(String value1, String value2) {
            addCriterion("adreesDesc between", value1, value2, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andadreesDescNotBetween(String value1, String value2) {
            addCriterion("adreesDesc not between", value1, value2, "adreesDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescIsNull() {
            addCriterion("hotelDesc is null");
            return (Criteria) this;
        }

        public Criteria andhotelDescIsNotNull() {
            addCriterion("hotelDesc is not null");
            return (Criteria) this;
        }

        public Criteria andhotelDescEqualTo(String value) {
            addCriterion("hotelDesc =", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescNotEqualTo(String value) {
            addCriterion("hotelDesc <>", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescGreaterThan(String value) {
            addCriterion("hotelDesc >", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescGreaterThanOrEqualTo(String value) {
            addCriterion("hotelDesc >=", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescLessThan(String value) {
            addCriterion("hotelDesc <", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescLessThanOrEqualTo(String value) {
            addCriterion("hotelDesc <=", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescLike(String value) {
            addCriterion("hotelDesc like", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescNotLike(String value) {
            addCriterion("hotelDesc not like", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescIn(List<String> values) {
            addCriterion("hotelDesc in", values, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescNotIn(List<String> values) {
            addCriterion("hotelDesc not in", values, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescBetween(String value1, String value2) {
            addCriterion("hotelDesc between", value1, value2, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andhotelDescNotBetween(String value1, String value2) {
            addCriterion("hotelDesc not between", value1, value2, "hotelDesc");
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