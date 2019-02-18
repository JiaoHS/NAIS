package com.nasi.portal.web.controller.huanghe;

/**
 * @Author: River
 * @Date:Created in  21:10 2018/5/8
 * @Description: 返回符合easyui 下拉列表的格式的json
 */
public class ComboboxResult {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
