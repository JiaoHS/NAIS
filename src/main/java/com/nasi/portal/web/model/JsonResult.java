/**
 * @author anliyong@baidu.com
 * 2015-7-17 下午10:35:51
 */
package com.nasi.portal.web.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author anliyong@baidu.com 2015-7-17下午10:35:51
 */
public class JsonResult<T> implements Serializable {
    
    private static final Logger logger = LoggerFactory.getLogger(JsonResult.class);

    private static final long serialVersionUID = -24395699114309708L;

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    /**
     * 0 ok;
     */
    int code;

    T data;

    String info;

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.info = msg;
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> result = success(data, "操作成功");
        logger.info(result.toString());
        return result;
    }

    public static <T> JsonResult<T> success(T data, String msg) {
        JsonResult<T> result = new JsonResult<T>(JsonResult.SUCCESS, msg, data);
        logger.info(result.toString());
        return result;
    }

    public static <T> JsonResult<T> error(String msg) {
        JsonResult<T> result = new JsonResult<T>(JsonResult.ERROR, msg, null);
        logger.info(result.toString());
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
