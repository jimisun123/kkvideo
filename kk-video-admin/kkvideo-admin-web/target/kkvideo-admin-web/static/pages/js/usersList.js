// 定义举报列表对象
var List = function () {
	
    // 举报列表
	var handleList = function() {
    	
		// 上下文对象路径
		var hdnContextPath = $("#hdnContextPath").val();
		var apiServer = $("#apiServer").val();
		var bgmServer = $("#bgmServer").val();
		var apiSourceServer = $("#apiSourceServer").val();

		var jqGrid = $("#usersList");  
        jqGrid.jqGrid({  
            caption: "短视频用户列表",  
            url: hdnContextPath + "/users/list.action",  
            mtype: "post",  
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
            datatype: "json",  
            colNames: ['ID', '头像', '用户名', '昵称', '粉丝数', '关注数', '获赞数'],  
            colModel: [  
                { name: 'id', index: 'id', width: 30, sortable: false, hidden: false },  
                { name: 'faceImage', index: 'username', width: 50, sortable: false,
                	formatter:function(cellvalue, options, rowObject) {
                		var src = apiSourceServer + cellvalue;
                		var img = "<img src='" + src + "' width='120'></img>"
			    		return img;
			    	}  
                },
                { name: 'username', index: 'password', width: 30, sortable: false },
                { name: 'nickname', index: 'nickname', width: 30, sortable: false },
                { name: 'fansCounts', index: 'age', width: 20, sortable: false },
                { name: 'followCounts', index: 'sexValue', width: 20, sortable: false },
                { name: 'receiveLikeCounts', index: 'province', width: 20, sortable: false, hidden: false }
            ],  
            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: 500,				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#usersListPager",		// 分页控件的id  
            subGrid: false				// 是否启用子表格
        }).navGrid('#usersListPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.usersList_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        
        // 条件查询所有用户列表
        $("#searchUserListButton").click(function(){
        	var searchUsersListForm = $("#searchUserListForm");
        	jqGrid.jqGrid().setGridParam({ 
        		page: 1,
                url: hdnContextPath + "/users/list.action?" + searchUsersListForm.serialize(),
            }).trigger("reloadGrid");
        });
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	handleList();
        }

    };

}();


jQuery(document).ready(function() {
	List.init();
});