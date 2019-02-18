package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.OrderCourse;
import com.nasi.portal.data.model.OrderCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCourseMapper {
    int countByExample(OrderCourseExample example);

    int deleteByExample(OrderCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCourse record);

    int insertSelective(OrderCourse record);

    List<OrderCourse> selectByExample(OrderCourseExample example);

    OrderCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCourse record, @Param("example") OrderCourseExample example);

    int updateByExample(@Param("record") OrderCourse record, @Param("example") OrderCourseExample example);

    int updateByPrimaryKeySelective(OrderCourse record);

    int updateByPrimaryKey(OrderCourse record);
}