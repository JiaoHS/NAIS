/**
 * @author anliyong@baidu.com
 * 2015-7-17 下午8:23:30
 */
package com.nasi.portal.web.controller.caohao;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nasi.portal.Task.EmailVeryfyTask;
import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.common.helper.MailHelper;
import com.nasi.portal.common.helper.MailInfo;
import com.nasi.portal.common.helper.MailUtil;
import com.nasi.portal.data.model.WebConfig;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.common.constants.CookieConstants;
import com.nasi.portal.common.constants.SessonConstants;
import com.nasi.portal.common.helper.EncryptHelper;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.dict.Role;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.model.JsonResult;

/**
 * @author anliyong@baidu.com
 * 2015-7-17下午8:23:30
 */
@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {

    @Resource
    private UserService userService;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginSubmit")
    @ResponseBody
    public JsonResult<?> login(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam(value = "gourl", required = false, defaultValue = "") String gourl,
                               HttpServletRequest request, HttpServletResponse response) {

        if (email == null || "".equals(email.trim())) {
            return JsonResult.error("请输入用户名");
        }

        if (password == null || "".equals(password.trim())) {
            return JsonResult.error("请输入密码");
        }

        User user = userService.getActiveUserByEmail(email);

        if (user == null) {
            return JsonResult.error("用户名不存在");
        }

        if (!EncryptHelper.encryptMD5(password).equals(user.getPassword())) {
            return JsonResult.error("密码输入不正确");
        }

        request.getSession().setAttribute(SessonConstants.CURRENT_LOGIN_USER, user);

        super.addCookie(request, response, CookieConstants.LOGIN_USER_ID, String.valueOf(user.getId()), Integer.MAX_VALUE);

        super.addCookie(request, response, CookieConstants.LOGIN_EMAIL, user.getEmail(), Integer.MAX_VALUE);

        super.addCookie(request, response, CookieConstants.LOGIN_STATUS, String.valueOf(1), -1);

//        if (gourl == null || "".equals(gourl)) {
//            if (user.getRoleId() == 0) {
//                gourl = Role.getByRoleId(user.getRoleId()).getHomeUrl();
//            } else {
//                String referer = request.getHeader("referer");
//                String language = "/CN";
//                if (referer.contains("/EN/")) {
//                    language = "/EN";
//                }
//                gourl = language + Role.getByRoleId(user.getRoleId()).getHomeUrl();
//            }
//        }
        logger.info("--------------------------------------------user: " + email + " , pwd: " + password + " login successfully!");

        return JsonResult.success(user);
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/registerSave")
    @ResponseBody
    public JsonResult<?> register(@RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  @RequestParam("repwd") String repwd,
                                  @RequestParam("telCn") String telCn,
                                  @RequestParam("userName") String userName,
                                  @RequestParam("idCard") String idCard,
                                  @RequestParam("sex") Integer sex,
                                  @RequestParam(value = "role", required = false) Integer roleId,
                                  HttpServletRequest request, HttpServletResponse response) {

        if (email == null || "".equals(email.trim())) {
            return JsonResult.error("请输入用户名");
        }

        if (!checkEmail(email)) {
            return JsonResult.error("请输入正确的邮箱格式");
        }

        if (password == null || "".equals(password.trim())) {
            return JsonResult.error("请输入密码");
        }

        if (password.length() < 6) {
            return JsonResult.error("密码长度不得小于6位");
        }

        if (!isValidate(password)) {
            return JsonResult.error("密码必须由数字和字母组成");
        }


        if (repwd == null || "".equals(repwd.trim())) {
            return JsonResult.error("请再次确认密码");
        }

        if (!password.equals(repwd.trim())) {
            return JsonResult.error("两次输入密码不一致");
        }

        User user = userService.getActiveUserByEmail(email);

        if (user != null) {
            return JsonResult.error("该邮箱已注册");
        }

        user = new User();

        user.setEmail(email);
        user.setPassword(EncryptHelper.encryptMD5(password));
        /*0:管理员，1：教授，2：学生*/
        user.setRoleId(2);
        user.setActive(1);
//        user.setFromSchoolCn(school);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        user.setTelCn(telCn);
        user.setIdCard(idCard);
        user.setNameCn(userName);
        user.setGender(sex);

        userService.insertOrUpdate(user);

        request.getSession().setAttribute(SessonConstants.CURRENT_LOGIN_USER, user);

        super.addCookie(request, response, CookieConstants.LOGIN_USER_ID, String.valueOf(user.getId()), Integer.MAX_VALUE);

        super.addCookie(request, response, CookieConstants.LOGIN_EMAIL, user.getEmail(), Integer.MAX_VALUE);

        super.addCookie(request, response, CookieConstants.LOGIN_STATUS, String.valueOf(1), -1);

        logger.info("--------------------------------------------user:" + user.getEmail() + " ,register successfully! ， pwd:" + password);

        return JsonResult.success("/personalInfoSet.html");
    }


    @RequestMapping(value = "/emailVerify")
    @ResponseBody
    public JsonResult<?> emailVerify(@RequestParam String email, HttpServletRequest request) {

//        User user = (User) request.getSession().getAttribute(SessonConstants.CURRENT_LOGIN_USER);


        if (email == null || "".equals(email.trim())) {
            return JsonResult.error("请输入用户名");
        }

        if (!checkEmail(email)) {
            return JsonResult.error("请输入正确的邮箱格式");
        }

        User user = userService.getActiveUserByEmail(email);

        if (user == null) {
            return JsonResult.error("用户名不存在");
        }

        request.getSession().setAttribute(SessonConstants.CURRENT_LOGIN_USER, user);

        WebConfig host = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_HOST);

        WebConfig port = webConfigService.getByKey(ConfigConstants.EMAIL_SERVER_PORT);

        WebConfig userName = webConfigService.getByKey(ConfigConstants.EMAIL_USERNAME);

        WebConfig pwd = webConfigService.getByKey(ConfigConstants.EMAIL_PASSWORD);

        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);


        taskExecutor.execute(new EmailVeryfyTask(email, verifyCode, host.getV(), port.getV(), userName.getV(), pwd.getV()));

        logger.info("--------------------------------------------send email to user: " + email);

        return JsonResult.success(verifyCode);

    }

    @RequestMapping("/passwordReset")
    public String passwordReset() {
        return "personalCenter/passwordReset";
    }

    @RequestMapping(value = "/passwordResetSubmit")
    @ResponseBody
    public JsonResult<?> passwordReset(@RequestParam String password, HttpServletRequest request) {

        if (password == null || "".equals(password.trim())) {
            return JsonResult.error("请输入密码");
        }

        if (password.length() < 6) {
            return JsonResult.error("密码长度不得小于6位");
        }

        if (!isValidate(password)) {
            return JsonResult.error("密码必须由数字和字母组成");
        }

        User user = (User) request.getSession().getAttribute(SessonConstants.CURRENT_LOGIN_USER);

        if (user != null) {
            user.setPassword(EncryptHelper.encryptMD5(password));
            userService.insertOrUpdate(user);
            logger.info("--------------------------------------------reset password: user: " + user.getEmail());
            return JsonResult.success(null, "密码重置成功");
        } else {
            return JsonResult.error("密码重置失败");
        }


    }


    private boolean isValidate(String password) {

        char[] chars = password.toCharArray();
        boolean hasNum = false;
        boolean hasEn = false;
        for (char c : chars) {
            if (c >= 48 && c <= 57) {
                hasNum = true;
            } else if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                hasEn = true;
            }
        }
        if (hasEn && hasNum)
            return true;
        else
            return false;
    }

    private boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


}
