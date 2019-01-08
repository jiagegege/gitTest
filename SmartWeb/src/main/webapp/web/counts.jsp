<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<!-- 自己的css -->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/web/css/main.css" />
</head>
<body>
	
	<script type="text/javascript">
	var projectUrl = "${pageContext.request.contextPath}";
	//当前用户名
	var thisUsername = "${user.uname}";
	var two = "${two}";
	</script>
	
<!--bootstrap-->
	<%-- <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/bootstrap.min.js"></script> --%>
	
	<jsp:include page="header.jsp"></jsp:include>
	
								<div class="modal fade " id = "datas1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="tableTitle ">明细表  &nbsp;												
												</h5>
												<button class="btn btn-mini" id ="downloadExcelList" type="button">
												 	<a>点击下载
													 	<c:if test="${two == 0}">
															15分钟级  &nbsp;
														</c:if>
														<c:if test="${two == 1}">
															小时级汇  &nbsp;
														</c:if>
														<c:if test="${two == 2}">
															天级  &nbsp;
														</c:if>
												 	Excel文件</a>
												</button>											
											</div>
											<div class="modal-body">												
												<div class="row rowNumb4  magin-bottom" >									
													  <div class="col-xs-12 col-sm-12  magin-bottom">
														<div class="table4 clearFloat">
															
															<table id="allData4" class="table table-hover table-bordered table-striped table-condensed">
																<thead></thead>
																<tbody></tbody>
															</table>
														</div>
													</div>  									
												</div>
											</div> 	
											<div class="modal-footer">
												<button type="button" class="btn btn-primary" data-dismiss = "modal">Close</button>
												
											</div>											
										</div>
										
									</div>
									
									</div>
								
								
								</div>

				<div class="container">
						<jsp:include page="twoNav3.jsp"></jsp:include>
						<div class="row">
								
								 <!-- <p class = "selectRange">
								  	<select class="form-control" id = "selectRange">
									</select>
								  </p> -->
								 <!--  截图 -->
							<!-- <div class="js-capture hide"> -->					
								<div class="row rowNumb3  magin-bottom" style="margin-top: 10px;">									
									  <div class="col-xs-12 col-sm-12  magin-bottom">
										<div class="table4 clearFloat">
											<h5 class="tableTitle ">
											<c:if test="${two == 0}">
												15分钟级汇总统计  &nbsp;
											</c:if>
											<c:if test="${two == 1}">
												小时级汇总统计  &nbsp;
											</c:if>
											<c:if test="${two == 2}">
												天级汇总统计  &nbsp;
											</c:if>
											
												
											 <button class="btn btn-mini" id ="downloadExcel" type="button">
												 	<a>点击下载
													 	<c:if test="${two == 0}">
															15分钟级  &nbsp;
														</c:if>
														<c:if test="${two == 1}">
															小时级汇  &nbsp;
														</c:if>
														<c:if test="${two == 2}">
															天级  &nbsp;
														</c:if>
												 	Excel文件</a>
												</button>	 										
											 </h5>
											 	 
											<table id="allData1" class="table table-hover table-bordered table-striped table-condensed">
												<thead></thead>
												<tbody></tbody>
											</table>
										</div>
									</div>  									
								</div>
						<!-- 	</div> -->
							
								<!-- <div class="row rowNumb2  magin-bottom" >									
									  <div class="col-xs-12 col-sm-12  magin-bottom">
										<div class="table4 clearFloat">
											<h5 class="tableTitle ">小时级汇总统计  &nbsp;
											<button class="btn btn-mini" id ="downloadExcel2" type="button">
												 	<a>点击下载excel小时级excel文件</a>
												</button>												
											 </h5>
											 	 
											<table id="allData2" class="table table-hover table-bordered table-striped table-condensed">
												<thead></thead>
												<tbody></tbody>
											</table>
										</div>
									</div>  									
								</div>
								<div class="row rowNumb2  magin-bottom" >									
									  <div class="col-xs-12 col-sm-12  magin-bottom">
										<div class="table4 clearFloat">
											<h5 class="tableTitle ">天级汇总统计  &nbsp;	
											<button class="btn btn-mini" id ="downloadExcel3" type="button">
												 	<a>点击下载excel天级excel文件</a>
												</button> 											
											 </h5>
											 	
											<table id="allData3" class="table table-hover table-bordered table-striped table-condensed">
												<thead></thead>
												<tbody></tbody>
											</table>
										</div>
									</div>  									
								</div>	 -->	
							
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
	</div>
		<!-- /#wrapper -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/jquery-1.12.4.js"></script>
		<!-- ajax调取数据相关js -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/web/js/data3.js"></script>	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/bootstrap.min.js"></script>
		<!-- 捕获文件下载 -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/fileDownload.js"></script>
	<!-- toastr 消息提示类的框架 -->
	<script src="${pageContext.request.contextPath}/web/js/framework/toastr.js"></script>

</body>
</html>