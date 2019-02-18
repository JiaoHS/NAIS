package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.Course;
import com.nasi.portal.data.model.CourseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    int countByExample(CourseCriteria example);

    int deleteByExample(CourseCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseCriteria example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseCriteria example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseCriteria example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}