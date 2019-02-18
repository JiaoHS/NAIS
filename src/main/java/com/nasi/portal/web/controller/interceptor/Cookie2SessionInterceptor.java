/**
 * @author anliyong@baidu.com
 * 2015-7-18 上午10:27:57
 */
package com.nasi.portal.web.controller.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nasi.portal.common.constants.CookieConstants;
import com.nasi.portal.constant.SessionConstant;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.UserService;

/**
 * @author anliyong@baidu.com
 * 2015-7-18上午10:27:57
 */
public class Cookie2SessionInterceptor implements HandlerInterceptor {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(SessionConstant.CURRENT_LOGIN_USER);
        
        if (user == null) {
            try {
                
                String userId = null;
                String email = null;
                String loginStatus = "0";

                Map<String, Cookie> cookies = readCookieMap(request);

                Cookie uidCookie = cookies.get(CookieConstants.LOGIN_USER_ID);

                if (uidCookie != null) {
                    userId = uidCookie.getValue();
                }

                Cookie emailCookie = cookies.get(CookieConstants.LOGIN_EMAIL);
                if (emailCookie != null) {
                    email = emailCookie.getValue();
                }

                Cookie loginStatusCookie = cookies.get(CookieConstants.LOGIN_STATUS);
                if (loginStatusCookie != null) {
                    loginStatus = loginStatusCookie.getValue();
                }

                if (userId != null && email != null && "1".equals(loginStatus)) {
                    WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
                    UserService userService = applicationContext.getBean(UserService.class);
                    user = userService.getByPrimaryKey(Integer.valueOf(userId));
                    if (user != null) {
                        session.setAttribute(SessionConstant.CURRENT_LOGIN_USER, user);
                    }
                }

            } catch (Exception e) {
                logger.error(e.getMessage(), e.fillInStackTrace());
            }

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

}
