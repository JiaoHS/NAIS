/**
 * @author: 安李勇
 * @email: anlystar@gmail.com
 */
package com.nasi.portal.common.helper;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author 安李勇
 *
 */
public class MailHelper {
	
	private static class SmtpAuthenticator extends Authenticator {
		private String username;
		private String password;

		public SmtpAuthenticator(String username, String password) {
			this.username = username;
			this.password = password;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

	public static boolean sendTextMail(MailInfo mailInfo) {
		Properties pro = mailInfo.getProperties();
		SmtpAuthenticator sa = null;
		if (mailInfo.isValidate()) { // 判断是否需要身份认证 如果需要身份认证，则创建一个密码验证器
			sa = new SmtpAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, sa);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			if(mailInfo.isReceipt()) {
				mailMessage.setHeader("Disposition-Notification-To", mailInfo.getFromAddress());
			}
			if (mailInfo.getToAddress() != null) {
				String[] toAddresses = mailInfo.getToAddress().split(";");
				for (String str : toAddresses) {
					if (str != null && !"".equals(str)) {
						Address to = new InternetAddress(str);
						// Message.RecipientType.TO属性表示接收者的类型为TO
						mailMessage.addRecipient(Message.RecipientType.TO, to);
					}
				}
			}
			// 创建邮件的抄送地址，并设置到邮件消息中
			if (mailInfo.getCcAddress() != null) {
				String[] ccAddresses = mailInfo.getCcAddress().split(";");
				for (String str : ccAddresses) {
					if (str != null && !"".equals(str)) {
						Address cc = new InternetAddress(str);
						mailMessage.addRecipient(Message.RecipientType.CC, cc);
					}
				}
			}
			// 创建邮件的接收者地址，并设置到邮件消息中
			if (mailInfo.getBccAddress() != null) {
				String[] bccAddresses = mailInfo.getBccAddress().split(";");
				for (String str : bccAddresses) {
					if (str != null && !"".equals(str)) {
						Address bcc = new InternetAddress(str);
						mailMessage.addRecipient(Message.RecipientType.BCC, bcc);
					}
				}
			}
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 * @param mailInfo 待发送的邮件信息
	 */
	public static boolean sendHtmlMail(MailInfo mailInfo) {
		Properties pro = mailInfo.getProperties();
		SmtpAuthenticator sa = null;
		if (mailInfo.isValidate()) { // 判断是否需要身份认证 如果需要身份认证，则创建一个密码验证器
			sa = new SmtpAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, sa);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			if (mailInfo.getToAddress() != null) {
				String[] toAddresses = mailInfo.getToAddress().split(";");
				for (String str : toAddresses) {
					if (str != null && !"".equals(str)) {
						Address to = new InternetAddress(str);
						// Message.RecipientType.TO属性表示接收者的类型为TO
						mailMessage.addRecipient(Message.RecipientType.TO, to);
					}
				}
			}
			// 创建邮件的抄送地址，并设置到邮件消息中
			if (mailInfo.getCcAddress() != null) {
				String[] ccAddresses = mailInfo.getCcAddress().split(";");
				for (String str : ccAddresses) {
					if (str != null && !"".equals(str)) {
						Address cc = new InternetAddress(str);
						mailMessage.addRecipient(Message.RecipientType.CC, cc);
					}
				}
			}
			// 创建邮件的接收者地址，并设置到邮件消息中
			if (mailInfo.getBccAddress() != null) {
				String[] bccAddresses = mailInfo.getBccAddress().split(";");
				for (String str : bccAddresses) {
					if (str != null && !"".equals(str)) {
						Address bcc = new InternetAddress(str);
						mailMessage.addRecipient(Message.RecipientType.BCC, bcc);
					}
				}
			}
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=" + mailInfo.getEncoding());
			mainPart.addBodyPart(html);
			if (mailInfo.getAttachFileNames() != null) {
				String[] attachFileNames = mailInfo.getAttachFileNames().split(";");
				for (String str : attachFileNames) {
					if(str != null && !"".equals(str)) {
						MimeBodyPart mbpFile = new MimeBodyPart();
						FileDataSource fds = new FileDataSource(str);
						mbpFile.setDataHandler(new DataHandler(fds));
						mbpFile.setFileName(fds.getName());
						mainPart.addBodyPart(mbpFile);
					}
				}
			}
			if(mailInfo.isReceipt()) {
				mailMessage.setHeader("Disposition-Notification-To", mailInfo.getFromAddress());
			}
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
