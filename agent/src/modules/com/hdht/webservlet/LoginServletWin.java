package com.hdht.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jawin.COMException;
import com.hdht.ivs.model.UserInfo;
import com.hdht.ivs.serviceclient.IvsControlManager;
import com.hdht.ivs.serviceclient.IvsControlService;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 * <p>copyright:</p>
 * <p>Date: 2009-7-9</p>
 * @version V1.0
 * @amendment history:
 */
public class LoginServletWin extends HttpServlet{

    private static final long serialVersionUID = -2914194867201500238L;

    @SuppressWarnings("unused")
    private ServletConfig config = null;

    public void service(HttpServletRequest arg0, HttpServletResponse arg1)throws ServletException, IOException {
        process(arg0, arg1);
    }
    private String toJosn(String str) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{returnTag:");
        buffer.append("'" + str + "'}");
        return buffer.toString();
    }

    public  void process(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String userId = (String) req.getParameter("userName");//用户名
        String passWord = (String) req.getParameter("pwd");//密码

        HttpSession session = req.getSession();

        if(userId == null || passWord == null){
            out.write(toJosn("NO"));
            res.flushBuffer();
            return;
        }


        if(userId != null || passWord != null ){
            try {
                if(session.getAttribute("ivsControlService")==null){
                    Date startDate=new Date();
                    IvsControlService ivsControlService = IvsControlManager.createIvsControlWebService();
                    ivsControlService.initDispatch(userId, passWord,session.getId());
                    Date endDate=new Date();
                    System.out.println("取得多边形初始化,时间:"+String.valueOf(endDate.getTime()-startDate.getTime()));
                    session.setAttribute("ivsControlService", ivsControlService);
                }
                out.write(toJosn("OK"));
                res.sendRedirect(req.getContextPath()+"/gis/camera.html");
                res.flushBuffer();
            } catch(Exception e){
                out.write(toJosn("NO"));
                res.sendRedirect(req.getContextPath()+"/gis/camera.html");
                res.flushBuffer();
                e.printStackTrace();
            }

        }
    }


    public void init(ServletConfig arg0) throws ServletException {
        config = arg0;
    }
}
