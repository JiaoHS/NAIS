package com.nasi.portal.web.controller.system;

import java.util.List;

import javax.annotation.Resource;

import com.nasi.portal.data.model.UserExample;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.dict.Role;
import com.nasi.portal.web.controller.BaseController;

@RequestMapping(value="/system/user")
@Controller
public class UserSystemController extends BaseController {
    
    @Resource
    private UserMapper userMapper;
    
    @RequestMapping(value="/ajaxLoadProfessor")
    public @ResponseBody JSONObject ajaxLoadProfessor(){
        JSONObject json = new JSONObject();

        UserExample example=new UserExample();
        example.createCriteria().andRoleIdEqualTo(Role.PROFESSOR.getRoleId());
        
        List<User> users = userMapper.selectByExample(example);
        
        if (CollectionUtils.isNotEmpty(users)) {
            json.put("flg", true);
            json.put("options", JSONArray.fromObject(users));
            return json;
        }
        json.put("flg", false);
        return json;
    }
    
}
