package com.nasi.portal.data.model;

import java.util.Date;

public class UserHomeWork {
    private Long id;

    private Long taskCourseId;

    private String taskCourseCode;

    private Long taskId;

    private Integer taskStatius;

    private String taskSubmitUrl;

    private String taskSubmitDesc;

    private Integer taskTotalScore;

    private Integer taskScore;

    private Date submitTime;

    private Date createTime;

    private Long createUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskCourseId() {
        return taskCourseId;
    }

    public void setTaskCourseId(Long taskCourseId) {
        this.taskCourseId = taskCourseId;
    }

    public String getTaskCourseCode() {
        return taskCourseCode;
    }

    public void setTaskCourseCode(String taskCourseCode) {
        this.taskCourseCode = taskCourseCode == null ? null : taskCourseCode.trim();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskStatius() {
        return taskStatius;
    }

    public void setTaskStatius(Integer taskStatius) {
        this.taskStatius = taskStatius;
    }

    public String getTaskSubmitUrl() {
        return taskSubmitUrl;
    }

    public void setTaskSubmitUrl(String taskSubmitUrl) {
        this.taskSubmitUrl = taskSubmitUrl == null ? null : taskSubmitUrl.trim();
    }

    public String getTaskSubmitDesc() {
        return taskSubmitDesc;
    }

    public void setTaskSubmitDesc(String taskSubmitDesc) {
        this.taskSubmitDesc = taskSubmitDesc == null ? null : taskSubmitDesc.trim();
    }

    public Integer getTaskTotalScore() {
        return taskTotalScore;
    }

    public void setTaskTotalScore(Integer taskTotalScore) {
        this.taskTotalScore = taskTotalScore;
    }

    public Integer getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Integer taskScore) {
        this.taskScore = taskScore;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
}