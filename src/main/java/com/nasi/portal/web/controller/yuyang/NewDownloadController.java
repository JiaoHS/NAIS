package com.nasi.portal.web.controller.yuyang;

import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by yy on 2018-05-25.
 */

@Controller
@RequestMapping(value = "/newDownload")
public class NewDownloadController extends BaseController {
    @RequestMapping(value = "/pull")
    @ResponseBody
    public JsonResult download(@RequestParam("path") String path,
                               HttpServletRequest request,
                               HttpServletResponse response){

        String rootPath = request.getSession().getServletContext().getRealPath("");

        rootPath+=path;
        System.out.println(rootPath);
        try {
            // path取自数据库里的路径
            File file = new File(rootPath);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(rootPath));
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
