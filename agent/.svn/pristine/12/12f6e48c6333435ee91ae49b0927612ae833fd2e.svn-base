<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title></title>
  <style type="text/css">
    	#orgTypeTabs ul LI {
    height:30px;
    line-height:30px;  /*  让内容垂直居中  */
    display:inline;  /*  将li设置成内联元素就可以了  */
    font-size:15px;
    ont-family:Chinese Font;
    padding:6px
}
</style>
 	 <%@ include file="/commons/common_include.jsp"%> 
    <script src="js/agent.js"></script>
  </head>
  <script type="text/javascript">
      setInterval("myInterval()",10000);//1000为1秒钟
       function myInterval()
       {
            makeTableAgent();
        }
   </script>
<body class="borderlayout">

	<div region="north" size=79>
	<div region="north" size=29>
	  	<div class="navbar">
	  	<h2>当前操作：</h2>
	  	<h2>运行监控</h2>
	  	</div>
	  	</div>
	  		<div region="center">
			<div id="orgTypeTabs">
			<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
				<LI id="Limonitor" class="ui-state-default ui-corner-top"><A href="javascript:monitor();" id="subOrgTab">实时监控</A></LI>
				<LI id="LimonitorLog" class="ui-state-default ui-corner-top"><A href="javascript:monitorLog();" id="currOrgTab">监控日志</A></LI>
			</ul>
		</div>
	</div>
		</div>
	</div>
	
	
	<div region="center">
	 <div id="monitor" align="center">
	 <table id="templateTable" frame=void rules=none  cellspacing=0  align="center" width="80%" border="1px" cellspacing="0px" cellpadding="0px"></table>
	</div>
	<div id="monitorLog"  style="display:none">
		<form id="templateSearchForm">
			<fieldset>
				<table>
					<tr>
						<td style="width:60px;"><label for="serverName">机器名称：</label></td>
						<td>
							<div class="input">
								<input type="text" id="serverName"  name="serverName" size="20"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</td>
						<td style="width:60px;"><label for="serviveName">服务名称：</label></td>
						<td>
							<div class="input">
								<input type="text" id="serviceName" name="serviceName" size="20"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</td>
						<td style="width:60px;"><label for="startReceivertime">通知时间：</label></td>
						<td>
							<div class="input">
							<input type="text" id="startReceivertime" size="14" name="startReceivertime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly/>
						至
							<input type="text" id="endReceivertime" size="14" name="endReceivertime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly/>
							</div>
						</td>
						<td>		
			</td>
					</tr>
				</table></fieldset></form>
				<div class="buttons" style="width:130px;margin-top:-25px;margin-right:30px;float:right;">
				<button id="searchB">查询</button>
				<button id="resetB">清空</button>
			</div> 
		<div class="toolbar">
			<button id="excelExport">导出</button>
		</div>
		<table id="templateTableLog"></table>
	</div>
	</div>
</body>
</html>
