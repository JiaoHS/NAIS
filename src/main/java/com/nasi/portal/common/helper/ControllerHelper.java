/**
 * 
 */
package com.nasi.portal.common.helper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/**
 * @author anly
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ControllerHelper {

	static {
		
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				if (value instanceof Date) {
                    return new DateConverter();
                }
				
				if (!(value instanceof String)) {
					throw new ConversionException("只支持String类型的转换");
				}
				String str = (String) value;
				if ("".equals(str.trim())) {
					return null;
				}

				SimpleDateFormat sf = null;
				//避免最常见的日期类型判断多次
				if(str.trim().matches("[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}")) {
					sf = new SimpleDateFormat("yyyy-MM-dd");
				} else if(str.trim().matches("[\\d]{4}-[\\d]{1,2}-[\\d]{1,2} [\\d]{1,2}:[\\d]{1,2}:[\\d]{1,2}")) {
					sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				} else if(str.trim().matches("[\\d]{4}/[\\d]{1,2}/[\\d]{1,2}")) {
					sf = new SimpleDateFormat("yyyy/MM/dd");
				} else if(str.trim().matches("[\\d]{4}/[\\d]{1,2}/[\\d]{1,2} [\\d]{1,2}:[\\d]{1,2}:[\\d]{1,2}")) {
					sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				} else {
					sf = new SimpleDateFormat("yyyy-MM-dd");
				}
				
				try {
					return sf.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
				
			}
		}, Date.class);
		
	}
	
	/**
	 * 从map中提取带前缀prefix的参数和值封装到对象类型为clz的对象中并返回
	 * @param map 
	 * @param prefix 参数前缀
	 * @param clz 对象类型
	 * @return
	 */
	public static <T> T getBean(Map<String, String> map, String prefix, Class<T> clz) {
		return toBean(map, prefix, clz, null);
	}
	
	/**
	 * 从map中提取带前缀prefix的参数和值封装到对象bean中并返回
	 * @param map
	 * @param prefix 参数前缀
	 * @param bean 带初始值对象
	 * @return
	 */
	public static <T> T getBean(Map<String, String> map, String prefix, T bean) {
		return toBean(map, prefix, null, bean);
	}
	
	/**
	 * 从map中提取带前缀prefix的参数和值copy到另外一个map中
	 * @param map 
	 * @param prefix 参数前缀
	 * @param desc
	 * @return
	 */
	public static Map<String, Object> copyParams(Map<String, String> map, String prefix, Map<String, Object> desc) {
		
		if(desc == null) {
			desc = new HashMap<String, Object>();
		}
		
		if(map == null) {
			return desc;
		}
		
		Set keys = map.keySet();
		
		if(keys == null || keys.size() == 0) {
			return desc;
		}
		
		Iterator<String> ite = keys.iterator();
		
		while (ite.hasNext()) {
			
			String key = ite.next();
			
			if(!key.startsWith(prefix + ".")) {
				continue;
			}
			
			String value = map.get(key);
			
			desc.put(key, value);
				
		}
		
		desc.put("pageNo", map.get("pageNo"));
		
		return desc;
	}
	
	
	/**
	 * 从map中提取带前缀prefix的参数和值封装到对象类型为clz的对象或者对象bean中并返回
	 * @param map
	 * @param prefix 参数前缀
	 * @param clz 对象类型
	 * @param bean 带初始值对象
	 * @return
	 */
	private static <T> T toBean(Map<String, String> map, String prefix, Class<?> clz, T bean) {
		
		if(map == null) {
			return bean;
		}
		
		Set keys = map.keySet();
		
		if(keys == null || keys.size() == 0) {
			return bean;
		}
		
		if(bean == null && clz == null) {
			throw new RuntimeException("the bean or clz is required");
		}
		
		if(bean == null) {
			bean = getInstance(clz);
		}
		
		boolean has = false;
		
		if(clz == null) {
			has = true;
			clz = bean.getClass();
		}
		
		Iterator<String> ite = keys.iterator();
		
		while (ite.hasNext()) {
			
			String key = ite.next();
			
//			if(!key.matches(prefix + "(\\[[\\d]*\\])?\\..*")) {
//				continue;
//			}
			
			if(!key.startsWith(prefix + ".")) {
				continue;
			}
			
			has = true;
			
			String fieldName = key.substring(key.indexOf(".") + 1);
			
			String value = map.get(key);
			
			try {
				
				setProperty(bean, fieldName, value);
				
			} catch (Exception e) {
				throw new RuntimeException("Property '" + fieldName + "' is not exists.");
			}
				
		}
		
		if(!has) {
			return null;
		} else {
			return bean;
		}
	}
	
	private static <T> T toBean(HttpServletRequest request, String prefix, Class<?> clz, T bean) {
		
		Map params = request.getParameterMap();
		
		Iterator<String> ite = params.keySet().iterator();
		
		Map<String, String> map = new HashMap<String, String>();
		
		while (ite.hasNext()) {
			String key = ite.next();
			map.put(key, request.getParameter(key));
		}
		
		return (T) toBean(map, prefix, clz, bean);
	}
	
	/**
	 * 从request中提取带前缀prefix的参数和值封装到对象类型为clz的对象中并返回
	 * @param request
	 * @param prefix 参数前缀
	 * @param clz 对象类型
	 * @return
	 */
	public static <T> T getBean(HttpServletRequest request, String prefix, Class<T> clz) {
		return toBean(request, prefix, clz, null);
	}
	
	/**
	 * 从request中提取带前缀prefix的参数和值封装到对象bean中并返回
	 * @param request
	 * @param prefix 参数前缀
	 * @param bean 带初始值对象
	 * @return
	 */
	public static <T> T getBean(HttpServletRequest request, String prefix, T bean) {
		return toBean(request, prefix, null, bean);
	}
	
	/**
	 * 在request中提取前缀为prefix的参数值封装到对象类型为clz的实例中, 并以List的形式返回
	 * @param request
	 * @param prefix
	 * @param clz
	 * @return
	 */
	public static <T> List<T> getList(HttpServletRequest request, String prefix, Class<T> clz) {
		return generateList(request, prefix, clz, getInstance(clz));
	}
	
	/**
	 * 
	 * 在request中提取前缀为prefix的参数值封装到对象bean中, 并以List的形式返回
	 * @param request
	 * @param prefix
	 * @param bean
	 * @return
	 */
	public static <T> List<T> getList(HttpServletRequest request, String prefix, T bean) {
		return generateList(request, prefix, null, bean);
	}
	
	/**
	 * 在request中提取前缀为prefix的参数值封装到对象类型为clz的实例中, 并以数组的形式返回
	 * @param request
	 * @param prefix
	 * @param clz
	 * @return
	 */
	public static <T> T[] getArray(HttpServletRequest request, String prefix, Class<T> clz) {
		
		List list = generateList(request, prefix, clz, getInstance(clz));
		
		Object[] arr = (Object[])Array.newInstance(clz, list.size());
		
		return (T[]) list.toArray(arr);
		
	}
	
	/**
	 * 在request中提取前缀为prefix的参数值封装到对象bean中, 并以数组的形式返回
	 * @param request
	 * @param prefix
	 * @param bean
	 * @return
	 */
	public static <T> T[] getArray(HttpServletRequest request, String prefix, T bean) {
		
		List list = generateList(request, prefix, null, bean);
		
		Object[] arr = (Object[])Array.newInstance(bean.getClass(), list.size());
		
		return (T[]) list.toArray(arr);
		
	}
	
	/**
	 * 在request中提取前缀为prefix的参数值封装到对象类型为clz的实例中, 并以Set的形式返回
	 * @param request
	 * @param prefix
	 * @param clz
	 * @return
	 */
	public static <T> Set<T> getSet(HttpServletRequest request, String prefix, Class<T> clz) {
		return new HashSet(generateList(request, prefix, clz, getInstance(clz)));
	}
	
	/**
	 * 
	 * 在request中提取前缀为prefix的参数值封装到对象bean中, 并以Set的形式返回
	 * @param request
	 * @param prefix
	 * @param bean
	 * @return
	 */
	public static <T> Set<T> getSet(HttpServletRequest request, String prefix, T bean) {
		return new HashSet(generateList(request, prefix, null, bean));
	}
	
	/**
	 * 从request中提取参数前缀为prefix的值封装到对象中, 并以集合形式返回
	 * @param request
	 * @param prefix 参数前缀
	 * @param clz
	 * @param bean
	 * @return
	 */
	private static <T> List<T> generateList(HttpServletRequest request, String prefix, Class<T> clz, Object bean) {
		
		List<T> result = new ArrayList<T>();
		
		Map map = request.getParameterMap();
		
		Iterator<String> ite = map.keySet().iterator();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		while (ite.hasNext()) {
			String key = ite.next();
			
			if(!key.matches(prefix + "(\\[[\\d]*\\])?\\..*")) {
				continue;
			}
			
			if(!key.startsWith(prefix + ".")) {
				
				String number = key.substring(key.indexOf("[") + 1, key.indexOf("]."));
				
				Integer num = Integer.valueOf(number);
				
				while(list.size() < num + 1) {
					list.add(null);
				}
				
				Map<String, String> temp = list.get(num);
				
				if(temp == null) {
					temp = new HashMap<String, String>();
				}
				
				String value = request.getParameter(key);
				
				key = key.substring(0, key.indexOf("[")) + key.substring(0, key.indexOf(".") + 1);
				
				temp.put(key, value);
				list.set(num, temp);
				
			} else {
				String[] values = request.getParameterValues(key);
				for (int i = 0, len = values.length; i < len; i++) {
					
					Map<String, String> temp = null;
					
					if(list.size() > i) {
						temp = list.get(i);
					} else {
						temp = new HashMap<String, String>();
						list.add(temp);
					}
					
					temp.put(key, values[i]);
					list.set(i, temp);
				}
			}
			
		}
		
		for (Map<String, String> t : list) {
			
			if(t == null) {
				continue;
			}
			
			try {
				result.add((T)toBean(t, prefix, clz, BeanUtils.cloneBean(bean)));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 给对象的属性赋值
	 * @param bean
	 * @param fieldName
	 * @param value
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private static <T> void setProperty(Object bean, String fieldName, Object value) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		if(fieldName.contains(".")) {
			
			String realFieldName = fieldName.substring(0, fieldName.indexOf("."));
			String simpleFieldName = fieldName.substring(fieldName.indexOf(".") + 1);
			
			/**
			 * 当参数出现类似news.column.id的情况时, 若值为空, 且原对象为空时, 则不再进行赋值
			 */
			if("".equals(value) && BeanUtils.getProperty(bean, realFieldName) == null) {
				return;
			}
				
			PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(bean, realFieldName);
			
			Class<T> clz = (Class<T>) propertyDescriptor.getPropertyType();
			
			Object obj = getInstance(clz);
			
			setProperty(obj, simpleFieldName, value);
			
			setProperty(bean, realFieldName, obj);
			
		} else {
			
			PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(bean, fieldName);
			
			Class<T> type = (Class<T>) propertyDescriptor.getPropertyType();
			
			if("".equals(value) && (Integer.class.equals(type) || Long.class.equals(type) || Float.class.equals(type) || Double.class.equals(type))) {
				PropertyUtils.setProperty(bean, fieldName, null);
			} else if ("".equals(value) && String.class.equals(type)) {
				PropertyUtils.setProperty(bean, fieldName, null);
			} else {
				BeanUtils.setProperty(bean, fieldName, value);
			}
			
		}
		
	}
	
	/**
	 * 根据反射创建一个对象实例，该对象必须有一个无参构造函数
	 * @param clz 对象类型
	 * @return
	 */
	private static <T> T getInstance(Class<?> clz) {
		try {
			Constructor constructor = clz.getConstructor();
			return (T) constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * 获取重定向的RedirectView，并添加参数
	 * @param url
	 * @param map
	 * @return
	 */
	public static ModelAndView getRedirectView(String url, Map<String, Object> map) {
		RedirectView rv = new RedirectView(url);
		rv.setAttributesMap(map);
		return new ModelAndView(rv);
	}
	
	/**
	 * 获取重定向的RedirectView，并添加参数
	 * @param url
	 * @param map
	 * @return
	 */
	public static ModelAndView getRedirectView(String url, String...args) {
		RedirectView rv = new RedirectView(url);
		
		if(args != null && args.length % 2 == 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i = 0, len = args.length; i < len - 1; i +=2) {
				map.put(args[i], args[i + 1]);
			}
			rv.setAttributesMap(map);
		}
		
		return new ModelAndView(rv);
	}
	
}