package com.nasi.portal.common.Pay.AliPay;

public enum PaymentChannel {
	
	ALI_PAY(1, "支付宝");
	
	private int index;
	
	private String name;

	public static final PaymentChannel getByIndex(int index){
		
		for (PaymentChannel channel : PaymentChannel.values()) {
			if (index == channel.getIndex()) {
				return channel;
			}
		}
		
		return null;
		
	}
	
	
	private PaymentChannel(int index, String name) {
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
