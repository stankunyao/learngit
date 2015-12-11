package com.harmony.themis.commons.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;

import com.harmony.apportal.common.ApportalConstants;
import com.harmony.themis.commons.Constants;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.bean.LoginUserInfo;
import com.harmony.themis.commons.exception.BaseActionException;
import com.harmony.themis.commons.exception.BaseException;
import com.harmony.themis.commons.json.JsonValueProcessorImpl;
import com.harmony.themis.commons.util.ListRange;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action基类，实现将JSON格式结果的输出方法
 */
public class BaseAction extends ActionSupport implements Serializable {
	/**  */
	private static final long serialVersionUID = 1L;
	protected static int DEFAULTPAGESIZE = ApportalConstants.PAGESIZE_DEFAULT;
	
	/**
	 * 分页开始记录
	 */
	private int page;
	/**
	 * 每页条数
	 */
	private int rows;
	
	/**
	 * 排序名称
	 */
	private String sort;
	/**
	 * 排序方向
	 */
	private String dir;
	protected static String datePattern = "yyyy年MM月dd日";
	/**
	 * 从Session中取得用户信息
	 * @return LoginUserInfo 用户信息
	 */
	public LoginUserInfo getLoginUserInfo() {
		HttpSession session = this.getRequest().getSession();
		LoginUserInfo userInfo = (LoginUserInfo)session.getAttribute(Constants.SESSION_USER_INFO);
		if(userInfo == null) {
			throw new BaseActionException("NOLOGIN001",MessageConstants.ACTION_USER_NOSESSION);
		}
		return userInfo;
	}
	
	/**
	 * 取得HttpServletRequest对象
	 * @return HttpServletRequest对象
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 取得Response对象
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 取得ServletContext对象
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	/**
	 * 转换字符串为json 格式
	 * @param str 普通字符串
	 */
	public void outJsonString(String str) {
		//getResponse().setContentType("text/javascript;charset=UTF-8");
		getResponse().setContentType("text/html;charset=UTF-8");
		outString(str);
	}

	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 */
	public void outJson(Object obj) {
		outJsonString(JSONObject.fromObject(obj).toString());
	}
	
	
	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 */
	@SuppressWarnings("unchecked")
	public void outJsonByMsg(Object obj) {
		this.outJsonByMsg(obj,0, null,null,0,0);
	}

	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 * @param message 提示信息
	 */
	public void outJsonByMsg(Object obj,String message) {
		this.outJsonByMsg(obj,0, message,null,0,0);
	}
	
	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 * @param message 提示信息
	 * @param format 日期格式
	 */
	public void outJsonByMsg(Object obj,String message,String format) {
		this.outJsonByMsg(obj, 0,message,format,0,0);
	}
	
	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 * @param message 提示信息
	 */
	public void outJsonByMsg(String message) {
		this.outJsonByMsg(null, 0,message,null,0,0);
	}
	
	/**
	 *  转换ListRange对象为json 格式
	 * @param obj 任意对象
	 * @param totalSize 记录总数
	 */
	@SuppressWarnings("unchecked")
	public void outJsonByMsg(List list,long totalSize,int page,int rows) {
		this.outJsonByMsg(list,totalSize,null,null,page,rows);
	}
	
	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 * @param message 提示信息
	 * @param format 日期格式
	 */
	@SuppressWarnings("unchecked")
	public void outJsonByMsg(Object obj,long totalSize,String message,String format,int page,int rows) {
		if(message == null) {
			message = "";
		}
		JsonConfig config = this.getJsonConfig(format);
		// 类型为集合
		if(obj instanceof List) {
			
			if(obj != null && totalSize == 0) {
				totalSize = ((List)obj).size();
			}
			ListRange formList = new ListRange();
			formList.setMessage(message);
			formList.setSuccess(true);
			formList.setList((List)obj);
			formList.setTotalSize(totalSize);
			formList.setPage(page);
			formList.setRows(rows);
			int totalPage=0;
			if(totalSize%rows==0){
				totalPage=(int) (totalSize/rows);
			}
			else
				totalPage=(int) (totalSize/rows)+1;
			formList.setTotalPage(totalPage);
			JSONObject json = JSONObject.fromObject(formList,config);
			outJsonString(json.toString());
		} else {
			if(obj == null) {
				obj = new Object();
			}	
			JSONObject json = JSONObject.fromObject(obj,config);
			json.accumulate("message", message);
			json.accumulate("success", true);
			outJsonString(json.toString());
		}
	}
	
