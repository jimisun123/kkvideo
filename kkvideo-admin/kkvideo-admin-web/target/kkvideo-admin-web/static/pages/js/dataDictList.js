// 删除数据字典
var deleteDataDict = function(dataDictId) {
	
	var hdnContextPath = $("#hdnContextPath").val();
	
	swal({
		  title: "提醒",
		  text: "确认删除?",
		  type: "warning",
		  confirmButtonText: "确认!",
		  confirmButtonClass: "btn-warning",
		  showCancelButton: true,
		  cancelButtonText: "噢!等等...",
		  confirmButtonColor: "#DD6B55",  
		  closeOnConfirm: false
	}, function(isConfirm) {
		if (isConfirm) {
			App.blockUI();
			
			$.ajax({
		    	url: $("#hdnContextPath").val() + "/dataDict/delete.action",
		    	type: "POST",
		    	async: false,
		    	data: {"ddId": dataDictId},
		    	success: function(data) {
		            if(data.status == 200 && data.msg == "OK") {
		            	App.unblockUI();
		            	SweetAlert.success("删除成功！");
		            	
		            	// 刷新jqgrid
		            	reloadDataDictGrid();
		            } else {
		            	App.unblockUI();
		            	console.log(JSON.stringify(data));
		            }
		    	},
		        error: function (response, ajaxOptions, thrownError) {
		        	App.unblockUI();
		        	Error.displayError(response, ajaxOptions, thrownError);                
		        }
		    });
			
		}
	});
	
}

// 重新刷新grid
var reloadDataDictGrid = function() {
	var jqGrid = $("#jqGridDataDictList");  
	var hdnContextPath = $("#hdnContextPath").val();
	jqGrid.jqGrid('setGridParam',{datatype:'json'}).setGridParam({ 
		page: 1,
        url: hdnContextPath + "/dataDict/getDataDictList.action",
    }).trigger("reloadGrid");
}

// 重新渲染modal
function renderModal() {
	// 重新渲染ajax modal
	Common.openAjaxModal('a[name="ajaxModifyDataDictLink"]', '#ajax-modifyDataDict-modal');
} 

// 数据字典对象
var DataDictList = function () {
	
    // 数据字典列表
	var handleDataDictList = function() {
    	
		var hdnContextPath = $("#hdnContextPath").val();
		
		var jqGrid = $("#jqGridDataDictList");  
        jqGrid.jqGrid({  
            caption: "数据字典列表",  
            url: hdnContextPath + "/dataDict/getDataDictList.action",  
            mtype: "post",  
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
            datatype: "json",  
            colNames: ['ID', '字典名称', '字典码', 'key', 'value', '是否显示', '操作'],  
            colModel: [  
                { name: 'id', index: 'id', width: 60, sortable: false, hidden: true },  
                { name: 'typeName', index: 'typeName', width: 30, sortable: false },
                { name: 'typeCode', index: 'typeCode', width: 30, sortable: false },
                { name: 'ddkey', index: 'ddkey', width: 30, sortable: false },
                { name: 'ddvalue', index: 'ddvalue', width: 30, sortable: false },
                { name: 'isShow', index: 'isShow', width: 30, sortable: false },
                {
                	width:50, sortable: false,
			    	formatter:function(cellvalue, options, rowObject) {
			    		
			    	var ddId = rowObject.id;
			    	
			    	var btnModify = '<a class="btn btn-outline blue-chambray" id="ajaxModifyDataDictLink" name="ajaxModifyDataDictLink" data-url="' + hdnContextPath + '/dataDict/modifyDataDict.action?ddId=' + ddId + '" data-toggle="modal" style="padding: 1px 3px 1px 3px;">编辑</a>';
			    	
			    	var btnDelete = '<button class="btn btn-outline blue-chambray" id="" onclick=deleteDataDict("' + ddId + '") style="padding: 1px 3px 1px 3px;">删除</button>';
			    	
			    	return btnModify + btnDelete}  // success
                }
            ],  
            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
//            multiselect: true,  		// 定义是否可以多选
            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
//            width: 900,
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: 500,				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#jqGridDataDictPager",		// 分页控件的id  
            subGrid: false,				// 是否启用子表格
            gridComplete: renderModal
        }).navGrid('#jqGridDataDictPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.jqGridDataDictList_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleDataDictList();
        	
        }

    };

}();


jQuery(document).ready(function() {
	DataDictList.init();
});