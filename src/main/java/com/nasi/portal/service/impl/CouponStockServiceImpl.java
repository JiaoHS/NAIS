package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.CouponStockMapper;
import com.nasi.portal.data.mapper.UserCouponMapper;
import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.CouponStockService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.system.Usercontroller;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yy on 2018-05-04.
 */

@Service
public class CouponStockServiceImpl implements CouponStockService {
    @Resource
    private CouponStockMapper couponStockMapper;
    @Resource
    private UserCouponMapper userCouponMapper;
    @Resource
    private UserMapper userMapper;
    /**
     * show stock info
     */
    @Override
    public DataGridResult getActivityCouponStockRecordsByPage(Integer page, Integer rows,long id){
        PageHelper.startPage(page,rows);
        CouponStockExample example=new CouponStockExample();
        Date now=new Date();
        example.createCriteria().andCouponTypeEqualTo(1).andStockGreaterThan(0).andCouponStartTimeLessThanOrEqualTo(now).andCouponEndTimeGreaterThanOrEqualTo(now);
        example.setOrderByClause("update_time desc");
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);

        System.out.println("coupon:");
        for(int i=0;i<couponStockList.size();i++){
            System.out.println(couponStockList.get(i).getId());
        }
        UserCouponExample userCouponExample=new UserCouponExample();
        userCouponExample.createCriteria().andUserIdEqualTo(id).andCouponTypeEqualTo(1);
        List<UserCoupon>userCouponList=userCouponMapper.selectByExample(userCouponExample);
        System.out.println("userCoupon:");
        for(int i=0;i<userCouponList.size();i++){
            System.out.println(userCouponList.get(i).getId());
        }
        for(UserCoupon iter:userCouponList){
            int flag=-1;
            for(int i=0;i<couponStockList.size();i++){
                if(couponStockList.get(i).getId()==iter.getStockId()){
                    flag=i;
                }
            }
            if(flag!=-1)
                couponStockList.remove(flag);
        }
        /*//筛选一下符合时间的记录
        Date now=new Date();
        List<CouponStock> adoptCouponStockList=new ArrayList<CouponStock>();
        for(CouponStock iter:couponStockList){
            if(timeComparison(now,iter.getCouponStartTime(),iter.getCouponEndTime())==true){
                CouponStock insertRecord=new CouponStock();
                insertRecord.setId(iter.getId());
                insertRecord.setCouponCode(iter.getCouponCode());
                insertRecord.setCouponType(iter.getCouponType());
                insertRecord.setDiscountAmount(iter.getDiscountAmount());
                insertRecord.setStock(iter.getStock());
                insertRecord.setCreateTime(iter.getCreateTime());
                insertRecord.setUpdateTime(iter.getUpdateTime());
                insertRecord.setCreateUser(iter.getCreateUser());
                insertRecord.setCouponStartTime(iter.getCouponStartTime());
                insertRecord.setCouponEndTime(iter.getCouponEndTime());
                adoptCouponStockList.add(insertRecord);
            }
        }*/
        //筛选完成
        PageInfo<CouponStock> pageInfo=new PageInfo<CouponStock>(couponStockList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(couponStockList);
        return dataGridResult;
    }

    /**
     * get coupon
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int pullActivityCouponCode(Long id,Long userId){
        CouponStock record=couponStockMapper.selectByPrimaryKey(id);
        if(record==null||record.getCouponType()!=1){
            return -3;
        }
        //first+ 去重
        UserCouponExample example=new UserCouponExample();
        example.createCriteria().andStockIdEqualTo(id).andUserIdEqualTo(userId);
        List<UserCoupon> userCouponList=userCouponMapper.selectByExample(example);
        if(userCouponList!=null&&userCouponList.size()==0||userCouponList==null){
            //first stock -1
            if(record.getStock()>0){
                record.setStock(record.getStock()-1);
            }else{
                return -1;
            }
            couponStockMapper.updateByPrimaryKeySelective(record);
            //second add to user link
            UserCoupon userCouponRecord=new UserCoupon();
            userCouponRecord.setUserId(userId);
            userCouponRecord.setStockId(id);
            userCouponRecord.setCouponStatus(1);
            userCouponRecord.setCouponCode(record.getCouponCode());
            userCouponRecord.setCouponType(1);
            userCouponRecord.setDiscountAmount(record.getDiscountAmount());
            userCouponRecord.setCreateTime(new Date());
            userCouponRecord.setUpdateTime(new Date());
            userCouponMapper.insertSelective(userCouponRecord);
            return 1;
        }else{
            return -2;
        }
    }

    /**
     * show my coupon
     */
    @Override
    public DataGridResult getMyCouponStockRecordsByPage(Long userId, Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        UserCouponExample example=new UserCouponExample();
        UserCouponExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userId).andCouponTypeEqualTo(1).andCouponStatusEqualTo(1);

