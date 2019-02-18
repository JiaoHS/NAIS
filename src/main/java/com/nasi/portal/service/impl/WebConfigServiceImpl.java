/**
 * @author anliyong@baidu.com
 * 2015-6-23 上午10:08:28
 */
package com.nasi.portal.service.impl;

import static org.springframework.util.Assert.hasLength;

import java.util.List;

import javax.annotation.Resource;

import com.nasi.portal.data.model.WebConfigExample;
import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.WebConfigMapper;
import com.nasi.portal.data.model.WebConfig;
import com.nasi.portal.service.WebConfigService;

/**
 * @author anliyong@baidu.com
 * 2015-6-23上午10:08:28
 */
@Service
public class WebConfigServiceImpl implements WebConfigService {

    @Resource
    private WebConfigMapper webConfigMapper;
    
    @Override
    public WebConfig getByKey(String key) {
        
        hasLength(key, "key不能为空");

        WebConfigExample webConfigExample=new WebConfigExample();
        webConfigExample.createCriteria().andKEqualTo(key).andActiveEqualTo(1);
        
        List<WebConfig> configs = webConfigMapper.selectByExample(webConfigExample);
        
        if (configs == null || configs.isEmpty()||configs.get(0)==null) {
            return null;
        }
        
        return configs.get(0);
    }

    @Override
    public void setByKey(String key,String value) {

        if (key==null)
            return;

        WebConfigExample configCriteria=new WebConfigExample();
        configCriteria.createCriteria().andKEqualTo(key).andActiveEqualTo(1);
        List<WebConfig> webConfigs = webConfigMapper.selectByExample(configCriteria);
        if (webConfigs!=null&&webConfigs.size()>0){
            WebConfig webConfig = webConfigs.get(0);
            webConfig.setV(value);
            webConfigMapper.updateByPrimaryKey(webConfig);
        }else {
            WebConfig webConfig=new WebConfig();
            webConfig.setK(key);
            webConfig.setV(value);
            webConfig.setActive(1);
            webConfigMapper.insert(webConfig);
        }


    }

}
