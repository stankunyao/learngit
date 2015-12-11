package com.harmony.themis.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "agent")
public class Agent implements java.io.Serializable {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getReceivertimeStr() {
		return receivertimeStr;
	}

	public void setReceivertimeStr(String receivertimeStr) {
		this.receivertimeStr = receivertimeStr;
	}

	public int getIntervalTimer() {
		return intervalTimer;
	}

	public void setIntervalTimer(int intervalTimer) {
		this.intervalTimer = intervalTimer;
	}

	public String getMonitorServiceStatu() {
		return monitorServiceStatu;
	}

	public void setMonitorServiceStatu(String monitorServiceStatu) {
		this.monitorServiceStatu = monitorServiceStatu;
	}

	public String getSendtimeStr() {
		return sendtimeStr;
	}

	public void setSendtimeStr(String sendtimeStr) {
		this.sendtimeStr = sendtimeStr;
	}

	public String getStartTimer() {
		return startTimer;
	}

	public void setStartTimer(String startTimer) {
		this.startTimer = startTimer;
	}

	public String getEndTimer() {
		return endTimer;
	}

	public void setEndTimer(String endTimer) {
		this.endTimer = endTimer;
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "server_name")
	private String serverName;
	@Column(name = "server_ip")
	private String serverIp;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "status")
	private String status;
	@Column(name = "receive_time")
	private Date receiveTime;
	@Column(name="service_type")
	private String serviceType;
	// 扩展字段
	@Transient
	private String receivertimeStr;
	/**
	 * 监控服务间隔时间
	 */
	@Transient
	private int intervalTimer;
	@Transient
	private String monitorServiceStatu;
	@Transient
	private String sendtimeStr;
	@Transient
    private String startTimer;
	@Transient
    private String endTimer;
	public Agent() {

	}

	public Agent(String id,String serverName, String serverIp, String serviceName,
			String status,Date receiveTime,String serviceType) {
		this.id=id;
		this.serverName = serverName;
		this.serverIp = serverIp;
		this.serviceName = serviceName;
		this.status = status;
		this.receiveTime = receiveTime;
		this.serviceType = serviceType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
