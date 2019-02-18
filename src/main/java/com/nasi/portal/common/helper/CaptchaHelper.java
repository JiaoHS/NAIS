/**
 * 
 */
package com.nasi.portal.common.helper;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nasi.portal.constant.SessionConstant;

/**
 * @author anly
 * 
 */
public class CaptchaHelper {

    private static String[] srcs = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    private static final Random random = new Random();

    /**
     * 生成验证码 (a + b = ?)
     * 
     * @param request
     * @return
     */
    public static String createCaptchaStr(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int a = random.nextInt(20);
        int b = random.nextInt(20);
        String str = System.currentTimeMillis() + "";
        session.setAttribute(SessionConstant.CAPTCHA_TIME, str);
        str = a + " + " + b + " = ?";
        session.setAttribute(SessionConstant.CAPTCHA_STR, String.valueOf(a + b));
        return str;
    }

    /**
     * 获取验证码字符串并存放在session中
     * 
     * @param request
     * @param num 产生验证码的个数
     * @param type 验证码类型 0|1：纯数字|字母+数字
     * @return
     */
    public static String createCaptchaStr(HttpServletRequest request, int num, int type) {
        if (type == 0) {
            HttpSession session = request.getSession();
            String str = System.currentTimeMillis() + "";
            session.setAttribute(SessionConstant.CAPTCHA_TIME, str);
            str = str.substring(str.length() - num, str.length());
            session.setAttribute(SessionConstant.CAPTCHA_STR, str);
            return str;
        } else {
            int length = srcs.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; i++) {
                int index = random.nextInt(length);
                sb.append(srcs[index]);
            }
            HttpSession session = request.getSession();
            String str = System.currentTimeMillis() + "";
            session.setAttribute(SessionConstant.CAPTCHA_TIME, str);
            str = sb.toString();
            session.setAttribute(SessionConstant.CAPTCHA_STR, str);
            return str;
        }
    }

    /**
     * 验证验证码字符串是否输入正确
     * 
     * @param request
     * @param str
     * @return
     */
    public static boolean checkCaptcha(HttpServletRequest request, String str) {
        HttpSession session = request.getSession();
        String captcha = (String) session.getAttribute(SessionConstant.CAPTCHA_STR);
        if (captcha != null && captcha.equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证输入验证码字符串时间是否超时
     * 
     * @param request
     * @return
     */
    public static boolean checkTimeOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String timeStr = (String) session.getAttribute(SessionConstant.CAPTCHA_TIME);
        long nowtime = System.currentTimeMillis();
        long createtime = 0l;
        if (timeStr != null) {
            createtime = Long.valueOf(timeStr);
        }
        if (nowtime - createtime < 5 * 60 * 1000) {
            return true;
        } else {
            return false;
        }
    }

}
