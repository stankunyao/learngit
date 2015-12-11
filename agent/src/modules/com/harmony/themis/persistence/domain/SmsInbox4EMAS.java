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
 *		接受短信
 *		移动
 */
@Entity
@Table(name = "sms_inbox")
public class SmsInbox4EMAS {
	@Id
	private String emasmsid;//企业移动代理服务器产生的ID
	@Column(name = "EXTCODE")
	private String extcode;//扩展号码
	@Column(name = "SOURCEADDR")
	private String sourceaddr;//单个手机号码
	@Column(name = "RECEIVETIME")
	private Timestamp receivetime;//短信接收时间
	@Column(name = "MESSAGECONTENT")
	private String messagecontent;//短信内容，其编码由msgfmt决定
	@Column(name = "MSGFMT")
	private int msgfmt;//消息类型0-ASCII 4-Binary , 8-usc2 ，15-gb2312，16-gb18030
	@Column(name = "REQUESTTIME")
	private Timestamp requesttime;//短信发送入库时间
	@Column(name = "APPLICATIONID")
	private String applicationid;//业务编号，可自行设置
	//private String ecid;//EC/SI应用ID	
	public String getEmasmsid() {
		return emasmsid;
	}
	public void setEmasmsid(String emasmsid) {
		this.emasmsid = emasmsid;
	}
	public String getExtcode() {
		return extcode;
	}
	public void setExtcode(String extcode) {
		this.extcode = extcode;
	}
	public String getSourceaddr() {
		return sourceaddr;
	}
	public void setSourceaddr(String sourceaddr) {
		this.sourceaddr = sourceaddr;
	}
	public Timestamp getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(Timestamp receivetime) {
		this.receivetime = receivetime;
	}
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	public int getMsgfmt() {
		return msgfmt;
	}
	public void setMsgfmt(int msgfmt) {
		this.msgfmt = msgfmt;
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
