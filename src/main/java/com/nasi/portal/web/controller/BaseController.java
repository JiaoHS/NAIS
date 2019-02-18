/**
 *
 */
package com.nasi.portal.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nasi.portal.constant.SessionConstant;
import com.nasi.portal.data.model.User;

/**
 * @author anliyong
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    protected String getAppBaseUrl(HttpServletRequest request) {

        String path = request.getContextPath();

        StringBuffer url = new StringBuffer();

        url.append(request.getScheme());
        url.append("://");
        url.append(request.getServerName());

        if (!(("http".equalsIgnoreCase(request.getScheme()) && 80 == request.getServerPort()) || ("https"
                .equalsIgnoreCase(request.getScheme())) && 443 == request.getServerPort())) {
            url.append(":" + request.getServerPort());
        }

        if (!"/".equals(path)) {
            url.append(path);
        }

        url.append("/");

        return url.toString();
    }

    /**
     * 设置cookie
     * 
     * @param response
     * @param name cookie名字
     * @param value cookie值
     * @param maxAge acookie生命周期 以秒为单位 (-1浏览器关闭立即失效)
     */
    protected void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
            int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");

        cookie.setMaxAge(maxAge);

        // String domain = request.getServerName();
        //
        // if (domain.matches(".+?[a-zA-z]*.*")) {
        // cookie.setDomain(domain.replaceAll("(.+?\\.)?([^\\.]+?\\.[^\\.]+?$)",
        // "$2"));
        // }

        response.addCookie(cookie);
    }

    /**
     * 根据名字获取cookie
     * 
     * @param request
     * @param name cookie名字
     * 
     * @return
     */
    protected Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     * 
     * @param request
     * 
     * @return
     */
    protected Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 获取IP地址
     * 
     * @param request
     * 
     * @return
     */
    protected static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("Cdn-Src-Ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_REAL_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        return ip;
    }

    protected int getPageNo(Map<String, String> map) {

        int pageNo = 1;

        if (map.containsKey("pageNo")) {
            String pageNoStr = map.get("pageNo");
            if (pageNoStr != null && !"".equals(pageNoStr.trim())) {
                pageNo = Integer.valueOf(pageNoStr);
            }
        }

        pageNo = pageNo <= 0 ? 1 : pageNo;

        return pageNo;
    }

    protected int getPageSize(Map<String, String> map) {

        int pageSize = 20;

        if (map.containsKey("pageSize")) {
            String pageNoStr = map.get("pageSize");
            if (pageNoStr != null && !"".equals(pageNoStr.trim())) {
                pageSize = Integer.valueOf(pageNoStr);
            }
        }

        pageSize = pageSize <= 0 ? 20 : pageSize;

        return pageSize;
    }
    
    protected void response2Client(HttpServletResponse response, String content) {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;

        logger.info("response content -->" + content);

        try {
            out = response.getWriter();
            out.print(content);
            out.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
        }

    }
    
    protected User getCurrentLoginUser(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(SessionConstant.CURRENT_LOGIN_USER);
        return user;
    }
    
    protected void printAlertAndRefresh(HttpServletResponse response, String message, String callBackReq){
        
        PrintWriter out ;
        
        try {
            out = response.getWriter();
            
            out.println("<html>");  
            out.println("<script>");
            out.println("alert('" + message + "'); ");
            out.println("window.location = '"+ callBackReq +"'");  
            out.println("</script>");  
            out.println("</html>");  
        } catch (IOException e) {
            logger.error("alert e ",e);
        }
    }
    
    
}
