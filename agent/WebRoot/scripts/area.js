var areaCurrNode, areaTrees = function(areaTreeContent, callback, type){
	if(!areaTreeContent) areaTreeContent = $("body").append("<ul></ul>");
	
	var show_type = type || "";
	
	
	return $(areaTreeContent).tree({
		data:{
			simpleData:{
				enable: true,
				checkable: true
			}
		},
		check : {
			chkStyle : 'checkbox',
			enable: true,
			autoCheckTrigger: true,
			chkboxType: {"Y" : "", "N" : ""}
		},
		async: {
			enable: true,
			url: templateRoot + "zaibei/area_tree.action?type=" + show_type,
			autoParam: ["id"]
		},
		callback: {
			onClick: function(event, treeId, treeNode){
				areaCurrNode = treeNode;
				
				if(typeof callback == 'function') {
					callback.call(this, treeNode, treeId, event);
				}
			}
		}
	});
};
var getCheckedIds = function() {
	var zTree = $.fn.zTree.getZTreeObj("areaTree");
	var nodes = zTree.getCheckedNodes(true);
	var v = new Array();
	
	for (var i=0, l=nodes.length; i<l; i++) {
		v.push(nodes[i].id);
	}
	return v;
};
var getCheckedNames = function() {
	var zTree = $.fn.zTree.getZTreeObj("areaTree");
	var nodes = zTree.getCheckedNodes(true);
	
	var nameArr = "";
	for (var i=0, l=nodes.length; i<l; i++) {
		nameArr = nameArr + "," + nodes[i].name;
	}

	//alert(nameArr);
	return nameArr.substr(1);	
}

// -------------------------------------------------------------------------------------
var areaSelectCurrNode, areaSelect = function(areaTreeContent, callback, type){
	if(!areaTreeContent) areaTreeContent = $("body").append("<ul></ul>");
	var show_type = type || "";
	
	//alert(templateRoot);
	return $(areaTreeContent).tree({
		data:{
			simpleData:{
				enable: true,
				checkable: true
			}
		},
		check : {
			chkStyle : 'radio',
			enable: true,
			autoCheckTrigger: true,
			chkboxType: {"Y" : "", "N" : ""},
			radioType : 'all'
		},
		async: {
			enable: true,
			url: templateRoot + "zaibei/area_tree.action?type=" + show_type,
			autoParam: ["id"]
		},
		callback: {
			onClick: function(event, treeId, treeNode){
				areaSelectCurrNode = treeNode;
				
				if(typeof callback == 'function') {
					callback.call(this, treeNode, treeId, event);
				}
			}
		}
	});
};
var getCheckedNode = function() {
	var zTree = $.fn.zTree.getZTreeObj("areaRadio");
	var nodes = zTree.getCheckedNodes(true);
	if(nodes.length > 0) {
		return nodes[0];
	} else {
		return "";
	}
};
