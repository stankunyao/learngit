<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0014)about:internet -->
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en"> 
    <!-- 
    Smart developers always View Source. 
    
    This application was built using Adobe Flex, an open source framework
    for building rich Internet applications that get delivered via the
    Flash Player or to desktops via Adobe AIR. 
    
    Learn more about Flex at http://flex.org 
    // -->
    <%
    	String mapConfigXml = request.getParameter("mapConfigXml");
     %>
    <head>
        <title></title>
        <meta name="google" value="notranslate" />         
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- Include CSS to eliminate any default margins/padding and set the height of the html element and 
             the body element to 100%, because Firefox, or any Gecko based browser, interprets percentage as 
             the percentage of the height of its parent container, which has to be set explicitly.  Fix for
             Firefox 3.6 focus border issues.  Initially, don't display flashContent div so it won't show 
             if JavaScript disabled.
        -->
        <style type="text/css" media="screen"> 
            html, body  { height:100%; }
            body { margin:0; padding:0; overflow:auto; text-align:center; 
                   background-color: #ffffff; }   
            object:focus { outline:none; }
            #flashContent { display:none; }
        </style>
        
        <!-- Enable Browser History by replacing useBrowserHistory tokens with two hyphens -->
        <!-- BEGIN Browser History required section -->
        <link rel="stylesheet" type="text/css" href="history/history.css" />
        <script type="text/javascript" src="history/history.js"></script>
        <!-- END Browser History required section -->  
            
        <script type="text/javascript" src="swfobject.js"></script>
        <script type="text/javascript" src="harmonycommon.js"></script>
        <script type="text/javascript">
        	var mapConfigXml = "<%=mapConfigXml %>";
        	//如果没有传递mapConfigXml,就使用HarmonyCommon默认的值
        	if(mapConfigXml != "" && mapConfigXml != "null")
        	{
        		HarmonyCommon.mapConfigXml = mapConfigXml;
        	}
            // For version detection, set to min. required Flash Player version, or 0 (or 0.0.0), for no version detection. 
            var swfVersionStr = "10.2.0";//指定flash版本号,即正常播放该 flash 的最低版本
            // To use express install, set to playerProductInstall.swf, otherwise the empty string. 
            var xiSwfUrlStr = "playerProductInstall.swf";//版本低于当前要求时,执行该 swf 文件,跳转到官方下载最新版本的 flash 插件（可选）
            var flashvars = {};//json 对象，用来为 flash 传递初始化信息
            var params = {};//flash 设置，是否显示按钮、是否全屏、是否允许访问 JS、背景颜色、窗口模式等
            //Flash的可选param元素
            params.quality = "high";//指定在应用程序回放期间使用的消除锯齿级别。
            params.bgcolor = "#ffffff";//背景色
            params.allowscriptaccess = "always";//使用 allowscriptaccess 使 Flash 应用程序可与承载它的 HTML 页通信。
            params.allowfullscreen = "true";//允许全屏
            
            //可以使用 Internet Explorer 4.0 中的透明 Flash 内容、绝对定位和分层显示的功能;
			//Opaque使应用程序隐藏页面上位于它后面的所有内容。 
			params.wmode = "opaque"; 
			
            var attributes = {};//设置嵌入 flash 完成时 object 标签的 id，name等属性
            attributes.id = "MapJsp";
            attributes.name = "MapJsp";
            attributes.align = "middle";
            //swfobject是在swfobject.js中定义的,通过embedSWF方法可以在jsp中直接修改flash
            swfobject.embedSWF(
                "MapJsp.swf", "flashContent", 
                "100%", "100%", 
                swfVersionStr, xiSwfUrlStr, 
                flashvars, params, attributes);
            // JavaScript enabled so display the flashContent div in case it is not replaced with a swf object.
            //设置显示flash的div的css样式
            swfobject.createCSS("#flashContent", "display:block;text-align:left;");
        </script>
    </head>
    <body>
        <!-- SWFObject's dynamic embed method replaces this alternative HTML content with Flash content when enough 
             JavaScript and Flash plug-in support is available. The div is initially hidden so that it doesn't show
             when JavaScript is disabled.
        -->
        <div id="flashContent">
        </div>
        
        <!-- 如果浏览器不支持javascript时,就用下面的内容来代替 -->
        <noscript>
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="100%" height="100%" id="MapJsp">
                <param name="movie" value="MapJsp.swf" />
                <param name="quality" value="high" />
                <param name="bgcolor" value="#ffffff" />
                <param name="allowScriptAccess" value="always" />
                <param name="allowFullScreen" value="true" />
                <!--[if !IE]>-->
                <object type="application/x-shockwave-flash" data="MapJsp.swf" width="100%" height="100%">
                    <param name="quality" value="high" />
                    <param name="bgcolor" value="#ffffff" />
                    <param name="allowScriptAccess" value="always" />
                    <param name="allowFullScreen" value="true" />
                <!--<![endif]-->
                <!--[if gte IE 6]>-->
                    <p> 
                        Either scripts and active content are not permitted to run or Adobe Flash Player version
                        10.2.0 or greater is not installed.
                    </p>
                <!--<![endif]-->
                    <a href="http://www.adobe.com/go/getflashplayer">
                        <img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash Player" />
                    </a>
                <!--[if !IE]>-->
                </object>
                <!--<![endif]-->
            </object>
        </noscript>  
   </body>
</html>
