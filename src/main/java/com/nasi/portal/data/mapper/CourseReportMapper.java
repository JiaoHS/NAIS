package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CourseReport;
import com.nasi.portal.data.model.CourseReportCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseReportMapper {
    int countByExample(CourseReportCriteria example);

    int deleteByExample(CourseReportCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseReport record);

    int insertSelective(CourseReport record);

    List<CourseReport> selectByExample(CourseReportCriteria example);

    CourseReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseReport record, @Param("example") CourseReportCriteria example);

    int updateByExample(@Param("record") CourseReport record, @Param("example") CourseReportCriteria example);

    int updateByPrimaryKeySelective(CourseReport record);

    int updateByPrimaryKey(CourseReport record);
}