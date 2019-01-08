

/*function GetRequest() {
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


	var navUrl = GetRequest();
	$(".twoNav_a").removeClass("active");
	$(".twoNav_a").eq(navUrl.two).addClass("active");
	*/
	
//	alert(navUrl.two);
	


/*$(".changenum").attr("display", "hide");*/
//	function selectAllMapping() {
//	$.ajax({
//		url: projectUrl + "/excel/selectAllMapping.do",
//		type: "post",
//		success: function success(data) {
//			console.log(data);
//			
//			
//			//查找选择范围dom元素
//			var selectDom = $("#selectRange");
//			selectDom.html("");
//			var fieldDom = "<option value = 'all'>全部小区</option><option value = 'VIP'>VIP小区</option>";
//			for (var i = 0; i < data.data.length; i++) {
//				fieldDom += "<option value="+data.data[i]+">" + data.data[i] + "</option>";
//			}
//			//添加范围选项
//			selectDom.append(fieldDom);
//			if (localStorage.getItem("selectRange")) {
//				selectDom.val(localStorage.getItem("selectRange"));
//			}else{
//				localStorage.setItem("selectRange","all");
//			}
//			selectDom.on("change",function(){
//				localStorage.setItem("selectRange",selectDom.val());
//				location.reload();
//			});
//		}
//	});
//};			
//
//selectAllMapping();

