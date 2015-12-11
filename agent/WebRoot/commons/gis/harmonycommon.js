var HarmonyUtils = {
	getPlottingTargetId:function()
	{
		return HarmonyCommon.plottingTargetId;
	},
	getPlottingTargetName:function()
	{
		return HarmonyCommon.plottingTargetName;
	},
	getUserId:function()
	{
		return "test";
	},
	getUserId:function()
	{
		return "test";
	}
};
var HarmonyCommon = {
	// 定义swf文件id
	flashMapId:"MapJsp",
	// 标绘的目标事件id	
	plottingTargetId:"_",
	plottingTargetName:"_",
	//
	currentTargetId:"",
	//
	currentTargetName:"",
	
	// 地图xml配置
	mapConfigXml:"mapXml.xml",
	// 地图全局变量
	MapApp:null,
	// 高亮图标
	highlightImagePath:"image/centric.gif",
	// 决策标绘时设置的默认值
	defaultColor:"#FF0000",
	defaultLineWidth:2,
	defaultLineHashArrow:1,
	defaultImageWidth:25,
	defaultImageHeight:25,
	defaultImagePath:"image/centric.gif",
	// 焦点位置
	centerx:115.31298,
	centery:39.2294,
	// 清除时除外的类型
	excludeType:"GuardAccident",
	mapInitCompleteCallbackHandler : null,
	// 定义地图初始化完成后的回调函数，没有参数
	mapInitCompleteCallback : function(){
	    HarmonyCommon.MapApp=document.getElementById(HarmonyCommon.flashMapId);

	    var polygonStr = ranges;
	    alert("polygonStr="+polygonStr);
	    alert("colour=" + colour);
	    if(polygonStr){
	    	var array = polygonStr.split(",");
	    	if(array.length > 0){
    	   		var arr_ = [];
    	        for(var i=0; i<array.length; i++){
    	        	arr_[i] = eval("(" + array[i] + ")");
    	        }
    	        var polygon = {
    	                id:"polygon_"+new Date().getTime(), points: arr_,
    	                lineColor:"#FFFF00", lineWidth:0, fillColor:colour, opacity:0.5
    	            };
    	        HarmonyCommon.addPolygon(polygon);
    		}
	    }
	    
	    
	    //如果mapInitCompleteCallbackHandler是function类型,就执行这个方法,这里定义为null
		if(typeof  HarmonyCommon.mapInitCompleteCallbackHandler == "function")
		{
			HarmonyCommon.mapInitCompleteCallbackHandler();
		}
	},
	getRouteAnalystUrl:function()
	{
		return "http://192.168.3.124:8090/iserver/services/transportationAnalyst-sichuan/rest/networkanalyst/NetDT_3@sichuan/path.json";
	},
	// 获取配置xml
	getMapConfigXml:function()
	{
		return HarmonyCommon.mapConfigXml;
	},
	// 定义地图选点完成后的回调函数，参数是({x,y})对象
	drawPointCompleteCallback :  function(point,config)
	{
		
	},
	// 单击图标后触发
	markClickCallback : function(obj)
	{
		if(HarmonyCommon.clickCallbacks[obj["id"]]){
			HarmonyCommon.clickCallbacks[obj["id"]](obj);
		}
	},
	// 单击图标后触发
	infoWindowButtonClickCallback : function(obj,btnName)
	{
		if(HarmonyCommon.infoWindowButtonClickCallbacks[obj["id"]+btnName]){
			HarmonyCommon.infoWindowButtonClickCallbacks[obj["id"]+btnName](obj,btnName);
		}
	},
	userDrawEndCallback:null,
	// 执行回调过程
	mapInitCompleteHandler: function(){
		if(HarmonyCommon.mapInitCompleteCallback != null)
			HarmonyCommon.mapInitCompleteCallback();
	},
	routeAnalysisComplete : function(id,obj)
	{
		if(HarmonyCommon.routeAnalysisCallbacks[id]){
			HarmonyCommon.routeAnalysisCallbacks[id](obj);
		}
	},
	drawEndCallback:function(obj)
	{
		if(typeof HarmonyCommon.drawEndCallbacks == "function")
		{
			HarmonyCommon.drawEndCallbacks(obj);
		} 
	},
	clickCallbacks:{},
	infoWindowButtonClickCallbacks:{},
	routeAnalysisCallbacks:{},
	drawEndCallbacks:null,
	plottingSavedHandler:function(plottingId,plottingName)
	{
		if(HarmonyCommon.plottingSavedCallback != null)
		{
			HarmonyCommon.plottingSavedCallback(plottingId,plottingName);
		}
	},
	plottingSavedCallback:function(plottingId,plottingName){
//		alert("标绘保存："+plottingId+" 名称："+plottingName);
	},
	plottingDeleteHandler:function(plottingId,plottingName)
	{
		if(HarmonyCommon.plottingDeleteCallback != null)
		{
			HarmonyCommon.plottingDeleteCallback(plottingId,plottingName);
		}
	},
	plottingDeleteCallback:function(plottingId){
//		alert("标绘删除："+plottingId);
	}
};

