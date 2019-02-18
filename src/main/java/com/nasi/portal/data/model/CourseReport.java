package com.nasi.portal.data.model;

import java.io.Serializable;
import java.util.Date;

public class CourseReport extends BaseModel implements Serializable {
    private Integer id;

    private Integer studentId;

    private String nameCn;

    private String nameEn;

    private String studentAccount;

    private Integer arrangeId;

    private Integer score;

    private String comment;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer isPaid;

    private Integer schoolId;

    private String schoolNameCn;

    private String schoolNameEn;

    private Integer courseId;

    private String courseNameCn;

    private String courseNameEn;

    private Integer professorId;

    private String professorNameCn;

    private String professorNameEn;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount == null ? null : studentAccount.trim();
    }

    public Integer getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(Integer arrangeId) {
        this.arrangeId = arrangeId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
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
}