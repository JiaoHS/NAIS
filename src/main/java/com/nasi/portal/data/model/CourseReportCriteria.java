package com.nasi.portal.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseReportCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer end;

    public CourseReportCriteria() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
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

        public Criteria andStudentAccountIsNull() {
            addCriterion("student_account is null");
            return (Criteria) this;
        }

        public Criteria andStudentAccountIsNotNull() {
            addCriterion("student_account is not null");
            return (Criteria) this;
        }

        public Criteria andStudentAccountEqualTo(String value) {
            addCriterion("student_account =", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotEqualTo(String value) {
            addCriterion("student_account <>", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountGreaterThan(String value) {
            addCriterion("student_account >", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountGreaterThanOrEqualTo(String value) {
            addCriterion("student_account >=", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountLessThan(String value) {
            addCriterion("student_account <", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountLessThanOrEqualTo(String value) {
            addCriterion("student_account <=", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountLike(String value) {
            addCriterion("student_account like", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotLike(String value) {
            addCriterion("student_account not like", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountIn(List<String> values) {
            addCriterion("student_account in", values, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotIn(List<String> values) {
            addCriterion("student_account not in", values, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountBetween(String value1, String value2) {
            addCriterion("student_account between", value1, value2, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotBetween(String value1, String value2) {
            addCriterion("student_account not between", value1, value2, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andArrangeIdIsNull() {
            addCriterion("arrange_id is null");
            return (Criteria) this;
        }

        public Criteria andArrangeIdIsNotNull() {
            addCriterion("arrange_id is not null");
            return (Criteria) this;
        }

        public Criteria andArrangeIdEqualTo(Integer value) {
            addCriterion("arrange_id =", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdNotEqualTo(Integer value) {
            addCriterion("arrange_id <>", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdGreaterThan(Integer value) {
            addCriterion("arrange_id >", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("arrange_id >=", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdLessThan(Integer value) {
            addCriterion("arrange_id <", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdLessThanOrEqualTo(Integer value) {
            addCriterion("arrange_id <=", value, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdIn(List<Integer> values) {
            addCriterion("arrange_id in", values, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdNotIn(List<Integer> values) {
            addCriterion("arrange_id not in", values, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdBetween(Integer value1, Integer value2) {
            addCriterion("arrange_id between", value1, value2, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andArrangeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("arrange_id not between", value1, value2, "arrangeId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("`comment` is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("`comment` is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("`comment` =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("`comment` <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("`comment` >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("`comment` >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("`comment` <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("`comment` <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("`comment` like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("`comment` not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("`comment` in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("`comment` not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("`comment` between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("`comment` not between", value1, value2, "comment");
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

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Integer value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Integer value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Integer value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Integer value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Integer> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Integer> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
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

        public Criteria andProfessorIdIsNull() {
            addCriterion("professor_id is null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIsNotNull() {
            addCriterion("professor_id is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdEqualTo(Integer value) {
            addCriterion("professor_id =", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotEqualTo(Integer value) {
            addCriterion("professor_id <>", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThan(Integer value) {
            addCriterion("professor_id >", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("professor_id >=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThan(Integer value) {
            addCriterion("professor_id <", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThanOrEqualTo(Integer value) {
            addCriterion("professor_id <=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIn(List<Integer> values) {
            addCriterion("professor_id in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotIn(List<Integer> values) {
            addCriterion("professor_id not in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdBetween(Integer value1, Integer value2) {
            addCriterion("professor_id between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("professor_id not between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnIsNull() {
            addCriterion("professor_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnIsNotNull() {
            addCriterion("professor_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnEqualTo(String value) {
            addCriterion("professor_name_cn =", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotEqualTo(String value) {
            addCriterion("professor_name_cn <>", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnGreaterThan(String value) {
            addCriterion("professor_name_cn >", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("professor_name_cn >=", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnLessThan(String value) {
            addCriterion("professor_name_cn <", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnLessThanOrEqualTo(String value) {
            addCriterion("professor_name_cn <=", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnLike(String value) {
            addCriterion("professor_name_cn like", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotLike(String value) {
            addCriterion("professor_name_cn not like", value, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnIn(List<String> values) {
            addCriterion("professor_name_cn in", values, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotIn(List<String> values) {
            addCriterion("professor_name_cn not in", values, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnBetween(String value1, String value2) {
            addCriterion("professor_name_cn between", value1, value2, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameCnNotBetween(String value1, String value2) {
            addCriterion("professor_name_cn not between", value1, value2, "professorNameCn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnIsNull() {
            addCriterion("professor_name_en is null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnIsNotNull() {
            addCriterion("professor_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnEqualTo(String value) {
            addCriterion("professor_name_en =", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotEqualTo(String value) {
            addCriterion("professor_name_en <>", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnGreaterThan(String value) {
            addCriterion("professor_name_en >", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("professor_name_en >=", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnLessThan(String value) {
            addCriterion("professor_name_en <", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnLessThanOrEqualTo(String value) {
            addCriterion("professor_name_en <=", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnLike(String value) {
            addCriterion("professor_name_en like", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotLike(String value) {
            addCriterion("professor_name_en not like", value, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnIn(List<String> values) {
            addCriterion("professor_name_en in", values, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotIn(List<String> values) {
            addCriterion("professor_name_en not in", values, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnBetween(String value1, String value2) {
            addCriterion("professor_name_en between", value1, value2, "professorNameEn");
            return (Criteria) this;
        }

        public Criteria andProfessorNameEnNotBetween(String value1, String value2) {
            addCriterion("professor_name_en not between", value1, value2, "professorNameEn");
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