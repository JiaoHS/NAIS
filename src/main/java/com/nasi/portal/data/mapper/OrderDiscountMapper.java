package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.OrderDiscount;
import com.nasi.portal.data.model.OrderDiscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDiscountMapper {
    int countByExample(OrderDiscountExample example);

    int deleteByExample(OrderDiscountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDiscount record);

    int insertSelective(OrderDiscount record);

    List<OrderDiscount> selectByExample(OrderDiscountExample example);

    OrderDiscount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDiscount record, @Param("example") OrderDiscountExample example);

    int updateByExample(@Param("record") OrderDiscount record, @Param("example") OrderDiscountExample example);

    int updateByPrimaryKeySelective(OrderDiscount record);

    int updateByPrimaryKey(OrderDiscount record);
}