if(localStorage.getItem("upColor")){
	var colors = localStorage.getItem("upColor");
}else{
	
	  localStorage.setItem("upColor",0);
	
}	
var myDownload = function(url){
	$.fileDownload(url,{
		   httpMethod: 'POST',
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

try {
	var navUrl = GetRequest();
	
	$(".twoNav_a").removeClass("active");
	$(".twoNav_a").eq(navUrl.two).addClass("active");
	
	
} catch (e) {
	// TODO: handle exception
	console.log(e);
}

//function selectAllMapping() {
//	$.ajax({
//		url: projectUrl + "/excel/selectAllMapping.do",
//		type: "post",
//		success: function success(data) {
//			console.log(data);
//			
//			
//			//查找选择范围dom元素
//			var selectDom = $("#selectRange");
//			selectDom.html("");
//			var fieldDom = "<option value = 'all'>全部小区</option><option value = 'VIP'>VIP小区</option>";
//			for (var i = 0; i < data.data.length; i++) {
//				fieldDom += "<option value="+data.data[i]+">" + data.data[i] + "</option>";
//			}
//			//添加范围选项
//			selectDom.append(fieldDom);
//			if (localStorage.getItem("selectRange")) {
//				selectDom.val(localStorage.getItem("selectRange"));
//			}else{
//				localStorage.setItem("selectRange","all");
//			}
//			selectDom.on("change",function(){
//				localStorage.setItem("selectRange",selectDom.val());
//				location.reload();
//			});
//		}
//	});
//};			
//
//selectAllMapping();
//	
var updatenumber =function() {
	
	var getAllSum = new Promise(function(resolve,reject){
		//需求变更，直接使用cell表中vip作为默认连表查询对象
		var getAllUrl = "";
		//如果当前位置在vip位置则查询vip小区信息，如果不在则默认查询所有top小区前20条信息
		if(two == 0){
			if(localStorage.getItem("selectRange") == "VIP"){
				getAllUrl = "/main/selectSumCell.do?threeName=null";
			}else if(localStorage.getItem("selectRange") == "校园"){
				getAllUrl = "/main/selectSumCell.do?threeName=null";
			}else{
				getAllUrl = "/main/selectSumCell.do?threeName="+localStorage.getItem("selectRange");
			}
		}
		if(two == 1){
			getAllUrl = "/main/selectHourSumCell.do?tagName=校园";
		}
		if(two == 2){
			getAllUrl = "/main/selectDaySumCell.do?tagName=校园";
		}
		$.ajax({
			url: projectUrl + getAllUrl,
			type: "post",
			success: function success(data) {
				if (data.state) {
						resolve(data.data);
				}else{
					reject(data);
					alert("表格数据查询失败");
				}
			}
		});
	});
	
	

	getAllSum.then(function(data){
		//表格对象
		var domH =$("#allData1 thead"); 
		var domB = $("#allData1 tbody");
		//重新筛选数据字段
		var fields = [];
		var dom = "<tr>";
		for (var field in data[0]) {
			if (data[0][field] != null) {
				fields.push(field);
			}
		}
		// 更改属性排序
		console.table(data);
		var xField = "hm";
		//获取url对象
	
		if(data.length == 0){
			domB.append("<h5>未查找到信息，请添加相关设置</h5>");
			return
		}
		for (var i = 0; i < fields.length; i++) {
			dom += "<th>" + fields[i].toLocaleUpperCase() + "</th>";
		}
		dom += "</tr>";
		domH.html(dom);
		domB.html("");
		for (var i = 0; i < data.length; i++) {
			var fieldDom = "<tr>";
			if(two != 2){
				for(var l = 0; l<2; l++){
					fieldDom += "<td>" + data[i][fields[l]] + "</td>";
				}
				for (var l = 2; l < fields.length; l++) {
					fieldDom += "<td><a href='javascript:;' data-toggle = 'modal' data-target= '#datas1' onclick='getdata("+'"'+data[i][fields[l]]+'",'+data[i][fields[0]]+data[i][fields[1]]+','+l+',"'+data[i][fields[2]]+'",'+two+")'>" + data[i][fields[l]] + "</a></td>";
					
				}
				
			}else{
				for(var l = 0; l<1; l++){
					fieldDom += "<td>" + data[i][fields[l]] + "</td>";
				}
				for (var l = 1; l < fields.length; l++) {
					fieldDom += "<td><a href='javascript:;' data-toggle = 'modal' data-target= '#datas1' onclick='getdata("+'"'+data[i][fields[l]]+'",'+data[i][fields[0]]+','+l+',"'+data[i][fields[1]]+'",'+two+")'>" + data[i][fields[l]] + "</a></td>";
					
				}
				
			}
			
			fieldDom += "</tr>";
			domB.append(fieldDom);
		}
		
		
	})
};
/*var getDayAllSum = new Promise(function(resolve,reject){	
	var getAllUrl = "";					
	//如果当前位置在vip位置则查询vip小区信息，如果不在则默认查询所有top小区前20条信息
		//分钟级		
//		getAllUrl = "/main/selectDaySumCell.do?tagName="+localStorage.getItem("selectRange");
		getAllUrl = "/main/selectDaySumCell.do?tagName=all";	
		$.ajax({
			url: projectUrl + getAllUrl,
			type: "post",
			success: function success(data) {
				if (data.state) {
						resolve(data.data);
				}else{
					reject(data);
					alert("表格数据查询失败");
				}
			}
		});
});*/
/*getDayAllSum.then(function(data){
	var table = 3;
	//表格对象
	var domH =$("#allData3 thead"); 
	var domB = $("#allData3 tbody");
	//重新筛选数据字段
	var fields = [];
	var dom = "<tr>";
	for (var field in data[0]) {
		if (data[0][field] != null) {
			fields.push(field);
		}
	}
	// 更改属性排序
	console.table(data);
	var xField = "hm";

	if(data.length == 0){
		domB.append("<h5>未查找到信息，请添加相关设置</h5>");
		return
	}
	for (var i = 0; i < fields.length; i++) {
		dom += "<th>" + fields[i].toLocaleUpperCase() + "</th>";
	}
	dom += "</tr>";
	domH.html(dom);
	domB.html("");
	for (var i = 0; i < data.length; i++) {
		var fieldDom = "<tr>";
		for(var l = 0; l<2; l++){
			fieldDom += "<td>" + data[i][fields[l]] + "</td>";
		}
		for (var l = 2; l < fields.length; l++) {
			fieldDom += "<td><a href='javascript:;' data-toggle = 'modal' data-target= '#datas1' onclick='getdata("+'"'+data[i][fields[l]]+'",'+data[i][fields[0]]+data[i][fields[1]]+','+l+',"'+data[i][fields[2]]+'",'+table+")'>" + data[i][fields[l]] + "</a></td>";
			
		}
		fieldDom += "</tr>";
		domB.append(fieldDom);
	}
	

});*/
var  getdata  = function(datas,stime,l,site,two){
	
	 

	var tagName = localStorage.getItem("selectRange");
	
	var getAllUrl = "";
	if(two == 0){
	
				
				getAllUrl = "/sc/selectMinAllDataByDatas.do?tagName="+tagName+"&datas="+datas+"&stime="+stime+"&l="+l+"&site="+site;		
		
	}else if(two == 1){
		getAllUrl = "/sc/selectHourAllDataByDatas.do?tagName="+tagName+"&datas="+datas+"&stime="+stime+"&l="+l+"&site="+site;
	}else if(two == 2){
		getAllUrl = "/sc/selectDayAllDataByDatas.do?tagName="+tagName+"&datas="+datas+"&stime="+stime+"&l="+l+"&site="+site;
	}
	
	var getDa = new Promise(function(resolve,reject){  
		$.ajax({
			url: projectUrl + getAllUrl,
			type: "post",
			
			success: function success(data) {				
				if (data.state) {
					
						resolve(data.data);
				}else{
					reject(data);
					alert("表格数据查询失败");
				}
			}
		});
	});
	getDa.then(function(data){
		
		//表格对象
		var domH =$("#allData4 thead"); 
		var domB = $("#allData4 tbody");
		//重新筛选数据字段
		var fields = [];
		var dom = "<tr>";
		for (var field in data[0]) {
			if (data[0][field] != null) {
				fields.push(field);
			}
		}
		// 更改属性排序
		console.table(data);
		var xField = "hm";

		if(data.length == 0){
			domH.html("");
			domB.html("");
			domB.html("<h5>查询结果为空</h5>");
			
			return
		}
		for (var i = 0; i < fields.length; i++) {
			dom += "<th>" + fields[i].toLocaleUpperCase() + "</th>";
			
		}
		dom += "</tr>";
		domH.html(dom);
		domB.html("");
		for (var i = 0; i < data.length; i++) {
			
			var fieldDom = "<tr>";
			for (var l = 0; l < fields.length; l++) {
				fieldDom += "<td>" + data[i][fields[l]] + "</td>";
				
			}
			fieldDom += "</tr>";
			domB.append(fieldDom);
		}
	});	
}


//文件下载jq方法

$("#downloadExcel").on("click", function () {
	
	var getAllUrl = "";
		getAllUrl = "/allNetwork/getDates.do?two="+two
		$.ajax({
			url: projectUrl + getAllUrl,
			type: "post",
			
			success: function success(data) {
				var data = data.data.sort();
				var getTime = data[data.length-1].split("ALLCELL")[1];
				console.log(data);
				
				var locStor = localStorage.getItem("selectRange");
				var navUrl = GetRequest();
				
				var	fileName = "";
				if(navUrl.two == 0){
						fileName = "15分钟级校园信息";
				}else if(navUrl.two == 1){
						fileName = "小时级校园信息";
				}else if(navUrl.two == 2){	
						fileName = "天级校园信息";
				}
				
//				for(var i = data.length-1 ; i > 0 ; i--){
//					var getUrl = projectUrl 
//					+ '/excel/generateHourAllNetTableExcel.do?tagName=' +locStor+'&colors='+colors;
//					myDownload(getUrl);
//				}
				fileName = fileName + getTime ;
				var getUrl = projectUrl 
				+ '/excel/generateSchoolTableExcel.do?tagName='+locStor+'&two='+navUrl.two+'&colors='+colors+'&fileName='+fileName+'.xlsx';
				myDownload(getUrl);
				
				
				
				
			}
		});
	
	
	
});



 updatenumber(); 

 













