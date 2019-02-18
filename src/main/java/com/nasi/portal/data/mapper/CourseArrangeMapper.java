package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.CourseArrangeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseArrangeMapper {
    int countByExample(CourseArrangeCriteria example);

    int deleteByExample(CourseArrangeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseArrange record);

    int insertSelective(CourseArrange record);

    List<CourseArrange> selectByExample(CourseArrangeCriteria example);

    CourseArrange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseArrange record, @Param("example") CourseArrangeCriteria example);

    int updateByExample(@Param("record") CourseArrange record, @Param("example") CourseArrangeCriteria example);

    int updateByPrimaryKeySelective(CourseArrange record);

    int updateByPrimaryKey(CourseArrange record);
}