package com.nasi.portal.data.model.dict;

public enum IsPaid {
    
    NOT(0,"未付款"),
    YES(1,"已付款");
    
    private int index;
    
    private String name;

    private IsPaid(int index, String name) {
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
