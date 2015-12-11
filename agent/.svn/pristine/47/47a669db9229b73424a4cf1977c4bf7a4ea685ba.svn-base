package com.hdht.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jawin.COMException;

import com.hdht.ivs.model.CameraInfo;
import com.hdht.ivs.serviceclient.IvsControlManager;
import com.hdht.ivs.serviceclient.IvsControlService;

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
            if(session.getAttribute("ivsControlService")==null){
                ivsControlService = IvsControlManager.createIvsControlWebService();
                ivsControlService.initDispatch("yj002", "111111",session.getId());
                session.setAttribute("ivsControlService", ivsControlService);
            }else{
                ivsControlService  = (IvsControlService)session.getAttribute("ivsControlService");
            }
            String cameraId = (String) request.getParameter("cameraId");
            Integer result = ivsControlService.playLive(Long.valueOf(strChannelId), new Long(cameraId), 0,session.getId());
            //boolean isOnline=isOnLine(request,new Long(cameraId));
            //if(!isOnline){
            //	result=2;//0成功,1失败,2不可用
            //}
            if(result==1){
                ivsControlService = IvsControlManager.createIvsControlWebService();
                ivsControlService.initDispatch("yj002", "111111",session.getId());
                session.setAttribute("ivsControlService", ivsControlService);
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
        initCamerasList(request);
        List<CameraInfo> camList=(List<CameraInfo>)session.getAttribute("camList");
        boolean onLine=false;
        if(camList!=null){
            for(CameraInfo cameraInfo:camList){
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

    private void initCamerasList(HttpServletRequest request) throws COMException{
        HttpSession session = request.getSession();
        if(session.getAttribute("camList")==null){
            List<CameraInfo> camList = new ArrayList<CameraInfo>();
            IvsControlService ivsControlService  = (IvsControlService)session.getAttribute("ivsControlService");
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
        }
    }

    public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        doPost(arg0,arg1);
    }
}
