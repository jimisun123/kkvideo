<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 9]>
<script src="<%=request.getContextPath() %>/static/global/plugins/respond.min.js"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/excanvas.min.js"></script> 
<script src="<%=request.getContextPath() %>/static/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->

<!-- 上下文对象路径 -->
<input type="hidden" id="hdnContextPath" name="hdnContextPath" value="<%=request.getContextPath() %>"/>
<input type="hidden" id="apiServer" name="apiServer" value="https://video.redrat.cn"/>
<input type="hidden" id="bgmServer" name="bgmServer" value="http://admin.video.redrat.cn:8888"/>
<input type="hidden" id="apiSourceServer" name="apiSourceServer" value="http://video.redrat.cn:8888"/>
<%--<input type="hidden" id="apiServer" name="apiServer" value="http://192.168.1.2:8081"/>
<input type="hidden" id="bgmServer" name="bgmServer" value="http://192.168.1.2:8080/mvc"/>--%>



<!-- BEGIN CORE PLUGINS -->
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap/js/bootstrap.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/js.cookie.min.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/morris/morris.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-validation/js/jquery.validate.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-validation/js/additional-methods.min.js?v=3.1415926" type="text/javascript"></script>

<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/global/scripts/app.js?v=3.1415926" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.form.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/form-validation.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-sweetalert/sweetalert.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/Guriddo_jqGrid_JS_5.2.0/js/i18n/grid.locale-cn.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/Guriddo_jqGrid_JS_5.2.0/js/jquery.jqGrid.min.js?v=3.1415926" type="text/javascript"></script>

<!-- END PAGE LEVEL SCRIPTS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/pages/scripts/dashboard.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/ui-sweetalert.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/ui-blockui.min.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/icheck/icheck.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/form-icheck.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-modal/js/bootstrap-modal.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/file-uploader/js/vendor/jquery.ui.widget.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/file-uploader/js/jquery.fileupload.js?v=3.1415926"></script>



<!-- END PAGE LEVEL SCRIPTS -->

<!-- BEGIN 自己写的页面JS -->
<script src="<%=request.getContextPath() %>/static/pages/js/commonJSFunction.js?v=3.1415926" type="text/javascript"></script>

<!-- END 自己写的页面JS -->

<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/layouts/layout/scripts/layout.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/layouts/layout/scripts/demo.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/layouts/global/scripts/quick-sidebar.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/layouts/global/scripts/quick-nav.js?v=3.1415926" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->

      
      
      
      
