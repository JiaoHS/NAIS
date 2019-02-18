package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class CourseHomeWorkAssign implements Serializable {
    private Long id;

    private Long arrangeId;

    private String workName;

    private Integer workStatus;

    private Integer workType;

    private String courseCode;

    private String courseNameCn;

    private String courseNameEn;

    private String workPath;

    private Date deadLineTime;

    private Integer workTotalScore;

    private String workDesc;

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

    public Long getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(Long arrangeId) {
        this.arrangeId = arrangeId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
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

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath == null ? null : workPath.trim();
    }

    public Date getDeadLineTime() {
        return deadLineTime;
    }

    public void setDeadLineTime(Date deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    public Integer getWorkTotalScore() {
        return workTotalScore;
    }

    public void setWorkTotalScore(Integer workTotalScore) {
        this.workTotalScore = workTotalScore;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc == null ? null : workDesc.trim();
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