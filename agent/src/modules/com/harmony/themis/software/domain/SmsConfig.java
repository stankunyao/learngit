package com.harmony.themis.software.domain;

public class SmsConfig {
	private int msgClock;
	private int sndMsgNum;
	private String[] phoneNumber;

	public int getMsgClock() {
		return msgClock;
	}

	public void setMsgClock(int msgClock) {
		this.msgClock = msgClock;
	}

	public int getSndMsgNum() {
		return sndMsgNum;
	}

	public void setSndMsgNum(int sndMsgNum) {
		this.sndMsgNum = sndMsgNum;
	}

	public String[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
