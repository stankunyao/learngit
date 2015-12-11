package com.harmony.themis.commons;

import java.util.HashMap;
import java.util.Map;

public class MessageConstants {
	public static final String DAO_DELETE_EXCEPTION = "删除发生数据访问异常。";
	public static final String DAO_SAVE_EXCEPTION = "保存发生数据访问异常。";
	public static final String DAO_UPDATE_EXCEPTION = "更新发生数据访问异常。";
	public static final String DAO_SAVEORUPDATE_EXCEPTION = "更新发生数据访问异常。";
	public static final String DAO_SEARCH_EXCEPTION = "查询发生数据访问异常。";
	public static final String DAO_LOAD_EXCEPTION = "加载对象发生数据访问异常。";
	public static final String DAO_FIND_EXCEPTION = "查询记录发生数据访问异常。";
	public static final String DAO_FINDCOUNT_EXCEPTION = "查询记录总数发生数据访问异常。";
	public static final String DAO_OTHER_EXCEPTION = "访问数据库时，发生系统内部其他未知异常。";
	public static final String DAO_DELETEEVENT = "此数据已被使用，不能删除";
	public static final String DAO_DATAACESS_EXCEPTION = "通过框架访问数据库时，发生数据访问异常，请联系管理员。";
	
	public static final String DATA_ACCESS_EXCEPTION = "发生数据访问异常。";
	public static final String OTHER_EXCEPTION = "发生系统内部其他未知异常。";
	public static final String FILE_IOEXCEPTION = "文件操作发生异常。";
	public static final String FILENOTFOUND_EXCEPTION = "文件没有找到。";
	public static final String BEANUTILS_COPYXCEPTION = "对象复制出现错误。";
	
	public static final String SERVICE_NO_SOURCEORGID = "源组织为空或不存在，请刷新重试";
	public static final String SERVICE_NOFUND_PARENTID = "父组织找不到或已被删除，请刷新重试";
	public static final String SERVICE_NODTUY_ORG_EXCEPTION = "值班单位还没有设置，不能继续操作，请联系管理员。";
	public static final String SERVICE_USER_FAULTY_EXCEPTION = "用户关联信息还没有设置或用户已被删除，不能继续操作，请联系管理员。";
	public static final String SERVICE_PERSON_ISUSED = "此人员在本组织中已经存在，不能重复选择！";
	public static final String SERVICE_PERSON_ORG_DELETE = "此人员关联的值班单位已经被删除，不能继续操作，请联系管理员";
	
	public static final String SERVICE_ID_NOFUND_EXCEPTION = "主键为空或记录已删除，找不到相关记录，请重试。";
	
	public static final String SERVICE_EXISTS_SENDORGID = "你选择的单位已经被选择过，不能重复选择，请重试。<br>重复单位为：";
	//public static final String LOGIC_BEANCLASS_ISNULL = "没有设置BeanClass属性";
	public static final String ACTION_ID_ISNULL = "没有指定操作的记录，请重试。";
	public static final String ACTION_PARAM_ISNULL = "必要的参数值为空，不能继续，请重试。";
	public static final String ACTION_SORTCODE_NOTFOUND = "没有找到指定的业务代码，请重试。";
	public static final String ACTION_ORG_NOTFOUND = "组织机构码没有配置。";
	public static final String ACTION_PDA_ROLE_NOTFOUND = "请为PDA用户分配权限";
	public static final String ACTION_PDA_USERID = "账户已存在";
	public static final String ACTION_ATORG_NOTFOUND = "AT机构码没有配置。";
	public static final String ACTION_APPORTAL_NOTFOUND = "apportal中没有找到匹配的AT机构码。";
	public static final String ACTION_ATORG_NOTONLOY = "apportal机构码不唯一。";
	public static final String ACTION_MODULE_NOTFOUND = "没有找到指定的模块代码，请重试。";
	public static final String ACTION_USERID_ISUSED = "对不起，你选择的用户名，已经被其他用户使用，请重新选择。";
	public static final String ACTION_EXIST_CODE = "编码值已经存在，请重新输入。";
	public static final String ACTION_OLDPASSWORD_ERROR = "旧密码有误，修改密码不成功，请重新输入。";
	public static final String ACTION_PWD_CHANGE_SUCCESS = "修改密码成功。";
	public static final String ACTION_USER_NOSESSION = "用户会话信息失效，请重新登录。";
	public static final String ACTION_FILE_NOTFOUND = "文件为空，或没有找到。";
	public static final String ACTION_FILE_CONTENTTYPE_ERROR = "上传的文件类型不正确，请上传WORD或EXCEL文件。";
	public static final String ACTION_FILE_EXPORT_ERROR = "导出文件的文件类型不正确，只能导出到Excel中。";
	
	public static final String ACTION_RECORD_CHANGED = "你操作的记录被其他用户修改，请刷新重试。";
	public static final String ACTION_PRINTDATA_KEY_ISNULL = "没有指定打印数据服务，请刷新重试。";
	
