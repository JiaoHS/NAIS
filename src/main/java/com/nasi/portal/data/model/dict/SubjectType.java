package com.nasi.portal.data.model.dict;

public enum SubjectType {
    
    CLASS(1,"课程"),
    OTHER(2,"杂费");
    
    private int index;
    
    private String name;

    private SubjectType(int index, String name) {
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
