package com.nasi.portal.data.model;

public class CampusWithBLOBs extends Campus {
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
}