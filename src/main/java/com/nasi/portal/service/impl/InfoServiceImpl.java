package com.nasi.portal.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.common.helper.DateHelper;
import com.nasi.portal.data.mapper.InfoMapper;
import com.nasi.portal.data.model.Info;
import com.nasi.portal.data.model.InfoExample;
import com.nasi.portal.service.InfoService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * created by xdCao on 2018/4/18
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> getInfoList() {

        InfoExample example=new InfoExample();
        example.setOrderByClause("create_time desc");
        List<Info> infoList = infoMapper.selectByExample(example);
        return infoList;

    }

    @Override
    public List<Info> getInfoListLimit(Integer num) {

        List<Info> infos = infoMapper.selectLimit(num);
        return infos;

    }

    @Override
    @Transactional
    public void updateInfo(Info info) {
        infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    @Transactional
    public void deleteInfo(Long id) {
        infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Info showInfo(Long id) {
        Info info = infoMapper.selectByPrimaryKey(id);
        return info;
    }

    @Override
    @Transactional
    public void insertInfo(Info info) {
        infoMapper.insertSelective(info);
    }

    @Override
    public JsonResult<?> getInfoListByPage(Integer page,Integer rows){


        PageHelper.startPage(page,rows,true);
        InfoExample example=new InfoExample();
        example.setOrderByClause("create_time desc");
        List<Info> infos = infoMapper.selectByExample(example);
        PageInfo<Info> pageInfo=new PageInfo<Info>(infos);

        return JsonResult.success(pageInfo);

    }

    @Override
    public DataGridResult getInfoByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        InfoExample example=new InfoExample();
        example.setOrderByClause("create_time desc");
        List<Info> infos = infoMapper.selectByExampleWithBLOBs(example);
        PageInfo<Info> pageInfo=new PageInfo<Info>(infos);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(infos);
        dataGridResult.setTotal(pageInfo.getTotal());

        return dataGridResult;
    }

    @Override
    public DataGridResult findInfoListPageByTitle(String title, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        InfoExample example=new InfoExample();
        example.createCriteria().andTitleLike("%"+title+"%");
        example.setOrderByClause("create_time desc");
        List<Info> infos = infoMapper.selectByExampleWithBLOBs(example);
        PageInfo<Info> pageInfo=new PageInfo<Info>(infos);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(infos);

        return dataGridResult;
    }



    @Override
    public DataGridResult findInfoListPageByDate(Date date, Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        InfoExample example=new InfoExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(date).andCreateTimeLessThan(DateHelper.getTomorrowDate(date));
        example.setOrderByClause("create_time desc");
        List<Info> infos = infoMapper.selectByExampleWithBLOBs(example);
        PageInfo<Info> pageInfo=new PageInfo<Info>(infos);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(infos);
        dataGridResult.setTotal(pageInfo.getTotal());

        return dataGridResult;
    }

    @Override
    public DataGridResult findInfoListPageWithTitleAndDate(String title, Date date, Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        InfoExample example=new InfoExample();
        example.createCriteria().andTitleLike("%"+title+"%").andCreateTimeGreaterThanOrEqualTo(date).andCreateTimeLessThan(DateHelper.getTomorrowDate(date));
        example.setOrderByClause("create_time desc");
        List<Info> infos = infoMapper.selectByExampleWithBLOBs(example);
        PageInfo<Info> pageInfo=new PageInfo<Info>(infos);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(infos);
        dataGridResult.setTotal(pageInfo.getTotal());

        return dataGridResult;

    }

}
