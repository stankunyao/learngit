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
import org.jawin.DispatchPtr;

import com.hdht.ivs.serviceclient.IvsControlManager;
import com.hdht.ivs.serviceclient.IvsControlService;
import com.hdht.ivs.model.CameraInfo;
import com.hdht.ivs.model.UserInfo;


public class PlayLiveServlet extends HttpServlet{
	private static final long serialVersionUID = 8748921013455381359L;

	public void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {		
		doPost(arg0,arg1);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();		
		String strChannelId = request.getParameter("channelId");
		try{
			IvsControlService ivsControlService;
			if(session.getAttribute("ivsControlServiceCoal")==null){
				ivsControlService = IvsControlManager.createIvsControlWebService("IvsControlServiceUrlCoal");
				ivsControlService.initDispatch("VC03", "tongfang3",session.getId());				
				session.setAttribute("ivsControlServiceCoal", ivsControlService);
			}else{
				ivsControlService  = (IvsControlService)session.getAttribute("ivsControlServiceCoal");
			}
			String cameraId = (String) request.getParameter("cameraId");
			Integer result = ivsControlService.playLive(Long.valueOf(strChannelId), new Long(cameraId), 0,session.getId()+"ForCoal");
			//boolean isOnline=isOnLine(request,new Long(cameraId));
			//if(!isOnline){
			//	result=2;//0成功,1失败,2不可用
			//}
			if(result==1){
				ivsControlService = IvsControlManager.createIvsControlWebService("IvsControlServiceUrlCoal");
				ivsControlService.initDispatch("VC03", "tongfang3",session.getId());				
				session.setAttribute("ivsControlServiceCoal", ivsControlService);
				System.out.println("播放失败,重新登录");
			}
			System.out.println("播放视频 操作是否成功：" + result);
			out.print(String.valueOf(result));
		}catch(Exception e){
			e.printStackTrace();
			out.print("1");
		}
	}
	
	private boolean isOnLine(HttpServletRequest request,long cameraId) throws COMException{
		HttpSession session = request.getSession();
		initCamerasForCoalList(request);
		List<CameraInfo> camCoalList=(List<CameraInfo>)session.getAttribute("camCoalList");
		boolean onLine=false;
		if(camCoalList!=null){
			for(CameraInfo cameraInfo:camCoalList){
				if(cameraInfo.getCameraId()==cameraId && cameraInfo.isOnLine()){
					onLine=true;
					break;
				}
			}
		}
		
		if(onLine){
			return true;
		}else{
			return false;
		}
	}
	
	private void initCamerasForCoalList(HttpServletRequest request) throws COMException{
		HttpSession session = request.getSession();		
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
	
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {		
		doPost(arg0,arg1);
	}
}
