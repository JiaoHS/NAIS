package com.nasi.portal.service;

import com.nasi.portal.data.model.CouponStock;
import com.nasi.portal.data.model.UserCoupon;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;

import java.util.Date;
import java.util.List;

/**
 * Created by yy on 2018-05-04.
 */
public interface CouponStockService {
    public DataGridResult getActivityCouponStockRecordsByPage(Integer page, Integer rows,long id);
    public int pullActivityCouponCode(Long id,Long userId);
    public DataGridResult getMyCouponStockRecordsByPage(Long userId, Integer page, Integer rows);
    public List<UserCoupon> userCouponListFilter(List<UserCoupon> list);
    public boolean timeComparison(Date now,Date begin,Date end);
    public int pullSpreadCouponCode(String couponCode,Long userId);
    public DataGridResult getCouponRecordsFromQuery(String code,Integer type,Integer page, Integer rows);
    public DataGridResult getCouponStockRecordsFitCodeByPage(String code,Integer page, Integer rows);
    public DataGridResult getCouponStockRecordsByPage(Integer page,Integer rows);
    public DataGridResult getCouponStockRecordsFitTypeByPage(Integer type,Integer page, Integer rows);
    public DataGridResult getCouponStockRecordsFitCodeAndTypeByPage(String code,Integer type,Integer page, Integer rows);
    public List<CouponStock> getCouponStockById(Long id);
    public List<UserCoupon> getCouponStockByStockIdAndUserId(Long stockId,Long userId);
    public boolean updateCouponStockRecord(CouponStock couponStock);
    public boolean deleteCouponStockRecord(CouponStock couponStock);
    public String buildCouponCode();
    public boolean insertCouponStockRecord(CouponStock couponStock);
    public boolean judgeEcho(Integer[] list,int position);
    public boolean judgeNumPosition(int iter,Integer[] list);
    public JsonResult getCouponTypes();
    public boolean checkInclude(List<Integer>list,int num);
    public DataGridResult getCouponStockRecords(Integer page, Integer rows);
    public boolean deleteCouponRecord(Long id);
    public boolean checkCouponStock(Long id);
    public boolean bulidExtendCode(Long userId);
    public boolean judgeUserHaveExtendCodeOrNot(Long userId);
    public String getCouponCodeById(Long id);
}
