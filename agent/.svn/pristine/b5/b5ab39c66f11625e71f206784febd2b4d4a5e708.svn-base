package com.harmony.themis.software.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.harmony.themis.main.util.PropertiesUtil;
import com.harmony.themis.persistence.domain.AgentHistory;
import com.harmony.themis.software.domain.SimpleMail;
import com.harmony.themis.software.service.MonitoryHistoryServiceInterface;
import com.harmonywisdom.emergency.smsplatform.request.SmsRequestSingle;
import com.harmonywisdom.emergency.smsplatform.response.SmsSendSingleRsp;
import com.harmonywisdom.smsplatform.client.SmsClient;

/**
 * 2014-09-25日龙泽全新增短信发送至手机
 *
 */
public class MonitorSendMail implements ServletContextListener{
	
	static private final Log logger = LogFactory.getLog(MonitorSendMail.class);
	private static SmsClient client = null;
	private String serverIp = null;
	private String serverPort = null;
	private String loginAccount = null;
	private String loginPasswd = null;
	
	class SendMailThread extends Thread {
		SendMailThread() {
        }

        public void run() {
        	MonitoryHistoryServiceInterface historyService=(MonitoryHistoryServiceInterface)SpringUtil.getBean("historyService");
        	if(historyService==null)
        	{
        		logger.error("historyService服务对象取不到");
        	}
        	sendMial(historyService);
        }
    }

	private void  sendMial(MonitoryHistoryServiceInterface historyService)
	{
		try{
				List<AgentHistory> historyList=new ArrayList<AgentHistory>();
				historyList=historyService.returnMailIng();
				if(historyList!=null &&historyList.size()>0)
				{
					SimpleMailSender sms=MailSenderFactory.getSender();//邮件方式
					SimpleMail sm=new SimpleMail();
					for(int i=0;i<historyList.size();i++)
					{
						String user = historyList.get(i).getReceiveUser();
							if(user.indexOf("@") != -1){
								//邮件发送
								sm.setContent(historyList.get(i).getSendContent());
								sm.setSubject(historyList.get(i).getSendContent());
								historyList.get(i).setSendStatus("1");//发送成功
								try{
									sms.send(user, sm);//发送邮件
									}
									catch(Exception e ){
										historyList.get(i).setSendStatus("-1");
										logger.error("邮件发送失败,请检查邮件地址");
									}
								historyService.update(historyList.get(i));
							}else{	//短信发送
//								//SmsSendSingleRsp result = sendMsgToMobile(sm.getContent(), user);
//								/*具体的发送短信
//								 * 
//								 */
//								
//								if(result.getResult()){
//									historyList.get(i).setSendStatus("1");//发送成功
//									historyService.update(historyList.get(i));
//								}else{
////									logger.error("应急通警告短信发送失败,失败描述：" + result.getErrorDesc());
////									System.out.println("应急通警告短信发送失败，失败描述：" + result.getErrorDesc());
//								}
							}
					}
					SendMailThread t = new SendMailThread();
					t.sleep(12*60*60000);//执行一次休眠1分钟
				}else
				{
					//没有异常邮件需要发送
				}
		}catch(Exception e)
		{
			logger.error("邮件或者短信发送失败!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 进行短信发送
	 * @param message
	 * @param phoneNum
	 * @throws Exception 
	 */
	private SmsSendSingleRsp sendMsgToMobile(String message, String phoneNum){
		//读取配置信息
		if(serverIp == null || serverPort == null 
				|| loginAccount == null || loginPasswd == null){
			serverIp = PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "sortMessageServerIp");
			serverPort = PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "sortMessagePort");
			loginAccount = PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "loginAccount");
			loginPasswd = PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "loginPassWord");
		}
		if(client == null){
			client = new SmsClient(serverIp, serverPort);
		}
		SmsRequestSingle obj = new SmsRequestSingle();
		obj.setMessage(message);
		obj.setReceiverPhoneNO(phoneNum);
		obj.setSenderId(loginAccount);
		obj.setSenderPwd(loginPasswd);
		obj.setSendType(1);
		SmsSendSingleRsp result = client.sendShortMessageSingle(obj);
		return result;
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		SendMailThread t=new SendMailThread();
		t.start();
	}

}
