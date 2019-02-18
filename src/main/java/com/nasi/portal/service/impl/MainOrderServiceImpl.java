package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.*;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.web.controller.caohao.DTO.OrderDto;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.font.CreatedFontTracker;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.notNull;


/**
 * created by xdCao on 2018/5/8
 */
@Service
public class MainOrderServiceImpl implements MainOrderService {

    @Autowired
    private MainOrderMapper mainOrderMapper;

    @Autowired
    private OrderCourseMapper orderCourseMapper;

    @Autowired
    private CourseArrangeNewMapper courseArrangeMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public void insertCourseOrder(MainOrder mainOrder) {
        notNull(mainOrder, "user不能为空");
        mainOrderMapper.insert(mainOrder);
    }

    @Override
    public List<MainOrder> getOrderListByUserId(Long id) {

        MainOrderExample example=new MainOrderExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andCreatedUserEqualTo(id);
        List<MainOrder> mainOrders = mainOrderMapper.selectByExample(example);
        if (mainOrders==null||mainOrders.size()==0)
            return null;

        return mainOrders;


    }

    @Override
    public List<CourseArrangeNew> getCourseListByOrder(Long id) {

        List<CourseArrangeNew> courseArrangeNewList=new ArrayList<CourseArrangeNew>();

        MainOrder mainOrder = mainOrderMapper.selectByPrimaryKey(id);
        if (mainOrder==null)
            return null;

        OrderCourseExample example=new OrderCourseExample();
        example.setOrderByClause("course_order");
        example.createCriteria().andOrderIdEqualTo(mainOrder.getId());

        List<OrderCourse> orderCourses = orderCourseMapper.selectByExample(example);

        if (orderCourses==null||orderCourses.size()==0)
            return null;

        for (OrderCourse orderCourse:orderCourses){
            CourseArrangeNew courseArrange = courseArrangeMapper.selectByPrimaryKey(orderCourse.getArrangeId());
            courseArrangeNewList.add(courseArrange);
        }

        return courseArrangeNewList;

    }

    @Override
    public MainOrder getOrderById(Long id) {

        MainOrder mainOrder = mainOrderMapper.selectByPrimaryKey(id);
        return mainOrder;
    }

    @Override
    @Transactional
    public int updateOrderSelective(MainOrder mainOrder) {

        int i = mainOrderMapper.updateByPrimaryKeySelective(mainOrder);
        return i;

    }

    @Override
    public DataGridResult getOrderListByPage(String paymentSeq, Long campusId, Integer orderSource, Integer orderStatus, Integer page, Integer rows) {


        List<OrderDto> orderDtos=new ArrayList<OrderDto>();
        PageHelper.startPage(page,rows);
        MainOrderExample example=new MainOrderExample();
        example.setOrderByClause("create_time desc");
        MainOrderExample.Criteria criteria = example.createCriteria();
        if (paymentSeq!=null&&(!paymentSeq.equals(""))){
            criteria.andPaymentSeqEqualTo(paymentSeq);
        }
        if (campusId!=null){
            criteria.andCampusIdEqualTo(campusId);
        }
        if (orderSource!=null){
            criteria.andOrderSourceEqualTo(orderSource);
        }
        if (orderStatus!=null){
            criteria.andOrderStatusEqualTo(orderStatus);
        }
        List<MainOrder> mainOrders = mainOrderMapper.selectByExample(example);
        for (MainOrder mainOrder:mainOrders){
            if(mainOrder.getRemark()!=null){
                continue;
            }
            OrderDto orderDto=new OrderDto();
            User user = userMapper.selectByPrimaryKey(mainOrder.getCreatedUser());
            orderDto.setId(mainOrder.getId());
            orderDto.setCampusId(mainOrder.getCampusId());
            orderDto.setCreatedUser(user.getEmail());
            orderDto.setOrderSource(mainOrder.getOrderSource());
            orderDto.setOrderStatus(mainOrder.getOrderStatus());
            orderDto.setPaymentChannel(mainOrder.getPaymentChannel());
            orderDto.setPaymentSeq(mainOrder.getPaymentSeq());
            orderDtos.add(orderDto);
        }

        PageInfo<MainOrder> pageInfo=new PageInfo<MainOrder>(mainOrders);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(orderDtos);

        return dataGridResult;

    }


}
