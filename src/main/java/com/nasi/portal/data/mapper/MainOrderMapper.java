package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.data.model.MainOrderExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainOrderMapper {
    int countByExample(MainOrderExample example);

    int deleteByExample(MainOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MainOrder record);

    int insertSelective(MainOrder record);

    List<MainOrder> selectByExample(MainOrderExample example);

    MainOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MainOrder record, @Param("example") MainOrderExample example);

    int updateByExample(@Param("record") MainOrder record, @Param("example") MainOrderExample example);

    int updateByPrimaryKeySelective(MainOrder record);

    int updateByPrimaryKey(MainOrder record);

    void paymentOrderScan(@Param("date")Date date);
}