package com.harmony.themis.software.util;

import org.springframework.web.context.WebApplicationContext;

import com.harmony.themis.commons.listener.SpringInit;

public class SpringUtil {
    private static WebApplicationContext springContext;
	static{
		springContext =SpringInit.getApplicationContext();
	}
	public static Object getBean(String name) {
		return springContext.getBean(name);
	}
	
}
