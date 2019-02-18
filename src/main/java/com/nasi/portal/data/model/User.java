package com.nasi.portal.data.model;

import java.util.Date;

public class User {
    private Integer id;

    private String email;

    private String password;

    private Integer roleId;

    private Integer active;

    private Long couponMoney;

    private Long couponCode;

    private String nameCn;

    private String nameEn;

    private Date birthDate;

    private String idCard;

    private String telCn;

    private String telEn;

    private String emcUser;

    private String emcTel;

    private String fromSchoolCn;

    private String fromSchoolEn;

    private String address;

    private String postAdd;

    private String postUser;

    private String postTel;

    private Long hotelId;

    private String giftCode;

    private Long giftMoney;

    private Date createTime;

    private Date updateTime;

    private String inviteCode;

    private String photo;

    private Integer isPaid;

    private Integer gender;

    private Integer cardtype;

    private String major;

    private String schooladdress;

    private String emcrole;

    private Integer emcgender;

    private String wechat;

    private String homeaddress;

    private Long professorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Long getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Long couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Long getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Long couponCode) {
        this.couponCode = couponCode;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getTelCn() {
        return telCn;
    }

    public void setTelCn(String telCn) {
        this.telCn = telCn == null ? null : telCn.trim();
    }

    public String getTelEn() {
        return telEn;
    }

    public void setTelEn(String telEn) {
        this.telEn = telEn == null ? null : telEn.trim();
    }

    public String getEmcUser() {
        return emcUser;
    }

    public void setEmcUser(String emcUser) {
        this.emcUser = emcUser == null ? null : emcUser.trim();
    }

    public String getEmcTel() {
        return emcTel;
    }

    public void setEmcTel(String emcTel) {
        this.emcTel = emcTel == null ? null : emcTel.trim();
    }

    public String getFromSchoolCn() {
        return fromSchoolCn;
    }

    public void setFromSchoolCn(String fromSchoolCn) {
        this.fromSchoolCn = fromSchoolCn == null ? null : fromSchoolCn.trim();
    }

    public String getFromSchoolEn() {
        return fromSchoolEn;
    }

    public void setFromSchoolEn(String fromSchoolEn) {
        this.fromSchoolEn = fromSchoolEn == null ? null : fromSchoolEn.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostAdd() {
        return postAdd;
    }

    public void setPostAdd(String postAdd) {
        this.postAdd = postAdd == null ? null : postAdd.trim();
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser == null ? null : postUser.trim();
    }

    public String getPostTel() {
        return postTel;
    }

    public void setPostTel(String postTel) {
        this.postTel = postTel == null ? null : postTel.trim();
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode == null ? null : giftCode.trim();
    }

    public Long getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(Long giftMoney) {
        this.giftMoney = giftMoney;
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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCardtype() {
        return cardtype;
    }

    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getSchooladdress() {
        return schooladdress;
    }

    public void setSchooladdress(String schooladdress) {
        this.schooladdress = schooladdress == null ? null : schooladdress.trim();
    }

    public String getEmcrole() {
        return emcrole;
    }

    public void setEmcrole(String emcrole) {
        this.emcrole = emcrole == null ? null : emcrole.trim();
    }

    public Integer getEmcgender() {
        return emcgender;
    }

    public void setEmcgender(Integer emcgender) {
        this.emcgender = emcgender;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }
}