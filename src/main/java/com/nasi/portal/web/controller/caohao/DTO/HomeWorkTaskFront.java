package com.nasi.portal.web.controller.caohao.DTO;

import com.nasi.portal.data.model.HomeWorkTask;
import com.nasi.portal.data.model.UserHomeWork;
import com.nasi.portal.web.controller.caohao.PictureResult;

/**
 * created by xdCao on 2018/5/21
 */

public class HomeWorkTaskFront {

    private HomeWorkTask homeWorkTask;

    private Integer status;

    private UserHomeWork userHomeWork;

    public UserHomeWork getUserHomeWork() {
        return userHomeWork;
    }

    public void setUserHomeWork(UserHomeWork userHomeWork) {
        this.userHomeWork = userHomeWork;
    }



    public HomeWorkTask getHomeWorkTask() {
        return homeWorkTask;
    }

    public void setHomeWorkTask(HomeWorkTask homeWorkTask) {
        this.homeWorkTask = homeWorkTask;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
