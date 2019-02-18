package com.nasi.portal.web.controller.caohao;


import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.UserExample;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * created by xdCao on 2018/4/17
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    @ResponseBody
    public JsonResult<?> userTest(){

        List<User> users = userMapper.selectByExample(new UserExample());
        return JsonResult.success(users);

    }

    @RequestMapping("/file")
    public String fileTest(){
        return "fileTest";
    }


    @RequestMapping(value = "/red")
    public String redirect(){
        return "redirect:http://www.baidu.com";
    }



}
