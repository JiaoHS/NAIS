package com.nasi.portal.data.model;

public class WebConfig {
    private Integer id;

    private String k;

    private String v;

    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k == null ? null : k.trim();
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v == null ? null : v.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}