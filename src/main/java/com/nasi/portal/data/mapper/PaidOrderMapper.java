package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.PaidOrder;
import com.nasi.portal.data.model.PaidOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaidOrderMapper {
    int countByExample(PaidOrderCriteria example);

    int deleteByExample(PaidOrderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PaidOrder record);

    int insertSelective(PaidOrder record);

    List<PaidOrder> selectByExample(PaidOrderCriteria example);

    PaidOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaidOrder record, @Param("example") PaidOrderCriteria example);

    int updateByExample(@Param("record") PaidOrder record, @Param("example") PaidOrderCriteria example);

    int updateByPrimaryKeySelective(PaidOrder record);

    int updateByPrimaryKey(PaidOrder record);
}