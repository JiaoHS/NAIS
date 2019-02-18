package com.nasi.portal.service;

import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.CourseChoiceMsg;
import com.nasi.portal.data.model.ext.CampusCourseArrange;
import com.nasi.portal.web.controller.caohao.DataGridResult;

import java.util.List;

/**
 * @Author: River
 * @Date:Created in  9:45 2018/4/22
 * @Description:
 */
public interface CourseArrangeNewService {
    DataGridResult getCourseArrangeListByPage(Integer page, Integer rows);

    DataGridResult findCourseArrangeListByCourseCode(String courseCode, Integer page, Integer rows);

    DataGridResult findCourseArrangeListBySchoolName(String schoolNameCn, Integer page, Integer rows);

    DataGridResult findProfessorListPageWithCourseCodeAndSchoolName(String courseCode, String schoolNameCn, Integer page, Integer rows);

    void insertCourseArrange(CourseArrangeNew courseArrange);

    void deleteCourseArrange(Long id);

    List<CampusCourseArrange> campusArrange(Long campusId);

    List<CourseChoiceMsg> getCourseByid(Long[] ids);

    CourseArrangeNew showCourseArrange(Long id);

    void updateCourseArrange(CourseArrangeNew courseArrange);

    List<CourseArrangeNew> getCourseArrangeByProfessorId(Integer professorId, Long campusId);
}
