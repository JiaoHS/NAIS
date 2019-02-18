package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.CourseArrangeNewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseArrangeNewMapper {
    int countByExample(CourseArrangeNewExample example);

    int deleteByExample(CourseArrangeNewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseArrangeNew record);

    int insertSelective(CourseArrangeNew record);

    List<CourseArrangeNew> selectByExample(CourseArrangeNewExample example);

    CourseArrangeNew selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseArrangeNew record, @Param("example") CourseArrangeNewExample example);

    int updateByExample(@Param("record") CourseArrangeNew record, @Param("example") CourseArrangeNewExample example);

    int updateByPrimaryKeySelective(CourseArrangeNew record);

    int updateByPrimaryKey(CourseArrangeNew record);

    List<Map<String,Object>> getCourseByid(Long[] ids);
}