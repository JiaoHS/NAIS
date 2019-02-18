/**
 * @author anliyong@baidu.com
 * 2015-7-28 下午11:06:00
 */
package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.CourseReport;

/**
 * @author anliyong@baidu.com
 * 2015-7-28下午11:06:00
 */
public interface CourseReportService {

    public List<CourseReport> getAllByArrangeId(Integer arrangeId);
    
    public int updateScoreByPrimaryKey(Integer id, String score);
    
    public List<CourseReport> getByUserId(Integer userId);
    
    public int insertOrUpdate(CourseReport courseReport);
    
}
