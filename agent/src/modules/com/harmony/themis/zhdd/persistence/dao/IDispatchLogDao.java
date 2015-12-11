package com.harmony.themis.zhdd.persistence.dao;

import com.harmony.themis.commons.dao.IBaseDao;
import com.harmony.themis.persistence.domain.DispatchLog;
/**
 * IDispatchLogDao的Dao接口
 * @author meinan
 *
 */
public interface IDispatchLogDao extends IBaseDao {
	DispatchLog getBySmsId(String string);
}
