package com.nasi.portal.data.model;

import java.util.Date;

public class Info {
    private Long id;

    private String title;

    private String titleImg;

    private String descInfo;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg == null ? null : titleImg.trim();
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo == null ? null : descInfo.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}