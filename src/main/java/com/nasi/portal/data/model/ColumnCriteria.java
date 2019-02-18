package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.List;

public class ColumnCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public ColumnCriteria() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andEtitleIsNull() {
            addCriterion("etitle is null");
            return (Criteria) this;
        }

        public Criteria andEtitleIsNotNull() {
            addCriterion("etitle is not null");
            return (Criteria) this;
        }

        public Criteria andEtitleEqualTo(String value) {
            addCriterion("etitle =", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleNotEqualTo(String value) {
            addCriterion("etitle <>", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleGreaterThan(String value) {
            addCriterion("etitle >", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleGreaterThanOrEqualTo(String value) {
            addCriterion("etitle >=", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleLessThan(String value) {
            addCriterion("etitle <", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleLessThanOrEqualTo(String value) {
            addCriterion("etitle <=", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleLike(String value) {
            addCriterion("etitle like", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleNotLike(String value) {
            addCriterion("etitle not like", value, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleIn(List<String> values) {
            addCriterion("etitle in", values, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleNotIn(List<String> values) {
            addCriterion("etitle not in", values, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleBetween(String value1, String value2) {
            addCriterion("etitle between", value1, value2, "etitle");
            return (Criteria) this;
        }

        public Criteria andEtitleNotBetween(String value1, String value2) {
            addCriterion("etitle not between", value1, value2, "etitle");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("`location` is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("`location` is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(Integer value) {
            addCriterion("`location` =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(Integer value) {
            addCriterion("`location` <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(Integer value) {
            addCriterion("`location` >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("`location` >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(Integer value) {
            addCriterion("`location` <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(Integer value) {
            addCriterion("`location` <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<Integer> values) {
            addCriterion("`location` in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<Integer> values) {
            addCriterion("`location` not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(Integer value1, Integer value2) {
            addCriterion("`location` between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("`location` not between", value1, value2, "location");
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

        public Criteria andLevelIsNull() {
            addCriterion("`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNull() {
            addCriterion("column_type is null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNotNull() {
            addCriterion("column_type is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeEqualTo(Integer value) {
            addCriterion("column_type =", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotEqualTo(Integer value) {
            addCriterion("column_type <>", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThan(Integer value) {
            addCriterion("column_type >", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_type >=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThan(Integer value) {
            addCriterion("column_type <", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThanOrEqualTo(Integer value) {
            addCriterion("column_type <=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIn(List<Integer> values) {
            addCriterion("column_type in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotIn(List<Integer> values) {
            addCriterion("column_type not in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeBetween(Integer value1, Integer value2) {
            addCriterion("column_type between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("column_type not between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andEcontentIsNull() {
            addCriterion("econtent is null");
            return (Criteria) this;
        }

        public Criteria andEcontentIsNotNull() {
            addCriterion("econtent is not null");
            return (Criteria) this;
        }

        public Criteria andEcontentEqualTo(String value) {
            addCriterion("econtent =", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotEqualTo(String value) {
            addCriterion("econtent <>", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentGreaterThan(String value) {
            addCriterion("econtent >", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentGreaterThanOrEqualTo(String value) {
            addCriterion("econtent >=", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentLessThan(String value) {
            addCriterion("econtent <", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentLessThanOrEqualTo(String value) {
            addCriterion("econtent <=", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentLike(String value) {
            addCriterion("econtent like", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotLike(String value) {
            addCriterion("econtent not like", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentIn(List<String> values) {
            addCriterion("econtent in", values, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotIn(List<String> values) {
            addCriterion("econtent not in", values, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentBetween(String value1, String value2) {
            addCriterion("econtent between", value1, value2, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotBetween(String value1, String value2) {
            addCriterion("econtent not between", value1, value2, "econtent");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andEurlIsNull() {
            addCriterion("eurl is null");
            return (Criteria) this;
        }

        public Criteria andEurlIsNotNull() {
            addCriterion("eurl is not null");
            return (Criteria) this;
        }

        public Criteria andEurlEqualTo(String value) {
            addCriterion("eurl =", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlNotEqualTo(String value) {
            addCriterion("eurl <>", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlGreaterThan(String value) {
            addCriterion("eurl >", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlGreaterThanOrEqualTo(String value) {
            addCriterion("eurl >=", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlLessThan(String value) {
            addCriterion("eurl <", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlLessThanOrEqualTo(String value) {
            addCriterion("eurl <=", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlLike(String value) {
            addCriterion("eurl like", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlNotLike(String value) {
            addCriterion("eurl not like", value, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlIn(List<String> values) {
            addCriterion("eurl in", values, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlNotIn(List<String> values) {
            addCriterion("eurl not in", values, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlBetween(String value1, String value2) {
            addCriterion("eurl between", value1, value2, "eurl");
            return (Criteria) this;
        }

        public Criteria andEurlNotBetween(String value1, String value2) {
            addCriterion("eurl not between", value1, value2, "eurl");
            return (Criteria) this;
        }

        public Criteria andColumnStatusIsNull() {
            addCriterion("column_status is null");
            return (Criteria) this;
        }

        public Criteria andColumnStatusIsNotNull() {
            addCriterion("column_status is not null");
            return (Criteria) this;
        }

        public Criteria andColumnStatusEqualTo(Integer value) {
            addCriterion("column_status =", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusNotEqualTo(Integer value) {
            addCriterion("column_status <>", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusGreaterThan(Integer value) {
            addCriterion("column_status >", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_status >=", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusLessThan(Integer value) {
            addCriterion("column_status <", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("column_status <=", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusIn(List<Integer> values) {
            addCriterion("column_status in", values, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusNotIn(List<Integer> values) {
            addCriterion("column_status not in", values, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusBetween(Integer value1, Integer value2) {
            addCriterion("column_status between", value1, value2, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("column_status not between", value1, value2, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andBannerIsNull() {
            addCriterion("banner is null");
            return (Criteria) this;
        }

        public Criteria andBannerIsNotNull() {
            addCriterion("banner is not null");
            return (Criteria) this;
        }

        public Criteria andBannerEqualTo(String value) {
            addCriterion("banner =", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotEqualTo(String value) {
            addCriterion("banner <>", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThan(String value) {
            addCriterion("banner >", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThanOrEqualTo(String value) {
            addCriterion("banner >=", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLessThan(String value) {
            addCriterion("banner <", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLessThanOrEqualTo(String value) {
            addCriterion("banner <=", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLike(String value) {
            addCriterion("banner like", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotLike(String value) {
            addCriterion("banner not like", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerIn(List<String> values) {
            addCriterion("banner in", values, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotIn(List<String> values) {
            addCriterion("banner not in", values, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerBetween(String value1, String value2) {
            addCriterion("banner between", value1, value2, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotBetween(String value1, String value2) {
            addCriterion("banner not between", value1, value2, "banner");
            return (Criteria) this;
        }

        public Criteria andEbannerIsNull() {
            addCriterion("ebanner is null");
            return (Criteria) this;
        }

        public Criteria andEbannerIsNotNull() {
            addCriterion("ebanner is not null");
            return (Criteria) this;
        }

        public Criteria andEbannerEqualTo(String value) {
            addCriterion("ebanner =", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerNotEqualTo(String value) {
            addCriterion("ebanner <>", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerGreaterThan(String value) {
            addCriterion("ebanner >", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerGreaterThanOrEqualTo(String value) {
            addCriterion("ebanner >=", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerLessThan(String value) {
            addCriterion("ebanner <", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerLessThanOrEqualTo(String value) {
            addCriterion("ebanner <=", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerLike(String value) {
            addCriterion("ebanner like", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerNotLike(String value) {
            addCriterion("ebanner not like", value, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerIn(List<String> values) {
            addCriterion("ebanner in", values, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerNotIn(List<String> values) {
            addCriterion("ebanner not in", values, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerBetween(String value1, String value2) {
            addCriterion("ebanner between", value1, value2, "ebanner");
            return (Criteria) this;
        }

        public Criteria andEbannerNotBetween(String value1, String value2) {
            addCriterion("ebanner not between", value1, value2, "ebanner");
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