/**
	添加点
	{id:,x:,y:,image:,type,width,height,title,html,buttons:[{btnName:,callback:}],attributes}
**/
HarmonyCommon.addMarker = function(marker,callback)
{
	//buttons现在被注释了,所以不会执行if判断,直接跳转到最后两句话
	if(marker["buttons"])
	{
		for(var i=0; i<marker["buttons"].length; i++)
		{
			if("-" == marker["buttons"][i])
				continue;
			HarmonyCommon.infoWindowButtonClickCallbacks[marker["id"]+i] = marker["buttons"][i]["callback"];
			marker["buttons"][i]["callback"] = i+"";
		}
	}
	HarmonyCommon.MapApp.addMarker(marker);
	HarmonyCommon.clickCallbacks[marker["id"]] = callback;
};

/**
	添加点
	{id:,x:,y:,image:,type,width,height,title,html,buttons:[{btnName:,callback:}],attributes}
**/
HarmonyCommon.addBarrierMarker = function(marker,callback)
{
	if(marker["buttons"])
	{
		for(var i=0; i<marker["buttons"].length; i++)
		{
			if("-" == marker["buttons"][i])
				continue;
			HarmonyCommon.infoWindowButtonClickCallbacks[marker["id"]+i] = marker["buttons"][i]["callback"];
			marker["buttons"][i]["callback"] = i+"";
		}
	}
	HarmonyCommon.MapApp.addBarrierMarker(marker);
	HarmonyCommon.clickCallbacks[marker["id"]] = callback;
};

/**
	添加多边形
	{id:,points:[{x:,y:}],lineColor,lineWidth,fillColor,opacity}
**/
HarmonyCommon.addPolygon = function(polygon,callback)
{
    var points = [];
    for (var i = 0; polygon.points && (i < polygon.points.length); i++) {
        points.push(polygon.points[i]);
    }
    polygon.points = points;
    alert(HarmonyCommon.MapApp);
	HarmonyCommon.MapApp.addPolygon(polygon);
	HarmonyCommon.clickCallbacks[polygon["id"]] = callback;
};


/**
	添加线
	{id:,points:[{x:,y:}],lineColor,lineWidth,opacity}
**/
HarmonyCommon.addPolyline = function(polyline,callback)
{
    var points = [];
    for (var i = 0; polyline.points && (i < polyline.points.length); i++) {
        points.push(polyline.points[i]);
    }
    polyline.points = points;
	HarmonyCommon.MapApp.addPolyline(polyline);
	HarmonyCommon.clickCallbacks[polyline["id"]] = callback;
};

