/**
 * @author anliyong@baidu.com
 * 2015-7-18 下午8:16:08
 */
package com.nasi.portal.web.controller.professor;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nasi.portal.data.model.*;
import net.sf.json.JSONObject;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.common.helper.IOHelper;
import com.nasi.portal.service.CourseArrangeService;
import com.nasi.portal.service.CourseHomeWorkAssignService;
import com.nasi.portal.service.CourseHomeWorkCommitService;
import com.nasi.portal.service.CourseReportService;
import com.nasi.portal.service.CourseWareService;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;

/**
 * @author anliyong@baidu.com 2015-7-18下午8:16:08
 */
@Controller
@RequestMapping("/professor")
public class ProfessorController extends BaseController {

    int maxFileByteSize = 1 * 1024 * 1024 * 5;
    
    @Resource
    private CourseArrangeService courseArrangeService;

    @Resource
    private CourseReportService courseReportService;
    
    @Resource
    private CourseWareService courseWareService;

    @Resource
    private WebConfigService webConfigService;
    
    @Resource
    private CourseHomeWorkAssignService courseHomeWorkAssignService;
    
    @Resource
    private CourseHomeWorkCommitService courseHomeWorkCommitService;

    // @RequestMapping("/home.do")
    // public String home() {
    // return "professor/home";
    // }

    @RequestMapping("home.do")
    public String courses(HttpServletRequest request, Model model) {

        User user = super.getCurrentLoginUser(request);
        List<CourseArrange> courses = courseArrangeService.getActiveByProfesserId(user.getId());
        model.addAttribute("courses", courses);
        return "professor/courses";
    }

    @RequestMapping("students.do")
    public String students(@RequestParam("arrangeId") Integer arrangeId, Model model) {

        CourseArrange course = courseArrangeService.getByPrimaryKey(arrangeId);
        List<CourseReport> reports = courseReportService.getAllByArrangeId(arrangeId);
        model.addAttribute("course", course);
        model.addAttribute("reports", reports);
        return "professor/students";
    }

    @RequestMapping("updateScore.do")
    @ResponseBody
    public JsonResult<?> updateScore(@RequestParam("commitId") Integer commitId, @RequestParam("score") Integer score) {
//        courseReportService.updateScoreByPrimaryKey(reportId, score);
        courseHomeWorkCommitService.updateScoreByPrimaryKey(commitId, score);
        return JsonResult.success(Boolean.TRUE);
    }

    @RequestMapping("uploadFile.do")
    @ResponseBody
    public String uploadFile(@RequestParam(value = "arrangeId") Integer arrangeId,
            @RequestParam(value = "wareNameCn") String  wareNameCn,
            @RequestParam(value = "attach", required = false) MultipartFile attach,
            HttpServletRequest request, HttpServletResponse response) {

        
        boolean success = false;
        String code = "";

        if (attach.getSize() > maxFileByteSize) {
            return "<script type=\"text/javascript\">parent.uploadResult('2','"+code+"');</script>";
        }
        
        
        try {

            CourseArrange arrange = courseArrangeService.getByPrimaryKey(arrangeId);
            CourseWare ware = new CourseWare();
            ware.setArrangeId(Long.valueOf(arrangeId));
            code = arrange.getCourseCode();
            ware.setCourseCode(arrange.getCourseCode());
            ware.setCourseId(Long.valueOf(arrange.getCourseId()));
            ware.setCourseNameCn(arrange.getCourseNameCn());
            ware.setCourseNameEn(arrange.getCourseNameEn());
            ware.setCreateTime(new Date());
            ware.setUpdateTime(new Date());
            ware.setWareNameCn(wareNameCn);
            ware.setCourseCode(arrange.getCourseCode());
            ware.setWareStatus(1);
            
            String basePath = webConfigService.getByKey(ConfigConstants.ATTACH_PATH).getV();
            String fileSeparator = System.getProperty("file.separator");

            if (attach.getOriginalFilename().contains(fileSeparator)) {
                return "<script type=\"text/javascript\">parent.uploadResult('3','"+fileSeparator+"');</script>";
            }
            
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            if (!attach.isEmpty()) {
                String relativePath = String.format("upload%sware%s%s%s%s%s%s", fileSeparator,
                        fileSeparator,arrange.getCourseCode(),fileSeparator,arrangeId, fileSeparator, attach.getOriginalFilename());
                
                File courseTargetAttach = new File(basePath + relativePath);
                IOHelper.makeDirs(courseTargetAttach);

                attach.transferTo(courseTargetAttach);

                ware.setWarePath(relativePath);
            }
            courseWareService.insertWare(ware);
            success = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            success = false;
        }
        
        if (success) {
            return "<script type=\"text/javascript\">parent.uploadResult('1','"+code+"');</script>";
        } else {
            return "<script type=\"text/javascript\">parent.uploadResult('0','"+code+"');</script>";
        }
        
    }

    
    @RequestMapping("ware.do")
    public String ware(HttpServletRequest request, Model model) {

        User user = super.getCurrentLoginUser(request);
        List<CourseArrange> courses = courseArrangeService.getActiveByProfesserId(user.getId());
        model.addAttribute("courses", courses);
        return "professor/ware";
    }
    
