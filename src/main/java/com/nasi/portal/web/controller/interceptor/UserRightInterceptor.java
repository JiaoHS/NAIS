/**
 * @author anliyong@baidu.com
 * 2015-7-18 上午11:06:16
 */
package com.nasi.portal.web.controller.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nasi.portal.constant.SessionConstant;
import com.nasi.portal.data.model.User;

/**
 * @author anliyong@baidu.com
 * 2015-7-18上午11:06:16
 */
public class UserRightInterceptor implements HandlerInterceptor {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    private String denyPage;
    
    private Map<String, String> rightUrl;
    
    private String language = "/CN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(SessionConstant.CURRENT_LOGIN_USER);
        
        if (user == null) {
            redirect2login(request, response);
            return false;
        }
        
        String uri = request.getRequestURI();
        
        if (!uri.contains(rightUrl.get(String.valueOf(user.getRoleId())))) {
            redirect2login(request, response);
            return false;
        }
        
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
    }
    
    private void redirect2login(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        if (uri.startsWith("/EN")) {
            language = "/EN";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script type=\"text/javascript\">window.open('" + request.getContextPath() + this.language + this.denyPage
                    + "?gourl=" + request.getRequestURL() + "', '_top')</script>");
            out.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
        }
    }

    public String getDenyPage() {
        return denyPage;
    }

    public void setDenyPage(String denyPage) {
        this.denyPage = denyPage;
    }

    public Map<String, String> getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(Map<String, String> rightUrl) {
        this.rightUrl = rightUrl;
    }

}
