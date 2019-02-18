package com.nasi.portal.web.controller.huanghe;

import com.nasi.portal.data.model.ProfessorMsg;
import com.nasi.portal.service.ProfessorService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: River
 * @Date:Created in  10:40 2018/4/20
 * @Description:
 */
@Controller
@RequestMapping("/professorList")
public class ProfessorListController extends BaseController {

    @Autowired
    private ProfessorService professorService;
    @RequestMapping("/professorhome")
    public String campushome() {
        return "teachers/teachers";
    }
    @RequestMapping("/all")
    @ResponseBody
    public JsonResult<?> findAllProfessorList(@RequestParam(value = "schoolId",required = false) Integer schoolId,
                                              @RequestParam(value = "page") Integer page,
                                              @RequestParam(value = "rows") Integer rows){

        JsonResult<?> professorMsg = professorService.getProfessorListAll(schoolId,page,rows);
        if(professorMsg==null){
            return JsonResult.error("教授信息为空");
        }
        return  professorMsg;
    }

}
