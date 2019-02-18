package com.nasi.portal.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nasi.portal.data.mapper.CourseArrangeMapper;
import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.CourseHomeWorkAssign;
import com.nasi.portal.data.model.CourseHomeWorkCommit;
import com.nasi.portal.data.model.CourseWare;
import com.nasi.portal.service.CourseHomeWorkAssignService;
import com.nasi.portal.service.CourseHomeWorkCommitService;
import com.nasi.portal.service.CourseWareService;
import com.nasi.portal.service.WebConfigService;

@Controller
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private CourseArrangeMapper courseArrangeMapper;
    
    @Autowired
    private CourseWareService courseWareService;
    
    @Autowired
    private CourseHomeWorkAssignService assignService;
    
    @Autowired
    private CourseHomeWorkCommitService commitService;
    
    @RequestMapping("/arrangAttachment")
    public String arrangAttachment(Integer id, HttpServletResponse response) {
        try {
            CourseArrange arrange = courseArrangeMapper.selectByPrimaryKey(id);
            String path = arrange.getAttachPath();
            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();

            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            String filePath = basePath + path;

            File file = new File(filePath);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping("/courseWare")
    public String courseWare(Long id, HttpServletResponse response) {
        try {
            CourseWare courseWare = courseWareService.getById(id);
            String path = courseWare.getWarePath();
            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();

            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            String filePath = basePath + path;

            File file = new File(filePath);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping("/homeWorkAssign")
    public String homeWorkAssign(Long id, HttpServletResponse response) {
        try {
            
            CourseHomeWorkAssign assign  = assignService.getById(id);
            String path = assign.getWorkPath();
            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();

            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            String filePath = basePath + path;

            File file = new File(filePath);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping("/homeWorkCommit")
    public String homeWorkCommit(Long id, HttpServletResponse response) {
        try {
            
            CourseHomeWorkCommit commit  = commitService.getById(id);
            String path = commit.getCommitPath();
            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();

            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            String filePath = basePath + path;

            File file = new File(filePath);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}