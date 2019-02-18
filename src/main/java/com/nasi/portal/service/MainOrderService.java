package com.nasi.portal.service;

import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.web.controller.caohao.DataGridResult;

import java.util.List;

/**
 * @Author: River
 * @Date:Created in  16:44 2018/5/4
 * @Description:
 */
public interface MainOrderService {
    void insertCourseOrder(MainOrder mainOrder);

    List<MainOrder> getOrderListByUserId(Long id);

    List<CourseArrangeNew> getCourseListByOrder(Long id);

    MainOrder getOrderById(Long id);

    int updateOrderSelective(MainOrder mainOrder);

    DataGridResult getOrderListByPage(String paymentSeq, Long campusId, Integer orderSource, Integer orderStatus, Integer page, Integer rows);
}
