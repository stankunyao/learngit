package com.harmony.themis.software.domain;

public class NodeDocument {
	private String serviceName;
	private String state;
	private int sdMsgNum;
	private int msgTimerClock;
	private String [] phoneNumber;
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSdMsgNum() {
		return sdMsgNum;
	}

	public void setSdMsgNum(int sdMsgNum) {
		this.sdMsgNum = sdMsgNum;
	}

	public int getMsgTimerClock() {
		return msgTimerClock;
	}

	public void setMsgTimerClock(int msgTimerClock) {
		this.msgTimerClock = msgTimerClock;
	}

	public String[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
}
