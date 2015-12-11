/**
 * 软件著作权：北京东方正通科技有限公司
 *
 * 系统名称：值守应急系统产品（themis）
 *
 * 文件名称：IBaseDao.java
 *
 * 工程名：  themis_V1.0
 *		 
 * 版本历史：2008-10-21
 * 
 * 
 */
package com.harmony.themis.commons.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.harmony.framework.dao.support.Page;
import com.harmony.framework.query.QueryObject;
import com.harmony.themis.commons.exception.BaseDaoException;

/**
 * Dao实现基类
 * @author 李来普
 *
 */
public interface IBaseDao {
	
	/**
	 * 根据主键获取实体对象
	 * @param oid 主键
	 * @return Bean实体对象
	 */
	public Object getById(String oid);


	/**
	 * 新增记录
	 * @param o Bean实体对象
	 * @return 主键
	 */
	public String save(Object o);

	/**
	 * 更新已有记录
	 * @param o Bean实体对象
	 */
	public void update(Object o);
	
	/**
	 * 增加或更新记录
	 * @param o Bean实体对象
	 */
	public void saveOrUpdate(Object o);

	/**
	 * 根据实体对象删除已有的记录
	 * @param o Bean实体对象
	 */
	public void delete(Object o);
	
	/**
	 * 删除集合所有对象
	 * @param collection 删除的集合
	 * @throws BaseDaoException  DAO访问异常
	 */	
	@SuppressWarnings("unchecked")
	public void deleteAll(Collection collection);	
	
	/**
	 * 根据主键删除已有的记录
	 * @param oid 主键
	 */
	public void delete(String oid);
	

	/**
	 * 根据查询条件返回结果数
	 * 
	 * @param queryObject
	 *            QueryObject
	 * @param aliases
	 *            Map<String, String>
	 * @return 结果数
	 */
	public long findCountByQueryObject(final QueryObject queryObject,
			final Map<String, String> aliases);

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
			final Map<String, String> aliases) ;

	/**
	 * 根据HQL查询条件返回结果集合
	 * @param queryString HQL查询语句
	 * @return 结果集合
	 * @throws BaseDaoException  DAO访问异常
	 */
//	@SuppressWarnings("unchecked")
//	public List findListByHQL(String queryString);
	
	/**
	 * 根据HQL查询条件及参数返回结果集合
	 * @param queryString HQL查询语句
	 * @param value 参数数组
	 * @return 结果集合
	 * @throws BaseDaoException  DAO访问异常
	 */
	@SuppressWarnings("unchecked")
	public List findListByHQL(String queryString, Object[] values);
	
	
	/**
	 * 使用Criteria查询得到所有集合
	 * @param detachedCriteria 
	 * @return 指定的业务对象集合
	 */
	public List getListByCriteria(DetachedCriteria detachedCriteria);
	
	/**
	 * 使用Criteria查询得到分页集合数据
	 * @param detachedCriteria
	 * @param startIndex 开始索引
	 * @param maxResultCount 最大记录
	 * @return  指定的业务对象集合
	 */
	public List findPageByCriteria(final DetachedCriteria detachedCriteria,final int startIndex, final int maxResultCount);
	
	public Page findPageByHQL(final String hql, final int pageNo,	final int pageSize, final Object[] params);
	/**
	 * 根据sql查询
	 * @param queryString
	 * @return
	 */
	public List findListBySql(String queryString) ;
	/**
	 *  使用Criteria查询得到分页总数
	 * @param detachedCriteria
	 * @return 指定的业务对象集合数
	 */
	public int findCountByCriteria(DetachedCriteria detachedCriteria);

}
