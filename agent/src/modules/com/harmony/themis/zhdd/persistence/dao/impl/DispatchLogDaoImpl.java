package com.harmony.themis.zhdd.persistence.dao.impl;

import com.harmony.themis.commons.dao.impl.BaseDaoImpl;
import com.harmony.themis.persistence.domain.DispatchLog;
import com.harmony.themis.zhdd.persistence.dao.IDispatchLogDao;
import java.util.List;
public class DispatchLogDaoImpl  extends BaseDaoImpl implements IDispatchLogDao{
	private Class<?> beanClass = DispatchLog.class;


	public Class<?> getBeanClass() {
		return beanClass;
	}


	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}
	@Override
	public DispatchLog getBySmsId(String string) {
		String hql = "from DispatchLog t where t.smsid = '"+string+"'";
		List<DispatchLog> dispatchLogs = this.findListByHQL(hql, null);
		if(null != dispatchLogs && dispatchLogs.size()>0){
			return dispatchLogs.get(0);
		}
		return null;
	}
}
