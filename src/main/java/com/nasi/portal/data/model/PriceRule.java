package com.nasi.portal.data.model;

import java.util.Date;

public class PriceRule {
    private Long id;

    private Long campusId;

    private String campusName;

    private Date ruleStartTime;

    private Date ruleEndTime;

    private Long ruleCourseCount;

    private Long ruleMoneyAmount;

    private String ruleDesc;

    private Integer ruleStatus;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName == null ? null : campusName.trim();
    }

    public Date getRuleStartTime() {
        return ruleStartTime;
    }

    public void setRuleStartTime(Date ruleStartTime) {
        this.ruleStartTime = ruleStartTime;
    }

    public Date getRuleEndTime() {
        return ruleEndTime;
    }

    public void setRuleEndTime(Date ruleEndTime) {
        this.ruleEndTime = ruleEndTime;
    }

    public Long getRuleCourseCount() {
        return ruleCourseCount;
    }

    public void setRuleCourseCount(Long ruleCourseCount) {
        this.ruleCourseCount = ruleCourseCount;
    }

    public Long getRuleMoneyAmount() {
        return ruleMoneyAmount;
    }

    public void setRuleMoneyAmount(Long ruleMoneyAmount) {
        this.ruleMoneyAmount = ruleMoneyAmount;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
    }

    public Integer getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(Integer ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}