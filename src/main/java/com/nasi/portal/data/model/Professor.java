package com.nasi.portal.data.model;

import java.util.Date;

public class Professor {
    private Long id;

    private String professorName;

    private String fromSchool;

    private String description;

    private String photo;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName == null ? null : professorName.trim();
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool == null ? null : fromSchool.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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