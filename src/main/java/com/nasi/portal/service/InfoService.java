package com.nasi.portal.service;


import com.nasi.portal.data.model.Info;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;

import java.util.Date;
import java.util.List;

/**
 * created by xdCao on 2018/4/18
 */

public interface InfoService {

    List<Info> getInfoList();

    List<Info> getInfoListLimit(Integer num);

    void updateInfo(Info info);

    void deleteInfo(Long id);

    Info showInfo(Long id);

    void insertInfo(Info info);

    public JsonResult<?> getInfoListByPage(Integer page, Integer rows);

    DataGridResult getInfoByPage(Integer page,Integer rows);

    DataGridResult findInfoListPageByTitle(String title, Integer page, Integer rows);

    DataGridResult findInfoListPageByDate(Date date, Integer page, Integer rows);

    DataGridResult findInfoListPageWithTitleAndDate(String title, Date date, Integer page, Integer rows);
}
