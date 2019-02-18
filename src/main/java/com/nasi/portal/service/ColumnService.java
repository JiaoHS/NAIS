/**
 * @author anliyong@baidu.com
 * 2015-5-31 下午7:20:23
 */
package com.nasi.portal.service;

import java.util.List;

import com.nasi.portal.data.model.Column;

/**
 * @author anliyong@baidu.com 
 * 2015-5-31下午7:20:23
 */
public interface ColumnService {

    public int insertOrUpdate(Column column);

    public List<Column> listAll();

    public Column getByPrimaryKey(Integer id);

    public List<Column> getSelectData(Integer level, Integer type);

    public int deleteByPrimaryKey(Integer id);
    
    public List<Column> getListByLocationAndParentId(Integer location, Integer parentId);
    
    public List<Column> getListByParentId(Integer parentId);

}
