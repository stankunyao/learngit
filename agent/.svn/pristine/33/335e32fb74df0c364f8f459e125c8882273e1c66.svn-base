

blockShow = function(displayBox,top,left){
	if(!top){
		top = ($(window).height() - 120) /2;
	}
	if(!left){
		left= ($(window).width() - 120) /2;
	}
	$.blockUI({ 
        message: displayBox, 
        css: { 
            top:  top + 'px', 
            left: left + 'px',
            width: '120px' 
        }
    });
};
	
blockClose=function(msg){
	$.unblockUI();
	if(msg){
		blockUIOver(msg);
	}
};
	
blockUIOver=function(msg){
	$.blockUI({
		message: msg = '<h2>'+msg+'</h2>', 
		timeout: 1200
	});
};