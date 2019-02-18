package com.nasi.portal.web.controller.system;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nasi.portal.common.helper.IOHelper;
import com.nasi.portal.data.mapper.CourseArrangeMapper;
import com.nasi.portal.data.mapper.CourseMapper;
import com.nasi.portal.data.mapper.SchoolMapper;
import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.Course;
import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.CourseArrangeCriteria;
import com.nasi.portal.data.model.Pager;
import com.nasi.portal.data.model.School;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.dict.ArrangStatus;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/arrange")
public class ArrangeSystemController extends BaseController {

    @Resource
    private CourseArrangeMapper courseArrangeMapper;

    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private WebConfigService webConfigService;

    @RequestMapping(value = "list")
    public String listArrange(String schoolNameQuery, String courseNameQuery, String professorNameQuery,
            @RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize, Model model) {

        CourseArrangeCriteria arrangeCriteria = new CourseArrangeCriteria();
        CourseArrangeCriteria.Criteria criteria = arrangeCriteria.createCriteria();
        if (StringUtils.isNotEmpty(schoolNameQuery)) {
            criteria.andSchoolNameCnLike("%" + schoolNameQuery + "%");
        }
        if (StringUtils.isNotEmpty(courseNameQuery)) {
            criteria.andCourseNameCnLike("%" + courseNameQuery + "%");
        }
        if (StringUtils.isNotEmpty(professorNameQuery)) {
            criteria.andProfessorNameCnLike("%" + professorNameQuery + "%");
        }

        int count = courseArrangeMapper.countByExample(arrangeCriteria);
        Pager<CourseArrange> pager = new Pager<CourseArrange>(pageNo, pageSize, count);
        arrangeCriteria.setStart(pager.getStart());
        arrangeCriteria.setEnd(pager.getPageSize());

        List<CourseArrange> data = courseArrangeMapper.selectByExample(arrangeCriteria);

        pager.setData(data);

        model.addAttribute("pager", pager);
        model.addAttribute("schoolNameQuery",schoolNameQuery);
        model.addAttribute("courseNameQuery",courseNameQuery);
        model.addAttribute("professorNameQuery",professorNameQuery);

        return "system/arrange/arrangeList";

    }

    @RequestMapping(value = "/disable")
    public String disable(Integer id) {

        CourseArrange arrange = new CourseArrange();
        arrange.setStatus(ArrangStatus.DISABLE.getStatus());
        arrange.setId(id);
        courseArrangeMapper.updateByPrimaryKeySelective(arrange);
        return "redirect:list";

    }

    @RequestMapping(value = "/active")
    public String active(Integer id) {

        CourseArrange arrange = new CourseArrange();
        arrange.setStatus(ArrangStatus.ACTIVE.getStatus());
        arrange.setId(id);
        courseArrangeMapper.updateByPrimaryKeySelective(arrange);
        return "redirect:list";

    }

    @RequestMapping(value = "/showArrangeDetail")
    public String showArrangeDetail(Integer arrangeId, Model model){
        
        CourseArrange arrange = courseArrangeMapper.selectByPrimaryKey(arrangeId);
        
        model.addAttribute("arrange", arrange);
        
        return "/system/arrange/arrangeDetail";
        
        
    }
    
    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm:ss");
    
