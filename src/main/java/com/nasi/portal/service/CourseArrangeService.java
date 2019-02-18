/**
 * @author anliyong@baidu.com
 * 2015-7-25 上午10:51:21
 */
package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.CourseArrange;

/**
 * @author anliyong@baidu.com
 * 2015-7-25上午10:51:21
 */
public interface CourseArrangeService {
    
    public CourseArrange getByPrimaryKey(Integer id);
    
    public List<CourseArrange> getActiveByProfesserId(Integer id);
    
    public List<Integer> getProfesserIdsBySchool(Integer id);
    
    public List<CourseArrange> getActiveBySchoolId(Integer id);
    
    public int insertOrUpdate(CourseArrange courseArrange);
    
}
