/**
 * @author: 安李勇
 * @email: anlystar@gmail.com
 */
package com.nasi.portal.common.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * @author 安李勇
 * 
 */
public class VelocityHelper {

    public static String ENCODING_UTF_8 = "UTF-8";

    private static Log logger = LogFactory.getLog(VelocityHelper.class);

    private static String vmPath = null;

    static {
        vmPath = VelocityHelper.class.getResource("/").getPath();
        vmPath = vmPath.replace("WEB-INF/classes/", "");
    }

    private static VelocityEngine loadVelocityEngine(String encoding) {
        VelocityEngine ve = new VelocityEngine();
        Properties p = new Properties();
        p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, vmPath);
        p.setProperty(Velocity.INPUT_ENCODING, encoding);
        p.setProperty(Velocity.OUTPUT_ENCODING, encoding);
        ve.init(p);
        return ve;
    }

    public static boolean updateVelocity(String vm, VelocityContext context, String filePath, String encoding) {
        boolean result = true;
        try {
            encoding = encoding == null || "".equals(encoding.trim()) ? ENCODING_UTF_8 : encoding;
            Template template = loadVelocityEngine(encoding).getTemplate(vm, encoding);
            File dest = new File(filePath);
            IOHelper.makeDirs(dest);
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, encoding)); // 设置写入的文件编码,解决中文问题
            template.merge(context, writer);
            writer.close();
            fos.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = false;
        }
        return result;
    }

    public static void mergeTemplate(HttpServletResponse response, String vm, VelocityContext context, String encoding) {
        try {
            encoding = encoding == null || "".equals(encoding.trim()) ? ENCODING_UTF_8 : encoding;
            Template template = loadVelocityEngine(encoding).getTemplate(vm, encoding);
            template.merge(context, response.getWriter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generate(String vm, VelocityContext context, String encoding) {
        Writer writer = null;
        try {
            encoding = encoding == null || "".equals(encoding.trim()) ? ENCODING_UTF_8 : encoding;
            Template template = loadVelocityEngine(encoding).getTemplate(vm, encoding);
            writer = new StringWriter();
            template.merge(context, writer);
            return writer.toString();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public static VelocityContext generateVelocityContext(Map<String, Object> map) {
        VelocityContext context = new VelocityContext();
        if (map == null) {
            return null;
        }
        Iterator<Entry<String, Object>> ite = map.entrySet().iterator();
        while (ite.hasNext()) {
            Entry<String, Object> entry = ite.next();
            context.put(entry.getKey(), entry.getValue());
        }
        return context;
    }

}
