package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class School extends BaseModel implements Serializable {
    private Integer id;

    private String schoolNameCn;

    private String schoolNameEn;

    private String schoolDescCn;

    private String schoolDescEn;

    private String schoolProvice;

    private String schoolCity;

    private Date seasonStart;

    private Date seasonEnd;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer showOrder;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolNameCn() {
        return schoolNameCn;
    }

    public void setSchoolNameCn(String schoolNameCn) {
        this.schoolNameCn = schoolNameCn == null ? null : schoolNameCn.trim();
    }

    public String getSchoolNameEn() {
        return schoolNameEn;
    }

    public void setSchoolNameEn(String schoolNameEn) {
        this.schoolNameEn = schoolNameEn == null ? null : schoolNameEn.trim();
    }

    public String getSchoolDescCn() {
        return schoolDescCn;
    }

    public void setSchoolDescCn(String schoolDescCn) {
        this.schoolDescCn = schoolDescCn == null ? null : schoolDescCn.trim();
    }

    public String getSchoolDescEn() {
        return schoolDescEn;
    }

    public void setSchoolDescEn(String schoolDescEn) {
        this.schoolDescEn = schoolDescEn == null ? null : schoolDescEn.trim();
    }

    public String getSchoolProvice() {
        return schoolProvice;
    }

    public void setSchoolProvice(String schoolProvice) {
        this.schoolProvice = schoolProvice == null ? null : schoolProvice.trim();
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity == null ? null : schoolCity.trim();
    }

    public Date getSeasonStart() {
        return seasonStart;
    }

    public void setSeasonStart(Date seasonStart) {
        this.seasonStart = seasonStart;
    }

    public Date getSeasonEnd() {
        return seasonEnd;
    }

    public void setSeasonEnd(Date seasonEnd) {
        this.seasonEnd = seasonEnd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
}