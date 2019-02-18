package com.nasi.portal.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by yy on 2018-05-30.
 */
public class testReadAmount {
    public static void main(String args[]){
        ResourceBundle resource = ResourceBundle.getBundle("discountAmount");
        String key = resource.getString("discount_amount");
        System.out.println(key);


        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)+1);
        Date date=curr.getTime();
        System.out.println(date);
    }
}