    @RequestMapping(value = "/ajaxGetArrange")
    public @ResponseBody JSONObject ajaxGetArrange(Integer id){
        
        JSONObject json = new JSONObject();
        
        CourseArrange arrange = courseArrangeMapper.selectByPrimaryKey(id);
        if (arrange != null) {
            json.put("schoolId", arrange.getSchoolId());
            json.put("courseId", arrange.getCourseId());
            json.put("professorId", arrange.getProfessorId());
            json.put("startTime", SDF_TIME.format(arrange.getCourseStartTime()));
            json.put("endTime", SDF_TIME.format(arrange.getCourseEndTime()));
            json.put("price", arrange.getPrice()/1000);
        }
        
        return json;
        
    }
    
    
    @RequestMapping(value = "/add")
    public
            String
            addArrange(
                    @RequestParam(value = "schoolId", required = false) Integer schoolId,
                    @RequestParam(value = "courseId", required = false) Integer courseId,
                    @RequestParam(value = "professorId", required = false, defaultValue="0") Integer professorId,
                    @RequestParam(value = "startTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") Date startTime,
                    @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") Date endTime,
                    @RequestParam(value = "price", required = false, defaultValue="0") Double price,
                    @RequestParam(value = "courseAttach", required = false) MultipartFile courseAttach,
                    HttpServletRequest request, HttpServletResponse response) {

        try {
            User loginUser = getCurrentLoginUser(request);
            School school = schoolMapper.selectByPrimaryKey(schoolId);
            Course course = courseMapper.selectByPrimaryKey(courseId);
            User professor = userMapper.selectByPrimaryKey(professorId.intValue());

            if (school == null || course == null) {
                printAlertAndRefresh(response, "参数不正确", "/system/arrange/list");
            }

            Double priceLong = price * 1000;
            
            CourseArrange arrange = new CourseArrange();
            arrange.setSchoolId(schoolId);
            arrange.setSchoolNameCn(school.getSchoolNameCn());
            arrange.setSchoolNameEn(school.getSchoolNameEn());
            arrange.setCourseId(courseId);
            arrange.setCourseCode(course.getCourseCode());
            arrange.setCourseNameCn(course.getCourseNameCn());
            arrange.setCourseNameEn(course.getCourseNameEn());
            if (professor != null) {
                arrange.setProfessorId(professorId);
                arrange.setProfessorNameCn(professor.getNameCn());
                arrange.setProfessorNameEn(professor.getNameEn());
                arrange.setProfessorFromSchoolCn(professor.getFromSchoolCn());
                arrange.setProfessorFromSchoolEn(professor.getFromSchoolEn());
            }
            arrange.setCreateTime(new Date());
            arrange.setUpdateTime(new Date());
            arrange.setCreateUser(loginUser.getId());
            arrange.setUpdateUser(loginUser.getId());
            arrange.setStatus(ArrangStatus.ACTIVE.getStatus());
            arrange.setPrice(priceLong.longValue());
            arrange.setCourseStartTime(startTime);
            arrange.setCourseEndTime(endTime);
            
            courseArrangeMapper.insertSelective(arrange);

            if (courseAttach != null) {
                String basePath = webConfigService.getByKey("ATTACH_PATH").getV();
                String fileSeparator = System.getProperty("file.separator");
                if (!basePath.endsWith(fileSeparator)) {
                    basePath += fileSeparator;
                }
                if (!courseAttach.isEmpty()) {
                    String relativePath =
                            String.format("upload%sattach%scourse%scourse_attach_%s_%s%s", fileSeparator, fileSeparator,
                                    fileSeparator, arrange.getId(), arrange.getCourseNameEn(),courseAttach.getName().substring(courseAttach.getName().lastIndexOf(".")));
                    File courseTargetAttach = new File(basePath + relativePath);
                    IOHelper.makeDirs(courseTargetAttach);
                    courseAttach.transferTo(courseTargetAttach);
                    arrange.setAttachPath(relativePath);
                }
            }
            courseArrangeMapper.updateByPrimaryKeySelective(arrange);

            printAlertAndRefresh(response, "保存成功", "/system/arrange/list");
        } catch (Exception e) {
            printAlertAndRefresh(response, "保存失败", "/system/arrange/list");
        }

        return null;
    }
    
    
    @RequestMapping(value = "/update")
    public
            String
            updateArrange(
                    @RequestParam(value = "id", required = false) Integer id,
                    @RequestParam(value = "schoolId", required = false) Integer schoolId,
                    @RequestParam(value = "courseId", required = false) Integer courseId,
                    @RequestParam(value = "professorId", required = false, defaultValue="0") Integer professorId,
                    @RequestParam(value = "startTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") Date startTime,
                    @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") Date endTime,
                    @RequestParam(value = "price", required = false, defaultValue="0") Double price,
                    @RequestParam(value = "courseAttach", required = false) MultipartFile courseAttach,
                    HttpServletRequest request, HttpServletResponse response) {
        try {
            
            if (id == null| id == 0 ) {
                printAlertAndRefresh(response, "id不能为空", "/system/arrange/list");
            }
            
            User loginUser = getCurrentLoginUser(request);
            School school = schoolMapper.selectByPrimaryKey(schoolId);
            Course course = courseMapper.selectByPrimaryKey(courseId);
            User professor = userMapper.selectByPrimaryKey(professorId.intValue());

            if (school == null || course == null) {
                printAlertAndRefresh(response, "参数不正确", "/system/arrange/list");
            }

            Double priceLong = price * 1000;
            
            CourseArrange arrange = new CourseArrange();
            arrange.setId(id);
            arrange.setSchoolId(schoolId);
            arrange.setSchoolNameCn(school.getSchoolNameCn());
            arrange.setSchoolNameEn(school.getSchoolNameEn());
            arrange.setCourseId(courseId);
            arrange.setCourseCode(course.getCourseCode());
            arrange.setCourseNameCn(course.getCourseNameCn());
            arrange.setCourseNameEn(course.getCourseNameEn());
            if (professor != null) {
                arrange.setProfessorId(professorId);
                arrange.setProfessorNameCn(professor.getNameCn());
                arrange.setProfessorNameEn(professor.getNameEn());
                arrange.setProfessorFromSchoolCn(professor.getFromSchoolCn());
                arrange.setProfessorFromSchoolEn(professor.getFromSchoolEn());
            }else {
                arrange.setProfessorId(0);
                arrange.setProfessorNameCn("");
                arrange.setProfessorNameEn("");
                arrange.setProfessorFromSchoolCn("");
                arrange.setProfessorFromSchoolEn("");
            }
            arrange.setCreateTime(new Date());
            arrange.setUpdateTime(new Date());
            arrange.setCreateUser(loginUser.getId());
            arrange.setUpdateUser(loginUser.getId());
            arrange.setStatus(ArrangStatus.ACTIVE.getStatus());
            arrange.setPrice(priceLong.longValue());
            arrange.setCourseStartTime(startTime);
            arrange.setCourseEndTime(endTime);
            
            courseArrangeMapper.updateByPrimaryKeySelective(arrange);

            if (courseAttach != null) {
                String basePath = webConfigService.getByKey("ATTACH_PATH").getV();
                String fileSeparator = System.getProperty("file.separator");
                if (!basePath.endsWith(fileSeparator)) {
                    basePath += fileSeparator;
                }
                if (!courseAttach.isEmpty()) {
                    String relativePath =
                            String.format("upload%sattach%scourse%scourse_attach_%s_%s%s", fileSeparator, fileSeparator,
                                    fileSeparator, arrange.getId(), arrange.getCourseNameEn(),courseAttach.getName().substring(courseAttach.getName().lastIndexOf(".")));
                    File courseTargetAttach = new File(basePath + relativePath);
                    IOHelper.makeDirs(courseTargetAttach);
                    courseAttach.transferTo(courseTargetAttach);
                    arrange.setAttachPath(relativePath);
                }
            }
            courseArrangeMapper.updateByPrimaryKeySelective(arrange);

            printAlertAndRefresh(response, "更新成功", "/system/arrange/list");
        } catch (Exception e) {
            printAlertAndRefresh(response, "更新失败", "/system/arrange/list");
        }

        return null;
    }
    

}
