/**
 * @author anliyong@baidu.com
 * 2015-5-31 下午5:56:43
 */
package com.nasi.portal.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nasi.portal.web.controller.BaseController;

/**
 * @author anliyong@baidu.com 2015-5-31下午5:56:43
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController extends BaseController {
    
    @RequestMapping(value = "/home")
    public String home() {
        return "system/main";
    }

    @RequestMapping(value = "/left")
    public String left() {
        return "system/left";
    }

    @RequestMapping(value = "/right")
    public String right() {
        return "system/right";
    }

    @RequestMapping(value = "/top")
    public String top() {
        return "system/top";
    }
    
}
