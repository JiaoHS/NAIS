/**
 * @author anliyong@baidu.com
 * 2015-5-31 下午5:56:43
 */
package com.nasi.portal.web.controller.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nasi.portal.common.helper.ControllerHelper;
import com.nasi.portal.data.mapper.CourseMapper;
import com.nasi.portal.data.model.Course;
import com.nasi.portal.data.model.CourseCriteria;
import com.nasi.portal.data.model.CourseCriteria.Criteria;
import com.nasi.portal.data.model.Pager;
import com.nasi.portal.data.model.User;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;

/**
 * @author anliyong@baidu.com 2015-5-31下午5:56:43
 */
@Controller
@RequestMapping("/system/course")
public class CourseController extends BaseController {

    @Resource
    private CourseMapper courseMapper;

    
    @RequestMapping(value = "/addCourse")
    @ResponseBody
    public JsonResult<?> addCourse(HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);
        Course course = ControllerHelper.getBean(request, "course", Course.class);

        if (StringUtils.isBlank(course.getCourseNameCn()) || StringUtils.isBlank(course.getCourseNameEn())
                || StringUtils.isBlank(course.getCourseCode())) {

            return JsonResult.error("课程中文名、课程英文名、课程编码不能为空！");

        }

        if (user == null) {
            return JsonResult.error("用户没有登录，不能录入课程系统！");
        }
        course.setCreateTime(new Date());
        course.setCreateUser(user.getId());
        course.setUpdateTime(new Date());
        course.setUpdateUser(user.getId());

        courseMapper.insert(course);

        return JsonResult.success("课程录入成功！");

    }

    @RequestMapping("/showAdd")
    public String showAdd(HttpServletRequest request, HttpServletResponse response) {

        return "system/course/courseAdd";
    }

    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "courseNameCn", required = false) String courseNameCn,
            @RequestParam(value ="courseNameEn", required = false) String courseNameEn,
            @RequestParam(value ="courseCode", required = false) String courseCode,
            @RequestParam(value ="pageNo", required = false) Integer pageNo,
            @RequestParam(value ="pageSize", required = false) Integer pageSize,
            HttpServletRequest request, HttpServletResponse response) {
        
        pageNo = pageNo == null ? 0 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        boolean sign = false;
        CourseCriteria courseCriteria = new CourseCriteria();
        Criteria criteria = courseCriteria.createCriteria();

        if (StringUtils.isNotBlank(courseNameCn)) {
            criteria.andCourseNameCnEqualTo(courseNameCn);
        }
        if (StringUtils.isNotBlank(courseNameEn)) {
            criteria.andCourseNameEnEqualTo(courseNameEn);
        }
        if (StringUtils.isNotBlank(courseCode)) {
            criteria.andCourseCodeEqualTo(courseCode);
        }

        Pager<Course> page = null;
        List<Course> list = null;
        ModelAndView view = new ModelAndView("system/course/courseList");

        int count = courseMapper.countByExample(courseCriteria);
        page = new Pager<Course>(pageNo, pageSize, count);

        courseCriteria.setStart(page.getStart());
        courseCriteria.setEnd(page.getPageSize());
        list = courseMapper.selectByExample(courseCriteria);
        page.setData(list);
        view.addObject("page", page);
        view.addObject("courseNameCn", courseNameCn);
        view.addObject("courseNameEn", courseNameEn);
        view.addObject("courseCode", courseCode);
        return view;
    }
    
    
    
    

    @RequestMapping("/courseEdit")
    public ModelAndView courseEdit(@RequestParam(value = "courseId", required = true) Integer courseId,
            HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("system/course/courseEdit");
        if (courseId == null) {
            return view;
        }
        Course course = courseMapper.selectByPrimaryKey(courseId);
        if (course != null) {
            view.addObject("course", course);
        }



        return view;
    }

    @RequestMapping("/delete/{courseId}")
    public JsonResult<?>
            delete(@PathVariable Integer courseId, HttpServletRequest request,
            HttpServletResponse response) {

        if (courseId == null) {
            return JsonResult.error("系统发生错误！");
        }
        int count = courseMapper.deleteByPrimaryKey(courseId);
        if (count == 1) {
            return JsonResult.success("删除成功！");
        } else {
            return JsonResult.success("删除失败！");
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public JsonResult<?> edit(@RequestParam("courseId") Integer courseId,
            @RequestParam("courseNameCn") String courseNameCn,
            @RequestParam("courseNameEn") String courseNameEn, @RequestParam("courseCode") String courseCode,
            @RequestParam("courseDescCn") String courseDescCn, @RequestParam("courseDescEn") String courseDescEn) {

        if (courseId == null) {
            return JsonResult.error("系统发生错误！");
        }

        Course course = courseMapper.selectByPrimaryKey(courseId);

        if (course != null) {
            String oldCourseNameCn = course.getCourseNameCn();
            boolean sign = false;
            if (!oldCourseNameCn.equals(courseNameCn)) {
                sign = true;
                course.setCourseNameCn(courseNameCn);
            }

            String oldCourseNameEn = course.getCourseNameEn();
            if (!oldCourseNameEn.equals(courseNameEn)) {
                sign = true;
                course.setCourseNameEn(courseNameEn);
            }

            String oldCourseCode = course.getCourseCode();
            if (!oldCourseCode.equals(courseCode)) {
                sign = true;
                course.setCourseCode(courseCode);
            }

            String oldCourseDescCn = course.getCourseDescCn();
            if (!oldCourseDescCn.equals(courseDescCn)) {
                sign = true;
                course.setCourseDescCn(courseDescCn);
            }

            String oldCourseDescEn = course.getCourseDescEn();
            if (!oldCourseDescEn.equals(courseDescEn)) {
                sign = true;
                course.setCourseDescEn(courseDescEn);
            }

            if (!sign) {
                return JsonResult.error("无任何修改！");
            } else {
                int count = courseMapper.updateByPrimaryKey(course);
                if (count == 1) {
                    return JsonResult.success("修改成功！");
                } else {
                    return JsonResult.error("修改失败！");
                }
            }
        } else {
            return JsonResult.error("查询不到所编辑的课程！");
        }
    }
    
    
    @RequestMapping(value="/ajaxLoad")
    public @ResponseBody JSONObject ajaxLoad(){
        JSONObject json = new JSONObject();
        
        CourseCriteria courseCriteria = new CourseCriteria();
        courseCriteria.createCriteria();
        
        List<Course> course = courseMapper.selectByExample(courseCriteria);
        
        if (CollectionUtils.isNotEmpty(course )) {
            json.put("flg", true);
            json.put("options", JSONArray.fromObject(course));
            return json;
        }
        json.put("flg", false);
        return json;
    }

}
