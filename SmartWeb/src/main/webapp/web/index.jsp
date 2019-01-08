<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<!-- 每经过800秒页面刷新一次 （15分钟）参数设置页面并不需要一直刷新 -->
	<c:if test="${two != 11}">
		<meta http-equiv="Refresh" content="800">
	</c:if>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${projectName}</title>
	<link rel="icon"
		href="${pageContext.request.contextPath}/web/img/cmcc.png"
		type="image/x-icon" />
	<!-- 最新的 Bootstrap 核心 css 文件 -->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/web/css/framework/bootstrap.min.css" />
	<!-- 引用bootstrap 插件所需要的css文件-->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/web/css/framework/style.css" />
	<link href="${pageContext.request.contextPath}/web/css/framework/toastr.css" rel="stylesheet"/>
	<!-- 日历的css文件 -->
	<link rel="stylesheet" 
		href="${pageContext.request.contextPath}/web/laydate/theme/default/laydate.css" media="all">
	<!-- 自己的css -->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/web/css/main.css" />
	<!-- excel参数导入 -->
	<c:if test="${two == 11}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/web/css/excelImport.css" />
	</c:if>
</head>
<body>
	<div class="main">
		<!--侧边栏导航 三级  -->
		<jsp:include page="sidebar.jsp"></jsp:include>
		<div id="wrapper">
			<!--头部导航-->
			<jsp:include page="header.jsp"></jsp:include>
			<!--模态遮罩层-->
			<div class="overlay"></div>
			<!-- Sidebar -->
			<!--侧边栏导航  一级-->
			<jsp:include page="oneNav.jsp"></jsp:include>
			<!-- /#sidebar-wrapper -->
			<!-- Page Content 数据页面主体-->
			<!-- 数据页面 -->
			<c:if test="${two == 0}">
				<jsp:include page="pageContent.jsp"></jsp:include>
			</c:if>
			<!-- （excel）设置页面 -->
			<c:if test="${two == 11}">
				<jsp:include page="setPage.jsp"></jsp:include>
			</c:if>
			<!-- /#page-content-wrapper -->
		</div>
	</div>
	<div class="modal fade" id="myModal" backdrop="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- 禁止用户手动关闭 -->
					<button id = "modalClose" type="button" class="close" data-dismiss="modal" aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						文件下载
					</h4>
				</div>
				<div class="modal-body clearfix" id ="modal_content">
					文件正在后台动态生成，（如果文件过大）请耐心等待……
				</div>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">
						关闭
					</button>
					<button type="button" class="btn btn-primary">
						提交更改
					</button> -->
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- /#wrapper -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/jquery-1.12.4.js"></script>
	<!-- 捕获文件下载 -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/fileDownload.js"></script>
	
	<!-- 日历日期 -->
	<script 
		src="${pageContext.request.contextPath}/web/laydate/laydate.js"></script>
	<!--bootstrap-->
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/bootstrap.min.js"></script>
	<!--ecarts -->
	<!-- toastr 消息提示类的框架 -->
	<script src="${pageContext.request.contextPath}/web/js/framework/toastr.js"></script>
	<!--my-->
	<script type="text/javascript">
		//项目请求根路径
		var projectUrl = "${pageContext.request.contextPath}";
		//当前用户名
		var thisUsername = "${user.uname}";
		//判断浏览器版本
		function IEVersion() {
            var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串  
            var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器  
            var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器  
            var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
            if(isIE) {
                var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
                reIE.test(userAgent);
                var fIEVersion = parseFloat(RegExp["$1"]);
                if(fIEVersion == 7) {
                    return 7;
                } else if(fIEVersion == 8) {
                    return 8;
                } else if(fIEVersion == 9) {
                    return 9;
                } else if(fIEVersion == 10) {
                    return 10;
                } else {
                    return 6;//IE版本<=7
                }   
            } else if(isEdge) {
                return 'edge';//edge
            } else if(isIE11) {
                return 11; //IE11  
            }else{
                return -1;//不是ie浏览器
            }
        }
		console.log("浏览器版本:"+IEVersion());
		if(IEVersion() != -1){
			alert("本产品不支持ie系列，请使用chrome浏览器或者火狐浏览器最高版本访问");
		};
		toastr.options = {
				  "closeButton": true,
				  "debug": true,
				  "positionClass": "toast-top-right",
				  "showDuration": "300",
				  "hideDuration": "1000",
				  "timeOut": "3000",
				  "extendedTimeOut": "1000",
				  "showEasing": "swing",
				  "hideEasing": "linear",
				  "showMethod": "fadeIn",
				  "hideMethod": "fadeOut"
				};
	</script>
	<!--公共js 二，三级导航相关js  -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/web/js/main.js"></script>
	
	<!-- 数据监测相关js -->
	<c:if test="${two == 0}">
		<!-- echarts 框架核心文件 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/web/js/framework/echarts.common.min.js"></script>
		<!-- echarts 图表格式相关文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/echartData.js"></script>
		<!-- ajax调取数据相关js -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/web/js/data.js"></script>
	</c:if>
	<!-- excel文件 作为参数 导入相关js -->
	<c:if test="${two == 11}">
		<!-- js-xlsx框架 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/web/js/framework/xlsx.core.min.js"></script>
		<!-- 解析excel 参数导入相关js -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/web/js/excelImport.js"></script>
		
	</c:if>
</body>

</html>