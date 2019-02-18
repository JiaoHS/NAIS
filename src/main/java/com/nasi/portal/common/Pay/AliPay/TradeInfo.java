package com.nasi.portal.common.Pay.AliPay;

public class TradeInfo {

	/** 
	 * 买家支付宝账号
	 */
	private String buyerLogonId;

	/** 
	 * 买家实付金额，单位为元，两位小数。该金额代表该笔交易买家实际支付的金额，不包含商户折扣等金额
	 */
	private String buyerPayAmount;

	/** 
	 * 买家在支付宝的用户id
	 */
	private String buyerUserId;

	/** 
	 * 交易中用户支付的可开具发票的金额，单位为元，两位小数。该金额代表该笔交易中可以给用户开具发票的金额
	 */
	private String invoiceAmount;

	/** 
	 * 商家订单号
	 */
	private String outTradeNo;

	/** 
	 * 支付宝交易号
	 */
	private String tradeNo;

	/** 
	 * 交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）
	 */
	private String tradeStatus;

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getBuyerPayAmount() {
		return buyerPayAmount;
	}

	public void setBuyerPayAmount(String buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public String getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
}
