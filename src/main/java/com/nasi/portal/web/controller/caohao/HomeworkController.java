package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.data.model.CourseArrangeNew;
import com.nasi.portal.data.model.HomeWorkTask;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.CourseArrangeNewService;
import com.nasi.portal.service.HomeTaskService;
import com.nasi.portal.web.controller.caohao.DTO.HomeWorkTaskFront;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * created by xdCao on 2018/5/21
 */
@RequestMapping("/homework/professor")
@Controller
public class HomeworkController {

    @Autowired
    private CourseArrangeNewService courseArrangeNewService;

    @Autowired
    private HomeTaskService homeTaskService;

    @RequestMapping(value = "/arrangeList")
    @ResponseBody
    public JsonResult<?> getArrangeListByProId(@RequestParam("professorId") Integer id,
                                               @RequestParam("campusId") Long campusId){

        List<CourseArrangeNew> courseArrangeByProfessorId = courseArrangeNewService.getCourseArrangeByProfessorId(id,campusId);
        if (courseArrangeByProfessorId==null||courseArrangeByProfessorId.size()==0){
            return JsonResult.error("没有相关的课程安排");
        }else {
            return JsonResult.success(courseArrangeByProfessorId);
        }


    }

    @RequestMapping(value = "/attach/upload")
    @ResponseBody
    public JsonResult<?> attachUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"homework";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return JsonResult.success("/static/homework"+File.separator+filename);
        } else {
            return JsonResult.error("上传失败");
        }

    }

    @RequestMapping(value = "/add")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult<?> uploadHomeWork(@RequestParam("courseArrangeId") Long courseArrangeId,
                                        @RequestParam("courseId") Long courseId,
                                        @RequestParam("courseCode") String courseCode,
                                        @RequestParam("taskType") Integer taskType,
                                        @RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                        @RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
                                        @RequestParam(value = "attachUrl",required = false) String url,
                                        @RequestParam("desc") String desc,
                                        @RequestParam("totalScore") Integer totalScore,
                                        @RequestParam("professorId") Long professorId
                                        ){
//任务类型 1 作业 2 演讲 3 期中考试 4 期末考试

        if (taskType==1&&(url==null||url.equals("")))
            return JsonResult.error("作业安排请上传附件");

        HomeWorkTask homeWorkTask=new HomeWorkTask();
        homeWorkTask.setCreateTime(new Date());
        homeWorkTask.setCreateUser(professorId);
        homeWorkTask.setTaskArrangeId(courseArrangeId);
        homeWorkTask.setTaskCourseCode(courseCode);
        homeWorkTask.setTaskCourseId(courseId);
        homeWorkTask.setTaskDesc(desc);
        homeWorkTask.setTaskStartTime(startTime);
        homeWorkTask.setTaskEndTime(endTime);
        homeWorkTask.setTaskType(taskType);
        homeWorkTask.setTaskTotalScore(totalScore);
        homeWorkTask.setTaskAttachUrl(url);

        homeTaskService.addNewHomeTask(homeWorkTask);

        return JsonResult.success(homeWorkTask);

    }


    @RequestMapping(value = "/studentList")
    @ResponseBody
    public JsonResult<?> getStudentList(@RequestParam("campusId") Long campusId,
                                        @RequestParam("courseArrangeId") Long arrangeId){

        List<User> users=homeTaskService.getStudentListByCampusAndArrange(campusId,arrangeId);

        return JsonResult.success(users);

    }

    @RequestMapping(value = "/doneDetail")
    @ResponseBody
    public JsonResult<?> getDoneDetail(@RequestParam(value = "campusId",required = false) Long campusId,
                                       @RequestParam("courseArrangeId") Long arrangeId,
                                       @RequestParam("studentId") Long userId,
                                       @RequestParam("baseDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date baseDate){

        HashMap<String,List<HomeWorkTaskFront>> hashMap=homeTaskService.getDoneDetailWithBaseDate(campusId,arrangeId,userId,baseDate);

        return JsonResult.success(hashMap);

    }

    @RequestMapping(value = "/giveScore")
    @ResponseBody
    public JsonResult<?> giveScore(@RequestParam("userHomeWorkId") Long id,
                                   @RequestParam("score") Integer score){

        boolean b = homeTaskService.updateUserHomeWorkScore(id, score);

        if (b){
            return JsonResult.success(null,"操作成功");
        }else {
            return JsonResult.error("找不到对应数据");
        }


    }


    @RequestMapping(value = "/news")
    @ResponseBody
    public JsonResult<?> getNews(@RequestParam("professorId") Long id){
        List<HomeWorkTask> newsByProfessorId = homeTaskService.getNewsByProfessorId(id);
        if (newsByProfessorId==null||newsByProfessorId.size()==0){
            return JsonResult.error("没有与该教授相关的信息");
        }

        if (newsByProfessorId.size()<=2){
            return JsonResult.success(newsByProfessorId);
        }else {
            List<HomeWorkTask> list=new ArrayList<HomeWorkTask>();
            for (int i = 0; i < 2; i++) {
                list.add(newsByProfessorId.get(i));
            }
            return JsonResult.success(list);
        }


    }



}
