package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class CourseArrange extends BaseModel implements Serializable {
    private Integer id;

    private Integer schoolId;

    private String schoolNameCn;

    private String schoolNameEn;

    private Integer courseId;

    private String courseNameCn;

    private String courseNameEn;

    private String courseCode;

    private Integer professorId;

    private String professorNameCn;

    private String professorNameEn;

    private String professorFromSchoolCn;

    private String professorFromSchoolEn;

    private Date courseStartTime;

    private Date courseEndTime;

    private String attachPath;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer status;

    private Long price;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
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

    public Date getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public Date getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath == null ? null : attachPath.trim();
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