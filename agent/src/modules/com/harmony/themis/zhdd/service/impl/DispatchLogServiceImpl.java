package com.harmony.themis.zhdd.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.harmony.framework.query.Projections;
import com.harmony.framework.query.QueryObject;
import com.harmony.framework.query.QueryObjectBase;
import com.harmony.framework.query.QueryParam;
import com.harmony.themis.commons.Constants;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.exception.BaseServiceException;
import com.harmony.themis.commons.util.DateFormatUtils;
import com.harmony.themis.onDuty.persistence.domain.SmsLogView;
import com.harmony.themis.persistence.domain.DispatchLog;
import com.harmony.themis.persistence.domain.SmsSent4EMAS;
import com.harmony.themis.persistence.domain.SystemConfig;
import com.harmony.themis.zhdd.persistence.dao.IDispatchLogDao;
import com.harmony.themis.zhdd.service.IDispatchLogService;

public class DispatchLogServiceImpl implements
		IDispatchLogService {
	private IDispatchLogDao dispatchLogDao;
	private SystemConfig systemConfig;

	public IDispatchLogDao getDispatchLogDao() {
		return dispatchLogDao;
	}

	public void setDispatchLogDao(IDispatchLogDao dispatchLogDao) {
		this.dispatchLogDao = dispatchLogDao;
	}

	/**
	 * 返回统计记录数的QueryObject对象
	 * 
	 * @param param
	 *            参数对象
	 * @return
	 */
	private QueryObject getCountQueryObject(DispatchLog param, Date startTime,
			Date endTime) {
		return this.getQueryObject(param, null, null);
	}

	/**
	 * 根据查询条件返回结果数
	 * 
	 * @param ExtendConfig
	 *            param 组织Bean对象参数
	 * @return 结果数
	 */

	public long findCountByParam(DispatchLog param, Date startTime, Date endTime) {
		// 总记录数
		long totalSize = 0;
		Map<String, String> aliases = new HashMap<String, String>();
		QueryObject queryObject = this.getCountQueryObject(param, startTime,
				endTime);
		totalSize = dispatchLogDao.findCountByQueryObject(queryObject, aliases);
		return totalSize;
	}

	/**
	 * 返回统计记录数的QueryObject对象
	 * 
	 * @param param
	 *            参数对象
	 * @return
	 */
	private QueryObject getCountQueryObject(DispatchLog param) {
		return this.getQueryObject(param, null, null);
	}

	/**
	 * 根据查询条件返回结果数
	 * 
	 * @param ExtendConfig
	 *            param 组织Bean对象参数
	 * @return 结果数
	 */

	public long findCountByParam(DispatchLog param) {
		// 总记录数
		long totalSize = 0;
		Map<String, String> aliases = new HashMap<String, String>();
		QueryObject queryObject = this.getCountQueryObject(param);
		totalSize = dispatchLogDao.findCountByQueryObject(queryObject, aliases);
		return totalSize;
	}

	/**
	 * 返回QueryObject对象
	 * 
	 * @param param
	 *            参数对象
	 * @param sort
	 *            排序字段
	 * @param dir
	 *            顺序
	 * @return
	 */
	private QueryObject getQueryObject(DispatchLog param, String sort,
			String dir) {
		QueryObject queryObject = new QueryObjectBase();
		QueryParam qp = new QueryParam();
		Projections projections = new Projections();

		if (StringUtils.isNotEmpty(param.getReceivePerson())) {
			qp.andParameter(new QueryParam("receivePerson",
					QueryParam.OPERATOR_LIKE,  "%"+param.getReceivePerson()+ "%"));
		}
        if(StringUtils.isNotEmpty(param.getMessageContent())){
        	qp.andParameter(new QueryParam("messageContent",
					QueryParam.OPERATOR_LIKE,  "%"+param.getMessageContent()+ "%"));
        }
		if (param.getStartTime() != null) {
			qp.andParameter(new QueryParam("sendTime", QueryParam.OPERATOR_GE,param.getStartTime()));
		}
        if(StringUtils.isNotEmpty(param.getPerId())){
        	qp.andParameter(new QueryParam("perId", QueryParam.OPERATOR_EQ,param.getPerId()));
        }
		if (param.getEndTime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(this.getFullTime(param.getEndTime()));
			cal.add(Calendar.DATE, 1);
			qp.andParameter(new QueryParam("sendTime",
					QueryParam.OPERATOR_LE, this.getFullTime(cal.getTime())));
		}

		queryObject.setQueryParam(qp);
		// 处理排序
		if (sort == null || dir == null) {
			projections.setOrderProperty("sendTime");// 默认发生时间排序
			projections.setDescFlag(false);
		} else {
			projections.setOrderProperty(sort);// 默认创建时间排序
			if ("DESC".equals(dir)) {
				projections.setDescFlag(true);
			} else {
				projections.setDescFlag(false);
			}
		}

		queryObject.setProjections(projections);
		return queryObject;
	}
	private Date getFullTime(Date shortTime) {
		String dayStr = DateFormatUtils.dateToStr(shortTime);
		String fullStr = dayStr + " " + systemConfig.getDayStartTime();
		Date fullDate = DateFormatUtils.strToDate3(fullStr);
		return fullDate;
	}
	/**
	 * 根据传入的参数条件查询结果集合
	 * 
	 * @param ExtendConfig
	 *            param 组织Bean对象参数
	 * @param startIndex
	 *            int 开始索引
	 * @param maxResultCount
	 *            int 结束索引
	 * @param sort
	 *            排序字段
	 * @param dir
	 *            顺序
	 * @return 检索结果集合
	 */
	@SuppressWarnings("unchecked")
	public List<DispatchLog> findListByParamByPage(DispatchLog param,
			int startIndex, int maxResultCount, String sort, String dir) {
		List<DispatchLog> configList = new ArrayList<DispatchLog>();

		Map<String, String> aliasmap = new HashMap<String, String>();
		QueryObject queryObject = this.getQueryObject(param, sort, dir);

		configList = dispatchLogDao.findListByQueryObject(queryObject, true,startIndex, maxResultCount, aliasmap);

		return configList;
	}

	public DispatchLog getDispatchLogById(String id) {
		return (DispatchLog) dispatchLogDao.getById(id);
	}

	public void saveDispatchLog(DispatchLog dispatchLog) {
		dispatchLogDao.save(dispatchLog);
	}

	public void deleteDispatchLog(DispatchLog dispatchLog) {
		dispatchLogDao.delete(dispatchLog);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.harmony.themis.resource.service.IRescConfigService#getConfig()
	 */
	@SuppressWarnings("unchecked")
	public List getDispatchLogListByTime(Date satrtTime, Date endTime,
			String handelType) {
		List<DispatchLog> dispatchLogList = null;
		String hql = "from DispatchLog t where t.handelType=? and t.sendTime between ? and ?";
		dispatchLogList = dispatchLogDao.findListByHQL(hql, new Object[] {
				handelType, satrtTime, endTime });

		return dispatchLogList;
	}

	@Override
	public void update(DispatchLog dispatchLog) {
		dispatchLogDao.update(dispatchLog);
	}

	@Override
	public DispatchLog getDispatchLogBySmsId(String string) {
		return dispatchLogDao.getBySmsId(string);
	}

	@Override
	public List<DispatchLog> findDispatchLogByState(String state) {
		String hql = "from DispatchLog t where t.synstate='" + state+"' or synstate is null ";
		List<DispatchLog> mass = dispatchLogDao.findListByHQL(hql, null);
		if (null != mass && mass.size() > 0) {
			return mass;
		}
		return null;
	}

	@Override
	public List<SmsLogView> setSmsView(List<SmsLogView> smsList,
			List<DispatchLog> sampleList, Map<String, SmsSent4EMAS> map)
			throws BaseServiceException {
		try {
			for (DispatchLog log : sampleList) {
				SmsLogView view = new SmsLogView();
				if (map.get(log.getId()) != null) {
					SmsSent4EMAS mas = map.get(log.getId());
				   if(log.getSynstate().equals(MessageConstants.MESSAGE_SEND_NSYNSTATE)){
					    String codes = mas.getSentresult() + "";
					    if(codes==null||codes.trim().length()==0){
							log.setState(MessageConstants.MESSAGE_SEND);
						}else if(codes.equals("0")&&!mas.getSmsstatus().equals("DeliveryImpossible")){
							log.setState(MessageConstants.MESSAGE_SEND_SUCCESS);
						}else if(codes.equals("-1")||mas.getSmsstatus().equals("DeliveryImpossible")){
							log.setState(MessageConstants.MESSAGE_SEND_FAILE);
						}else{
							log.setState(MessageConstants.MESSAGE_SEND_UNKNOWN);
						}
					}				
				}
				BeanUtils.copyProperties(view, log);
				view.setSendTimeStr(DateFormatUtils.format(log.getSendTime(),Constants.DATETIME_FORMAT_NO_SECEND));
				smsList.add(view);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public SystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

}
