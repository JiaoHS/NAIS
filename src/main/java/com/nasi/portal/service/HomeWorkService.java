package com.nasi.portal.service;

import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.HomeWorkTask;
import com.nasi.portal.data.model.UserHomeWork;
import com.nasi.portal.web.controller.caohao.DTO.HomeWorkTaskFront;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.StuInfo;
import com.nasi.portal.web.model.JsonResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yy on 2018-05-25.
 */
public interface HomeWorkService {
    public DataGridResult showMyCourses(Long userId, Long campusId,Integer page, Integer rows);
    public List<StuInfo> getStuInfo(Long campusId,Long userId);
    public HashMap<String, List<HomeWorkTaskFront>> getDoneDetailsWithBaseDate(Long campusId,Long arrangeId, Long userId, Date baseDate);
    public JsonResult saveUserHomeWork(UserHomeWork record);
    public List<UserHomeWork> getTwoRecentHomeWorkTasks(Long userId);
    public List<HomeWorkTask> getNotices(Long userId,Long campusId);
    public int getTotalScore(Long taskId);
}
