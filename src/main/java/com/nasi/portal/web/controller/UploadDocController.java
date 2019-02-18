package com.nasi.portal.web.controller;

import com.nasi.portal.web.model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * @auther coraljiao
 * @date 2019/1/14 15:42
 * @description
 */
@Controller
@RequestMapping("/upload")
public class UploadDocController {


    @RequestMapping(value = "/file")
    @ResponseBody
    public JsonResult<?> imgUpload(@RequestParam MultipartFile uploadFile, HttpServletRequest request) throws IOException {

        //如果文件不为空，写入上传路径
        if(!uploadFile.isEmpty()) {
            //上传文件名
            String filename = uploadFile.getOriginalFilename();
            //获取上传文件的后缀
            String suffix=filename.substring(filename.lastIndexOf(".")+1);

            String path=null;
            if (suffix.equals("pdf") ||suffix.equals("doc")||suffix.equals("docx")){
                //上传文件路径
                path=request.getSession().getServletContext().getRealPath("static")+ File.separator+"files";
            }else {
                //上传图片路径
                //path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"images";
                return JsonResult.error("上传文件格式不对!");
            }
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            uploadFile.transferTo(new File(path + File.separator + filename));
            return JsonResult.success("/static/files" + File.separator + filename);
        } else {
            return JsonResult.error("上传文件失败");
        }

    }





    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/fileUpload2")
    public JsonResult<?> fileUpload2(@RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
        System.out.println("fileName："+uploadFile.getOriginalFilename());
        String path="E:/"+new Date().getTime()+uploadFile.getOriginalFilename();

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        uploadFile.transferTo(newFile);
        return JsonResult.error("ok");
    }

    @RequestMapping(value = "/doc/upload",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<?> springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    //上传文件路径
                    String path = request.getSession().getServletContext().getRealPath("static") + File.separator + "doc";
                    //上传文件名
                    String filename = file.getOriginalFilename();
                    File filepath = new File(path, filename);
                    //判断路径是否存在，如果不存在就创建一个
                    if (!filepath.getParentFile().exists()) {
                        filepath.getParentFile().mkdirs();
                    }
                    //上传
                    try {
                        file.transferTo(new File(path + File.separator + filename));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return JsonResult.error("上传文件失败");
                    }
                    return JsonResult.success("/static/doc" + File.separator + filename);
                }else {
                    return JsonResult.error("上传文件失败");
                }
            }
            return JsonResult.error("上传文件失败");
        } else {
            return JsonResult.error("上传文件失败");
        }
    }


//    @RequestMapping(value = "/doc/upload")
//    @ResponseBody
//    public JsonResult<?> imgUpload(@RequestParam("fuImportMultipleShipmentStatus") MultipartFile file, HttpServletRequest request){
//
//        //如果文件不为空，写入上传路径
//        if(!file.isEmpty()) {
//            //上传文件路径
//            String path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"doc";
//            //上传文件名
//            String filename = file.getOriginalFilename();
//            File filepath = new File(path,filename);
//            //判断路径是否存在，如果不存在就创建一个
//            if (!filepath.getParentFile().exists()) {
//                filepath.getParentFile().mkdirs();
//            }
//            //将上传文件保存到一个目标文件当中
//            try {
//                file.transferTo(new File(path + File.separator + filename));
//            } catch (IOException e) {
//                e.printStackTrace();
//                return JsonResult.error("上传文件失败");
//            }
//            return JsonResult.success("/static/doc"+File.separator+filename);
//        } else {
//            return JsonResult.error("上传失败");
//        }
//
//    }
}
