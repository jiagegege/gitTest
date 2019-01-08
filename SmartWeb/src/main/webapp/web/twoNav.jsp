<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row twoNav">
	<ul class="nav nav-tabs">
	  <li role="presentation" class="active twoNav_a">
	  	<a href="${pageContext.request.contextPath}/main/showIndex.do?two=0">
	  	  15分钟 
	  	</a>
  	  </li>
	  <li role="presentation" class="keyPoint15 twoNav_a">
	  	<a href="${pageContext.request.contextPath}/main/showIndex.do?two=1">
	  	  <!-- 15分钟重点 -->
	  	  小时
	  	</a>
	  </li>
	  <!-- 将语句隐藏 可以加 style="display: none" -->
	  <li role="presentation" class="twoNav_a keyPointHour" >
	  	<a href="${pageContext.request.contextPath}/main/showIndex.do?two=2">
	  		<!-- 小时 -->
	  		天
	  	</a>
	  </li>
	   <li role="presentation" class=" counts" st>
	  	<a href="http://10.202.144.236:3000/mm/" target="blank">
	  		<!-- 小时 -->
	  		汇总
	  	</a>
	  </li>
	  <li role="presentation" class="school">
	  	<a href="${pageContext.request.contextPath}/main/school.do?two=0" target="_blank">
	  		<!-- 小时 -->
	  		校园
	  	</a>
	  </li>
	  <li role="presentation" class="counts">
	  	<a href="${pageContext.request.contextPath}/main/counts.do?two=0" target="_blank">
	  		<!-- 小时 -->
	  		汇总统计
	  	</a>
	  </li>
	 
	 <%--  <li role="presentation">
	  	<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      	<span class="caret"></span>
   		</a>
	  </li>
	  <li role="presentation"  class="twoNav_a">
	  	<a href="${pageContext.request.contextPath}/main/showIndex.do?two=3">天</a>
  	  </li> --%>
	   <p class="showBtn">
		<span class="glyphicon glyphicon-menu-down showmoreIcon" id="showmore"></span>
		<span class="showmoreText">显示更多</span>
	  </p> 
	  <p class = "selectRange">
	  	<select class="form-control" id = "selectRange">
		</select>
	  </p>
	</ul>
</div>

<!--  <div>
	<input type="text" class="layui-input" id="test1">
	<input type="text" id="endtime">
	<input type="button" id="选择时间段">
</div> 
   -->
<div id="changenum">
	选择显示个数:
	<input type="text" id="numbers" >
	<input type="button" value="确认" id="numbtn">

</div>
	   

