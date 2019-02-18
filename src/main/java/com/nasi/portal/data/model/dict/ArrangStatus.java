package com.nasi.portal.data.model.dict;

public enum ArrangStatus {
    
    ACTIVE(1,"激活"),
    DISABLE(2,"禁用");
    
    private int status;
    
    private String desc;
    
    private ArrangStatus(int status, String desc) {
        this.desc = desc;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
