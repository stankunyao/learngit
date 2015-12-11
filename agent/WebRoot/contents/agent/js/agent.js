$(function() {
	//grid自适应高度
	$(window).resize(function(){
	     $(window).unbind("onresize");
	     jQuery("#templateTable").setGridHeight($(window).height()-130);
	     jQuery("#templateTableLog").setGridHeight($(window).height()-210);
	     $(window).bind("onresize", this);
	});
	jQuery("#templateTableLog").initGrid({
		url : 'agent_getHistoryListByParamByPage.action',
		shrinkToFit :true,	forceFit : true, 
		cols : [
			{
				header : 'id',
				name : 'id',
				hidden : true,
				id : true,
				index : 'ID',
				width : 120
			},
			{
				header : '机器名称',
				name : 'serverName',
				hidden : false,
				id : false,
				index : 'serverName',
				align:'center',
				width : 120
				
			},
			{
				header : '服务器地址',
				name : 'serverIp',
				hidden : false,
				id : false,
				index : 'serverIp',
				align:'center',
				width : 120
			},
			{
				header : '服务名称',
				name : 'serviceName',
				hidden : false,
				id : false,
				index : 'serviceName',
				align:'center',
				width : 120
			}
			,
			{
				header : '错误类型',
				name : 'errorType',
				hidden : false,
				id : false,
				index : 'errorType',
				align:'center',
				width : 120,
				formatter:ErrorCH
			},
			{
				header : '通知时间',
				name : 'sendTime',
				hidden : false,
				id : false,
				index : 'sendTime',
				align:'center',
				width : 120
			},
			{
				header : '通知类型',
				name : 'sendType',
				hidden : false,
				id : false,
				index : 'sendType',
				align:'center',
				width : 120
			},
			{
				header : '接受对象',
				name : 'receiveUser',
				hidden : false,
				id : false,
				index : 'receiveUser',
				align:'center',
				width : 120
			}
			,
			{
				header : '通知状态',
				name : 'sendStatus',
				hidden : false,
				id : false,
				index : 'sendStatus',
				align:'center',
				width : 120
			}
			,
			{
				header : '发送内容',
				name : 'sendContent',
				hidden : false,
				id : false,
				index : 'sendContent',
				align:'center',
				width : 120
			}
		],
		ondblClickRow : function(rowid, iRow, iCol, e) {
		}
	});
	$("#searchB").click(function() {
		search();
	});
	$("#resetB").click(function() {
		$("#templateSearchForm").clearForm();
		search();
	});
	
	$("#excelExport").click(function(){
		var serverName=$("#serverName").val();
		var serviceName=$("#serviceName").val();
		var startReceivertime=$("#startReceivertime").val();
		var endReceivertime=$("#endReceivertime").val();
		location.href=templateRoot+"/agent_exportExcel.action?serviceName="+serviceName+"&serverName="+serverName+"&startReceivertime="+startReceivertime+"&endReceivertime="+endReceivertime;
	});
	monitor();
});

function search(){
	var serverName=$("#serverName").val();
	var serviceName=$("#serviceName").val();
	var startReceivertime=$("#startReceivertime").val();
	var endReceivertime=$("#endReceivertime").val();
	var params={serverName:serverName,serviceName:serviceName,startReceivertime:startReceivertime,endReceivertime:endReceivertime};
	$("#templateTableLog").searchGrid(params);  
}
function monitor(){
	makeTableAgent();
	$("#monitorLog").hide();
	$("#monitor").show();
	$("#serverName").val('');
	$("#serviceName").val('');
	$("#startReceivertime").val('');
	$("#endReceivertime").val('');
	$("#LimonitorLog").removeClass("ui-state-default ui-corner-top ui-tabs-selected ui-state-active").addClass("ui-state-default ui-corner-top"); 
	$("#Limonitor").removeClass("ui-state-default ui-corner-top").addClass("ui-state-default ui-corner-top ui-tabs-selected ui-state-active"); 
}
function monitorLog(){
	search();
	$("#monitor").hide();
	$("#monitorLog").show();
	$("#LimonitorLog").removeClass("ui-state-default ui-corner-top").addClass("ui-state-default ui-corner-top ui-tabs-selected ui-state-active"); 
	$("#Limonitor").removeClass("ui-state-default ui-corner-top ui-tabs-selected ui-state-active").addClass("ui-state-default ui-corner-top"); 
}


function onServerNameImg(cellvalue, options, rowObject){
	var str="";
	str ='<img  src="/Monitor/Images/serverName.png" alt="' + rowObject.serverName + '" />';
	return str;
}

function makeTableAgent(){
	$("#templateTable").html("");
	$.ajax({
		url :'agent_getAbNormalByParamByPage.action',
		type : 'POST',
		async:false,
		error : function() {
			hAlert( '初始化消息来源失败！');
		},
		success : function(result) {
			var tab="";
			if(result==""){
				tab+='<tr align="center"><td colspan="4" width="660px">没有服务器处于监控中</td><tr>';
			}else{
				var resultObj=eval(result);
				tab+="<tr>";
				for(var i=0;i<resultObj.list.length;i++){
					var obj=resultObj.list[i];
					tab+="<td  style='text-align:center'> <img src='"+imagePath(obj.status)+"'></td>";
				}
				tab+="</tr>";
				tab+="<tr style='height:30px'>";
				for(var i=0;i<resultObj.list.length;i++){
					var obj=resultObj.list[i];
					tab+="<td  style='text-align:center'>"+obj.serverIp+"</td>";
				}
				tab+="</tr>";
				tab+="<tr style='height:30px'>";
				for(var i=0;i<resultObj.list.length;i++){
					var obj=resultObj.list[i];
					tab+="<td  style='text-align:center'>"+obj.serviceName+"</td>";
				}
				tab+="</tr>";
				tab+="<tr style='height:30px'>";
				for(var i=0;i<resultObj.list.length;i++){
					var obj=resultObj.list[i];
					tab+="<td  style='text-align:center'>"+obj.status+"</td>";
				}
				tab+="</tr>";
		}
		$("#templateTable").append(tab);
		}});
}

function imagePath(status){
	var str="";
	if(status=='正常')
		str="/Monitor/Images/usual.gif";
	else if(status=="不正常")
		str="/Monitor/Images/unusual.gif";
	else
		str="/Monitor/Images/dead2.gif";
	return str;
		
}

function ErrorCH(cellvalue, options, rowObject){
	var p = rowObject.errorType;
	var str=rowObject.errorTypeStr;
	if(p=='0')
		return '<font color="blue">'+str+'</font>';
	else if(p=='-1'){
		return '<font color="red">'+str+'</font>';
	}
	else
		return str;
};
