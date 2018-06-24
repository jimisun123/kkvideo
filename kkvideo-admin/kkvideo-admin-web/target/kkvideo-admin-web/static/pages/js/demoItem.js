var reloadItemGrid = function() {
	var jqGrid = $("#jqGridDemoItemList");  
	var hdnContextPath = $("#hdnContextPath").val();
	jqGrid.jqGrid('setGridParam',{datatype:'json'}).setGridParam({ 
		page: 1,
        url: hdnContextPath + "/demoItem/getItemInfoList.action",
    }).trigger("reloadGrid");
}

// 商品对象信息
var DemoItemInfo = function () {

    // 商品对象的操作函数
	var handleDemoItemInfo = function() {
		
        $('#itemForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	name: {
                    required: true
                },
                amount: {
                    required: true,
                    digits: true
                }
            },

            messages: {
            	name: {
                    required: "商品名称不能为空."
                },
                amount: {
                    required: "金额不能为空.",
                    digits: "请输入一个数字作为价格."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#itemForm')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('#input-error'));
            },

            submitHandler: function(form) {
            	
            	App.blockUI();
            	
            	var itemForm = $('#itemForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	itemForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/demoItem/saveOrUpdate.action', // 需要提交的 url
                    data: itemForm.serialize(),
                    success: function(data) {
                    	debugger;
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.success("保存成功！");
                        	App.unblockUI();
                        	
                        	// 修改操作需要刷新grid以及关闭窗口
                        	var itemId = $("#itemId").val();
                        	if (itemId != "" && itemId != null && itemId != undefined) {
                        		reloadItemGrid();
                        		$("#ajax-modifyItem-modal").modal('hide');
                        	}
                        } else {
                        	SweetAlert.error(data.msg);
                        	App.unblockUI();
                        }
                    },
	                error: function (response, ajaxOptions, thrownError) {
	                	Error.displayError(response, ajaxOptions, thrownError); 
	                	App.unblockUI();
	                }
                });
            	
            }
        });

        $('#itemForm input').keypress(function(e) {
            if (e.which == 13) {
                if ($('#itemForm').validate().form()) {
                    $('#itemForm').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
        
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	handleDemoItemInfo();
        }

    };

}();

jQuery(document).ready(function() {
	DemoItemInfo.init();
});