/**
 * 
 */
package com.harmony.themis.persistence.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DaoKun
 *		已处理短信对象（可以查询和删除）
 *		移动
 */
@Entity
@Table(name = "sms_sent")
public class SmsSent4EMAS {
	@Id
	private String massmsid;//企业移动代理服务器产生的ID
	@Column(name = "GWSMSID")
	private String gwsmsid;//isag产生的msgid（isag=综合业务接入网关）
	@Column(name = "SISMSID")
	private String sismsid;//uuid/guid由smsoutbox带来
	@Column(name = "EXTCODE")
	private String extcode;//扩展代码
	@Column(name = "DESTADDR")
	private String destaddr;//单个手机号码
	@Column(name = "REQUESTTIME")
	private Timestamp requesttime;//请求时间，由smsoutbox带啦
	@Column(name = "SENTTIME")
	private Timestamp senttime;//提交到isag的时间
	@Column(name = "SENTRESULT")
	private int sentresult;//发送状态0：正确1：消息结构错2：命令字错3：消息序号重复4：消息长度错5：资费代码错6：超过最大消息长度7：业务代码错8：流量控制错9：其他错误
	@Column(name = "SMSSTATUS")
	private String smsstatus;//短信状态报告delivered短消息发送成功expired超过有效期deleted已删除accepted已接收undeliv短消息不可转发unknown未知状态rejected被拒绝
	@Column(name = "STATUSTIME")
	private Timestamp statustime;//收到状态报告的时间
	@Column(name = "APPLICATIONID")
	private String applicationid;//业务编号，可自行设置
	//private String ecid;//EC/SI应用ID	
	
	public String getMassmsid() {
		return massmsid;
	}
	public void setMassmsid(String massmsid) {
		this.massmsid = massmsid;
	}
	public String getGwsmsid() {
		return gwsmsid;
	}
	public void setGwsmsid(String gwsmsid) {
		this.gwsmsid = gwsmsid;
	}
	public String getSismsid() {
		return sismsid;
	}
	public void setSismsid(String sismsid) {
		this.sismsid = sismsid;
	}
	public String getExtcode() {
		return extcode;
	}
	public void setExtcode(String extcode) {
		this.extcode = extcode;
	}
	public String getDestaddr() {
		return destaddr;
	}
	public void setDestaddr(String destaddr) {
		this.destaddr = destaddr;
	}
	public Timestamp getRequesttime() {
		return requesttime;
	}
	public void setRequesttime(Timestamp requesttime) {
		this.requesttime = requesttime;
	}
	public Timestamp getSenttime() {
		return senttime;
	}
	public void setSenttime(Timestamp senttime) {
		this.senttime = senttime;
	}
	public int getSentresult() {
		return sentresult;
	}
	public void setSentresult(int sentresult) {
		this.sentresult = sentresult;
	}
	public String getSmsstatus() {
		return smsstatus;
	}
	public void setSmsstatus(String smsstatus) {
		this.smsstatus = smsstatus;
	}
	public Timestamp getStatustime() {
		return statustime;
	}
	public void setStatustime(Timestamp statustime) {
		this.statustime = statustime;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
//	public String getEcid() {
//		return ecid;
//	}
//	public void setEcid(String ecid) {
//		this.ecid = ecid;
//	}
}
