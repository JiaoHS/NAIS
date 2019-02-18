package com.nasi.portal.data.model;

import java.util.Date;

public class CourseArrangeNew {
    private Long id;

    private Long campusId;

    private String schoolNameCn;

    private String schoolNameEn;

    private Integer courseId;

    private String courseName;

    private String courseCode;

    private Integer professorId;

    private String professorNameCn;

    private String professorNameEn;

    private String professorFromSchoolCn;

    private String professorFromSchoolEn;

    private Date startTime;

    private Date endTime;

    private String courseAttach;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer status;

    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public String getProfessorNameCn() {
        return professorNameCn;
    }

    public void setProfessorNameCn(String professorNameCn) {
        this.professorNameCn = professorNameCn == null ? null : professorNameCn.trim();
    }

    public String getProfessorNameEn() {
        return professorNameEn;
    }

    public void setProfessorNameEn(String professorNameEn) {
        this.professorNameEn = professorNameEn == null ? null : professorNameEn.trim();
    }

    public String getProfessorFromSchoolCn() {
        return professorFromSchoolCn;
    }

    public void setProfessorFromSchoolCn(String professorFromSchoolCn) {
        this.professorFromSchoolCn = professorFromSchoolCn == null ? null : professorFromSchoolCn.trim();
    }

    public String getProfessorFromSchoolEn() {
        return professorFromSchoolEn;
    }

    public void setProfessorFromSchoolEn(String professorFromSchoolEn) {
        this.professorFromSchoolEn = professorFromSchoolEn == null ? null : professorFromSchoolEn.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCourseAttach() {
        return courseAttach;
    }

    public void setCourseAttach(String courseAttach) {
        this.courseAttach = courseAttach == null ? null : courseAttach.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}