package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.web.model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * created by xdCao on 2018/4/23
 */
@Controller
public class UploadController {


    @RequestMapping(value = "/pic/upload")
    @ResponseBody
    public PictureResult imgUpload(@RequestParam MultipartFile uploadFile, HttpServletRequest request) throws IOException {

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
                path = request.getSession().getServletContext().getRealPath("static")+ File.separator+"images";
            }
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            uploadFile.transferTo(new File(path + File.separator + filename));
            PictureResult result=new PictureResult();
            if (suffix.equals("pdf") ||suffix.equals("doc")||suffix.equals("docx")){
                result.setError(0);
                result.setUrl("/static/files/"+filename);
            }else {
                result.setError(0);
                result.setUrl("/static/images/"+filename);
            }
            return result;
        } else {
            PictureResult result=new PictureResult();
            result.setError(1);
            result.setUrl(null);
            result.setMessage("上传失败");
            return result;
        }

    }

}
