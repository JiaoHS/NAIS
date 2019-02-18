package com.nasi.portal.web.controller.caohao;

import com.nasi.portal.common.constants.SessonConstants;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * created by xdCao on 2018/4/17
 */

@Controller
@RequestMapping(value = "/user")
public class PersonalInfoController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home() {
        return "personalCenter/personHome";
    }

    @RequestMapping("/info")
    public String info() {
        return "personalCenter/personalInfoShow";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public JsonResult<?> showPersonInfo(HttpServletRequest request, @RequestParam("id") Integer id) {
//        User currentLoginUser = getCurrentLoginUser(request);
//        currentLoginUser = userService.getByPrimaryKey(currentLoginUser.getId());
        User currentLoginUser = userService.getByPrimaryKey(id);
        request.getSession().setAttribute(SessonConstants.CURRENT_LOGIN_USER, currentLoginUser);
        return JsonResult.success(currentLoginUser);
    }

    @RequestMapping("/update")
    public String update() {
        return "personalCenter/personalInfoSet";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public JsonResult<?> saveData(@RequestParam(value = "nameCn", required = false) String nameCn,
                                  @RequestParam(value = "nameEn", required = false) String nameEn,
                                  @RequestParam(value = "gender", required = false) Integer gender,
                                  @RequestParam(value = "birthDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
                                  @RequestParam(value = "cardType", required = false) Integer cardType,
                                  @RequestParam(value = "idCard", required = false) String idCard,
                                  @RequestParam(value = "telCn", required = false) String telCn,
                                  @RequestParam(value = "email", required = false) String email,
                                  @RequestParam(value = "fromSchoolCn", required = false) String fromSchoolCn,
                                  @RequestParam(value = "major", required = false) String major,
                                  @RequestParam(value = "schoolAddress", required = false) String schoolAddress,
                                  @RequestParam(value = "emcUser", required = false) String emcUser,
                                  @RequestParam(value = "emcTel", required = false) String emcTel,
                                  @RequestParam(value = "emcRole", required = false) String emcRole,
                                  @RequestParam(value = "emcGender", required = false) Integer emcGender,
                                  @RequestParam(value = "weChat", required = false) String weChat,
                                  @RequestParam(value = "homeAddress", required = false) String homeAddress,
                                  @RequestParam(value = "file", required = false) MultipartFile file,
                                  HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);

        user = userService.getByPrimaryKey(user.getId());
        user.setNameCn(nameCn);
        user.setNameEn(nameEn);
        /*0：女 1：男*/
        user.setGender(gender);
        user.setBirthDate(birthDate);
        /*0: 身份证 1: 护照 2: */
        user.setCardtype(cardType);
        user.setIdCard(idCard);
        user.setTelCn(telCn);
        user.setEmail(email);
        user.setFromSchoolCn(fromSchoolCn);
        user.setMajor(major);
        user.setSchooladdress(schoolAddress);
        user.setEmcUser(emcUser);
        user.setEmcTel(emcTel);
        user.setEmcrole(emcRole);
        user.setEmcgender(emcGender);
        user.setWechat(weChat);
        user.setHomeaddress(homeAddress);


        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static") + File.separator + "photos";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setPhoto("/static/photos" + File.separator + filename);
        } else {
        }


        userService.insertOrUpdate(user);


        request.getSession().setAttribute(SessonConstants.CURRENT_LOGIN_USER, user);

        return JsonResult.success(user);
    }

    @RequestMapping("/course")
    public String course() {
        return "personalCenter/coursesCenter";
    }

    @RequestMapping("/coupon")
    public String coupon() {
        return "personalCenter/couponCenter";
    }

    @RequestMapping("/hotel")
    public String hotel() {
        return "personalCenter/hotelChoose";
    }

    @RequestMapping("/hotelPay")
    public String hotelPay() {
        return "personalCenter/hotelPay";
    }

    @RequestMapping("/orderCenter")
    public String orderCenter() {
        return "personalCenter/orderCenter";
    }

    @RequestMapping("/chooseCourses")
    public String chooseCourses() {
        return "personalCenter/chooseCourses";
    }

    @RequestMapping("/coursesOrderPreview")
    public String coursesOrderPreview() {
        return "personalCenter/coursesOrderPreview";
    }

    @RequestMapping("/coursesOrderReview")
    public String coursesOrderReview() {
        return "personalCenter/coursesOrderReview";
    }

    @RequestMapping("/protocol")
    public String protocol() {
        return "personalCenter/protocol";
    }

    @RequestMapping("/payWay")
    public String payWay() {
        return "personalCenter/payWay";
    }

    @RequestMapping("/paySuccess")
    public String paySuccess() {
        return "personalCenter/paySuccess";
    }

    @RequestMapping("/payFail")
    public String payFail() {
        return "personalCenter/payFail";
    }

    @RequestMapping("/teacherHome")
    public String teacherHome() {
        return "teachers/teacherHome";
    }

    @RequestMapping("/teacherIndex")
    public String teacherIndex() {
        return "teachers/teacherIndex";
    }

    @RequestMapping(value = "/application")
    public String application() {
        return "applicationInformation/applicationhome";
    }

    @RequestMapping(value = "/applicationGuide")
    public String applicationGuide() {
        return "applicationInformation/applicationGuide";
    }

    @RequestMapping(value = "/translateGradeGuide")
    public String translateGradeGuide() {
        return "applicationInformation/translateGradeGuide";
    }

    @RequestMapping(value = "/academicStandards")
    public String academicStandards() {
        return "applicationInformation/academicStandards";
    }

    @RequestMapping(value = "/gradeStandards")
    public String gradeStandards() {
        return "applicationInformation/gradeStandards";
    }

    @RequestMapping(value = "/teachingQualityEvaluation")
    public String teachingQualityEvaluation() {
        return "applicationInformation/teachingQualityEvaluation";
    }

    @RequestMapping(value = "/transcriptCertification")
    public String transcriptCertification() {
        return "applicationInformation/transcriptCertification";
    }

    @RequestMapping(value = "/tuitionInformation")
    public String tuitionInformation() {
        return "applicationInformation/tuitionInformation";
    }

    @RequestMapping(value = "/paymentInformation")
    public String paymentInformation() {
        return "applicationInformation/paymentInformation";
    }

    @RequestMapping(value = "/refundPolicy")
    public String refundPolicy() {
        return "applicationInformation/refundPolicy";
    }

    @RequestMapping(value = "/studentSystem")
    public String studentSystem() {
        return "teachers/studentSystem";
    }

    @RequestMapping(value = "/SelectCampus")
    public String SelectCampus() {
        return "personalCenter/SelectCampus";
    }
}
