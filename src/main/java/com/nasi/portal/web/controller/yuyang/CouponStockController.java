package com.nasi.portal.web.controller.yuyang;

import com.nasi.portal.data.model.CouponStock;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.CouponStockService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yy on 2018-05-06.
 */

@Controller
@RequestMapping(value = "/coupon")
public class CouponStockController extends BaseController {
    @Autowired
    private CouponStockService couponStockService;

    @Autowired
    private UserService userService;

    //显示活动优惠券
    @RequestMapping(value = "/show/activityCouponList")
    @ResponseBody
    public DataGridResult getActivityCouponList(@RequestParam(value = "page") Integer page,
                                                @RequestParam(value = "rows") Integer rows,
                                                HttpServletRequest request){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        return couponStockService.getActivityCouponStockRecordsByPage(page,rows,user.getId().longValue());
    }

    //领取优惠券
    @RequestMapping(value = "/pullActivityCouponCode")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult pullActivityCouponCode(@RequestParam(value = "id") Long id,
                                             HttpServletRequest request){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        int result=couponStockService.pullActivityCouponCode(id.longValue(),user.getId().longValue());
        if(result==1){
            return JsonResult.success(id);
        }else if(result==-1){
            return JsonResult.error("不好意思，该优惠券已经被领完了。");
        }else if(result==-2){
            return JsonResult.error("您已经拥有该优惠券，无法重复领取。");
        }else if(result==-3){
            return JsonResult.error("不好意思，该优惠券不存在。");
        }else{
            return JsonResult.error("未知错误，请重试。");
        }
    }

    //我的优惠券
    @RequestMapping(value = "/show/myCouponList")
    @ResponseBody
    public DataGridResult getMyCouponList(@RequestParam(value = "page") Integer page,
                                          @RequestParam(value = "rows") Integer rows,
                                          HttpServletRequest request){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        return couponStockService.getMyCouponStockRecordsByPage(user.getId().longValue(),page,rows);
    }

    //领取推广优惠券
    @RequestMapping(value = "/pullSpreadCouponCode")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult pullSpreadCouponCode(@RequestParam(value = "couponCode") String couponCode,
                                           HttpServletRequest request){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        int result=couponStockService.pullSpreadCouponCode(couponCode,user.getId().longValue());
        if(result==1){
            return JsonResult.success(couponCode);
        }else if(result==-1){
            return JsonResult.error("不好意思，该优惠券不存在或者已经失效了。");
        }/*else if(result==-2){
            return JsonResult.error("不好意思，该优惠券已经被领完了。");
        }*/else if(result==-3){
            return JsonResult.error("您已经拥有该优惠券，无法重复领取。");
        }else{
            return JsonResult.error("未知错误，请重试。");
        }
    }

    //后台优惠码管理--查询
    @RequestMapping(value = "/admin/find")
    @ResponseBody
    public DataGridResult findCouponByQuery(@RequestParam(value = "code",required = false) String code,
                                            @RequestParam(value = "type",required = false) Integer type,
                                            @RequestParam(value = "page") Integer page,
                                            @RequestParam(value = "rows") Integer rows){
        return couponStockService.getCouponRecordsFromQuery(code,type,page,rows);
    }

    //后台优惠码管理--编辑
    @RequestMapping(value = "/admin/update")
    @ResponseBody
    public JsonResult updateCouponRecord(@RequestParam(value = "id") Long id,
                                         @RequestParam(value = "code") String code,
                                         @RequestParam(value = "type") Integer type,
                                         @RequestParam(value = "discountAmount") Long discountAmount,
                                         @RequestParam(value = "stock") Integer stock,
                                         @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                         @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime){
        List<CouponStock> list=couponStockService.getCouponStockById(id.longValue());
        if(list==null||list!=null&&list.size()==0){
            return JsonResult.error("数据库中不存在该记录");
        }
        CouponStock record=new CouponStock();
        record.setId(id.longValue());
        record.setCouponCode(code);
        record.setCouponType(type);
        record.setDiscountAmount(discountAmount.longValue());
        record.setStock(stock);
        record.setCreateTime(list.get(0).getCreateTime());
        record.setUpdateTime(new Date());
        record.setCreateUser(list.get(0).getCreateUser());
        record.setCouponStartTime(startTime);
        record.setCouponEndTime(endTime);
        //couponStockService.updateCouponStockRecord(record);
        if(couponStockService.updateCouponStockRecord(record)){
            return JsonResult.success(record);
        }else{
            return JsonResult.error("数据库中已不存在该记录");
        }
    }

    //后台优惠码管理--查看
    @RequestMapping(value = "/admin/show/list/select")
    @ResponseBody
    public JsonResult showCouponStockInfoBySelect(@RequestParam("id") Long id){
        List<CouponStock> list=couponStockService.getCouponStockById(id.longValue());
        if(list==null||list!=null&&list.size()==0){
            return JsonResult.error("不存在id为"+id+"的记录");
        }
        return JsonResult.success(list);
    }

