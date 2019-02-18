package com.nasi.portal.web.controller.system;

import java.util.List;

import javax.annotation.Resource;

import com.nasi.portal.data.model.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.data.mapper.CourseReportMapper;
import com.nasi.portal.data.mapper.UserMapper;

@Controller
@RequestMapping("/system/report")
public class ReportController {

    @Resource
    private CourseReportMapper reportMapper;

    @Resource
    private UserMapper userMapper;
    
    @RequestMapping("list")
    public String list(String userEmail, Model model) {

        if (StringUtils.isNotBlank(userEmail)) {
            CourseReportCriteria reportCriteria = new CourseReportCriteria();
            reportCriteria.createCriteria().andStudentAccountEqualTo(userEmail);
            List<CourseReport> reports = reportMapper.selectByExample(reportCriteria);
            
            UserExample userCriteria = new UserExample();
            userCriteria.createCriteria().andEmailEqualTo(userEmail);
            
            List<User> users = userMapper.selectByExample(userCriteria);
            
            if (CollectionUtils.isNotEmpty(users)) {
                model.addAttribute("user", users.get(0));
                model.addAttribute("reports", reports);
                model.addAttribute("userEmail", userEmail);
            }
            
        }

        return "/system/report/reportList";

    }

    @RequestMapping(method=RequestMethod.GET ,value="ajaxUpdate")
    @ResponseBody
    public void ajaxUpdate(Integer id, Integer score) {

        if (id == null || score == null) {
            return;
        }
        CourseReport report = new CourseReport();
        report.setScore(score);
        report.setId(id);
        reportMapper.updateByPrimaryKeySelective(report);
    }
    
    
    @RequestMapping(method=RequestMethod.GET ,value="ajaxUpdateIsPaid")
    @ResponseBody
    public void ajaxUpdateIsPaid(Integer id, Integer isPaid) {

        if (id == null || isPaid == null) {
            return;
        }
        CourseReport report = new CourseReport();
        report.setIsPaid(isPaid);
        report.setId(id);
        reportMapper.updateByPrimaryKeySelective(report);
    }

}
