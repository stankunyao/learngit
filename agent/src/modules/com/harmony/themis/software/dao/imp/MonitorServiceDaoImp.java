package com.harmony.themis.software.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.harmony.themis.commons.dao.impl.BaseDaoImpl;
import com.harmony.themis.persistence.domain.Agent;
import com.harmony.themis.software.dao.MonitorServiceDao;

public class MonitorServiceDaoImp  extends BaseDaoImpl implements MonitorServiceDao {
	private Class<?> beanClass = Agent.class;
    
	
	@Override
	public List<Agent> findListByQuery(Agent param,final int startIndex, final int maxResultCount,boolean cacheable) {
		List<Agent> _list=new ArrayList<Agent>();
		Session session=null;
		try
		{
			SessionFactory sessionFactory=this.getHibernateTemplate().getSessionFactory();
			session=sessionFactory.openSession();
			String hql="from Agent";  
			Query query = session.createQuery(hql);  
			query.setMaxResults(maxResultCount);
			query.setFirstResult((startIndex-1)*maxResultCount);
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
	public long findListCountByQuery(Agent param) {
		List<Agent> _list=new ArrayList<Agent>();
		SessionFactory sessionFactory=this.getHibernateTemplate().getSessionFactory();
		Session session=sessionFactory.openSession();
		String hql="from Agent as a where a.serviceName like :serviceName";  
		Query query = session.createQuery(hql);  
		query.setString("serviceName", "%"+param.getServiceName()+"%");  
		_list=query.list();
		return _list.size();
	}

	@Override
	public List<Agent> findListByQuerySql(String queryString) {
		List<Agent> _list=new ArrayList<Agent>();
//		Session session=null;
//		try
//		{
//			SessionFactory sessionFactory=this.getHibernateTemplate().getSessionFactory();
//			session=sessionFactory.openSession();
//			SQLQuery query= session.createSQLQuery(queryString);
//			query.addEntity(Agent.class);
//			_list=query.list();
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}finally
//		{
//		
//			session.flush();
//			session.close();
//		}
		_list = this.findListBySql(queryString);
		return _list;
	}

	/**
	 * @return the beanClass
	 */
	public Class<?> getBeanClass() {
		return beanClass;
	}

	/**
	 * @param beanClass the beanClass to set
	 */
	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}
	
}
