<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row twoNav">
	<ul class="nav nav-tabs">
	  <li role="presentation" class="active twoNav_a">
	  	<a href="${pageContext.request.contextPath}/main/school.do?two=0">
	  	  15分钟 
	  	</a>
  	  </li>
	  <li role="presentation" class="keyPoint15 twoNav_a">
	  	<a href="${pageContext.request.contextPath}/main/school.do?two=1">
	  	  <!-- 15分钟重点 -->
	  	  小时
	  	</a>
	  </li>
	  <li role="presentation" class="twoNav_a keyPointHour">
	  	<a href="${pageContext.request.contextPath}/main/school.do?two=2">
	  		<!-- 小时 -->
	  		天
	  	</a>
	  </li>
	  <!--  <p class = "selectRange">
	  	<select class="form-control" id = "selectRange">
		</select>
	  </p> -->
	  
	</ul>
</div>


	   