/**
	通过id删除一个
**/
HarmonyCommon.removeOverlayById = function(overlayId)
{
	HarmonyCommon.MapApp.removeOverlayById(overlayId);
};
/**
	清空
**/
HarmonyCommon.clearOverlays = function()
{
	HarmonyCommon.MapApp.clearOverlays();
};

/**
	清空障碍点
**/
HarmonyCommon.clearBarrier = function()
{
	HarmonyCommon.MapApp.clearBarrier();
};

/**
	设置高亮
**/
HarmonyCommon.setMarkerHighlight = function(overlayId,color)
{
	HarmonyCommon.MapApp.setMarkerHighlight(overlayId,color);
};
/**
	移除高亮
**/
HarmonyCommon.removeMarkerHighlight = function(overlayId)
{
	HarmonyCommon.MapApp.removeMarkerHighlight(overlayId);
};
/**
	显示详情信息
**/
HarmonyCommon.showOverlayInfo = function(overlayId)
{
	HarmonyCommon.MapApp.showOverlayInfo(overlayId);
};
/**
	显示详情信息
**/
HarmonyCommon.showOverlayInfoForLayer = function(overlayId,layerId)
{
	HarmonyCommon.MapApp.showOverlayInfoForLayer(overlayId,layerId);
};

/**
	路径分析 {id,paths:[{id:,points},{id,points}]}
**/
HarmonyCommon.routeAnalysis = function(obj,callback)
{
	HarmonyCommon.routeAnalysisCallbacks[obj["id"]] = callback;
	
	var paths = [];
	for(var i=0; i<obj.paths.length ; i++)
	{
		var path = obj.paths[i];
		var newPoints = [];
		for(var j=0 ; j< path.points.length ;j++)
		{
			var point =  path.points[j];
			newPoints.push(point);
		}
		paths.push({id:path.id,points:newPoints});
	}
	obj.paths = paths;
	
	HarmonyCommon.MapApp.routeAnalysis(obj);
};

/**
	修改编辑模式{drawType:}  (polyline,polygon,mappoint)
**/
HarmonyCommon.changeDragMode = function(mode,callback)
{
	HarmonyCommon.drawEndCallbacks = callback;
	HarmonyCommon.MapApp.changeDragMode(mode);
};

/**
	中心对焦
**/
HarmonyCommon.panByPoint = function(centerX,centerY)
{
	HarmonyCommon.MapApp.panByPoint(centerX,centerY);
};
/**
	中心对焦
**/
HarmonyCommon.panByPointAndLevel = function(centerX,centerY,level)
{
	HarmonyCommon.MapApp.panByPointAndLevel(centerX,centerY,level);
};

/**
	缩放位置
**/
HarmonyCommon.panByExtent = function(xmin,ymin,xmax,ymax)
{
	HarmonyCommon.MapApp.panByExtent(xmin,ymin,xmax,ymax);
};

/**
	设置地图标注
**/
HarmonyCommon.setMapLabel = function(mapLabel)
{
	HarmonyCommon.MapApp.setMapLabel(mapLabel);
};
/**
	缩放到指定等级
**/
HarmonyCommon.zoomToLevel = function(level)
{
	HarmonyCommon.MapApp.zoomToLevel(level);
};
/**
	执行功能
**/
HarmonyCommon.executeCommand = function(commandId)
{
	HarmonyCommon.MapApp.executeCommand(commandId);
};
/**
	更新图标
**/
HarmonyCommon.updateMarker = function(marker)
{
	HarmonyCommon.MapApp.updateMarker(marker);
};
/**
	更新线
**/
HarmonyCommon.updatePolyline = function(polyline)
{
    var points = [];
    for (var i = 0; polyline.points && (i < polyline.points.length); i++) {
        points.push(polyline.points[i]);
    }
    polyline.points = points;
	HarmonyCommon.MapApp.updatePolyline(polyline);
};
/**
	创建多边形箭头点
**/
HarmonyCommon.createArrowPolygon = function(ps)
{
    var points = [];
    for (var i = 0; ps && (i < ps.length); i++) {
        points.push(ps[i]);
    }
	return HarmonyCommon.MapApp.createArrowPolygon(points);
};

