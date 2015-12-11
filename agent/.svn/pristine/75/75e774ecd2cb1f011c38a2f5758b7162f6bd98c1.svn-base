$(function(){
	// -----------------资源表格开始grid-------------------
	jQuery("#dataTable").initGrid({
		url :  templateRoot + 'commons/upload_pagelist.action',// 请求的URL地址
		cols : [{
					name : 'attachmentId',
					hidden : true,
					id : true
				},{
					header : '文件名',
					name : 'fileName',	//文件名
					width : 200
				},{
					header : '存储路径',
					name : 'filePath',		//路径
					width : 300
				},  {
					header : '文件大小',
					name : 'fileLength',	  //文件大小
					width : 50,
					formatter:function(v){
						return getFileSize(v);
					}
				},{
					header : '文件类型',
					name : 'mimeType',	//文件类型
					width : 100
				},{
					header : '上传人',
					name : 'uploader',		//上传人
					width : 100
				},{
					header : '上传时间',
					name : 'uploadTime',	 //上传时间
					width : 120,
					defaultsort : true
				}

		]
	});
	getFileSize = function(fileByteSize){//返回文件大中，KB或MB
		var byteSize = Math.round(fileByteSize / 1024 * 100) * .01;					                        
		var suffix = 'KB';			
		if (byteSize > 1000) {
			byteSize = Math.round(byteSize *.001 * 100) * .01;
			suffix = 'MB';
		}
		var sizeParts = byteSize.toString().split('.');
		if (sizeParts.length > 1) {
			byteSize = sizeParts[0] + '.' + sizeParts[1].substr(0,2);
		} else {
			byteSize = sizeParts[0];
		}														
		return byteSize + suffix;
	}

	$("#fromDate").datetime({
    	dateFmt:'yyyy年MM月dd日 HH:mm:ss',//日期时间格式，默认为"2011-09-13"
    	skin:'ext',//风格，默认为"default"；可以为"blue","ext","green","red"
    	width:'140px',//宽度，默认为100px
    	height:'30px'//高度，默认为20px
	});
	$("#toDate").datetime({
    	dateFmt:'yyyy年MM月dd日 HH:mm:ss',//日期时间格式，默认为"2011-09-13"
    	skin:'ext',//风格，默认为"default"；可以为"blue","ext","green","red"
    	width:'140px',//宽度，默认为100px
    	height:'30px'//高度，默认为20px
	});
	//在列表上方的工具栏里放增删改查按钮,自定义放增删改查
	//---------删除---------//
	$("#deleteB").click(function() {
				var gr = jQuery("#dataTable").jqGrid('getGridParam',
						'selarrrow');
				if (gr.length == 0) {
					hError('请选择要删除的记录!');
					return;
				}
				var config = {
					url : templateRoot + 'commons/upload_delete.action',
					ids : {
						ids : gr
					}
				}
				deleteByids(config);
	});
	
	//删除记录
	function deleteByids(config) {
        hConfirm('您确定要删除所选记录吗？', null, function(r){
            if (r) {
					$("#dialog-message").dialog('close');
					//return false;
					$.ajax({
								type : "post",
								url : config.url,
								data : jQuery.param(config.ids, true),
								dataType : "json",
								cache : false,
								success : function(data, textStatus) {
									hAlert(data.message);
									if (data.success) {
										$("#dataTable").jqGrid("setGridParam", {  
									        search: true    //将jqGrid的search选项设为true   
									    }).trigger("reloadGrid", [{page:1}]);   //重新载入Grid表格，以使上述设置生效
									} else {
										hError('删除失败');
									}
								}
							});
            	}
			})
	}
	//---------删除结束---------//

	$("#searchB").click(function() {
				searchDialog();
	})
	
	//查询对话框
	function searchDialog(){
		// 窗口标题,打开窗口
//		search.dialog("option", "title", "查询").dialog("open");
		$("#dialogsearch").dialog("open");
	};
	//点击对话框中的搜索按钮,提交参数到服务器
	function search(){
		jQuery("#dataTable").searchGrid($("#searchForm").formToObject());
	    $("#dialogsearch").dialog("close"); 
	};
	//配置搜索对话框
	$("#dialogsearch").dialog({
		autoOpen : false,
		modal : true, // 设置对话框为模态（modal）对话框
		resizable : true,
		width : 550,
		height: 150,
		buttons : { // 为对话框添加按钮
			"查询" : function() {
				search()
			},
			"取消" : function() {
				$("#dialogsearch").dialog("close")
			}
		}
	});
	//--------检索功能结束-----------//	
})
