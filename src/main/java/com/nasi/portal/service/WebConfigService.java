/**
 * @author anliyong@baidu.com
 * 2015-6-23 上午10:08:13
 */
package com.nasi.portal.service;

import com.nasi.portal.data.model.WebConfig;

/**
 * @author anliyong@baidu.com
 * 2015-6-23上午10:08:13
 */
public interface WebConfigService {

    public WebConfig getByKey(String key);

    void setByKey(String key,String value);
    
}