    //后台优惠码管理--删除
    @RequestMapping(value = "/admin/delete")
    @ResponseBody
    public JsonResult deleteRecord(@RequestParam("id") Long id){
        List<CouponStock> list=couponStockService.getCouponStockById(id.longValue());
        if(list==null||list!=null&&list.size()==0){
            return JsonResult.error("不存在id为"+id+"的记录");
        }
        couponStockService.deleteCouponStockRecord(list.get(0));
        return JsonResult.success(list);
    }

    //后台优惠码管理--获取优惠码
    @RequestMapping(value = "/admin/getCoupon")
    @ResponseBody
    public JsonResult getCoupon(){
        return JsonResult.success(couponStockService.buildCouponCode());
    }

    //后台优惠码管理--添加优惠码
    @RequestMapping(value = "/admin/addCoupon")
    @ResponseBody
    public JsonResult addCouponRecord(@RequestParam("code") String code,
                                      @RequestParam("type") Integer type,
                                      @RequestParam("discountAmount") Long discountAmount,
                                      @RequestParam("stock") Integer stock,
                                      @RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                      @RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
                                      HttpServletRequest request){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());

        CouponStock record=new CouponStock();
        record.setCouponCode(code);
        record.setCouponType(type);
        record.setDiscountAmount(discountAmount.longValue());
        record.setStock(stock);
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser(user.getId().longValue());
        record.setCouponStartTime(startTime);
        record.setCouponEndTime(endTime);

        couponStockService.insertCouponStockRecord(record);

        List<CouponStock>list=new ArrayList<CouponStock>();
        list.add(record);
        return JsonResult.success(list);
    }

    //后台优惠码管理--显示类型 辅助
    @RequestMapping(value = "/admin/types")
    @ResponseBody
    public JsonResult showCouponType(){
        return couponStockService.getCouponTypes();
    }

    //后台优惠码管理--显示所有优惠券
    @RequestMapping(value = "/admin/list")
    @ResponseBody
    public DataGridResult showCouponList(@RequestParam(value = "page") Integer page,
                                         @RequestParam(value = "rows") Integer rows){
        return couponStockService.getCouponStockRecords(page,rows);
    }

    //后台优惠券管理--批量删除
    @RequestMapping(value = "/admin/batchDelete")
    @ResponseBody
    public JsonResult batchDeleteCouponRecords(@RequestParam String ids){
        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                couponStockService.deleteCouponRecord(id);
            }
            return JsonResult.success(null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("删除失败");
        }
    }

    //后台优惠券管理--添加优惠券
    @RequestMapping(value = "/admin/insert")
    @ResponseBody
    public JsonResult insertCouponRecord(@RequestParam("couponCode") String couponCode,
                                         @RequestParam("couponType") Integer couponType,
                                         @RequestParam("discountAmount") Long discountAmount,
                                         @RequestParam(value ="stock",required = false) Integer stock,
                                         @RequestParam("couponStartTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date couponStartTime,
                                         @RequestParam("couponEndTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date couponEndTime,
                                         HttpServletRequest request){

        /*User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());*/
        CouponStock record=new CouponStock();
        record.setCouponCode(couponCode);
        record.setCouponType(couponType);

        record.setDiscountAmount(discountAmount);


        if(couponType==1){
            if(stock!=null){
                record.setStock(stock);
            }else{
                return JsonResult.success("活动优惠码的库存不能为空");
            }
        }else{
            record.setStock(-1);
        }

        record.setCouponStartTime(couponStartTime);
        record.setCouponEndTime(couponEndTime);
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        //管理员id
        record.setCreateUser(-100l);

        couponStockService.insertCouponStockRecord(record);
        return JsonResult.success(record);
    }


    @RequestMapping(value = "/buildExtendCode")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult buildExtendCode(@RequestParam("userId") Long userId){
        if(couponStockService.bulidExtendCode(userId)){
            return JsonResult.success("success");
        }else{
            return JsonResult.error("生成失败，原因：1、该用户已经生成；2、生成过程中异常");
        }
    }


    @RequestMapping(value = "/judgeExtendCode")
    @ResponseBody
    public JsonResult judgeExtendCode(@RequestParam("userId") Long userId){
        if(couponStockService.judgeUserHaveExtendCodeOrNot(userId)){
            return JsonResult.success("已生成");
        }else{
            return JsonResult.error("没生成");
        }
    }


    @RequestMapping(value = "/getCodeById")
    @ResponseBody
    public JsonResult getCodeById(@RequestParam("id") Long id){
        String code=couponStockService.getCouponCodeById(id);
        if(code==null)
            return JsonResult.error("不存在该优惠券");
        else
            return JsonResult.success(code);
    }
}
