package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.CourseHomeWorkCommit;

public interface CourseHomeWorkCommitService {

    CourseHomeWorkCommit getByAssignIdAndArrangeId(Long assignId, Long arrangeId);

    Integer disableById(Long commitId);

    Integer insert(CourseHomeWorkCommit commit);
    
    Integer count(Long assignId, String name);
    
    List<CourseHomeWorkCommit> search(Long assignId, String name, int start, int size);
    
    public int updateScoreByPrimaryKey(Integer id, Integer score);

    CourseHomeWorkCommit getById(Long id);

}
