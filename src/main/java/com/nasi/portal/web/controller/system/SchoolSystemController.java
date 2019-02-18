package com.nasi.portal.web.controller.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.common.helper.ControllerHelper;
import com.nasi.portal.data.mapper.SchoolMapper;
import com.nasi.portal.data.model.School;
import com.nasi.portal.data.model.SchoolCriteria;
import com.nasi.portal.data.model.User;
import com.nasi.portal.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/school")
public class SchoolSystemController extends BaseController {

    @Resource
    private SchoolMapper schoolMapper;

    @RequestMapping(value = "/list")
    public String
            schoolList(@RequestParam(value = "schoolNameCn", required = false, defaultValue = "") String schoolNameCn,
                    @RequestParam(value = "schoolNameEn", required = false, defaultValue = "") String schoolNameEn,
                    Model model) {

        SchoolCriteria schoolCriteria = new SchoolCriteria();
        SchoolCriteria.Criteria criteria = schoolCriteria.createCriteria();

        criteria.andCreateTimeLessThanOrEqualTo(new Date());

        if (StringUtils.isNotBlank(schoolNameCn)) {
            criteria.andSchoolNameCnLike("%"+schoolNameCn+"%");
        }

        if (StringUtils.isNotBlank(schoolNameEn)) {
            criteria.andSchoolNameEnLike("%"+schoolNameEn+"%");
        }

        List<School> schools = schoolMapper.selectByExample(schoolCriteria);

        model.addAttribute("schools", schools);
        model.addAttribute("queryNameCn", schoolNameCn);
        model.addAttribute("queryNameEn", schoolNameEn);
        
        return "system/school/schoolList";

    }

    @RequestMapping(value = "/entryAddSchool")
    public String entryAddSchool() {
        return "system/school/schoolEdit";
    }

    @RequestMapping(value = "/edit")
    public String entrySchoolEdit(HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);
        School school = ControllerHelper.getBean(request, "school", School.class);

        if (school.getId() == null || school.getId() == 0) {
            school.setCreateUser(user.getId());
            school.setCreateTime(new Date());
            school.setUpdateUser(user.getId());
            school.setUpdateTime(new Date());

            schoolMapper.insertSelective(school);
        } else {
            school.setUpdateUser(user.getId());
            school.setUpdateTime(new Date());
            schoolMapper.updateByPrimaryKeySelective(school);
        }

        return "redirect:list";
    }

    @RequestMapping(value = "/show")
    public String entrySchoolEdit(Integer id, Boolean edit, Model model) {
        School school = schoolMapper.selectByPrimaryKey(id);
        model.addAttribute("school", school);
        if (edit) {
            return "system/school/schoolEdit";
        } else {
            return "system/school/schoolDetail";
        }
    }
    
    @RequestMapping(value = "/ajaxLoad")
    public @ResponseBody JSONObject ajaxLoad(HttpServletRequest request) {
        JSONObject json = new JSONObject();
        List<School> schools = schoolMapper.selectByExample(new SchoolCriteria());
        if (CollectionUtils.isNotEmpty(schools)) {
            json.put("flg", true);
            json.put("options", JSONArray.fromObject(schools));
            return json;
        }
        json.put("flg", false);
        return json;
    }
    

}
