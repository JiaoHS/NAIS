package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CourseWare;
import com.nasi.portal.data.model.CourseWareCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseWareMapper {
    int countByExample(CourseWareCriteria example);

    int deleteByExample(CourseWareCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseWare record);

    int insertSelective(CourseWare record);

    List<CourseWare> selectByExample(CourseWareCriteria example);

    CourseWare selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseWare record, @Param("example") CourseWareCriteria example);

    int updateByExample(@Param("record") CourseWare record, @Param("example") CourseWareCriteria example);

    int updateByPrimaryKeySelective(CourseWare record);

    int updateByPrimaryKey(CourseWare record);
}