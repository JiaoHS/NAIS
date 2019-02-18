/**
 * @author anliyong@baidu.com
 * 2015-7-25 下午12:11:58
 */
package com.nasi.portal.web.model;

import java.util.List;

import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.School;

/**
 * @author anliyong@baidu.com
 * 2015-7-25下午12:11:58
 */
public class SchoolVo {

    private School school;
    
    List<Professor> professors;
    
    List<CourseArrange> arranges;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<CourseArrange> getArranges() {
        return arranges;
    }

    public void setArranges(List<CourseArrange> arranges) {
        this.arranges = arranges;
    }
    
}
