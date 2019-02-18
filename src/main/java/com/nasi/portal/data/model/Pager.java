/**
 * 
 */
package com.nasi.portal.data.model;

import java.util.List;

/**
 * @author anly
 *
 */
public class Pager<T> {

	private int pageNo = 1;
	private int pageSize = 30;
	private int recordCount;
	private int pageCount;
	private List<T> data;
	private double time;

	public Pager() {
	}

	public Pager(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo > 0 ? pageNo : 1;
		this.pageSize = pageSize > 0 ? pageSize : 10;
	}

	public Pager(int pageNo, int pageSize, int recordCount) {
		super();
		this.pageNo = pageNo > 0 ? pageNo : 1;
        this.pageSize = pageSize > 0 ? pageSize : 10;
        this.recordCount = recordCount > 0 ? recordCount : 0;
        this.pageNo = this.pageNo > this.getPageCount() ? this.getPageCount() : this.pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		this.pageNo = this.pageNo > this.getPageCount() ? this.getPageCount() : this.pageNo;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getPageCount() {
		if (pageSize > 0) {
			this.pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getStart() {
		return (pageNo - 1) * pageSize;
	}
	
}