        UserCouponExample.Criteria criteria_1=example.createCriteria();
        criteria_1.andUserIdEqualTo(userId).andCouponTypeEqualTo(2).andCouponStatusEqualTo(1);
        example.or(criteria_1);
        example.setOrderByClause("update_time desc");
        List<UserCoupon>userCouponList=userCouponMapper.selectByExample(example);

        /*for(UserCoupon iter:userCouponList){
            System.out.println(iter.getCouponCode()+"~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }*/

        List<UserCoupon>newList=new ArrayList<UserCoupon>();
        for(UserCoupon iter:userCouponList){
            if(iter.getCouponType()==1){
                if(checkCouponStock(iter.getStockId())){
                    UserCoupon userRecord=new UserCoupon();
                    userRecord.setId(iter.getId());
                    userRecord.setUserId(iter.getUserId());
                    userRecord.setStockId(iter.getStockId());
                    userRecord.setCouponStatus(iter.getCouponStatus());
                    userRecord.setCouponCode(iter.getCouponCode());
                    userRecord.setCouponType(iter.getCouponType());
                    userRecord.setDiscountAmount(iter.getDiscountAmount());
                    userRecord.setCreateTime(iter.getCreateTime());
                    userRecord.setUpdateTime(iter.getUpdateTime());
                    newList.add(userRecord);
                }
            }else{
                UserCoupon userRecord=new UserCoupon();
                userRecord.setId(iter.getId());
                userRecord.setUserId(iter.getUserId());
                userRecord.setStockId(iter.getStockId());
                userRecord.setCouponStatus(iter.getCouponStatus());
                userRecord.setCouponCode(iter.getCouponCode());
                userRecord.setCouponType(iter.getCouponType());
                userRecord.setDiscountAmount(iter.getDiscountAmount());
                userRecord.setCreateTime(iter.getCreateTime());
                userRecord.setUpdateTime(iter.getUpdateTime());
                newList.add(userRecord);
            }
        }

        userCouponList=userCouponListFilter(newList);
        PageInfo<UserCoupon> pageInfo=new PageInfo<UserCoupon>(userCouponList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(userCouponList);

        return dataGridResult;
    }

    @Override
    public boolean checkCouponStock(Long id){
        CouponStockExample couponStockExample=new CouponStockExample();
        couponStockExample.createCriteria().andIdEqualTo(id).andStockGreaterThan(0);
        List<CouponStock>list=couponStockMapper.selectByExample(couponStockExample);
        if(list!=null&&list.size()!=0)
            return true;
        else
            return  false;
    }

    /**
     * util
     */
    @Override
    public List<UserCoupon> userCouponListFilter(List<UserCoupon> list){
        /*Date now=new Date();
        List<UserCoupon> newList=new ArrayList<UserCoupon>();
        for(UserCoupon iter:list){
            CouponStockExample example=new CouponStockExample();
            example.createCriteria().andIdEqualTo(iter.getStockId());
            List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
            if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
                //do nothing
            }else{
                if(timeComparison(now,couponStockList.get(0).getCouponStartTime(),couponStockList.get(0).getCouponEndTime())){
                    UserCoupon insertRecord=new UserCoupon();
                    insertRecord.setUpdateTime(iter.getUpdateTime());
                    insertRecord.setCreateTime(iter.getCreateTime());
                    insertRecord.setDiscountAmount(iter.getDiscountAmount());
                    insertRecord.setCouponType(iter.getCouponType());
                    insertRecord.setCouponCode(iter.getCouponCode());
                    insertRecord.setCouponStatus(iter.getCouponStatus());
                    insertRecord.setStockId(iter.getStockId());
                    insertRecord.setId(iter.getId());
                    insertRecord.setUserId(iter.getUserId());
                    newList.add(insertRecord);
                }else{
                    //do nothing
                }
            }
        }*/
        List<UserCoupon>newList=new ArrayList<UserCoupon>();
        //Date now=new Date();
        for(UserCoupon iter:list){
            Date now=new Date();
            CouponStockExample example=new CouponStockExample();
            example.createCriteria().andCouponStartTimeLessThanOrEqualTo(now).andCouponEndTimeGreaterThanOrEqualTo(now).andIdEqualTo(iter.getStockId());
            List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
            if(couponStockList!=null&&couponStockList.size()!=0){
                UserCoupon insertRecord=new UserCoupon();
                insertRecord.setUpdateTime(iter.getUpdateTime());
                insertRecord.setCreateTime(iter.getCreateTime());
                insertRecord.setDiscountAmount(iter.getDiscountAmount());
                insertRecord.setCouponType(iter.getCouponType());
                insertRecord.setCouponCode(iter.getCouponCode());
                insertRecord.setCouponStatus(iter.getCouponStatus());
                insertRecord.setStockId(iter.getStockId());
                insertRecord.setId(iter.getId());
                insertRecord.setUserId(iter.getUserId());
                newList.add(insertRecord);
            }
        }
        return newList;
    }

