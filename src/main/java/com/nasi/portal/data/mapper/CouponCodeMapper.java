package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CouponCode;
import com.nasi.portal.data.model.CouponCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponCodeMapper {
    int countByExample(CouponCodeCriteria example);

    int deleteByExample(CouponCodeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponCode record);

    int insertSelective(CouponCode record);

    List<CouponCode> selectByExample(CouponCodeCriteria example);

    CouponCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponCode record, @Param("example") CouponCodeCriteria example);

    int updateByExample(@Param("record") CouponCode record, @Param("example") CouponCodeCriteria example);

    int updateByPrimaryKeySelective(CouponCode record);

    int updateByPrimaryKey(CouponCode record);
}