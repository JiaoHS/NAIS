/**
 * @author anliyong@baidu.com
 * 2015-7-28 下午11:06:16
 */
package com.nasi.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.CourseReportMapper;
import com.nasi.portal.data.mapper.custom.CourseReportCustomMapper;
import com.nasi.portal.data.model.CourseReport;
import com.nasi.portal.data.model.CourseReportCriteria;
import com.nasi.portal.service.CourseReportService;

/**
 * @author anliyong@baidu.com
 * 2015-7-28下午11:06:16
 */
@Service
public class CourseReportServiceImpl implements CourseReportService {

    @Resource
    private CourseReportMapper courseReportMapper;
    
    @Resource
    private CourseReportCustomMapper courseReportCustomMapper;

    @Override
    public List<CourseReport> getAllByArrangeId(Integer arrangeId) {
        
        CourseReportCriteria criteria = new CourseReportCriteria();
        criteria.createCriteria().andArrangeIdEqualTo(arrangeId).andIsPaidEqualTo(1);
        return courseReportMapper.selectByExample(criteria);
    }

    @Override
    public int updateScoreByPrimaryKey(Integer id, String score) {
        return courseReportCustomMapper.updateScoreByPrimaryKey(id, score);
    }

    @Override
    public List<CourseReport> getByUserId(Integer userId) {
        CourseReportCriteria criteria = new CourseReportCriteria();
        criteria.createCriteria().andStudentIdEqualTo(userId);
        return courseReportMapper.selectByExample(criteria);
    }

    @Override
    public int insertOrUpdate(CourseReport courseReport) {
        
        if (courseReport.getId() == null) {
            return courseReportMapper.insertSelective(courseReport);
        } else {
            return courseReportMapper.updateByPrimaryKey(courseReport);
        }
        
    }
    
}