    /**
     * util
     */
    @Override
    public boolean timeComparison(Date now,Date begin,Date end){
        if(now.after(begin)||now.equals(begin)&&now.before(end)||now.equals(end)){
            return true;
        }else{
            return false;
        }
    }


    /**
     * get coupon
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int pullSpreadCouponCode(String couponCode,Long userId){
        Date now=new Date();
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andCouponCodeEqualTo(couponCode).andCouponStartTimeLessThanOrEqualTo(now).andCouponEndTimeGreaterThanOrEqualTo(now).andCouponTypeEqualTo(2);
        List<CouponStock>couponStockList=couponStockMapper.selectByExample(example);
        if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
            //no such code
            return -1;
        }
        /*CouponStock record=couponStockMapper.selectByPrimaryKey(couponStockList.get(0).getId());
        if(record.getStock()>0){
            record.setStock(record.getStock()-1);
        }else{
            return -2;
        }
        couponStockMapper.updateByPrimaryKeySelective(record);*/
        //去重
        UserCouponExample userExample=new UserCouponExample();
        userExample.createCriteria().andStockIdEqualTo(couponStockList.get(0).getId()).andUserIdEqualTo(userId);
        List<UserCoupon>userCouponList=userCouponMapper.selectByExample(userExample);
        System.out.println(userCouponList.size());
        if(userCouponList.size()!=0&&userCouponList!=null){
            return -3;
        }

