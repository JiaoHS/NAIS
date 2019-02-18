package com.nasi.portal.common.Pay.AliPay;

public enum OrderStatus {
	
	CREATE(1, "订单创建"),
	PAYING(2, "发起支付"),
	PAYSUCESS(3, "支付成功"),
	CANCLE(-1,"取消订单")	,
	EXAMINE(4,"审核中");
	private int index;
	
	private String name;

	
	private OrderStatus(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
