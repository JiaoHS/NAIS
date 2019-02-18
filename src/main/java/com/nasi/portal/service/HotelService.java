/**
 * @author anliyong@baidu.com
 * 2015-8-29 下午2:05:05
 */
package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.Campus;
import com.nasi.portal.data.model.Hotel;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.campusInfo;
import com.nasi.portal.web.model.JsonResult;

/**
 * @author anliyong@baidu.com
 * 2015-8-29下午2:05:05
 */
public interface HotelService {

    public List<Campus> getCampusMessageForHomePage();
    public DataGridResult getCampusRecordFromQuery(String campusName, Integer page, Integer rows);
    public DataGridResult getCampusRecords(Integer page, Integer rows);
    public List<campusInfo> getCampusRecordsAnother();
    public List<Campus> getCampusRecordBySelect(Long id);
    int insertOrUpdate(Campus campus);
    int deleteCampusRecord(Long id);
    public JsonResult<?> getCampusListByPage(Integer page, Integer rows);
    public DataGridResult getCampusListForDataGridByPage(Integer page, Integer rows);
    
}
