/**
 * @author anliyong@baidu.com
 * 2015-6-23 下午10:10:19
 */
package com.nasi.portal.web.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nasi.portal.common.constants.CookieConstants;
import com.nasi.portal.context.WebContext;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author anliyong@baidu.com
 * 2015-6-23下午10:10:19
 */
@Controller
public class HomeController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/indexhome")
    public String indexhome() {
        return "indexhome";
    }
    @RequestMapping(value = "/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }
    @RequestMapping(value = "/application")
    public String application() {
        return "applicationInformation/application";
    }
    @RequestMapping(value = "/normalQuestion")
    public String normalQuestion() {
        return "applicationInformation/normalQuestion";
    }
    //@RequestMapping("/home")
    //public String index (HttpServletRequest request, HttpServletResponse response) {
    //
    //    String language = null;
    //
    //    Cookie cookie = getCookieByName(request, CookieConstants.USER_LANGUAGE);
    //
    //    if (cookie != null) {
    //        language = cookie.getValue();
    //    } else {
    //        language = request.getLocale().getLanguage();
    //        if (language.toLowerCase().contains("en")) {
    //            language = "EN";
    //        } else {
    //            language = "CN";
    //        }
    //        addCookie(request, response, CookieConstants.USER_LANGUAGE, language, Integer.MAX_VALUE);
    //    }
    //
    //    if ("EN".equals(language)) {
    //        return "redirect:EN/home.html";
    //    } else {
    //        return "redirect:CN/home.html";
    //    }
    //
    //}
    //
    //@RequestMapping("/home.html")
    //public String index () {
    //    return "home";
    //}
    //@RequestMapping("/{language:[CE]N}/**")
    //public void forward(@PathVariable("language") String language, HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
    //    WebContext.language.set(language);
    //    request.getRequestDispatcher(request.getRequestURI().replace("/" + language + "/", "/")).forward(request, response);
    //    return;
    //}
}
