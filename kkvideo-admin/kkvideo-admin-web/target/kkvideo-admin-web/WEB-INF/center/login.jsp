<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>短视频后台管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="leechenxiang" name="author" />
    
    <link href="<%=request.getContextPath() %>/static/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="<%=request.getContextPath() %>/static/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-sweetalert/sweetalert.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=request.getContextPath() %>/static/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="<%=request.getContextPath() %>/static/pages/css/login-2.min.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="<%=request.getContextPath()%>/portal/image/itzixi_favicon.ico" type="image/x-icon">
        
	<style type="text/css">
		.help-block {
			display: block;
		  	margin-top: 5px;
		  	margin-bottom: 10px;
		  	color: red; 
		}
	</style>
	
</head>
<body class="login">
        <!-- BEGIN LOGO -->
        <div class="logo">
            <a href="<%=request.getContextPath()%>/">
                <img src="<%=request.getContextPath()%>/static/pages/img/logos/logo.png" /> 
            </a>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN LOGIN -->
        <div class="content">
            <!-- BEGIN LOGIN FORM -->
            <form class="login-form">

                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">用户名</label>
                    <div id="input-error">
                    	<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" /> </div>
                    </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">密码</label>
                    <div id="input-error">
                    	<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" /> </div>
                    </div>
                
                
                <div class="form-actions" style="padding: 0 30px 15px;">
                    <button type="submit" class="btn red btn-block uppercase">登 录</button>
                </div>
                <div class="create-account">
                    <p>
                        <a href="javascript:;" class="btn-primary btn" id="register-btn">注 册 用 户</a>
                    </p>
                </div>
            </form>
            <!-- END LOGIN FORM -->

            <!-- BEGIN REGISTRATION FORM -->
            <form class="register-form">
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">用户名</label>
                    <div id="input-error">
                    	<input class="form-control placeholder-no-fix" type="text" placeholder="用户名" name="username" />
                    </div> 
                </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">密码</label>
                    <div id="input-error">
                    	<input class="form-control placeholder-no-fix" type="text" placeholder="密码" name="password" />
                    </div> 
                </div>
                <div class="form-actions">
                    <button type="button" id="register-back-btn" class="btn btn-default">返 回</button>
                </div>
            </form>
            <!-- END REGISTRATION FORM -->
        </div>
        
        <input type="hidden" id="hdnContextPath" name="hdnContextPath" value="<%=request.getContextPath() %>"/>
        
<!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js?v=3.1415926"></script>
<script src="../assets/global/plugins/excanvas.min.js?v=3.1415926"></script> 
<script src="../assets/global/plugins/ie8.fix.min.js?v=3.1415926"></script> 
<![endif]-->
        
        <!-- 公用尾部JS start -->
	    <jsp:include page="common/commonFooterJS.jsp"></jsp:include>
	    <!-- 公用尾部JS end -->
    
        <script src="<%=request.getContextPath() %>/static/pages/js/login.js?v=1.1" type="text/javascript"></script>
        
</body>
</html>
