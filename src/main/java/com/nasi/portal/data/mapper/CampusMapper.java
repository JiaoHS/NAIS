package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.Campus;
import com.nasi.portal.data.model.CampusExample;
import com.nasi.portal.data.model.Campus;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampusMapper {
    int countByExample(CampusExample example);

    int deleteByExample(CampusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Campus record);

    int insertSelective(Campus record);

    List<Campus> selectByExampleWithBLOBs(CampusExample example);

    List<Campus> selectByExample(CampusExample example);

    Campus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByExampleWithBLOBs(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByExample(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKeyWithBLOBs(Campus record);

    int updateByPrimaryKey(Campus record);
}