package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class PaidSubject implements Serializable {
    private Long id;

    private String subjectNameCn;

    private String subjectNameEn;

    private Integer subjectType;

    private Long subjectMoney;

    private Integer subjectStatus;

    private Integer pageOrder;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectNameCn() {
        return subjectNameCn;
    }

    public void setSubjectNameCn(String subjectNameCn) {
        this.subjectNameCn = subjectNameCn == null ? null : subjectNameCn.trim();
    }

    public String getSubjectNameEn() {
        return subjectNameEn;
    }

    public void setSubjectNameEn(String subjectNameEn) {
        this.subjectNameEn = subjectNameEn == null ? null : subjectNameEn.trim();
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public Long getSubjectMoney() {
        return subjectMoney;
    }

    public void setSubjectMoney(Long subjectMoney) {
        this.subjectMoney = subjectMoney;
    }

    public Integer getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(Integer subjectStatus) {
        this.subjectStatus = subjectStatus;
    }

    public Integer getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(Integer pageOrder) {
        this.pageOrder = pageOrder;
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
}