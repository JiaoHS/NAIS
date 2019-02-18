package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.common.Pay.AliPay.OrderStatus;
import com.nasi.portal.common.Pay.AliPay.PaymentChannel;
import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * created by xdCao on 2018/5/10
 */
@Controller
@RequestMapping(value = "/pay/bankPay")
public class BankPayController extends BaseController {

    @Autowired
    private MainOrderService mainOrderService;


    @RequestMapping(value = "/receipt/upload")
    @ResponseBody
    public JsonResult<?> imgUpload(@RequestParam("orderId") Long id,@RequestParam("file") MultipartFile file, HttpServletRequest request){

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"receipts";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
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

            MainOrder mainOrder=new MainOrder();
            mainOrder.setId(id);
            mainOrder.setPaymentChannel(3);
            mainOrder.setPaymentTime(new Date());
            mainOrder.setManualPaidRep("/static/receipts"+File.separator+filename);
            mainOrder.setUpdateTime(new Date());
            mainOrder.setOrderStatus(OrderStatus.PAYING.getIndex());

            mainOrderService.updateOrderSelective(mainOrder);

            return JsonResult.success("/static/receipts"+File.separator+filename);
        } else {
            return JsonResult.error("上传失败");
        }

    }




}
