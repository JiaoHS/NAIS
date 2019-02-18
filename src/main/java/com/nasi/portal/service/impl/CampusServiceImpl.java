package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.CampusMapper;
import com.nasi.portal.data.model.Campus;
import com.nasi.portal.data.model.CampusExample;
import com.nasi.portal.service.CampusService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.campusInfo;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class CampusServiceImpl implements CampusService {
    @Resource
    private CampusMapper campusMapper;
    @Override
    public List<Campus> getCampusMessageForHomePage(){
        CampusExample example=new CampusExample();
        example.createCriteria();
        example.setOrderByClause("update_time desc");
        List<Campus> campusList=campusMapper.selectByExampleWithBLOBs(example);

        if(campusList==null||campusList!=null&&campusList.size()==0){
            return null;
        }
        return campusList;
    }

    @Override
    public DataGridResult getCampusRecordFromQuery(String campusName,Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        CampusExample example=new CampusExample();
        example.createCriteria().andCampusNameLike("%"+campusName+"%");
        example.setOrderByClause("create_time desc");
        List<Campus> campusList=campusMapper.selectByExampleWithBLOBs(example);
        PageInfo<Campus> pageInfo=new PageInfo<Campus>(campusList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(campusList);
        return dataGridResult;
    }

    @Override
    public DataGridResult getCampusRecords(Integer page, Integer rows){
        PageHelper.startPage(page,rows,true);
        CampusExample example=new CampusExample();
        example.setOrderByClause("update_time desc");
        List<Campus> campusList = campusMapper.selectByExampleWithBLOBs(example);

        List<campusInfo>campusInfoList=new ArrayList<campusInfo>();
        for(Campus iter:campusList){
            campusInfo record=new campusInfo();
            record.setId(iter.getId());
            record.setCampusName(iter.getCampusName());
            record.setCampusNameEn(iter.getCampusNameEn());
            campusInfoList.add(record);
        }



        PageInfo<campusInfo> pageInfo=new PageInfo<campusInfo>(campusInfoList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(campusInfoList);
        dataGridResult.setTotal(pageInfo.getTotal());

        return dataGridResult;
    }

    @Override
    public List<campusInfo> getCampusRecordsAnother(){
        CampusExample example=new CampusExample();
        example.setOrderByClause("update_time desc");
        List<Campus> campusList = campusMapper.selectByExampleWithBLOBs(example);

        List<campusInfo>campusInfoList=new ArrayList<campusInfo>();
        /*for(Campus iter:campusList){
            campusInfo record=new campusInfo();
            record.setId(iter.getId());
            record.setCampusName(iter.getCampusName());
            record.setCampusNameEn(iter.getCampusNameEn());
            campusInfoList.add(record);
        }*/
        campusInfo record=new campusInfo();
        record.setId(campusList.get(0).getId());
        record.setCampusName(campusList.get(0).getCampusName());
        record.setCampusNameEn(campusList.get(0).getCampusNameEn());
        campusInfoList.add(record);
        return campusInfoList;
    }

    @Override
    public List<Campus> getCampusRecordBySelect(Long id){
        CampusExample example=new CampusExample();
        example.createCriteria().andIdEqualTo(id);
        List<Campus> campusList=campusMapper.selectByExampleWithBLOBs(example);

        if(campusList==null||campusList.isEmpty()){
            return null;
        }
        return campusList;
    }

    @Override
    public List<Campus> getCampusRecordBySelectName(String name){
        CampusExample example=new CampusExample();
        example.createCriteria().andCampusNameEqualTo(name);
        List<Campus> campusList=campusMapper.selectByExampleWithBLOBs(example);

        if(campusList==null||campusList.isEmpty()){
            return null;
        }
        return campusList;
    }

    @Override
    public int insertOrUpdate(Campus campus){
        notNull(campus, "campus不能为空");
        if (campus.getId() == null) {
            return campusMapper.insertSelective(campus);
        } else {
            return campusMapper.updateByPrimaryKeySelective(campus);
        }
    }

    @Override
    public int deleteCampusRecord(Long id){
        CampusExample example=new CampusExample();
        example.createCriteria().andIdEqualTo(id);
        List<Campus> campusList=campusMapper.selectByExampleWithBLOBs(example);

        if(campusList==null||campusList!=null&&campusList.size()==0){
            return -1;
        }else{
            campusMapper.deleteByPrimaryKey(id);
            return 1;
        }
    }

    @Override
    public JsonResult<?> getCampusListByPage(Integer page, Integer rows){
        PageHelper.startPage(page,rows,true);
        CampusExample example=new CampusExample();
        example.setOrderByClause("update_time desc");
        List<Campus> campusList = campusMapper.selectByExampleWithBLOBs(example);
        PageInfo<Campus> pageInfo=new PageInfo<Campus>(campusList);

        return JsonResult.success(pageInfo);
    }

    @Override
    public DataGridResult getCampusListForDataGridByPage(Integer page, Integer rows){
        PageHelper.startPage(page,rows,true);
        CampusExample example=new CampusExample();
        example.setOrderByClause("update_time desc");
        List<Campus> campusList = campusMapper.selectByExampleWithBLOBs(example);
        PageInfo<Campus> pageInfo=new PageInfo<Campus>(campusList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(campusList);
        dataGridResult.setTotal(pageInfo.getTotal());

        return dataGridResult;
    }
}
