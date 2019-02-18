/**
 * @author anliyong@baidu.com
 * 2015-7-17 下午10:21:36
 */
package com.nasi.portal.service;

import com.nasi.portal.data.model.User;
import com.nasi.portal.web.controller.caohao.DataGridResult;

/**
 * @author anliyong@baidu.com
 * 2015-7-17下午10:21:36
 */
public interface UserService {

    public User getActiveUserByEmail(String email);
    
    public User getByPrimaryKey(Integer id);
    
    public int insertOrUpdate(User user);

    User selectUserByProfessorName(Long professorId);

    DataGridResult getUserListByPage(Integer page, Integer rows);

    DataGridResult findUserListPageByNameEn(String nameEn, Integer page, Integer rows);
}
