package com.nasi.portal.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.CourseHomeWorkAssignMapper;
import com.nasi.portal.data.model.CourseHomeWorkAssign;
import com.nasi.portal.data.model.CourseHomeWorkAssignCriteria;
import com.nasi.portal.service.CourseHomeWorkAssignService;

@Service
public class CourseHomeWorkAssignServiceImpl implements CourseHomeWorkAssignService {
    
    @Resource
    CourseHomeWorkAssignMapper courseHomeWorkAssignMapper;
    
    @Override
    public List<CourseHomeWorkAssign> getAssignListByArrangeList(List<Long> arrangeIds){
        
        if (CollectionUtils.isEmpty(arrangeIds)) {
            return Collections.emptyList();
        }
        
        CourseHomeWorkAssignCriteria assignCriteria = new CourseHomeWorkAssignCriteria();
        assignCriteria.createCriteria().andArrangeIdIn(arrangeIds).andWorkStatusEqualTo(1);
        
        return courseHomeWorkAssignMapper.selectByExample(assignCriteria);
    }
        
    @Override
    public Integer insertAssign(CourseHomeWorkAssign assign){
        
        if (assign == null) {
            return 0;
        }
        
        return courseHomeWorkAssignMapper.insertSelective(assign);
    }
    
    @Override
    public CourseHomeWorkAssign getById(Long id){
        if (id == null) {
            return null;
        }
        return courseHomeWorkAssignMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public Integer disableById(Long id){
        if (id == null) {
            return 0;
        }
        
        CourseHomeWorkAssign assign = new CourseHomeWorkAssign();
        
        assign.setId(id);
        assign.setWorkStatus(2);
        
        return courseHomeWorkAssignMapper.updateByPrimaryKeySelective(assign);
    }
    
    
    
}
