package com.nasi.portal.data.model;

import java.util.List;

/**
 * @Author: River
 * @Date:Created in  10:32 2018/4/20
 * @Description:
 */
public class ProfessorMsg {
    private Long id;
    private String professorName;
    private String fromSchool;
    private String description;
    private String photo;
    private List<String> schoolNameList;
    private List<String> courseNameList;

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
        this.professorName = professorName;
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getSchoolNameList() {
        return schoolNameList;
    }

    public void setSchoolNameList(List<String> schoolNameList) {
        this.schoolNameList = schoolNameList;
    }

    public List<String> getCourseNameList() {
        return courseNameList;
    }

    public void setCourseNameList(List<String> courseNameList) {
        this.courseNameList = courseNameList;
    }
}
