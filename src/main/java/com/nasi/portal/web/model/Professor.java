/**
 * @author anliyong@baidu.com
 * 2015-7-25 下午12:03:33
 */
package com.nasi.portal.web.model;

import java.util.List;

import com.nasi.portal.data.model.Course;

/**
 * @author anliyong@baidu.com
 * 2015-7-25下午12:03:33
 */
public class Professor {
    
    private Integer id;
    
    private String school;
    
    private String eschool;
    
    private String name;
    
    private String ename;
    
    private String photo;
    
    private List<Course> courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEschool() {
        return eschool;
    }

    public void setEschool(String eschool) {
        this.eschool = eschool;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
