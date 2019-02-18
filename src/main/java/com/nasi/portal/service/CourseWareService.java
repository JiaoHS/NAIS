package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.CourseWare;

public interface CourseWareService {

    List<CourseWare> getListByArrangeId(Long arrangeId);

    Integer insertWare(CourseWare ware);

    CourseWare getById(Long id);

    Integer disableById(Long id);

}
