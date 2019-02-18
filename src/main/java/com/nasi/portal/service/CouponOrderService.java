package com.nasi.portal.service;

import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.data.model.OrderDiscount;

/**
 * Created by yy on 2018-05-08.
 */
public interface CouponOrderService {
    public boolean updateUserCouponOrderRecord(OrderDiscount record, Long userId);
    public MainOrder getMainOrderFromId(Long id);
    public boolean updateMainOrder(MainOrder record);
    public boolean updateUserCouponAndMainOrderRecord(OrderDiscount orderDiscountRecord, Long userId,MainOrder mainOrderRecord);
}
