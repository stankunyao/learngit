package com.harmony.themis.commons;

public class ErrorCodeConstants {
	public static final String DAO_DELETE_EXCEPTION = "DAO_001";
	public static final String DAO_SAVE_EXCEPTION = "DAO_002";
	public static final String DAO_UPDATE_EXCEPTION = "DAO_003";
	public static final String DAO_SAVEORUPDATE_EXCEPTION = "DAO_004";
	public static final String DAO_SEARCH_EXCEPTION = "DAO_005";
	public static final String DAO_LOAD_EXCEPTION = "DAO_006";
	public static final String DAO_FIND_EXCEPTION = "DAO_007";
	public static final String DAO_FINDCOUNT_EXCEPTION = "DAO_008";
	public static final String DATA_ACCESS_EXCEPTION = "DAO_009";
	public static final String DAO_OTHER_EXCEPTION = "DAO_999";
	public static final String OTHER_EXCEPTION = "OTHER_001";
	
	public static final String FILE_IOEXCEPTION = "SYS_001。";
	
	public static final String SERVICE_NO_SOURCEORGID = "源组织为空或不存在，请刷新重试";
	public static final String SERVICE_NOFUND_PARENTID = "父组织找不到或已被删除，请刷新重试";
	public static final String SERVICE_NODTUY_ORG_EXCEPTION = "值班单位还没有设置，不能继续操作，请联系管理员。";
	public static final String SERVICE_USER_FAULTY_EXCEPTION = "用户关联信息还没有设置，不能继续操作，请联系管理员。";
	
	//public static final String LOGIC_BEANCLASS_ISNULL = "没有设置BeanClass属性";
	public static final String ACTION_ID_ISNULL = "没有指定操作的记录，请重试。";
	public static final String ACTION_DOWN_IO_EXCEPTION = "文件下载失败，IO操作发生异常，请确认文件是否存在。";
	public static final String ACTION_DOWN_NO_RECORD = "文件下载失败，不存在的数据库记录。";
	
	public static final String ACTION_DOWN_SERVICE_FAILURE = "文件下载失败，业务处理发生异常，请重试。";
	public static final String ACTION_DOWN_DB_FAILURE = "文件下载失败，数据库操作发生异常，请重试。";
	public static final String ACTION_DOWN_FAILURE = "文件下载失败，发生异常，请重试。";
	
	public static final String ACTION_SEARCH_SERVICE_FAILURE = "查询失败，业务处理发生异常，请重试。";
	public static final String ACTION_SEARCH_DB_FAILURE = "查询失败，数据库操作发生异常，请重试。";
	public static final String ACTION_SEARCH_FAILURE = "查询失败，发生异常，请重试。";
	
	public static final String ACTION_SAVE_SUCCESS = "增加成功。";	
	public static final String ACTION_SAVE_SERVICE_FAILURE = "增加记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_SAVE_DB_FAILURE = "增加记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_SAVE_FAILURE = "增加记录失败，发生异常，请重试。";
	
	public static final String ACTION_UPDATE_SUCCESS = "修改成功。";	
	public static final String ACTION_UPDATE_SERVICE_FAILURE = "修改记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_UPDATE_DB_FAILURE = "修改记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_UPDATE_FAILURE = "修改记录失败，发生异常，请重试。";
	
	public static final String ACTION_DELETE_SUCCESS = "删除成功。";	
	public static final String ACTION_DELETE_SERVICE_FAILURE = "删除记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_DELETE_DB_FAILURE = "删除记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_DELETE_FAILURE = "删除记录失败，发生异常，请重试。";
	
	public static final String ACTION_CONFLATION_SUCCESS = "合并成功。";	
	public static final String ACTION_CONFLATION_SERVICE_FAILURE = "合并记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_CONFLATION_DB_FAILURE = "合并记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_CONFLATION_FAILURE = "合并记录失败，发生异常，请重试。";
	
	public static final String ACTION_SPLIT_SUCCESS = "拆分成功。";	
	public static final String ACTION_SPLIT_SERVICE_FAILURE = "拆分记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_SPLIT_DB_FAILURE = "拆分记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_SPLIT_FAILURE = "拆分记录失败，发生异常，请重试。";
	
	public static final String ACTION_LOAD_SERVICE_FAILURE = "加载记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_LOAD_DB_FAILURE = "加载记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_LOAD_FAILURE = "加载记录失败，发生异常，请重试。";
	
	public static final String ACTION_SYSNC_SUCCESS = "同步数据成功。";
	public static final String ACTION_SYSNC_FAILURE = "同步数据失败，发生异常，请重试。";
}
