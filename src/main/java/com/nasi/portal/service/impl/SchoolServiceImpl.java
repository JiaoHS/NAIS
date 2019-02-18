/**
 * @author anliyong@baidu.com
 * 2015-7-25 上午11:01:06
 */
package com.nasi.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nasi.portal.data.mapper.SchoolMapper;
import com.nasi.portal.data.model.School;
import com.nasi.portal.data.model.SchoolCriteria;
import com.nasi.portal.service.SchoolService;

/**
 * @author anliyong@baidu.com
 * 2015-7-25上午11:01:06
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public List<School> getSchools() {
        SchoolCriteria criteria = new SchoolCriteria();
        criteria.setOrderByClause(" show_order ");
        return schoolMapper.selectByExample(criteria);
    }
    
}
