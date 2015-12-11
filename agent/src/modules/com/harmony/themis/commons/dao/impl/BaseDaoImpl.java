/**
 * 软件著作权：北京东方正通科技有限公司
 *
 * 系统名称：值守应急系统产品（themis）
 *
 * 文件名称：BaseDaoImpl.java
 *
 * 工程名：  themis_V1.0
 *		 
 * 版本历史：2008-10-21
 * 
 * 
 */
package com.harmony.themis.commons.dao.impl;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.harmony.framework.dao.DAOException;
import com.harmony.framework.dao.impl.DefaultPage;
import com.harmony.framework.dao.support.Page;
import com.harmony.framework.dao.support.QueryObjectHelper;
import com.harmony.framework.query.QueryObject;
import com.harmony.framework.query.utils.QueryUtil;
import com.harmony.themis.commons.dao.IBaseDao;
import com.harmony.themis.commons.exception.BaseDaoException; 

/**
 * Dao实现基类
 * @author 李来普
 *
 */
public abstract class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {
	/**
	 * 定义LOG日志
	 */
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * 根据主键获取实体对象
	 * @param oid 主键
	 * @return Bean实体对象
	 */
	public Object getById(String oid) {
		return this.getHibernateTemplate().get(this.getBeanClass(), oid);
	}

	/**
	 * 新增记录
	 * @param o Bean实体对象
	 * @return 主键
	 */
	public String save(Object o) {
		return (String)this.getHibernateTemplate().save(o);

	}
	
	/**
	 * 更新已有记录
	 * @param o Bean实体对象
	 */
	public void update(Object o) {
		this.getHibernateTemplate().update(o);		

	}
	
	/**
	 * 增加或更新记录
	 * @param o Bean实体对象
	 */
	public void saveOrUpdate(Object o) {
		this.getHibernateTemplate().saveOrUpdate(o);	

	}
	
	/**
	 * 根据实体对象删除已有的记录
	 * @param o Bean实体对象
	 */
	public void delete(Object o) {
		this.getHibernateTemplate().delete(o);
	}
	
	/**
	 * 删除集合所有对象
	 * @param collection 删除的集合
	 * @throws BaseDaoException  DAO访问异常
	 */	
	@SuppressWarnings("unchecked")
	public void deleteAll(Collection collection) {
		this.getHibernateTemplate().deleteAll(collection);	
	}

	/**
	 * 根据主键删除已有的记录
	 * @param oid 主键
	 */
	public void delete(String oid) {
		if (oid != null) {
			Object o = this.getById(oid);
			if (o != null) {
				this.delete(o);
			}
		}
	}	
	
	/**
	 * 根据查询条件返回结果数
	 * 
	 * @param queryObject
	 *            QueryObject
	 * @param aliases
	 *            Map<String, String>
	 * @return 结果数
	 */
	@SuppressWarnings({ "unchecked"})
	public long findCountByQueryObject(final QueryObject queryObject,
			final Map<String, String> aliases) {
			if(queryObject.getProjections() == null) {
				com.harmony.framework.query.Projections projections = new com.harmony.framework.query.Projections();
				queryObject.setProjections(projections);
			}
			
		    queryObject.getProjections().setRowCount(true);
		    queryObject.getProjections().setDistinctFlag(true);
			queryObject.setEntityClass(this.getBeanClass());
			
			//以下用于将orderByProperties属性设置为null add by 黎小明
			try{
				com.harmony.framework.query.Projections proj = queryObject.getProjections() ;
				
				Class cls = com.harmony.framework.query.Projections.class ;
				Method md = cls.getMethod("setOrderProperty",  new  Class[]{String.class}) ;
				md.invoke(proj, new Object[]{null}) ;
				
			}catch (Exception e) {
				e.printStackTrace() ;
			}
	
			if (!QueryUtil.validQueryObject(queryObject))
				return 0;
			Object reseult = (Object) getHibernateTemplate()
					.execute(new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {
							Criteria criteria = session
									.createCriteria(queryObject
											.getEntityClass());
							ClassMetadata classMetadata = getSessionFactory()
									.getClassMetadata(
											queryObject.getEntityClass());

							QueryObjectHelper.processCriteria(criteria,
									queryObject, true, aliases, classMetadata);
							
							//return criteria.list();
							return criteria.uniqueResult();
						}
					});
			
			//return reseult == null ? 0 : reseult.size();	
			return reseult == null ? 0 : Long.parseLong(reseult.toString());	
			

	}
	
	/**
	 * 根据条件查询结果集合
	 * 
	 * @param queryObject
	 *            QueryObject 查询实体对象接口定义
	 * @param cacheable
	 *            boolean 是否使用缓存
	 * @param startIndex
	 *            int 开始索引
	 * @param maxResultCount
	 *            int 最大记录数
	 * @param aliases
	 *            Map<String, String> 别名Map
	 * @return   实体对象集合
	 */
	@SuppressWarnings("unchecked")
	public List findListByQueryObject(final QueryObject queryObject,
			final boolean cacheable, final int startIndex, final int maxResultCount,
			final Map<String, String> aliases) {
			queryObject.setEntityClass(this.getBeanClass());
			if (!QueryUtil.validQueryObject(queryObject))
				return null;
			return (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {
							Criteria criteria = session
									.createCriteria(queryObject
											.getEntityClass());
							ClassMetadata classMetadata = getSessionFactory()
									.getClassMetadata(
											queryObject.getEntityClass());

							QueryObjectHelper.processCriteria(criteria,
									queryObject, cacheable, aliases,
									classMetadata);

							if (maxResultCount > 0)
								criteria.setMaxResults(maxResultCount);
							if (startIndex > 0)
								criteria.setFirstResult(startIndex);
							return criteria.list();
						}
					});	
	}

	/**
	 * 根据HQL查询条件返回结果集合
	 * @param queryString HQL查询语句
	 * @return 结果集合
	 * @throws BaseDaoException  DAO访问异常
	 */
