package com.harmony.themis.zhdd.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.harmony.themis.commons.exception.BaseServiceException;
import com.harmony.themis.onDuty.persistence.domain.SmsLogView;
import com.harmony.themis.persistence.domain.DispatchLog;
import com.harmony.themis.persistence.domain.SmsSent4EMAS;
import com.harmony.themis.persistence.domain.SystemConfig;

public interface IDispatchLogService {

	public List<DispatchLog> findListByParamByPage(DispatchLog param,
			int startIndex, int maxResultCount, String sort, String dir);
	public DispatchLog getDispatchLogById(String id);
	public long findCountByParam(DispatchLog param);
	public void saveDispatchLog(DispatchLog dispatchLog);
	public void deleteDispatchLog(DispatchLog dispatchLog);
	public List getDispatchLogListByTime(Date satrtTime,Date endTime, String handelType);
	public void update(DispatchLog dispatchLog);
	public DispatchLog getDispatchLogBySmsId(String string);
	public List<DispatchLog> findDispatchLogByState(String state);
	public void setSystemConfig(SystemConfig systemConfig);
	/*
	 * 显示转换
	 */
	public List<SmsLogView> setSmsView(List<SmsLogView> smsList,List<DispatchLog> sampleList,Map<String, SmsSent4EMAS> map)throws BaseServiceException;
}
