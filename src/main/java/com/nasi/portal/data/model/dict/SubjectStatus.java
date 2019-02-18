package com.nasi.portal.data.model.dict;

public enum SubjectStatus {
    
    USEFUL(1,"有效"),
    UNUSEFUL(2,"作废");
    
    private int index;
    
    private String name;

    private SubjectStatus(int index, String name) {
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
