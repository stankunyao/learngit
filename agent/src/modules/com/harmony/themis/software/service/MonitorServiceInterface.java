 package com.harmony.themis.software.service;

import java.util.List;

import com.harmony.themis.commons.exception.BaseServiceException;
import com.harmony.themis.persistence.domain.Agent;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.software.domain.AgentView;

public interface MonitorServiceInterface {
	
	/**
	 * 删除对应关系
	 * @param oid
	 *            String 例子Bean主键 
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public void deleteIntervalTimer(List<Agent> list) throws BaseServiceException;
	/**
	 * 查询记录
	 * @param param 
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public List<Agent> findIntervalTimer(Agent param) throws BaseServiceException;
	/**
	 * 查询记录
	 * @param param 
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public Agent findPreAgent(Agent param) throws BaseServiceException;
	
	/**
	 * 删除对应关系
	 * @param oid
	 *            String 例子Bean主键 
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public void delete(String oid) throws BaseServiceException;
	/**
	 * 新增对应关系
	 * @param Agent
	 *            Agent 例子Bean
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public String save(Agent agent) throws BaseServiceException;
	/**
	 * 更新已有记录
	 * @param Agent
	 *            Agent 例子Bean
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public void update(Agent agent) throws BaseServiceException;
	public String transferMonistor(Agent agent);
	/**
	 * 根据主键获取对象
	 * @param oid
	 * @param Agent
	 *            Agent 例子Bean
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public Agent getById(String oid) throws BaseServiceException;
	/**
	 * 根据传入的参数条件查询结果集合
	 * @param Agent
	 *            param 例子Bean对象参数
	 * @param startIndex int 开始索引
	 * @param maxResultCount int 结束索引
	 * @param sort 排序字段
	 * @param dir 顺序  
	 * @return 检索结果集合
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public List<Agent> findMonitorServiceListBySqlByPage(Agent agent, int startIndex,
			int maxResultCount, String sort, String dir,boolean cacheable,String table) throws BaseServiceException;
	
	/***
	 * 只适合搜寻最新监控记录数
	 * @param agent
	 * @return 记录数
	 * @throws BaseServiceException
	 */
	public long findMonitorServiceCountBySql(Agent agent,String table)throws BaseServiceException;
	
	/**
	 * 根据查询条件返回结果数
	 * 
	 * @param Agent
	 *            param 例子Bean对象参数    
	 * @return 结果数
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public long findCountByParam(Agent agent)
			throws BaseServiceException;
	public List<Agent> findLisByParam(Agent param ,
			int startIndex, int maxResultCount, String sort, String dir) throws BaseServiceException;
	public String setQueryParm(Agent parm,String sql);
	/*
	 * 显示转换
	 */
	public List<AgentView> setAgentView(List<AgentView> infoList,List<Agent> sampleList)throws BaseServiceException;
	public AgentHistory setHistory(Agent agnet);
	public List<String> sendMessage(String contents);
	public List<Agent> findAllAgent();
}
