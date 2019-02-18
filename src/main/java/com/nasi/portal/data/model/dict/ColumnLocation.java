/**
 * @author anliyong@baidu.com
 * 2015-6-23 上午10:43:23
 */
package com.nasi.portal.data.model.dict;

/**
 * @author anliyong@baidu.com
 * 2015-6-23上午10:43:23
 */
public enum ColumnLocation implements BaseDict<ColumnLocation> {
    
    HEAD(1, "头部"), OTHER(2, "其他");

    private int index;
    
    private String name;
    
    private ColumnLocation(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ColumnLocation getByIndex(int index) {
       
        ColumnLocation[] locations = values();
        
        for (ColumnLocation columnLocation : locations) {
            if (columnLocation.getIndex() == index) {
                return columnLocation;
            }
        }
        
        return null;
    }

}
