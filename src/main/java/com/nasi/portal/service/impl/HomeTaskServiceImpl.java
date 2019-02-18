package com.nasi.portal.service.impl;

import com.nasi.portal.common.helper.DateHelper;
import com.nasi.portal.data.mapper.HomeWorkTaskMapper;
import com.nasi.portal.data.mapper.OrderCourseMapper;
import com.nasi.portal.data.mapper.UserHomeWorkMapper;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.HomeTaskService;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.caohao.DTO.HomeWorkTaskFront;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * created by xdCao on 2018/5/21
 */
@Service
public class HomeTaskServiceImpl implements HomeTaskService {

    @Autowired
    private HomeWorkTaskMapper homeWorkTaskMapper;

    @Autowired
    private OrderCourseMapper orderCourseMapper;

    @Autowired
    private MainOrderService mainOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserHomeWorkMapper userHomeWorkMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addNewHomeTask(HomeWorkTask homeWorkTask) {

        homeWorkTaskMapper.insert(homeWorkTask);

    }

    @Override
    public List<User> getStudentListByCampusAndArrange(Long campusId, Long arrangeId) {

        OrderCourseExample example=new OrderCourseExample();
        example.createCriteria().andArrangeIdEqualTo(arrangeId).andCampusIdEqualTo(campusId);
        List<OrderCourse> orderCourses = orderCourseMapper.selectByExample(example);
        List<User> users=new ArrayList<User>();
        for (OrderCourse orderCourse:orderCourses){
            Long orderId = orderCourse.getOrderId();
            MainOrder orderById = mainOrderService.getOrderById(orderId);
            if (orderById!=null) {
                User byPrimaryKey = userService.getByPrimaryKey(orderById.getCreatedUser());
                users.add(byPrimaryKey);
            }
        }

       return users;
    }

    @Override
    public HashMap<String, List<HomeWorkTaskFront>> getDoneDetailWithBaseDate(Long campusId, Long arrangeId, Long userId, Date baseDate) {



        Date begin=DateHelper.yesterday(DateHelper.yesterday(baseDate));

        Date yesterday=DateHelper.yesterday(baseDate);

        Date tomorrow=DateHelper.tomorrow(baseDate);

        Date end=DateHelper.tomorrow(DateHelper.tomorrow(baseDate));

        List<Date> dateList=new ArrayList<Date>();

        dateList.add(begin);
        dateList.add(yesterday);
        dateList.add(baseDate);
        dateList.add(tomorrow);
        dateList.add(end);

        HashMap<String,List<HomeWorkTaskFront>> hashMap=new HashMap<String,List<HomeWorkTaskFront>>();

        //任务类型 1 作业 2 演讲 3 期中考试 4 期末考试
        for (int i = 1; i < 5; i++) {

            List<HomeWorkTask> homeWorkTasks=new ArrayList<HomeWorkTask>();

            for (int j = 0; j < 5; j++) {
                HomeWorkTaskExample example=new HomeWorkTaskExample();

                example.createCriteria()
                        .andCreateTimeGreaterThanOrEqualTo(dateList.get(j)).andCreateTimeLessThan(DateHelper.tomorrow(dateList.get(j)))
                        .andTaskArrangeIdEqualTo(arrangeId)
                        .andTaskTypeEqualTo(i);

                List<HomeWorkTask> homeWorkTasksTemp = homeWorkTaskMapper.selectByExample(example);
                if (homeWorkTasksTemp==null||homeWorkTasksTemp.size()==0){
                    homeWorkTasks.add(null);
                }else {
                    homeWorkTasks.add(homeWorkTasksTemp.get(0));
                }
            }


            //这里查找对应的学生的完成情况

            List<HomeWorkTaskFront> homeWorkTaskFronts=new ArrayList<HomeWorkTaskFront>();

//            for (HomeWorkTask homeWorkTask:homeWorkTasks){
            for (int j = 0; j < homeWorkTasks.size(); j++) {

                HomeWorkTaskFront homeWorkTaskFront=new HomeWorkTaskFront();

                homeWorkTaskFront.setHomeWorkTask(homeWorkTasks.get(j));

                if (homeWorkTasks.get(j)!=null){

                    UserHomeWorkExample userExample=new UserHomeWorkExample();
                    userExample.createCriteria().andCreateUserEqualTo(userId).andTaskIdEqualTo(homeWorkTasks.get(j).getId());
                    List<UserHomeWork> userHomeWorks = userHomeWorkMapper.selectByExample(userExample);
                    if (userHomeWorks==null||userHomeWorks.size()==0){
                        homeWorkTaskFront.setUserHomeWork(null);
                        homeWorkTaskFront.setStatus(0);
                    }else {
                        UserHomeWork userHomeWork = userHomeWorks.get(0);
                        homeWorkTaskFront.setUserHomeWork(userHomeWork);
                        //任务完成状态   1  已完成待评分  2已评分

                        /*
                         * status:
                         * 0:未提交，显示为Unsubmitted
                         * 1:已提交未打分，且没有上传，显示为submitted
                         * 2:已提交未打分，显示为download
                         * 3:已打分，显示分数
                         * */

                        if (userHomeWork.getTaskStatius()==2){
                            homeWorkTaskFront.setStatus(3);
                        }else if (userHomeWork.getTaskStatius()==1){
                            if (userHomeWork.getTaskSubmitUrl()==null||userHomeWork.getTaskSubmitUrl().equals("")){
                                homeWorkTaskFront.setStatus(1);
                            }else {
                                homeWorkTaskFront.setStatus(2);
                            }

                        }
                    }
                }


                homeWorkTaskFronts.add(homeWorkTaskFront);

            }

            hashMap.put(String.valueOf(i),homeWorkTaskFronts);


        }


        return hashMap;
    }

    @Override
    @Transactional
    public boolean updateUserHomeWorkScore(Long id, Integer score) {

        UserHomeWork userHomeWork = userHomeWorkMapper.selectByPrimaryKey(id);

        if (userHomeWork==null) {
            return false;
        }

        userHomeWork.setTaskScore(score);
        userHomeWork.setTaskStatius(2);
        userHomeWorkMapper.updateByPrimaryKeySelective(userHomeWork);

        return true;

    }

    @Override
    public List<HomeWorkTask> getNewsByProfessorId(Long id) {

        HomeWorkTaskExample example=new HomeWorkTaskExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andCreateUserEqualTo(id);

        List<HomeWorkTask> homeWorkTasks = homeWorkTaskMapper.selectByExample(example);

        return homeWorkTasks;

    }


}
