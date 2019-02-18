package com.nasi.portal.web.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.data.mapper.CouponCodeMapper;
import com.nasi.portal.data.mapper.PaidOrderMapper;
import com.nasi.portal.data.mapper.PaidSubjectMapper;
import com.nasi.portal.data.model.CouponCode;
import com.nasi.portal.data.model.CouponCodeCriteria;
import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.CourseReport;
import com.nasi.portal.data.model.CourseReportCriteria;
import com.nasi.portal.data.model.Pager;
import com.nasi.portal.data.model.PaidOrder;
import com.nasi.portal.data.model.PaidOrderCriteria;
import com.nasi.portal.data.model.PaidSubject;
import com.nasi.portal.data.model.PaidSubjectCriteria;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.dict.CodeStatus;
import com.nasi.portal.data.model.dict.CodeType;
import com.nasi.portal.data.model.dict.OrderStatus;
import com.nasi.portal.service.CourseArrangeService;
import com.nasi.portal.service.CourseReportService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.OrderVo;

@Controller
@RequestMapping(value = "/system/order")
public class OrderSystemController extends BaseController {
    
    @Resource
    private PaidOrderMapper paidOrderMapper; 
    
    @Resource
    private CouponCodeMapper couponCodeMapper;
    
    @Resource
    private UserService userService;
    
    @Resource
    private CourseReportService courseReportService; 
    
    @Resource
    private CourseArrangeService courseArrangeService; 
    
    @Resource
    private PaidSubjectMapper paidSubjectMapper;
    