	public static final String ACTION_DOWN_IO_EXCEPTION = "文件下载失败，IO操作发生异常，请确认文件是否存在。";
	public static final String ACTION_DOWN_NO_RECORD = "文件下载失败，不存在的数据库记录。";
	
	public static final String ACTION_DOWN_SERVICE_FAILURE = "文件下载失败，业务处理发生异常，请重试。";
	public static final String ACTION_DOWN_DB_FAILURE = "文件下载失败，数据库操作发生异常，请重试。";
	public static final String ACTION_DOWN_FAILURE = "文件下载失败，发生异常，请重试。";
	
	public static final String ACTION_SEARCH_SERVICE_FAILURE = "查询失败，业务处理发生异常，请重试。";
	public static final String ACTION_SEARCH_DB_FAILURE = "查询失败，数据库操作发生异常，请重试。";
	public static final String ACTION_SEARCH_FAILURE = "查询失败，发生异常，请重试。";
	
	public static final String ACTION_SAVE_SUCCESS = "保存成功。";	
	public static final String ACTION_SAVE_TO_SUCCESS = "由于当前日期的交接班记录已存在，该操作被视为修改操作。";	
	public static final String ACTION_SAVE_SERVICE_FAILURE = "增加记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_SAVE_DB_FAILURE = "增加记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_SAVE_FAILURE = "增加记录失败，发生异常，请重试。";
	
	public static final String ACTION_UPDATE_SUCCESS = "修改成功。";	
	public static final String ACTION_REPORT_SUCCESS = "上报成功。";	
	public static final String ACTION_UPDATE_SERVICE_FAILURE = "修改记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_UPDATE_DB_FAILURE = "修改记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_UPDATE_FAILURE = "修改记录失败，发生异常，请重试。";
	
	public static final String ACTION_SEND_SUCCESS = "发送成功。";
	
	public static final String ACTION_START_MEETING_SUCCESS = "发起视频会议成功。";
	public static final String ACTION_START_MEETING_FAILURE = "发起视频会议失败,你要开启的会议还未结束,如有异议请联系主持人：";
	public static final String ACTION_STOP_MEETING_SUCCESS = "结束视频会议成功。";
	public static final String ACTION_STOP_MEETING_FAILURE = "结束视频会议失败。";
	public static final String ACTION_INVITE_SUCCESS = "视频会议邀请成功。";
	public static final String ACTION_INVITE_FAILURE = "视频会议邀请失败，此会议已结束，请刷新重试。";
	public static final String ACTION_INVITEE_NOTFOUND = "邀请人没有找到，请重试。";	
	public static final String ACTION_INVITE_RECEIVE_SUCCESS = "接受视频会议邀请成功。";
	
	public static final String ACTION_DELETE_SUCCESS = "成功删除";	
	public static final String ACTION_DELETE_SERVICE_FAILURE = "删除记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_DELETE_DB_FAILURE = "删除记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_DELETE_FAILURE = "删除记录失败，发生异常，请重试。";
	
	public static final String ACTION_UNDO_SUCCESS = "还原成功。";	
	public static final String ACTION_IMPORT_SUCCESS = "导入成功。";	
	public static final String ACTION_EXPORT_SUCCESS = "导出成功。";	
	
	public static final String ACTION_CONFLATION_SUCCESS = "合并成功。";	
	public static final String ACTION_CONFLATION_SERVICE_FAILURE = "合并记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_CONFLATION_DB_FAILURE = "合并记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_CONFLATION_FAILURE = "合并记录失败，发生异常，请重试。";
	
	public static final String ACTION_SPLIT_SUCCESS = "拆分成功。";	
	public static final String ACTION_SPLIT_SERVICE_FAILURE = "拆分记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_SPLIT_DB_FAILURE = "拆分记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_SPLIT_FAILURE = "拆分记录失败，发生异常，请重试。";
	
	public static final String ACTION_LOAD_SUCCESS = "加载记录成功。";
	public static final String ACTION_LOAD_SERVICE_FAILURE = "加载记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_LOAD_DB_FAILURE = "加载记录失败，数据库操作发生异常，请重试。";
	public static final String ACTION_LOAD_FAILURE = "加载记录失败，发生异常，请重试。";
	
	public static final String ACTION_SYSNC_SUCCESS = "同步数据成功。";
	public static final String ACTION_SYSNC_FAILURE = "同步数据失败，发生异常，请重试。";
	
	public static final String ACTION_UPDATE_PUBLIC_SUCCESS = "公用账号信息保存成功。";
	
	public static final String ACTION_PUBLISH_SUCCESS = "发布成功。";
	public static final String ACTION_UNDO_PUBLISH_SUCCESS = "取消发布成功。";
	public static final String ACTION_PUBLISH_SERVICE_FAILURE = "发布记录失败，业务处理发生异常，请重试。";
	public static final String ACTION_PUBLISH_DB_FAILURE = "发布记录失败，数据库操作发生异常，请重试。";
	
