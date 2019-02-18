package com.nasi.portal.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.CourseWareMapper;
import com.nasi.portal.data.model.CourseWare;
import com.nasi.portal.data.model.CourseWareCriteria;
import com.nasi.portal.service.CourseWareService;

@Service
public class CourseWareServiceImpl implements CourseWareService {

    
     @Resource
     CourseWareMapper courseWareMapper;
     
     @Override
     public List<CourseWare> getListByArrangeId(Long arrangeId){
         
         if (arrangeId == null) {
            return Collections.emptyList();
        }
         
         CourseWareCriteria courseWareCriteria = new CourseWareCriteria();
         courseWareCriteria.createCriteria().andArrangeIdEqualTo(arrangeId).andWareStatusEqualTo(1);
         
         return courseWareMapper.selectByExample(courseWareCriteria);
         
     }
     
     @Override
     public CourseWare getById(Long id){
         
         if (id == null) {
            return null;
        }
         return courseWareMapper.selectByPrimaryKey(id);
         
     }
     
     @Override
     public Integer disableById(Long id){
         
         if (id == null) {
            return 0;
         }
        
         CourseWare ware = new CourseWare();
         ware.setId(id);
         ware.setWareStatus(2);
         return courseWareMapper.updateByPrimaryKeySelective(ware);
         
     }
     
     @Override
     public Integer insertWare(CourseWare ware){
         
         if (ware == null) {
            return 0;
        }
         
        return courseWareMapper.insertSelective(ware);
         
     }
     
}
