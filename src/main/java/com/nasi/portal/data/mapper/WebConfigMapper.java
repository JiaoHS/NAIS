package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.WebConfig;
import com.nasi.portal.data.model.WebConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebConfigMapper {
    int countByExample(WebConfigExample example);

    int deleteByExample(WebConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebConfig record);

    int insertSelective(WebConfig record);

    List<WebConfig> selectByExample(WebConfigExample example);

    WebConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebConfig record, @Param("example") WebConfigExample example);

    int updateByExample(@Param("record") WebConfig record, @Param("example") WebConfigExample example);

    int updateByPrimaryKeySelective(WebConfig record);

    int updateByPrimaryKey(WebConfig record);
}