var reloadUserGrid = function() {
	var jqGrid = $("#jqGridUserInfoList");  
	var hdnContextPath = $("#hdnContextPath").val();
	jqGrid.jqGrid('setGridParam',{datatype:'json'}).setGridParam({ 
		page: 1,
        url: hdnContextPath + "/user/getUserInfoList.action",
    }).trigger("reloadGrid");
}

var UserInfo = function () {

    // 用户信息
	var handleUserInfo = function() {
		
		jQuery.validator.addMethod("nicknameIsExist", function(value, element) {
			
			var nickname = value;
			var userId = $("#userId").val();
			
	    	var flag = true;
	        $.ajax({
	        	url: $("#hdnContextPath").val() + "/user/nicknameIsExist.action",
	        	type: "POST",
	        	async: false,
	        	data: {"nickname": nickname, "userId": userId},
	        	success: function(data) {
	                if(data.status == 200 && data.msg == "OK") {
	                	if (data.data) {
	                		flag = false;
	                	} else {
	                		flag = true;
	                	}
	                } else {
	                	console.log(JSON.stringify(data));
	                }
	        	},
                error: function (response, ajaxOptions, thrownError) {
                	Error.displayError(response, ajaxOptions, thrownError);                
                }
	        });
	    	
	    	return flag;
		}, "该昵称已经存在.");
		
		jQuery.validator.addMethod("usernameIsExist", function(value, element) {
    		
    		var username = value;
    		var userId = $("#userId").val();
    		
        	var flag = true;
            $.ajax({
            	url: $("#hdnContextPath").val() + "/user/usernameIsExist.action",
            	type: "POST",
            	async: false,
            	data: {"username": username, "userId": userId},
            	success: function(data) {
                    if(data.status == 200 && data.msg == "OK") {
                    	if (data.data) {
                    		flag = false;
                    	} else {
                    		flag = true;
                    	}
                    } else {
                    	console.log(JSON.stringify(data));
                    }
            	},
                error: function (response, ajaxOptions, thrownError) {
                	Error.displayError(response, ajaxOptions, thrownError);                
                }
            });
        	
        	return flag;
    	}, "该用户名已经存在.");
    	
        $('#userInfoForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	username: {
                    required: true,
                    rangelength: [2,8],
                    usernameIsExist: true
                },
                password: {
                    required: true,
                    minlength:6
                    
                },
                confirmPassword: {
                    required: true,
                    equalTo: "#password"
                },
                nickname: {
                    required: true,
                    rangelength: [2,8],
                    nicknameIsExist: true
                },
                age: {
                	digits: true,
                	range: [12,100] 
                }
            },

            messages: {
            	username: {
                    required: "用户名不能为空.",
                    rangelength: "用户名的长度请控制在2-8位."
                },
                password: {
                    required: "密码不能为空.",
                    minlength: "密码长度不能少于6位."
                },
                confirmPassword: {
                    required: "确认密码不能为空.",
                    equalTo: "两次密码输入不一致."
                },
                nickname: {
                    required: "昵称不能为空.",
                    rangelength: "昵称的长度请控制在2-8位."
                },
                age: {
                	digits: "年龄必须为整数.",
                	range: "年龄范围12岁-100岁 (-_-|||)"
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#userInfoForm')).show();
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
            	
            	var userId = $("#userId").val();
            
            	var userInfoForm = $('#userInfoForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	userInfoForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/user/saveOrUpdate.action', // 需要提交的 url
                    data: userInfoForm.serialize(),
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.success("保存成功！");
                        	App.unblockUI();
                        	
                        	// 修改操作需要刷新grid以及关闭窗口
                        	if (userId != "" && userId != null && userId != undefined) {
                        		reloadUserGrid();
                        		$("#ajax-modifyUserInfo-modal").modal('hide');
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

        $('#userInfoForm input').keypress(function(e) {
            if (e.which == 13) {
                if ($('#userInfoForm').validate().form()) {
                    $('#userInfoForm').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
        
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	handleUserInfo();
        	
        	'use strict';
        	$("#distpicker").distpicker({
//        		province: "浙江省",
//        		city: "杭州市",
//        		district: "西湖区"
        	});
        	
        }

    };

}();

jQuery(document).ready(function() {
	UserInfo.init();
});