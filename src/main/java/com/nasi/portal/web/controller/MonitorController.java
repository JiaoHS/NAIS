/**
 * @author anliyong@baidu.com
 * 2015-7-17 下午8:23:30
 */
package com.nasi.portal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author anliyong@baidu.com
 * 2015-7-17下午8:23:30
 */
@Controller
public class MonitorController extends BaseController {

    @RequestMapping("/monitor.do")
    @ResponseBody
    public String login () {
        return "ok";
    }
    
}
