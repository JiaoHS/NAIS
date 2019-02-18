package com.nasi.portal.service.impl;

import com.nasi.portal.data.mapper.MainOrderMapper;
import com.nasi.portal.data.model.MainOrder;
import com.nasi.portal.service.QuarterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.springframework.util.Assert.notNull;

/**
 * Created by yy on 2018-05-19.
 */

@Service
public class QuarterServiceImpl implements QuarterService {
    @Resource
    private MainOrderMapper mainOrderMapper;
    @Override
    public boolean submitQuarter(MainOrder record){
        notNull(record, "user不能为空");
        mainOrderMapper.insertSelective(record);
        return true;
    }
}
