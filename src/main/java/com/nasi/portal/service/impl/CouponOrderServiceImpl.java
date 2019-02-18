package com.nasi.portal.service.impl;

import com.nasi.portal.data.mapper.MainOrderMapper;
import com.nasi.portal.data.mapper.OrderDiscountMapper;
import com.nasi.portal.data.mapper.UserCouponMapper;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.CouponOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yy on 2018-05-08.
 */
@Service
public class CouponOrderServiceImpl implements CouponOrderService {
    @Resource
    private OrderDiscountMapper orderDiscountMapper;
    /*@Resource
    private CouponStockMapper couponStockMapper;*/
    @Resource
    private UserCouponMapper userCouponMapper;
    @Resource
    private MainOrderMapper mainOrderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserCouponOrderRecord(OrderDiscount record,Long userId){
        orderDiscountMapper.insertSelective(record);
        UserCouponExample userExample=new UserCouponExample();
        userExample.createCriteria().andUserIdEqualTo(userId.longValue()).andStockIdEqualTo(record.getCouponId());
        List<UserCoupon> userCouponList=userCouponMapper.selectByExample(userExample);
        if(userCouponList==null||userCouponList!=null&&userCouponList.size()==0){
            return false;
        }
        /*UserCoupon userRecord=new UserCoupon();

        userRecord.setId(userCouponList.get(0).getId());
        userRecord.setUserId(userId.longValue());
        userRecord.setStockId(userCouponList.get(0).getStockId());
        userRecord.setCouponStatus(2);
        userRecord.setCouponCode(userCouponList.get(0).getCouponCode());
        userRecord.setCouponType(userCouponList.get(0).getCouponType());
        userRecord.setDiscountAmount(userCouponList.get(0).getDiscountAmount());
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());*/
        UserCoupon userRecord=userCouponList.get(0);
        userRecord.setCouponStatus(2);
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());
        userCouponMapper.updateByPrimaryKeySelective(userRecord);
        return true;
    }

    @Override
    public MainOrder getMainOrderFromId(Long id){
        return mainOrderMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMainOrder(MainOrder record){
        MainOrderExample example=new MainOrderExample();
        example.createCriteria().andIdEqualTo(record.getId());
        List<MainOrder>list=mainOrderMapper.selectByExample(example);
        if(list==null||list!=null&&list.size()==0){
            return false;
        }
        mainOrderMapper.updateByPrimaryKeySelective(record);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserCouponAndMainOrderRecord(OrderDiscount orderDiscountRecord, Long userId,MainOrder mainOrderRecord){
        orderDiscountMapper.insertSelective(orderDiscountRecord);
        UserCouponExample userExample=new UserCouponExample();
        userExample.createCriteria().andUserIdEqualTo(userId.longValue()).andStockIdEqualTo(orderDiscountRecord.getCouponId());
        List<UserCoupon> userCouponList=userCouponMapper.selectByExample(userExample);
        if(userCouponList==null||userCouponList!=null&&userCouponList.size()==0){
            return false;
        }
        /*UserCoupon userRecord=new UserCoupon();

        userRecord.setId(userCouponList.get(0).getId());
        userRecord.setUserId(userId.longValue());
        userRecord.setStockId(userCouponList.get(0).getStockId());
        userRecord.setCouponStatus(2);
        userRecord.setCouponCode(userCouponList.get(0).getCouponCode());
        userRecord.setCouponType(userCouponList.get(0).getCouponType());
        userRecord.setDiscountAmount(userCouponList.get(0).getDiscountAmount());
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());*/
        UserCoupon userRecord=userCouponList.get(0);
        userRecord.setCouponStatus(2);
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());
        userCouponMapper.updateByPrimaryKeySelective(userRecord);


        MainOrderExample example=new MainOrderExample();
        example.createCriteria().andIdEqualTo(mainOrderRecord.getId());
        List<MainOrder>list=mainOrderMapper.selectByExample(example);
        if(list==null||list!=null&&list.size()==0){
            return false;
        }
        mainOrderMapper.updateByPrimaryKeySelective(mainOrderRecord);

        return true;
    }
}
