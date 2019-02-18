package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.common.Pay.AliPay.OrderStatus;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.CouponStockService;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.service.OrderCourseService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.controller.caohao.DTO.OrderDto;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * created by xdCao on 2018/5/8
 */
@Controller
@RequestMapping(value = "/order")
public class MainOrderController extends BaseController {

    @Autowired
    private MainOrderService mainOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CouponStockService couponStockService;

    @RequestMapping(value = "/single")//ok
    @ResponseBody
    public JsonResult<?> getSingleOrder(@RequestParam("id") Long id) {
        MainOrder orderById = mainOrderService.getOrderById(id);
        if (orderById != null) {
            return JsonResult.success(orderById);
        } else {
            return JsonResult.error("");
        }
    }


    @RequestMapping(value = "/list/my")//ok
    @ResponseBody
    public JsonResult<?> myOrderList(HttpServletRequest request) {

        User user = getCurrentLoginUser(request);
        if (user == null) {
            return JsonResult.error("用户未登录");
        }

//        userService.getByPrimaryKey(id);

        List<MainOrder> list = mainOrderService.getOrderListByUserId(Long.valueOf(user.getId()));

        if (list == null)
            return JsonResult.error("无该用户订单记录");


        return JsonResult.success(list);

    }

    @RequestMapping(value = "/courseList")//ok
    @ResponseBody
    public JsonResult<?> getCourseListByOrder(@RequestParam("orderId") Long id) {

        List<CourseArrangeNew> courseList = mainOrderService.getCourseListByOrder(id);
        if (courseList == null || courseList.size() == 0) {
            return JsonResult.error("无课程内容");
        }

        return JsonResult.success(courseList);

    }


    @RequestMapping(value = "/toPayList")//ok
    @ResponseBody
    public JsonResult<?> getOrderToPay(@RequestParam("orderId") Long id) {

        MainOrder orderById = mainOrderService.getOrderById(id);
        if (orderById == null)
            return JsonResult.error("找不到该订单");

        return JsonResult.success(orderById);

    }

    /*---------------------------------------------------------后台管理部分----------------------------------------------------------------------------*/


    @RequestMapping(value = "/find")//ok
    @ResponseBody
    public DataGridResult findOrdersByPage(@RequestParam(value = "paymentSeq", required = false) String paymentSeq,
                                           @RequestParam(value = "campusId", required = false) Long campusId,
                                           @RequestParam(value = "orderSource", required = false) Integer orderSource,
                                           @RequestParam(value = "orderStatus", required = false) Integer orderStatus,
                                           @RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "rows") Integer rows) {

        DataGridResult dataGridResult = null;

        dataGridResult = mainOrderService.getOrderListByPage(paymentSeq, campusId, orderSource, orderStatus, page, rows);

        return dataGridResult;

    }


    @RequestMapping(value = "/admin/receipt/upload")//ok
    @ResponseBody
    @Transactional
    public JsonResult<?> imgUpload(@RequestParam("orderId") Long id, @RequestParam("file") MultipartFile file, HttpServletRequest request) {

        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static") + File.separator + "receipts";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
                return JsonResult.error("上传文件失败");
            }

            MainOrder mainOrder = new MainOrder();
            mainOrder.setId(id);
            mainOrder.setReceipt("/static/receipts" + File.separator + filename);
            mainOrder.setUpdateTime(new Date());
            mainOrderService.updateOrderSelective(mainOrder);

            return JsonResult.success("/static/receipts" + File.separator + filename);
        } else {
            return JsonResult.error("上传失败");
        }

    }


    @RequestMapping(value = "/abandon")//ok
    @ResponseBody
    @Transactional
    public JsonResult<?> abandonOrder(@RequestParam("ids") String ids) {

        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                MainOrder mainOrder = new MainOrder();
                mainOrder.setId(id);
                mainOrder.setOrderStatus(OrderStatus.CANCLE.getIndex());
                mainOrderService.updateOrderSelective(mainOrder);
            }
            return JsonResult.success(null, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("操作失败");
        }

    }


    @RequestMapping(value = "/verify")
    @ResponseBody
    @Transactional
    public JsonResult<?> verifyOrder(@RequestParam("orderId") Long id, @RequestParam(value = "AcrossId", required = false) Long AcrossId) {

        MainOrder orderById = mainOrderService.getOrderById(id);
        if (orderById == null)
            return JsonResult.error("没有该订单");
        MainOrder order = new MainOrder();
        order.setId(orderById.getId());
        order.setPaymentSuccessTime(new Date());
        order.setUpdateTime(new Date());
        if (AcrossId == 1) {
            order.setOrderStatus(OrderStatus.PAYSUCESS.getIndex());
        }
        if (AcrossId == 0) {
            order.setOrderStatus(OrderStatus.CANCLE.getIndex());
        }
        mainOrderService.updateOrderSelective(order);
        boolean bool = couponStockService.bulidExtendCode(Long.valueOf(orderById.getCreatedUser()));
        return JsonResult.success(order, "操作成功");
//        if (bool) {
//            return JsonResult.success(order, "操作成功");
//        } else {
//            return JsonResult.error("未能生成推广码");
//        }
    }


}
