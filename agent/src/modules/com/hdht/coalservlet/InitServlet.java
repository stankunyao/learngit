package com.hdht.coalservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jawin.COMException;

import com.hdht.ivs.model.CameraInfo;
import com.hdht.ivs.model.UserInfo;
import com.hdht.ivs.serviceclient.IvsControlService;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 * <p>copyright:</p>
 * <p>Date: 2009-7-9</p>
 * @version V1.0
 * @amendment history:
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 5475515487801727161L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * 对数据进行JSON数据格式封装
	 * @param str 需要转换的字符串
	 * @return 转换过的字符串
	 * 
	 */
	private String toJosn(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{returnTag:");
		buffer.append("'" + str + "'");
		return buffer.toString();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();		
		String message = "none";
		StringBuffer buffer = new StringBuffer();
		String type = request.getParameter("type");
		System.out.println("type=" + type);
		
		if(type != null && "register".equals(type)){
			try {
				IvsControlService ivsControlService  = (IvsControlService)session.getAttribute("ivsControlServiceCoal");
				UserInfo userInfo = ivsControlService.getLoginUserInfo(session.getId());
				
				System.out.println("name=" + userInfo.getUserName() + ",domainId=" + userInfo.getDomainId()
						+ ",ccIP=" + userInfo.getCcIP());
				
				String str = "querySucced";
				buffer.append(toJosn(str));
				buffer.append(",");
				
				buffer.append("queryResult:[");
				buffer.append("{name:'"
						+ userInfo.getUserName()
						+ "',domainId:'"
						+ userInfo.getDomainId()
						+ "',ccIP:'"
						+ userInfo.getCcIP() + "'}]}");

				message = buffer.toString();
				out.print(message);
			} catch (COMException e) {
				e.printStackTrace();
				message = "none";
				out.print(toJosn(message) + "}");
			} catch(Exception e)
			{
				e.printStackTrace();
				message = "none";
				out.print(toJosn(message) + "}");
			}
			
		}else if(type != null && "logout".equals(type)){
			try{
				IvsControlService ivsControlService  = (IvsControlService)session.getAttribute("ivsControlServiceCoal");
				ivsControlService.logoff(session.getId());
				message = "success";
				out.print(toJosn(message) + "}");
			} catch (COMException e){
				e.printStackTrace();
				message = "none";
				out.print(toJosn(message) + "}");
			} catch(Exception e){
				e.printStackTrace();
				message = "none";
				out.print(toJosn(message) + "}");
			}
		}
	}

	
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0,arg1);
	}
}