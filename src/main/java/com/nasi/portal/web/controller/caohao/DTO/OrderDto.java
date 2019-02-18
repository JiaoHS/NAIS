package com.nasi.portal.web.controller.caohao.DTO;

/**
 * created by xdCao on 2018/5/12
 */

public class OrderDto {

    private Long id;

    private String paymentSeq;

    private Integer orderSource;

    private Integer orderStatus;

    private String createdUser;

    private Integer paymentChannel;

    private Long campusId;

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
        this.paymentSeq = paymentSeq;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Integer getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(Integer paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }
}
