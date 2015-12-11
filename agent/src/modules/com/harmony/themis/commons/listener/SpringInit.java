package com.harmony.themis.commons.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringInit implements ServletContextListener {
    private static WebApplicationContext springContext;
    
    public SpringInit() {
        super();
    }

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {			
		
		springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

	}
    public static WebApplicationContext getApplicationContext() {
	        return springContext;
	}

}
