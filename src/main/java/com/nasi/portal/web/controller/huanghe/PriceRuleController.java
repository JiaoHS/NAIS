package com.nasi.portal.web.controller.huanghe;

import com.nasi.portal.data.model.Campus;
import com.nasi.portal.data.model.PriceRule;
import com.nasi.portal.service.CampusService;
import com.nasi.portal.service.PriceRuleService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: River
 * @Date:Created in  20:29 2018/5/9
 * @Description: 价格规则管理
 */
@Controller
@RequestMapping("/priceRule")
public class PriceRuleController {

    @Autowired
    private PriceRuleService priceRuleService;
    
    @Autowired
    private CampusService campusService;

    //按照校区id进行分页查询
    @RequestMapping("/find")
    @ResponseBody
    public DataGridResult priceRuleList(@RequestParam(value = "campusId",required = false) Long id,
                                        @RequestParam(value = "page") Integer page,
                                        @RequestParam(value = "rows") Integer rows){

        DataGridResult priceRuleListByPage=null;

       if (id==null ||id.equals("")){
           priceRuleListByPage = priceRuleService.getPriceRuleBy(page,rows);
           return  priceRuleListByPage;
       }

        priceRuleListByPage=priceRuleService.getPriceRuleByCampusId(page,rows,id);

        return priceRuleListByPage;
    }

    //添加规则
    @RequestMapping("/add")
    @ResponseBody
    public JsonResult<?> addPriceRule(@RequestParam("campusName") String campusId,
                                      @RequestParam("ruleStartTime") String ruleStart,
                                      @RequestParam("ruleEndTime") String ruleEnd,
                                      @RequestParam("ruleCourseCount") Long ruleCourseCount,
                                      @RequestParam("ruleMoneyAmount") Long ruleMoneyAmount,
                                      @RequestParam("ruleStatus") Integer ruleStatus,
                                      @RequestParam("ruleDesc") String ruleDesc){

        Date ruleStartTime = null;
        Date ruleEndTime = null;
        try {
            ruleStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ruleStart);
            ruleEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ruleEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PriceRule rule = new PriceRule();
        //如果campusId不为空,则把campusName添加进去,并且确定id
        if (!(campusId == null || campusId.trim().length() == 0)){
            Campus campus = campusService.getCampusRecordBySelect(Long.parseLong(campusId)).get(0);
            String campusName = campus.getCampusName();
            rule.setCampusId(Long.parseLong(campusId));
            rule.setCampusName(campusName);
        }else {
            rule.setCampusId((long)-1);
        }
        rule.setRuleStartTime(ruleStartTime);
        rule.setRuleEndTime(ruleEndTime);
        rule.setRuleCourseCount(ruleCourseCount);
        rule.setRuleMoneyAmount(ruleMoneyAmount);
        rule.setRuleStatus(ruleStatus);
        rule.setRuleDesc(ruleDesc);
        rule.setCreateTime(new Date());
        rule.setUpdateTime(new Date());

        JsonResult<?> jsonResult = priceRuleService.insertPriceRule(rule);

        return jsonResult;

    }

    //删除规则
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult<?> deletePriceRule(@RequestParam("id") Long id){
        try {
            priceRuleService.deletePriceRule(id);
            return JsonResult.success(null,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("删除g规则失败");
        }
    }

    //批量删除
    @RequestMapping(value = "/batchDelete")
    @ResponseBody
    public JsonResult<?> deleteBatchPriceRule(@RequestParam String ids){

        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                priceRuleService.deletePriceRule(id);
            }
            return JsonResult.success(null,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("删除失败");
        }
    }

}
