/**
 * @author anliyong@baidu.com
 * 2015-8-12 下午4:34:16
 */
package com.nasi.portal.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.common.helper.MailHelper;
import com.nasi.portal.common.helper.MailInfo;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.model.JsonResult;

/**
 * @author anliyong@baidu.com 2015-8-12下午4:34:16
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController extends BaseController {

    @Resource
    private WebConfigService webConfigService;

    @RequestMapping("/home.html")
    public String home() {
        return "message/home";
    }

    @RequestMapping("/send.do")
    @ResponseBody
    public JsonResult<?> send(@RequestParam("msgTitle") String msgTitle, @RequestParam("msgContent") String msgContent) {

        try {
            String mailServerHost = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_HOST).getV();
            String mailServerPort = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_PORT).getV();
            String mailUsername = webConfigService.getByKey(ConfigConstants.EMAIL_USERNAME).getV();
            String mailPassword = webConfigService.getByKey(ConfigConstants.EMAIL_PASSWORD).getV();
            String mailReceived = webConfigService.getByKey(ConfigConstants.EMAIL_RECEIVED).getV();

            MailInfo mailInfo = new MailInfo();
            mailInfo.setFromAddress(mailUsername + mailServerHost.substring(mailServerHost.indexOf("@") + 1));
            mailInfo.setMailServerHost(mailServerHost);
            mailInfo.setMailServerPort(mailServerPort);
            mailInfo.setUserName(mailUsername);
            mailInfo.setPassword(mailPassword);
            mailInfo.setToAddress(mailReceived);
            mailInfo.setSubject(msgTitle);
            mailInfo.setContent(msgContent);
            MailHelper.sendTextMail(mailInfo);
            return JsonResult.success("");
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return JsonResult.error("系统异常，请联系管理员");
        }

    }

}
