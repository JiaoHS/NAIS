package com.nasi.portal.web.controller.caohao;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.nasi.portal.common.Pay.AliPay.*;
import com.nasi.portal.common.helper.JsonHelper;
import com.nasi.portal.data.mapper.MainOrderMapper;
import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.data.model.MainOrderExample;

import com.nasi.portal.service.CouponStockService;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.web.model.JsonResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.monitor.StringMonitor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * created by xdCao on 2018/5/7
 */
@Controller()
@RequestMapping(value = "/pay/aliPay")
public class AliPayController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AliPayController.class);

    @Autowired
    private MainOrderService mainOrderService;

    @Autowired
    private MainOrderMapper mainOrderMapper;

    @Autowired
    private CouponStockService couponStockService;

    @RequestMapping(value = "/doPay")
    @ResponseBody
    public String pay(String paymentSeq) {

        String result = null;
        if (paymentSeq == null || paymentSeq.isEmpty() || paymentSeq.equals(" ")) {

//            return JsonResult.error("订单序列不能为空");
        }
        PagePayInfo payInfo = getPagePayInfo(paymentSeq);
        if (payInfo == null) {
//            return JsonResult.error("无该订单序列");
        }
        AlipayService alipayService = AlipayService.getInstance();
        result = alipayService.pagePay(payInfo);

        LOGGER.info("订单完成支付动作： " + paymentSeq);
        return result;

    }

    @RequestMapping("/return")
    public String syncReturn(Model model, HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }

        boolean signVerified = checkSignature(params);

        String out_trade_no = request.getParameter("out_trade_no");
        String trade_no = request.getParameter("trade_no");
        String total_amount = request.getParameter("total_amount");

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            try {
                out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
                trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
                total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

//            MainOrderExample example = new MainOrderExample();
//            example.createCriteria().andPaymentSeqEqualTo(out_trade_no);
//            List<MainOrder> mainOrderList = mainOrderMapper.selectByExample(example);
//
//            if (mainOrderList == null || mainOrderList.size() == 0) {
//                return "redirect:http://47.95.218.154:8080/user/home#/payment";
//            }
//
//            MainOrder mainOrder = mainOrderList.get(0);
//            Date payTime = new Date();
//            //更新 合并订单 的每个订单的状态
//            if (mainOrder.getRemark() != null ||mainOrder.getRemark().contains("i")) {
//                String[] ids = mainOrder.getRemark().split("i");
//                Long count = (long) ids.length;
//                for (int i = 0; i < count; i++) {
//                    MainOrder mainOrder3 = new MainOrder();
//                    mainOrder3.setId(Long.parseLong(ids[i]));
//                    mainOrder3.setPaymentChannel(Integer.valueOf(PaymentChannel.ALI_PAY.getIndex()));
//                    mainOrder3.setOrderStatus(OrderStatus.PAYSUCESS.getIndex());
//                    mainOrder3.setPaymentTime(payTime);
//                    mainOrder3.setPaymentSuccessTime(payTime);
//                    mainOrder3.setPaymenRemark(JsonHelper.toJsonString(params));
//                    mainOrderMapper.updateByPrimaryKeySelective(mainOrder3);
//                }
//            }
        } else {
            return "redirect:http://www.issneducation.com/user/home#/payment";
        }
        LOGGER.info("out_trade_no:{" + out_trade_no + "}, trade_no:{" + trade_no + "}, total_amount{" + total_amount + "}");
        //model.addAttribute(arg0, arg1)

//        MainOrder order= (MainOrder) request.getSession().getAttribute("orderId");
//
//        response.addCookie(new Cookie("orderId",String.valueOf(order.getId())));
//
//        request.getSession().removeAttribute("orderId");

        return "redirect:http://www.issneducation.com/user/home#/payment";
    }

    @RequestMapping("/notify")
    @Transactional
    public @ResponseBody
    String notify(HttpServletRequest request) {

        LOGGER.info("receive notify request");
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }
        boolean signVerified = false;
        LOGGER.info("notify http params: " + params);
        signVerified = checkSignature(params);

        String out_trade_no = request.getParameter("out_trade_no");
        String trade_no = request.getParameter("trade_no");
        String trade_status = request.getParameter("trade_status");

        if (signVerified) {//验证成功
            try {
                LOGGER.info("notify success, out_trade_no:{}, trade_no:{}, trade_status:{}", out_trade_no, trade_no, trade_status);
                out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
                trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
                trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.info("", e);
            }

            if (trade_status.equals("TRADE_FINISHED")) {
                LOGGER.info("trade finished, paymentSeq {}, alipay_trade_no", out_trade_no, trade_no);
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                MainOrderExample example = new MainOrderExample();
                example.createCriteria().andPaymentSeqEqualTo(out_trade_no);
                List<MainOrder> mainOrderList = mainOrderMapper.selectByExample(example);

                if (mainOrderList == null || mainOrderList.size() == 0) {
                    return "fail";
                }

                MainOrder mainOrder = mainOrderList.get(0);

                Date payTime = new Date();

                mainOrder.setPaymentChannel(Integer.valueOf(PaymentChannel.ALI_PAY.getIndex()));
                mainOrder.setOrderStatus(OrderStatus.PAYSUCESS.getIndex());
                mainOrder.setPaymentTime(payTime);
                mainOrder.setPaymentSuccessTime(payTime);
                mainOrder.setPaymenRemark(JsonHelper.toJsonString(params));
                mainOrderMapper.updateByPrimaryKeySelective(mainOrder);
                //更新 合并订单 的每个订单的状态
                if (mainOrder.getRemark() != null || mainOrder.getRemark().contains("i")) {

                    String[] ids = mainOrder.getRemark().split("i");
                    Long count = (long) ids.length;
                    for (int i = 0; i < count; i++) {
                        MainOrder mainOrder2 = new MainOrder();
                        mainOrder2.setId(Long.parseLong(ids[i]));
                        mainOrder2.setPaymentChannel(Integer.valueOf(PaymentChannel.ALI_PAY.getIndex()));
                        mainOrder2.setOrderStatus(OrderStatus.PAYSUCESS.getIndex());
                        mainOrder2.setPaymentTime(payTime);
                        mainOrder2.setPaymentSuccessTime(payTime);
                        mainOrder2.setPaymenRemark(JsonHelper.toJsonString(params));

                        mainOrderMapper.updateByPrimaryKeySelective(mainOrder2);
                    }
                    LOGGER.info("更新订单状态成功！");
                }

                couponStockService.bulidExtendCode(Long.valueOf(mainOrder.getCreatedUser()));


//                request.getSession().setAttribute("order",mainOrder);

//                mailNoticePaymentOrder(mainOrder, payTime);

            }

            return "success";

        } else {
            LOGGER.info("signVerified failed");
            return "fail";
        }
    }

