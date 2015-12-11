package com.harmony.themis.commons.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.harmony.apportal.sdk.dictdata.domain.DictData;
import com.harmony.themis.commons.Constants;


/**
 * 
 * @author Administrator
 *
 */
public class SystemUtil {
	
	public static void setDictDataMap(ServletContext context) throws ServletException {
		Map<String,List<DictData>> dictDataMap = new HashMap<String,List<DictData>>();

		// 从web.xml取得初始化参数，以","分隔
		String dictCodeByStr = context.getInitParameter(Constants.DICT_CODE);
		dictCodeByStr = dictCodeByStr.replaceAll("\\n", "");
		dictCodeByStr = dictCodeByStr.replaceAll("\\t", "");
		dictCodeByStr = dictCodeByStr.replaceAll(" ", "");
		
		String[] dictCodes = StringUtils.split(dictCodeByStr, Constants.SEPARATOR_CHAR);
		// 从Apportal门户系统取得字典项数据,并放置到Map中
		dictDataMap = ApportalUtil.getDictDataMap(dictCodes);
		// 存取dictDataMap 为 application变量，以供应用调用
		context.setAttribute(Constants.DICT_DATA_MAP, dictDataMap);
	}
	
	/**
	 * 根据演练字典项配置设置静态变量
	 * @param context
	 */
	public static void setYanlianSetup(ServletContext context) {
		List<DictData> yanlianSetupList = ApportalUtil.getDictData(
				Constants.DICT_YANLIAN_SETUP, context);
		if (yanlianSetupList != null) {
			for (DictData dict : yanlianSetupList) {
				// 演练默认值守事件ID
//				if ("yanlian_defaultInfoDutyId".equals(dict
//						.getDictdataCode())) {
//					Constants.YANLIAN_GLOBAL_INFODUTY_ID = dict.getDictdataName().trim();
//				} 
				// 默认预案名称_模糊匹配
				if("yanlian_defaultPlansName".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_DEFAULT_PLANS_NAME = dict.getDictdataName().trim();
					
				}
				// 默认预案流程图名称_模糊匹配
				else if("yanlian_defaultFlowName".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_DEFAULT_FLOW_NAME = dict.getDictdataName().trim();
				}
				// 默认启动预案流程图ID_菱形 
				else if("yanlian_defaultStartFlowId".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_DEFAULT_START_FLOW_ID = dict.getDictdataName().trim();
				}
				// 默认启动预案流程图结点ID_菱形 
				else if("yanlian_defaultStartNodeId".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_DEFAULT_START_NODE_ID = dict.getDictdataName().trim();
				}	
				// 默认显示突发事件流程图结点ID
				else if("yanlian_defaultEventNodeId".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_DEFAULT_EVENT_NODE_ID = dict.getDictdataName().trim();
				}	
				// 事件信息刷新时间间隔（单位：秒）
				else if("yanlian_refresh_time".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_REFRESH_TIME = dict.getDictdataName().trim();
				}				
				// 事件信息滚动速度（单位：毫秒/像素）
				else if("yanlian_scrollSpeed".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_SCROLL_SPEED = dict.getDictdataName().trim();
				}
				// 应急案例对应的事件类型
				else if("yanlian_case_eventType".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_CASE_EVENT_TYPE = dict.getDictdataName().trim();
				}	
				// 灾害链对应的流程图主键
				else if("yanlian_flow_chainId".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_FLOW_CHAIN_ID = dict.getDictdataName().trim();
				}
				// 默认选中变色流程图节点
				else if("yanlian_selected_flow_nodes".equals(dict
						.getDictdataCode())) {
					// 拆分数据项描述内容
					//String[] nodes = dict.getDictdataText().trim().split(",");
					String[] nodes = StringUtils.split(dict.getDictdataText().trim(), "，");
					//Constants.YANLIAN_SELECTED_FLOW_NODES.clear();
					Constants.YANLIAN_SELECTED_FLOW_NODES.addAll(Arrays.asList(nodes));					
				}	
				// 演练事件管理传真打印模板编码
				else if("yanlian_fax_print_template".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_FAX_PRINT_TEMPLATE = dict.getDictdataName().trim();
				}
				// 演练预警类型
				else if("yanlian_warning_type".equals(dict
						.getDictdataCode())) {
					Constants.YANLIAN_WARNING_TYPE = dict.getDictdataName().trim();
				}
			}
		}
	}

}
