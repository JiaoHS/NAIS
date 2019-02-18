package com.nasi.portal.service;

import com.nasi.portal.data.model.PriceRule;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;

import java.util.Date;

/**
 * @Author: River
 * @Date:Created in  16:11 2018/5/4
 * @Description:
 */
public interface PriceRuleService {

    PriceRule findTotalAmountByCampusIdAndCount(Long count, Long campusId, Date date);

    DataGridResult getPriceRuleBy(Integer page, Integer rows);


    DataGridResult getPriceRuleByCampusId(Integer page, Integer rows,long campusId);

    JsonResult<?> insertPriceRule(PriceRule rule);

    PriceRule showPriceRule(Long id);

    JsonResult<?> updatePriceRule(PriceRule rule);

    void deletePriceRule(Long id);
}
