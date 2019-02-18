/**
 * @author anliyong@baidu.com
 * 2015-5-31 下午5:56:43
 */
package com.nasi.portal.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.common.helper.MailHelper;
import com.nasi.portal.common.helper.MailInfo;
import com.nasi.portal.data.model.Column;
import com.nasi.portal.data.model.Course;
import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.School;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.ColumnService;
import com.nasi.portal.service.CourseArrangeService;
import com.nasi.portal.service.SchoolService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.model.JsonResult;
import com.nasi.portal.web.model.Professor;
import com.nasi.portal.web.model.SchoolVo;

/**
 * @author anliyong@baidu.com 2015-5-31下午5:56:43
 */
@Controller
@RequestMapping("/column")
public class ColumnController extends BaseController {
    
    @Resource
    private ColumnService columnService;
    
    @Resource
    private CourseArrangeService courseArrangeService;
    
    @Resource
    private SchoolService schoolService;
    
    @Resource
    private UserService userService;
    
    @Resource
    private WebConfigService webConfigService;

    @RequestMapping("/{id}.html")
    public String show(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse reponse, Model model) {
        
        Column topColumn = null;
        Column curColumn = columnService.getByPrimaryKey(id);
        
        if (curColumn.getLevel() == 1) { //一级栏目
            topColumn = curColumn;
            model.addAttribute("topColumn", curColumn);
            List<Column> subColumns = columnService.getListByParentId(curColumn.getId());
            model.addAttribute("subColumns", subColumns);
            if (CollectionUtils.isNotEmpty(subColumns)) {
                model.addAttribute("curColumn", subColumns.get(0));
            }
        } else if (curColumn.getLevel() == 2) { //二级栏目
            topColumn = columnService.getByPrimaryKey(curColumn.getParentId());
            model.addAttribute("topColumn", topColumn);
            model.addAttribute("curColumn", curColumn);
            List<Column> subColumns = columnService.getListByParentId(curColumn.getParentId());
            model.addAttribute("subColumns", subColumns);
        }
        
        return "column/column";
    }
    
    @RequestMapping("/course.html")
    public String course(Model model) {
        
        Integer id = 100014;
        
        Column curColumn = columnService.getByPrimaryKey(id);
        Column topColumn = columnService.getByPrimaryKey(curColumn.getParentId());
        model.addAttribute("topColumn", topColumn);
        model.addAttribute("curColumn", curColumn);
        List<Column> subColumns = columnService.getListByParentId(curColumn.getParentId());
        model.addAttribute("subColumns", subColumns);
        
        List<School> schools = schoolService.getSchools();
        
        List<SchoolVo> schoolVos = new ArrayList<SchoolVo>();
        
        for (School school : schools) {
            SchoolVo vo = new SchoolVo();
            vo.setSchool(school);
            List<CourseArrange> arranges = courseArrangeService.getActiveBySchoolId(school.getId());
            vo.setArranges(arranges);
            schoolVos.add(vo);
        }
        
        model.addAttribute("schools", schoolVos);
        
        return "column/course";
    }
    