	/**
	 *  转换任意对象为json 格式
	 * @param obj 任意对象
	 * @param message 提示信息
	 * @param format 日期格式
	 * 不分页
	 */
	@SuppressWarnings("unchecked")
	public void outJsonByMsgNoPage(Object obj,long totalSize,String message,String format) {
		page=1;
		rows=100;
		if(message == null) {
			message = "";
		}
		JsonConfig config = this.getJsonConfig(format);
		// 类型为集合
		if(obj instanceof List) {
			
			if(obj != null && totalSize == 0) {
				totalSize = ((List)obj).size();
			}
			ListRange formList = new ListRange();
			formList.setMessage(message);
			formList.setSuccess(true);
			formList.setList((List)obj);
			formList.setTotalSize(totalSize);
			formList.setPage(page);
			formList.setRows(rows);
			int totalPage=0;
			if(totalSize%rows==0){
				totalPage=(int) (totalSize/rows);
			}
			else
				totalPage=(int) (totalSize/rows)+1;
			formList.setTotalPage(totalPage);
			JSONObject json = JSONObject.fromObject(formList,config);
			String a=json.toString();
			outJsonString(json.toString());
		} else {
			if(obj == null) {
				obj = new Object();
			}	
			JSONObject json = JSONObject.fromObject(obj,config);
			json.accumulate("message", message);
			json.accumulate("success", true);
			String a=json.toString();
			outJsonString(json.toString());
		}
	}
	

	/**
	 *  转换任意对象为json 格式,并输出错误信息
	 * @param obj 任意对象
	 * @param e 异常对象
	 * @param defaultMsg 默认错误信息
	 */
	public void outJsonByErrorMsg(Object obj,Exception e,String defaultMsg) {
		if(obj == null) {
			obj = new Object();
		}
		if(defaultMsg == null) {
			defaultMsg = "";
		} else {
			defaultMsg = defaultMsg +",";
		}
		
		String message = "";
		String errorCode = "";
		if(e instanceof BaseActionException) {
			message =  this.getText(defaultMsg + e.getMessage());
			errorCode = ((BaseActionException)e).getErrorCode();
		} else if(e instanceof BaseException) {
			message =  this.getText(defaultMsg + e.getMessage());
		} else if(e instanceof DataAccessException ) {
			message = this.getText(defaultMsg + MessageConstants.DAO_DATAACESS_EXCEPTION);
		} else {
			if(StringUtils.isEmpty(defaultMsg)) {
				message = this.getText(MessageConstants.OTHER_EXCEPTION);
			} else {
				message = this.getText(defaultMsg);
			}
		}
		JSONObject json = JSONObject.fromObject(obj);
		json.accumulate("message", message);
		json.accumulate("errorCode", errorCode);
		json.accumulate("success", false);
		outJsonString(json.toString());
		
	}
	/**
	 *  转换任意对象为json 格式,并输出错误信息
	 * @param e 异常对象
	 * @param defaultMsg 默认错误信息
	 */
	public void outJsonByErrorMsg(Exception e,String defaultMsg) {
		this.outJsonByErrorMsg(null,e,defaultMsg);
	}
	/**
	 *  转换任意对象为json 格式,并输出错误信息
	 * @param e 异常对象
	 */
	public void outJsonByErrorMsg(Exception e) {
		this.outJsonByErrorMsg(e,null);
	}
	
	public void outJsonByErrorMsg(String s) {
		this.outJsonByErrorMsg(null,s);
	}
	
	/**
	 * 转换字符串为json 格式，并设置ContentType为text/html
	 * @param str 普通字符串
	 */
	public void outJsonStringOther(String str) {
		getResponse().setContentType("text/html;charset=UTF-8");
		outString(str);
	}

	/**
	 *  转换任意对象为json 格式，并设置ContentType为text/html
	 * @param obj 任意对象
	 */
	public void outJsonOther(Object obj) {
		outJsonStringOther(JSONObject.fromObject(obj).toString());
	}

	/**
	 * 输出集合对象为json 数组格式
	 * @param array 集合对象
	 */
	public void outJsonArray(Object array) {
		outJsonString(JSONArray.fromObject(array).toString());
	}

	/**
	 * 输出字符串到页面
	 * @param str 字符
	 */
	public void outString(String str) {
		try {
			getResponse().setHeader("Cache-Control", "no-cache");
			getResponse().setHeader("Cache-Control", "no-store");
			getResponse().setDateHeader("Expires", 0L);
			getResponse().setHeader("Pragma", "no-cache");	
			PrintWriter out = getResponse().getWriter();
			out.write(str);
			getResponse().flushBuffer();
		} catch (IOException e) {
		}
	}

	/**
	 * 输出xml文本串到页面
	 * @param xmlStr xml串
	 */
	public void outXMLString(String xmlStr) {
		getResponse().setContentType("application/xml;charset=UTF-8");
		outString(xmlStr);
	}

	/**
	 * 格式化默认日期
	 * @return
	 */
	public JsonConfig getJsonConfig() {
		return this.getJsonConfig(null);
	}
	
	/**
	 * 根据指定格式格式化日期
	 * @param format 根据format
	 * @return
	 */
	public JsonConfig getJsonConfig(String format) {
		if(format == null) {
			//format = Constants.DATETIME_FORMAT_NO_SECEND;
			format = Constants.DATETIME_FORMAT;
		}
		JsonConfig conf = new JsonConfig();
		conf.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);   
		// 转换日期格式
		conf.registerJsonValueProcessor(Date.class,
				new JsonValueProcessorImpl(
						format));
		return conf;
	}
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	private String _dc; 
	private String first;
	private String node;
	private String level;

	public String get_dc() {
		return _dc;
	}

	public void set_dc(String _dc) {
		this._dc = _dc;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
