<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>茂名移动LTE无线网络性能预警系统</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/web/img/cmcc.png"
	type="image/x-icon" />
<!-- 最新的 Bootstrap 核心 css 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/web/css/framework/bootstrap.min.css" />
<!--my-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/web/css/login.css" />
</head>

<body>
	<div class="main">
		<div class="showLogin">
			<div class="showLogo">
				<img src="${pageContext.request.contextPath}/web/img/mobileLogo.png" />
				<h4>茂名移动LTE无线网络性能预警系统</h4>
			</div>
			<div class="formBlock">
				<form action="" id="user">
					<div class="form-group">
						<label for="uname">用户名</label> 
						<input name="Uname" type="text"
							class="form-control" id="uname" placeholder="请输入用户名">
					</div>
					<div class="form-group">
						<label for="pwd">密码</label> 
						<input name="password" type="password"
							class="form-control sub" id="pwd" placeholder="请输入密码">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1" style="height: 36px;">验证码</label>
						<a href="#" class="codeContent"> <img id="codeImg"
							src="${pageContext.request.contextPath}/user/codeImg.do"
							class="imager" />
						</a> <span class="glyphicon ok" id="verifyIcon"></span> 
						<input type="text" class="form-control sub" name="received" id="verify"
							placeholder="请输入验证码"> <span id="result" class="ok"></span>
						<!-- <span class="result error">验证码错误</span> -->
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" id="remember"> 记住密码
						</label>
					</div>
					<button type="submit" class="btn btn-primary btn-lg btn-block"
						style="padding: 5px 0;" id="submit">登陆</button>
				</form>
			</div>
		</div>
	</div>
</body>
<!--bootstrap-->
<script
	src="${pageContext.request.contextPath}/web/js/framework/jquery-1.12.4.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="${pageContext.request.contextPath}/web/js/framework/bootstrap.min.js"></script>
<!--my-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/js/login.js"></script>
<script type="text/javascript">
	/*登陆方法  */
		$("#submit").on("click",function(event){
			subFrom (event);
		});
		/* 回车事件 */
		$(".sub").keypress(function(event){
		    if(event.which === 13) { 
		        //点击回车要执行的事件
		        subFrom(event)
		     }
		});
		function subFrom (event){
			var event = event || window.event;
			  event.preventDefault(); // 兼容标准浏览器
			  event.returnValue = false; // 兼容IE6~8
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/user/login.do",
				data:$("#user").serialize(),
				success:function(data){
					console.log(data);
					if(data.state == 1){
						savePwd();
						location = "${pageContext.request.contextPath}/main/showIndex.do?two=0&three=0";
					}
					if(data.state){
						
						$("#result").html(data.message).removeClass("error").addClass("ok");
					}else{
						 alert("账号或密码错误");
						$("#result").html(data.message).removeClass("ok").addClass("error");
					}
				}
			});
		}
		/* 如果存在密码缓存则，默认 */
		function inputUserInfo(){
			if(localStorage.getItem("huahaiUserInfo")){
				var userInfoStr = localStorage.getItem("huahaiUserInfo");
				var userInfo = JSON.parse(userInfoStr);
				$("#uname").val(userInfo.uname);
				$("#pwd").val(userInfo.pwd);
			}
		}
		inputUserInfo();
		/* 记住密码 */
		function savePwd(){
			if($("#remember")[0].checked){
				var userInfo = {
					uname:$("#uname").val(),
					pwd:$("#pwd").val()
				}
				var userInfoStr = JSON.stringify(userInfo);
				localStorage.setItem("huahaiUserInfo",userInfoStr);
			}
		}
		/*点击图片更换验证码*/
		$("#codeImg").on("click",function(){
			$(this).attr("src","${pageContext.request.contextPath}/user/codeImg.do?"+Math.random());
		});
		/*查看验证码是否正确  */
		$("#verify").on("input",function(){
			if($(this).val().length != 4){
				return
			}
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/user/verify.do",
				data:{
					received:$("#verify").val()
				},
				success:function(data){
					console.log(data);
					if(data.state){
						$("#result").html(data.message).removeClass("error").addClass("ok");
						/* glyphicon-ok */
						$("#verifyIcon").addClass("glyphicon-ok ok");
						$("#verifyIcon").removeClass("glyphicon-remove err");
					}else{
						$("#result").html(data.message).removeClass("ok").addClass("error");
						$("#verifyIcon").addClass("glyphicon-remove err");
						$("#verifyIcon").removeClass("glyphicon-ok ok");
					}
				}
			});
		});
	</script>
</html>