package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CouponStock;
import com.nasi.portal.data.model.CouponStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponStockMapper {
    int countByExample(CouponStockExample example);

    int deleteByExample(CouponStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponStock record);

    int insertSelective(CouponStock record);

    List<CouponStock> selectByExample(CouponStockExample example);

    CouponStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponStock record, @Param("example") CouponStockExample example);

    int updateByExample(@Param("record") CouponStock record, @Param("example") CouponStockExample example);

    int updateByPrimaryKeySelective(CouponStock record);

    int updateByPrimaryKey(CouponStock record);
}