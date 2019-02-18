package com.nasi.portal.web.controller.yuyang;

import com.nasi.portal.data.model.*;
import com.nasi.portal.service.CouponOrderService;
import com.nasi.portal.service.CouponStockService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by yy on 2018-05-08.
 */
@Controller
@RequestMapping(value = "/couponOrder")
public class CouponOrderController extends BaseController {
    @Autowired
    private CouponOrderService couponOrderService;

    @Autowired
    private CouponStockService couponStockService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/submit")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult insertCouponOrderRecord(@RequestParam(value = "orderId") Long orderId,
                                              @RequestParam(value = "stockId") Long stockId,
                                              HttpServletRequest request){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());

        if(stockId==null&&orderId!=null){
            MainOrder mainOrder=couponOrderService.getMainOrderFromId(orderId);
            if(mainOrder==null){
                return JsonResult.error("该订单已不存在。");
            }
            mainOrder.setUpdateTime(new Date());
            if(couponOrderService.updateMainOrder(mainOrder)==true){
                return JsonResult.success("提交订单成功");
            }else{
                return JsonResult.error("插入数据失败");
            }
        }else if(stockId!=null&&orderId!=null){
            MainOrder mainOrder=couponOrderService.getMainOrderFromId(orderId);
            if(mainOrder==null){
                return JsonResult.error("该订单已不存在。");
            }

            OrderDiscount record=new OrderDiscount();
            List<UserCoupon>list=couponStockService.getCouponStockByStockIdAndUserId(stockId.longValue(),user.getId().longValue());
            if(list==null||list!=null&&list.size()==0){
                return JsonResult.error("您的这张优惠券已不存在。");
            }

            mainOrder.setCashAmount(mainOrder.getCashAmount()-list.get(0).getDiscountAmount());
            mainOrder.setDiscountAmount(list.get(0).getDiscountAmount());
            mainOrder.setUpdateTime(new Date());

            record.setOrderId(orderId.longValue());
            record.setCouponId(stockId.longValue());
            record.setCouponCode(list.get(0).getCouponCode());
            record.setCouponType(list.get(0).getCouponType());
            record.setDiscountAmount(list.get(0).getDiscountAmount());
            record.setCreateTime(new Date());
            record.setUpdateTime(new Date());
            /*if(couponOrderService.updateUserCouponOrderRecord(record,user.getId().longValue())==true&&couponOrderService.updateMainOrder(mainOrder)==true){
                return JsonResult.success("提交订单成功");
            }else{
                return JsonResult.error("插入数据失败");
            }*/

            if(couponOrderService.updateUserCouponAndMainOrderRecord(record,user.getId().longValue(),mainOrder)==true){
                    //couponOrderService.updateUserCouponOrderRecord(record,user.getId().longValue())==true&&couponOrderService.updateMainOrder(mainOrder)==true){
                return JsonResult.success("提交订单成功");
            }else{
                return JsonResult.error("插入数据失败");
            }

        }
        return JsonResult.error("请至少提供一个订单编号");
    }
}
