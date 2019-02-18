/**
 * @author: 安李勇
 * @email: anlystar@gmail.com
 */
package com.nasi.portal.common.helper;

import java.security.MessageDigest;

/**
 * @author 安李勇
 * 
 */
public class EncryptHelper {

	public static String KEY_MD5 = "MD5";
	public static String KEY_SHA = "SHA";

	/**
	 * md5加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {
		if(data == null || data.length == 0){
			return null;
		}
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}

	/**
	 * md5加密
	 * 
	 * @param 源字符串
	 * @return 加密后的字符串
	 */
	public static String encryptMD5(String sourceString) {
		String resultString = null;
		if(sourceString == null || "".equals(resultString)) {
			return sourceString;
		}
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			// 进行加密
			byte[] b = md.digest(resultString.getBytes("UTF-8"));
			resultString = byte2hexString(b);
		} catch (Exception ex) {
		}
		return resultString;
	}

	/**
	 * SHA加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {
		if(data == null || data.length == 0){
			return null;
		}
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}
	
	public static String encryptSHA(String sourceString) {
		String resultString = null;
		if(sourceString == null || "".equals(resultString)) {
			return sourceString;
		}
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance(KEY_SHA);
			// 进行加密
			byte[] b = md.digest(resultString.getBytes("UTF-8"));
			resultString = byte2hexString(b);
		} catch (Exception ex) {
		}
		return resultString;
	}

	/**
	 * 方法说明:把字节数组转换成字符串.
	 * 
	 * @param bytes
	 * @return
	 */
	private static final String byte2hexString(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}

}
