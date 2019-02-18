package com.nasi.portal.service.impl;

import com.nasi.portal.data.mapper.OrderCourseMapper;
import com.nasi.portal.data.model.OrderCourse;
import com.nasi.portal.service.OrderCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

/**
 * @Author: River
 * @Date:Created in  16:12 2018/5/5
 * @Description:
 */
@Service
public class OrderCourseServiceImpl implements OrderCourseService {
    @Autowired
    private OrderCourseMapper orderCourseMapper;

    @Override
    public void insertCourseOrder(OrderCourse orderCourse) {
        notNull(orderCourse, "user不能为空");
        orderCourseMapper.insert(orderCourse);
    }
}
