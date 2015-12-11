/**
 * 软件著作权：北京东方正通科技有限公司
 *
 * 系统名称：值守应急系统（themis）
 *
 * 文件名称：BaseDaoException.java
 *
 * 工程名：  themis
 *		 
 * 版本历史：2008-08-14 
 * 
 * 
 */
package com.harmony.themis.commons.exception;

/**
 * DAO访问异常基类
 * @author 李来普
 *
 */
public class BaseDaoException extends BaseException{
	/**
	 * 构造一个DAO数据访问层异常对象.
	 * @param message 信息描述
	 */
	public BaseDaoException(String message) {
		super(message);
	}

	/**
	 * 构造一个DAO数据访问层异常对象.
	 * @param errorCode 错误编码
	 * @param message 信息描述
	 */
	public BaseDaoException(String errorCode,String message) {
		super(errorCode,message,true);
	}
	
	/**
	 * 构造一个DAO数据访问层异常对象.
	 * @param errorCode 错误编码
	 * @param message 信息描述
	 * @param messageKey 消息是否为属性文件中的Key
	 */
	public BaseDaoException(String errorCode,String message,boolean propertiesKey) {
		super(errorCode,message,propertiesKey);
	}
	/**
	 * 构造一个DAO数据访问层异常对象.
	 * @param message 信息描述
	 * @param cause 根异常类（可以存入任何异常）
	 */
	public BaseDaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
