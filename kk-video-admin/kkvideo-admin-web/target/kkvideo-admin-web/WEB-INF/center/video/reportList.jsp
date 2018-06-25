<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath() %>/static/pages/js/reportList.js?v=1.1" type="text/javascript"></script>

	<!-- BEGIN PAGE HEADER-->
	<!-- BEGIN PAGE BAR -->
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <span>首页</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>举报信息</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>举报列表</span>
	        </li>
	    </ul>
	</div>
	<!-- END PAGE BAR -->
	<!-- END PAGE HEADER-->
        
    <!-- 列表 jqgrid start -->                
	<div class="row">
	
    	<div class="col-md-12">
			<br/>
			
			<div class="usersReportsList_wrapper">  
			    <table id="usersReportsList"></table>  
			    <div id="usersReportsListPager"></div>  
			</div>  
			
		</div>
	</div>
	<!-- 列表 jqgrid end -->
	
