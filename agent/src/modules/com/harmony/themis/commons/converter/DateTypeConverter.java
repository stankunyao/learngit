package com.harmony.themis.commons.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.harmony.themis.commons.Constants;


/**
 * 日期类型转换器
 * @author Administrator
 *
 */
public class DateTypeConverter extends StrutsTypeConverter {

	private static final Logger log = Logger.getLogger(DateTypeConverter.class);
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm";
	
	//暂时只考虑这几种日期格式
	public static final DateFormat[] ACCEPT_DATE_FORMATS = {
			new SimpleDateFormat(Constants.DATETIME_FORMAT),
			new SimpleDateFormat(Constants.DATETIME_FORMAT_SLASH),
			new SimpleDateFormat(Constants.DATETIME_FORMAT_NO_SECEND),
			new SimpleDateFormat(Constants.DATETIME_FORMAT_NO_SECEND_SLASH),
			new SimpleDateFormat(Constants.DATETIME_FORMAT_NO_SECEND_CHINESE),
			new SimpleDateFormat(Constants.DATE_FORMAT),
			new SimpleDateFormat(Constants.DATE_FORMAT_SLASH),
			new SimpleDateFormat(Constants.DATE_FORMAT_CHINESE)
			
//			new SimpleDateFormat("yyyy/MM/dd HH:mm"),
//			new SimpleDateFormat("yyyy-MM-dd"),
//			new SimpleDateFormat("yyyy年MM月dd日"),
//			new SimpleDateFormat("yyyy/MM/dd")
	};

	/**
	 * 
	 */
	public DateTypeConverter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map,
	 *      java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values[0] == null || values[0].trim().equals(""))
			return null;
		for (DateFormat format : ACCEPT_DATE_FORMATS) {
			try {
				return format.parse(values[0]);
			} catch (ParseException e) {
				continue;
			} catch (RuntimeException e) {
				continue;
			}
		}
		log.debug("can not format date string:" + values[0]);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map,
	 *      java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if (o instanceof Date) {
			SimpleDateFormat format = new SimpleDateFormat(
					DEFAULT_DATE_FORMAT);
			try {
				return format.format((Date) o);
			} catch (RuntimeException e) {
				return "";
			}
		}
		return "";
	}

}