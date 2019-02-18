package com.nasi.portal.data.model;

import java.util.Date;

public class MainOrder {
    private Long id;

    private String paymentSeq;

    private Integer orderVersion;

    private Integer orderStatus;

    private Integer orderSource;

    private Long campusId;

    private Long totalAmount;

    private Long cashAmount;

    private Long discountAmount;

    private Integer paymentChannel;

    private Date paymentTime;

    private Date paymentSuccessTime;

    private Date createTime;

    private Date updateTime;

    private String paymenRemark;

    private String remark;

    private String manualPaidRep;

    private String receipt;

    private Integer createdUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentSeq() {
        return paymentSeq;
    }

    public void setPaymentSeq(String paymentSeq) {
        this.paymentSeq = paymentSeq == null ? null : paymentSeq.trim();
    }

    public Integer getOrderVersion() {
        return orderVersion;
    }

    public void setOrderVersion(Integer orderVersion) {
        this.orderVersion = orderVersion;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(Integer paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentSuccessTime() {
        return paymentSuccessTime;
    }

    public void setPaymentSuccessTime(Date paymentSuccessTime) {
        this.paymentSuccessTime = paymentSuccessTime;
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

    public String getPaymenRemark() {
        return paymenRemark;
    }

    public void setPaymenRemark(String paymenRemark) {
        this.paymenRemark = paymenRemark == null ? null : paymenRemark.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getManualPaidRep() {
        return manualPaidRep;
    }

    public void setManualPaidRep(String manualPaidRep) {
        this.manualPaidRep = manualPaidRep == null ? null : manualPaidRep.trim();
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt == null ? null : receipt.trim();
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }
}