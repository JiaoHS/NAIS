/**
 * @author anliyong@baidu.com
 * 2015-7-18 上午9:58:45
 */
package com.nasi.portal.data.model.dict;

/**
 * @author anliyong@baidu.com
 * 2015-7-18上午9:58:45
 */
public enum Role {
    
    ADMIN(0, "管理员", "/system/home"),
    PROFESSOR(1, "教授", "/professor/home.do"),
//    STUDENT(2, "学生", "/student/home.do");
    STUDENT(2, "学生", "/personalInfoSet.html");


    private Integer roleId;
    
    private String roleName;
    
    private String homeUrl;
    
    private String right;
    
    private Role(Integer roleId, String roleName, String homeUrl) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.homeUrl = homeUrl;
    }
 
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public static Role getByRoleId(int roleId) {
        
        Role[] roles = values();
        
        for (Role role : roles) {
            if (role.getRoleId() == roleId) {
                return role;
            }
        }
        
        return null;
    }

}
