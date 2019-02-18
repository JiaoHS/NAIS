package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.PriceRuleMapper;
import com.nasi.portal.data.model.PriceRule;
import com.nasi.portal.data.model.PriceRuleExample;
import com.nasi.portal.service.PriceRuleService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.springframework.util.Assert.notNull;

/**
 * @Author: River
 * @Date:Created in  16:11 2018/5/4
 * @Description:
 */
@Service
public class PriceRuleServiceImpl implements PriceRuleService {

    @Autowired
    private PriceRuleMapper priceRuleMapper;

    @Override
    public PriceRule findTotalAmountByCampusIdAndCount(Long count, Long campusId, Date date) {
        notNull(campusId, "campusId不能为空");
        notNull(count, "count不能为空");
        notNull(date, "date不能为空");


        PriceRuleExample example=new PriceRuleExample();
        example.createCriteria().andCampusIdEqualTo(campusId).andRuleCourseCountEqualTo(count).andRuleStartTimeLessThanOrEqualTo(date).andRuleEndTimeGreaterThanOrEqualTo(date).andRuleStatusEqualTo(1);
        List<PriceRule> priceRules = priceRuleMapper.selectByExample(example);
        if (priceRules == null || priceRules.isEmpty()) {
            return null;
        }
        return priceRules.get(0);
    }

    @Override
    public DataGridResult getPriceRuleBy(Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        PriceRuleExample example=new PriceRuleExample();
        example.setOrderByClause("create_time desc");
        List<PriceRule> priceRules = priceRuleMapper.selectByExample(example);
        PageInfo<PriceRule> priceRulePageInfo=new PageInfo<PriceRule>(priceRules);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(priceRules);
        dataGridResult.setTotal(priceRulePageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult getPriceRuleByCampusId(Integer page, Integer rows,long campusId) {
        PageHelper.startPage(page,rows,true);
        PriceRuleExample example = new PriceRuleExample();
        example.createCriteria().andCampusIdEqualTo(campusId);
        example.setOrderByClause("create_time desc");
        List<PriceRule> priceRules = priceRuleMapper.selectByExample(example);
        PageInfo<PriceRule> priceRulePageInfo=new PageInfo<PriceRule>(priceRules);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(priceRules);
        dataGridResult.setTotal(priceRulePageInfo.getTotal());

        return dataGridResult;
    }

    @Override
    @Transactional
    public JsonResult<?> insertPriceRule(PriceRule rule) {
        notNull(rule, "rule不能为空");
        //判断插入的数据在数据库中是否存在，存在就需要回滚事物
        PriceRuleExample example = new PriceRuleExample();
        PriceRuleExample example1 = new PriceRuleExample();
        PriceRuleExample example2=new PriceRuleExample();
        //校区的id,规则生效，课程的数目，开始的时间在新插入的时间之间，结束的时间在新插入的时间之间，如果表中存在满足这样的数据就不插入，否则插入
        example.createCriteria().andCampusIdEqualTo(rule.getCampusId()).andRuleStartTimeBetween(rule.getRuleStartTime(), rule.getRuleEndTime()).andRuleStatusEqualTo(1).andRuleCourseCountEqualTo(rule.getRuleCourseCount());
        example1.createCriteria().andCampusIdEqualTo(rule.getCampusId()).andRuleEndTimeBetween(rule.getRuleStartTime(), rule.getRuleEndTime()).andRuleStatusEqualTo(1).andRuleCourseCountEqualTo(rule.getRuleCourseCount());
        example2.createCriteria().andCampusIdEqualTo(rule.getCampusId()).andRuleStartTimeLessThanOrEqualTo(rule.getRuleStartTime()).andRuleEndTimeGreaterThanOrEqualTo(rule.getRuleEndTime()).andRuleStatusEqualTo(1).andRuleCourseCountEqualTo(rule.getRuleCourseCount());
        List<PriceRule> priceRules1 = priceRuleMapper.selectByExample(example);
        List<PriceRule> priceRules2 = priceRuleMapper.selectByExample(example1);
        List<PriceRule> priceRules3 = priceRuleMapper.selectByExample(example2);
        if ((priceRules1 == null || priceRules1.size() == 0) && (priceRules2 == null || priceRules2.size() == 0) && (priceRules3 == null || priceRules3.size() == 0)) {
            priceRuleMapper.insertSelective(rule);
            return JsonResult.success(null);
        } else {
            return  JsonResult.error("插入的规则生效时间或结束时间有错误");
        }
    }

    @Override
    public PriceRule showPriceRule(Long id) {
        PriceRule priceRule = priceRuleMapper.selectByPrimaryKey(id);
        return priceRule;
    }

    @Override
    public JsonResult<?> updatePriceRule(PriceRule rule) {
        notNull(rule, "rule不能为空");
        //判断插入的数据在数据库中是否存在，存在就需要回滚事物
        PriceRuleExample example = new PriceRuleExample();
        PriceRuleExample example1 = new PriceRuleExample();
        PriceRuleExample example2=new PriceRuleExample();
        //校区的id,规则生效，课程的数目，开始的时间在新插入的时间之间，结束的时间在新插入的时间之间，如果表中存在满足这样的数据就不插入，否则插入
        example.createCriteria().andCampusIdEqualTo(rule.getCampusId()).andRuleStartTimeBetween(rule.getRuleStartTime(), rule.getRuleEndTime()).andRuleStatusEqualTo(1).andRuleCourseCountEqualTo(rule.getRuleCourseCount());
        example1.createCriteria().andCampusIdEqualTo(rule.getCampusId()).andRuleEndTimeBetween(rule.getRuleStartTime(), rule.getRuleEndTime()).andRuleStatusEqualTo(1).andRuleCourseCountEqualTo(rule.getRuleCourseCount());
        example2.createCriteria().andCampusIdEqualTo(rule.getCampusId()).andRuleStartTimeLessThanOrEqualTo(rule.getRuleStartTime()).andRuleEndTimeGreaterThanOrEqualTo(rule.getRuleEndTime()).andRuleStatusEqualTo(1).andRuleCourseCountEqualTo(rule.getRuleCourseCount());
        List<PriceRule> priceRules1 = priceRuleMapper.selectByExample(example);
        List<PriceRule> priceRules2 = priceRuleMapper.selectByExample(example1);
        List<PriceRule> priceRules3 = priceRuleMapper.selectByExample(example2);
        if ((priceRules1 == null || priceRules1.size() == 0) && (priceRules2 == null || priceRules2.size() == 0) && (priceRules3 == null || priceRules3.size() == 0)) {
            priceRuleMapper.updateByPrimaryKeySelective(rule);
            return JsonResult.success(null);
        } else {
            return  JsonResult.error("更改的规则生效时间或结束时间有错误");
        }
    }

    @Override
    @Transactional
    public void deletePriceRule(Long id) {
        priceRuleMapper.deleteByPrimaryKey(id);
    }



}
