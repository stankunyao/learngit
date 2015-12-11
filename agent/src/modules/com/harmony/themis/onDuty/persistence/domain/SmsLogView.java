package com.harmony.themis.onDuty.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Transient;

public class SmsLogView implements java.io.Serializable {
	private String id;

	/**
	 * 操作类型(电话，短信，传真等)
	 */

	private String handelType;

	/**
	 * 接收号码
	 */

	private String receiveNum;

	/**
	 * 操作状态
	 */

	private String state;

	/**
	 * 接收人
	 */

	private String receivePerson;

	/**
	 * 接收单位
	 */

	private String receiveOrg;

	/**
	 * 短信内容
	 */

	private String messageContent;

	/**
	 * 发送时间
	 */

	private String sendTimeStr;

	/**
	 * 发送人
	 */

	private String sendPerson;

	/**
	 * 发送单位
	 */

	private String sendOrg;

	/**
	 * 备注
	 */

	private String remark;

	/**
	 * 短信id
	 */
	private String smsid;
	/**
	 * 关联事件id
	 */
	private String eventid;

	private String synstate;// 0:未同步1：同步

	private String perId;

	public SmsLogView() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHandelType() {
		return handelType;
	}

	public void setHandelType(String handelType) {
		this.handelType = handelType;
	}

	public String getReceiveNum() {
		return receiveNum;
	}

	public void setReceiveNum(String receiveNum) {
		this.receiveNum = receiveNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}

	public String getReceiveOrg() {
		return receiveOrg;
	}

	public void setReceiveOrg(String receiveOrg) {
		this.receiveOrg = receiveOrg;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getSendPerson() {
		return sendPerson;
	}

	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}

	public String getSendOrg() {
		return sendOrg;
	}

	public void setSendOrg(String sendOrg) {
		this.sendOrg = sendOrg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSmsid() {
		return smsid;
	}

	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getSendTimeStr() {
		return sendTimeStr;
	}

	public void setSendTimeStr(String sendTimeStr) {
		this.sendTimeStr = sendTimeStr;
	}

	

	public String getSynstate() {
		return synstate;
	}

	public void setSynstate(String synstate) {
		this.synstate = synstate;
	}

	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

}
