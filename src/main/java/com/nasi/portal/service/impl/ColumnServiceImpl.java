/**
 * @author anliyong@baidu.com
 * 2015-5-31 下午7:20:43
 */
package com.nasi.portal.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.ColumnMapper;
import com.nasi.portal.data.model.Column;
import com.nasi.portal.data.model.ColumnCriteria;
import com.nasi.portal.service.ColumnService;

/**
 * @author anliyong@baidu.com 2015-5-31下午7:20:43
 */
@Service
public class ColumnServiceImpl implements ColumnService {

    @Resource
    private ColumnMapper columnMapper;

    @Override
    public int insertOrUpdate(Column column) {
        if (column.getId() == null) {
            return columnMapper.insertSelective(column);
        } else {
            ColumnCriteria columnsCriteria = new ColumnCriteria();
            columnsCriteria.createCriteria().andIdEqualTo(column.getId());
            return columnMapper.updateByExampleSelective(column, columnsCriteria);
        }
    }

    @Override
    public List<Column> listAll() {
        ColumnCriteria columnsCriteria = new ColumnCriteria();
        return columnMapper.selectByExample(columnsCriteria);
    }

    @Override
    public Column getByPrimaryKey(Integer id) {
        notNull(id, "id不能为空");
        return columnMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Column> getSelectData(Integer level, Integer type) {
        notNull(level, "level不能为空");
        notNull(type, "type不能为空");
        ColumnCriteria columnsCriteria = new ColumnCriteria();
        columnsCriteria.createCriteria().andLevelEqualTo(level).andColumnTypeEqualTo(type);
        columnsCriteria.setOrderByClause(" show_order ");
        return columnMapper.selectByExample(columnsCriteria);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        notNull(id, "id不能为空");
        return columnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Column> getListByLocationAndParentId(Integer location, Integer parentId) {
        notNull(location, "location不能为空");
        notNull(parentId, "parentId不能为空");
        ColumnCriteria columnsCriteria = new ColumnCriteria();
        columnsCriteria.createCriteria().andLocationEqualTo(location).andParentIdEqualTo(parentId);
        columnsCriteria.setOrderByClause(" show_order ");
        return columnMapper.selectByExample(columnsCriteria);
    }

    @Override
    public List<Column> getListByParentId(Integer parentId) {
        notNull(parentId, "parentId不能为空");
        ColumnCriteria columnsCriteria = new ColumnCriteria();
        columnsCriteria.createCriteria().andParentIdEqualTo(parentId);
        columnsCriteria.setOrderByClause(" show_order ");
        return columnMapper.selectByExample(columnsCriteria);
    }

}
