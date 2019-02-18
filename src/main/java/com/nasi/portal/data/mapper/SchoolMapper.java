package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.School;
import com.nasi.portal.data.model.SchoolCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    int countByExample(SchoolCriteria example);

    int deleteByExample(SchoolCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    List<School> selectByExample(SchoolCriteria example);

    School selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolCriteria example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolCriteria example);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}