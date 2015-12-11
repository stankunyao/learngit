package com.harmony.themis.software.action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.harmony.apportal.common.util.StringUtil;
import com.harmony.themis.commons.Constants;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.exception.BaseDaoException;
import com.harmony.themis.commons.util.DateFormatUtils;
import com.harmony.themis.commons.util.ListRange;
import com.harmony.themis.commons.web.action.BaseAction;
import com.harmony.themis.excel.exportexcel.ExcelExportByColumnIndex;
import com.harmony.themis.main.util.PropertiesUtil;
import com.harmony.themis.persistence.domain.Agent;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.persistence.domain.SystemConfig;
import com.harmony.themis.software.domain.AgentHistoryView;
import com.harmony.themis.software.domain.AgentView;
import com.harmony.themis.software.service.MonitorServiceInterface;
import com.harmony.themis.software.service.MonitoryHistoryServiceInterface;

public class MonitorServiceAction extends BaseAction {
	protected final Log logger = LogFactory.getLog(getClass());
	private MonitorServiceInterface agentService;
	private MonitoryHistoryServiceInterface historyService;
	/**
	 * 重启服务的数据库ID
	 */
	private String ids;
	/**
	 * 分页开始记录
	 */
	private int page;
	/**
	 * 每页条数
	 */
	private int rows;
	/**
	 * 排序方向
	 */
	private String dir;
	/**
	 * 排序名称
	 */
	private String sort;
	/**
	 * 开始-接收时间
	 */
	private Date startReceivertime;
	/**
	 * 结束-接收时间
	 */
	private Date endReceivertime;
	/**
	 * 机器名称
	 */
	private String serviceName;