//    private void mailNoticePaymentOrder(final MainOrder mainOrder, final Date payTime){
//
//        MAIL_SEND_POOL.submit(new Runnable() {
//
//            @Override
//            public void run() {
//
//                try {
//                    UserFullInfo userFullInfo = userInfoService.getUserFullInfoById(mainOrder.getCreateUser().intValue());
//
//                    StringBuffer mailSb = new StringBuffer();
//                    mailSb.append("订单于 ").append(SDF.format(payTime)).append("被支付").append("<br/>")
//                            .append("订单编号：").append(mainOrder.getPaymentSeq()).append("<br/>")
//                            .append("支付金额：").append(PriceService.convert2StringPrice(mainOrder.getCashAmount())).append("<br/>")
//                            .append("用户姓名：").append(userFullInfo.getUsers().getName()).append("(").append(userFullInfo.getUsers().getFirstName()).append("&nbsp;").append(userFullInfo.getUsers().getLastName()).append(")").append("<br/>")
//                            .append("用户邮箱：").append(userFullInfo.getUsers().getEmail()).append("<br/>")
//                            .append("联系方式：").append(userFullInfo.getUserInfo().getPhone()).append("(海外：").append(userFullInfo.getUserInfo().getPhoneAbroad()).append("&nbsp;").append(")").append("<br/>");
//
//
//                    OrderCourseCriteria orderCourseCriteria = new OrderCourseCriteria();
//                    orderCourseCriteria.createCriteria().andOrderIdEqualTo(mainOrder.getId());
//
//                    List<OrderCourse> arrangeList = orderCourseMapper.selectByExample(orderCourseCriteria);
//
//                    List<Integer> courseIdList = new ArrayList<>();
//
//                    mailSb.append("订单所属校区：").append(ecCampusMapper.selectByPrimaryKey(mainOrder.getOrderCampus().intValue()).getTitle()).append("<br/>");
//                    if (CollectionUtils.isNotEmpty(arrangeList)) {
//                        for (OrderCourse orderCourse : arrangeList) {
//                            courseIdList.add(orderCourse.getCourseId().intValue());
//                        }
//
//                        EcCourseCriteria ecCourseCriteria = new EcCourseCriteria();
//                        ecCourseCriteria.createCriteria().andIdIn(courseIdList);
//
//                        List<EcCourse> courseList = ecCourseMapper.selectByExample(ecCourseCriteria);
//
//                        if (CollectionUtils.isNotEmpty(courseList)) {
//
//                            mailSb.append("选课明细：").append("<br/>");
//
//                            for (EcCourse ecCourse : courseList) {
//                                mailSb.append(ecCourse.getCode() + "(" + ecCourse.getTitle() + ")").append("<br/>");
//                            }
//                        }
//
//                    }
//
//
//                    MailUtil.sendHtmlMail("订单支付信息：" + mainOrder.getPaymentSeq() , mailSb.toString());
//                } catch (Exception e) {
//                    LOGGER.error("Mail Send Fail !! OrderInfo :　{}",ToStringBuilder.reflectionToString(mainOrder) ,e);
//                }
//            }
//        });
//
//    }


    private boolean checkSignature(Map<String, String> params) {
        try {
            return AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return false;
        }
    }


    private PagePayInfo getPagePayInfo(String paymentSeq) {
        MainOrderExample example = new MainOrderExample();
        example.createCriteria().andPaymentSeqEqualTo(paymentSeq);
        List<MainOrder> mainOrderList = mainOrderMapper.selectByExample(example);
        if (mainOrderList == null || mainOrderList.size() == 0) {
            return null;
        }
        MainOrder mainOrder = mainOrderList.get(0);
        PagePayInfo pagePayInfo = new PagePayInfo();
        pagePayInfo.setOutTradeNo(mainOrder.getPaymentSeq());
        //现金部分用于支付
        pagePayInfo.setTotalAmount(longToCashString(mainOrder.getCashAmount()));
        pagePayInfo.setSubject(mainOrder.getPaymentSeq());
        // TODO trade description
        pagePayInfo.setBody("");
        return pagePayInfo;
    }

    private static String longToCashString(Long cashLong) {
        return convert2StringPriceNoSymbol(cashLong);
    }


    public static final String convert2StringPriceNoSymbol(Long price) {

        if (price == null) {
            return "0.00";
        }

        BigDecimal pricebd = new BigDecimal(price).divide(new BigDecimal(1000)).setScale(2, BigDecimal.ROUND_HALF_UP);

        return pricebd.toString();
    }


}
