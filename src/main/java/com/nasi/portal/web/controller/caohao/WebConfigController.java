package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.data.model.WebConfig;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * created by xdCao on 2018/4/18
 */
@Controller
@RequestMapping(value = "/config")
public class WebConfigController extends BaseController {

    @Autowired
    private WebConfigService webConfigService;

    // todo 这里所有的操作都必须确认session中管理员的存在

    @RequestMapping(value = "/email/show")
    @ResponseBody
    public JsonResult<?> emailConfigShow(){
        List<WebConfig> configs=new ArrayList<WebConfig>();
        WebConfig serverHost = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_HOST);
        WebConfig serverPort = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_PORT);
        WebConfig userName = webConfigService.getByKey(ConfigConstants.EMAIL_USERNAME);
        WebConfig password = webConfigService.getByKey(ConfigConstants.EMAIL_PASSWORD);
        WebConfig received = webConfigService.getByKey(ConfigConstants.EMAIL_RECEIVED);
        configs.add(serverHost);
        configs.add(serverPort);
        configs.add(userName);
        configs.add(password);
        configs.add(received);
        return JsonResult.success(configs);

    }

    @RequestMapping("/email/set")
    @ResponseBody
    public JsonResult<?> emailConfigSet(@RequestParam("serverHost") String serverHost,
                                        @RequestParam("serverPort") String  serverPort,
                                        @RequestParam("userName") String userName,
                                        @RequestParam("password") String password,
                                        @RequestParam("received") String received){
        webConfigService.setByKey(ConfigConstants.EMAIL_SERVER_HOST,serverHost);
        webConfigService.setByKey(ConfigConstants.EMAIL_SERVER_PORT,serverPort);
        webConfigService.setByKey(ConfigConstants.EMAIL_USERNAME,userName);
        webConfigService.setByKey(ConfigConstants.EMAIL_PASSWORD,password);
        webConfigService.setByKey(ConfigConstants.EMAIL_RECEIVED,received);
        return JsonResult.success(null);
    }



}
