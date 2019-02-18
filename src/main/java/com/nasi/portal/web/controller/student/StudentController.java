/**
 * @author anliyong@baidu.com
 * 2015-7-18 下午8:16:08
 */
package com.nasi.portal.web.controller.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nasi.portal.common.constants.ConfigConstants;
import com.nasi.portal.common.constants.SessonConstants;
import com.nasi.portal.common.helper.IOHelper;
import com.nasi.portal.data.mapper.CouponCodeMapper;
import com.nasi.portal.data.mapper.CourseReportMapper;
import com.nasi.portal.data.mapper.PaidOrderMapper;
import com.nasi.portal.data.mapper.PaidSubjectMapper;
import com.nasi.portal.data.model.CouponCode;
import com.nasi.portal.data.model.CouponCodeCriteria;
import com.nasi.portal.data.model.CourseArrange;
import com.nasi.portal.data.model.CourseHomeWorkAssign;
import com.nasi.portal.data.model.CourseHomeWorkCommit;
import com.nasi.portal.data.model.CourseReport;
import com.nasi.portal.data.model.CourseReportCriteria;
import com.nasi.portal.data.model.CourseWare;
import com.nasi.portal.data.model.Hotel;
import com.nasi.portal.data.model.PaidOrder;
import com.nasi.portal.data.model.PaidOrderCriteria;
import com.nasi.portal.data.model.PaidSubject;
import com.nasi.portal.data.model.PaidSubjectCriteria;
import com.nasi.portal.data.model.School;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.dict.CodeStatus;
import com.nasi.portal.data.model.dict.CodeType;
import com.nasi.portal.data.model.dict.OrderStatus;
import com.nasi.portal.data.model.dict.SubjectStatus;
import com.nasi.portal.data.model.dict.SubjectType;
import com.nasi.portal.service.CourseArrangeService;
import com.nasi.portal.service.CourseHomeWorkAssignService;
import com.nasi.portal.service.CourseHomeWorkCommitService;
import com.nasi.portal.service.CourseReportService;
import com.nasi.portal.service.CourseWareService;
import com.nasi.portal.service.HotelService;
import com.nasi.portal.service.SchoolService;
import com.nasi.portal.service.UserService;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.AssignCommitVo;
import com.nasi.portal.web.model.CourseInfo;
import com.nasi.portal.web.model.JsonResult;

