package com.nasi.portal.web.controller.yuyang;

import com.nasi.portal.data.model.HomeWorkTask;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.UserHomeWork;
import com.nasi.portal.service.HomeWorkService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.controller.caohao.DTO.HomeWorkTaskFront;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.StuInfo;
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
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yy on 2018-05-26.
 */

@Controller
@RequestMapping(value = "/homeWork/student")
public class HomeWorkController extends BaseController {
    @Autowired
    private HomeWorkService homeWorkService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/myCourse")
    @ResponseBody
    public DataGridResult showMyCourse(@RequestParam(value = "page") Integer page,
                                       @RequestParam(value = "rows") Integer rows,
                                       @RequestParam("campusId") Long campusId,
                                       @RequestParam("studentId") Long studentId,
                                       HttpServletRequest request){
        DataGridResult courseRst=null;
        /*User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());*/
        courseRst=homeWorkService.showMyCourses(studentId,campusId,page,rows);
        return courseRst;
    }

    @RequestMapping(value = "/stuInfo")
    @ResponseBody
    public JsonResult getStudentInfo(@RequestParam("campusId") Long campusId,
                                     @RequestParam("studentId") Long studentId,
                                     HttpServletRequest request){
        /*User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());*/
        List<StuInfo>list=homeWorkService.getStuInfo(campusId,studentId);
        return JsonResult.success(list);
    }

    @RequestMapping(value = "/doneDetail")
    @ResponseBody
    public JsonResult<?> getDoneDetail(@RequestParam(value = "campusId",required = false) Long campusId,
                                       @RequestParam("courseArrangeId") Long courseArrangeId,
                                       @RequestParam("studentId") Long studentId,
                                       @RequestParam("baseDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date baseDate){

        HashMap<String,List<HomeWorkTaskFront>> hashMap=homeWorkService.getDoneDetailsWithBaseDate(campusId,courseArrangeId,studentId,baseDate);

        return JsonResult.success(hashMap);

    }


    @RequestMapping(value = "/attach/upload")
    @ResponseBody
    public JsonResult<?> attachUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"stuhomework";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return JsonResult.success("/static/stuhomework"+File.separator+filename);
        } else {
            return JsonResult.error("上传失败");
        }

    }

    @RequestMapping(value = "/add")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult<?> uploadHomeWork(@RequestParam("courseId") Long courseId,
                                        @RequestParam("courseCode") String courseCode,
                                        @RequestParam("taskId") Long taskId,
                                        @RequestParam(value = "attachUrl",required = false) String url,
                                        @RequestParam("desc") String desc,
                                        @RequestParam("taskType") Integer taskType,
                                        @RequestParam("studentId") Long studentId,
                                        HttpServletRequest request){
        //任务类型 1 作业 2 演讲 3 期中考试 4 期末考试
        if (taskType==1&&(url==null||url.equals("")))
            return JsonResult.error("作业安排请上传附件");

        /*User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());*/

        int score=homeWorkService.getTotalScore(taskId);

        UserHomeWork record =new UserHomeWork();
        record.setTaskCourseId(courseId);
        record.setTaskCourseCode(courseCode);
        record.setTaskId(taskId);
        record.setTaskStatius(1);
        record.setTaskSubmitUrl(url);
        record.setTaskSubmitDesc(desc);
        record.setSubmitTime(new Date());
        record.setCreateTime(new Date());
        record.setTaskTotalScore(score);
        record.setCreateUser(studentId);
        homeWorkService.saveUserHomeWork(record);
        return JsonResult.success(record);
    }

    @RequestMapping(value = "/notices")
    @ResponseBody
    public JsonResult getNotices(@RequestParam(value = "campusId") Long campusId,
                                 @RequestParam("studentId") Long studentId,
                                 HttpServletRequest request){
        /*User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());*/
        List<HomeWorkTask>list=homeWorkService.getNotices(studentId,campusId);
        if(list==null||list.size()==0){
            return JsonResult.error("no notices");
        }else{
            return JsonResult.success(list);
        }
    }

    @RequestMapping(value = "/download")
    @ResponseBody
    public JsonResult download(@RequestParam("path") String path,
                               HttpServletResponse response){
        try {
            // path指的是完整路径
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return JsonResult.error("success");
    }


}
