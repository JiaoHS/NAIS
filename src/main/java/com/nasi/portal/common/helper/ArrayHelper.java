/**
 * @author: 安李勇
 * @email: anlystar@gmail.com
 */
package com.nasi.portal.common.helper;

import java.lang.reflect.Array;

/**
 * @author 安李勇
 *
 */
public class ArrayHelper {
	
	/**
	 * 增加长度
	 * @param oldArray
	 * @param addLength
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object arrayAddLength(Object oldArray, int addLength) {
		Class c = oldArray.getClass();
		if (!c.isArray()) {
			return null;
		}
		Class componentType = c.getComponentType();
		int length = Array.getLength(oldArray);
		int newLength = length + addLength;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(oldArray, 0, newArray, 0, length);
		return newArray;
	}

	/**
	 * 减少长度
	 * @param oldArray
	 * @param reduceLength
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object arrayReduceLength(Object oldArray, int reduceLength) {
		Class c = oldArray.getClass();
		if (!c.isArray()) {
			return null;
		}
		Class componentType = c.getComponentType();
		int length = Array.getLength(oldArray);
		int newLength = length - reduceLength;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(oldArray, 0, newArray, 0, newLength);
		return newArray;
	}
	
}
