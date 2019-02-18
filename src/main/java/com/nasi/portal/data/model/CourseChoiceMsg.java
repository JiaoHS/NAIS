package com.nasi.portal.data.model;

import java.util.Date;

/**
 * @Author: River
 * @Date:Created in  10:24 2018/5/4
 * @Description:
 */
public class CourseChoiceMsg {
    private Long id;

    private Long campusId;

    private Long courseId;

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    private String courseName;

    private String courseCode;

    private String schoolNameCn;

    private String startTime;

    private String endTime;

    private String timeSpan;

    public String getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private Date choiceTime;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSchoolNameCn() {
        return schoolNameCn;
    }

    public void setSchoolNameCn(String schoolNameCn) {
        this.schoolNameCn = schoolNameCn;
    }

    public Date getChoiceTime() {
        return choiceTime;
    }

    public void setChoiceTime(Date choiceTime) {
        this.choiceTime = choiceTime;
    }
}
