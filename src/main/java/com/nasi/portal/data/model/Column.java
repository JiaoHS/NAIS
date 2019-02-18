package com.nasi.portal.data.model;

import java.io.Serializable;

public class Column extends BaseModel implements Serializable {
    private Integer id;

    private String title;

    private String etitle;

    private Integer parentId;

    private Integer location;

    private Integer showOrder;

    private Integer level;

    private Integer columnType;

    private String content;

    private String econtent;

    private String url;

    private String eurl;

    private Integer columnStatus;

    private String banner;

    private String ebanner;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle == null ? null : etitle.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getColumnType() {
        return columnType;
    }

    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent == null ? null : econtent.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getEurl() {
        return eurl;
    }

    public void setEurl(String eurl) {
        this.eurl = eurl == null ? null : eurl.trim();
    }

    public Integer getColumnStatus() {
        return columnStatus;
    }

    public void setColumnStatus(Integer columnStatus) {
        this.columnStatus = columnStatus;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public String getEbanner() {
        return ebanner;
    }

    public void setEbanner(String ebanner) {
        this.ebanner = ebanner == null ? null : ebanner.trim();
    }
}