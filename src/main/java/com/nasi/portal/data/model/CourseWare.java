package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class CourseWare implements Serializable {
    private Long id;

    private String wareNameCn;

    private String wareNameEn;

    private Integer wareNameCount;

    private Integer wareStatus;

    private String wareNameDesc;

    private Long courseId;

    private String courseNameCn;

    private String courseNameEn;

    private String courseCode;

    private Long arrangeId;

    private String warePath;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWareNameCn() {
        return wareNameCn;
    }

    public void setWareNameCn(String wareNameCn) {
        this.wareNameCn = wareNameCn == null ? null : wareNameCn.trim();
    }

    public String getWareNameEn() {
        return wareNameEn;
    }

    public void setWareNameEn(String wareNameEn) {
        this.wareNameEn = wareNameEn == null ? null : wareNameEn.trim();
    }

    public Integer getWareNameCount() {
        return wareNameCount;
    }

    public void setWareNameCount(Integer wareNameCount) {
        this.wareNameCount = wareNameCount;
    }

    public Integer getWareStatus() {
        return wareStatus;
    }

    public void setWareStatus(Integer wareStatus) {
        this.wareStatus = wareStatus;
    }

    public String getWareNameDesc() {
        return wareNameDesc;
    }

    public void setWareNameDesc(String wareNameDesc) {
        this.wareNameDesc = wareNameDesc == null ? null : wareNameDesc.trim();
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Long getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(Long arrangeId) {
        this.arrangeId = arrangeId;
    }

    public String getWarePath() {
        return warePath;
    }

    public void setWarePath(String warePath) {
        this.warePath = warePath == null ? null : warePath.trim();
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
}