/**
 * @author anliyong@baidu.com 2015-7-18下午8:16:08
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private CourseArrangeService courseArrangeService;

    @Resource
    private CourseReportService courseReportService;

//    @Resource
//    private HotelService hotelService;
    
    @Resource
    private PaidOrderMapper paidOrderMapper;
    
    @Resource
    private PaidSubjectMapper paidSubjectMapper;
    
    @Resource
    private CouponCodeMapper couponCodeMapper;
    
    @Resource
    private CourseReportMapper courseReportMapper;
    
    @Resource
    private CourseWareService courseWareService;
    
    @Resource
    private CourseHomeWorkAssignService courseHomeWorkAssignService;
    
    @Resource
    private CourseHomeWorkCommitService courseHomeWorkCommitService;

    @Resource
    private WebConfigService webConfigService;
    
    int maxFileByteSize = 1 * 1024 * 1024 * 5;


    @RequestMapping("/home.do")
    public String home() {
        return "student/home";
    }

    @RequestMapping("/myData.do")
    public String myData(HttpServletRequest request, Model model) {
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        model.addAttribute("user", user);
        return "student/myData";
    }
    
    @RequestMapping("entryBankPaid.do")
    public String entryBankPaid(HttpServletRequest request, Model model,@RequestParam("orderId")Long orderId){
        
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        
        Long userId = Long.valueOf(user.getId());
        
        PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andOrderStatusNotEqualTo(OrderStatus.DEL.getIndex());
        
        List<PaidOrder> orders = paidOrderMapper.selectByExample(orderCriteria);
        if (CollectionUtils.isNotEmpty(orders)) {
            PaidOrder order = orders.get(0);
            if (order.getId().equals(orderId)) {
                model.addAttribute("paidOrder", order);
            }
        }
        
        return "student/paidOrder";
        
    }

    @RequestMapping("myOrder.do")
    public String paidOrder(HttpServletRequest request, Model model){
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        
        if (user == null) {
            return "";
        }
        
        PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(Long.valueOf(user.getId())).andOrderStatusNotEqualTo(OrderStatus.DEL.getIndex());
        
        List<PaidOrder> orders = paidOrderMapper.selectByExample(orderCriteria);
        
        if (CollectionUtils.isEmpty(orders)) {
            PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
            subjectCriteria.setOrderByClause(" page_order ");
            subjectCriteria.createCriteria().andSubjectTypeEqualTo(SubjectType.CLASS.getIndex()).andSubjectStatusEqualTo(SubjectStatus.USEFUL.getIndex());
            List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
            model.addAttribute("classSubjects", classSubjects);
            return "student/orderChoise";
        }else {
                
                PaidOrder paidOrder = orders.get(0);
                model.addAttribute("paidOrder", paidOrder);
                
                if (StringUtils.isNotBlank(paidOrder.getSubjectIds())) {
                    List<Long> subIds = new ArrayList<Long>();
                    String[] subjectStrs = paidOrder.getSubjectIds().split(",");
                    for (String s : subjectStrs) {
                        subIds.add(Long.valueOf(s));
                    }
                    
                    PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
                    subjectCriteria.setOrderByClause(" page_order ");
                    subjectCriteria.createCriteria().andIdIn(subIds);
                    List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
                    
                    model.addAttribute("classSubjects", classSubjects);
                }
                
                return "student/myPaid";
        }
    }
    
    @RequestMapping("resetBill.do")
    public String resetBill(HttpServletRequest request, Model model,@RequestParam("orderId")Long orderId){
        
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        
        Long userId = Long.valueOf(user.getId());
        
        PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andOrderStatusNotEqualTo(OrderStatus.DEL.getIndex());
        
        List<PaidOrder> orders = paidOrderMapper.selectByExample(orderCriteria);
        if (CollectionUtils.isNotEmpty(orders)) {
            PaidOrder order = orders.get(0);
            if (order.getId().equals(orderId)) {
                if (StringUtils.isNotBlank(order.getCouponCode())) {
                    CouponCodeCriteria codeCriteria = new CouponCodeCriteria();
                    codeCriteria.createCriteria().andCouponCodeEqualTo(order.getCouponCode());
                    CouponCode code2Set = new CouponCode();
                    code2Set.setUseStatus(CodeStatus.INIT.getIndex());
                    couponCodeMapper.updateByExampleSelective(code2Set, codeCriteria);
                }
                PaidOrder order2Set = new PaidOrder();
                order2Set.setOrderStatus(OrderStatus.DEL.getIndex());
                order2Set.setId(orderId);
                order2Set.setUpdateUser(userId);
                order2Set.setUpdateTime(new Date());
                paidOrderMapper.updateByPrimaryKeySelective(order2Set);
            }
        }
        
        PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
        subjectCriteria.setOrderByClause(" page_order ");
        subjectCriteria.createCriteria().andSubjectTypeEqualTo(SubjectType.CLASS.getIndex()).andSubjectStatusEqualTo(SubjectStatus.USEFUL.getIndex());
        List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
        model.addAttribute("classSubjects", classSubjects);
        return "student/orderChoise";
    }
    
    
    @RequestMapping("validateCoupon.do")
    public @ResponseBody JSONObject validateCoupon(HttpServletRequest request, Model model, @RequestParam(value="couponCode",defaultValue="",required=false)String couponCode){
        JSONObject res = new JSONObject();

        if (StringUtils.isBlank(couponCode)) {
            logger.info("没有传入优惠代码");
            res.put("flag", true); 
            return res;
        }
        
        CouponCodeCriteria couponCodeCriteria = new CouponCodeCriteria();
        couponCodeCriteria.createCriteria().andCouponCodeEqualTo(couponCode);
        List<CouponCode> codes = couponCodeMapper.selectByExample(couponCodeCriteria);
        if (CollectionUtils.isNotEmpty(codes)) {
            CouponCode code = codes.get(0);
            if (code.getCouponType() == CodeType.UNIQUE.getIndex()) {
                if (code.getUseStatus() != CodeStatus.INIT.getIndex()) {
                    res.put("flag", false); 
                    res.put("desc", "优惠码已经被使用过了");
                    return res;
                }
            }
            
            res.put("flag", true); 
            res.put("couponMoney", code.getCouponMoney()); 
            return res;
        }else {
            logger.info("没有找到优惠代码 code = "+ couponCode);
            res.put("flag", false);
            res.put("desc", "没有找到这样的优惠码");
            return res;
        }
    }
    
    
    @RequestMapping("deleteCourse.do")
    public @ResponseBody JSONObject deleteCourse(HttpServletRequest request, Model model, @RequestParam(value="id",defaultValue="0",required=false)Integer id){
        JSONObject res = new JSONObject();
        
        if (id == null || id ==0) {
            res.put("flag", false);
            return res;
        }
        
        User user = getCurrentLoginUser(request);
        
        try {
            CourseReportCriteria reportCriteria = new CourseReportCriteria();
            reportCriteria.createCriteria().andArrangeIdEqualTo(id).andStudentIdEqualTo(user.getId());
            courseReportMapper.deleteByExample(reportCriteria);
            res.put("flag", true);
        } catch (Exception e) {
            logger.info("删除课程失败 user = "+ user.getId() + " arrid = "+id);
            res.put("flag", false);
        
        }
        return res;
        
    }
    
    
    @RequestMapping("myPaidBill.do")
    public String myPaid(HttpServletRequest request, Model model, @RequestParam(value="optionIds",defaultValue="",required=false)String optionIds, 
            @RequestParam(value="cuponCode",defaultValue="",required=false)String cuponCode){
        
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        
        Long userId = Long.valueOf(user.getId());

        if (StringUtils.isBlank(optionIds) && StringUtils.isBlank(cuponCode)) {
            PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
            orderCriteria.createCriteria().andUserIdEqualTo(userId).andOrderStatusNotEqualTo(OrderStatus.DEL.getIndex());
            List<PaidOrder> orderList = paidOrderMapper.selectByExample(orderCriteria);
            if (CollectionUtils.isNotEmpty(orderList)) {
                
                PaidOrder paidOrder = orderList.get(0);
                model.addAttribute("paidOrder", paidOrder);
                
                if (StringUtils.isNotBlank(paidOrder.getSubjectIds())) {
                    List<Long> subIds = new ArrayList<Long>();
                    String[] subjectStrs = paidOrder.getSubjectIds().split(",");
                    for (String s : subjectStrs) {
                        subIds.add(Long.valueOf(s));
                    }
                    
                    PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
                    subjectCriteria.setOrderByClause(" page_order ");
                    subjectCriteria.createCriteria().andIdIn(subIds);
                    List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
                    
                    model.addAttribute("classSubjects", classSubjects);
                }
                
                return "student/myPaid";
            }
        }
        
        Long needPayMoney = 0L;
        Long realMoney = 0L;
        Long couponMoney = 0L;
        
        List<Long> optionIdList = new ArrayList<Long>();
        String[] optionIdArray = optionIds.split(",");
        for (String s : optionIdArray) {
            try {
                optionIdList.add(Long.valueOf(s));
            } catch (Exception e) {
                logger.info("",e);
                continue;
            }
        }
        
        PaidOrder paidOrder = new PaidOrder();
        paidOrder.setUserId(userId);
        paidOrder.setOrderStatus(OrderStatus.INIT.getIndex());
        paidOrder.setCreateUser(userId);
        paidOrder.setUpdateUser(userId);
        paidOrder.setCreateTime(new Date());
        paidOrder.setUpdateTime(new Date());
        paidOrder.setSubjectIds(optionIds);
        
        //算选的课钱
        if (CollectionUtils.isNotEmpty(optionIdList)) {
            PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
            subjectCriteria.createCriteria().andIdIn(optionIdList);
            List<PaidSubject> subjects = paidSubjectMapper.selectByExample(subjectCriteria);
            if (CollectionUtils.isNotEmpty(subjects)) {
                for (PaidSubject subject : subjects) {
                    if (subject.getSubjectStatus() == SubjectStatus.USEFUL.getIndex()) {
                        realMoney += subject.getSubjectMoney();
                        needPayMoney += subject.getSubjectMoney();
                    }
                }
            }
        }
        
        //算优惠券钱
        CouponCode code = null;
        if (StringUtils.isNotBlank(cuponCode)) {
            CouponCodeCriteria couponCodeCriteria = new CouponCodeCriteria();
            couponCodeCriteria.createCriteria().andCouponCodeEqualTo(cuponCode);
            List<CouponCode> codes = couponCodeMapper.selectByExample(couponCodeCriteria);
            if (CollectionUtils.isNotEmpty(codes)) {
                code = codes.get(0);
            }
        }
        if (code != null) {
            couponMoney += code.getCouponMoney();
            needPayMoney -= code.getCouponMoney();
            if (code.getCouponType() == CodeType.UNIQUE.getIndex()) {
                code.setUseStatus(CodeStatus.USING.getIndex());
                couponCodeMapper.updateByPrimaryKeySelective(code);
            }
            cuponCode = code.getCouponCode();
            
            paidOrder.setCouponCode(cuponCode);
            paidOrder.setCouponMoney(couponMoney);
        }
        
        paidOrder.setRealMoney(realMoney);
        paidOrder.setNeedPayMoney(needPayMoney);
        
        paidOrderMapper.insertSelective(paidOrder);
        
        
        if (StringUtils.isNotBlank(paidOrder.getSubjectIds())) {
            List<Long> subIds = new ArrayList<Long>();
            String[] subjectStrs = paidOrder.getSubjectIds().split(",");
            for (String s : subjectStrs) {
                subIds.add(Long.valueOf(s));
            }
            
            PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
            subjectCriteria.setOrderByClause(" page_order ");
            subjectCriteria.createCriteria().andIdIn(subIds);
            List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
            
            model.addAttribute("classSubjects", classSubjects);
        }
        
        model.addAttribute("paidOrder", paidOrder);
        
        return "student/myPaid";
        
    }
    @RequestMapping("submitPayBill.do")
    public @ResponseBody JSONObject submitPayBill(HttpServletRequest request, Model model,
            @RequestParam(value="orderId",defaultValue="null",required=false)Long orderId, 
            @RequestParam(value="paidName",defaultValue="",required=false)String paidName,
            @RequestParam(value="paidBank",defaultValue="",required=false)String paidBank,
            @RequestParam(value="paidAcctount",defaultValue="",required=false)String paidAcctount,
            @RequestParam(value="paidDesc",defaultValue="",required=false)String paidDesc,
            @RequestParam(value="paidMoney",defaultValue="null",required=false)Long paidMoney,
            @RequestParam(value="paidPhone",defaultValue="",required=false)String paidPhone){
                
        JSONObject res = new JSONObject();
        if (orderId == null || StringUtils.isBlank(paidName) || 
                StringUtils.isBlank(paidBank) || StringUtils.isBlank(paidBank) || 
                StringUtils.isBlank(paidAcctount) || StringUtils.isBlank(paidDesc) ||  StringUtils.isBlank(paidPhone) ||
                (paidMoney == null || paidMoney == 0)) {
            res.put("flag", false);
            res.put("desc", "输入信息有误，请检查！");
            return res;
        }
        
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        
        Long userId = Long.valueOf(user.getId());
        
        PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andOrderStatusNotEqualTo(OrderStatus.DEL.getIndex());
        
        List<PaidOrder> orders = paidOrderMapper.selectByExample(orderCriteria);
        if (CollectionUtils.isNotEmpty(orders)) {
            PaidOrder order = orders.get(0);
            if (!order.getId().equals(orderId)) {
                res.put("flag", false);
                res.put("desc", "您无权编辑此订单！");
                return res;
            }
            
            order.setUpdateTime(new Date());
            order.setUpdateUser(userId);
            order.setPaidUser(paidName);
            order.setPaidBank(paidBank);
            order.setPaidMoney(paidMoney);
            order.setPaidAccount(paidAcctount);
            order.setPaidDesc(paidDesc);
            order.setPaidPhone(paidPhone);
            paidOrderMapper.updateByPrimaryKeySelective(order);
            //TODO 发邮件
            res.put("flag", true);
            res.put("desc", "付款信息提交成功，在工作人员审核通过之前，您可以随时更新您的付款信息！");
            return res;
        }
        return res;
    }
    
    @RequestMapping("/saveData.do")
    @ResponseBody
    public String saveData(@RequestParam("nameCn") String nameCn, @RequestParam("nameEn") String nameEn,
            @RequestParam("birthDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
            @RequestParam("idCard") String idCard, @RequestParam("telCn") String telCn,
            @RequestParam("telEn") String telEn, @RequestParam("emcUser") String emcUser,
            @RequestParam("fromSchoolCn") String fromSchoolCn, @RequestParam("fromSchoolEn") String fromSchoolEn,
            @RequestParam("address") String address, @RequestParam("postAdd") String postAdd,
            @RequestParam("postUser") String postUser, @RequestParam("postTel") String postTel,
            //password
            @RequestParam("passwordPrev") String passwordPrev, @RequestParam("passwordNew") String passwordNew,
            @RequestParam("passwordConfirm") String passwordConfirm, 
            HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);
        boolean needReset = false;
        if (StringUtils.isNotBlank(passwordPrev)) {
            
            if (StringUtils.isNotBlank(passwordNew)) {
                if (user.getPassword().equals(passwordPrev)) {
                    if (!passwordNew.equals(passwordConfirm)) {
                        return "两次输入的密码不一致";
                    }
                    needReset = true;
                }else {
                    return "原密码不正确";
                }
            }else {
                return "未录入新密码";
            }
        }else {
            if (StringUtils.isNotBlank(passwordNew)) {
                return "未录入原密码";
            }
        }
        
        user = userService.getByPrimaryKey(user.getId());
        if (needReset) {
            user.setPassword(passwordNew);
        }
        user.setNameCn(nameCn);
        user.setNameEn(nameEn);
        user.setBirthDate(birthDate);
        user.setIdCard(idCard);
        user.setTelCn(telCn);
        user.setTelEn(telEn);
        user.setEmcUser(emcUser);
        user.setFromSchoolCn(fromSchoolCn);
        user.setFromSchoolEn(fromSchoolEn);
        user.setAddress(address);
        user.setPostAdd(postAdd);
        user.setPostUser(postUser);
        user.setPostTel(postTel);
        userService.insertOrUpdate(user);

        request.getSession().setAttribute(SessonConstants.CURRENT_LOGIN_USER, user);

        return "";
    }

    @RequestMapping("uploadPhoto.do")
    @ResponseBody
    public String uploadPhoto(@RequestParam(value = "photo", required = false) MultipartFile photo,
            HttpServletRequest request, HttpServletResponse response) {

        boolean success = false;
        try {

            String fileSeparator = System.getProperty("file.separator");
            String basePath = request.getSession().getServletContext().getRealPath(fileSeparator);
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            User user = getCurrentLoginUser(request);
            user = userService.getByPrimaryKey(user.getId());

            if (!photo.isEmpty()) {
                String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1);
                String relativePath = String.format("upload%sphoto%s%s.%s", fileSeparator, fileSeparator, user.getId(),
                        suffix);
                File courseTargetAttach = new File(basePath + relativePath);
                IOHelper.makeDirs(courseTargetAttach);

                photo.transferTo(courseTargetAttach);

                user.setPhoto(relativePath);
                userService.insertOrUpdate(user);
            }
            success = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
        }

        if (success) {
            return "<script type=\"text/javascript\">parent.uploadResult('1');</script>";
        } else {
            return "<script type=\"text/javascript\">parent.uploadResult('0');</script>";
        }
    }

    @RequestMapping("selectCourse.do")
    public String selectCourse(Model model, HttpServletRequest request) {

        User user = getCurrentLoginUser(request);
        
        PaidOrderCriteria orderCriteria = new PaidOrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(Long.valueOf(user.getId())).andOrderStatusNotEqualTo(OrderStatus.DEL.getIndex());
        
        List<PaidOrder> orders = paidOrderMapper.selectByExample(orderCriteria);
        
        if (CollectionUtils.isEmpty(orders)) {
            PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
            subjectCriteria.setOrderByClause(" page_order ");
            subjectCriteria.createCriteria().andSubjectTypeEqualTo(SubjectType.CLASS.getIndex()).andSubjectStatusEqualTo(SubjectStatus.USEFUL.getIndex());
            List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
            model.addAttribute("classSubjects", classSubjects);
            model.addAttribute("preTitle","请在选课前先");
            return "student/orderChoise";
        }else {
            PaidOrder paidOrder = orders.get(0);
            if (paidOrder.getOrderStatus() != OrderStatus.PASS.getIndex()) {
                model.addAttribute("paidOrder", paidOrder);
                
                if (StringUtils.isNotBlank(paidOrder.getSubjectIds())) {
                    List<Long> subIds = new ArrayList<Long>();
                    String[] subjectStrs = paidOrder.getSubjectIds().split(",");
                    for (String s : subjectStrs) {
                        subIds.add(Long.valueOf(s));
                    }
                    
                    PaidSubjectCriteria subjectCriteria = new PaidSubjectCriteria();
                    subjectCriteria.setOrderByClause(" page_order ");
                    subjectCriteria.createCriteria().andIdIn(subIds);
                    List<PaidSubject> classSubjects = paidSubjectMapper.selectByExample(subjectCriteria);
                    
                    model.addAttribute("classSubjects", classSubjects);
                }
                
                model.addAttribute("preTitle", "（请等待订单审核完毕后再进行选课操作）");
                
                return "student/myPaid";
            }
        }

        List<School> schools = schoolService.getSchools();

        model.addAttribute("schools", schools);

        List<CourseReport> reports = courseReportService.getByUserId(user.getId());

        List<CourseArrange> arranges = new ArrayList<CourseArrange>();

        if (reports != null && !reports.isEmpty()) {
            for (CourseReport report : reports) {
                arranges.add(courseArrangeService.getByPrimaryKey(report.getArrangeId()));
            }
        }

        model.addAttribute("arranges", arranges);

        return "student/selectCourse";
    }

    @RequestMapping("showCourseBySchoolId.do")
    public String showCourseBySchoolId(@RequestParam(value = "schoolId") Integer schoolId, HttpServletRequest request,
            Model model) {

        ConvertUtils.register(null, java.util.Date.class);

        User user = getCurrentLoginUser(request);

        List<CourseArrange> arranges = courseArrangeService.getActiveBySchoolId(schoolId);
        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();

        List<CourseReport> reports = courseReportService.getByUserId(user.getId());

        Set<Integer> set = new HashSet<Integer>();

        if (reports != null && !reports.isEmpty()) {
            for (CourseReport report : reports) {
                set.add(report.getArrangeId());
            }
        }

        if (arranges != null && !arranges.isEmpty()) {
            for (CourseArrange courseArrange : arranges) {
                CourseInfo info = new CourseInfo();
                try {
                    BeanUtils.copyProperties(info, courseArrange);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e.fillInStackTrace());
                }
                if (set.contains(courseArrange.getId())) {
                    info.setSelectEnable(1);
                }
                courseInfos.add(info);
            }
        }
        model.addAttribute("arranges", courseInfos);

        return "student/selectCourseModal";
    }

    @RequestMapping("saveSelectCourse.do")
    @ResponseBody
    public JsonResult<?> saveSelectCourse(@RequestParam(value = "aids") String aids, HttpServletRequest request) {

        User user = getCurrentLoginUser(request);

        if (aids != null && !"".equals(aids)) {
            String[] aidArray = aids.split(",");
            for (String aid : aidArray) {
                CourseArrange arr = courseArrangeService.getByPrimaryKey(Integer.valueOf(aid));
                CourseReport cr = new CourseReport();
                cr.setStudentId(user.getId());
                cr.setArrangeId(arr.getId());
                cr.setCourseId(arr.getCourseId());
                cr.setCourseNameCn(arr.getCourseNameCn());
                cr.setCourseNameEn(arr.getCourseNameEn());
                cr.setCreateTime(new Date());
                cr.setCreateUser(user.getId());
                cr.setNameCn(user.getNameCn());
                cr.setNameEn(user.getNameEn());
                cr.setStudentAccount(user.getEmail());
                cr.setProfessorId(arr.getProfessorId());
                cr.setProfessorNameCn(arr.getProfessorNameCn());
                cr.setProfessorNameEn(arr.getProfessorNameEn());
                cr.setSchoolId(arr.getSchoolId());
                cr.setSchoolNameCn(arr.getSchoolNameCn());
                cr.setSchoolNameEn(arr.getSchoolNameEn());
                cr.setUpdateTime(new Date());
                cr.setUpdateUser(user.getId());
                courseReportService.insertOrUpdate(cr);
            }
        }

        return JsonResult.success(true);
    }

    @RequestMapping("showScore.do")
    public String showScore(HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);

        List<CourseReport> reports = courseReportService.getByUserId(user.getId());

        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();

        if (reports != null && reports.size() > 0) {
            for (CourseReport courseReport : reports) {
                CourseArrange courseArrange = courseArrangeService.getByPrimaryKey(courseReport.getArrangeId());
                CourseInfo info = new CourseInfo();
                try {
                    BeanUtils.copyProperties(info, courseArrange);
                    info.setScore(courseReport.getScore());
                    courseInfos.add(info);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e.fillInStackTrace());
                }

            }

        }

        model.addAttribute("courseInfos", courseInfos);

        return "student/score";
    }

//    @RequestMapping("applyHotel.do")
//    public String applyHotel(HttpServletRequest request, Model model) {
//        List<Hotel> hotels = hotelService.getAll();
//        model.addAttribute("hotels", hotels);
//        User user = getCurrentLoginUser(request);
//        user = userService.getByPrimaryKey(user.getId());
//        model.addAttribute("user", user);
//        return "student/applyHotel";
//    }
    
    @RequestMapping("saveApplyHotel.do")
    @ResponseBody
    public JsonResult<?> saveApplyHotel(@RequestParam(value = "hotelId") Integer hotelId, HttpServletRequest request, Model model) {
        
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        user.setHotelId(Long.valueOf(hotelId));
        
        userService.insertOrUpdate(user);
        return JsonResult.success(true);
    }
    
    @RequestMapping("coupon.do")
    public String coupon(HttpServletRequest request, Model model) {
        User user = getCurrentLoginUser(request);
        user = userService.getByPrimaryKey(user.getId());
        model.addAttribute("user", user);
        return "student/coupon";
    }
    
    @RequestMapping("wareList.do")
    public String wareList(HttpServletRequest request, Model model, Long arrangeId){
        
        List<CourseWare> warelist = courseWareService.getListByArrangeId(arrangeId);
        model.addAttribute("arrangeId",arrangeId);
        model.addAttribute("wares", warelist);
        return "student/warelist";
    }
    
    
    @RequestMapping("workCommitList.do")
    public String workCommitList(HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);

        List<CourseReport> reports = courseReportService.getByUserId(user.getId());

        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();

        if (reports != null && reports.size() > 0) {
            for (CourseReport courseReport : reports) {
                CourseArrange courseArrange = courseArrangeService.getByPrimaryKey(courseReport.getArrangeId());
                CourseInfo info = new CourseInfo();
                try {
                    BeanUtils.copyProperties(info, courseArrange);
                    info.setScore(courseReport.getScore());
                    courseInfos.add(info);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e.fillInStackTrace());
                }

            }

        }

        model.addAttribute("courseInfos", courseInfos);

        return "student/commitlist";
    }
    
    @RequestMapping("showAssignList.do")
    public String showAssignList(HttpServletRequest request, Model model, Long arrangeId){
        
        List<AssignCommitVo> vos = new ArrayList<AssignCommitVo>();
        List<CourseHomeWorkAssign> assignList = courseHomeWorkAssignService.getAssignListByArrangeList(Arrays.asList(arrangeId));
        if (CollectionUtils.isNotEmpty(assignList)) {

            for (CourseHomeWorkAssign assign : assignList) {
                AssignCommitVo commitVo = new AssignCommitVo();
                try {
                    BeanUtils.copyProperties(commitVo, assign);
                    CourseHomeWorkCommit commit = courseHomeWorkCommitService.getByAssignIdAndArrangeId(assign.getId(), arrangeId);
                    if (commit != null) {
                        commitVo.setIsCommited(true);
                        commitVo.setCommitId(Long.valueOf(commit.getId()));
                        commitVo.setCommitStatus(commit.getCommitStatus());
                        if (commit.getCommitStatus() == 3) {
                            commitVo.setScoreDesc(String.valueOf(commit.getCommitThisScore()) + "/" + String.valueOf(commit.getCommitTotalScore()));
                        }
                        
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    continue;
                }
                vos.add(commitVo);
            }

        }
        
        model.addAttribute("assignList", vos);
        model.addAttribute("arrangeId",arrangeId);
        return "student/assignlist";
    }
    
    @RequestMapping("submitCommit")
    @ResponseBody
    public String submitCommit(HttpServletRequest request, Model model, 
            @RequestParam(value="assignId", required = true)Long assignId,
            @RequestParam(value="arrangeId", required = true)Long arrangeId,
            @RequestParam(value="commitDesc", required = true)String commitDesc,
            @RequestParam(value="attach", required = true) MultipartFile attach){
        
        boolean success = false;
        String code = "";
        
        if (attach.getSize() > maxFileByteSize) {
            return "<script type=\"text/javascript\">parent.uploadResult('2','"+code+"');</script>";
        }
        
        try {
            User user = getCurrentLoginUser(request);
            
            CourseHomeWorkAssign assign = courseHomeWorkAssignService.getById(assignId);
            if (assign != null && user != null) {
                
                CourseHomeWorkCommit oriCommit = courseHomeWorkCommitService.getByAssignIdAndArrangeId(assignId, arrangeId);
                if (oriCommit != null) {
                    courseHomeWorkCommitService.disableById(Long.valueOf(oriCommit.getId()));
                }
                
                CourseHomeWorkCommit commit = new CourseHomeWorkCommit();
                
                commit.setArrangeId(assign.getArrangeId());
                commit.setAssignId(assignId);
                commit.setAssignName(assign.getWorkName());
                commit.setCommitStatus(1);
                commit.setCommitType(assign.getWorkType());
                
                commit.setCourseCode(assign.getCourseCode());
                commit.setCourseNameCn(assign.getCourseNameCn());
                commit.setCourseNameEn(assign.getCourseNameEn());
                
                commit.setWorkPath(assign.getWorkPath());
                commit.setCommitTotalScore(assign.getWorkTotalScore());
                commit.setCommitThisScore(0);
                commit.setCommitDesc(commitDesc);
                
                commit.setCommitTime(new Date());
                commit.setCreateTime(new Date());
                commit.setUpdateTime(new Date());
                
                commit.setStudentId(user.getId());
                commit.setStudentNameEn(user.getNameEn());
                commit.setStudentNameCn(user.getNameCn());
                
                commit.setUpdateUser(user.getId().longValue());
                commit.setCreateUser(user.getId().longValue());
                
                String basePath = webConfigService.getByKey(ConfigConstants.ATTACH_PATH).getV();
                String fileSeparator = System.getProperty("file.separator");
                
                if (attach.getOriginalFilename().contains(fileSeparator)) {
                    return "<script type=\"text/javascript\">parent.uploadResult('3','"+fileSeparator+"');</script>";
                }
                
                if (!basePath.endsWith(fileSeparator)) {
                    basePath += fileSeparator;
                }
                
                if (!attach.isEmpty()) {
                    String relativePath = String.format("upload%scommit%s%s%s%s%s%s%s%s", fileSeparator,
                            fileSeparator,assign.getCourseCode(),fileSeparator,user.getId(), fileSeparator,assign.getId(),fileSeparator, attach.getOriginalFilename());
                    
                    File courseTargetAttach = new File(basePath + relativePath);
                    IOHelper.makeDirs(courseTargetAttach);
                    
                    attach.transferTo(courseTargetAttach);
                    
                    commit.setCommitPath(relativePath);
                }
                
                courseHomeWorkCommitService.insert(commit);
                
                success =true;
                
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            success = false;
        }
        
        if (success) {
            return "<script type=\"text/javascript\">parent.uploadResult('1','"+code+"');</script>";
        } else {
            return "<script type=\"text/javascript\">parent.uploadResult('0','"+code+"');</script>";
        }
        
    }
    
}
