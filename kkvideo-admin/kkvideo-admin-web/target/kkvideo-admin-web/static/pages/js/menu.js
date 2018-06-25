var Menu = function () {

    
    return {
        // 初始化各个函数及对象
        init: function () {

        },
    
    	// 动态加载页面
	    ajaxLoadPage: function(url) {
	    	$(".page-content").load(url);
	    }

    };

}();

jQuery(document).ready(function() {
	Menu.init();
});