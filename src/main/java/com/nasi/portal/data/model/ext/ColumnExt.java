package com.nasi.portal.data.model.ext;

import java.util.List;

import com.nasi.portal.data.model.Column;

public class ColumnExt extends Column {

    private static final long serialVersionUID = -104855945942741822L;

    public List<Column> subColumns;

    public List<Column> getSubColumns() {
        return subColumns;
    }

    public void setSubColumns(List<Column> subColumns) {
        this.subColumns = subColumns;
    }
    
}
