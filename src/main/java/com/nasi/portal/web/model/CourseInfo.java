/**
 * @author anliyong@baidu.com
 * 2015-8-24 下午10:33:11
 */
package com.nasi.portal.web.model;

import java.util.Date;

/**
 * @author anliyong@baidu.com
 * 2015-8-24下午10:33:11
 */
public class CourseInfo {
    
    private Integer id;

    private Date courseStartTime;

    private Date courseEndTime;
    
    private String courseNameCn;

    private String courseNameEn;

    private String courseCode;
    
    private String professorNameCn;

    private String professorNameEn;

    private String professorFromSchoolCn;

    private String professorFromSchoolEn;
    
    private Integer selectEnable = 0;
    
    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCourseNameCn() {
        return courseNameCn;
    }

    public void setCourseNameCn(String courseNameCn) {
        this.courseNameCn = courseNameCn;
    }

    public String getCourseNameEn() {
        return courseNameEn;
    }

    public void setCourseNameEn(String courseNameEn) {
        this.courseNameEn = courseNameEn;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getProfessorNameCn() {
        return professorNameCn;
    }

    public void setProfessorNameCn(String professorNameCn) {
        this.professorNameCn = professorNameCn;
    }

    public String getProfessorNameEn() {
        return professorNameEn;
    }

    public void setProfessorNameEn(String professorNameEn) {
        this.professorNameEn = professorNameEn;
    }

    public String getProfessorFromSchoolCn() {
        return professorFromSchoolCn;
    }

    public void setProfessorFromSchoolCn(String professorFromSchoolCn) {
        this.professorFromSchoolCn = professorFromSchoolCn;
    }

    public String getProfessorFromSchoolEn() {
        return professorFromSchoolEn;
    }

    public void setProfessorFromSchoolEn(String professorFromSchoolEn) {
        this.professorFromSchoolEn = professorFromSchoolEn;
    }

    public Integer getSelectEnable() {
        return selectEnable;
    }

    public void setSelectEnable(Integer selectEnable) {
        this.selectEnable = selectEnable;
    }

    public String getScore() {
        return score;
    }

    public void setScore(Integer score) {
        if (score < 0) {
            this.score = "未打分";
        } else if (score < 40) {
            this.score = "D";
        } else if (score < 60) {
            this.score = "C";
        } else if (score < 80) {
            this.score = "B";
        } else {
            this.score = "A";
        }
    }
    
}
