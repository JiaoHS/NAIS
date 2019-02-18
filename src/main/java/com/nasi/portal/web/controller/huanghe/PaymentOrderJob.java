package com.nasi.portal.web.controller.huanghe;


import com.nasi.portal.data.mapper.MainOrderMapper;
import org.joda.time.DateTime;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author: River
 * @Date:Created in  9:11 2018/5/11
 * @Description: 扫描超过24小时未付款的顶订单，订单作废order_status改变为-1
 */
public class PaymentOrderJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ApplicationContext applicationContext = (ApplicationContext) jobExecutionContext.getJobDetail().getJobDataMap().get("applicationContext");
        //超过24小时没有完成的，订单作废order_status改变为-1
        applicationContext.getBean(MainOrderMapper.class).paymentOrderScan(new DateTime().minusHours(24).toDate());
//        //测试向前推5分钟
//        System.out.println("-------------准备执行任务--------------");
//        applicationContext.getBean(MainOrderMapper.class).paymentOrderScan(new DateTime().minusMinutes(5).toDate());
//        System.out.println("---------------执行完任务---------------");
    }
}