    @RequestMapping("wareDetail.do")
    public String wareDetail(HttpServletRequest request, Model model, Long arrangeId){
        
        List<CourseWare> warelist = courseWareService.getListByArrangeId(arrangeId);
        model.addAttribute("arrangeId",arrangeId);
        model.addAttribute("wares", warelist);
        return "professor/warelist";
    }
    
    @RequestMapping("delWare.do")
    public @ResponseBody JSONObject delWare(HttpServletRequest request, Model model, Long wareId){
        
        JSONObject json = new JSONObject();
        json.put("flag", 2);
        try {
            
            if (wareId != null) {
                CourseWare ware = courseWareService.getById(wareId);
                if (ware != null) {
                    courseWareService.disableById(wareId);
                    json.put("flag", 1);
                    json.put("code", ware.getCourseCode());
                }
                
            }
            
        } catch (Exception e) {
            logger.info("fahsengyichang!!!",e);
        }
        return json;
    }
    
    @RequestMapping("delAssign.do")
    public @ResponseBody JSONObject delAssign(HttpServletRequest request, Model model, Long assignId){
        
        JSONObject json = new JSONObject();
        json.put("flag", 2);
        try {
            
            if (assignId != null) {
                CourseHomeWorkAssign assign = courseHomeWorkAssignService.getById(assignId);
                if (assign != null) {
                    courseHomeWorkAssignService.disableById(assignId);
                    json.put("flag", 1);
                    json.put("code", assign.getCourseCode());
                }
                
            }
            
        } catch (Exception e) {
            logger.info("fahsengyichang!!!",e);
        }
        return json;
    }
    
    
    @RequestMapping("showAssignDetail.do")
    public String showAssignDetail(HttpServletRequest request, Model model, Long assignId){
        
        try {
            
            if (assignId != null) {
                CourseHomeWorkAssign assign = courseHomeWorkAssignService.getById(assignId);
                model.addAttribute("assign", assign);
            }
            
        } catch (Exception e) {
            logger.info("fahsengyichang!!!",e);
        }
        return "professor/assigndetail";
    }
    
    
    @RequestMapping("showAssignList.do")
    public String showAssignList(HttpServletRequest request, Model model, Long arrangeId){
        
        List<CourseHomeWorkAssign> assignList = courseHomeWorkAssignService.getAssignListByArrangeList(Arrays.asList(arrangeId));
        model.addAttribute("arrangeId",arrangeId);
        model.addAttribute("assignList", assignList);
        return "professor/assignlist";
    }
    
