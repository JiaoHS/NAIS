/**
 * @author anliyong@baidu.com
 * 2015-6-23 上午10:43:41
 */
package com.nasi.portal.data.model.dict;

/**
 * @author anliyong@baidu.com
 * 2015-6-23上午10:43:41
 */
public interface BaseDict<T> {

    public int getIndex();
    
    public String getName();
    
    public T getByIndex(int index);
    
}
