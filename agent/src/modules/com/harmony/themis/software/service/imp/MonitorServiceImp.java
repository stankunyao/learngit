package com.harmony.themis.software.service.imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.harmony.framework.dao.impl.HibernateUtilDAOImpl;
import com.harmony.framework.query.Projections;
import com.harmony.framework.query.QueryObject;
import com.harmony.framework.query.QueryObjectBase;
import com.harmony.framework.query.QueryParam;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.exception.BaseDaoException;
import com.harmony.themis.commons.exception.BaseServiceException;
import com.harmony.themis.main.util.PropertiesUtil;
import com.harmony.themis.persistence.domain.Agent;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.software.dao.MonitorServiceDao;
import com.harmony.themis.software.domain.AgentView;
import com.harmony.themis.software.service.MonitorServiceInterface;

public class MonitorServiceImp implements MonitorServiceInterface {
	private MonitorServiceDao dao;
    
	@Override
	public void deleteIntervalTimer(List<Agent> list)
			throws BaseServiceException {
		for(Iterator it = list.iterator();it.hasNext();){
			Agent agent =(Agent) it.next();
			this.update(agent);
		}
	}
	
	@Override
	public Agent findPreAgent(Agent param) throws BaseServiceException {
		Map<String, String> aliases = new HashMap<String, String>();
		QueryObject queryObject=this.getQueryObject(param, null,null);
		List<Agent> sampleList = dao.findListByQueryObject(queryObject, false, 0, 12121212, aliases);
		Agent agent = null;
		if(sampleList.size()!=0){
			agent=sampleList.get(0);
		}
		return agent;		
	}
    