    @RequestMapping("saveAssign.do")
    @ResponseBody
    public String saveAssign(HttpServletRequest request, Model model, 
            @RequestParam(value="arrangeId", required = true)Long arrangeId,
            @RequestParam(value="workType", required = true)Integer workType,
            @RequestParam(value="workName", required = true)String workName,
            @RequestParam(value="workTotalScore", required = true)Integer workTotalScore,
            @RequestParam(value="deadLineTime", required = true)@DateTimeFormat(pattern="yyyy-MM-dd")Date deadLineTime,
            @RequestParam(value = "attach", required = false) MultipartFile attach,
            @RequestParam(value = "workDesc", required = false) String workDesc){
        
        boolean success = false;
        String code = "";

        if (attach.getSize() > maxFileByteSize) {
            return "<script type=\"text/javascript\">parent.uploadResult('2','"+code+"');</script>";
        }
        
        User user = getCurrentLoginUser(request);
        
        CourseArrange arrange = courseArrangeService.getByPrimaryKey(arrangeId.intValue());
        if (arrange != null && user != null) {
            try {
                CourseHomeWorkAssign courseHomeWorkAssign = new CourseHomeWorkAssign();
                courseHomeWorkAssign.setArrangeId(arrangeId);
                courseHomeWorkAssign.setWorkName(workName);
                courseHomeWorkAssign.setWorkStatus(1);
                courseHomeWorkAssign.setWorkType(workType);
                courseHomeWorkAssign.setCourseCode(arrange.getCourseCode());
                courseHomeWorkAssign.setCourseNameCn(arrange.getCourseNameCn());
                courseHomeWorkAssign.setCourseNameEn(arrange.getCourseNameEn());
                courseHomeWorkAssign.setDeadLineTime(deadLineTime);
                courseHomeWorkAssign.setWorkTotalScore(workTotalScore);
                courseHomeWorkAssign.setCreateTime(new Date());
                courseHomeWorkAssign.setUpdateTime(new Date());
                courseHomeWorkAssign.setWorkDesc(workDesc);
                courseHomeWorkAssign.setCreateUser(user.getId().longValue());
                courseHomeWorkAssign.setUpdateUser(user.getId().longValue());
                
                
                String basePath = webConfigService.getByKey(ConfigConstants.ATTACH_PATH).getV();
                String fileSeparator = System.getProperty("file.separator");
                
                String fileName = attach.getOriginalFilename();
                
                if (fileName.contains(fileSeparator)) {
                    return "<script type=\"text/javascript\">parent.uploadResult('3','"+fileSeparator+"');</script>";
                }
                
                if (!basePath.endsWith(fileSeparator)) {
                    basePath += fileSeparator;
                }
                
                if (!attach.isEmpty()) {
                    String relativePath = String.format("upload%shomework%s%s%s%s%s%s", fileSeparator,
                            fileSeparator,arrange.getCourseCode(),fileSeparator,arrangeId, fileSeparator, attach.getOriginalFilename());
                    
                    File courseTargetAttach = new File(basePath + relativePath);
                    IOHelper.makeDirs(courseTargetAttach);
                    
                    attach.transferTo(courseTargetAttach);
                    
                    courseHomeWorkAssign.setWorkPath(relativePath);
                }
                
                courseHomeWorkAssignService.insertAssign(courseHomeWorkAssign);
                success = true;
            } catch (Exception e) {
                logger.info("布置作业出错！",e);
                success = false;
            }
            
        }
        
        if (success) {
            return "<script type=\"text/javascript\">parent.uploadResult('1','"+code+"');</script>";
        } else {
            return "<script type=\"text/javascript\">parent.uploadResult('0','"+code+"');</script>";
        }
        
        
    }

    @RequestMapping("showCommitList.do")
    public String showCommitList(HttpServletRequest request, Model model, 
            @RequestParam(value="assignId", required = false, defaultValue = "0") Long assignId, 
            @RequestParam(value="name", required = false) String name, 
            @RequestParam(value="pageNo", required = false, defaultValue = "1") int pageNo, 
            @RequestParam(value="pageSize", required = false, defaultValue = "100") int pageSize){
        
        if ("".equals(name)) {
            name = null;
        }
        
        int count = courseHomeWorkCommitService.count(assignId, name);

        Pager<CourseHomeWorkCommit> pager = new Pager<CourseHomeWorkCommit>(pageNo, pageSize, count);
        
        if (count > 0) {
            List<CourseHomeWorkCommit> commitList = courseHomeWorkCommitService.search(assignId, name, pager.getStart(), pager.getPageSize());
            pager.setData(commitList);
        }
        
        model.addAttribute("assignId", assignId);
        model.addAttribute("name", name);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pager", pager);
        return "professor/commitList";
    }


}
