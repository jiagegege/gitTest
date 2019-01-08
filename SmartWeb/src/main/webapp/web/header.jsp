<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
	style="border-radius: 0">
	<div class="container-fluid">
		<div class="navbar-header">
			<img src="${pageContext.request.contextPath}/web/img/mobileLogo.png" class="logo" /> 
				<a class="navbar-brand visible-lg" href="#">
				<!-- 潮州移动LTE无线网络性能预警系统 -->
				${projectName}
				</a>
		</div>
		<div>
			<!--最上部分头部导航 预留区域-->
		</div>
		<div class="userBlock">
			<p>
				<span>欢迎&nbsp;&nbsp;${user.uname}&nbsp;|</span>&nbsp;&nbsp;<a
					href="${pageContext.request.contextPath}/user/exit.do"
					style="color: white;">退出登录</a>
			</p>
		</div>
	</div>
</nav>