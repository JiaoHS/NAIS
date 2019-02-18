package com.nasi.portal.data.model.ext;

import com.nasi.portal.data.model.CourseArrangeNew;

import java.util.List;

/**
 * @Author: River
 * @Date:Created in  16:23 2018/4/22
 * @Description:
 */
public class CampusCourseArrange {
    private String courseId;
    private String startTime;
    private String endTime;
    private List<CourseArrangeNew> list;
    private String timeSpan;

    public String getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<CourseArrangeNew> getList() {
        return list;
    }

    public void setList(List<CourseArrangeNew> list) {
        this.list = list;
    }
}
