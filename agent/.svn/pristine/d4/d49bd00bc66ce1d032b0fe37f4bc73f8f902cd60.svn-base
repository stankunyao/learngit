package com.harmony.themis.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.harmony.themis.commons.Constants;
import com.harmony.themis.commons.util.DateFormatUtils;

@Entity
@Table(name = "agent_history")
public class AgentHistory implements java.io.Serializable{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public String getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	public String getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}
	public String getReceivertimeStr() {
		return receivertimeStr;
	}
	public void setReceivertimeStr(String receivertimeStr) {
		this.receivertimeStr = receivertimeStr;
	}
	public Date getStartTimer() {
		return startTimer;
	}
	public void setStartTimer(Date startTimer) {
		this.startTimer = startTimer;
	}
	public Date getEndTimer() {
		return endTimer;
	}
	public void setEndTimer(Date endTimer) {
		this.endTimer = endTimer;
	}

	@Column(name = "SERVER_NAME")
	private String serverName;
	@Column(name = "SERVER_IP")
	private String serverIp;
	@Column(name = "SERVICE_NAME")
	private String serviceName;
	@Column(name = "SERVICE_TYPE")
	private String serviceType;
	@Column(name = "ERROR_TYPE")
	private String errorType;
	@Column(name = "SEND_TYPE")
	private String sendType;
	@Column(name="send_time")
	private Date sendTime;
	@Column(name="SEND_CONTENT")
	private String sendContent;
	@Column(name="SEND_STATUS")
	private String sendStatus;
	@Column(name="RECEIVE_USER")
	private String receiveUser;
	// 扩展字段
	@Transient
	private String receivertimeStr;
	@Transient
    private Date startTimer;
	@Transient
    private Date endTimer;
	public AgentHistory(){
		
	}
	public AgentHistory(String historyId,String serverName,String serviceName,String serverIp,String serviceType,String sendContent,String sendStatus,Date sendTime,String errorType,String sendType,String receiveUser){
		this.serverName=serverName;
		this.serviceName=serviceName;
		this.serverIp=serverIp;
		this.serviceType=serviceType;
		this.sendContent=sendContent;
		this.sendStatus=sendStatus;
		this.errorType=errorType;
		this.sendTime=sendTime;
		this.receiveUser=receiveUser;
		this.sendType=sendType;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
