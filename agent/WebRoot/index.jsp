<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>${applicationScope.systemInfo.systemName}</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	  //window.location.href="${pageContext.request.contextPath}/index.action";
	  //window.location.href="${pageContext.request.contextPath}/contents/main/main.jsp";
	</script>
  </head>
  
  <body style="margin: 0px;overflow:hidden">
  <iframe id="main" name="main" frameborder="no" scrolling="no" src="${pageContext.request.contextPath}/index.action?first=false" width="100%" height="100%"></iframe>  
  </body>
</html>
