/**
 * @author: 安李勇
 * @email: anlystar@gmail.com
 */
package com.nasi.portal.common.helper;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author 安李勇
 *
 */
public class DateHelper {
	
	public static DateHelper instance = null;
	
	private DateHelper() {}
	
	private static class SingletonHolder {     
	    private static DateHelper instance = new DateHelper();     
    }    
	
	public static DateHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * 根据日期获取年
	 * @param date
	 * @return
	 */
	public static String getYearByDate(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("yyyy").format(date);
	}

	/**
	 * 根据日期获取月份
	 * @param date
	 * @return
	 */
	public static String getMonthByDate(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("MM").format(date);
	}

	/**
	 * 根据日期获取天
	 * @param date
	 * @return
	 */
	public static String getDayByDate(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("dd").format(date);
	}

	/**
	 * 根据时间和日期格式转换日期输出
	 * @param date 时间
	 * @param str 日期格式 例如"yyyy-MM-dd HH:mm:ss.S";
	 * @return
	 */
	public static String toDateTimeStr(Date date, String str) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(str).format(date);
	}
	
	/**
	 * 根据时间和日期格式转换日期输出
	 * @param time 时间
	 * @param str 日期格式 例如"yyyy-MM-dd HH:mm:ss.S";
	 * @return
	 */
	public static String toDateTimeStr(long time, String str) {
		return new SimpleDateFormat(str).format(new Date(time));
	}

	/**
	 * 把时间转换成形如"yyyy-MM-dd HH:mm:ss"格式输出
	 * @param date
	 * @return
	 */
	public static String toFullDateTimeStr(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 把日期转换成形如"yyyy-MM-dd"格式输出
	 * @param date
	 * @return
	 */
	public static String toDateStr(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * toDateStartToEndStr 开始时间，结束时间段表示 2006-09-09 12:00-12:00
	 * 
	 */
	public static String toDateStartToEndStr(Date start, Date end) {
		if (start == null || end == null) {
			return null;
		}
		String str1 = toDateTimeStr(start, "yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String str2 = sdf.format(end);
		return str1 + "-" + str2;
	}

	public static int DateDiff(String sdate1, String sdate2, String fmt, TimeZone tz) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (fmt != null) {
			df = new SimpleDateFormat(fmt);
		}
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = df.parse(sdate1);
			date2 = df.parse(sdate2);
		} catch (ParseException pe) {
			pe.printStackTrace();
			return 0;
		}

		Calendar cal1 = null;
		Calendar cal2 = null;

		if (tz == null) {
			cal1 = Calendar.getInstance();
			cal2 = Calendar.getInstance();
		} else {
			cal1 = Calendar.getInstance(tz);
			cal2 = Calendar.getInstance(tz);
		}

		cal1.setTime(date1);
		long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET);
		cal2.setTime(date2);
		long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET);
		int hr1 = (int) (ldate1 / 3600000); // 60*60*1000
		int hr2 = (int) (ldate2 / 3600000);
		int days1 = (int) hr1 / 24;
		int days2 = (int) hr2 / 24;
		int dateDiff = days2 - days1;
		return dateDiff;
	}

	public static int MonthDiff(String sdate1, String sdate2, String fmt, TimeZone tz) {
		Calendar cal1 = null;
		Calendar cal2 = null;
		if (tz == null) {
			cal1 = Calendar.getInstance();
			cal2 = Calendar.getInstance();
		} else {
			cal1 = Calendar.getInstance(tz);
			cal2 = Calendar.getInstance(tz);
		}
		int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
		int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
		return monthDiff;
	}

	public static int YearDiff(String sdate1, String sdate2, String fmt, TimeZone tz) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (fmt != null) {
			df = new SimpleDateFormat(fmt);
		}
		Date date1 = null;
		Date date2 = null;

		try {
			date1 = df.parse(sdate1);
			date2 = df.parse(sdate2);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		Calendar cal1 = null;
		Calendar cal2 = null;

		if (tz == null) {
			cal1 = Calendar.getInstance();
			cal2 = Calendar.getInstance();
		} else {
			cal1 = Calendar.getInstance(tz);
			cal2 = Calendar.getInstance(tz);
		}

		cal1.setTime(date1);
		cal2.setTime(date2);
		int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
		return yearDiff;
	}

	/**
	 * 字符串转换成时间格式
	 * @param date
	 * @param str 例如"yyyy-MM-dd HH:mm:ss.S"
	 * @return
	 */
	public static Date strToDate(String date, String str) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		Date result = sdf.parse(date, new ParsePosition(0));
		return result;
	}

	public static Date getYesterdayDate(Date date) {
		if (date == null) {
			return null;
		}
		long milliSeconds = date.getTime();
		milliSeconds -= 24 * 60 * 60 * 1000;
		Date tomorrow = new Date(milliSeconds);
		String tomorrowString = toDateStr(tomorrow);
		tomorrowString += " 23:59:59";
		return strToDate(tomorrowString, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date getTomorrowDate(Date date) {
		if (date == null) {
			return null;
		}
		long milliSeconds = date.getTime();
		milliSeconds += 24 * 60 * 60 * 1000;
		Date tomorrow = new Date(milliSeconds);
		String tomorrowString = toDateStr(tomorrow);
		tomorrowString += " 00:00:00";
		return strToDate(tomorrowString, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date getTodayBeginDate(Date date) {
		if (date == null) {
			return null;
		}
		long milliSeconds = date.getTime();
		Date tomorrow = new Date(milliSeconds);
		String tomorrowString = toDateStr(tomorrow);
		tomorrowString += " 00:00:00";
		return strToDate(tomorrowString, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date getTodayEndDate(Date date) {
		if (date == null) {
			return null;
		}
		long milliSeconds = date.getTime();
		Date tomorrow = new Date(milliSeconds);
		String tomorrowString = toDateStr(tomorrow);
		tomorrowString += " 23:59:59";
		return strToDate(tomorrowString, "yyyy-MM-dd HH:mm:ss");
	}

	public static int dayOfWeek(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int week = aCalendar.get(Calendar.DAY_OF_WEEK);
		return week;
	}

	public static int dayOfDate(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int week = aCalendar.get(Calendar.DAY_OF_MONTH);
		return week;
	}

	public static String TimetoLong(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		return sdf.format(date);
	}

	public static String getNowOfLastYear() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
		// Format the date to get year and month
		String currentYearAndMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		return currentYearAndMonth;
	}

	public static Date getYestodayOfLastMonth() {
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
		aGregorianCalendar.set(Calendar.DAY_OF_MONTH, aGregorianCalendar.get(Calendar.DAY_OF_MONTH) - 1);
		// Format the date to get year and month
		String nowOfLastMonthStr = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowOfLastMonth = new Date();
		try {
			nowOfLastMonth = sdf.parse(nowOfLastMonthStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return nowOfLastMonth;
	}

	public static Date getYestodayOfLastYear() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
		aGregorianCalendar.set(Calendar.DAY_OF_MONTH, aGregorianCalendar.get(Calendar.DAY_OF_MONTH) - 1);
		// Format the date to get year and month
		String yestodayOfLastYearStr = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date yestodayOfLastYear = new Date();
		try {
			yestodayOfLastYear = sdf.parse(yestodayOfLastYearStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return yestodayOfLastYear;

	}

	public static Date getDateAddXYear(Date date, int year) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		gCalendar.add(Calendar.YEAR, year);
		return gCalendar.getTime();
	}
	
	public static Date getDateAddXMonth(Date date, int month) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		gCalendar.add(Calendar.MONTH, month);
		return gCalendar.getTime();
	}
	
	public static Date getDateAddXDay(Date date, int day) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		gCalendar.add(Calendar.DATE, day);
		return gCalendar.getTime();
	}
	
	public static Date getDateAddXHour(Date date, int hour) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		gCalendar.add(Calendar.HOUR, hour);
		return gCalendar.getTime();
	}

	public static String getMonthEn(Date date, boolean simple) {
		String result = "";
		Locale locale = Locale.ENGLISH;
		if (simple) {
			result = String.format(locale, "%tb", date);
		} else {
			result = String.format(locale, "%tB", date);
		}
		return result;
	}

	public static Date getFirstDayOfMonth(Date date) {
		String str = toDateStr(date);
		str = str.substring(0, 8) + "01";
		Date dt = strToDate(str, "yyyy-MM-dd");
		return getTodayBeginDate(dt);
	}

	/**
	 * 返回昨天
	 * @param today
	 * @return
	 */
	public static Date yesterday(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
		return calendar.getTime();
	}

	/**
	 * 返回明天
	 * @param today
	 * @return
	 */
	public static Date tomorrow(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
		return calendar.getTime();
	}
	
}
