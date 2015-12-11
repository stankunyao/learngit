<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
	<%@include file="/commons/common_include.jsp"%>    
    <title>附件管理</title>
    <script src="${pageContext.request.contextPath}/commons/attachment/js/attachment.js"></script>
  </head>
  
<body class="borderlayout">
	<div region="center">
		<div class="navbar">
		  <h1>当前操作：</h1>
		  <h2>附件管理</h2>
		</div>
		
		<div class="toolbar"> 
			<button id="searchB">查询</button>
			<button id="deleteB">删除</button>
		</div>
		  
		<div class="title_level1">附件列表</div>
		
		<table id="dataTable"></table>
	</div>

	<div id="dialogsearch" title="查询附件">
		<form name="searchForm" id="searchForm">
			<fieldset>
				<div id="dialogarea">
					<table style="width: 100%;" border="0" cellspacing="1"
						cellpadding="0">
						<tr>
							<td><div id="inputname">文件名：</div>
							</td>
							<td><div id="inputvalue">
									<input type="text" id="fileName" name="fileName" size="20" />
								</div>
							</td>
							<td><div id="inputname">上传人：</div>
							</td>
							<td><div id="inputvalue">
									<input type="text" id="uploader" name="uploader" size="20" />
								</div>
							</td>
						</tr>
						<tr>
							<td><div id="inputname">上传时间：</div>
							</td>
							<td colspan="3"><div id="inputvalue">
									<input type="text" id="fromDate" name="fromDate" size="10"
										readonly="readonly" /> 至 <input
										type="text" id="toDate" name="toDate" size="10"
										readonly="readonly" />
								</div></td>
						</tr>
					</table>

				</div>
			</fieldset>
		</form>
	</div>

</body>
</html>
