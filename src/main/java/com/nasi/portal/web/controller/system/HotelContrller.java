package com.nasi.portal.web.controller.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nasi.portal.common.helper.ControllerHelper;
import com.nasi.portal.data.mapper.HotelMapper;
import com.nasi.portal.data.model.Hotel;
import com.nasi.portal.data.model.HotelCriteria;
import com.nasi.portal.data.model.HotelCriteria.Criteria;
import com.nasi.portal.data.model.Pager;
import com.nasi.portal.data.model.User;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.model.JsonResult;

@Controller
@RequestMapping("/system/hotel")
public class HotelContrller extends BaseController {
    @Resource
    private HotelMapper hotelMapper;

    @RequestMapping("/list")
    public ModelAndView list(Model model, 
            @RequestParam(value = "pageNo",required = false) Integer pageNo,
            @RequestParam(value = "pageSize", required = false) Integer pageSize, HttpServletRequest request,
            HttpServletResponse response) {

        pageNo = pageNo == null ? 0 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        Hotel hotel = ControllerHelper.getBean(request, "hotel", Hotel.class);

        HotelCriteria hotelCriteria = new HotelCriteria();
        Criteria criteria = hotelCriteria.createCriteria();

        if (hotel != null) {
            if (StringUtils.isNotBlank(hotel.getHotelNameCn())) {
                criteria.andHotelNameCnEqualTo(hotel.getHotelNameCn());
            }
            if (StringUtils.isNotBlank(hotel.getHotelNameEn())) {
                criteria.andHotelNameEnEqualTo(hotel.getHotelNameEn());
            }
            if (StringUtils.isNotBlank(hotel.getDescriptionCn())) {
                criteria.andDescriptionCnEqualTo(hotel.getDescriptionCn());
            }
            if (StringUtils.isNotBlank(hotel.getDescriptionEn())) {
                criteria.andDescriptionEnEqualTo(hotel.getDescriptionEn());
            }
        }




        Pager<Hotel> page = null;
        List<Hotel> list = null;
        ModelAndView view = new ModelAndView("system/hotel/hotelList");

        int count = hotelMapper.countByExample(hotelCriteria);

        page = new Pager<Hotel>(pageNo, pageSize, count);

        hotelCriteria.setStart(page.getStart());
        hotelCriteria.setEnd(page.getPageSize());
        list = hotelMapper.selectByExample(hotelCriteria);
        page.setData(list);
        view.addObject("page", page);
        if (hotel != null) {
            view.addObject("hotelNameCn", hotel.getHotelNameCn());
            view.addObject("hotelNameEn", hotel.getHotelNameEn());
        }

        return view;
    }

    @RequestMapping("/showAdd")
    public String showAdd(HttpServletRequest request, HttpServletResponse response) {

        return "system/hotel/hotelAdd";
    }

    @RequestMapping(value = "/addHotel")
    @ResponseBody
    public JsonResult<?> addHotel(HttpServletRequest request, Model model) {

        User user = getCurrentLoginUser(request);
        Hotel hotel = ControllerHelper.getBean(request, "hotel", Hotel.class);

        if (StringUtils.isBlank(hotel.getHotelNameCn()) || StringUtils.isBlank(hotel.getHotelNameEn())) {

            return JsonResult.error("酒店中文名、酒店英文名不能为空！");

        }

        if (user == null) {
            return JsonResult.error("用户没有登录，不能录入酒店！");
        }
        hotel.setCreateTime(new Date());
        hotel.setCreateUser(user.getId());
        hotel.setUpdateTime(new Date());
        hotel.setUpdateUser(user.getId());

        hotelMapper.insert(hotel);

        return JsonResult.success("酒店录入成功！");

    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult<?>
            delete(@PathVariable Integer hotelId, HttpServletRequest request,
            HttpServletResponse response) {

        if (hotelId == null) {
            return JsonResult.error("系统发生错误！");
        }
        int count = hotelMapper.deleteByPrimaryKey(hotelId);
        if (count == 1) {
            return JsonResult.success("删除成功！");
        } else {
            return JsonResult.error("删除失败！");
        }
    }

    @RequestMapping("/hotelEdit")
    public ModelAndView courseEdit(@RequestParam(value = "hotelId", required = true) Integer hotelId,
            HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("system/hotel/hotelEdit");
        if (hotelId == null) {
            return view;
        }
        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
        if (hotel != null) {
            view.addObject("hotel", hotel);
        }

        return view;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public JsonResult<?> edit(@RequestParam("hotelId") Integer hotelId,
            @RequestParam("hotelNameCn") String hotelNameCn, @RequestParam("hotelNameEn") String hotelNameEn,
            @RequestParam("hotelDescCn") String hotelDescCn, @RequestParam("hotelDescEn") String hotelDescEn) {

        if (hotelId == null) {
            return JsonResult.error("系统发生错误！");
        }

        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);

        if (hotel != null) {
            String oldHotelNameCn = hotel.getHotelNameCn();
            boolean sign = false;
            if (!oldHotelNameCn.equals(hotelNameCn)) {
                sign = true;
                hotel.setHotelNameCn(hotelNameCn);
            }

            String oldHotelNameEn = hotel.getHotelNameEn();
            if (!oldHotelNameEn.equals(hotelNameEn)) {
                sign = true;
                hotel.setHotelNameEn(hotelNameEn);
            }

            String oldHotelDescCn = hotel.getDescriptionCn();
            if (!oldHotelDescCn.equals(hotelDescCn)) {
                sign = true;
                hotel.setDescriptionCn(hotelDescCn);
            }

            String oldHotelDescEn = hotel.getDescriptionEn();
            if (!oldHotelDescEn.equals(hotelDescEn)) {
                sign = true;
                hotel.setDescriptionEn(hotelDescEn);
            }

            if (!sign) {
                return JsonResult.error("无任何修改！");
            } else {
                int count = hotelMapper.updateByPrimaryKey(hotel);
                if (count == 1) {
                    return JsonResult.success("修改成功！");
                } else {
                    return JsonResult.error("修改失败！");
                }
            }
        } else {
            return JsonResult.error("查询不到所编辑的酒店！");
        }
    }


}
