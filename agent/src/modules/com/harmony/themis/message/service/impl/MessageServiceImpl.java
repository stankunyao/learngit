/**
 * 
 */
package com.harmony.themis.message.service.impl;

import java.util.List;

import com.harmony.themis.message.persistence.dao.IMsgSendTask4EMASDao;
import com.harmony.themis.message.service.IMessageService;
import com.harmony.themis.persistence.domain.SmsOutbox4EMAS;
import com.harmony.themis.persistence.domain.SmsSent4EMAS;

/**
 * 短信服务接口实现类
 * @author Wang Xiaoqing
 *
 */
public class MessageServiceImpl implements IMessageService {

	private IMsgSendTask4EMASDao msgSendTask4EMASDao;

	@Override
	public void sendMsg4EMAS(SmsOutbox4EMAS task) {
		this.msgSendTask4EMASDao.save(task);
	}
	
	
	public void setMsgSendTask4EMASDao(IMsgSendTask4EMASDao msgSendTask4EMASDao) {
		this.msgSendTask4EMASDao = msgSendTask4EMASDao;
	}

	public IMsgSendTask4EMASDao getMsgSendTask4EMASDao() {
		return msgSendTask4EMASDao;
	}


	@Override
	public SmsSent4EMAS findSmsSentBySmsId4Emas(String smsid) {
		String hql = "from SmsSent4EMAS t where t.sismsid = '"+smsid+"'";
		List<SmsSent4EMAS> emas = msgSendTask4EMASDao.findListByHQL(hql, null);
		if(null != emas && emas.size() > 0){
			return emas.get(0);
		}
		return null;
	}
    

	@Override
	public List<SmsSent4EMAS> findSmsSentBySmsIds4Emas(String[] smsids) {
		String hql = "from SmsSent4EMAS t where t.sismsid in (:sismsid)";
		List<SmsSent4EMAS> mass = msgSendTask4EMASDao.findListSmsByHql(hql, smsids);
		if(null != mass && mass.size() > 0){
			return mass;
		}
		return null;
	}

    
}
