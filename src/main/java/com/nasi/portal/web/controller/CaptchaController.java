/**
 * 
 */
package com.nasi.portal.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nasi.portal.common.helper.CaptchaHelper;

/**
 * @author anly
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class CaptchaController extends BaseController {

    private Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        super.response2Client(response, CaptchaHelper.createCaptchaStr(request));
    }

    @RequestMapping(value = "/captchaStr")
    public void show(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

        int w = 55;// 宽度
        int h = 22;// 高度
        int n = 4;// 验证码字符串数量
        int t = 0;// 验证码字符串类别0:1|纯数字:数字加字母

        if (map.containsKey("w")) {
            w = MapUtils.getIntValue(map, "w");
        }

        if (map.containsKey("h")) {
            h = MapUtils.getIntValue(map, "h");
        }

        if (map.containsKey("n")) {
            n = MapUtils.getIntValue(map, "n");
        }

        if (map.containsKey("t")) {
            t = MapUtils.getIntValue(map, "t");
        }

        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 设定背景颜色
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, w, h);
        // 画边框
        g.setColor(Color.black);
        g.drawRect(0, 0, w - 1, h - 1);
        // 随机产生的验证码
        String strEnsure = CaptchaHelper.createCaptchaStr(request, n, t);

        logger.info("验证码-->" + strEnsure);

        // 将验证码显示在图像中，如果要生成更多位的验证码，增加drawString语句
        g.setColor(Color.black);
        g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
        g.drawString(strEnsure, 8, 17);
        // 随机产生10个干扰点

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            g.drawOval(x, y, 1, 1);
        }
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        OutputStream out;
        try {
            out = response.getOutputStream();
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG", out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
