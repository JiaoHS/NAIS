package com.nasi.portal.data.model.dict;

public enum CodeType {
    
    UNIQUE(1,"单次使用"),
    INFINITY(2,"无限次使用");
    
    private int index;
    
    private String name;

    private CodeType(int index, String name) {
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
