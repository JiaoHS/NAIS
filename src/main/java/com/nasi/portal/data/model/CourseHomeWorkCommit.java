package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class CourseHomeWorkCommit extends BaseModel implements Serializable {
    private Integer id;

    private Long assignId;

    private String assignName;

    private Long arrangeId;

    private Integer studentId;

    private String studentNameCn;

    private String studentNameEn;

    private Integer commitStatus;

    private Integer commitType;

    private String courseCode;

    private String courseNameCn;

    private String courseNameEn;

    private String workPath;

    private String commitPath;

    private Integer commitTotalScore;

    private Integer commitThisScore;

    private String commitDesc;

    private Date commitTime;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAssignId() {
        return assignId;
    }

    public void setAssignId(Long assignId) {
        this.assignId = assignId;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName == null ? null : assignName.trim();
    }

    public Long getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(Long arrangeId) {
        this.arrangeId = arrangeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNameCn() {
        return studentNameCn;
    }

    public void setStudentNameCn(String studentNameCn) {
        this.studentNameCn = studentNameCn == null ? null : studentNameCn.trim();
    }

    public String getStudentNameEn() {
        return studentNameEn;
    }

    public void setStudentNameEn(String studentNameEn) {
        this.studentNameEn = studentNameEn == null ? null : studentNameEn.trim();
    }

    public Integer getCommitStatus() {
        return commitStatus;
    }

    public void setCommitStatus(Integer commitStatus) {
        this.commitStatus = commitStatus;
    }

    public Integer getCommitType() {
        return commitType;
    }

    public void setCommitType(Integer commitType) {
        this.commitType = commitType;
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

    public String getCommitPath() {
        return commitPath;
    }

    public void setCommitPath(String commitPath) {
        this.commitPath = commitPath == null ? null : commitPath.trim();
    }

    public Integer getCommitTotalScore() {
        return commitTotalScore;
    }

    public void setCommitTotalScore(Integer commitTotalScore) {
        this.commitTotalScore = commitTotalScore;
    }

    public Integer getCommitThisScore() {
        return commitThisScore;
    }

    public void setCommitThisScore(Integer commitThisScore) {
        this.commitThisScore = commitThisScore;
    }

    public String getCommitDesc() {
        return commitDesc;
    }

    public void setCommitDesc(String commitDesc) {
        this.commitDesc = commitDesc == null ? null : commitDesc.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
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