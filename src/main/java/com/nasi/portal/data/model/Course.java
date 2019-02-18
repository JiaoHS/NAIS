package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class Course extends BaseModel implements Serializable {
    private Integer id;

    private String courseNameCn;

    private String courseNameEn;

    private String courseCode;

    private String courseDescCn;

    private String courseDescEn;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseNameCn() {
        return courseNameCn;
    }

    public void setCourseNameCn(String courseNameCn) {
        this.courseNameCn = courseNameCn == null ? null : courseNameCn.trim();
    }

    public String getCourseNameEn() {
        return courseNameEn;
    }

    public void setCourseNameEn(String courseNameEn) {
        this.courseNameEn = courseNameEn == null ? null : courseNameEn.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getCourseDescCn() {
        return courseDescCn;
    }

    public void setCourseDescCn(String courseDescCn) {
        this.courseDescCn = courseDescCn == null ? null : courseDescCn.trim();
    }

    public String getCourseDescEn() {
        return courseDescEn;
    }

    public void setCourseDescEn(String courseDescEn) {
        this.courseDescEn = courseDescEn == null ? null : courseDescEn.trim();
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}