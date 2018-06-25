var Common = function () {
	
    return {
        // 初始化各个函数及对象
        init: function () {

        },
        
        strIsNotEmpty: function(str) {
        	if (str != null && str != undefined && str != '') { 
        		return true;
        	}
        	return false;
        },
        
        // 时间戳转换成指定日期格式
        formatTime: function(time, format) {
	    	var t = new Date(time);
    	    var tf = function(i){return (i < 10 ? '0' : '') + i};
    	    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
    	        switch(a){
    	            case 'yyyy':
    	                return tf(t.getFullYear());
    	                break;
    	            case 'MM':
    	                return tf(t.getMonth() + 1);
    	                break;
    	            case 'mm':
    	                return tf(t.getMinutes());
    	                break;
    	            case 'dd':
    	                return tf(t.getDate());
    	                break;
    	            case 'HH':
    	                return tf(t.getHours());
    	                break;
    	            case 'ss':
    	                return tf(t.getSeconds());
    	                break;
    	        }
    	    })
	    }    
	    
	    
    };

}();

jQuery(document).ready(function() {
	Common.init();
});