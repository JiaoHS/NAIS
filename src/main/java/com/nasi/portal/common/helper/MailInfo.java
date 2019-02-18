/**
 * @author: 安李勇
 * @email: anlystar@gmail.com
 */
package com.nasi.portal.common.helper;

import java.util.Properties;

/**
 * @author 安李勇
 * 
 */
public class MailInfo {

	// 发送邮件的服务器的IP和端口
	private String mailServerHost;
	private String mailServerPort = "25";
	// 邮件发送者的地址
	private String fromAddress;
	// 邮件接收者的地址,多个邮箱以分号隔开
	private String toAddress;
	// 抄送地址,多个邮箱以分号隔开
	private String ccAddress;
	// 暗送地址,多个邮箱以分号隔开
	private String bccAddress;
	// 登陆邮件发送服务器的用户名和密码
	private String userName;
	private String password;
	// 是否需要身份验证
	private boolean validate = true;
	// 邮件主题
	private String subject;
	// 邮件的文本内容
	private String content;
	// 邮件附件的文件名,多个以分号隔开
	private String attachFileNames;
	// 邮件内容编码
	private String encoding = "UTF-8";
	// 是否要求回执
	private boolean receipt;

	/**
	 * 获得邮件会话属性
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}

	public boolean isReceipt() {
		return receipt;
	}

	public void setReceipt(boolean receipt) {
		this.receipt = receipt;
	}

}
