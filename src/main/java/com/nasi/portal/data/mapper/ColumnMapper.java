package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.Column;
import com.nasi.portal.data.model.ColumnCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColumnMapper {
    int countByExample(ColumnCriteria example);

    int deleteByExample(ColumnCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Column record);

    int insertSelective(Column record);

    List<Column> selectByExample(ColumnCriteria example);

    Column selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Column record, @Param("example") ColumnCriteria example);

    int updateByExample(@Param("record") Column record, @Param("example") ColumnCriteria example);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);
}