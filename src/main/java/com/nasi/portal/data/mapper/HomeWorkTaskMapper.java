package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.HomeWorkTask;
import com.nasi.portal.data.model.HomeWorkTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeWorkTaskMapper {
    int countByExample(HomeWorkTaskExample example);

    int deleteByExample(HomeWorkTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeWorkTask record);

    int insertSelective(HomeWorkTask record);

    List<HomeWorkTask> selectByExample(HomeWorkTaskExample example);

    HomeWorkTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeWorkTask record, @Param("example") HomeWorkTaskExample example);

    int updateByExample(@Param("record") HomeWorkTask record, @Param("example") HomeWorkTaskExample example);

    int updateByPrimaryKeySelective(HomeWorkTask record);

    int updateByPrimaryKey(HomeWorkTask record);
}