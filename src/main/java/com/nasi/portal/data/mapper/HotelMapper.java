package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.Hotel;

import java.util.List;

import com.nasi.portal.data.model.HotelCriteria;
import org.apache.ibatis.annotations.Param;

public interface HotelMapper {
    int countByExample(HotelCriteria example);

    int deleteByExample(HotelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    List<Hotel> selectByExample(HotelCriteria example);

    Hotel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelCriteria example);

    int updateByExample(@Param("record") Hotel record, @Param("example") HotelCriteria example);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);
}