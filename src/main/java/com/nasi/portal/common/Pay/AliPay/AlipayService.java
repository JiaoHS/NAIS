package com.nasi.portal.common.Pay.AliPay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;

public class AlipayService {

	private AlipayClient alipayClient;

	private static volatile AlipayService INSTANCE;

	private AlipayService() {
		alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);


	}

	public static AlipayService getInstance() {
		if (INSTANCE == null) {
			synchronized (AlipayService.class) {
				if (INSTANCE == null) {
					INSTANCE = new AlipayService();
				}
			}
		}
		return INSTANCE;
	}

	public String pagePay(PagePayInfo pagePayInfo) {		
		AlipayTradePagePayModel bizModel = new AlipayTradePagePayModel();
		bizModel.setOutTradeNo(pagePayInfo.getOutTradeNo());
		bizModel.setTotalAmount(pagePayInfo.getTotalAmount());
		bizModel.setSubject(pagePayInfo.getSubject());
		bizModel.setBody(pagePayInfo.getBody());
		bizModel.setProductCode("FAST_INSTANT_TRADE_PAY");

		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		alipayRequest.setBizModel(bizModel);
		String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public TradeInfo query(String out_trade_no)
	{
		//设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		//请二选一设置
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"}");
		
		AlipayTradeQueryResponse result = null;
		//请求
		try {
			result = alipayClient.execute(alipayRequest);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(result != null)
		{
			TradeInfo tradeInfo = new TradeInfo();
			tradeInfo.setBuyerLogonId(result.getBuyerLogonId());
			tradeInfo.setBuyerPayAmount(result.getBuyerPayAmount());
			tradeInfo.setBuyerUserId(result.getBuyerUserId());
			tradeInfo.setInvoiceAmount(result.getInvoiceAmount());
			tradeInfo.setOutTradeNo(result.getOutTradeNo());
			tradeInfo.setTradeNo(result.getTradeNo());
			tradeInfo.setTradeStatus(result.getTradeStatus());
			
			return tradeInfo;
		}
		
		return null;
	}
}