    @RequestMapping(value = "list")
    public String list(@RequestParam(value = "orderId", defaultValue = "0", required = false)Long orderId,
            @RequestParam(value = "email", defaultValue = "", required = false)String email,
            @RequestParam(value = "orderStatus", defaultValue = "0", required = false)Integer orderStatus,
            @RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize, Model model) {
        
        
        PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
        PaidOrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        
        if (StringUtils.isNotBlank(email)) {
            User queryUser = userService.getActiveUserByEmail(email);
            if (queryUser != null) {
                criteria.andUserIdEqualTo(queryUser.getId().longValue());
            }
        }
        if (orderId != null && orderId != 0) {
            criteria.andIdEqualTo(orderId);
        }else {
            orderId = null;
        }
        
        if (orderStatus != null && orderStatus != 0) {
            criteria.andOrderStatusEqualTo(orderStatus);
        }else {
            orderStatus = 0;
        }
        
        int count = paidOrderMapper.countByExample(orderCriteria);

        Pager<OrderVo> pager = new Pager<OrderVo>(pageNo, pageSize, count);
        orderCriteria.setStart(pager.getStart());
        orderCriteria.setEnd(pager.getPageSize());

        List<PaidOrder> orders = paidOrderMapper.selectByExample(orderCriteria);

        List<OrderVo> data = new ArrayList<OrderVo>();
        
        if (CollectionUtils.isNotEmpty(orders)) {
            for (PaidOrder order : orders) {
                
                OrderVo vo = new OrderVo();
                try {
                    vo.setId(order.getId());
                    vo.setUserId(order.getUserId());
                    vo.setOrderStatus(order.getOrderStatus());
                    vo.setCreateUser(order.getCreateUser());
                    vo.setUpdateUser(order.getUpdateUser());
                    vo.setCreateTime(order.getCreateTime());
                    vo.setUpdateTime(order.getUpdateTime());
                    vo.setRealMoney(order.getRealMoney());
                    vo.setCouponCode(order.getCouponCode());
                    vo.setCouponMoney(order.getCouponMoney());
                    vo.setNeedPayMoney(order.getNeedPayMoney());
                    vo.setSubjectIds(order.getSubjectIds());
                    vo.setPaidAccount(order.getPaidAccount());
                    vo.setPaidUser(order.getPaidUser());
                    vo.setPaidBank(order.getPaidBank());
                    vo.setPaidMoney(order.getPaidMoney());
                    vo.setPaidDesc(order.getPaidDesc());
                    vo.setPaidPhone(order.getPaidPhone());
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                User user = userService.getByPrimaryKey(order.getUserId().intValue());
                vo.setUserName(user.getNameCn());
                vo.setEmail(user.getEmail());
                data.add(vo);
            }
            
        }
        
        pager.setData(data);

        model.addAttribute("pager", pager);
        model.addAttribute("orderId",orderId);
        model.addAttribute("email",email);
        model.addAttribute("orderStatus", orderStatus);

        return "system/order/list";
    }
    
    
    @RequestMapping(value="showUserCourse")
    public String showUserCourse(HttpServletRequest request, Model model, @RequestParam("userId")Long userId){
        
        if (userId == null || userId == 0) {
            return "";
        }
        
        CourseReportCriteria reportCriteria = new CourseReportCriteria();
        reportCriteria.createCriteria().andStudentIdEqualTo(userId.intValue());
        
        List<CourseReport> reports = courseReportService.getByUserId(userId.intValue());
        List<CourseArrange> arranges = new ArrayList<CourseArrange>();

        if (reports != null && !reports.isEmpty()) {
            for (CourseReport report : reports) {
                arranges.add(courseArrangeService.getByPrimaryKey(report.getArrangeId()));
            }
        }
        
        model.addAttribute("arranges",arranges);
        return "system/order/userCourse";
    }
    
    
    @RequestMapping(value="showOrderDetail")
    public String showOrderDetail(HttpServletRequest request, Model model, @RequestParam("orderId")Long orderId, 
            @RequestParam("email")String email, @RequestParam("userName")String userName){
        
        if (orderId == null || orderId == 0) {
            return "";
        }
        
        PaidOrder order = paidOrderMapper.selectByPrimaryKey(orderId);
        
        if (StringUtils.isNotBlank(order.getSubjectIds())) {
            List<Long> subIds = new ArrayList<Long>();
            String[] subjectStrs = order.getSubjectIds().split(",");
            for (String s : subjectStrs) {
                subIds.add(Long.valueOf(s));
            }
            
            PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
            subjectCriteria.setOrderByClause(" page_order ");
            subjectCriteria.createCriteria().andIdIn(subIds);
            List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
            
            model.addAttribute("classSubjects", classSubjects);
        }
        
        model.addAttribute("userName", userName);
        model.addAttribute("email", email);
        model.addAttribute("order",order);
        return "system/order/showOrderDetail";
    }
    
    
    @RequestMapping(value = "approve")
    public @ResponseBody JSONObject approve(HttpServletRequest request, Model model,@RequestParam("orderId")Long orderId) {

        JSONObject json = new JSONObject();
        try {
            User user = getCurrentLoginUser(request);
            
            PaidOrder paidOrder = paidOrderMapper.selectByPrimaryKey(orderId);
            if (paidOrder != null) {
                paidOrder.setOrderStatus(OrderStatus.PASS.getIndex());
                paidOrder.setId(orderId);
                paidOrder.setUpdateTime(new Date());
                paidOrder.setUpdateUser(user.getId().longValue());
                paidOrderMapper.updateByPrimaryKeySelective(paidOrder);
            }
            if (StringUtils.isNotBlank(paidOrder.getCouponCode())) {
                
                CouponCodeCriteria codeCriteria = new CouponCodeCriteria();
                codeCriteria.createCriteria().andCouponCodeEqualTo(paidOrder.getCouponCode());
                
                List<CouponCode> codes = couponCodeMapper.selectByExample(codeCriteria);
                if (CollectionUtils.isNotEmpty(codes)) {
                    CouponCode code = codes.get(0);
                    if (code.getCouponType() == CodeType.UNIQUE.getIndex()) {
                        CouponCode code2Set = new CouponCode();
                        code2Set.setUseStatus(CodeStatus.USED.getIndex());
                        code2Set.setUpdateTime(new Date());
                        code2Set.setUpdateUser(user.getId().longValue());
                        couponCodeMapper.updateByExampleSelective(code2Set, codeCriteria);
                    }
                }
                
            }
            json.put("flag", true);
        } catch (Exception e) {
            logger.info("",e);
            json.put("flag", false);
        }
        return json;
    }
    
    
}
