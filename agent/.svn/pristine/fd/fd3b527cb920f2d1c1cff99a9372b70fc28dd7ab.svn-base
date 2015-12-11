package com.harmony.themis.software.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.harmony.themis.commons.util.DateFormatUtils;
import com.harmony.themis.main.util.PropertiesUtil;
import com.harmony.themis.software.domain.SimpleMail;

public class AutoRunCheck extends QuartzJobBean {

	static private final Log logger = LogFactory.getLog(MonitorSendMail.class);
	@Override
	public void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try{
			String reviceEmailUserNames=PropertiesUtil.getInstance().getPro("config/AgentConfig.properties", "reviceEmailUserNames");
			List<String> users=new ArrayList<String>();
			if(StringUtils.isNotEmpty(reviceEmailUserNames))
			{
					String[] us=reviceEmailUserNames.split(";");
					if(us!=null && us.length>0)
					{
						for(int a=0;a<us.length;a++)
						{
							users.add(us[a]);
						}
					}
			}else
			{
				//没有配置收件人
				System.out.println("没有配置收件人，请检查config/AgentConfig.properties");
			}
			SimpleMailSender sms=MailSenderFactory.getSender();//邮件方式
			SimpleMail sm=new SimpleMail();
				sm.setContent("日期："+DateFormatUtils.dateToStr2(new Date())+"监控服务正常运行...巡检周期为一周/次!");
				sm.setSubject("监控服务运行情况巡检通知");
			if(users!=null && users.size()>0)
						sms.send(users, sm);//群发邮件
		}catch(Exception e)
		{
			logger.error("邮件发送失败!");
			e.printStackTrace();
		}
	}

}
