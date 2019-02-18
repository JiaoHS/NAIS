package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class ClassContact implements Serializable {
    private Long id;

    private String contactName;

    private String contactMoblie;

    private String contactPhone;

    private String contactAdd;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactMoblie() {
        return contactMoblie;
    }

    public void setContactMoblie(String contactMoblie) {
        this.contactMoblie = contactMoblie == null ? null : contactMoblie.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactAdd() {
        return contactAdd;
    }

    public void setContactAdd(String contactAdd) {
        this.contactAdd = contactAdd == null ? null : contactAdd.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClassContact other = (ClassContact) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactMoblie() == null ? other.getContactMoblie() == null : this.getContactMoblie().equals(other.getContactMoblie()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getContactAdd() == null ? other.getContactAdd() == null : this.getContactAdd().equals(other.getContactAdd()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactMoblie() == null) ? 0 : getContactMoblie().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getContactAdd() == null) ? 0 : getContactAdd().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}