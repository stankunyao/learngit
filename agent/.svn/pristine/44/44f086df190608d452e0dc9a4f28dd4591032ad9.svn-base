package com.hdht.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.jawin.COMException;

import com.harmony.framework.web.ext.convert.JsonUtils;
import com.harmony.framework.web.ext.gird.GridPage;
import com.hdht.ivs.serviceclient.IvsControlService;
import com.hdht.ivs.model.CameraInfo;


public class PlayLiveResultServlet extends HttpServlet{
	private static final long serialVersionUID = 8748921013455381359L;

	public void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {		
		doPost(arg0,arg1);
	}

	private String toJosn(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{returnTag:");
		buffer.append("'" + str + "'");
		return buffer.toString();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0L);
		response.setHeader("Pragma", "no-cache");

		PrintWriter writer = response.getWriter();
		String json=null;
		try {
			json = GetCameras(request, response);
		} catch (COMException e) {
			e.printStackTrace();
		}
		writer.write(json);
		response.flushBuffer();
	}
	
	private String GetCameras(HttpServletRequest request, HttpServletResponse response) throws COMException{
		HttpSession session = request.getSession();
		StringBuffer camerasBuffer = new  StringBuffer();
		
		List<CameraInfo> camList = new ArrayList<CameraInfo>();
		IvsControlService ivsControlService  = (IvsControlService)session.getAttribute("ivsControlService");
		if(session.getAttribute("camList")==null){
			List<CameraInfo> allcamList;
			allcamList = ivsControlService.getCameras(session.getId());
			if(allcamList!=null){
				for(CameraInfo cameraInfo:allcamList){
					if(cameraInfo.isOnLine()){
						camList.add(cameraInfo);
					}
				}
			}
			session.setAttribute("camList", camList);
		}else{
			camList=(List<CameraInfo>)session.getAttribute("camList");
		}

    	int start=0;
    	try{
    		String tem=request.getParameter("start");
    		start=Integer.parseInt(request.getParameter("start"));
    	}catch(Exception e){
    		
    	}
    	int limit=20;
    	try{
     		limit=Integer.parseInt(request.getParameter("limit"));
    	}catch(Exception e){
    		
    	}
    	int pagecount=camList.size();
    	camList=getPageList(camList,start,limit);
    	JsonConfig jsonConfig = JsonUtils.configJson(new String[]{}, "yyyy-MM-dd");
    	
		GridPage gridPage = new GridPage(camList,pagecount);
		JSON json = JSONSerializer.toJSON(gridPage, jsonConfig);
		
		return json.toString();
	}
	
	private List getPageList(List list,int start,int limit){
		List pagelist=new ArrayList();
		for(int i=start;i<start+limit;i++){
			if(i<list.size()){
				pagelist.add(list.get(i));
			}
		}
		return pagelist;
	}
	
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {		
		doPost(arg0,arg1);
	}
}