/**
 * 取圆周上的点集合
 * @param point
 * @param radius
 * @return
 */
HarmonyCommon.getCircleLinePoint = function (point,radius)
{
	var points = [];
	for(var i=0; i<361; i=i+1)
	{
		points.push(HarmonyCommon.getCirclePoint(i/180*Math.PI,radius,point.x,point.y));
		points.push(HarmonyCommon.getCirclePoint((i+0.5)/180*Math.PI,radius,point.x,point.y));
	}
	return points;
};
/**
 * 经纬度转换成mokato
 */
HarmonyCommon.lonLatToMeters = function (lon,lat)
{
	var originShift = 2 * Math.PI * 6378137/2;
	var mx = lon * originShift / 180;
	var my = Math.log(Math.tan((90 + lat) * Math.PI / 360)) / (Math.PI / 180);
	my=my * originShift / 180;
	return {x:mx, y:my};
};
/**
 * 转换成经纬度
 */
HarmonyCommon.metersToLonLat = function (mx,my)
{
	var originShift = 2 * Math.PI * 6378137/2;
	var lon =(mx / originShift) * 180.0;
	var lat =(my / originShift) * 180.0;
	lat=180 / Math.PI * (2 * Math.atan(Math.exp(lat * Math.PI / 180.0)) - Math.PI / 2.0);
	return {x:lon, y:lat};
};
/**
 * 根据角度，获取圆形上的一个点坐标
 * @param angle
 * @param radius
 * @param x
 * @param y
 * @return
 */
HarmonyCommon.getCirclePoint = function(angle,radius,x,y)
{
	var circlePointX = x+Math.cos(angle)*radius;
	var circlePointY = y + Math.sin(angle)*radius;
	var endPoint = new Point(circlePointX,circlePointY);
	return endPoint;
};

/**
	创建多边形箭头点
**/
HarmonyCommon.hideInfoWindow = function()
{
	return HarmonyCommon.MapApp.hideInfoWindow();
};

/**
	计算点位置
**/
HarmonyCommon.calPointByLineAndDistance = function(point1,point2,percent)
{
	var returnPoint = {x:0,y:0};
	returnPoint.x = point1.x+percent*(point2.x-point1.x);
	returnPoint.y = point1.y+percent*(point2.y-point1.y);
	return returnPoint;
};

/**
	计算两点距离
**/
HarmonyCommon.calDistanceByTowPoint = function(point1,point2)
{
	return Math.pow(Math.pow(point1.x-point2.x,2)+Math.pow(point1.y-point2.y,2),0.5);
};
/**
	闪烁图标
**/
HarmonyCommon.refreshOverlay = function(overlayId)
{
	return HarmonyCommon.MapApp.refreshOverlay(overlayId);
};
/**
	移除闪烁效果
**/
HarmonyCommon.removeRefreshOverlay = function(overlayId)
{
	return HarmonyCommon.MapApp.removeRefreshOverlay(overlayId);
};
/**
	移除所有闪烁效果
**/
HarmonyCommon.removeAllRefresh = function()
{
	return HarmonyCommon.MapApp.removeAllRefresh();
};
/**
	增加统计图标
*/
HarmonyCommon.addStatisticsMarker = function(marker)
{
	var tempArray = [];
	for(var i=0; i<marker.chart.datas.length; i++)
	{
		tempArray.push(marker.chart.datas[i]);
	}
	marker.chart.datas = tempArray;
	tempArray = [];
	for(var i=0; i<marker.chart.yFields.length; i++)
	{
		tempArray.push(marker.chart.yFields[i]);
	}
	marker.chart.yFields = tempArray;
	
	HarmonyCommon.MapApp.addStatisticsMarker(marker);
};

/**
 * 清除某一个图层的数据
 */ 