	@Override
	public List<Agent> findIntervalTimer(Agent param) throws BaseServiceException {
	   String sql="select at.id,at.server_name,at.receive_time,at.server_ip,at.service_name,at.status from agent at where DATEDIFF(DAY,at.receive_time,GETDATE())>7";
	   List<Agent> list= dao.findListBySql(sql);		
	   return list;
	}
	@Override
	public void delete(String oid) throws BaseServiceException {
		
		
	}
	@Override
	public String save(Agent agent) throws BaseServiceException {
		return 	dao.save(agent);
	}
	@Override
	public void update(Agent agent) throws BaseServiceException {
		try {
			dao.update(agent);
		} catch (BaseDaoException de) {
			throw new BaseServiceException(
					MessageConstants.DAO_UPDATE_EXCEPTION + de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
		
	}
	@Override
	public Agent getById(String oid) throws BaseServiceException {
		try {
			return (Agent) dao.getById(oid);
		} catch (BaseDaoException de) {
			throw new BaseServiceException(MessageConstants.DAO_LOAD_EXCEPTION
					+ de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
	}
	@Override
	public String transferMonistor(Agent agent) {
		String id= dao.save(agent);
		return id;
	}
	@SuppressWarnings("unchecked")
	public List<Agent> findMonitorServiceListBySqlByPage(Agent param,
			int startIndex, int maxResultCount, String sort, String dir,boolean cacheable,String table)
			throws BaseServiceException {
		List<Agent> sampleList = new ArrayList<Agent>();
		try {
			sampleList=dao.findListByQuery(param, startIndex, maxResultCount, cacheable);  
		} catch (BaseDaoException de) {
			throw new BaseServiceException(MessageConstants.DAO_FIND_EXCEPTION
					+ de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
		return sampleList;
	}

	@Override
	public long findMonitorServiceCountBySql(Agent param,String table) throws BaseServiceException {
		return dao.findListCountByQuery(param);
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
	private QueryObject getQueryObject(Agent param, String sort, String dir) {
		QueryObject queryObject = new QueryObjectBase();
		QueryParam qp = new QueryParam();
		Projections projections = new Projections();
		// 机器ip地址为查询条件
		if (StringUtils.isNotEmpty(param.getServerIp())) {
					qp.andParameter(new QueryParam("serviceip", QueryParam.OPERATOR_EQ,
							param.getServerIp()));
		}
		if (StringUtils.isNotEmpty(param.getServerName())) {
					qp.andParameter(new QueryParam("servicename",
							QueryParam.OPERATOR_EQ, param.getServerName()));
		}
		if (StringUtils.isNotEmpty(param.getServiceName())) {
			qp.andParameter(new QueryParam("name",
					QueryParam.OPERATOR_EQ, param.getServiceName()));
		}
		if (StringUtils.isNotEmpty(param.getStatus())) {
			qp.andParameter(new QueryParam("status",
					QueryParam.OPERATOR_EQ, param.getStatus()));
		}
        queryObject.setQueryParam(qp);
		queryObject.setProjections(projections);
		return queryObject;
	}

	public long findCountByParam(Agent param) throws BaseServiceException {
		// 总记录数
		long totalSize = 0;
		try {
			Map<String, String> aliases = new HashMap<String, String>();
			QueryObject queryObject = this.getCountQueryObject(param);
			totalSize = dao.findCountByQueryObject(queryObject, aliases);
		} catch (BaseDaoException de) {
			throw new BaseServiceException(MessageConstants.DAO_FIND_EXCEPTION
					+ de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
		return totalSize;
	}
	public List<Agent> findLisByParam(Agent param ,
			int startIndex, int maxResultCount, String sort, String dir) throws BaseServiceException {
		// 总记录数
		List<Agent> sampleList = new ArrayList<Agent>();
		long totalSize = 0;
		try {
			Map<String, String> aliases = new HashMap<String, String>();
			QueryObject queryObject = this.getCountQueryObject(param);
			sampleList = dao.findListByQueryObject(queryObject, false, startIndex, maxResultCount, aliases);
		} catch (BaseDaoException de) {
			throw new BaseServiceException(MessageConstants.DAO_FIND_EXCEPTION
					+ de.getMessage(), de);
		} catch (Exception e) {
			throw new BaseServiceException(MessageConstants.OTHER_EXCEPTION
					+ e.getMessage(), e);
		}
		return sampleList;
	}

	/**
	 * 返回统计记录数的QueryObject对象
	 * 
	 * @param param
	 *            参数对象
	 * @return
	 */
	private QueryObject getCountQueryObject(Agent param) {
		return this.getQueryObject(param, null, null);
	}
	
	@Override
	public List<AgentView> setAgentView(List<AgentView> infoList,
			List<Agent> sampleList) throws BaseServiceException {
		if (!sampleList.isEmpty()) {
			for (int i = 0; i < sampleList.size(); i++) {
				Agent agnet = sampleList.get(i);
				AgentView agentview = new AgentView();
				if (agnet != null) {
					agentview = setModeBean(agentview, agnet);
					infoList.add(agentview);
				}
			}
		}
		return infoList;
	}
	/**
	 * 只是用于监服务分页查询
	 */
	@Override
	public String setQueryParm(Agent parm,String sql) {
		return sql;
	}
	public AgentView setModeBean(AgentView agentview, Agent agent) {
		agentview.setId(agent.getId());
		agentview.setServerName(agent.getServerName());
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		agentview.setReceivertime(formatter.format(agent.getReceiveTime()));
		agentview.setServerIp(agent.getServerIp());
		agentview.setServiceName(agent.getServiceName());
		String status =  agent.getStatus();
		if(status.equals("-1")){
			agentview.setStatus("宕机");
		}else if(status.equals("0")){
			agentview.setStatus("不正常");
		}else{
			agentview.setStatus("正常");
		}
		
		return agentview;
	}
	public void setDao(MonitorServiceDao dao) {
		this.dao = dao;
	}
	
	
	public AgentHistory setHistory(Agent agnet) {
		AgentHistory history = new AgentHistory();
		history.setServerName(agnet.getServerName());
		history.setServerIp(agnet.getServerIp());
		history.setServiceName(agnet.getServiceName());
		history.setErrorType(agnet.getStatus());
		return history;
	}

	@Override
	public List<String> sendMessage(String contents) {
		// TODO Auto-generated method stub
		String receiveEmailUserNames=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "reviceEmailUserNames");
		String receivePhoneUserNames=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "receivePhoneUserNames");
		return null;
	}
	public List<Agent> findAllAgent(){
		return dao.findListByHQL("from Agent", null);
	}
}
