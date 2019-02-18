package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.Info;
import com.nasi.portal.data.model.InfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoMapper {


    int countByExample(InfoExample example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExampleWithBLOBs(InfoExample example);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKeyWithBLOBs(Info record);

    int updateByPrimaryKey(Info record);

    List<Info> selectLimit(Integer limit);
}