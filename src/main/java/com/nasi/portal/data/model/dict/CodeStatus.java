package com.nasi.portal.data.model.dict;

public enum CodeStatus {
    
    INIT(1,"可用"),
    USING(2,"正在使用"),
    USED(3,"使用完毕");
    
    private int index;
    
    private String name;

    private CodeStatus(int index, String name) {
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
