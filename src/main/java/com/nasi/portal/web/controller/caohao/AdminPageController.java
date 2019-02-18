package com.nasi.portal.web.controller.caohao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by xdCao on 2018/4/22
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping(value = "/index.html")
    public String indexPage(){
        return "admin/index";
    }

    @RequestMapping(value = "/info.html")
    public String infoPage(){
        return "admin/info";
    }

    @RequestMapping(value = "/info-add.html")
    public String infoAddPage(){
        return "admin/info-add";
    }

    @RequestMapping(value = "/info-edit.html")
    public String infoEditPage(){
        return "admin/info-edit";
    }

    @RequestMapping(value = "/professor.html")
    public String professorPage(){
        return "admin/professor";
    }

    @RequestMapping(value = "/professor-add.html")
    public String professorAddPage(){
        return "admin/professor-add";
    }

    @RequestMapping(value = "/professor-edit.html")
    public String professorEditPage(){
        return "admin/professor-edit";
    }

    @RequestMapping(value = "/campus.html")
    public String campusPage(){
        return "admin/campus";
    }

    @RequestMapping(value = "/campus-add.html")
    public String campusAddPage(){
        return "admin/campus-add";
    }

    @RequestMapping(value = "/campus-edit.html")
    public String campusEditPage(){
        return "admin/campus-edit";
    }

    @RequestMapping(value = "/course-arrange.html")
    public String courseArrangePage(){
        return "admin/course-arrange";
    }

    @RequestMapping(value = "/coupon.html")
    public String couponPage(){
        return "admin/coupon";
    }

    @RequestMapping(value = "/coupon-add.html")
    public String couponAddPage(){
        return "admin/coupon-add";
    }

    @RequestMapping(value = "/coupon-edit.html")
    public String couponEditPage(){
        return "admin/coupon-edit";
    }

    @RequestMapping(value = "course-arrange-add.html")
    public String courseArrangeAddPage(){
        return  "admin/course-arrange-add";
    }

    @RequestMapping(value = "course-arrange-edit.html")
    public String courseArrangeEditPage(){
        return  "admin/course-arrange-edit";
    }

    @RequestMapping(value = "price-rule.html")
    public String priceRulePage(){
        return "admin/price-rule";
    }

    @RequestMapping(value = "price-rule-add.html")
    public String priceRuleAddPage(){
        return  "admin/price-rule-add";
    }

    @RequestMapping(value = "/order.html")
    public String orderPage(){
        return "admin/order";
    }

    @RequestMapping(value = "/order-add.html")
    public String orderAddPage(){
        return "admin/order-add";
    }

    @RequestMapping(value = "/order-edit.html")
    public String orderEditPage(){
        return "admin/order-edit";
    }
    @RequestMapping(value = "/order-info.html")
    public String orderInfoPage(){
        return "admin/order-info";
    }

    @RequestMapping(value = "/user.html")
    public String userPage(){return "admin/user";}

    @RequestMapping(value = "/hotel.html")
    public String hotelPage(){return "admin/hotel";}
    @RequestMapping(value = "/hotel-add.html")
    public String hotelAddPage(){
        return "admin/hotel-add";
    }

    @RequestMapping(value = "/hotel-edit.html")
    public String hotelEditPage(){
        return "admin/hotel-edit";
    }

    @RequestMapping(value = "/viewDetails.html")
    public String viewDetails(){return "admin/viewDetails";}

    @RequestMapping(value = "/viewScore.html")
    public String viewScore(){return "admin/viewScore";}

    @RequestMapping(value = "/viewCampus.html")
    public String test(){return "admin/viewCampus";}
}
