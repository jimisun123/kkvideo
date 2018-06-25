var Error = function () {
    
    return {
        // 初始化各个函数及对象
        init: function () {

        },
        
    	// 显示或者记录错误
	    displayError: function(response, ajaxOptions, thrownError) {
	    	if (response.status == 404) {// 页面没有找到
	    		SweetAlert.error("404: 找不到页面...");
            } else if (response.status == 401) {// session过期
            	SweetAlert.errorSessionExpire();
            } else if (response.status == 507) {// 用户访问次数太频繁 
            	SweetAlert.error("您的访问次数太频繁, 请过一会再试...");
            } else {//其他错误
            	SweetAlert.error("500: 服务端发生错误..."); 
            }
            console.log(thrownError);
	    }

    };

}();

jQuery(document).ready(function() {
	Error.init();
});