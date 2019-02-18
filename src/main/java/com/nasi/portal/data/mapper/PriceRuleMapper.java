package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.PriceRule;
import com.nasi.portal.data.model.PriceRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceRuleMapper {
    int countByExample(PriceRuleExample example);

    int deleteByExample(PriceRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PriceRule record);

    int insertSelective(PriceRule record);

    List<PriceRule> selectByExample(PriceRuleExample example);

    PriceRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PriceRule record, @Param("example") PriceRuleExample example);

    int updateByExample(@Param("record") PriceRule record, @Param("example") PriceRuleExample example);

    int updateByPrimaryKeySelective(PriceRule record);

    int updateByPrimaryKey(PriceRule record);
}