	public static final String ACTION_FEEDBACK_SUCCESS = "反馈成功。";
	public static final String ACTION_INTENDSTO_SUCCESS = "归档成功。";
	
	//值班表操作
	public static final String ACTION_DUTY_SAVE_SUCCESS = "保存成功。";
	public static final String ACTION_DUTY_REPORT_SUCCESS = "上报成功。";
	public static final String ACTION_DUTY_ENABLE_SUCCESS = "生效成功。";
	public static final String ACTION_DUTY_CANCEL_SUCCESS = "取消生效成功。";
	
	public static final String ACTION_RESOURCE_CHECK_FAILURE = "该记录已经审核过。";
	public static final String ACTION_RESOURCE_CHECK_SUCCESS = "审核成功。";
	
	//短信发送
	public static final String ACTION_MESSAGE_SEND_NULL = "警告：短信发送功能未开启，不能继续操作。请在系统配置管理中修改。";
	public static final String ACTION_MESSAGE_SEND_SUCCESS = "短信发送成功。";
	public static final String ACTION_MESSAGE_SEND_FAILURE = "短信发送失败。";
	//传真发送
	public static final String ACTION_FAX_SEND_SUCCESS = "传真发送成功。";
	public static final String ACTION_FAX_SEND_FAILURE = "传真发送失败。";
	//网络信息发送
	public static final String ACTION_WEBMESSAGE_SEND_SUCCESS = "网络信息发送成功。";
	public static final String ACTION_WEBMESSAGE_SEND_FAILURE = "网络信息发送失败。";
   //打电话
	public static final String ACTION_TELCALL_SUCCESS = "电话拨号成功。";
	public static final String ACTION_TELCALL_FAILURE = "电话拨号失败。";
	
	public static final String ACTION_DELETE_RESOURCE_FAILURE = "基层上报或已经审核记录不能删除。";
	public static final String ACTION_DELETE_RESOURCE_WARN_FAILURE = "基层上报、上级下发或已经审核记录不能删除。";
	
	//特殊时期设置
	public static final String CHECK_DUTY_SPE_ITER = "该值班时期的日期范围与其他值班时期有重复，请重新选择日期范围！";
	//预案结构
	public static final String PLANSITEM_SAVE_SAMECODE="已存在的编码,节点编码必须唯一！";//保存时存在相同code
	public static final String PLANS_ISSUE_FALIURE="该记录已上报!";
	public static final String PLANS_APPROVE_NOTYET="该记录尚未审核!";
	public static final String PLANS_APPROVE_SUCCESS="审核成功!";
	public static final String PLANS_ISSUE_SUCCESS="成功发布";
	public static final String PLANS_ISSUE_CANCEL="取消发布";
	public static final String PLANS_REPORT_SUCCESS="成功上报";
	public static final String PLANS_REVISE_NOYETISSUE="该记录尚未发布,不能修订!";
	public static final String PLANS_REPORT_CANNOTUPDATE="该记录已经上报不能修改!";
	public static final String PLANS_REPORT_CANNOTDELETE="该记录已经上报不能删除!";
	
	public static final String ACTION_VALIDATE_CODE_ERROR = "你输入验证码不正确，请重试。";	
	public static final String ACTION_VALIDATE_CODE_SUCCESS = "验证通过，现在以值班身份登录。";
	public static final String ACTION_UPDATE_ERROR = "即时通信同步失败，请检查网络";
	public static final  String MESSAGE_SEND_SYNSTATE = "1";
	public static final  String MESSAGE_SEND_NSYNSTATE = "0";
	public static final  String MESSAGE_SEND_UNKNOWN = "其它原因";
	public static final  String MESSAGE_SEND = "发送中";
	public static final  String MESSAGE_SEND_SUCCESS = "发送成功";
	public static final  String MESSAGE_SEND_FAILE = "发送失败";
	//情况类别的map
	public static  Map<String, String> eventTypeMap = null;
	//情况类别细类的map
	public static  Map<String, String> eventSubTypeMap = null;
	public static final Map getEventTypeStr(){
		 
		if(eventTypeMap==null){
			eventTypeMap = new HashMap<String, String>();
			eventTypeMap.put("10000","突发事件");
			eventTypeMap.put("W0000","工作动态");
			eventTypeMap.put("B0000","预警信息");
			eventTypeMap.put("S0000","工作建议");
		 
		}
		
		return eventTypeMap;
	}
	public static final Map getEventSubTypeStr(){
		 
		if(eventSubTypeMap==null){
			eventSubTypeMap = new HashMap<String, String>();
			 
			
 
			eventSubTypeMap.put("13000","公共卫生");
			eventSubTypeMap.put("12000","事故灾难");
			eventSubTypeMap.put("11000","自然灾害");
			eventSubTypeMap.put("14000","社会安全");
		}
		
		return eventSubTypeMap;
	}
	

}
