
//alert(localStorage.getItem("upColor"));
	
if(localStorage.getItem("upColor")){
	var colors = localStorage.getItem("upColor");
}else{
	
	  localStorage.setItem("upColor",0);
	
}

//alert(localStorage.getItem("upColor"));


/*整体css侧边栏框架*/
$(document).ready(function () {
	var trigger = $('.hamburger'),
	    overlay = $('.overlay'),
	    isClosed = false;

	trigger.click(function () {
		hamburger_cross();
	});
	function hamburger_cross() {

		if (isClosed == true) {
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			$("#btn").css("left", "20px");
			isClosed = false;
		} else {
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			$("#btn").css("left", "230px");
			isClosed = true;
		}
	}
	$('[data-toggle="offcanvas"]').click(function () {
		$('#wrapper').toggleClass('toggled');
	});
});

//是否显示颜色 
$("#colorbtn").on("click",function(){
	/*var ccc = $("#updateColor").val();
	alert(ccc);*/
	var aaa = $("#updateColor option:selected").val();
	  localStorage.setItem("upColor",aaa);
	  if(localStorage.getItem("upColor") == 1){
		  alert("显示颜色");
	  }else{
		  alert("隐藏颜色");  
		  
	  }
	  window.location.reload();
	
	
});

//根据url 包装成一个object,很重要，因为之后的页面导航位置显示，ajax数据请求，都要依据当前导航的参数
function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}

//根据参数显示相应的模块（二级，三级导航）
try {
	var navUrl = GetRequest();
	$(".twoNav_a").removeClass("active");
	$(".twoNav_a").eq(navUrl.three).addClass("active");
	$(".threeNav>ul>li").removeClass("active");
	$(".threeNav>ul>li").eq(navUrl.two).addClass("active");
} catch (e) {
	// TODO: handle exception
	console.log(e);
}
//小时级excel全网文件下载按钮显示
/*if(navUrl.three == 1){
	$("#downloadExcel").show();
	var tagName = "all";
	if (localStorage.getItem("selectRange")) {
		tagName = localStorage.getItem("selectRange");
	}
	$("#downloadExcel a").attr("href",projectUrl + '/excel/generateHourAllNetTableExcel.do?tagName='+tagName); 
}else{
	$("#downloadExcel").hide();
}*/
// 三级菜单
/*
 * i 下表 n 子项
 */
$.each($(".twoNav_a a"), function (i, n) {
	$(this).attr("href", projectUrl + '/main/showIndex.do?two=' + navUrl.two + '&three=' + i);
});

var twoNavData = [
	["全网级指标", "小区级指标", "Top小区指标" , "告警列表", "基站断链", "系统工参", "最大用户数","无服务小区", "PRB", "其他"], 
	["全网级指标", "小区级指标", "新小区级指标", "0流量小区列表","无服务小区", "其他"], 
	["全网级指标", "小区级指标", "Top小区指标"],
	["15分钟级汇总","小时级汇总","天级汇总"]
	//,["全网级指标", "小区级指标", "Top小区指标", "0流量小区列表", "客户感知指标", "VIP小区指标报表", "流量劣化小区指标", "RRC劣化小区指标", "工单", "0流量小区列表", "干扰小区指标"]
];
var generateTwoNav = function generateTwoNav() {
	var dom = '<li><a href="' + projectUrl + '/main/showIndex.do?two=0&three=' + navUrl.three + '"> <i class="glyphicon glyphicon-th-large"></i> \u6C47\u603B\u6307\u6807\n\t\t\t</a></li>';
	for (var i = 0; i < twoNavData[navUrl.three].length; i++) {
		dom += '<li><a href="#setting' + navUrl.three + i 
		+ '" class="nav-header collapsed" data-toggle="collapse"> <i class="glyphicon glyphicon-calendar"></i>' 
		+twoNavData[navUrl.three][i] + '<span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="setting' + navUrl.three + i + '" class="nav nav-list collapse secondmenu" style="height: 0px;"></ul></li>';
	}
	dom += '<li><a href="' + projectUrl + '/main/showIndex.do?two=11&three=' + navUrl.three + '"><i class="glyphicon glyphicon-cog"></i> \u8BBE\u7F6E\n\t\t\t</a>\n\t\t</li>';
	$("#main-nav").html("");
	$("#main-nav").html(dom);
};
//生成侧边栏的二级导航
generateTwoNav(navUrl.three);
/*二级导航添加ui响应事件*/
if (navUrl.two == 0) {
	$("#main-nav>li").eq(0).addClass("active");
} else if (navUrl.two == 11) {
	$("#main-nav>li:last").addClass("active");
}


