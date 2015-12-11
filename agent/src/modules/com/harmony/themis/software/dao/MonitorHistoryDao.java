package com.harmony.themis.software.dao;

import java.util.List;

import com.harmony.themis.commons.dao.IBaseDao;
import com.harmony.themis.persistence.domain.AgentHistory;

public interface MonitorHistoryDao extends IBaseDao{
	 public List<AgentHistory> findListByQuery(final String sql, final int startIndex, final int maxResultCount,final boolean cacheable);
	 public long findListCountByQuery(String sql);
	 public List<AgentHistory> findListByQueryParam(AgentHistory param, final int startIndex, final int maxResultCount);
	public int findCountByparam(AgentHistory history);
}
