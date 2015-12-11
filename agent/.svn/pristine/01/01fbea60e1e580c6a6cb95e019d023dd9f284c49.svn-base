package com.harmony.themis.software.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.harmony.themis.commons.exception.BaseServiceException;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.persistence.domain.SystemConfig;
import com.harmony.themis.software.domain.AgentHistoryView;

public interface MonitoryHistoryServiceInterface {
	public String save(AgentHistory history) throws BaseServiceException;
	/**
	 * 根据查询条件返回结果数
	 * 
	 * @param Agent
	 *            param 例子Bean对象参数    
	 * @return 结果数
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public long findCountByParam(AgentHistory history)throws BaseServiceException;

	/**
	 * 根据传入的参数条件查询结果集合
	 * @param AgentHistory
	 *            param 例子Bean对象参数
	 * @param startIndex int 开始索引
	 * @param maxResultCount int 结束索引
	 * @param sort 排序字段
	 * @param dir 顺序  
	 * @return 检索结果集合
	 * @throws BaseServiceException
	 *             Service服务层异常
	 */
	public List<AgentHistory> findListByParamByPage(AgentHistory history, int startIndex,
			int maxResultCount, String sort, String dir) throws BaseServiceException;
	public SystemConfig getSystemConfig();

	public void setSystemConfig(SystemConfig systemConfig);
	/*
	 * 显示转换
	 */
	public List<AgentHistoryView> setAgentHistoryView(List<AgentHistoryView> infoList,List<AgentHistory> sampleList)throws BaseServiceException;
	public List<AgentHistory> findListByDetachedCriteria(DetachedCriteria d,int start, int end);
	public List<AgentHistory> returnMailIng();
	public void update(AgentHistory agentHistory);
}