    @RequestMapping("/professor.html")
    public String professor(Model model) {
        
        Integer id = 100004;
        
        Column curColumn = columnService.getByPrimaryKey(id);
        Column topColumn = null;
        if (curColumn.getLevel() == 1) { //一级栏目
            topColumn = curColumn;
        } else {
            topColumn = columnService.getByPrimaryKey(curColumn.getParentId());
        }
        
        model.addAttribute("topColumn", topColumn);
        model.addAttribute("curColumn", curColumn);
        List<Column> subColumns = columnService.getListByParentId(curColumn.getParentId());
        model.addAttribute("subColumns", subColumns);
        
        List<School> schools = schoolService.getSchools();
        
        List<SchoolVo> schoolVos = new ArrayList<SchoolVo>();
        
        for (School school : schools) {
            SchoolVo vo = new SchoolVo();
            vo.setSchool(school);
            List<Integer> professors = courseArrangeService.getProfesserIdsBySchool(school.getId());
            List<Professor> prList = new ArrayList<Professor>();
            Set<String> nameSet = new HashSet<String>();
            for(Integer pid : professors) {
                List<CourseArrange> cas =  courseArrangeService.getActiveByProfesserId(pid);
                Professor p = new Professor();
                User user = userService.getByPrimaryKey(pid);
                if (user == null) {
                    continue;
                }
                if (nameSet.contains(user.getNameCn())) {
                    continue;
                }
                nameSet.add(user.getNameCn());
                p.setPhoto(user.getPhoto());
                List<Course> courses = new ArrayList<Course>();
                Set<String> courseCodeSet = new HashSet<String>();
                for (CourseArrange ca : cas) {
                    if (courseCodeSet.contains(ca.getCourseCode())) {
                        continue;
                    }
                    courseCodeSet.add(ca.getCourseCode());
                    p.setId(pid);
                    p.setName(ca.getProfessorNameCn());
                    p.setEname(ca.getProfessorNameEn());
                    p.setSchool(ca.getProfessorFromSchoolCn());
                    p.setEschool(ca.getProfessorFromSchoolEn());
                    Course c = new Course();
                    c.setCourseNameCn(ca.getCourseNameCn());
                    c.setCourseNameEn(ca.getCourseNameEn());
                    courses.add(c);
                }
                p.setCourses(courses);
                prList.add(p);
            }
            vo.setProfessors(prList);
            schoolVos.add(vo);
        }
        
        model.addAttribute("schools", schoolVos);
        
        return "column/professor";
    }
    
    @RequestMapping("/content.do")
    public String content() {
        return "column/content";
    }

    @RequestMapping("/about-us.html")
    public String about() {
        return "column/about";
    }
    
    @RequestMapping("/jyxm.html")
    public String jyxm() {
        return "column/jyxm";
    }
    
    @RequestMapping("/mnlx.html")
    public String mnlx() {
        return "column/mnlx";
    }
    
    @RequestMapping("/send.do")
    @ResponseBody
    public JsonResult<?> send(@RequestParam(value = "name", required = false) String name, 
            @RequestParam(value = "sex", required = false) String sex,
            @RequestParam(value = "university", required = false) String university,
            @RequestParam(value = "gpa", required = false) String gpa,
            @RequestParam(value = "company", required = false) String company,
            @RequestParam(value = "time", required = false) String time) {

        try {
            String mailServerHost = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_HOST).getV();
            String mailServerPort = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_PORT).getV();
            String mailUsername = webConfigService.getByKey(ConfigConstants.EMAIL_USERNAME).getV();
            String mailPassword = webConfigService.getByKey(ConfigConstants.EMAIL_PASSWORD).getV();
            String mailReceived = webConfigService.getByKey(ConfigConstants.EMAIL_RECEIVED).getV();

            StringBuffer sb = new StringBuffer();
            sb.append(String.format("姓名:&nbsp;%s<br/>", name));
            sb.append(String.format("性别:&nbsp;%s<br/>", sex));
            sb.append(String.format("大学:&nbsp;%s<br/>", university));
            sb.append(String.format("GPA:&nbsp;%s<br/>", gpa));
            sb.append(String.format("公司:&nbsp;%s<br/>", company));
            sb.append(String.format("时间:&nbsp;%s<br/>", time));
            
            MailInfo mailInfo = new MailInfo();
            mailInfo.setFromAddress(mailUsername + mailServerHost.substring(mailServerHost.indexOf("@") + 1));
            mailInfo.setMailServerHost(mailServerHost);
            mailInfo.setMailServerPort(mailServerPort);
            mailInfo.setUserName(mailUsername);
            mailInfo.setPassword(mailPassword);
            mailInfo.setToAddress(mailReceived);
            mailInfo.setSubject("精英项目");
            mailInfo.setContent(sb.toString());
            MailHelper.sendHtmlMail(mailInfo);
            return JsonResult.success("");
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return JsonResult.error("系统异常，请联系管理员");
        }

    }

}
