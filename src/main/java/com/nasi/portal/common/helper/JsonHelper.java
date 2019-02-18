/**
 * 
 */
package com.nasi.portal.common.helper;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author anliyong
 *
 */
public class JsonHelper {

    public static String toJsonString(Object obj) {
        return JSONObject.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
    }
    
}
