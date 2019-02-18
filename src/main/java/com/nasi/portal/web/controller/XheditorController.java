/**
 * 
 */
package com.nasi.portal.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nasi.portal.common.helper.EscapeHelper;
import com.nasi.portal.common.helper.IOHelper;

/**
 * @author anly
 *
 */
@Controller
@RequestMapping(value = "/xheditor")
public class XheditorController extends BaseController {
	
	private Log logger = LogFactory.getLog(getClass());
	
	private final String IMAGES_PATH = "upload/images/";
	private final String ATTACHMENT_PATH = "upload/attachment/";
	private final String HYPERLINK_PATH = "upload/hyperlink/";

	@RequestMapping(value = "/uploadImg")
	public void uploadImg(HttpServletRequest request, HttpServletResponse response) {
		String path = this.IMAGES_PATH;
		upload(request, response, path);
	}
	
	@RequestMapping(value = "/uploadAttachment")
	public void uploadAttachment(HttpServletRequest request, HttpServletResponse response) {
		String path = this.ATTACHMENT_PATH;
		upload(request, response, path);
	}
	
	@RequestMapping(value = "/uploadHyperlink")
	public void uploadHyperlink(HttpServletRequest request, HttpServletResponse response) {
		String path = this.HYPERLINK_PATH;
		upload(request, response, path);
	}
	
	public void upload(HttpServletRequest request, HttpServletResponse response, String relativePath) {
		
		String immediate = request.getParameter("immediate");
		
		StringBuffer requestURL = request.getRequestURL();  
		String webURL = requestURL.delete(requestURL.length() - request.getRequestURI().length(), requestURL.length()).append(request.getContextPath()).append("/").toString(); 
		
		String webPath = request.getSession().getServletContext().getRealPath("/");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("err", "");
		
		boolean uploadFail = false;
		
		String url = webURL;
		
		if ("application/octet-stream".equals(request.getContentType())) { // HTML5上传
			try {
				
				String dispoString = request.getHeader("Content-Disposition");
				int iFindStart = dispoString.indexOf("name=\"") + 6;
				int iFindEnd = dispoString.indexOf("\"", iFindStart);
				iFindStart = dispoString.indexOf("filename=\"") + 10;
				iFindEnd = dispoString.indexOf("\"", iFindStart);
				String fileName = dispoString.substring(iFindStart, iFindEnd);
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				
				int i = request.getContentLength();
				byte buffer[] = new byte[i];
				int j = 0;
				while (j < i) { // 获取表单的上传文件
					int k = request.getInputStream().read(buffer, j, i - j);
					j += k;
				}
				
				String generateFileName = System.currentTimeMillis() + "-" + IOHelper.getByteMD5(buffer) + suffix;
				
				File desc = new File(webPath + relativePath + generateFileName);
				
				IOHelper.makeDirs(desc);
				
				OutputStream out = new BufferedOutputStream(new FileOutputStream(desc));
				
                out.write(buffer);
                out.close();
                
                url = url + relativePath + generateFileName;
			} catch (Exception e) {
				uploadFail = true;
				e.printStackTrace();
			}
			
		} else {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
			MultipartFile multipartFile = multipartRequest.getFile("filedata");
			try {
				
				String fileName = multipartFile.getOriginalFilename();
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				
				String generateFileName = System.currentTimeMillis() + "-" + IOHelper.getByteMD5(multipartFile.getBytes()) + suffix;
				
				File desc = new File(webPath + relativePath + generateFileName);
				
				IOHelper.makeDirs(desc);
				
				multipartFile.transferTo(new File(webPath + relativePath + generateFileName));
				
				url = url + relativePath + generateFileName;
				
			} catch (IllegalStateException e) {
				uploadFail = true;
				logger.error(e.getMessage());
			} catch (IOException e) {
				uploadFail = true;
				logger.error(e.getMessage());
			}
		}
		
		if(uploadFail) {
			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
			WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
			jsonObject.put("err", EscapeHelper.escape(applicationContext.getMessage("xheditor.upload.fail.msg", null, locale)));
		}
		
		if ("1".equals(immediate)) {
			jsonObject.put("msg", "!" + url);
		} else {
			jsonObject.put("msg", url);
		}
		
		super.response2Client(response, jsonObject.toString());
		
	}
	
}
