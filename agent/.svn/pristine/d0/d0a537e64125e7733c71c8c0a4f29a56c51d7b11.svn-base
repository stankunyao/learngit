package com.harmony.themis.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 调度历史
 * @author meinan
 * @created 2008-11-26
 */

@Entity
@Table(name="HM_DISPATCH_LOG")
public class DispatchLog  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
// Fields    
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")	
    private String id;
	
	/**
	 * 操作类型(电话，短信，传真等)
	 */
 	@Column(name = "HANDEL_TYPE")
     private String handelType;
 	
	/**
	 * 接收号码
	 */
 	@Column(name = "RECEIVE_NUM")
     private String receiveNum;
 	
 	
	/**
	 * 操作状态
	 */
 	@Column(name = "STATE")
     private String state;
 	
 	/**
	 * 接收人
	 */
 	@Column(name = "RECEIVE_PERSON")
     private String receivePerson;
 	
 	/**
	 * 接收单位
	 */
 	@Column(name = "RECEIVE_ORG")
     private String receiveOrg;

 	/**
	 * 短信内容
	 */
 	@Column(name = "MESSAGE_CONTENT")
     private String messageContent;

 	/**
	 * 发送时间
	 */
 	@Column(name = "SEND_TIME")
     private Date sendTime;

 	/**
	 * 发送人
	 */
 	@Column(name = "SEND_PERSON")
     private String sendPerson;
 	
 	/**
	 * 发送单位
	 */
 	@Column(name = "SEND_ORG")
     private String sendOrg;
 	
 	/**
	 * 备注
	 */
 	@Column(name = "REMARK")
     private String remark;
 	
 	@Transient
 	private Date startTime;
 	
 	@Transient
 	private Date endTime;
 	/**
 	 * 短信id
 	 */
 	private String smsid;
 	/**
 	 * 关联事件id
 	 */
 	private String eventid;
	@Column(name = "synstate")
 	private String synstate;//0:未同步1：同步
	@Column(name = "perid")
	private String perId;

    // Constructors


      public DispatchLog(String id, String handelType, String receiveNum, String state, String receivePerson, String receiveOrg, String messageContent, Date sendTime, String sendPerson, String sendOrg, String remark) {
		super();
		this.id = id;
		this.handelType = handelType;
		this.receiveNum = receiveNum;
		this.state = state;
		this.receivePerson = receivePerson;
		this.receiveOrg = receiveOrg;
		this.messageContent = messageContent;
		this.sendTime = sendTime;
		this.sendPerson = sendPerson;
		this.sendOrg = sendOrg;
		this.remark = remark;
	}


	/** default constructor */

	public DispatchLog() {
		
	}


	 /** full constructor */



	public String getHandelType() {
		return handelType;
	}


	public void setHandelType(String handelType) {
		this.handelType = handelType;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}


	public String getReceiveNum() {
		return receiveNum;
	}


	public void setReceiveNum(String receiveNum) {
		this.receiveNum = receiveNum;
	}


	public String getReceiveOrg() {
		return receiveOrg;
	}


	public void setReceiveOrg(String receiveOrg) {
		this.receiveOrg = receiveOrg;
	}


	public String getReceivePerson() {
		return receivePerson;
	}


	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSendOrg() {
		return sendOrg;
	}


	public void setSendOrg(String sendOrg) {
		this.sendOrg = sendOrg;
	}


	public String getSendPerson() {
		return sendPerson;
	}


	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}


	public Date getSendTime() {
		return sendTime;
	}


	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	/**   
	 * startTime   
	 *   
	 * @return  the startTime    
	 */
	public Date getStartTime() {
		return startTime;
	}


	/**   
	 * @param startTime the startTime to set   
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	/**   
	 * endTime   
	 *   
	 * @return  the endTime    
	 */
	public Date getEndTime() {
		return endTime;
	}


	/**   
	 * @param endTime the endTime to set   
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
