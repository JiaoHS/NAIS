package com.nasi.portal.service;

import com.nasi.portal.data.model.Campus;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.campusInfo;
import com.nasi.portal.web.model.JsonResult;

import java.util.List;

public interface CampusService {
    public List<Campus> getCampusMessageForHomePage();
    public DataGridResult getCampusRecordFromQuery(String campusName,Integer page, Integer rows);
    public DataGridResult getCampusRecords(Integer page, Integer rows);
    public List<campusInfo> getCampusRecordsAnother();
    public List<Campus> getCampusRecordBySelect(Long id);
    public List<Campus> getCampusRecordBySelectName(String name);
    int insertOrUpdate(Campus campus);
    int deleteCampusRecord(Long id);
    public JsonResult<?> getCampusListByPage(Integer page, Integer rows);
    public DataGridResult getCampusListForDataGridByPage(Integer page, Integer rows);
}
