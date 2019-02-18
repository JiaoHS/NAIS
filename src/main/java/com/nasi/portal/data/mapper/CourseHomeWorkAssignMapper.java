package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CourseHomeWorkAssign;
import com.nasi.portal.data.model.CourseHomeWorkAssignCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseHomeWorkAssignMapper {
    int countByExample(CourseHomeWorkAssignCriteria example);

    int deleteByExample(CourseHomeWorkAssignCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseHomeWorkAssign record);

    int insertSelective(CourseHomeWorkAssign record);

    List<CourseHomeWorkAssign> selectByExample(CourseHomeWorkAssignCriteria example);

    CourseHomeWorkAssign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseHomeWorkAssign record, @Param("example") CourseHomeWorkAssignCriteria example);

    int updateByExample(@Param("record") CourseHomeWorkAssign record, @Param("example") CourseHomeWorkAssignCriteria example);

    int updateByPrimaryKeySelective(CourseHomeWorkAssign record);

    int updateByPrimaryKey(CourseHomeWorkAssign record);
}