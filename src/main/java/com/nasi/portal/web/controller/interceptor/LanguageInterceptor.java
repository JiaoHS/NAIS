/**
 * @author anliyong@baidu.com
 * 2015-6-23 下午10:59:53
 */
package com.nasi.portal.web.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nasi.portal.context.WebContext;

/**
 * @author anliyong@baidu.com 2015-6-23下午10:59:53
 */
public class LanguageInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        String language = WebContext.language.get();
        
        if(language == null) {
            return;
        }
        
        if (modelAndView == null) {
            return;
        }
        
        modelAndView.setViewName(language + "/" + modelAndView.getViewName());
        WebContext.language.remove();

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
