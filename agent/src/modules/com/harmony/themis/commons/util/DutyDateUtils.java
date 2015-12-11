/**
 * 
 */
package com.harmony.themis.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Wang Xiaoqing
 */
public class DutyDateUtils {
	public static final String[] weekDayNames = { "星期日", "星期一", "星期二", "星期三",
			"星期四", "星期五", "星期六" };

	private static final String[] monthNames = { "一月", "二月", "三月", "四月", "五月",
			"六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

	private static final long oneDay = 1000 * 60 * 60 * 24;

	/**
	 * 得到月份的列表
	 * 
	 * @param thisMonth
	 * @return List包含多个list，其中每个list：0是月份对应的数字，1是页面展示样式，2是月份中文名
	 */
	public static List getMonthList(String thisMonth) {
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 0; i < monthNames.length; i++) {
			List<String> temp = new ArrayList<String>();
			temp.add((i + 1) + "");// index
			if (((i + 1) + "").equals(thisMonth)) {
				temp.add("onTab");
			} else {
				temp.add("");
			}
			temp.add(monthNames[i]);
			result.add(temp);
		}
		return result;
	}

	/**
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfYearMonth(String year, String month) {
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.YEAR, Integer.valueOf(year).intValue());
		cale.set(Calendar.MONTH, Integer.valueOf(month).intValue() - 1);
		cale.set(Calendar.DATE, 1);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		return cale.getTime();
	}

	/**
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfYearMonth(String year, String month) {

		Date firstDay = getFirstDayOfYearMonth(year, month);

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(firstDay);
		int monthDayNum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.YEAR, Integer.valueOf(year).intValue());
		cale.set(Calendar.MONTH, Integer.valueOf(month).intValue() - 1);
		cale.set(Calendar.DATE, monthDayNum);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		return cale.getTime();

	}

	/**
	 * 得到2个日期之间的日期列表
	 * 
	 * @param start_date
	 * @param end_date
	 * @return
	 */
	public static List getBetweenDate(Date start_date, Date end_date) {
		List<List<String>> result = new ArrayList<List<String>>();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTimeInMillis(start_date.getTime());
		end.setTimeInMillis(end_date.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		//
		while (start.getTimeInMillis() <= end.getTimeInMillis()) {
			StringBuffer tempDate = new StringBuffer();
			tempDate.append(format.format(start.getTime()));
			String tempWeek = weekDayNames[start.get(Calendar.DAY_OF_WEEK) - 1];
			List<String> temp = new ArrayList<String>();
			temp.add(tempDate.toString());
			temp.add(tempWeek);
			result.add(temp);
			start.setTimeInMillis(start.getTimeInMillis() + oneDay);
		}
		return result;
	}

	/**
	 * 得到这个日期所在年、月的所有日期列表
	 * 
	 * @param date
	 *            格式为：yyyy-MM-dd
	 * @return
	 */
	public static List getThisYearMonthDateList(String date) {
		Date paramDate = formatStr2Date(date);
		String year = getYearFromDate(paramDate);
		String month = getMonthFromDate(paramDate);
		Date startDate = getFirstDayOfYearMonth(year, month);
		Date endDate = getLastDayOfYearMonth(year, month);
		return getBetweenDate(startDate, endDate);
	}

	/**
	 * @param str
	 * @return
	 */
	public static Date formatStr2Date(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date result = format.parse(str);
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	/**
	 * @param date
	 * @return
	 */
	public static String getYearFromDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static String getMonthFromDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("MM");
		return format.format(date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static String getYearMonthDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static String formatDate(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 返回八位字符格式日期如果对象d等于空则返回当前日期字符,小于10前补0
	 * 
	 * @param d
	 *            Date d
	 * @return yyyymmdd 例: 20031201
	 */
	public static String formatDate8(Date d) {
		return formatDate(d, "yyyyMMdd");
	}

	/**
	 * 取当前年度。
	 * 
	 * @return int
	 */
	public static int getCurrentYear() {
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis((new Date()).getTime());
		return today.get(Calendar.YEAR);
	}
}
