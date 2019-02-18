package com.nasi.portal.data.model.dict;

public enum OrderStatus {
    
    INIT(1,"等待审核"),
    PASS(2,"审核通过"),
    DEL(3,"订单作废");
    
    private int index;
    
    private String name;

    private OrderStatus(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
