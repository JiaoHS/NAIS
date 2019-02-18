/**
 * @author anliyong
 */
package com.nasi.portal.data.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * PO的基类
 *
 * @author anliyong
 */
public class BaseModel {

    protected Integer id; //自增id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (id == null) {
            return false;
        }
        if (!(other instanceof BaseModel)) {
            return false;
        }
        return this.id.equals(((BaseModel) other).getId());
    }

    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

    public String toJsonString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.DisableCircularReferenceDetect);
    }

}
