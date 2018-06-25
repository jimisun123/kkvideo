var reloadDataDictGrid = function() {
	var jqGrid = $("#jqGridDataDictList");  
	var hdnContextPath = $("#hdnContextPath").val();
	jqGrid.jqGrid('setGridParam',{datatype:'json'}).setGridParam({ 
		page: 1,
        url: hdnContextPath + "/dataDict/getDataDictList.action",
    }).trigger("reloadGrid");
}

var DataDict = function () {

    // 用户信息
	var handleDataDict = function() {
		
        $('#dataDictForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	typeName: {
                    required: true
                },
                typeCode: {
                    required: true
                },
                ddkey: {
                    required: true
                },
                ddvalue: {
                    required: true
                },
                isShow: {
                	required: true
                }
            },

            messages: {
                typeName: {
                    required: "字典名称不能为空."
                },
                typeCode: {
                    required: "字典码不能为空."
                },
                ddkey: {
                    required: "key不能为空."
                },
                ddvalue: {
                    required: "value不能为空."
                },
                isShow: {
                	required: "是否显示不能为空."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#dataDictForm')).show();
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
            	
            	var dataDictId = $("#dataDictId").val();
            
            	var dataDictForm = $('#dataDictForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	dataDictForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/dataDict/saveOrUpdate.action', // 需要提交的 url
                    data: dataDictForm.serialize(),
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.success("保存成功！");
                        	App.unblockUI();
                        	
                        	// 修改操作需要刷新grid以及关闭窗口
                        	if (dataDictId != "" && dataDictId != null && dataDictId != undefined) {
                        		reloadDataDictGrid();
                        		$("#ajax-modifyDataDict-modal").modal('hide');
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

        $('#dataDictForm input').keypress(function(e) {
            if (e.which == 13) {
                if ($('#dataDictForm').validate().form()) {
                    $('#dataDictForm').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
        
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	handleDataDict();
        }

    };

}();

jQuery(document).ready(function() {
	DataDict.init();
});