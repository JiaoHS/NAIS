package com.nasi.portal.web.controller.huanghe;

import com.nasi.portal.service.UserService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: River
 * @Date:Created in  9:30 2018/5/27
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find")
    @ResponseBody
    public DataGridResult findInfoList(
                                       @RequestParam(value = "nameEn",required = false) String nameEn,
                                       @RequestParam(value = "page") Integer page,
                                       @RequestParam(value = "rows") Integer rows){

        DataGridResult userListByPage=null;

        if (nameEn == null ||nameEn.equals("")){
            userListByPage = userService.getUserListByPage(page,rows);
            return userListByPage;
        } else {
            userListByPage = userService.findUserListPageByNameEn(nameEn,page,rows);
            return userListByPage;
        }
    }
}
