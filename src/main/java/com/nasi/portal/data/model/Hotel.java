package com.nasi.portal.data.model;

import java.util.Date;

public class Hotel {
    private Integer id;

    private String hotelNameCn;

    private String hotelNameEn;

    private String descriptionCn;

    private String descriptionEn;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer campusid;

    private String hotaladdress;

    private String hotalimage1;

    private String hotalimage2;

    private Integer hotalstar;

    private Date starttime;

    private Date endtime;

    private Integer roomtype;

    private String roonumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelNameCn() {
        return hotelNameCn;
    }

    public void setHotelNameCn(String hotelNameCn) {
        this.hotelNameCn = hotelNameCn == null ? null : hotelNameCn.trim();
    }

    public String getHotelNameEn() {
        return hotelNameEn;
    }

    public void setHotelNameEn(String hotelNameEn) {
        this.hotelNameEn = hotelNameEn == null ? null : hotelNameEn.trim();
    }

    public String getDescriptionCn() {
        return descriptionCn;
    }

    public void setDescriptionCn(String descriptionCn) {
        this.descriptionCn = descriptionCn == null ? null : descriptionCn.trim();
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn == null ? null : descriptionEn.trim();
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

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }

    public String getHotaladdress() {
        return hotaladdress;
    }

    public void setHotaladdress(String hotaladdress) {
        this.hotaladdress = hotaladdress == null ? null : hotaladdress.trim();
    }

    public String getHotalimage1() {
        return hotalimage1;
    }

    public void setHotalimage1(String hotalimage1) {
        this.hotalimage1 = hotalimage1 == null ? null : hotalimage1.trim();
    }

    public String getHotalimage2() {
        return hotalimage2;
    }

    public void setHotalimage2(String hotalimage2) {
        this.hotalimage2 = hotalimage2 == null ? null : hotalimage2.trim();
    }

    public Integer getHotalstar() {
        return hotalstar;
    }

    public void setHotalstar(Integer hotalstar) {
        this.hotalstar = hotalstar;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public String getRoonumber() {
        return roonumber;
    }

    public void setRoonumber(String roonumber) {
        this.roonumber = roonumber == null ? null : roonumber.trim();
    }
}