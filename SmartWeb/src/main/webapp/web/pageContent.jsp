<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-content-wrapper">
					<div class="container">
						<jsp:include page="twoNav.jsp"></jsp:include>
						<div class="row" >
							<div>
								<!--col-lg-offset-1-->
								<div class="row rowNumb1">
									<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="table1"></div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="table2"></div>
									</div>
								</div>
								<!-- <div class="showToggle">
									<p class="showBtn">
										<span class="glyphicon glyphicon-menu-down showmoreIcon" id="showmore"></span>
										<span class="showmoreText">显示更多</span>
									</p> 
								</div>-->
								<div class="hideBlock" display="hide">
									<div class="row rowNumb1 magin-bottom">
										<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="table5"></div>
										</div>
										<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="table6"></div>
										</div>
									</div>
									<div class="row rowNumb1 magin-bottom">
										<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="table7"></div>
										</div>
										<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="table8"></div>
										</div>
									</div>
								</div>
								<div class="row rowNumb2  magin-bottom" style="margin-top: 10px;">
									<div class="col-xs-12 col-sm-12  magin-bottom">
										<div class="table3 clearFloat">
											<h5 class="tableTitle">整体指标  &nbsp;
												  <!-- <button class="btn btn-mini" id ="downloadExcel" type="button">
												 	<a>点击下载excel小时级全网excel文件</a>
												 </button>  -->
											 </h5>
											<table id="allData1" class="table table-hover table-bordered table-striped table-condensed">
												<thead></thead>
												<tbody></tbody>
											</table>
										</div>
									</div>
									 <!--  <div class="col-xs-12 col-sm-12  magin-bottom">
										<div class="table4 clearFloat">
											<h5 class="tableTitle ">汇总统计  &nbsp;												
												 <button class="btn btn-mini" id ="downloadExcel" type="button">
												 	<a>点击下载excel小时级全网excel文件</a>
												 </button>
											 </h5>
											<table id="allData3" class="table table-hover table-bordered table-striped table-condensed">
												<thead></thead>
												<tbody></tbody>
											</table>
										</div>
									</div> -->    
									<div class="col-xs-12 col-sm-12  magin-bottom">
										<div class="table4 clearFloat">
											<h5 class="tableTitle">TOP信息</h5>
											<table id="allData2"  class="table table-hover table-bordered table-striped table-condensed">
											<thead>
											</thead>
											<tbody>
											</tbody>
										</table>
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>