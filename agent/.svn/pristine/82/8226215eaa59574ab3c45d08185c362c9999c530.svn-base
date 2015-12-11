/**
 * 软件著作权：北京东方正通科技有限公司
 *
 * 系统名称：值守应急系统产品（themis）
 *
 * 文件名称：DictAction.java
 *
 * 工程名：  themis_V1.0
 *		 
 * 版本历史：2008-11-09
 * 
 * 
 */
package com.harmony.themis.commons.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.harmony.apportal.sdk.dictdata.domain.DictData;
import com.harmony.themis.commons.Constants;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.util.ApportalUtil;
import com.harmony.themis.commons.util.ListRange;


public class DictAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1693046889554781322L;

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * 字典Code
	 */
    private String dictCode;

	/**
	 * 取得指定编码的字典项对象。
	 * 
	 */
	public void getDictData() {
		ListRange<DictData> formList = new ListRange<DictData>();
		// 字典集合
		List<DictData> list = null;
		// 返回结果
		boolean result = false;
		long totalSize = 0;
		// 输出结果
		String message = "";
		try {

			// 取得系统字典对象
			
			list =  ApportalUtil.getDictData(this.getDictCode(), this
					.getServletContext());
			
			if(list != null) {
				totalSize = list.size();
			}
			result = true;			
		} catch (Exception e) {
			message = MessageConstants.ACTION_LOAD_FAILURE;
			logger.error(message, e);			
		} finally {
			// 生成JSON数据格式串
			formList.setList(list);
			formList.setTotalSize(totalSize);
			formList.setMessage(message);
			formList.setSuccess(result);
			// 输出结果
			this.outJson(formList);
		}
	}

	/**
	 * 取得所有的字典项对象。
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void getAllDictData() {

		try {
			List<DictData> list = new ArrayList<DictData>();
			// 取得系统所有字典对象

			Map<String, List<DictData>> dictDataMap = (Map<String, List<DictData>>)
			this.getServletContext().getAttribute(Constants.DICT_DATA_MAP);
			
			if(dictDataMap != null) {
				Iterator it = dictDataMap.keySet().iterator();
				while(it.hasNext()) {
					DictData data = new DictData();
					data.setDictdataCode((String)it.next());
					data.setDictdataName(data.getDictdataCode());
					data.setDictdataText(data.getDictdataCode());
					list.add(data);
				}
			}
			// 生成JSON数据格式串
			this.outJsonByMsg(list);
		} catch (Exception e) {
			this.outJsonByErrorMsg(e);
		} 

	}
	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}





}
