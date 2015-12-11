package com.harmony.themis.software.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.harmony.themis.main.util.PropertiesUtil;
import com.harmony.themis.persistence.domain.Agent;
import com.harmony.themis.software.domain.NodeDocument;
import com.harmony.themis.software.domain.SmsConfig;
import com.harmony.themis.software.domain.Supervisor;
import com.harmony.themis.software.service.MonitorServiceInterface;
import com.harmony.themis.software.util.SpringUtil;

public class AgentServiceFactory {
  private static AgentServiceFactory _instance;
  private String configFilePath="AgentConfig.properties";
  private Map<String,Supervisor> services = new HashMap<String,Supervisor>();
  private Map<String,Agent> _serviceMap =  new HashMap<String,Agent>();
  private SmsConfig sConfig = new SmsConfig();
  public AgentServiceFactory(){
	  refresh();
	  initService();
  }
  public static AgentServiceFactory getInstance(){
	 if(_instance==null){
		 _instance = new AgentServiceFactory();
	 }
	 return _instance;
  }
  public NodeDocument getProcess(String machineIp , String serviceName){
	  Supervisor supervisor = services.get(machineIp);
	  NodeDocument doc = null;
	  if(supervisor!=null){
		  doc=supervisor.getMap().get(serviceName);
	  }	  
	  return doc;
  }
  public void setProcess(String machineIp,String serviceName,NodeDocument nDm){
	  Supervisor supervisor = services.get(machineIp);
	  NodeDocument nDoc = new NodeDocument();
	  nDoc.setMsgTimerClock(sConfig.getMsgClock());
	  nDoc.setSdMsgNum(sConfig.getSndMsgNum());
	  nDoc.setPhoneNumber(sConfig.getPhoneNumber());
	  nDoc.setServiceName(serviceName);
	  nDoc.setState("1");
	  if(supervisor==null){
		  supervisor = new Supervisor();
		  supervisor.setCurrenTimer(System.currentTimeMillis());
		  supervisor.setMachineIp(machineIp);		  
		  supervisor.getMap().put(serviceName, nDoc);
	  }else{
		  if(nDm!=null){
			  nDoc =nDm;
		  }		  
		  supervisor.getMap().put(serviceName, nDoc);
	  }
	  services.put(machineIp, supervisor);
  }
  public void initService() {
	  _serviceMap.clear();
	  Agent param = new Agent();
	  MonitorServiceInterface agentService=(MonitorServiceInterface)SpringUtil.getBean("agentService");
	  List<Agent> list = agentService.findLisByParam(param, 0, 20000, null,null);
	  if(list!=null){
		  for(Agent agent :list){
			   Agent age = new Agent();
			try {
				BeanUtils.copyProperties(age, agent);
				 _serviceMap.put(agent.getServerIp()+agent.getServiceName(), age);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		  }
	  }
  }
  public void clearAll(){
	  services.clear();
  }
  public Agent getService(String processName){
	  Agent agent = _serviceMap.get(processName);
	  return agent;
  }
  public void putService(String processName, Agent agent){
	  _serviceMap.put(agent.getServerIp()+processName, agent);
  }
  public void refresh(){
	 PropertiesUtil pUtil= PropertiesUtil.getInstance();
	 String msgClock = pUtil.getPro("config/"+this.configFilePath, "msgClock");
	 String sndMsgNum = pUtil.getPro("config/"+this.configFilePath, "sndMsgNum");
	 String phoneNumber[] = pUtil.getPro("config/"+this.configFilePath, "phoneNumber").split(";");
	 sConfig.setMsgClock(Integer.parseInt(msgClock));
	 sConfig.setSndMsgNum(Integer.parseInt(sndMsgNum));
	 sConfig.setPhoneNumber(phoneNumber);
  }
  
}
