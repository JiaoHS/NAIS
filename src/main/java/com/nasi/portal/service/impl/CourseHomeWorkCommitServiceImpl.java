package com.nasi.portal.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.CourseHomeWorkCommitMapper;
import com.nasi.portal.data.mapper.custom.CourseHomeWorkCommitCustomMapper;
import com.nasi.portal.data.model.CourseHomeWorkCommit;
import com.nasi.portal.data.model.CourseHomeWorkCommitCriteria;
import com.nasi.portal.service.CourseHomeWorkCommitService;

@Service
public class CourseHomeWorkCommitServiceImpl implements CourseHomeWorkCommitService {
    
    @Resource
    private CourseHomeWorkCommitMapper courseHomeWorkCommitMapper;
    
    @Resource
    private CourseHomeWorkCommitCustomMapper courseHomeWorkCommitCustomMapper;
    
    @Override
    public CourseHomeWorkCommit getByAssignIdAndArrangeId(Long assignId,Long arrangeId){
        
        if (assignId == null || arrangeId == null) {
            return null;
        }
        
        CourseHomeWorkCommitCriteria commitCriteria = new CourseHomeWorkCommitCriteria();
        CourseHomeWorkCommitCriteria.Criteria criteria =  commitCriteria.createCriteria(); 
        criteria.andCommitStatusIn(Arrays.asList(1,3));
        if (assignId != null) {
            criteria.andAssignIdEqualTo(assignId);
        }
        
        if (arrangeId != null) {
            criteria.andArrangeIdEqualTo(arrangeId);
        }
        
        List<CourseHomeWorkCommit> commits = courseHomeWorkCommitMapper.selectByExample(commitCriteria);
        if (CollectionUtils.isNotEmpty(commits) ) {
            return commits.get(0);
        }
        
        return null;
        
    }
    
    @Override
    public CourseHomeWorkCommit getById(Long id){
        
        if (id == null) {
            return null;
        }
        
        return courseHomeWorkCommitMapper.selectByPrimaryKey(id.intValue());
        
    }
    
    @Override
    public Integer disableById(Long commitId){
        
        if (commitId == null) {
            return 0;
        }
        
        CourseHomeWorkCommit commit = new CourseHomeWorkCommit();
        
        if (commitId != null) {
            commit.setId(commitId.intValue());
        }
        
        commit.setCommitStatus(2);
        
        return courseHomeWorkCommitMapper.updateByPrimaryKeySelective(commit);
        
    }
    
    @Override
    public Integer insert(CourseHomeWorkCommit commit){
        
        if (commit == null) {
            return 0;
        }
        
        return courseHomeWorkCommitMapper.insertSelective(commit);
        
    }

    @Override
    public Integer count(Long assignId, String name) {
        return courseHomeWorkCommitCustomMapper.count(assignId, name);
    }

    @Override
    public List<CourseHomeWorkCommit> search(Long assignId, String name, int start, int size) {
        return courseHomeWorkCommitCustomMapper.search(assignId, name, start, size);
    }

    @Override
    public int updateScoreByPrimaryKey(Integer id, Integer score) {
        return courseHomeWorkCommitCustomMapper.updateScoreByPrimaryKey(id, score);
    }
    
}
