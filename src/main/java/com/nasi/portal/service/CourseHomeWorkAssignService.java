package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.CourseHomeWorkAssign;

public interface CourseHomeWorkAssignService {

    List<CourseHomeWorkAssign> getAssignListByArrangeList(List<Long> arrangeIds);

    Integer insertAssign(CourseHomeWorkAssign assign);

    CourseHomeWorkAssign getById(Long id);

    Integer disableById(Long id);

}
