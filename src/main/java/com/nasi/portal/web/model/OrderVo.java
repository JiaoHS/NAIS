package com.nasi.portal.web.model;

import com.nasi.portal.data.model.PaidOrder;

public class OrderVo extends PaidOrder{
    
    private static final long serialVersionUID = -1265717730787839135L;
    
    private String email;
    
    private String userName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
