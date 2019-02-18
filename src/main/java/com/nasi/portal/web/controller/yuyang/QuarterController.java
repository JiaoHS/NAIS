package com.nasi.portal.web.controller.yuyang;

import com.nasi.portal.common.Pay.AliPay.OrderStatus;
import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.service.QuarterService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by yy on 2018-05-19.
 */
@Controller
@RequestMapping(value = "/quarter")
public class QuarterController extends BaseController {
    @Autowired
    private MainOrderService mainOrderService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuarterService quarterService;

    @RequestMapping(value = "/submit")
    @ResponseBody
    public JsonResult submitQuarter(@RequestParam(value = "campusId", required = false) Long campusId,
                                    @RequestParam(value = "remark", required = false) String remark,
                                    @RequestParam(value = "money", required = false) Long money,
                                    HttpServletRequest request) {
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());

        List<MainOrder> list = mainOrderService.getOrderListByUserId(Long.valueOf(user.getId()));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                MainOrder orderInfo = list.get(i);
                //已经有住宿订单的情况 就abandon
                if (orderInfo.getOrderSource() == 200) {
                    orderInfo.setOrderStatus(OrderStatus.CANCLE.getIndex());
                    mainOrderService.updateOrderSelective(orderInfo);
                }
            }
        }
        MainOrder mainOrder = new MainOrder();

        if (campusId != null) {
            String paymentSeq = "SSXK" + user.getId() + System.currentTimeMillis();

            //MainOrder mainOrder=new MainOrder();
            mainOrder.setPaymentSeq(paymentSeq);
            mainOrder.setCreatedUser(user.getId());
            mainOrder.setOrderVersion(1);
            mainOrder.setOrderStatus(1);
            mainOrder.setOrderSource(200);
            mainOrder.setTotalAmount(money);
            mainOrder.setCashAmount(money);
            mainOrder.setDiscountAmount((long) 0);
            mainOrder.setCampusId(campusId);
            mainOrder.setCreateTime(new Date());
            mainOrder.setUpdateTime(new Date());
            mainOrder.setManualPaidRep(remark);
        } else {
            String paymentSeq = "SSXK" + user.getId() + System.currentTimeMillis();

            //MainOrder mainOrder=new MainOrder();
            mainOrder.setPaymentSeq(paymentSeq);
            mainOrder.setCreatedUser(user.getId());
            mainOrder.setOrderVersion(1);
            mainOrder.setOrderStatus(1);
            mainOrder.setOrderSource(200);
            mainOrder.setTotalAmount(money);
            mainOrder.setCashAmount(money);
            mainOrder.setDiscountAmount((long) 0);
            //mainOrder.setCampusId(campusId);
            mainOrder.setCreateTime(new Date());
            mainOrder.setUpdateTime(new Date());
            mainOrder.setManualPaidRep(remark);
        }
        quarterService.submitQuarter(mainOrder);

        return JsonResult.success(mainOrder);
    }
}
