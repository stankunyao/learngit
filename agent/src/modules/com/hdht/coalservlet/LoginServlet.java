package com.hdht.coalservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jawin.COMException;

import com.hdht.ivs.model.CameraInfo;
import com.hdht.ivs.serviceclient.IvsControlManager;
import com.hdht.ivs.serviceclient.IvsControlService;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = -2914194867201500238L;
	
	@SuppressWarnings("unused")
	private ServletConfig config = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * 执行登录视频服务器
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void process(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String userId = (String) req.getParameter("userName");//用户名
		String passWord = (String) req.getParameter("pwd");//密码
			
		HttpSession session = req.getSession();
		
		RequestDispatcher loginDispatcher = req.getSession().getServletContext().getRequestDispatcher("/contents/imgmonitor/validate.jsp");//登陆失败后的跳转对象
		if(userId == null){
			req.setAttribute("code", "用户ID不能为空!");
			loginDispatcher.forward(req, res);
			return;
		}
		if(passWord == null){
			req.setAttribute("code", "密码不能为空!");
			loginDispatcher.forward(req, res); 
			return;
		}

		if(userId != null || passWord != null ){
			try {
				if(session.getAttribute("ivsControlServiceCoal")==null){
					Date startDate=new Date();
					IvsControlService ivsControlService = IvsControlManager.createIvsControlWebService("IvsControlServiceUrlCoal");
					ivsControlService.initDispatch(userId, passWord,session.getId());
					Date endDate=new Date();
					System.out.println("登录视频服务器时间:"+String.valueOf(endDate.getTime()-startDate.getTime()));
					
					session.setAttribute("ivsControlServiceCoal", ivsControlService);
				}
				initCamerasForCoalList(req);
				res.sendRedirect(req.getContextPath()+"/contents/imgmonitor/coalDefends.jsp");				
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	private void initCamerasForCoalList(HttpServletRequest request) throws COMException{
		HttpSession session = request.getSession();
		StringBuffer camerasBuffer = new  StringBuffer();
		if(session.getAttribute("camCoalList")==null){
			List<CameraInfo> camCoalList = new ArrayList<CameraInfo>();
			IvsControlService ivsControlService  = (IvsControlService)session.getAttribute("ivsControlServiceCoal");
			List<CameraInfo> allcamCoalList;
			allcamCoalList = ivsControlService.getCamerasForCoal(session.getId());
			if(allcamCoalList!=null){
				for(CameraInfo cameraInfo:allcamCoalList){
					if(cameraInfo.isOnLine()){
						camCoalList.add(cameraInfo);
					}
				}
			}
			session.setAttribute("camCoalList", camCoalList);
		}
	}
	
	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;
	}
}
