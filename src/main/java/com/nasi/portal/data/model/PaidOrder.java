package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class PaidOrder implements Serializable {
    private Long id;

    private Long userId;

    private Integer orderStatus;

    private Long createUser;

    private Long updateUser;

    private Date createTime;

    private Date updateTime;

    private Long realMoney;

    private String couponCode;

    private Long couponMoney;

    private Long needPayMoney;

    private String subjectIds;

    private String paidAccount;

    private String paidUser;

    private String paidBank;

    private Long paidMoney;

    private String paidDesc;

    private String paidPhone;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
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

    public Long getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(Long realMoney) {
        this.realMoney = realMoney;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public Long getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Long couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Long getNeedPayMoney() {
        return needPayMoney;
    }

    public void setNeedPayMoney(Long needPayMoney) {
        this.needPayMoney = needPayMoney;
    }

    public String getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(String subjectIds) {
        this.subjectIds = subjectIds == null ? null : subjectIds.trim();
    }

    public String getPaidAccount() {
        return paidAccount;
    }

    public void setPaidAccount(String paidAccount) {
        this.paidAccount = paidAccount == null ? null : paidAccount.trim();
    }

    public String getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(String paidUser) {
        this.paidUser = paidUser == null ? null : paidUser.trim();
    }

    public String getPaidBank() {
        return paidBank;
    }

    public void setPaidBank(String paidBank) {
        this.paidBank = paidBank == null ? null : paidBank.trim();
    }

    public Long getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(Long paidMoney) {
        this.paidMoney = paidMoney;
    }

    public String getPaidDesc() {
        return paidDesc;
    }

    public void setPaidDesc(String paidDesc) {
        this.paidDesc = paidDesc == null ? null : paidDesc.trim();
    }

    public String getPaidPhone() {
        return paidPhone;
    }

    public void setPaidPhone(String paidPhone) {
        this.paidPhone = paidPhone == null ? null : paidPhone.trim();
    }
}