/**
 * @author anliyong@baidu.com
 * 2015-7-17 下午10:21:57
 */
package com.nasi.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.UserMapper;
import com.nasi.portal.data.model.User;
import com.nasi.portal.data.model.UserExample;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import org.springframework.stereotype.Service;
import static org.springframework.util.Assert.*;

import com.nasi.portal.service.UserService;

/**
 * @author anliyong@baidu.com
 * 2015-7-17下午10:21:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getActiveUserByEmail(String email) {
        
        hasLength(email, "email不能为空");

        UserExample example=new UserExample();
        example.createCriteria().andActiveEqualTo(1).andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(example);
        
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getByPrimaryKey(Integer id) {
        notNull(id, "id不能为空");
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertOrUpdate(User user) {
        notNull(user, "user不能为空");
        
        if (user.getId() == null) {
            return userMapper.insertSelective(user);
        } else {
            return userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public User selectUserByProfessorName(Long professorId) {
        notNull(professorId, "id不能为空");
        UserExample example=new UserExample();
        example.createCriteria().andProfessorIdEqualTo(professorId);
        List<User> users = userMapper.selectByExample(example);
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public DataGridResult getUserListByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        UserExample example=new UserExample();
        example.createCriteria().andRoleIdEqualTo(2);
        example.setOrderByClause("create_time desc");
        List<User> users = userMapper.selectByExample(example);
        PageInfo<User> userPageInfo = new PageInfo<User>(users);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(users);
        dataGridResult.setTotal(userPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findUserListPageByNameEn(String nameEn, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        UserExample example=new UserExample();
        example.createCriteria().andNameEnEqualTo(nameEn).andRoleIdEqualTo(2);
        example.setOrderByClause("create_time desc");
        List<User> users = userMapper.selectByExample(example);
        PageInfo<User> userPageInfo = new PageInfo<User>(users);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(users);
        dataGridResult.setTotal(userPageInfo.getTotal());
        return dataGridResult;
    }

}