if (navUrl.three == 0) {
	//（十五分钟） ajax请求全网excel数据(文件名)
	getFileList(1, $("#setting00"));
	getFileList(2, $("#setting01"));
	getFileList(3, $("#setting02"));
    getOuterFileList(4, $("#setting03"));
    getOuterFileList(5, $("#setting04"));
    getOuterFileList(6, $("#setting05"));
    getOuterFileList(7, $("#setting06"));
    getMinList(8, $("#setting07"));
    //getLinkList(5, $("#setting04"));
    
}else if(navUrl.three == 1){
	//（十五分钟重点） ajax请求全网excel数据
	getFileList(1, $("#setting10"));
	getFileList(2, $("#setting11"));
	getFileList(3, $("#setting12"));
	getFileList(4, $("#setting13")); 
	
}else if(navUrl.three == 2){    
	getDayFileList(1,$("#setting20"));
	//（十五分钟重点） ajax请求全网excel数据
	getDayFileList(2,$("#setting21"));
//	getFileList(2, $("#setting21"));
//	getFileList(3, $("#setting22")); 暂未开发
}

function getDayFileList(flag,document){
	$.ajax({
		url: projectUrl + "/allNetwork/getDayTopCellFileList.do",
		type: "POST",
		data:{
			colors : localStorage.getItem("upColor")
		},
		success: function success(data) {
			
			var data = data.data.sort();
			
			document.html("");
			var tagName = "";
			if (localStorage.getItem("selectRange")) {
				tagName = localStorage.getItem("selectRange");
			} 
			if(flag == 1){

					submitflag = "AllNetWork";
					filename = "天级全网数据";
					
					var getUrl = projectUrl 
					+ '/excel/generateDayAllNetTableExcel.do?tagName=' +tagName+'&colors='+colors;
					
					document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
							+"/web/img/excel.png"+ '"/>天级全网数据</a></li>');

				
				
			}else{
				for (var i = data.length; i >0; i--) {
					console.log(data);
					
					var filename = data[i-1].split(".")[0].split("ALLCELL")[1];
					//小时级小区数据_VIP小区_H2018070515
					var getUrl = projectUrl + '/excel/generateDayPointKeyExcel.do?tagName=' 
					+tagName+'&colors='+colors+'&excelName='+data[i-1]+'&filename='+"天级小区数据_"+tagName+"_"+filename+'.xlsx&flag=cell';
					
					document.append('<li onclick=myDownload("'+getUrl+'")>'+
							'<a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl+"/web/img/excel.png"+ '"/>' + 
							"天级小区数据_"+tagName+"_"+filename + '</a></li>');
				}
			}
			
		}
	})
}
/**
 * 生成新的文件名
 * @param filename
 * @param field
 * @returns
 */
function generateFilename (filename,field){
	var filenameArr = filename.split("_");
	filename = filenameArr[0]+field+filenameArr[1];
	return filename;
}
function generateNullFilename (filename,field){
	
	var filenameArr = filename.split("_");
	filename = filenameArr[0]+field+filenameArr[2];
	return filename;
}
/**
 * flag 
 * 	1 =>查询全网数据
 * 	2 =>查询小区级数据
 * 	3 =>查询top小区数据 
 *  4 =>报警
 *  5 =>断链
 *  6 =>工参
 *  7 =>最大用户数
 *  8 =>无服务小区
 * @param flag
 * @param document 数据渲染的位置
 * @returns
 */
