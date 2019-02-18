package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.CourseArrangeNewMapper;
import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.CourseArrangeNewExample;
import com.nasi.portal.data.model.CourseChoiceMsg;
import com.nasi.portal.data.model.ext.CampusCourseArrange;
import com.nasi.portal.service.CourseArrangeNewService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Author: River
 * @Date:Created in  9:45 2018/4/22
 * @Description: 课程安排
 */
@Service
public class CourseArrangeNewServiceImpl implements CourseArrangeNewService {

    @Autowired
    private CourseArrangeNewMapper courseArrangeNewMapper;

    @Override
    public DataGridResult getCourseArrangeListByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        CourseArrangeNewExample example=new CourseArrangeNewExample();
        example.setOrderByClause("create_time desc");
        List<CourseArrangeNew> courseArrangeNews = courseArrangeNewMapper.selectByExample(example);
        PageInfo<CourseArrangeNew> courseArrangeNewPageInfo=new PageInfo<CourseArrangeNew>(courseArrangeNews);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(courseArrangeNews);
        dataGridResult.setTotal(courseArrangeNewPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findCourseArrangeListByCourseCode(String courseCode, Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        CourseArrangeNewExample example=new CourseArrangeNewExample();
        example.createCriteria().andCourseCodeEqualTo(courseCode);
        example.setOrderByClause("create_time desc");
        List<CourseArrangeNew> courseArrangeNews = courseArrangeNewMapper.selectByExample(example);
        PageInfo<CourseArrangeNew> courseArrangeNewPageInfo=new PageInfo<CourseArrangeNew>(courseArrangeNews);


        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(courseArrangeNews);
        dataGridResult.setTotal(courseArrangeNewPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findCourseArrangeListBySchoolName(String schoolNameCn, Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        CourseArrangeNewExample example=new CourseArrangeNewExample();
        example.createCriteria().andSchoolNameCnEqualTo(schoolNameCn);
        example.setOrderByClause("create_time desc");
        List<CourseArrangeNew> courseArrangeNews = courseArrangeNewMapper.selectByExample(example);
        PageInfo<CourseArrangeNew> courseArrangeNewPageInfo=new PageInfo<CourseArrangeNew>(courseArrangeNews);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(courseArrangeNews);
        dataGridResult.setTotal(courseArrangeNewPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findProfessorListPageWithCourseCodeAndSchoolName(String courseCode, String schoolNameCn, Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        CourseArrangeNewExample example=new CourseArrangeNewExample();
        example.createCriteria().andCourseCodeEqualTo(courseCode).andSchoolNameCnEqualTo(schoolNameCn);
        example.setOrderByClause("create_time desc");
        List<CourseArrangeNew> courseArrangeNews = courseArrangeNewMapper.selectByExample(example);
        PageInfo<CourseArrangeNew> courseArrangeNewPageInfo=new PageInfo<CourseArrangeNew>(courseArrangeNews);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(courseArrangeNews);
        dataGridResult.setTotal(courseArrangeNewPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    @Transactional
    public void insertCourseArrange(CourseArrangeNew courseArrange) {
        courseArrangeNewMapper.insertSelective(courseArrange);
    }

    @Override
    @Transactional
    public void deleteCourseArrange(Long id) {
        courseArrangeNewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CampusCourseArrange> campusArrange(Long campusId) {

        CourseArrangeNewExample example=new CourseArrangeNewExample();
        example.createCriteria().andCampusIdEqualTo(campusId);
        //查询出的数据
        List<CourseArrangeNew> courseArrangeNews = courseArrangeNewMapper.selectByExample(example);
        //存放时间的list
        List<String> dates=new ArrayList<String>();
        //存放CampusCourseArrange的list,最后的结果
        List<CampusCourseArrange> list=new ArrayList<CampusCourseArrange>();
        //list存放日期相同的
        List<CourseArrangeNew> cans=new ArrayList<CourseArrangeNew>();

        CampusCourseArrange cr=new CampusCourseArrange();

        for (CourseArrangeNew courseArrangeNew:courseArrangeNews){
            //获取课程开始时间
            String startTime = new SimpleDateFormat("HH:mm:ss").format(courseArrangeNew.getStartTime());
            //获取时间的结束部分
            String endTime = new SimpleDateFormat("HH:mm:ss").format(courseArrangeNew.getEndTime());
            //得到时间段
            String spanTime=startTime+"-"+endTime;
            //如果时间集合里不包含此时间段
            if (!dates.contains(spanTime)){
                dates.add(spanTime);
                if (cans.size()>0 ){
                    cr.setList(cans);
                    list.add(cr);
                    cans =new ArrayList<CourseArrangeNew>();
                }
                //重新的生成新的对象
                cr = new CampusCourseArrange();
                cr.setStartTime(startTime);
                cr.setEndTime(new SimpleDateFormat("HH:mm:ss").format(courseArrangeNew.getEndTime()));
                cr.setTimeSpan(spanTime);
                cans.add(courseArrangeNew);
            }else {
                cans.add(courseArrangeNew);
            }
        }
        //加入最后的cr
        cr.setList(cans);
        list.add(cr);
        return list;
    }

    @Override
    public List<CourseChoiceMsg> getCourseByid(Long[] ids) {
        List<Map<String,Object>> courseChoiceList = courseArrangeNewMapper.getCourseByid(ids);
        if (courseChoiceList == null || courseChoiceList.size()==0){
            return null;
        }
        List<CourseChoiceMsg> courseChoiceMsgList=new ArrayList<CourseChoiceMsg>();

        for (Map<String,Object> map:courseChoiceList){
            CourseChoiceMsg courseChoiceMsg=new CourseChoiceMsg();
            courseChoiceMsg.setId((Long)map.get("id"));
            courseChoiceMsg.setCourseId(Long.parseLong(map.get("course_id").toString()));
            courseChoiceMsg.setCampusId(Long.parseLong(map.get("campus_id").toString()));
            courseChoiceMsg.setCourseName(map.get("course_name").toString());
            courseChoiceMsg.setCourseCode(map.get("course_code").toString());
            courseChoiceMsg.setSchoolNameCn(map.get("school_name_cn").toString());
            courseChoiceMsg.setStartTime(map.get("start_time").toString());
            courseChoiceMsg.setEndTime(map.get("end_time").toString());
            courseChoiceMsg.setTimeSpan(map.get("start_time").toString()+"-"+map.get("start_time").toString());
            courseChoiceMsg.setChoiceTime(new Date());
            courseChoiceMsgList.add(courseChoiceMsg);
        }
        return courseChoiceMsgList;
    }

    @Override
    public CourseArrangeNew showCourseArrange(Long id) {
        CourseArrangeNew courseArrangeNew = courseArrangeNewMapper.selectByPrimaryKey(id);
        return courseArrangeNew;
    }

    @Override
    @Transactional
    public void updateCourseArrange(CourseArrangeNew courseArrange) {
        courseArrangeNewMapper.updateByPrimaryKeySelective(courseArrange);
    }


    public List<CourseArrangeNew> getCourseArrangeByProfessorId(Integer professorId, Long campusId){

        CourseArrangeNewExample example=new CourseArrangeNewExample();
        example.createCriteria().andProfessorIdEqualTo(professorId).andCampusIdEqualTo(campusId);
        List<CourseArrangeNew> courseArrangeNewList = courseArrangeNewMapper.selectByExample(example);
        return courseArrangeNewList;
    }

}
