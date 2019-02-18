package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.common.helper.DateHelper;
import com.nasi.portal.data.mapper.*;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.HomeWorkService;
import com.nasi.portal.service.MainOrderService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.caohao.DTO.HomeWorkTaskFront;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.StuInfo;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yy on 2018-05-25.
 */
@Service
public class HomeWorkServiceImpl implements HomeWorkService {
    @Autowired
    private HomeWorkTaskMapper homeWorkTaskMapper;

    @Autowired
    private CampusMapper campusMapper;

    @Autowired
    private OrderCourseMapper orderCourseMapper;

    @Autowired
    private MainOrderMapper mainOrderMapper;

    @Autowired
    private CourseArrangeNewMapper courseArrangeNewMapper;

    @Autowired
    private MainOrderService mainOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserHomeWorkMapper userHomeWorkMapper;

    @Override
    public DataGridResult showMyCourses(Long userId, Long campusId, Integer page, Integer rows){

        PageHelper.startPage(page,rows);
        //first main_order
        MainOrderExample example=new MainOrderExample();
        example.createCriteria().andCreatedUserEqualTo(userId).andOrderStatusEqualTo(3).andCampusIdEqualTo(campusId);
        List<MainOrder> mainOrderList=mainOrderMapper.selectByExample(example);
        if(mainOrderList==null||mainOrderList!=null&&mainOrderList.size()==0){
            return null;
        }
        //get main_order for user
        List<OrderCourse>orderCourseList=new ArrayList<OrderCourse>();


        /*System.out.println("mainorder size:"+mainOrderList.size());

        for(int i=0;i<mainOrderList.size();i++)
            System.out.println(mainOrderList.get(i).getId());*/


        for(MainOrder iter:mainOrderList){
            OrderCourseExample example1=new OrderCourseExample();
            example1.createCriteria().andOrderIdEqualTo(iter.getId());
            List<OrderCourse>list=orderCourseMapper.selectByExample(example1);
            if(list==null||list!=null&&list.size()==0){

            }else{
                /*OrderCourse record=list.get(0);
                orderCourseList.add(record);*/
                orderCourseList.addAll(list);
            }
        }


        //System.out.println("orderCourseList size:"+orderCourseList.size());


        //order_course got
        if(orderCourseList==null||orderCourseList!=null&&orderCourseList.size()==0){
            return null;
        }
        //end got course arrange new list
        List<CourseArrangeNew>courseArrangeNewList=new ArrayList<CourseArrangeNew>();
        for(OrderCourse iter:orderCourseList){
            CourseArrangeNewExample example2=new CourseArrangeNewExample();
            example2.createCriteria().andIdEqualTo(iter.getArrangeId());
            List<CourseArrangeNew>list=courseArrangeNewMapper.selectByExample(example2);
            if(list==null||list!=null&&list.size()==0){

            }else{
                /*CourseArrangeNew record=list.get(0);
                courseArrangeNewList.add(record);*/
                courseArrangeNewList.addAll(list);
            }
        }

        if(courseArrangeNewList==null||courseArrangeNewList!=null&&courseArrangeNewList.size()==0){
            return null;
        }else{


            //System.out.println("courseArrangeNewList size:"+courseArrangeNewList.size());

            //去重 waitting

            PageInfo<CourseArrangeNew> pageInfo=new PageInfo<CourseArrangeNew>(courseArrangeNewList);
            DataGridResult dataGridResult=new DataGridResult();
            dataGridResult.setTotal(pageInfo.getTotal());
            dataGridResult.setRows(courseArrangeNewList);

            return dataGridResult;
        }
    }

    @Override
    public List<StuInfo> getStuInfo(Long campusId,Long userId){
        List<StuInfo>list=new ArrayList<StuInfo>();

        User user=userService.getByPrimaryKey(userId.intValue());

        StuInfo record=new StuInfo();
        record.setUserName(user.getNameCn());

        CampusExample example=new CampusExample();
        example.createCriteria().andIdEqualTo(campusId);
        List<Campus>campusList=campusMapper.selectByExample(example);
        if(campusList==null||campusList!=null&&campusList.size()==0){
            return list;
        }
        record.setSchoolName(campusList.get(0).getCampusName());
        list.add(record);
        return list;
    }