function getOuterFileList(flag, document){
	if(navUrl.three == 0){
		$.ajax({
			url: projectUrl + "/allNetwork/getAllNetworkFileList.do",
			type: "POST",
			data: {
				flag: flag,
				
					colors : localStorage.getItem("upColor")
				
			},
			success: function success(data) {
				var data = data.data.sort();
				document.html("");
				for (var i = data.length; i >0; i--) {
					console.log(data);
					var filename = data[i-1].split(".")[0];
					var getUrl =  projectUrl + '/allNetwork/getAllNetWork.do?filename=' +data[i-1]+'&colors='+colors+ '&excelname='+data[i-1];
					document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl+"/web/img/excel.png"+ '"/>' + filename + '</a></li>');
				}
			}
		})
	}
}
//!!!!
function getMinList(flag,document) {
	if(navUrl.three == 0){
		$.ajax({
			url: projectUrl + "/allNetwork/getAllNetworkFileList.do",
			type: "POST",
			data: {
				flag: flag,
				
					colors : localStorage.getItem("upColor")
				
			},
			success: function success(data) {
				
				console.log(data.data);
				if(navUrl.three == 0){
					var locStor = localStorage.getItem("selectRange");
					
					if(locStor == "all"){
						//alert("cccc");
						//alert(data.length);
						
						for (var i = data.data.length-1; i >0; i--) {
							
							var filename = data.data[i].split("ALLCELL")[1];
							
							submitflag = "AllNetWork";
							filename = "无服务_"+locStor+'_'+filename;
							
							//$("#downloadExcel a").attr("href",projectUrl + '/excel/generateHourAllNetTableExcel.do?tagName='+tagName); 
							var getUrl = projectUrl 
							+ '/excel/generateMinAllNetTableExcel.do?tagName=' +locStor+'&colors='+colors+'&filename='+filename+'.xlsx';
							document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
									+"/web/img/excel.png"+ '"/>'+filename+'</a></li>');
							
							
						}
						
					}else{
							for (var i = data.data.length-1; i >0; i--) {
							
							var filename = data.data[i].split("ALLCELL")[1];
							
							
							filename = "无服务_"+locStor+'_'+filename;
							
							//$("#downloadExcel a").attr("href",projectUrl + '/excel/generateHourAllNetTableExcel.do?tagName='+tagName); 
							var getUrl = projectUrl 
							+ '/excel/generateMinAllNetTableExcel.do?tagName=' +locStor+'&colors='+colors+"&filename="+filename+'.xlsx';
							document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
									+"/web/img/excel.png"+ '"/>'+filename+'</a></li>');
							
							
						}
					}
				}}
				
		})
	}
}

