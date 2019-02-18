package com.nasi.portal.web.controller.huanghe;

import com.nasi.portal.common.Pay.AliPay.OrderStatus;
import com.nasi.portal.data.model.Campus;
import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.data.model.Professor;
import com.nasi.portal.data.model.ext.CampusCourseArrange;
import com.nasi.portal.service.CampusService;
import com.nasi.portal.service.CourseArrangeNewService;
import com.nasi.portal.service.ProfessorService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: River
 * @Date:Created in  9:29 2018/4/22
 * @Description: 校区课程列表页
 */
@Controller
@RequestMapping("/campusCourse")
public class CampusCourseController {

    @Autowired
    private CourseArrangeNewService courseArrangeNewService;

    @Autowired
    private CampusService campusService;

    @Autowired
    private ProfessorService professorService;

    /**
     * 前台：课程安排,传入校区id
     *
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public JsonResult<?> campusCourseArrange(@RequestParam("campusId") Long campusId) {

        List<CampusCourseArrange> campusCourseArranges = courseArrangeNewService.campusArrange(campusId);
        if (campusCourseArranges != null && campusCourseArranges.size() > 0) {
            return JsonResult.success(campusCourseArranges);
        } else {
            return JsonResult.success("课程信息为空");
        }

    }

    //按照课程代码，校区检索
    @RequestMapping("/find")
    @ResponseBody
    public DataGridResult campusCourseList(@RequestParam(value = "courseCode", required = false) String courseCode,
                                           @RequestParam(value = "schoolNameCn", required = false) String schoolNameCn,
                                           @RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "rows") Integer rows) {
        DataGridResult CourseArrangeListByPage = null;

        if ((courseCode == null || courseCode.equals("")) && (schoolNameCn == null || schoolNameCn.equals(""))) {
            CourseArrangeListByPage = courseArrangeNewService.getCourseArrangeListByPage(page, rows);
            return CourseArrangeListByPage;
        } else if (schoolNameCn == null || schoolNameCn.equals("")) {
            CourseArrangeListByPage = courseArrangeNewService.findCourseArrangeListByCourseCode(courseCode, page, rows);
            return CourseArrangeListByPage;
        } else if (courseCode == null || courseCode.equals("")) {
            CourseArrangeListByPage = courseArrangeNewService.findCourseArrangeListBySchoolName(schoolNameCn, page, rows);
            return CourseArrangeListByPage;
        } else {
            CourseArrangeListByPage = courseArrangeNewService.findProfessorListPageWithCourseCodeAndSchoolName(courseCode, schoolNameCn, page, rows);
            return CourseArrangeListByPage;
        }
    }

    //添加课程
    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonResult<?> addCourseArrange(@RequestParam("courseName") String courseName,
                                          @RequestParam("courseCode") String courseCode,
                                          @RequestParam("schoolNameCn") String campusId,
                                          @RequestParam("startTime") String start,
                                          @RequestParam("endTime") String end,
                                          @RequestParam("professorNameCn") String professorId,
                                          @RequestParam("courseAttach") String courseAttach) {


        Time startTime = null;
        Time endTime = null;
        try {
            start = start.substring(start.lastIndexOf(" ") + 1);
            end = end.substring(end.lastIndexOf(" ") + 1);
            startTime = Time.valueOf(start);
            endTime = Time.valueOf(end);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Campus campus = campusService.getCampusRecordBySelect(Long.parseLong(campusId)).get(0);
        String schoolNameCn = campus.getCampusName();
        String schoolNameEn = campus.getCampusNameEn();


        Professor professor = professorService.getProfessorById(Long.parseLong(professorId));
        String professorNameCn = professor.getProfessorName();
        String professorFromSchool = professor.getFromSchool();

        CourseArrangeNew courseArrange = new CourseArrangeNew();
        courseArrange.setCampusId(Long.parseLong(campusId));
        courseArrange.setCourseName(courseName);
        courseArrange.setCourseCode(courseCode);
        courseArrange.setSchoolNameCn(schoolNameCn);
        courseArrange.setSchoolNameEn(schoolNameEn);
        courseArrange.setStartTime(startTime);
        courseArrange.setEndTime(endTime);
        courseArrange.setProfessorId(Integer.parseInt(professorId));
        courseArrange.setProfessorNameCn(professorNameCn);
        courseArrange.setProfessorFromSchoolCn(professorFromSchool);
        courseArrange.setCourseAttach(courseAttach);
        courseArrange.setCreateTime(new Date());
        courseArrange.setUpdateTime(new Date());

        courseArrangeNewService.insertCourseArrange(courseArrange);

        return JsonResult.success(null);
    }

    //删除课程
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult<?> deleteCourseArrange(@RequestParam("id") Long id) {
        try {
            courseArrangeNewService.deleteCourseArrange(id);
            return JsonResult.success(null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("删除课程失败");
        }
    }

    //批量删除
    @RequestMapping(value = "/batchDelete")
    @ResponseBody
    public JsonResult<?> deleteBatchCourseArrange(@RequestParam String ids) {

        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                courseArrangeNewService.deleteCourseArrange(id);
            }
            return JsonResult.success(null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("删除失败");
        }


    }

    public boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    //更新课程
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult<?> updateCourseArrange(@RequestParam("id") Long id,
                                             @RequestParam("courseName") String courseName,
                                             @RequestParam("courseCode") String courseCode,
                                             @RequestParam("schoolNameCn") String campusId,
                                             @RequestParam("startTime") String start,
                                             @RequestParam("endTime") String end,
                                             @RequestParam("professorNameCn") String professorId,
                                             @RequestParam("uploadFile") String uploadFile) {


        CourseArrangeNew courseArrange = courseArrangeNewService.showCourseArrange(id);

        Date startTime = null;
        Date endTime = null;
        try {
            endTime = new SimpleDateFormat("HH:mm:ss").parse(end);
            startTime = new SimpleDateFormat("HH:mm:ss").parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //更新校区信息
        List<Campus> campusList;
        if(!isInteger(campusId)){
            campusList= campusService.getCampusRecordBySelectName(campusId);
        }else {
            campusList= campusService.getCampusRecordBySelect(Long.parseLong(campusId));
        }

        if (campusList != null && campusList.size() > 0) {
            for (Campus info : campusList) {
                courseArrange.setCampusId(info.getId());
                courseArrange.setSchoolNameCn(info.getCampusName());
                courseArrange.setSchoolNameEn(info.getCampusNameEn());
            }
        }
        Professor professor;
        if(isInteger(professorId)){
            professor= professorService.getProfessorById(Long.parseLong(professorId));
        }else {
            professor= professorService.getProfessorByName(professorId);
        }

        String professorName = professor.getProfessorName();

        courseArrange.setProfessorId(professor.getId().intValue());
        courseArrange.setCourseName(courseName);
        courseArrange.setCourseCode(courseCode);
        courseArrange.setStartTime(startTime);
        courseArrange.setEndTime(endTime);
        courseArrange.setProfessorNameCn(professorName);
        courseArrange.setCourseAttach(uploadFile);
        courseArrange.setUpdateTime(new Date());

        courseArrangeNewService.updateCourseArrange(courseArrange);

        return JsonResult.success(courseArrange);

    }

    //返回校区，easyui需要的格式的json
    @RequestMapping(value = "/show/listCampus")
    @ResponseBody
    public List<ComboboxResult> getCampusList() {
        List<Campus> campusList = campusService.getCampusMessageForHomePage();
        List<ComboboxResult> results = new ArrayList<ComboboxResult>();
        for (Campus list : campusList) {
            ComboboxResult comboboxResult = new ComboboxResult();
            comboboxResult.setId(list.getId());
            comboboxResult.setName(list.getCampusName());
            results.add(comboboxResult);
        }
        return results;
    }

    //返回教授，easyui需要的格式的json
    @RequestMapping(value = "/show/listProfessor")
    @ResponseBody
    public List<ComboboxResult> getProfessorList() {
        List<Professor> professors = professorService.getAll();
        List<ComboboxResult> results = new ArrayList<ComboboxResult>();
        for (Professor list : professors) {
            ComboboxResult comboboxResult = new ComboboxResult();
            comboboxResult.setId(list.getId());
            comboboxResult.setName(list.getProfessorName());
            results.add(comboboxResult);
        }
        return results;
    }


}
