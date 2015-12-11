/**
 * 电信短信发送数据对象
 */
package com.harmony.themis.message.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.harmony.themis.commons.dao.impl.BaseDaoImpl;
import com.harmony.themis.message.persistence.dao.IMsgSendTask4EMASDao;
import com.harmony.themis.persistence.domain.SmsOutbox4EMAS;
import com.harmony.themis.persistence.domain.SmsSent4EMAS;

/**
 * @author DaoKun
 *
 */
public class MsgSendTask4EMASDaoImpl extends BaseDaoImpl implements IMsgSendTask4EMASDao {

	private Class<?> beanClass = SmsOutbox4EMAS.class;
	/* (non-Javadoc)
	 * @see com.harmony.themis.commons.dao.impl.BaseDaoImpl#getBeanClass()
	 */
	@Override
	public Class<?> getBeanClass() {
		return beanClass;
	}

	/* (non-Javadoc)
	 * @see com.harmony.themis.commons.dao.impl.BaseDaoImpl#setBeanClass(java.lang.Class)
	 */
	@Override
	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	@Override
	public List<SmsSent4EMAS> findListSmsByHql(String queryString,String []ids) {
		List _list = new ArrayList();
		Session session = null;
		try {
			SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
			session = sessionFactory.openSession() ;			
			Query query = session.createQuery(queryString);
			query.setParameterList("sismsid", ids);
			_list = query.list();

		} catch (Exception e) {
			e.printStackTrace() ;
		} finally {
			session.flush();
			session.close();
		}
		return _list ;
	}

}
