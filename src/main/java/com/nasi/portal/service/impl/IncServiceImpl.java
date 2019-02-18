/**
 * @author anliyong@baidu.com
 * 2015-6-20 下午7:40:15
 */
package com.nasi.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.common.helper.VelocityHelper;
import com.nasi.portal.data.model.Column;
import com.nasi.portal.data.model.WebConfig;
import com.nasi.portal.data.model.dict.ColumnLocation;
import com.nasi.portal.data.model.ext.ColumnExt;
import com.nasi.portal.service.ColumnService;
import com.nasi.portal.service.IncService;
import com.nasi.portal.service.WebConfigService;

/**
 * @author anliyong@baidu.com
 * 2015-6-20下午7:40:15
 */
@Service
public class IncServiceImpl implements IncService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Resource
    private ColumnService columnsService;
    
    @Resource
    private WebConfigService webConfigService;
    
    public boolean updateTopInc() {
    
        WebConfig webURL = webConfigService.getByKey(ConfigConstants.WEB_URL);
        
        WebConfig webPath = webConfigService.getByKey(ConfigConstants.WEB_PATH);
        
        List<Column> columns = columnsService.getListByLocationAndParentId(ColumnLocation.HEAD.getIndex(), 0);
        
        String vmName = "vm/top_cn.vm";
        
        String vmEName = "vm/top_en.vm";
        
        String incName = "/inc/CN/top.inc";
        
        String incEName = "/inc/EN/top.inc";
        
        VelocityContext context = new VelocityContext();
        
        List<ColumnExt> columnExts = new ArrayList<ColumnExt>();
        
        for (Column column : columns) {
            ColumnExt columnExt = new ColumnExt();
            try {
                BeanUtils.copyProperties(columnExt, column);
            } catch (Exception e) {
                logger.error(e.getMessage(), e.fillInStackTrace());
            }
            columnExt.setSubColumns(columnsService.getListByParentId(column.getId()));
            columnExts.add(columnExt);
        }
        
        context.put("columns", columnExts);

        context.put("webURL", webURL);
        
        logger.info("generate top.inc ... start");
        
        VelocityHelper.updateVelocity(vmName, context, webPath.getV() + incName, "UTF-8");
        
        VelocityHelper.updateVelocity(vmEName, context, webPath.getV() + incEName, "UTF-8");
        logger.info("generate top.inc ... end");
        
        return Boolean.TRUE;
    }
    
}
