package com.nasi.portal.web.controller.caohao;

import java.util.List;

/**
 * created by xdCao on 2018/4/22
 */

public class DataGridResult {

    private long total;

    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
