package com.nasi.portal.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.CourseArrangeMapper;
import com.nasi.portal.data.mapper.custom.CourseArrangeCustomMapper;
import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.CourseArrangeCriteria;
import com.nasi.portal.data.model.dict.ArrangStatus;
import com.nasi.portal.service.CourseArrangeService;

@Service
public class CourseArrangeServiceImpl implements CourseArrangeService {

    @Resource
    private CourseArrangeMapper courseArrangeMapper;
    
    @Resource
    private CourseArrangeCustomMapper courseArrangeCustomMapper;

    @Override
    public CourseArrange getByPrimaryKey(Integer id) {
        notNull(id, "id不能为空");
        return courseArrangeMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<CourseArrange> getActiveByProfesserId(Integer id) {
        
        notNull(id, "id不能为空");
        CourseArrangeCriteria criteria = new CourseArrangeCriteria();
        criteria.createCriteria().andProfessorIdEqualTo(id).andStatusEqualTo(ArrangStatus.ACTIVE.getStatus());
        return courseArrangeMapper.selectByExample(criteria);
    }

    @Override
    public List<Integer> getProfesserIdsBySchool(Integer id) {
        notNull(id, "id不能为空");
        return courseArrangeCustomMapper.getProfessorIdsBySchoolId(id, ArrangStatus.ACTIVE.getStatus());
    }

    @Override
    public List<CourseArrange> getActiveBySchoolId(Integer id) {
        notNull(id, "id不能为空");
        CourseArrangeCriteria criteria = new CourseArrangeCriteria();
        criteria.setOrderByClause(" course_start_time asc ");
        criteria.createCriteria().andSchoolIdEqualTo(id).andStatusEqualTo(ArrangStatus.ACTIVE.getStatus());
        return courseArrangeMapper.selectByExample(criteria);
    }

    @Override
    public int insertOrUpdate(CourseArrange courseArrange) {
        notNull(courseArrange, "courseArrange不能为空");
        if(courseArrange.getId() == null) {
            return courseArrangeMapper.insertSelective(courseArrange);
        } else {
            return courseArrangeMapper.updateByPrimaryKey(courseArrange);
        }
    }
    
}
