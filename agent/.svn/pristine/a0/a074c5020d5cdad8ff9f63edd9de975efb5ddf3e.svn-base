  /*
   * 软件著作权：北京东方正通科技有限公司
   *
   * 系统名称：[系统中文名称]（[系统英文名称]）
   *
   * 文件名称：DateFormatUtils.java
   *
   * 工程名：  BJInnerOA
   *		 
   * 版本历史：Apr 21, 2008     版 
   * 
   */

/**
 * 
 * 作者：张万兵
 * Apr 21, 2008	
 */ 

package com.harmony.themis.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.harmony.themis.commons.Constants;


public class DateFormatUtils {
	
	/**
	 * 将日期转为为format格式的字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format){
		if(null == date)
			return "";
		if(null == format){
			format = Constants.DATETIME_FORMAT_NO_SECEND;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String result = dateFormat.format(date);
		if("00:00".equals(result)){
			return "";
		}
		return result;
	}
	
	/**
	 * 将给定的日期字符串转换为日期
	 * @param dateStr
	 * @param format
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date parse(String dateStr, String format) throws ParseException{
		if(StringUtils.isEmpty(dateStr))
			return new Date();
		if(null == format){
			format = Constants.DATE_FORMAT;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateStr);		
	}
	
	public static Date parse1(String dateStr, String format){
		if(StringUtils.isEmpty(dateStr))
			return null;
		if(null == format){
			format = Constants.DATE_FORMAT;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date d = null;
		try
		{
			d = dateFormat.parse(dateStr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return d;
	}
	
	public static Date strToDate(String s) {
		Date d = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(s);
		} catch (Exception e) {

		}
		
		return d;
	}

	public static Date strToDate2(String s) {
		Date d = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			d = sdf.parse(s);
		} catch (Exception e) {
		}
		
		return d;
	}
	public static Date strToDate3(String s) {
		Date d = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			d = sdf.parse(s);
		} catch (Exception e) {

		}
		
		return d;
	}
	
	public static Date strToDate4(String str)
	{
		Date d = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		try {
			d = sdf.parse(str);
		} catch (Exception e) {

		}
		
		return d;
	}
	public static String dateToStr(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	
	public static String dateToStr2(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	
	public static String dateToStr3(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	public static String dateToStr4(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	public static String dateToStr5(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	public static String dateToStr6(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	public static String dateToStr7(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	public static String dateToStr8(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
	public static String dateToStr9(Date date) {
		String s = "";
		if(date == null) {
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		try {
			s = sdf.format(date);
		}catch (Exception e) {

		}
		
		return s;
	}
}



