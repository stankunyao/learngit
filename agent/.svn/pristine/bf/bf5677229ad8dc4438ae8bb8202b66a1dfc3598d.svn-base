/**
 * 
 */
package com.harmony.themis.message.service;

import java.util.List;

import com.harmony.themis.persistence.domain.SmsOutbox4EMAS;
import com.harmony.themis.persistence.domain.SmsSent4EMAS;

/**
 * 短信服务接口
 * @author Wang Xiaoqing
 *
 */
public interface IMessageService {

	
	/**
	 * 移动短信插入
	 * @param task
	 */
	public void sendMsg4EMAS(SmsOutbox4EMAS task);
	/**
	 * 电信短信插入
	 * @param task
	 */
//	public void sendMsg4MASS(SmsOutbox4MASS task);
	/**
	 * 按照短信id查询相应的发送对象 移动
	 * @param smsid
	 * @return
	 */
	public SmsSent4EMAS findSmsSentBySmsId4Emas(String smsid);
	/**
	 * 按照短信ids查询相应的发送对象 移动
	 * @param smsid
	 * @return
	 */
	public List<SmsSent4EMAS> findSmsSentBySmsIds4Emas(String [] smsids);
	

}
