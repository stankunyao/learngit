package com.harmony.themis.software.service.imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.harmony.framework.query.Projections;
import com.harmony.framework.query.QueryObject;
import com.harmony.framework.query.QueryObjectBase;
import com.harmony.framework.query.QueryParam;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.exception.BaseDaoException;
import com.harmony.themis.commons.exception.BaseServiceException;
import com.harmony.themis.commons.util.DateFormatUtils;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.persistence.domain.SystemConfig;
import com.harmony.themis.software.dao.MonitorHistoryDao;
import com.harmony.themis.software.domain.AgentHistoryView;
import com.harmony.themis.software.service.MonitoryHistoryServiceInterface;

public class MonitoryHistoryServiceImp implements
		MonitoryHistoryServiceInterface {
	private MonitorHistoryDao dao;
	private SystemConfig systemConfig;

	@Override
	public String save(AgentHistory history) throws BaseServiceException {
		return dao.save(history);
	}

	@Override
	public long findCountByParam(AgentHistory history)
			throws BaseServiceException {
		// 总记录数
		long totalSize = 0;
		try {
			totalSize=dao.findCountByparam(history);
		} catch (BaseDaoException de) {
			throw new BaseServiceException(MessageConstants.DAO_FIND_EXCEPTION
					+ de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
		return totalSize;
	}

	/**
	 * 返回统计记录数的QueryObject对象
	 * 
	 * @param param
	 *            参数对象
	 * @return
	 */
	private QueryObject getCountQueryObject(AgentHistory param) {
		return this.getQueryObject(param, null, null);
	}

	/**
	 * 返回QueryObject对象
	 * 
	 * @param param
	 *            参数对象
	 * @param sort
	 *            排序字段
	 * @param dir
	 *            顺序
	 * @return
	 */
	private QueryObject getQueryObject(AgentHistory param, String sort,
			String dir) {
		QueryObject queryObject = new QueryObjectBase();
		QueryParam qp = new QueryParam();
		Projections projections = new Projections();
		// 接收开始时间
		if (param.getStartTimer() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(this.getFullTime(param.getStartTimer()));
			cal.add(Calendar.DATE, -1);
			qp.andParameter(new QueryParam("sendTime",
					QueryParam.OPERATOR_GE, cal.getTime()));
		}
		// 接收结束时间
		if (param.getEndTimer() != null) {
			qp.andParameter(new QueryParam("sendTime",
					QueryParam.OPERATOR_LE,
					this.getEndTime(param.getEndTimer())));
		}
		// 机器名称
		if (StringUtils.isNotEmpty(param.getServerName())) {
			qp.andParameter(new QueryParam("serviceName",
					QueryParam.OPERATOR_LIKE, "%" + param.getServerName()
							+ "%"));
		}
		//排序
		if(sort != null && !"".equals(sort) 
				&& dir != null && !"".equals(dir)){
		}
		queryObject.setQueryParam(qp);
		queryObject.setProjections(projections);
		return queryObject;
	}

	@Override
	public List<AgentHistory> findListByParamByPage(AgentHistory param,
			int startIndex, int maxResultCount, String sort, String dir)
			throws BaseServiceException {
		List<AgentHistory> sampleList = new ArrayList<AgentHistory>();
		Map<String, String> aliasmap = new HashMap<String, String>();
		try {
			QueryObject queryObject = this.getQueryObject(param, sort, dir);
			sampleList = dao.findListByQueryObject(queryObject, true,
					startIndex, maxResultCount, aliasmap);
		} catch (BaseDaoException de) {
			throw new BaseServiceException(MessageConstants.DAO_FIND_EXCEPTION
					+ de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
		return sampleList;
	}

	public MonitorHistoryDao getDao() {
		return dao;
	}

	public void setDao(MonitorHistoryDao dao) {
		this.dao = dao;
	}

	@Override
	public List<AgentHistoryView> setAgentHistoryView(
			List<AgentHistoryView> infoList, List<AgentHistory> sampleList)
			throws BaseServiceException {
		if (!sampleList.isEmpty()) {
			for (int i = 0; i < sampleList.size(); i++) {
				AgentHistory history = sampleList.get(i);
				AgentHistoryView view = new AgentHistoryView();
				if (history != null) {
					view = setModeBean(view, history);
					infoList.add(view);
				}
			}
		}
		return infoList;
	}

	public AgentHistoryView setModeBean(AgentHistoryView view,
			AgentHistory history) {
		view.setHistoryId(history.getId());
		view.setServerName(history.getServerName());
		view.setServerIp(history.getServerIp());
		view.setServiceName(history.getServiceName());
		view.setReceiveUser(history.getReceiveUser());
		view.setSendContent(history.getSendContent());
		view.setSendStatus(history.getSendStatus());
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		view.setSendTime(formatter.format(history.getSendTime()));
		view.setSendType(history.getSendType());
		String status = history.getErrorType();
		String sendStatus=history.getSendStatus();
		if(status.equals("-1")){
			view.setErrorTypeStr("宕机");
			view.setErrorType("-1");
		}else if (status.equals("0")) {
			view.setErrorTypeStr("异常");
			view.setErrorType("0");
		} else {
			view.setErrorTypeStr("正常");
			view.setErrorType("1");
		}
		if(sendStatus.equals("0")){
			view.setSendStatus("发送中");
		}else if (sendStatus.equals("1")) {
			view.setSendStatus("发送成功");
		} else {
			view.setSendStatus("发送失败");
		}
		return view;
	}

	private Date getStartTime(Date shortTime) {
		String dayStr = DateFormatUtils.dateToStr(shortTime);
		String fullStr = dayStr + " " + "23:59";
		Date fullDate = DateFormatUtils.strToDate3(fullStr);
		return fullDate;
	}

	private Date getEndTime(Date shortTime) {
		String dayStr = DateFormatUtils.dateToStr(shortTime);
		String fullStr = dayStr + " " + "23:59";
		Date fullDate = DateFormatUtils.strToDate3(fullStr);
		return fullDate;
	}

	private Date getFullTime(Date shortTime) {
		String dayStr = DateFormatUtils.dateToStr(shortTime);
		String fullStr = dayStr + " " +"00:00";
		Date fullDate = DateFormatUtils.strToDate3(fullStr);
		return fullDate;
	}
	
	public SystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	@Override
	public List<AgentHistory> findListByDetachedCriteria(DetachedCriteria d,int start, int end) {
		// TODO Auto-generated method stub
		return dao.findPageByCriteria(d, start, end);
	}

	@Override
	public List<AgentHistory> returnMailIng() {
		// TODO Auto-generated method stub
		String hql="from AgentHistory where sendStatus!='1'";
		return dao.findListByHQL(hql, null);
	}

	@Override
	public void update(AgentHistory agentHistory) {
		// TODO Auto-generated method stub
		 dao.update(agentHistory);
	}

}
