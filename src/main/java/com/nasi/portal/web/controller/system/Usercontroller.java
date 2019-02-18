package com.nasi.portal.web.controller.system;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nasi.portal.common.helper.ControllerHelper;
import com.nasi.portal.common.helper.IOHelper;
import com.nasi.portal.data.mapper.HotelMapper;
import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.Hotel;
import com.nasi.portal.data.model.HotelCriteria;
import com.nasi.portal.data.model.Pager;
import com.nasi.portal.data.model.User;
import com.nasi.portal.service.WebConfigService;
import com.nasi.portal.web.controller.BaseController;

@Controller
@RequestMapping("/system/user")
public class Usercontroller extends BaseController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private HotelMapper hotelMapper;

    @Resource
    private WebConfigService webConfigService;

//    @RequestMapping("/list")
//    public ModelAndView list(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo,
//            @RequestParam(value = "pageSize", required = false) Integer pageSize, HttpServletRequest request,
//            HttpServletResponse response) {
//
//        pageNo = pageNo == null ? 0 : pageNo;
//        pageSize = pageSize == null ? 10 : pageSize;
//
//        User user = ControllerHelper.getBean(request, "user", User.class);
//
//
//        UserCriteria userCriteria = new UserCriteria();
//
//        Criteria criteria = userCriteria.createCriteria();
//
//
//        if (user != null) {
//            if (StringUtils.isNotBlank(user.getEmail())) {
//                criteria.andEmailEqualTo(user.getEmail());
//            }
//
//            if (StringUtils.isNotBlank(user.getNameCn())) {
//                criteria.andNameCnEqualTo(user.getNameCn());
//            }
//
//            if (StringUtils.isNotBlank(user.getNameEn())) {
//                criteria.andNameEnEqualTo(user.getNameEn());
//            }
//        }
//
//        Pager<User> page = null;
//        List<User> list = null;
//        ModelAndView view = new ModelAndView("system/user/userList");
//
//        int count = userMapper.countByExample(userCriteria);
//
//        page = new Pager<User>(pageNo, pageSize, count);
//
//        userCriteria.setStart(page.getStart());
//        userCriteria.setEnd(page.getPageSize());
//        list = userMapper.selectByExample(userCriteria);
//        page.setData(list);
//        view.addObject("page", page);
//        if (user != null) {
//            view.addObject("email", user.getEmail());
//            view.addObject("nameCn", user.getNameCn());
//            view.addObject("nameEn", user.getNameEn());
//        }
//
//        return view;
//    }

    @RequestMapping("/showAdd")
    public ModelAndView showAdd(HttpServletRequest request, HttpServletResponse response) {

        HotelCriteria criteria = new HotelCriteria();
        List<Hotel> hotelList = hotelMapper.selectByExample(criteria);

        ModelAndView view = new ModelAndView("system/user/userAdd");

        view.addObject("hotelList", hotelList);

        return view;
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "userPhotoAttach",
            required = false) MultipartFile userPhotoAttach) {

        User operator = getCurrentLoginUser(request);
        User user = ControllerHelper.getBean(request, "user", User.class);

        if (operator == null) {
            printAlertAndRefresh(response, "用户没有登录，不能录入用户！", "/system/user/list");
            return null;
        }

        if (StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(user.getPassword())) {

            printAlertAndRefresh(response, "邮箱或者密码不能为空！", "/system/user/list");
            return null;

        }
        if (user.getRoleId() == null) {
            printAlertAndRefresh(response, "角色不能为空！", "/system/user/list");
            return null;
        }
        try {
            Integer code = (int) (Math.random() * 900000 + 100000);
            user.setCouponCode(code.longValue());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());


            userMapper.insertSelective(user);

            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();
            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            if (!userPhotoAttach.isEmpty()) {

                String suffixName =
                        userPhotoAttach.getOriginalFilename().substring(
                                userPhotoAttach.getOriginalFilename().indexOf("."));

                if (StringUtils.isNotBlank(suffixName)) {
                    String relativePath =
                            String.format("upload%sattach%suser%suserattach_%s%s", fileSeparator, fileSeparator,
                                    fileSeparator, user.getId(), suffixName);
                    File courseTargetAttach = new File(basePath + relativePath);
                    IOHelper.makeDirs(courseTargetAttach);
                    userPhotoAttach.transferTo(courseTargetAttach);

                    user.setPhoto(relativePath);
                } else {
                    printAlertAndRefresh(response, "上传头像失败！", "/system/user/list");
                    return null;
                }

            }
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            printAlertAndRefresh(response, "用户录入失败！", "/system/user/list");
            return null;
        }
        printAlertAndRefresh(response, "用户录入成功！", "/system/user/list");
        return null;

    }

    @RequestMapping("/userEdit")
    public ModelAndView courseEdit(@RequestParam(value = "userId", required = true) Integer userId,
            HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("system/user/userEdit");
        if (userId == null) {
            return view;
        }
        User user = userMapper.selectByPrimaryKey(userId);

        if (user != null) {

            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();
            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }
            user.setPhoto(basePath + user.getPhoto());

            view.addObject("user", user);
        }



        HotelCriteria hotelCriteria = new HotelCriteria();
        List<Hotel> hotelList = hotelMapper.selectByExample(hotelCriteria);
        view.addObject("hotelList", hotelList);
        Map<Integer, Hotel> hotelMap = new HashMap<Integer, Hotel>();
        for (Hotel hotel : hotelList) {
            hotelMap.put(hotel.getId(), hotel);
        }
        view.addObject("hotelMap", hotelMap);
        return view;
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "userPhotoAttach", required = false) MultipartFile userPhotoAttach) {

        User user = ControllerHelper.getBean(request, "user", User.class);
        
        
        if (user.getId() == null) {
            printAlertAndRefresh(response, "系统发生错误！", "/system/user/list");
            return null;
        }

        try {
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);

            String basePath = webConfigService.getByKey("ATTACH_PATH").getV();
            String fileSeparator = System.getProperty("file.separator");
            if (!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }

            if (!userPhotoAttach.isEmpty()) {

                String suffixName =
                        userPhotoAttach.getOriginalFilename().substring(
                                userPhotoAttach.getOriginalFilename().indexOf("."));

                if (StringUtils.isNotBlank(suffixName)) {
                    String relativePath =
                            String.format("upload%sattach%suser%suserattach_%s%s", fileSeparator, fileSeparator,
                                    fileSeparator, user.getId(), suffixName);
                    File courseTargetAttach = new File(basePath + relativePath);
                    courseTargetAttach.delete();
                    IOHelper.makeDirs(courseTargetAttach);
                    userPhotoAttach.transferTo(courseTargetAttach);

                    user.setPhoto(relativePath);
                } else {
                    printAlertAndRefresh(response, "上传头像失败！", "/system/user/list");
                    return null;
                }

            }
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            printAlertAndRefresh(response, "更新失败！", "/system/user/list");
            logger.error(e.getMessage(), e);
            return null;
        }
        printAlertAndRefresh(response, "更新成功！", "/system/user/list");
        return null;

    }

}