        UserCoupon userCouponRecord=new UserCoupon();
        userCouponRecord.setUserId(userId);
        userCouponRecord.setStockId(couponStockList.get(0).getId());
        userCouponRecord.setCouponStatus(1);
        userCouponRecord.setCouponCode(couponCode);
        userCouponRecord.setCouponType(2);
        userCouponRecord.setDiscountAmount(couponStockList.get(0).getDiscountAmount());
        userCouponRecord.setCreateTime(new Date());
        userCouponRecord.setUpdateTime(new Date());
        userCouponMapper.insertSelective(userCouponRecord);
        return 1;
    }

    @Override
    public DataGridResult getCouponRecordsFromQuery(String code,Integer type,Integer page, Integer rows){
        DataGridResult dataGridResult=null;
        if(code==null||code.equals("")){
            if(type==null){
                dataGridResult=getCouponStockRecordsByPage(page,rows);
                System.out.println("fit nothing");
            }else{
                dataGridResult=getCouponStockRecordsFitTypeByPage(type,page,rows);
                //getCouponStockRecordsFitCodeByPage(code,page,rows);
                System.out.println("fit type");
            }
        }else{
            if(type==null){
                dataGridResult=getCouponStockRecordsFitCodeByPage(code,page,rows);
                System.out.println("fit code");
            }else{
                dataGridResult=getCouponStockRecordsFitCodeAndTypeByPage(code,type,page,rows);
                System.out.println("fit all");
            }
        }
        /*if(code==null||code.equals("")&&type!=null){
            dataGridResult=getCouponStockRecordsFitTypeByPage(type,page,rows);
            //getCouponStockRecordsFitCodeByPage(code,page,rows);
            System.out.println("fit type");
        }else if(code==null||code.equals("")&&type==null){
            dataGridResult=getCouponStockRecordsByPage(page,rows);
            System.out.println("fit nothing");
        }else if(code!=null||!code.equals("")&&type==null){
            dataGridResult=getCouponStockRecordsFitCodeByPage(code,page,rows);
            System.out.println("fit code");
        }else if(code!=null||!code.equals("")&&type!=null){
            dataGridResult=getCouponStockRecordsFitCodeAndTypeByPage(code,type,page,rows);
            System.out.println("fit all");
        }*/
        return dataGridResult;
    }

    @Override
    public DataGridResult getCouponStockRecordsFitCodeByPage(String code, Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andCouponCodeEqualTo(code);
        example.setOrderByClause("update_time desc");

        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        PageInfo<CouponStock> pageInfo=new PageInfo<CouponStock>(couponStockList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(couponStockList);
        return dataGridResult;
    }

    @Override
    public DataGridResult getCouponStockRecordsByPage(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        CouponStockExample example=new CouponStockExample();
        example.setOrderByClause("update_time desc");

        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        PageInfo<CouponStock> pageInfo=new PageInfo<CouponStock>(couponStockList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(couponStockList);
        return dataGridResult;
    }

    @Override
    public DataGridResult getCouponStockRecordsFitTypeByPage(Integer type,Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andCouponTypeEqualTo(type);
        example.setOrderByClause("update_time desc");
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        PageInfo<CouponStock> pageInfo=new PageInfo<CouponStock>(couponStockList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(couponStockList);
        return dataGridResult;
    }

    @Override
    public DataGridResult getCouponStockRecordsFitCodeAndTypeByPage(String code,Integer type,Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andCouponCodeEqualTo(code).andCouponTypeEqualTo(type);
        example.setOrderByClause("update_time desc");
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        PageInfo<CouponStock> pageInfo=new PageInfo<CouponStock>(couponStockList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(couponStockList);
        return dataGridResult;
    }

    @Override
    public List<CouponStock> getCouponStockById(Long id){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andIdEqualTo(id);
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        return couponStockList;
    }

    @Override
    public List<UserCoupon> getCouponStockByStockIdAndUserId(Long stockId,Long userId){
        Date now=new Date();
        UserCouponExample example=new UserCouponExample();
        example.createCriteria().andStockIdEqualTo(stockId).andUserIdEqualTo(userId);
        List<UserCoupon> list=userCouponMapper.selectByExample(example);
        list=userCouponListFilter(list);
        return list;
    }

    @Override
    public boolean updateCouponStockRecord(CouponStock couponStock){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andIdEqualTo(couponStock.getId());
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
            return false;
        }
        couponStockMapper.updateByPrimaryKeySelective(couponStock);
        return true;
    }

    @Override
    public boolean deleteCouponStockRecord(CouponStock couponStock){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andIdEqualTo(couponStock.getId());
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
            return false;
        }
        couponStockMapper.deleteByPrimaryKey(couponStock.getId());
        return true;
    }


    /*String randomcode = "";
    // 用字符数组的方式随机
    String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
        char c = m[(int) (Math.random() * 62)];
        // 保证六位随机数之间没有重复的
        if (randomcode.contains(String.valueOf(c))) {
            j--;
            continue;
        }
        randomcode = randomcode + c;
    }
        return randomcode;*/

    @Override
    public String buildCouponCode(){
        boolean flag=true;
        int time=0;
        while(flag){
            /*String randomcode = "";
            // 用字符数组的方式随机
            String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            char[] m = model.toCharArray();
            for (int j = 0; j < 6; j++) {
                char c = m[(int) (Math.random() * 62)];
                // 保证六位随机数之间没有重复的
                if (randomcode.contains(String.valueOf(c))) {
                    j--;
                    continue;
                }
                randomcode = randomcode + c;
            }*/
            String randomcode = "";
            // 用字符数组的方式随机
            String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            char[] m = model.toCharArray();
            int nums=(int)(Math.random()*3)+2;
            Integer[] list= {-1,-1,-1,-1,-1,-1};
            for(int i=0;i<nums;i++) {
                list[i]=(int)(Math.random()*6);
                while(judgeEcho(list,i)!=true) {
                    list[i]=(int)(Math.random()*6);
                }
            }
		    /*System.out.println(nums);
		    for(int i=0;i<6;i++) {
			    System.out.println(list[i]);
		    }*/
            for (int j = 0; j < 6; j++) {
                char c;
                if(judgeNumPosition(j,list)) {
                    c = m[(int) (Math.random() * 10)];
                }else {
                    c = m[(int) (Math.random() * 52)+10];
                }
                // 保证六位随机数之间没有重复的
                if (randomcode.contains(String.valueOf(c))) {
                    j--;
                    continue;
                }
                randomcode = randomcode + c;
            }
            //校检产生的优惠码是否已存在
            CouponStockExample example=new CouponStockExample();
            example.createCriteria().andCouponCodeEqualTo(randomcode);
            List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);

            if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
                //生成优惠码成功
                return randomcode;
            }else if(time>=10000){
                break;
            }else{
                time++;
            }
        }
        return "系统超时，请重试";
    }

    @Override
    public boolean insertCouponStockRecord(CouponStock couponStock){
        couponStockMapper.insertSelective(couponStock);
        return true;
    }

    @Override
    public boolean judgeEcho(Integer[] list,int position) {
        for(int i=0;i<position;i++) {
            if(list[i]==list[position].intValue()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean judgeNumPosition(int iter,Integer[] list) {
        for(int i=0;i<6;i++) {
            if(iter==list[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkInclude(List<Integer>list,int num){
        for(Integer iter:list){
            if(iter==num)
                return true;
        }
        return false;
    }

    @Override
    public JsonResult getCouponTypes(){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria();
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        List<Integer>typeList=new ArrayList<Integer>();
        for(CouponStock iter:couponStockList){
            if(checkInclude(typeList,iter.getCouponType())==true){
                //do nothing
            }else{
                typeList.add(iter.getCouponType());
            }
        }
        return JsonResult.success(typeList);
    }

    @Override
    public DataGridResult getCouponStockRecords(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        CouponStockExample example=new CouponStockExample();
        example.createCriteria();
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);

        PageInfo<CouponStock> pageInfo=new PageInfo<CouponStock>(couponStockList);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(couponStockList);
        return dataGridResult;
    }

    @Override
    public boolean deleteCouponRecord(Long id){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andIdEqualTo(id);
        List<CouponStock> couponStockList=couponStockMapper.selectByExample(example);
        if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
            return false;
        }else{
            couponStockMapper.deleteByPrimaryKey(id);
            return true;
        }
    }

    //生成用户的推广码
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean bulidExtendCode(Long userId){

        if(judgeUserHaveExtendCodeOrNot(userId)==true){
            return false;
        }

        CouponStock record=new CouponStock();
        record.setCouponType(2);

        ResourceBundle resource = ResourceBundle.getBundle("discountAmount");
        String key = resource.getString("discount_amount");
        long amount=Long.parseLong(key);
        System.out.println(amount);

        record.setDiscountAmount(amount);
        record.setStock(-1);
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser(userId);

        record.setCouponStartTime(new Date());

        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)+1);
        Date endDate=curr.getTime();
        record.setCouponEndTime(endDate);


        String extendCode=this.buildCouponCode();
        record.setCouponCode(extendCode);

        couponStockMapper.insertSelective(record);


        CouponStockExample couponStockExample=new CouponStockExample();
        couponStockExample.createCriteria().andCouponCodeEqualTo(extendCode);
        List<CouponStock>couponStockList=couponStockMapper.selectByExample(couponStockExample);
        if(couponStockList==null||couponStockList.size()==0)
            return false;

        User userRecord=userMapper.selectByPrimaryKey(userId.intValue());


        userRecord.setCouponCode(couponStockList.get(0).getId());
        userRecord.setCouponMoney(record.getDiscountAmount());
        userMapper.updateByPrimaryKeySelective(userRecord);
        return true;
    }

    //判断用户是否生成过推广码
    @Override
    public boolean judgeUserHaveExtendCodeOrNot(Long userId){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andCreateUserEqualTo(userId).andCouponTypeEqualTo(2);
        List<CouponStock>couponStockList=couponStockMapper.selectByExample(example);
        if(couponStockList==null||couponStockList!=null&&couponStockList.size()==0){
            return false;
        }
        return true;
    }

    @Override
    public String getCouponCodeById(Long id){
        CouponStockExample example=new CouponStockExample();
        example.createCriteria().andIdEqualTo(id);
        List<CouponStock>couponStockList=couponStockMapper.selectByExample(example);
        if(couponStockList==null||couponStockList.size()==0){
            return null;
        }
        return couponStockList.get(0).getCouponCode();
    }
}
