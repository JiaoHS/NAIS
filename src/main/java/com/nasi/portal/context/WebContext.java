/**
 * @author anliyong@baidu.com
 * 2015-6-25 上午9:48:17
 */
package com.nasi.portal.context;

/**
 * @author anliyong@baidu.com
 * 2015-6-25上午9:48:17
 */
public class WebContext {

    /**
     * 每个线程的语言版本
     */
    public static ThreadLocal<String> language = new ThreadLocal<String>();
    
}
