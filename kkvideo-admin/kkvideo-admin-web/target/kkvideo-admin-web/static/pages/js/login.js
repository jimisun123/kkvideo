var Login = function() {

	// 构建登录对象
    var handleLogin = function() {

    	// jquery-form-validate 前端的验证框架
        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            },

            messages: {
                username: {
                    required: "用户名不能为空."
                },
                password: {
                    required: "密码不能为空."
                }
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
            	
            	var loginForm = $('.login-form');
            	var hdnContextPath = $("#hdnContextPath").val();
            	loginForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/users/login.action', // 需要提交的 url
                    data: loginForm.serialize(),
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	window.location.href = hdnContextPath + "/center.action";
                        } else {
//                        	SweetAlert.error(data.msg);
                        	alert(data.msg);
                        }
                    }
                });
            	
            }
        });

    }
    
    return {
        init: function() {
            handleLogin();
        }

    };

}();

jQuery(document).ready(function() {
    Login.init();
});