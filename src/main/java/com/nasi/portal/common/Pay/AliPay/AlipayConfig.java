package com.nasi.portal.common.Pay.AliPay;

public class AlipayConfig {

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2017110309710696";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQ3sIlx+YhNx5zel2r22F7keNFuHyG7PfQWFKH+Ngb293tGzKwVQ5HyVR7PS9feLQ97JcYbrkUBVq6IYZdqRXjH9beQWiRIrN7x/GCJPt/1Nros9WYXtUqF5A2iPK9E3EQ96vPO5LLVAXxqFTLqNtZVu0vp4U9od9yUHJ/ed/a5SRRNsgpGXe75KXPMePui1jhGW58dQ0Qnu94To5CbYiCIamZRLvXTHveocdyBuvsmJ9kP8mGBjBxSTGJF9q3ImpaP/ptZOh1oOT+ZZYZ/WBsInvAv7qc2+vSIOmcmvfv9dLKx1BtdHu0Z1QhvCSEaWGPqHU5rVtCNqaNSZ0zW5sjAgMBAAECggEBAMsosIzRB80s8Kh/0Ba19vabawVIsY8HdO8oyXXKHGHUlOLofoA26wH2GP8Z/zcMj7xfoIO6RrjrkFjU/P2i1lApivR5iH0K1KtESms9D4dCAX8wVES1kP81FieFQx2XiHVpgaq7FkhBPNrV0UyavGgEfgXJGnddOJrXFtdZMtyUGxBc1igDVsrLd+4bJyEv2sIpYfxiIzTO3X8ABvAt4DOs8LLodjrrF4dc3ZPs45rg8W/eRKSr9XxLuGGZvWrT+KzGY21Ht1iWQVJR8q/qF7NqjaVLiE+I5KMSAiqgwb6ZHFzol3fJU97FuWtKu86aRSQASESWNkxpeaVqaCKDomECgYEA/H6OxGVgtk3BTQfDTWf3Kr2luB5wc4HYcO8e2vYFcq/6VjMYt7V/N7ZFi8ias/IIyvJkqtc4TyWrkaT86ihoixyzom5SgXYSNRCO9GevlKcW9mbuHOHGkoFIZPP1Wq+UYwZ4jlf2pp9ypUiOKsdk7yWnTCiitApMNaTxrFxsS7ECgYEA08UlmdvywF6VQwOWW4VwN5eS+OrXstWrZ7anRN+odMj7Afilm6mKlz4teZjwbmusoJlTjbzQSf3TL/GXKZ1Vr9UhxjmSiMu0UUkhCkH2DlEbJZwojl2EjSBanp+p13Q3OXyJsgnbpcPSeEyH1EOBQdsDWyifJCt2jAtNdv+aDRMCgYAG1qqpORGwflSg8HfirdEs8Cv/25syFa82B9PvHECzhX6jPQkLWLgUWzRw/8Lo4sJINN5zHhchVaTa8fwDn4qNUf6vhItphDgkBcnJZtGDli7yB4GleJv3NdcvHMhlZ2H+eJtlR46fnqvtPBTVpcbfD0cDsgoOFEVSIqCFCY/JUQKBgFqOrqKZvLfoelma2hwu9qq/JXlOK4js+Aw0vlikb8vo+fWA14i2Om6shxO9g+skHkDa8DDnMgbCBSI2ZFbGUhMLyBKVIgVfXq933yocxNSgeERf/7PJZ9pVoIq+agmZR9hMWjGJJ6U+FO2ehGMPruFzf37m4w67i0kduDWP3deDAoGBAKTS5Q9N+6iyYCkdpfScug9XY2zOx3QoDmlWbGXcqn1kB1Qc+j/z3YFaHpBf5uEJj4H5NwEwbvcdL1S7NKQYHIGpzxLNWges7jt3qh/03Ipbdi4KEflSBhXvLySHRiiS0tO7GQ6yUweeRbqOYkDNJH+oEvXZdQYXL1jBfc9ikZiZ";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlK/ftZsAOjlSwzl0hOaHHpWFVTo7XYBK1QCNstoUggcX0VxGzrOvgRn9DeO6JHt6qygdrxCuoAbMO4h/6ABLLQ1+/dBihuxHqZe0mayc1vkA56NS2vT89XRtREPfIvcPONvmY2Y5oEkEbXD/Wuf35SV7vTq6xIKmlTVx9DdcFlFaYT0n8QNIwJ0q1HzgHlclxx64rsa6oMmmU0v3pgqWqBLCr5mDXk4wnhcdzHnfNFzY4fQR/X9TrPTeNjfR8WTYKrgDbISbihZi9SlrlBdI5DUJiGJCX7Q0FMNCWY0gHVWGJMAXqKKgvdSuWrDdwX/yH1YGaX6vz1fB+ggzbCAoPQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String notify_url = "http://43.241.231.184:8081/pay/aliPay/notify";//测试服务器地址
	public static String notify_url = "http://www.issneducation.com/pay/aliPay/notify";//上线服务器地址
//	public static String notify_url = "http://39.107.85.11:8080/pay/alipay/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://43.241.231.184:8081/pay/aliPay/return";
	public static String return_url = "http://www.issneducation.com/pay/aliPay/return";
//	public static String return_url = "http://39.107.85.11:8080";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl =  "https://openapi.alipay.com/gateway.do"; //"https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\project\\alipay-wrapper\\alipay.trade.page.pay-JAVA-UTF-8";
	
}

