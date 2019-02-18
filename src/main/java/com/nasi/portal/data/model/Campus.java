package com.nasi.portal.data.model;

import java.util.Date;

public class Campus {
    private Long id;

    private String campusName;

    private String campusNameEn;

    private Date seasonStart;

    private Date seasonEnd;

    private String campusPhoto;

    private String campusBannerPhoto;

    private String hotelPhoto;

    private Date createTime;

    private Date updateTime;

    private String hoteladdress;

    private String hotelimage1;

    private String hotelimage2;

    private String hotalstar;

    private String hoteltype;

    private String hotelname;

    private String hoteldistance;
    private String campusDesc;

    private String adreesDesc;

    private String hotelDesc;

    public String getCampusDesc() {
        return campusDesc;
    }

    public void setCampusDesc(String campusDesc) {
        this.campusDesc = campusDesc == null ? null : campusDesc.trim();
    }

    public String getAdreesDesc() {
        return adreesDesc;
    }

    public void setAdreesDesc(String adreesDesc) {
        this.adreesDesc = adreesDesc == null ? null : adreesDesc.trim();
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc == null ? null : hotelDesc.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName == null ? null : campusName.trim();
    }

    public String getCampusNameEn() {
        return campusNameEn;
    }

    public void setCampusNameEn(String campusNameEn) {
        this.campusNameEn = campusNameEn == null ? null : campusNameEn.trim();
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

    public String getCampusPhoto() {
        return campusPhoto;
    }

    public void setCampusPhoto(String campusPhoto) {
        this.campusPhoto = campusPhoto == null ? null : campusPhoto.trim();
    }

    public String getCampusBannerPhoto() {
        return campusBannerPhoto;
    }

    public void setCampusBannerPhoto(String campusBannerPhoto) {
        this.campusBannerPhoto = campusBannerPhoto == null ? null : campusBannerPhoto.trim();
    }

    public String getHotelPhoto() {
        return hotelPhoto;
    }

    public void setHotelPhoto(String hotelPhoto) {
        this.hotelPhoto = hotelPhoto == null ? null : hotelPhoto.trim();
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

    public String getHoteladdress() {
        return hoteladdress;
    }

    public void setHoteladdress(String hoteladdress) {
        this.hoteladdress = hoteladdress == null ? null : hoteladdress.trim();
    }

    public String getHotelimage1() {
        return hotelimage1;
    }

    public void setHotelimage1(String hotelimage1) {
        this.hotelimage1 = hotelimage1 == null ? null : hotelimage1.trim();
    }

    public String getHotelimage2() {
        return hotelimage2;
    }

    public void setHotelimage2(String hotelimage2) {
        this.hotelimage2 = hotelimage2 == null ? null : hotelimage2.trim();
    }

    public String getHotalstar() {
        return hotalstar;
    }

    public void setHotalstar(String hotalstar) {
        this.hotalstar = hotalstar == null ? null : hotalstar.trim();
    }

    public String getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(String hoteltype) {
        this.hoteltype = hoteltype == null ? null : hoteltype.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public String getHoteldistance() {
        return hoteldistance;
    }

    public void setHoteldistance(String hoteldistance) {
        this.hoteldistance = hoteldistance == null ? null : hoteldistance.trim();
    }
}