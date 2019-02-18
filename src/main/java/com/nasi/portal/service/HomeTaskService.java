package com.nasi.portal.service;

import com.nasi.portal.data.model.HomeWorkTask;
import com.nasi.portal.data.model.User;
import com.nasi.portal.web.controller.caohao.DTO.HomeWorkTaskFront;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * created by xdCao on 2018/5/21
 */

public interface HomeTaskService {
    void addNewHomeTask(HomeWorkTask homeWorkTask);

    List<User> getStudentListByCampusAndArrange(Long campusId, Long arrangeId);

    HashMap<String, List<HomeWorkTaskFront>> getDoneDetailWithBaseDate(Long campusId, Long arrangeId, Long userId, Date baseDate);

    boolean updateUserHomeWorkScore(Long id, Integer score);

    List<HomeWorkTask> getNewsByProfessorId(Long id);
}
