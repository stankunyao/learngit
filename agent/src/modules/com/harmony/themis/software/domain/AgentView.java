package com.harmony.themis.software.domain;



public class AgentView {
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	private String id;
   
	private String serviceName;
   
	private String serverIp;
  
	private String serverName;

	private String status;
	private String receivertime;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	


	

	public String getReceivertime() {
		return receivertime;
	}

	

	public void setReceivertime(String receivertime) {
		this.receivertime = receivertime;
	}
	
	 //判断是否是同一个服务器
	 public boolean equals(Object o){   
	     AgentView s = (AgentView)o;   
	     return s.getServerIp().equals(serverIp)?true:false;   
	}   
}
