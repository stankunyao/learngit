package com.harmony.themis.software.domain;

import java.util.HashMap;
import java.util.Map;

public class Supervisor {
	private long currenTimer;
    private String machineName;
    private String machineIp;
    Map<String,NodeDocument> map = new HashMap<String,NodeDocument>();
	public Supervisor() {

	}
	public long getCurrenTimer() {
		return currenTimer;
	}

	public void setCurrenTimer(long currenTimer) {
		this.currenTimer = currenTimer;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getMachineIp() {
		return machineIp;
	}

	public void setMachineIp(String machineIp) {
		this.machineIp = machineIp;
	}
	public Map<String, NodeDocument> getMap() {
		return map;
	}
	public void setMap(Map<String, NodeDocument> map) {
		this.map = map;
	}
    
}
