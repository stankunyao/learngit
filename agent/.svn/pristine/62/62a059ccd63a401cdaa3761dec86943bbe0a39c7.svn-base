/**
 * 
 */
package com.harmony.themis.persistence.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author DaoKun
 *		短信发送队列，该表只能插入
 *		移动
 */
@Entity
@Table(name = "sms_outbox")
public class SmsOutbox4EMAS {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "assigned")	
	private String sismsid;//uuid/guid由应用侧产生
	@Column(name = "EXTCODE")
	private String extcode;//扩展号码
	@Column(name = "DESTADDR",length=2000)
	private String destaddr;//接受手机，多个用;分割，最大不超过50
	@Column(name = "MESSAGECONTENT",length=2000)
	private String messagecontent;//短信内容，其编码由msgfmt决定
	@Column(name = "REQDELIVERYREPORT")
	private int reqdeliveryreport = 1; //是否需要状态报告0：不需要1：需要
	@Column(name = "MSGFMT")
	private int msgfmt = 15;//消息类型0-ASCII 4-Binary , 8-usc2 ，15-gb2312，16-gb18030
	@Column(name = "SENDMETHOD")
	private int sendmethod;//发送方式 普通短信立即显示，长短信组包		带结构短信
	@Column(name = "REQUESTTIME")
	private Timestamp requesttime;//请求时间
	@Column(name = "APPLICATIONID")
	private String applicationid = "";//业务编号，可自行设置
	//private String ecid = "cdyjb";//EC/SI应用ID
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
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	public int getReqdeliveryreport() {
		return reqdeliveryreport;
	}
	public void setReqdeliveryreport(int reqdeliveryreport) {
		this.reqdeliveryreport = reqdeliveryreport;
	}
	public int getMsgfmt() {
		return msgfmt;
	}
	public void setMsgfmt(int msgfmt) {
		this.msgfmt = msgfmt;
	}
	public int getSendmethod() {
		return sendmethod;
	}
	public void setSendmethod(int sendmethod) {
		this.sendmethod = sendmethod;
	}
	public Timestamp getRequesttime() {
		return requesttime;
	}
	public void setRequesttime(Timestamp requesttime) {
		this.requesttime = requesttime;
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
