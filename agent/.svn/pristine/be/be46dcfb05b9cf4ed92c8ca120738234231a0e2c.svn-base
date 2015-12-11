package com.harmony.themis.software.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

import com.harmony.themis.commons.dao.impl.BaseDaoImpl;
import com.harmony.themis.persistence.domain.Agent;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.software.dao.MonitorHistoryDao;

public class MonitoryHistoryDaoImp extends BaseDaoImpl implements MonitorHistoryDao {
	private Class<?> beanClass = AgentHistory.class;
	@Override
	public Class<?> getBeanClass() {
		
		return this.beanClass;
	}

	@Override
	public void setBeanClass(Class<?> beanClass) {
		this.beanClass=beanClass;
		
	}

	@Override
	public List<AgentHistory> findListByQuery(String sql, int startIndex,
			int maxResultCount, boolean cacheable) {
		List<AgentHistory> _list=new ArrayList<AgentHistory>();
		Session session=null;
		try
		{
			SessionFactory sessionFactory=this.getHibernateTemplate().getSessionFactory();
			session=sessionFactory.openSession();
			SQLQuery query= session.createSQLQuery(sql);
			query.addEntity(Agent.class);
			if (maxResultCount > 0)
				query.setMaxResults(maxResultCount);
			if (startIndex > 0)
				query.setFirstResult(startIndex);
			_list=query.list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
		
			session.flush();
			session.close();
		}
		return _list;
	}

	@Override
	public long findListCountByQuery(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		//query.addEntity(Agent.class);
		return Long.valueOf(query.uniqueResult()+"").longValue() ;
	}

	@Override
	public List<AgentHistory> findListByQueryParam(AgentHistory param,
			int startIndex, int maxResultCount) {
		// TODO Auto-generated method stub
		List<AgentHistory> _list=new ArrayList<AgentHistory>();
		SessionFactory sf=this.getHibernateTemplate().getSessionFactory();
		Session session=sf.openSession();
		Criteria criteria = session.createCriteria(AgentHistory.class);
		if(startIndex>0){
		criteria.setFirstResult((startIndex-1)*maxResultCount);
		criteria.setMaxResults(maxResultCount);}
		criteria.add(Expression.like("serviceName", "%"+param.getServiceName()+"%"));
		criteria.add(Expression.like("serverName", "%"+param.getServerName()+"%"));
		criteria.add(Expression.ge("sendTime", param.getStartTimer()));
		criteria.add(Expression.le("sendTime", param.getEndTimer()));
		_list=criteria.list();
		return _list;
	}

	@Override
	public int findCountByparam(AgentHistory history) {
		// TODO Auto-generated method stub
		SessionFactory sf=this.getHibernateTemplate().getSessionFactory();
		Session session=sf.openSession();
		Criteria criteria = session.createCriteria(AgentHistory.class);
		criteria.add(Expression.like("serviceName", "%"+history.getServiceName()+"%"));
		criteria.add(Expression.like("serverName", "%"+history.getServerName()+"%"));
		return criteria.list().size();
	}
  
}
