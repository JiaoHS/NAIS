package com.nasi.portal.web.controller.yuyang.DTO;

/**
 * Created by yy on 2018-05-28.
 */
public class campusInfo {
    private Long id;
    private String campusName;
    private String campusNameEn;

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
        this.campusName = campusName;
    }

    public String getCampusNameEn() {
        return campusNameEn;
    }

    public void setCampusNameEn(String campusNameEn) {
        this.campusNameEn = campusNameEn;
    }
}
