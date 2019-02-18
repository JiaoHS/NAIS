package com.nasi.portal.web.controller.huanghe;

import com.nasi.portal.common.helper.EncryptHelper;
import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.Professor;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.ProfessorService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * created by River on 2018/4/18
 *
 */
@Controller
@RequestMapping("/professor")
public class Professor1Controller extends BaseController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show/list", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<?> professorList() {
        List<Professor> professorList = professorService.getAll();
        if (professorList == null){
            return JsonResult.error("教授列表为空");
        }
        Collections.sort(professorList, new Comparator<Professor>() {
            @Override
            public int compare(Professor o1, Professor o2) {
                return o1.getCreateTime().compareTo(o2.getCreateTime());
            }
        });
        if (professorList.size() < 8){
            return JsonResult.success(professorList);
        }
        List<Professor> professors = new ArrayList<Professor>();
        for (int i = 0; i < 8; i++) {
            professors.add(professorList.get(professorList.size() - i-1));
        }
        return JsonResult.success(professors);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonResult<?> addProfessor(@RequestParam("professorName") String professorName,
                                      @RequestParam("fromSchool") String fromSchool,
                                      @RequestParam("description") String description,
                                      @RequestParam("photo") String photo){
        Professor professor=new Professor();
        professor.setProfessorName(professorName);
        professor.setFromSchool(fromSchool);
        professor.setDescription(description);
        professor.setPhoto(photo);
        professor.setCreateTime(new Date());
        professor.setUpdateTime(new Date());

        professorService.insertProfessor(professor);

        return JsonResult.success(null);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult<?> deleteProfessor(@RequestParam("id") Long id){
        try {
            professorService.deleteBy(id);
            return JsonResult.success(null,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("删除教授失败");
        }

    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public JsonResult<?> deleteBatchInfo(@RequestParam String ids){
        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                professorService.deleteBy(id);
            }
            return JsonResult.success(null,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("删除失败");
        }
    }


    @RequestMapping(value = "/show/single")
    @ResponseBody
    public JsonResult<?> showInfoById(@RequestParam("id") Long id){

        Professor professor = professorService.showProfessor(id);

        if (professor!=null){
            return JsonResult.success(professor);
        }else {
            return JsonResult.error(null);
        }
    }

    @RequestMapping(value = "/find")
    @ResponseBody
    public DataGridResult findInfoList(@RequestParam(value = "professorName",required = false) String professorName,
                                       @RequestParam(value = "fromSchool",required = false) String fromSchool,
                                       @RequestParam(value = "page") Integer page,
                                       @RequestParam(value = "rows") Integer rows){

        DataGridResult professorListByPage=null;

        if ((professorName == null || professorName.equals("")) && (fromSchool == null ||fromSchool.equals(""))){
            professorListByPage = professorService.getProfessorListByPage(page,rows);
            return professorListByPage;
        }else if ((fromSchool == null ||fromSchool.equals(""))){
            professorListByPage = professorService.findProfessorListPageByName(professorName,page,rows);
            return professorListByPage;
        }else if ((professorName == null || professorName.equals(""))){
            professorListByPage = professorService.findProfessorListPageBySchool(fromSchool,page,rows);
            return professorListByPage;
        }else {
            professorListByPage = professorService.findProfessorListPageWithProfessorNameAndSchool(professorName,fromSchool,page,rows);
            return professorListByPage;
        }
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonResult<?> updateInfo(@RequestParam("professorName") String professorName,
                                    @RequestParam("fromSchool") String fromSchool,
                                    @RequestParam("description") String description,
                                    @RequestParam("photo") String photo,
                                    @RequestParam("id") Long id){

        Professor professor = professorService.showProfessor(id);
        professor.setProfessorName(professorName);
        professor.setPhoto(photo);
        professor.setFromSchool(fromSchool);
        professor.setDescription(description);
        professor.setUpdateTime(new Date());

        //获取professor的登录邮箱和密码
        User user= userService.selectUserByProfessorName(id);

        professorService.updateProfessor(professor);
        return JsonResult.success(professor);

    }

    @RequestMapping(value = "/img/upload")
    @ResponseBody
    public JsonResult<?> imgUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"images";
            //上传文件名(防止文件重名)
            String filename = file.getOriginalFilename()+System.currentTimeMillis();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return JsonResult.success("/static/images"+File.separator+filename);
        } else {
            return JsonResult.error("上传失败");
        }

    }

    /**
     * 生成教授登录账号
     * @param id :教授id
     * @return
     */
    @RequestMapping(value = "/createProfessNum")
    @ResponseBody
    public JsonResult<?> createProfessorNumber(@RequestParam("id") String id){

        Long professorId=Long.parseLong(id);
        User user1= userService.selectUserByProfessorName(professorId);
        if (user1 == null){
            User user=new User();
            user.setRoleId(1);
            user.setActive(1);
            user.setEmail("nais_professor_"+id+"@2018.com");
            user.setNameCn("nais_professor_"+id+"_2018");
            user.setNameEn("nais_professor_"+id+"_2018");
            user.setPassword(EncryptHelper.encryptMD5("nais_professor_"+id+"_2018"));
            user.setProfessorId(professorId);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());

            userService.insertOrUpdate(user);
            return JsonResult.success(null);
        }else {
            return new JsonResult(2,null,null);
        }

    }

    /**
     *
     */
    @RequestMapping(value = "/findUserByPrefessorId")
    @ResponseBody
    public JsonResult<?> findUserByPrefessorId(@RequestParam("id") String id){

        Long professorId=Long.parseLong(id);
        User user= userService.selectUserByProfessorName(professorId);
        return JsonResult.success(user);
    }






}