//	@SuppressWarnings("unchecked")
//	public List findListByHQL(String queryString) {
//		return this.getHibernateTemplate().find(queryString);
//
//	}
	
	/**
	 * 根据HQL查询条件及参数返回结果集合
	 * @param queryString HQL查询语句
	 * @param value 参数数组
	 * @return 结果集合
	 * @throws BaseDaoException  DAO访问异常
	 */
	@SuppressWarnings("unchecked")
	public List findListByHQL(String queryString, Object[] values) {
		return this.getHibernateTemplate().find(queryString,values);
	}
	
	/**
	 * 使用Criteria查询得到所有集合
	 * @param detachedCriteria 
	 * @return 指定的业务对象集合
	 */
	@SuppressWarnings("unchecked")
	public List getListByCriteria(DetachedCriteria detachedCriteria){
		
		return this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
	
	/**
	 *  使用Criteria查询得到分页总数
	 * @param detachedCriteria
	 * @return 指定的业务对象集合数
	 */
	public int findCountByCriteria(final DetachedCriteria detachedCriteria)
	{
		return (Integer)this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException{
				Criteria executableCriteria = detachedCriteria.getExecutableCriteria(session);
				int totalCount = ((Integer) executableCriteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				return totalCount;
			}
			
		});
	}
	
	/**
	 * 使用Criteria查询得到分页集合数据
	 * @param detachedCriteria
	 * @param startIndex 开始索引
	 * @param maxResultCount 最大记录
	 * @return  指定的业务对象集合
	 */
	public List findPageByCriteria(final DetachedCriteria detachedCriteria,final int startIndex, final int maxResultCount)
	{
		return (List)this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException{
				Criteria executableCriteria = detachedCriteria.getExecutableCriteria(session);
				if(startIndex > -1 && maxResultCount > -1) {
					executableCriteria.setFirstResult(startIndex);
					executableCriteria.setMaxResults(maxResultCount);
				}
				return executableCriteria.list();
			}
			
		});
	}
	

	/**
	 * <ol>
	 * <li> 返回指定的一页记录数。用于翻页查询。返回对象列表
	 * </ol>
	 * 
	 * @param queryString
	 *            final String -查询条件
	 * @param startIndex
	 *            final int -返回记录起始点
	 * @param rows
	 *            final int -返回记录数
	 * @return -结果集
	 */
	protected List findPageListByHQL(final String queryString, final int startIndex, final int rows, final Object[] params) throws DAOException {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException {
					Query q = session.createQuery(queryString);
					
					// 设置参数
					if (params != null){
						 for (int i = 0; i < params.length; i++) {
					            q.setParameter(i, params[i]);
					        }
					}
					
					if (startIndex > -1) {
						q.setFirstResult(startIndex);
					}
					if (rows > -1) {
						q.setMaxResults(rows);
					}
					List list = q.list();
					if (list == null) {
						list = Collections.EMPTY_LIST;
					}
					return list;
				}
			});
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DAOException(e);
		}
	}

	
	/**
	 * <ol>
	 * <li> 返回符合条件的记录总数
	 * </ol>
	 * 
	 * @param queryString
	 *            String -查询条件
	 * @return int -记录总数
	 */
	public int getListCount(final String queryString, final Object[] params) throws DAOException {
		int count = 0;
		try {
			// 拼装hql
			String countQueryStr = "select count(*) ";
			String fromStr = null;
			String newSql = null;
			String sql = queryString.toUpperCase();
			int begin = sql.indexOf("FROM");
			int end = sql.lastIndexOf("ORDER BY");
			if (end > 0)
				fromStr = queryString.substring(begin, end);
			else
				fromStr = queryString.substring(begin);
			newSql = countQueryStr + fromStr;
            
			//　执行查询
			List list = findPageListByHQL(newSql, -1, -1, params);
			if (list != null) {
				count = ((Long) list.get(0)).intValue();
			}
		} catch (Exception ex) {
			logger.error("getListCount 发生错误 ！ ", ex);
			throw new DAOException(ex);
		}
		return count;
	}

	
	/**
	 * 根据HSQL进行分页查询
	 * 
	 * @param hql　查询语句
	 * @param startIndex    记录起始索引
	 * @param pageSize	每页数
	 * @param isScroll  查询方式
	 * @param params    参数
	 * @return 指定页数和行数的数据
	 */
	public Page findPageByHQL(final String hql, final int startIndex,	final int pageSize, final Object[] params) {
		if (hql == null) {
			return null;
		}
        // 总记录数
		int count = this.getListCount(hql, params);
		List list = null;
		if (count > 0) {
			list = findPageListByHQL(hql, startIndex, pageSize, params);
		} else {
			list = Collections.EMPTY_LIST;
		}

		return new DefaultPage(startIndex/pageSize+1, pageSize, list, count);

	}
	@SuppressWarnings("unchecked")
	public List findListBySql(String queryString) {
		List _list = new ArrayList();
		Session session = null;
		try {
			SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
			session = sessionFactory.openSession() ;
			
			Query query = session.createSQLQuery(queryString);
			_list = query.list();

		} catch (Exception e) {
			e.printStackTrace() ;
		} finally {
			session.flush();
			session.close();
		}
		return _list ;
	}

	/** 
	 * @return 实体类Class
	 */
	public abstract Class<?> getBeanClass();


	/** 
	 * @param 实体类Class 设置实体类Class
	 */
	public abstract void setBeanClass(Class<?> beanClass);

}