    @Override
    public HashMap<String, List<HomeWorkTaskFront>> getDoneDetailsWithBaseDate(Long campusId,Long arrangeId, Long userId, Date baseDate){
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
            //control types
            List<HomeWorkTask> homeWorkTasks=new ArrayList<HomeWorkTask>();

            //first get homeworks
            for (int j = 0; j < 5; j++) {
                HomeWorkTaskExample example=new HomeWorkTaskExample();

                example.createCriteria()
                        .andCreateTimeGreaterThanOrEqualTo(dateList.get(j)).andCreateTimeLessThan(DateHelper.tomorrow(dateList.get(j)))
                        .andTaskArrangeIdEqualTo(arrangeId)
                        .andTaskTypeEqualTo(i);

                List<HomeWorkTask> homeWorkTasksTemp = homeWorkTaskMapper.selectByExample(example);
                if (homeWorkTasksTemp==null||homeWorkTasksTemp.size()==0){
                    //对应 未发布作业的情况
                    homeWorkTasks.add(null);
                }else {
                    homeWorkTasks.add(homeWorkTasksTemp.get(0));
                }
            }


            //这里查找对应的学生的完成情况

            List<HomeWorkTaskFront> homeWorkTaskFronts=new ArrayList<HomeWorkTaskFront>();


            for (int j = 0; j < homeWorkTasks.size(); j++) {

                HomeWorkTaskFront homeWorkTaskFront=new HomeWorkTaskFront();

                homeWorkTaskFront.setHomeWorkTask(homeWorkTasks.get(j));

                if (homeWorkTasks.get(j)!=null){

                    UserHomeWorkExample userExample=new UserHomeWorkExample();
                    userExample.createCriteria().andCreateUserEqualTo(userId).andTaskIdEqualTo(homeWorkTasks.get(j).getId());
                    List<UserHomeWork> userHomeWorks = userHomeWorkMapper.selectByExample(userExample);
                    if (userHomeWorks==null||userHomeWorks.size()==0){
                        homeWorkTaskFront.setUserHomeWork(null);
                        /*homeWorkTaskFront.setStatus(0);*/
                        //判断作业是否还可以提交
                        HomeWorkTaskExample exampleForJudge=new HomeWorkTaskExample();
                        exampleForJudge.createCriteria().andTaskStartTimeLessThanOrEqualTo(new Date()).andTaskEndTimeGreaterThanOrEqualTo(new Date()).andIdEqualTo(homeWorkTasks.get(j).getId());
                        List<HomeWorkTask> homeWorkTasksForJudge = homeWorkTaskMapper.selectByExample(exampleForJudge);
                        if(homeWorkTasksForJudge==null||homeWorkTasksForJudge!=null&&homeWorkTasksForJudge.size()==0){
                            homeWorkTaskFront.setStatus(1);
                        }else{
                            homeWorkTaskFront.setStatus(0);
                        }
                    }else {
                        UserHomeWork userHomeWork = userHomeWorks.get(0);
                        homeWorkTaskFront.setUserHomeWork(userHomeWork);
                        //任务完成状态   1  已完成待评分  2已评分

                        /*
                         * status:
                         * -1:未发布
                         * 0:未提交，显示上传下载按钮
                         * 1:未提交，但是当前时间已经超过作业提交最晚时间，显示  未提交
                         * 2:已提交 未打分 1类作业
                         * 3:已提交 未打分 2 3 4 类作业
                         * 4:已打分，显示分数
                         * */

                        if (userHomeWork.getTaskStatius()==2){
                            homeWorkTaskFront.setStatus(4);
                        }else if (userHomeWork.getTaskStatius()==1){
                            if (userHomeWork.getTaskSubmitUrl()==null||userHomeWork.getTaskSubmitUrl().equals("")){
                                // 2 3 4 类作业
                                homeWorkTaskFront.setStatus(3);
                            }else {
                                homeWorkTaskFront.setStatus(2);
                            }

                        }
                    }
                }else{
                    // -1  作业未发布
                    homeWorkTaskFront.setUserHomeWork(null);
                    homeWorkTaskFront.setStatus(-1);
                }


                homeWorkTaskFronts.add(homeWorkTaskFront);

            }

            hashMap.put(String.valueOf(i),homeWorkTaskFronts);

        }