//链路
function getLinkList(flag,document) {
	if(navUrl.three == 0){
		$.ajax({
			url: projectUrl + "/allNetwork/getAllNetworkFileList.do",
			type: "POST",
			data: {
				flag: flag,
				
					colors : localStorage.getItem("upColor")
				
			},
			success: function success(data) {
				
				console.log(data.data);
				if(navUrl.three == 0){
					var locStor = localStorage.getItem("selectRange");
					
					if(locStor == "all"){
						//alert("cccc");
						//alert(data.length);
						
						for (var i = data.data.length-1; i >0; i--) {
							
							var filename = data.data[i].split("ALLCELL")[1];
							
							submitflag = "AllNetWork";
							filename = "链路_"+locStor+'_'+filename;
							
							//$("#downloadExcel a").attr("href",projectUrl + '/excel/generateHourAllNetTableExcel.do?tagName='+tagName); 
							var getUrl = projectUrl 
							+ '/excel/generateLinkAllNetTableExcel.do?tagName=' +locStor+'&colors='+colors+'&filename='+filename+'.xlsx';
							document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
									+"/web/img/excel.png"+ '"/>'+filename+'</a></li>');
							
							
						}
						
					}else{
							for (var i = data.data.length-1; i >0; i--) {
							
							var filename = data.data[i].split("ALLCELL")[1];
							
							
							filename = "无服务_"+locStor+'_'+filename;
							
							//$("#downloadExcel a").attr("href",projectUrl + '/excel/generateHourAllNetTableExcel.do?tagName='+tagName); 
							var getUrl = projectUrl 
							+ '/excel/generateMinAllNetTableExcel.do?tagName=' +locStor+'&colors='+colors+"&filename="+filename+'.xlsx';
							document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
									+"/web/img/excel.png"+ '"/>'+filename+'</a></li>');
							
							
						}
					}
				}}
				
		})
	}
}
function getFileList(flag, document) {
	//getHourAllNetworkFileList
	
	if(navUrl.three == 0){
		$.ajax({
			url: projectUrl + "/allNetwork/getAllNetworkFileList.do",
			type: "POST",
			data: {
				flag: flag,
				
					colors : localStorage.getItem("upColor")
				
			},
			success: function success(data) {
				var data = data.data.sort();
				document.html("");
				if(navUrl.three == 0){
					var locStor = localStorage.getItem("selectRange");
					var colors = localStorage.getItem("upColor");
					if(locStor == "all"){
						if(flag == 1){
							var filename = "分钟级全网数据";							
							var getUrl =projectUrl 
							+ '/excel/generateAllExcel.do?tagName=' +tagName+'&colors='+colors+ 
								"&filename="+filename+".xlsx";
						document.append("<li onclick=myDownload('"+getUrl+"')><a class='samllSize'><img class='excelIcon' src='"+projectUrl
								+"/web/img/excel.png"+ "'/>" + filename + '</a></li>');
							
						}else{
							for (var i = data.length-1; i >0; i--) {
								var filename = data[i].split(".")[0];
								
								var getUrl =projectUrl + '/allNetwork/getAllNetWork.do?filename='
								+generateFilename(filename,"_all_")+'.xlsx'+'&excelname='+data[i]+'&colors='+colors;
								
								document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl+"/web/img/excel.png"+ '"/>'
										+ generateFilename(filename,"_all_") + '</a></li>');

							}
						}
							
						
						
					}else{
						for (var i = data.length-1; i >0; i--) {
							var filename = data[i].split(".")[0];
							var tagName = "";
							if (localStorage.getItem("selectRange")) {
								tagName = localStorage.getItem("selectRange");
							} else {
								tagName = "VIP";
							}
							
							//var flag 是cell 查询小区数据 如果是 AllNetWork 查询汇总的全网数据
							var submitflag = "";
							if(flag == 1){
								submitflag = "AllNetWork";
							}else if(flag == 2){
								submitflag = "cell";
							}
							//当不是十五分钟查询top小区，则停止函数渲染
							if(flag == 3 && localStorage.getItem("selectRange") != "all"){
								return;
							}
							var getUrl =projectUrl 
								+ '/excel/generatePointKeyExcel.do?tagName=' +tagName+'&colors='+colors+ 
									"&excelName="+data[i]+"&flag="+submitflag+"&filename="+generateFilename(filename,'_'+tagName+'_')+".xlsx";
							document.append("<li onclick=myDownload('"+getUrl+"')><a class='samllSize'><img class='excelIcon' src='"+projectUrl
									+"/web/img/excel.png"+ "'/>" + generateFilename(filename,'_'+tagName+'_') + '</a></li>');
						}
					}
					
				}
			}
		});
	}
	if(navUrl.three == 1){
		$.ajax({
			url: projectUrl + "/allNetwork/getHourAllNetworkFileList.do",
			type: "POST",
			data: {
				flag: flag,
				
					colors : localStorage.getItem("upColor")
				
			},
			success: function success(data) {
				var data = data.data.sort();
				document.html("");
				
					var locStor = localStorage.getItem("selectRange");
					//alert("小区组"+locStor);
						for (var i = data.length-1; i >0; i--) {
							var filename = data[i].split("ALLCELL")[1];
							var tagName = "";
							if (localStorage.getItem("selectRange")) {
								tagName = localStorage.getItem("selectRange");
							} else {
								tagName = "VIP";
							}
							//var flag 是cell 查询小区数据 如果是 AllNetWork 查询汇总的全网数据
							var submitflag = "";
							if(flag == 1){
								submitflag = "AllNetWork";
								filename = "小时级全网数据"+filename;
								//$("#downloadExcel a").attr("href",projectUrl + '/excel/generateHourAllNetTableExcel.do?tagName='+tagName); 
								var getUrl = projectUrl 
								+ '/excel/generateHourAllNetTableExcel.do?tagName=' +tagName+'&colors='+colors;
								document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
										+"/web/img/excel.png"+ '"/>小时级全网级数据</a></li>');
								return;
							}else if(flag == 2){
								submitflag = "cell";
								filename = "小时级小区数据_H"+filename;
								
								var tagName = "all";
								if (localStorage.getItem("selectRange")) {
									tagName = localStorage.getItem("selectRange");
								}
								var getUrl = projectUrl 
								+ '/excel/generateHourPointKeyExcel.do?tagName=' +tagName+'&colors='+colors+'&filename='+generateFilename(filename,"_"+tagName+"_")+'.xlsx'+
								'&excelName='+data[i]+'&flag='+submitflag;
								document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
										+"/web/img/excel.png"+ '"/>' + generateFilename(filename,"_"+tagName+"_")+ '</a></li>');
								
							}else if(flag == 3){
								submitflag = "cell";
								filename = "新小时级小区数据_H"+filename;
								
								var tagName = "all";
								if (localStorage.getItem("selectRange")) {
									tagName = localStorage.getItem("selectRange");
								}
								var getUrl = projectUrl 
								+ '/excel/generateHourNewPointKeyExcel.do?tagName=' +tagName+'&colors='+colors+'&filename='+generateFilename(filename,"_"+tagName+"_")+'.xlsx'+
								'&excelName='+data[i]+'&flag='+submitflag;
								document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl
										+"/web/img/excel.png"+ '"/>' + generateFilename(filename,"_"+tagName+"_")+ '</a></li>');
								
							}else if(flag == 4){
								if(locStor == "all"){
									for (var i = data.length-1; i >0; i--) {
										var filename = data[i].split(".")[0];
										
										var getUrl =projectUrl + '/allNetwork/getAllNetWork.do?filename='
										+generateNullFilename(filename,"_all_")+'.xlsx'+'&excelname='+data[i]+'&colors='+colors;
										
										document.append('<li onclick=myDownload("'+getUrl+'")><a class="samllSize" href="#"><img class="excelIcon" src="'+projectUrl+"/web/img/excel.png"+ '"/>'
												+ generateNullFilename(filename,"_all_") + '</a></li>');

									}
								}else{
									for (var i = data.length-1; i >0; i--) {
										var filename = data[i].split(".")[0];
										var tagName = "";
										if (localStorage.getItem("selectRange")) {
											tagName = localStorage.getItem("selectRange");
										} else {
											tagName = "VIP";
										}
										
										//var flag 是cell 查询小区数据 如果是 AllNetWork 查询汇总的全网数据
										var submitflag = "";
										if(flag == 1){
											submitflag = "AllNetWork";
										}else if(flag == 2){
											submitflag = "cell";
										}
										//当不是十五分钟查询top小区，则停止函数渲染
										if(flag == 3 && localStorage.getItem("selectRange") != "all"){
											return;
										}
										var getUrl =projectUrl 
											+ '/excel/generatePointKeyExcel.do?tagName=' +tagName+'&colors='+colors+ 
												"&excelName="+data[i]+"&flag="+submitflag+"&filename="+generateFilename(filename,'_'+tagName+'_')+".xlsx";
										document.append("<li onclick=myDownload('"+getUrl+"')><a class='samllSize'><img class='excelIcon' src='"+projectUrl
												+"/web/img/excel.png"+ "'/>" + generateFilename(filename,'_'+tagName+'_') + '</a></li>');
									}
								}
								
								
							}
							
						}
					
			}
		});
	}
	
}
/**
 * 利用原型链，给数组添加额外的功能
 */
