package com.harmony.themis.software.dao;

import java.util.List;

import com.harmony.themis.commons.dao.IBaseDao;
import com.harmony.themis.persistence.domain.Agent;


public interface MonitorServiceDao extends IBaseDao {
	 public List<Agent> findListByQuery(Agent param, final int startIndex, final int maxResultCount,final boolean cacheable);
	 public long findListCountByQuery(Agent param);
     public List<Agent> findListByQuerySql(String queryString) ;
}