	/**
	 * 根据参数查询正常服务记录
	 */
	public void getNormalByParamByPage() {
		try {
			List<Agent> sampleList = new ArrayList<Agent>();
			Agent param = getAgentBean();
			param.setMonitorServiceStatu("1");
			param.setIntervalTimer(10);
//			param.setStatus("1");
			sampleList = agentService.findMonitorServiceListBySqlByPage(param,
					this.getPage(), this.getRows(), this.getSort(),
					this.getDir(), true, "");
			Long size = agentService.findMonitorServiceCountBySql(param, "");
			List<AgentView> agentList = new ArrayList<AgentView>();
			agentList = agentService.setAgentView(agentList, sampleList);
			this.outJsonByMsg(agentList, size, null,
					Constants.DATETIME_FORMAT_NO_SECEND,0,0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 根据参数查询服务异常记录
	 */
	public void getAbNormalByParamByPage() {
		try {
			List<Agent> sampleList = new ArrayList<Agent>();
			Agent param = new Agent();
			sampleList = agentService.findAllAgent();
			Long size = agentService.findMonitorServiceCountBySql(param, "");
			List<AgentView> agentList = new ArrayList<AgentView>();
			agentList = agentService.setAgentView(agentList, sampleList);
			this.outJsonByMsgNoPage(agentList, size, null,
					Constants.DATETIME_FORMAT_NO_SECEND);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 根据参数查询监控服务异常记录
	 */
	public void getAbMonitorNormalByParamByPage() {
		try {
			List<Agent> sampleList = new ArrayList<Agent>();
			Agent param = new Agent();
			param.setMonitorServiceStatu("0");
			String intervalTimer=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "intervalTimer");
			param.setIntervalTimer(Integer.parseInt(intervalTimer));
			sampleList = agentService.findMonitorServiceListBySqlByPage(param,
					this.getPage(), this.getRows(), this.getSort(),
					this.getDir(), true, "");
			Long size = agentService.findMonitorServiceCountBySql(param, "");
			List<AgentView> agentList = new ArrayList<AgentView>();
			agentList = agentService.setAgentView(agentList, sampleList);
//			if(agentList!=null && agentList.size()>0)
//			{
//				System.out.println("------------------------------------------------");
//				System.out.println("IP为"+agentList.get(0).getServiceip()+"监控服务出现了异常");
//				System.out.println("------------------------------------------------");
//			}
			this.outJsonByMsg(agentList, size, null,
					Constants.DATETIME_FORMAT_NO_SECEND,0,0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 根据参数查询历史记录
	 */
	public void getHistoryListByParamByPage() {
		SystemConfig systemConfig = (SystemConfig) this.getServletContext()
				.getAttribute(Constants.APPLICATION_SYSTEM_INFO);
		try {
			String pageStr=this.getRequest().getParameter("page");
			String rowsStr=this.getRequest().getParameter("rows");
			page=Integer.parseInt(pageStr);
			rows=Integer.parseInt(rowsStr);
			List<AgentHistory> sampleList = new ArrayList<AgentHistory>();
			AgentHistory param = this.getHistoryBean();
			historyService.setSystemConfig(systemConfig);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AgentHistory.class); 
			detachedCriteria.add(Restrictions.like("serverName", "%"+param.getServerName()+ "%"));
			detachedCriteria.add(Restrictions.like("serviceName", "%"+param.getServiceName()+ "%"));
			detachedCriteria.add(Restrictions.between("sendTime", param.getStartTimer(), param.getEndTimer()));
			detachedCriteria.addOrder(Order.desc("sendTime"));
			int start=(page-1)*rows;
			sampleList = historyService.findListByDetachedCriteria(detachedCriteria, start, this.rows);
			Long size = historyService.findCountByParam(param);
			List<AgentHistoryView> agentList = new ArrayList<AgentHistoryView>();
			agentList = historyService.setAgentHistoryView(agentList,
					sampleList);
			this.outJsonByMsg(agentList, size, null,
					Constants.DATETIME_FORMAT_NO_SECEND,page,rows);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * 
	 */
	public void exportExcel(){
		
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		String path = basePath + "contents/template/monitor_history.xls";

		ExcelExportByColumnIndex<AgentHistoryView> excelExportByColumnIndex = new ExcelExportByColumnIndex<AgentHistoryView>();
		// 设置属性对应列
		Map<String, String> filedname_cellnum_map = new HashMap<String, String>();
		filedname_cellnum_map.put("serverName", "A");
		filedname_cellnum_map.put("serverIp", "B");
		filedname_cellnum_map.put("serviceName", "C");
		filedname_cellnum_map.put("errorTypeStr", "D");
		filedname_cellnum_map.put("sendTime", "E");
		filedname_cellnum_map.put("sendType", "F");
		filedname_cellnum_map.put("receiveUser", "G");
		filedname_cellnum_map.put("sendStatus", "H");
		filedname_cellnum_map.put("sendContent", "I");
		excelExportByColumnIndex
				.init_filedname_cellnum_map(filedname_cellnum_map);
		// 从哪一行开始
		excelExportByColumnIndex.initstartrow(3);
		// 将导出对象进行初始化
		excelExportByColumnIndex.initclsaa(AgentHistoryView.class);

		// 得到导出数据List
		SystemConfig systemConfig = (SystemConfig) this.getServletContext()
				.getAttribute(Constants.APPLICATION_SYSTEM_INFO);
		AgentHistory param = new AgentHistory();
		try {
			param = this.getHistoryBean();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int count=(int)historyService.findCountByParam(param);
		List<AgentHistoryView> agentList = loadExportData(systemConfig, param,
				0, count, "sendTime", "desc");
		if(agentList.size() == 0){
			AgentHistoryView history = new AgentHistoryView();
			history.setServerName("");
			agentList.add(history);
		}
		
		// 设置样式参数
		Map<String, String> argsMap = new HashMap<String, String>();
		// argsMap.put("rowHeight", "700");
		// 如果参数map中有rowHeight
		// 如果参数map中没有有rowHeight 则默认为上一行的高度
		// argsMap.put("rowHeight", "700")
		// 如果参数map中有sheetnum 此为导出的目标sheet 默认为0
		argsMap.put("sheetnum", "0");
		// 可进行标题行的修改
		Map<String, String> titleMap = new HashMap<String, String>();
		// 文件保存格式
		SimpleDateFormat date = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		try {
			excelExportByColumnIndex.exportExcel(
					"监控日志_" + date.format(new Date()),
					// 需要导出的数据
					agentList,
					// HttpServletResponse
					getResponse(),
					// 参数对象
					argsMap,
					// 导出模板
					new FileInputStream(path), titleMap);
		} catch (FileNotFoundException fileNotFound) {
			logger.error("监控日志模版文件无法找到无法找到: " + path);
		}
		
	}
	
	/**
	 * 进行导出数据的查询
	 * @param systemConfig
	 * @param param
	 * @param start
	 * @param limit
	 * @param sort
	 * @param dir
	 * @return
	 */
	private List<AgentHistoryView> loadExportData(SystemConfig systemConfig, AgentHistory param,
			int start, int limit, String sort, String dir){
		List<AgentHistoryView> agentList = new ArrayList<AgentHistoryView>();
		try {
			List<AgentHistory> sampleList = new ArrayList<AgentHistory>();
			historyService.setSystemConfig(systemConfig);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AgentHistory.class); 
			detachedCriteria.add(Restrictions.like("serverName", "%"+param.getServerName()+ "%"));
			detachedCriteria.add(Restrictions.like("serviceName", "%"+param.getServiceName()+ "%"));
			detachedCriteria.add(Restrictions.between("sendTime", param.getStartTimer(), param.getEndTimer()));
			detachedCriteria.addOrder(Order.desc("sendTime"));
			sampleList = historyService.findListByDetachedCriteria(detachedCriteria, start, limit);
			agentList = historyService.setAgentHistoryView(agentList, sampleList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return agentList;
	}
	public void rebootService() {
		ListRange<Agent> formList = new ListRange<Agent>();
		// 返回结果
		boolean result = false;
		// 输出结果
		String message = "";
		try {
			if (StringUtils.isEmpty(this.getIds())) {
				message = MessageConstants.ACTION_ID_ISNULL;
				return;
			}
			// 通过主键加载要修改的记录
			String agentIds[] = ids.split(";");
			for (int i = 0; i < agentIds.length; i++) {
				Agent infoAgent = agentService.getById(agentIds[i]);
				agentService.update(infoAgent);
			}
			result = true;
		} catch (Exception be) {
			message = MessageConstants.ACTION_UPDATE_SERVICE_FAILURE;
			if (be.getCause() instanceof BaseDaoException) {
				message = MessageConstants.ACTION_UPDATE_DB_FAILURE;
			}
			logger.error(message, be);
		} finally {
			formList.setSuccess(result);
			this.outJsonOther(formList);
		}
	}

	public MonitorServiceInterface getAgentService() {
		return agentService;
	}

	public void setAgentService(MonitorServiceInterface agentService) {
		this.agentService = agentService;
	}

	public int getStart() {
		return page;
	}

	public void setStart(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setLimit(int rows) {
		this.rows = rows;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public MonitoryHistoryServiceInterface getHistoryService() {
		return historyService;
	}

	public void setHistoryService(MonitoryHistoryServiceInterface historyService) {
		this.historyService = historyService;
	}

	public Date getStartReceivertime() {
		return startReceivertime;
	}

	public void setStartReceivertime(Date startReceivertime) {
		this.startReceivertime = startReceivertime;
	}

	public Date getEndReceivertime() {
		return endReceivertime;
	}

	public void setEndReceivertime(Date endReceivertime) {
		this.endReceivertime = endReceivertime;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * 获取页面的HistoryBean
	 * 
	 * @return
	 * @throws ParseException
	 */
	private AgentHistory getHistoryBean() throws ParseException {
		AgentHistory parm = new AgentHistory();
		String serviceName = this.getRequest().getParameter("serviceName");
		String serverName=this.getRequest().getParameter("serverName");
		String startTimer = this.getRequest().getParameter("startReceivertime");
		String endTimer = this.getRequest().getParameter("endReceivertime");
		if(serviceName==null){
			serviceName="";
		}
		if(serverName==null){
			serverName="";
		}
		parm.setServiceName(serviceName);
		parm.setServerName(serverName);
		if(startTimer==null||startTimer.equals("")){
			startTimer="1900-01-01";
		}
		if(endTimer==null||endTimer.equals("")){
			endTimer="2099-11-11";
		}
		startTimer+=" 00:00:00";
		endTimer+=" 23:59:59";
		if (startTimer != null && startTimer.trim().length() != 0) {
			parm.setStartTimer(DateFormatUtils.parse(startTimer,
					Constants.DATETIME_FORMAT));
		}
		if (endTimer != null && endTimer.trim().length() != 0) {
			parm.setEndTimer(DateFormatUtils.parse(endTimer,
					Constants.DATETIME_FORMAT));
		}
		return parm;
	}

	/**
	 * 获取页面的AgentBean
	 * 
	 * @return
	 * @throws ParseException
	 */
	private Agent getAgentBean() throws ParseException {
		Agent parm = new Agent();
		String name = this.getRequest().getParameter("serviceName");
		String startTimer = this.getRequest().getParameter("startReceivertime");
		String endTimer = this.getRequest().getParameter("endReceivertime");

		parm.setServiceName(name);
		if (startTimer != null && startTimer.trim().length() != 0) {
			parm.setStartTimer(startTimer);
		}
		if (endTimer != null && endTimer.trim().length() != 0) {
			parm.setEndTimer(endTimer);
		}
		return parm;
	}

	
	public String agent(){
		return "agent";
	}
}