Array.prototype.indexOf = function (val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val) return i;
	}
	return -1;
};
Array.prototype.remove = function (val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};
// 最小值
Array.prototype.min = function () {
	var min = this[0];
	var len = this.length;
	for (var i = 1; i < len; i++) {
		if (this[i] < min) {
			min = this[i];
		}
	}
	return min;
};
// 最大值
Array.prototype.max = function () {
	var max = this[0];
	var len = this.length;
	for (var i = 1; i < len; i++) {
		if (this[i] > max) {
			max = this[i];
		}
	}
	return max;
};
/*数组去重*/
Array.prototype.distinct = function () {
	var arr = this,
	    i,
	    obj = {},
	    result = [],
	    len = arr.length;
	for (i = 0; i < arr.length; i++) {
		if (!obj[arr[i]]) {
			//如果能查找到，证明数组元素重复了
			obj[arr[i]] = 1;
			result.push(arr[i]);
		}
	}
	return result;
};
//文件下载jq方法
var myDownload = function(url){
	$.fileDownload(url,{
		   httpMethod: 'GET',
		   prepareCallback:function(url){
			  $("#myModalLabel").html("文件下载");
		      $("#modal_content").html("文件正在后台动态生成，（如果文件过大,可能时间较长）请耐心等待……");
		      //给模态框添加打开属性，使用户点击模态框外部，模态框不会关闭。
		      $('#myModal').modal({
		    	  backdrop: 'static'
		    	  });
		      $("#modalClose").hide();
		      $('#myModal').modal('show');
		      
	      },
		   successCallback:function(url){
			   $("#modal_content").html("文件下载成功，2秒后自动关闭提示框");
			   setTimeout(() => {
				   $('#myModal').modal('hide');
			   }, 2000);
		   },
		   failCallback: function (html, url) {
			   $("#modal_content").html("文件下载失败，2秒后自动关闭提示框");
			   setTimeout(() => {
				   $('#myModal').modal('hide');
			   }, 2000);
		   }
		});
} 
var updateJsonValue = function(dom,flag){
	$("#myModalLabel").html("删除或添加属性");
	 $("#modalClose").show();
	var jsonValue = serializationJSON(dom);
	var childDom = "";
	for(var i = 0;i<jsonValue.length;i++){
		childDom += "<option value="+jsonValue[i].attribute+">"+jsonValue[i].attribute+"</option>";
	};
	var modalDeleteTitle = '<h4>删除属性</h4>';
	var documentsDelete = '<select class="form-control" id="jsonValue">'+childDom+'</select>';
	var modalDeleteBtn = '<button id = "modalDeleteBtn" type="button" class="pull-right btn btn-danger">删除属性</button>';
	var modalAddTitle = '<hr style="border:1 dashed #987cb9" color="#987cb9" size=1>';
	var documentsAdd = '<h4>添加属性</h4><form>'+
	  '<div class="form-group">'+
	    '<label for="attributeAdd">属性</label>'+
	   ' <input type="text" class="form-control" id="attributeAdd" placeholder="请输入属性">'+
	  '</div>'+
	 ' <div class="form-group">'+
	  ' <label for="compareAdd">临界值</label>'+
	   '<input type="number" class="form-control" id="compareAdd" placeholder="请输入临界值">'+
	 '</div>'+
	 
	 '</form>'
	 var modalAddBtn = '<button id = "modalAddBtn" type="button" class="pull-right btn btn-success">添加属性</button>';
	$("#modal_content").html(modalDeleteTitle+documentsDelete+modalDeleteBtn+
			modalAddTitle+documentsAdd+modalAddBtn);
	 $('#myModal').modal({
   	  backdrop: 'true'
   	 });
     $('#myModal').modal('show');
     //绑定更新事件
     $("#modalAddBtn").on("click",function(){
    	 getJsonValue(flag,function(data){
    		var jsonvalue = data;
	 		var obj = {};
	 		var attribute = $("#attributeAdd").val();
	 		obj.attribute = attribute;
	 		var compare = $("#compareAdd").val(); 
	 		obj.compare = compare;
	 		var symbol = $("#symbolAdd").val();
	 		obj.symbol = 0;
	 		
	 		console.log("增加属性");
	 		console.log(jsonvalue);
	 		console.log(obj);
	 		jsonvalue.push(obj);
	 		//提交数据
	 		setJosnValue(jsonvalue,flag);
    	 })
 	});
     //绑定删除事件
     $("#modalDeleteBtn").on("click",function(){
    	 if(confirm("确定要删除么？")){
    		 deleteJsonvalueDom(dom,$("#jsonValue").val(),flag);
    	 }
     });
};
//全网临界值增删
$("#updateAllNetBtn").on("click",function(){
	var dom = $(".criticalAllNetTable tbody tr");
	updateJsonValue(dom,"allNet");
});
//Top小区临界值增删
$("#updateTopCellBtn").on("click",function(){
	var dom = $(".criticalTopCellTable tbody tr");
	updateJsonValue(dom,"topCell");
});
//更改临界值
function setJosnValue(datas,flag){
	  $.ajax({
				url:projectUrl + "/setValue/setJsonValue.do",
				data:{
						jsonValue:JSON.stringify(datas),
						flag:flag,
						username:thisUsername
					},
				success:function(data){
					if(data.state == 1){
						//重新渲染表格
				 		getCriticalValue();
				 		toastr.success('修改成功', '提示');
				 		$("#jsonValue").html("");
				 		var dom = "";
				 		for(var i = 0;i<datas.length;i++){
				 			dom += "<option>"+datas[i].attribute+"</option>";
				 		}
				 		$("#jsonValue").html(dom);
					}else{
						alert("修改失败");
					}
				}
			});
}
var deleteJsonvalueDom = function(dom,htmlText,flag){
	 getJsonValue(flag,function(data){
		 data = $.grep(data, function(value) {
			 return value.attribute != htmlText;
		 });
		 setJosnValue(data,flag);
	 });
	 
}

function getJsonValue(flag,callback){
	  $.ajax({
				url:projectUrl + "/setValue/getJsonValue.do",
				dataType:"json",
				data:{
						flag:flag,
						username:thisUsername
					},
				success:function(data){
					data.data = JSON.parse(data.data);
					callback(data.data);
				}
			});
};


function getJsonValue(flag,callback){
	  $.ajax({
				url:projectUrl + "/setValue/getJsonValue.do",
				dataType:"json",
				data:{
						flag:flag,
						username:thisUsername
					},
				success:function(data){
					data.data = JSON.parse(data.data);
					callback(data.data);
				}
			});
}



