package com.harmony.themis.commons.web.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gpower.dfzt.web.SearchSystem;
import com.harmony.themis.commons.util.SystemUtil;

public class ContextLoaderServlet extends HttpServlet {

	/**
	 * Initialize the root web application context.
	 */
	public void init() throws ServletException {
		// 存取从门户取得的字典项到Map中
		SystemUtil.setDictDataMap(this.getServletContext());
		String enableRadar = this.getServletContext().getInitParameter("enableRadar");
		if(enableRadar != null && "true".equalsIgnoreCase(enableRadar)) {
			SearchSystem.init(this.getServletContext().getRealPath("/"));
			SearchSystem.start();
		}
		
	}

	
	/**
	 * Close the root web application context.
	 */
	public void destroy() {
		SearchSystem.stop();
	}
	
	/**
	 * This should never even be called since no mapping to this servlet should
	 * ever be created in web.xml. That's why a correctly invoked Servlet 2.3
	 * listener is much more appropriate for initialization work ;-)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getServletContext().log(
				"Attempt to call service method on ContextLoaderServlet as [" +
				request.getRequestURI() + "] was ignored");
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}


	public String getServletInfo() {
		return "ContextLoaderServlet for Servlet API 2.2/2.3 " +
		    "(deprecated in favor of ContextLoaderListener for Servlet API 2.4)";
	}

}
