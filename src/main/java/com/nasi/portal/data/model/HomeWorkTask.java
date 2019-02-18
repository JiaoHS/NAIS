package com.nasi.portal.data.model;

import java.util.Date;

public class HomeWorkTask {
    private Long id;

    private Long taskCourseId;

    private String taskCourseCode;

    private Long taskArrangeId;

    private Integer taskType;

    private Date taskStartTime;

    private Date taskEndTime;

    private String taskAttachUrl;

    private String taskDesc;

    private Integer taskTotalScore;

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

    public Long getTaskArrangeId() {
        return taskArrangeId;
    }

    public void setTaskArrangeId(Long taskArrangeId) {
        this.taskArrangeId = taskArrangeId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getTaskAttachUrl() {
        return taskAttachUrl;
    }

    public void setTaskAttachUrl(String taskAttachUrl) {
        this.taskAttachUrl = taskAttachUrl == null ? null : taskAttachUrl.trim();
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc == null ? null : taskDesc.trim();
    }

    public Integer getTaskTotalScore() {
        return taskTotalScore;
    }

    public void setTaskTotalScore(Integer taskTotalScore) {
        this.taskTotalScore = taskTotalScore;
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