        return hashMap;
    }

    @Override
    public JsonResult saveUserHomeWork(UserHomeWork record){
        userHomeWorkMapper.insertSelective(record);
        return JsonResult.success("save success");
    }

    @Override
    public List<UserHomeWork> getTwoRecentHomeWorkTasks(Long userId){
        //按时间倒序获取home work task
        HomeWorkTaskExample example=new HomeWorkTaskExample();
        //example.createCriteria().andTaskStartTimeLessThanOrEqualTo(new Date()).andTaskEndTimeGreaterThanOrEqualTo(new Date());
        example.createCriteria();
        example.setOrderByClause("create_time desc");
        List<HomeWorkTask>homeWorkTaskList=homeWorkTaskMapper.selectByExample(example);
        if(homeWorkTaskList==null||homeWorkTaskList.size()==0){
            return null;
        }else{
            //筛选用户作业
            List<UserHomeWork>userHomeWorkList=new ArrayList<UserHomeWork>();
            for(HomeWorkTask iter:homeWorkTaskList){
                UserHomeWorkExample example1=new UserHomeWorkExample();
                example1.createCriteria().andTaskIdEqualTo(iter.getId()).andCreateUserEqualTo(userId);
                List<UserHomeWork>userHomeWorkListTemp=userHomeWorkMapper.selectByExample(example1);
                if(userHomeWorkListTemp==null||userHomeWorkListTemp!=null&&userHomeWorkListTemp.size()==0){

                }else{
                    userHomeWorkList.add(userHomeWorkListTemp.get(0));
                }
            }
            if(userHomeWorkList.size()<=2&&userHomeWorkList.size()>0){
                return userHomeWorkList;
            }else if(userHomeWorkList.size()>2){
                List<UserHomeWork>endList=new ArrayList<UserHomeWork>();
                endList.add(userHomeWorkList.get(0));
                endList.add(userHomeWorkList.get(1));
                return endList;
            }else{
                return null;
            }
        }
    }

    @Override
    public List<HomeWorkTask> getNotices(Long userId,Long campusId){


        List<HomeWorkTask>endList=new ArrayList<HomeWorkTask>();
        //按时间倒序获取home work task
        HomeWorkTaskExample example=new HomeWorkTaskExample();
        //example.createCriteria().andTaskStartTimeLessThanOrEqualTo(new Date()).andTaskEndTimeGreaterThanOrEqualTo(new Date());
        example.createCriteria();
        example.setOrderByClause("create_time desc");
        List<HomeWorkTask>homeWorkTaskList=homeWorkTaskMapper.selectByExample(example);


        MainOrderExample example1=new MainOrderExample();
        example1.createCriteria().andCreatedUserEqualTo(userId).andOrderStatusEqualTo(3).andCampusIdEqualTo(campusId);
        List<MainOrder> mainOrderList=mainOrderMapper.selectByExample(example1);
        if(mainOrderList==null||mainOrderList!=null&&mainOrderList.size()==0){
            return null;
        }
        //get main_order for user
        List<OrderCourse>orderCourseList=new ArrayList<OrderCourse>();


        /*System.out.println("mainorder size:"+mainOrderList.size());

        for(int i=0;i<mainOrderList.size();i++)
            System.out.println(mainOrderList.get(i).getId());*/


        for(MainOrder iter:mainOrderList){
            OrderCourseExample example2=new OrderCourseExample();
            example2.createCriteria().andOrderIdEqualTo(iter.getId());
            List<OrderCourse>list=orderCourseMapper.selectByExample(example2);
            if(list==null||list!=null&&list.size()==0){

            }else{
                /*OrderCourse record=list.get(0);
                orderCourseList.add(record);*/
                orderCourseList.addAll(list);
            }
        }


        //System.out.println("orderCourseList size:"+orderCourseList.size());


        //order_course got
        if(orderCourseList==null||orderCourseList!=null&&orderCourseList.size()==0){
            return null;
        }
        //end got course arrange new list
        List<CourseArrangeNew>courseArrangeNewList=new ArrayList<CourseArrangeNew>();
        for(OrderCourse iter:orderCourseList){
            CourseArrangeNewExample example3=new CourseArrangeNewExample();
            example3.createCriteria().andIdEqualTo(iter.getArrangeId());
            List<CourseArrangeNew>list=courseArrangeNewMapper.selectByExample(example3);
            if(list==null||list!=null&&list.size()==0){

            }else{
                /*CourseArrangeNew record=list.get(0);
                courseArrangeNewList.add(record);*/
                courseArrangeNewList.addAll(list);
            }
        }

        if(courseArrangeNewList==null||courseArrangeNewList!=null&&courseArrangeNewList.size()==0){
            return null;
        }




       /*for(HomeWorkTask iter:homeWorkTaskList){
            for(CourseArrangeNew iter1:courseArrangeNewList){
                if(iter.getTaskArrangeId()==iter1.getId()){
                    endList.add(iter);
                }
            }
        }*/

        /*System.out.println("flag1111");
        for(int i=0;i<homeWorkTaskList.size();i++){
            System.out.println(homeWorkTaskList.get(i).getId());
        }
        System.out.println("flag2222");
        for(int i=0;i<courseArrangeNewList.size();i++){
            System.out.println(courseArrangeNewList.get(i).getId());
        }
        System.out.println("flag3333");*/

        for(int i=0;i<homeWorkTaskList.size();i++){
            for(int j=0;j<courseArrangeNewList.size();j++){
                if(homeWorkTaskList.get(i).getTaskArrangeId()==courseArrangeNewList.get(j).getId()){
                    endList.add(homeWorkTaskList.get(i));
                    break;
                }
            }
        }

        if(endList.size()>0&&endList.size()<=2){
            System.out.println("0-2");
            return endList;
        }else if(endList.size()==0){
            System.out.println("0");
            return null;
        }else{
            System.out.println(">2");
            for(HomeWorkTask iter:endList){
                System.out.println(iter.getId());
            }
            List<HomeWorkTask>end=new ArrayList<HomeWorkTask>();
            end.add(endList.get(0));
            end.add(endList.get(1));
            return end;
        }
    }

    @Override
    public int getTotalScore(Long taskId){
        HomeWorkTaskExample example=new HomeWorkTaskExample();
        example.createCriteria().andIdEqualTo(taskId);
        List<HomeWorkTask>list=homeWorkTaskMapper.selectByExample(example);
        if(list==null||list.size()==0){
            return -1;
        }else{
            return list.get(0).getTaskTotalScore();
        }
    }
}