HarmonyCommon.clearByLayerId = function(layerId)
{
	HarmonyCommon.MapApp.clearByLayerId(layerId);
};

/**
 * 在指定图层使用聚集操作{backgroundAlphas:"0.5,1.0",backgroundColors:"0x00FF00,0xFF0000",sizes:"20,30",weights:"30,100",minGraphicCount:5}
 */ 
HarmonyCommon.useClusterByLayerId = function(config,layerId)
{
	HarmonyCommon.MapApp.useClusterByLayerId(config,layerId);
};

/**
 * 创建一个新的图层
 */ 
HarmonyCommon.createLayerById = function(layerId)
{
	HarmonyCommon.MapApp.createLayerById(layerId);
};

/**
 * 删除一个图层
 */ 
HarmonyCommon.removeLayerById = function(layerId)
{
	HarmonyCommon.MapApp.removeLayerById(layerId);
};

/**
 * 从指定图层移走一个图标
 */ 
HarmonyCommon.removeMarkerByIdAndLayerId = function(markerId,layerId)
{
	HarmonyCommon.MapApp.removeMarkerByIdAndLayerId(markerId,layerId);
};

/**
 * 向指定的图层增加图标
 */ 
HarmonyCommon.addMarkerByLayerId = function(marker,layerId,callback)
{
	if(marker["buttons"])
	{
		for(var i=0; i<marker["buttons"].length; i++)
		{
			if("-" == marker["buttons"][i])
				continue;
			HarmonyCommon.infoWindowButtonClickCallbacks[marker["id"]+i] = marker["buttons"][i]["callback"];
			marker["buttons"][i]["callback"] = i+"";
		}
	}
	HarmonyCommon.MapApp.addMarkerByLayerId(marker,layerId);
	HarmonyCommon.clickCallbacks[marker["id"]] = callback;
};

//文本
function Title(title,fontSize,unKnow,fontType,color){
	this.id="title"+new Date().getTime();
	this.point=null;
	this.titleText=title;
    this.fontSize=fontSize;
    this.unKonw=unKnow;
	this.fontType=fontType;
	this.color=color;
	this.attributes=null;
	this.clickCallBack=null;
	this.type="title";
	this.addListener=function(eventName,callBack){
		if(eventName=="click"){
			this.clickCallBack=callBack;
		}
	};
};
//点
function Point(x,y){
	this.x=x;
	this.y=y;
};
//图标
function Marker(point,icon,title){
	this.id="marker"+new Date().getTime();
	this.point=point;
	this.icon=icon;
	this.title=title;
	this.zIndex=0;
	this.type="marker";
	this.attributes;
	this.clickCallBack=null;
};
//图片类
function Icon(imagePath,width,height){
	this.image=imagePath;
	this.width=width;
	this.height=height;
};
//圆
function Circle(centerPoint,radius,lineColor,lineWidth,opacity,fillColor){
	this.id="circle"+new Date().getTime();
	this.center=centerPoint;
	this.point=centerPoint;
	this.radius=radius;
	this.lineColor=lineColor;
	this.clickCallBack=null;
	this.lineWidth=lineWidth;
	this.fillColor=fillColor;
	this.opacity=opacity;
	this.type="circle";
};
//线条
function Polyline(points,lineColor,lineWidth,opacity,arrow){
	this.id="polyline"+new Date().getTime();
	this.points=points;
	this.lineColor=lineColor;
	this.lineWidth=lineWidth;
	this.opacity=opacity;
	this.arrow=arrow;
	this.type="polyline";
	this.clickCallBack=null;
};
//多边形
function Polygon(points,lineColor,lineWidth,opacity,fillColor){
	this.id="polygon"+new Date().getTime();
	this.points=points;
	this.lineColor=lineColor;
	this.opacity=opacity;
	this.fillColor=fillColor;
	this.type="polygon";
	this.clickCallBack=null;
};
