package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.data.model.Info;
import com.nasi.portal.service.InfoService;
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
import java.util.Date;
import java.util.List;

/**
 * created by xdCao on 2018/4/18
 */
@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/show/list")
    @ResponseBody
    public JsonResult<?> showInfoList(){
        List<Info> infoList = infoService.getInfoList();
        if (infoList!=null&&infoList.size()>0)
            return JsonResult.success(infoList);
        else
            return JsonResult.error("资讯列表为空");
    }

    @RequestMapping(value = "/show/list/limit")
    @ResponseBody
    public JsonResult<?> showInfoListLimit(@RequestParam("limit") Integer limit){
        List<Info> infoListLimit = infoService.getInfoListLimit(limit);
        if (infoListLimit!=null&&infoListLimit.size()>0)
            return JsonResult.success(infoListLimit);
        else
            return JsonResult.error("资讯列表为空");

    }

    @RequestMapping(value = "/show/single")
    @ResponseBody
    public JsonResult<?> showInfoById(@RequestParam("id") Long id){

        Info info = infoService.showInfo(id);
        if (info!=null){
            return JsonResult.success(info);
        }else {
            return JsonResult.error(null);
        }

    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonResult<?> addInfo(@RequestParam("title") String title,
                                 @RequestParam("titleImg") String titleImg,
                                 @RequestParam("desc") String desc,
                                 @RequestParam("content") String content){
        Info info=new Info();
        info.setTitle(title);
        info.setTitleImg(titleImg);
        info.setDescInfo(desc);
        info.setContent(content);
        info.setCreateTime(new Date());
        info.setUpdateTime(new Date());

        infoService.insertInfo(info);

        return JsonResult.success(null);

    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonResult<?> updateInfo(@RequestParam("id") Long id,
                                    @RequestParam("title") String title,
                                    @RequestParam("titleImg") String titleImg,
                                    @RequestParam("desc") String desc,
                                    @RequestParam("content") String content){

        Info info = infoService.showInfo(id);

        info.setTitleImg(titleImg);
        info.setTitle(title);
        info.setDescInfo(desc);
        info.setContent(content);
        info.setUpdateTime(new Date());

        infoService.updateInfo(info);


        return JsonResult.success(info);

    }



    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult<?> deleteInfo(@RequestParam("id") Long id){
        try {
            infoService.deleteInfo(id);
            return JsonResult.success(null,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("删除资讯失败");
        }
    }

    @RequestMapping(value = "/batchDelete")
    @ResponseBody
    public JsonResult<?> deleteBatchInfo(@RequestParam String ids){

        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                infoService.deleteInfo(id);
            }
            return JsonResult.success(null,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("删除失败");
        }


    }

    @RequestMapping(value = "/show/page")
    @ResponseBody
    public JsonResult<?> showByPage(@RequestParam("page") Integer page,
                                    @RequestParam("rows") Integer rows){

        return infoService.getInfoListByPage(page,rows);

    }

    @RequestMapping(value = "/admin/show/page")
    @ResponseBody
    public DataGridResult showByPageAdmin(@RequestParam("page") Integer page,
                                          @RequestParam("rows") Integer rows){

        return infoService.getInfoByPage(page,rows);

    }

    @RequestMapping(value = "/img/upload")
    @ResponseBody
    public JsonResult<?> imgUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static")+File.separator+"images";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return JsonResult.success("/static/images/"+File.separator+filename);
        } else {
            return JsonResult.error("上传失败");
        }

    }


    @RequestMapping(value = "/find")
    @ResponseBody
    public DataGridResult findInfoList(@RequestParam(value = "title",required = false) String title,
                                      @RequestParam(value = "date",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                      @RequestParam(value = "page") Integer page,
                                      @RequestParam(value = "rows") Integer rows){

        System.out.println(" "+title+" "+date+" "+page+" "+rows);

        DataGridResult infoListByPage =null;

        if ((title==null||title.equals(""))&&date==null){
            infoListByPage = infoService.getInfoByPage(page, rows);
            return infoListByPage;
        }else if (title==null||title.equals("")){
            infoListByPage=infoService.findInfoListPageByDate(date,page,rows);
            return infoListByPage;
        }else if (date==null){
            infoListByPage=infoService.findInfoListPageByTitle(title,page,rows);
            return infoListByPage;
        }else {
            infoListByPage=infoService.findInfoListPageWithTitleAndDate(title,date,page,rows);
            return infoListByPage;
        }



    }

    @RequestMapping("/infoList")
    public String infoList() {
        return "informationAndActivity/informationList";
    }
    @RequestMapping("/infoDetail")
    public String infoDetail() {
        return "informationAndActivity/information";
    }
    @RequestMapping("/activity")
    public String activity() {
        return "informationAndActivity/activity";
    }

}
