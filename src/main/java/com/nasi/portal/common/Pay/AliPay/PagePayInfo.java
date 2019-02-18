package com.nasi.portal.common.Pay.AliPay;

public class PagePayInfo {
	/**
	 * 商户订单号，64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复，eg:20150320010101001
	 */
	private String outTradeNo;
	
	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 */
	private String totalAmount;
	
	/**
	 * 订单标题
	 */
	private String subject;
	
	/**
	 * 订单描述
	 */
	private String body;
	
	/**
	 * 销售产品码，与支付宝签约的产品码名称。 注：目前仅支持FAST_INSTANT_TRADE_PAY
	 */
	private String product_code = "FAST_INSTANT_TRADE_PAY";

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getProduct_code() {
		return product_code;
	}
}
