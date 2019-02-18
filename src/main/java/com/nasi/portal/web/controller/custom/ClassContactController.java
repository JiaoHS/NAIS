package com.nasi.portal.web.controller.custom;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nasi.portal.data.mapper.ClassContactMapper;
import com.nasi.portal.data.model.ClassContact;
import com.nasi.portal.data.model.ClassContactCriteria;
import com.nasi.portal.web.controller.BaseController;

@Controller
@RequestMapping("/62/contact/")
public class ClassContactController extends BaseController{

    @Autowired
    private ClassContactMapper classContactMapper;
    
    @RequestMapping("query")
    public String queryContact( @RequestParam(value = "contactName", required = false, defaultValue = "")String contactName,
            Model model){
        
        ClassContactCriteria classContactCriteria = new ClassContactCriteria();
        ClassContactCriteria.Criteria criteria = classContactCriteria.createCriteria();
        
        if (StringUtils.isNotBlank(contactName)) {
            criteria.andContactNameLike("%" + contactName + "%");
        }
        
        List<ClassContact> contacts = classContactMapper.selectByExample(classContactCriteria);
        
        model.addAttribute("contacts", contacts);
        model.addAttribute("contactName", contactName);

        return "system/contact/list";
        
    }
    
    @RequestMapping("add")
    @ResponseBody
    public JSONObject addContact( @RequestParam(value = "contactName", required = false, defaultValue = "")String contactName,
            @RequestParam(value = "contactMoblie", required = false, defaultValue = "")String contactMoblie,
            @RequestParam(value = "contactPhone", required = false, defaultValue = "")String contactPhone,
            @RequestParam(value = "contactAdd", required = false, defaultValue = "")String contactAdd,
            Model model){
        
        JSONObject json = new JSONObject();
        try {
            
            if (StringUtils.isBlank(contactName) || StringUtils.isBlank(contactMoblie)) {
                json.put("flag", false);
                json.put("desc", "姓名和手机号码为必填项！");
                return json;
            }
            
            ClassContactCriteria classContactCriteria = new ClassContactCriteria();
            ClassContactCriteria.Criteria criteria = classContactCriteria.createCriteria();
            criteria.andContactNameEqualTo(contactName);
            
            List<ClassContact> contacts = classContactMapper.selectByExample(classContactCriteria);
            
            if (CollectionUtils.isNotEmpty(contacts)) {
                json.put("flag", false);
                json.put("desc", "已经存在的通讯录姓名！");
                return json;
            }
            
            ClassContact classContact = new ClassContact();
            classContact.setContactName(contactName);
            classContact.setContactMoblie(contactMoblie);
            classContact.setContactPhone(contactPhone);
            classContact.setContactAdd(contactAdd);
            classContact.setCreateTime(new Date());
            classContact.setUpdateTime(new Date());
            
            Integer affectRow = classContactMapper.insertSelective(classContact);
            if (affectRow != null && affectRow > 0) {
                json.put("flag", true);
                json.put("desc", String.format("保存通讯录[%s]成功！", contactName));
                return json;
            }
            
            json.put("flag", false);
            json.put("desc", String.format("保存通讯录[%s]出现异常！", contactName));
            return json;
            
        } catch (Exception e) {
            json.put("flag", false);
            json.put("desc", String.format("保存通讯录[%s]出现异常！", contactName));
            return json;
        }
        
    }
    
    @RequestMapping("modify")
    @ResponseBody
    public JSONObject modifyContact( 
            @RequestParam(value = "id", required = false, defaultValue = "")Long id,
            @RequestParam(value = "contactName", required = false, defaultValue = "")String contactName,
            @RequestParam(value = "contactMoblie", required = false, defaultValue = "")String contactMoblie,
            @RequestParam(value = "contactPhone", required = false, defaultValue = "")String contactPhone,
            @RequestParam(value = "contactAdd", required = false, defaultValue = "")String contactAdd,
            Model model){
        
        JSONObject json = new JSONObject();
        try {
            
            if (id == null) {
                json.put("flag", false);
                json.put("desc", "ID不得为空");
                return json;
            }
            
            if (StringUtils.isBlank(contactName) || StringUtils.isBlank(contactMoblie)) {
                json.put("flag", false);
                json.put("desc", "姓名和手机号码为必填项！");
                return json;
            }
            
            ClassContact classContact = new ClassContact();
            classContact.setId(id);
            classContact.setContactName(contactName);
            classContact.setContactMoblie(contactMoblie);
            classContact.setContactPhone(contactPhone);
            classContact.setContactAdd(contactAdd);
            classContact.setUpdateTime(new Date());
            
            Integer affectRow = classContactMapper.updateByPrimaryKeySelective(classContact);
            if (affectRow != null && affectRow > 0) {
                json.put("flag", true);
                json.put("desc", String.format("更新通讯录[%s]成功！", contactName));
                return json;
            }
            
            json.put("flag", false);
            json.put("desc", String.format("更新通讯录[%s]出现异常！", contactName));
            return json;
            
        } catch (Exception e) {
            json.put("flag", false);
            json.put("desc", String.format("更新通讯录[%s]出现异常！", contactName));
            return json;
        }
        
    }
    
    
}
