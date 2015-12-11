package com.harmony.themis.software.util;

import com.harmony.themis.main.util.PropertiesUtil;
/**
 * 发件箱工厂
 * @author wanglei
 *
 */
public class MailSenderFactory {

	/**
	 * 服务邮箱
	 */
	private static SimpleMailSender serviceSms = null;
	
	private static String smtpHostName=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "smtpHostName");
	private static String userName=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "userName");
	private static String passWord=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "passWord");

	/**
	 * 获取邮箱
	 * 
	 * @return 符合类型的邮箱
	 */
	public static SimpleMailSender getSender() {
		
			if (serviceSms == null) {
				serviceSms = new SimpleMailSender(smtpHostName,userName,
						passWord);
			}
			return serviceSms;
	}

}