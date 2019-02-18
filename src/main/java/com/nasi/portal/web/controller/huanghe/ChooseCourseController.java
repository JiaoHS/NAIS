package com.nasi.portal.web.controller.huanghe;

import com.nasi.portal.common.Pay.AliPay.OrderStatus;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.CourseArrangeNewService;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.service.OrderCourseService;
import com.nasi.portal.service.PriceRuleService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author: River
 * @Date:Created in  22:18 2018/5/3
 * @Description: 课程选择
 */
@Controller
@RequestMapping("/chooseCourse")
public class ChooseCourseController extends BaseController {

    @Autowired
    private CourseArrangeNewService courseArrangeNewService;

    @Autowired
    private PriceRuleService priceRuleService;

    @Autowired
    private MainOrderService mainOrderService;

    @Autowired
    private OrderCourseService orderCourseService;

    /**
     * @param ids:课程安排ID
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonResult<?> listChooseCourse(@RequestParam(value = "id", required = false) Long[] ids) {

        List<CourseChoiceMsg> courseArrangeNews = courseArrangeNewService.getCourseByid(ids);

        List<String> timeSpanList = new ArrayList<String>();

        for (CourseChoiceMsg course : courseArrangeNews) {
            String timeSpan = course.getTimeSpan();
            if (!timeSpanList.contains(timeSpan)) {
                timeSpanList.add(timeSpan);
            } else {
                return JsonResult.error("选择课程时间段有冲突");
            }
        }
        return JsonResult.success(courseArrangeNews);
    }

    /**
     * 提交课程，订单生成，未使用优惠前
     */
    @RequestMapping("/submit")
    @ResponseBody
    public JsonResult<?> submitChooseCourse(@RequestParam(value = "orderIds", required = false) String orderIds, @RequestParam(value = "id", required = false) String id,
                                            @RequestParam("campusId") Long campusId,
                                            @RequestParam("orderId") Long orderIdd,
                                            HttpServletRequest request) {
        if (orderIdd != null && orderIdd > 0) {
            MainOrder mainOrder = new MainOrder();
            mainOrder.setId(orderIdd);
            mainOrder.setOrderStatus(OrderStatus.CANCLE.getIndex());
            mainOrderService.updateOrderSelective(mainOrder);
        }

        String[] ids = id.split("i");
        //根据校区id和选课的数目,时间和规则状态;查询出总共的费用
        //long count = (long) 1;
        Long count = (long) ids.length;
        PriceRule priceRule = priceRuleService.findTotalAmountByCampusIdAndCount(count, campusId, new Date());
        Long moneyAmount = priceRule.getRuleMoneyAmount();

        //生成订单编号
        User user = getCurrentLoginUser(request);
        String paymentSeq = "SSXK" + user.getId() + System.currentTimeMillis();

        MainOrder mainOrder = new MainOrder();
        mainOrder.setPaymentSeq(paymentSeq);
        mainOrder.setCreatedUser(user.getId());
        mainOrder.setOrderVersion(1);
        if (orderIds != "" && orderIds != null) {
            mainOrder.setRemark(orderIds);
        }


        mainOrder.setOrderStatus(1);
        mainOrder.setOrderSource(100);
        mainOrder.setTotalAmount(moneyAmount);
        mainOrder.setCashAmount(moneyAmount);
        mainOrder.setDiscountAmount((long) 0);
        mainOrder.setCampusId(campusId);
        mainOrder.setCreateTime(new Date());
        mainOrder.setUpdateTime(new Date());

        //向main_order表中插入一条订单数据
        mainOrderService.insertCourseOrder(mainOrder);

        //得到自增主键order_id
        Long orderId = mainOrder.getId();

        //向order_course表中插入数据,选课的顺序就是数组中id的存放顺序
        for (int i = 0; i < count; i++) {
            OrderCourse orderCourse = new OrderCourse();
            orderCourse.setOrderId(orderId);
            orderCourse.setCampusId(campusId);
            orderCourse.setCourseOrder(i + 1);
            orderCourse.setArrangeId(Long.parseLong(ids[i]));
            orderCourse.setCreateTime(new Date());
            orderCourse.setUpdateTime(new Date());
            //向订单选课表order_course插入一条数据
            orderCourseService.insertCourseOrder(orderCourse);
        }

        return JsonResult.success(mainOrder);
    }

    /**
     * 更改订单的状态
     */
    @RequestMapping("/ChangeOrderStatus")
    @ResponseBody
    public JsonResult<?> ChangeOrderStatus(@RequestParam("orderId") Long orderIdd,
                                           HttpServletRequest request) {
        MainOrder mainOrder = new MainOrder();
        if (orderIdd != null && orderIdd > 0) {

            mainOrder.setId(orderIdd);
            mainOrder.setOrderStatus(OrderStatus.PAYSUCESS.getIndex());
            mainOrderService.updateOrderSelective(mainOrder);
        } else {

        }
        return JsonResult.success(mainOrder);
    }

    /**
     * 更改订单的状态
     */
    @RequestMapping("/ChangeOrderRemark")
    @ResponseBody
    public JsonResult<?> ChangeOrderStatus(@RequestParam("orderId") Long orderIdd, @RequestParam("remark") String remark,
                                           HttpServletRequest request) {
        MainOrder mainOrder = mainOrderService.getOrderById(orderIdd);
        if (mainOrder != null && mainOrder.getId() > 0) {
            //更新 合并订单 的每个订单的状态为审核中
            if (mainOrder.getRemark() != null && mainOrder.getRemark().contains("i")) {

                String[] ids = mainOrder.getRemark().split("i");
                Long count = (long) ids.length;
                for (int i = 0; i < count; i++) {
                    MainOrder mainOrder2 = new MainOrder();
                    mainOrder2.setId(Long.parseLong(ids[i]));
                    mainOrder2.setOrderStatus(OrderStatus.EXAMINE.getIndex());
                    mainOrder2.setPaymenRemark(remark);
                    mainOrder2.setPaymentChannel(3);
                    mainOrderService.updateOrderSelective(mainOrder2);
                }
            }
        }
        if (remark != null && remark != "") {

            mainOrder.setId(orderIdd);
            mainOrder.setPaymenRemark(remark);
            mainOrder.setOrderStatus(OrderStatus.EXAMINE.getIndex());
            mainOrder.setPaymentChannel(3);
            mainOrderService.updateOrderSelective(mainOrder);
        }
        return JsonResult.success(mainOrder);
    }
}
