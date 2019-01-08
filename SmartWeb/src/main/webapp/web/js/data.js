


var number = null;

if(localStorage.getItem("numglobal")){
	number = localStorage.getItem("numglobal");
	
}else{
	localStorage.setItem("numglobal",4);
	
}






/*$(".changenum").attr("display", "hide");*/
/**
 * 数据处理相关
 */
/* 显示更多图表 */
$(".showBtn").on("click", function () {
	var blockFlag = $(".hideBlock").attr("display");
	if (blockFlag == "hide") {
		$(".hideBlock").css({
			height: "100%"
		});
		$(".hideBlock").attr("display", "show");
		$("#showmore")[0].className = "glyphicon glyphicon-menu-down showmoreIcon";
		$("#showmoreText").html("收起");
	} else {
		$(".hideBlock").css({
			height: "0"
		});
		$(".hideBlock").attr("display", "hide");
		$("#showmore")[0].className = "glyphicon glyphicon glyphicon-menu-up showmoreIcon";
		$("#showmoreText").html("显示更多");
	}
});

// 基于准备好的dom，初始化echarts实例
/* option*数据参见echartData.js */
/* 线性图标 */
var myChart1 = echarts.init($(".table1")[0]);
var option1 = jQuery.extend(true, {}, option2);
option1.title.text = "无线接通率";
option1.series[0].name = "无线接通率";
option1.series[0].type = "line";
setMinMax(option1, 0.1);
setToFixed(option1, 2);
myChart1.setOption(option1);
/* 柱状图表 */
var myChart2 = echarts.init($(".table2")[0]);
myChart2.setOption(option2);

var myChart3 = echarts.init($(".table5")[0]);
var option3 = jQuery.extend(true, {}, option2);
option3.title.text = "流量GB";
option3.series[0].name = "流量GB";
//myChart3.setOption(option3);

var myChart4 = echarts.init($(".table6")[0]);
var option4 = jQuery.extend(true, {}, option2);
option4.title.text = "上行干扰";
option4.series[0].name = "上行干扰";
option4.series[0].type = "line";
setMinMax(option4, 2);
myChart4.setOption(option4);

var myChart5 = echarts.init($(".table7")[0]);
var option5 = jQuery.extend(true, {}, option2);
option5.title.text = "掉线率";
option5.series[0].name = "掉线率";
option5.series[0].type = "line";
setToFixed(option5, 2);
setMinMax(option5, 0.1);
myChart5.setOption(option5);

var myChart6 = echarts.init($(".table8")[0]);
var option6 = jQuery.extend(true, {}, option2);
option6.title.text = "切换成功率";
option6.series[0].name = "切换成功率";
setToFixed(option6, 2);
option6.series[0].type = "line";
setMinMax(option6, 0.1);

var myChart7 = echarts.init($(".table5")[0]);
var option7 = jQuery.extend(true, {}, option2);
option7.title.text = "平均激活用户数";
option7.series[0].name = "平均激活用户数";
setToFixed(option7, 1);
option7.series[0].type = "line";
setMinMax(option7, 10);
//重新定义最大值，最小值的算法 
function setMinMax(option, number) {
	console.log(option);
	option.yAxis[0].min = function () {
		console.log((option.series[0].data.min() - number).toFixed(3));
		return (option.series[0].data.min() - number).toFixed(3);
	};
	option.yAxis[0].max = function () {
		var num = parseFloat(option.series[0].data.max()) + number;
		var num2 = num > 100 ? 100 : num;
		console.log(num2.toFixed(2));
		return num2.toFixed(2);
	};
}
//设置保留几位小数
function setToFixed(option, number) {
	option.yAxis[0].axisLabel.formatter = function (value, index) {
		return value.toFixed(number);
	};
}
myChart6.setOption(option6);
/*图表初始化完毕*/
/* 图标跟随页面大小进行响应式变化 */
$(window).resize(function () {
	myChart1.resize();
	myChart2.resize();
	myChart3.resize();
	myChart4.resize();
	myChart5.resize();
	myChart6.resize();
	myChart7.resize();
});
//查询链路故障
function getLinkFailure() {
	$.ajax({
		url: projectUrl + "/main/selectLinkFailure.do",
		data:{
			tagName :localStorage.getItem("selectRange")
		},
		type: "post",
		success: function success(data) {
			console.log(data);
			// 提取数据显示到图表上
			var xAxis = [];
			var series = [];
			for (var i = 0; i < data.data.length; i++) {
				var xdata = data.data[i].datetime;
				xAxis.push(xdata.substring(xdata.length-4,xdata.length));
				series.push(data.data[i].num);
			}
			option2.xAxis[0].data = xAxis;
			option2.series[0].data = series;
			console.log(option2);
			myChart2.setOption(option2);
		}
	});
}
//查询链路故障---- 只在十五分钟显示链路故障
if(navUrl.three == 0){
	getLinkFailure();
	myChart3.setOption(option3);
}else{
	myChart2.setOption(option3);
}
//查询数据，渲染到表格中，图表中（全网数据）
var getAllUrl = "";
//如果当前位置在十五分钟重点级别，则需要添加threeName参数
if(navUrl.three == 0){
	$("#changenum").show();
	var locStor = localStorage.getItem("selectRange");
	if(locStor == "all"){
		getAllUrl = "/main/selectAllData.do?threeName=null";
	}else{
		
		getAllUrl = "/main/selectAllData.do?threeName="+localStorage.getItem("selectRange");
	}
	
}else if(navUrl.three == 1){
	$("#changenum").hide();
	getAllUrl = "/main/selectHourAllNetCell.do?tagName="+localStorage.getItem("selectRange");
}else{ 
	$("#changenum").hide();
	getAllUrl = "/main/selectDayAllNetCell.do?tagName="+localStorage.getItem("selectRange");
}

var updatenumber =function() {
	//异步获取全网数据
	var getDataProAll = new Promise(function(resolve,reject){  
		$.ajax({
			url: projectUrl + getAllUrl,
			type: "post",
			data:{
				number:localStorage.getItem("numglobal")
			},
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



		
	//查询全网数据
	//更改使用promise，获取数据
	getDataProAll.then(function(data){
		//获取表格对象
		var domH =$("#allData1 thead"); 
		var domB = $("#allData1 tbody");
		// 提取数据显示到图表上
		var xAxis = [];
		var series = [];
		//	获取url对象
		var url = GetRequest();
		//	根据url对象，查询相应的横坐标字段
		var xField = "hm";
		if (url.three == 1) {
			xField = "hh";
		}else if(url.three == 2){
			xField = "day1";
		}
		//js数组排序方法
		var compare = function (prop) {
		    return function (obj1, obj2) {
		        var val1 = obj1[prop];
		        var val2 = obj2[prop];
		        if (val1 < val2) {
		            return -1;
		        } else if (val1 > val2) {
		            return 1;
		        } else {
		            return 0;
		        }            
		    } 
		}
		//依据数据的时间进行排序
		data.sort(compare(xField));
		for (var i = 0; i < data.length; i++) {
			if(data[i]){
				xAxis.push(data[i][xField]);
				series.push(data[i].无线接通率);
			}
		}
		//	流量GB、干扰、掉线率、切换成功率
		var flow = []; //流量GB
		var disturb = []; //干扰
		var drops = []; //掉线率
		var handoverSuccessRate = []; //切换成功率
		var wirelessConnectivity = []; //无线接通率
		var AverageNumberActiveUsers = [];//平均激活用户数
		option2.xAxis.data = xAxis;
		/**
		  * 绘制图表的算法
		  * array, 数据
		  * attribute, 字段
		  * myChart, 图表对象
		  * option 图表配置
		  */
		function drawChart(array, attribute, myChart, option) {
			for (var i = 0; i < data.length; i++) {
				if(data[i]){
					array.push(data[i][attribute]);
				}
			}
			option.xAxis[0].data = xAxis;
			option.series[0].data = array;
			myChart.setOption(option);
			
		};
		drawChart(wirelessConnectivity, "无线接通率", myChart1, option1);
		if(navUrl.three == 0){
			drawChart(flow, "流量GB", myChart3, option3);
		}else{
			//小时级和天级将链路故障替换为 平均用户激活数
			drawChart(flow, "流量GB", myChart2, option3);
			drawChart(AverageNumberActiveUsers, "平均激活用户数", myChart7, option7);
		}
		drawChart(disturb, "上行干扰", myChart4, option4);
		drawChart(drops, "无线掉线率", myChart5, option5);
		drawChart(handoverSuccessRate, "切换成功率", myChart6, option6);
		
		//渲染表格数据
		console.log(data.data);
		// value 不为空的字段
		var fields = [];
		var dom = "<tr>";
		for (var field in data[0]) {
			if (data[0][field] != null) {
				fields.push(field);
			}
		}
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
		data.reverse();
		for (var i = 0; i < data.length; i++) {
			
			var fieldDom = "<tr>";
			for (var l = 0; l < fields.length; l++) {
				
				fieldDom += "<td>" + data[i][fields[l]] + "</td>";
			}
			fieldDom += "</tr>";
			domB.append(fieldDom);
		}
		var criticalValues = [];
		var criticalValue = {
			//属性
			attribute:"无线接通率",
			//临界值
			compare:99.7,
			//0代表< 1代表>
			symbol:0
		};
		criticalValues.push(criticalValue);
		criticalValue = {
				attribute:"无线掉线率",
				compare:0.2,
				symbol:1
			};
		criticalValues.push(criticalValue);
		criticalValue = {
			attribute:"切换成功率",
			compare:98,
			symbol:0
		};
		criticalValues.push(criticalValue);
		var str = JSON.stringify(criticalValues);
		console.log(str);
		var str1 = JSON.parse(str);
		console.log(str1);
		drawDataCorol1(fields,data,domB,criticalValues);
		$.ajax({
			url:projectUrl + "/setValue/getJsonValue.do",
			dataType:"json",
			data:{
					flag:"allNet",
					username:thisUsername
				},
			success:function(datas){
				datas.data = JSON.parse(datas.data);		
				console.log(datas.data);
				console.log(criticalValues);
				drawDataCorol1(fields,data,domB,datas.data);
			}
		});
	});
}


/**
 * 根据数据值大小判断，数据是否报警
 * fields, 全部字段=》 用于查找属性位置
 * data, 全部数据=》获取到数据值
 * domB, =》dom位置
 * compare,=》警戒值
 * attribute, =》比较的属性
 * symbol =》符号 0代表 “<” ，1代表 “>”
 */
var drawDataCorol1 = function(fields,data,domB,criticalValues){
	var indexs = [];
	for(var s = 0 ;s<criticalValues.length;s++){
		indexs[s] = fields.indexOf(criticalValues[s].attribute);
	}
	for (var i = 0; i < data.length; i++) {
		for(var l = 0 ;l<criticalValues.length;l++){
			var flag = Number(data[i][criticalValues[l].attribute]) < Number(criticalValues[l].compare);
			if(criticalValues[l].symbol == 1){
				flag = !flag;
			}
			if(flag){
				domB.children().eq(i).children().eq(indexs[l]).css({"color": "#eee","background": "red" });
			}else{
				domB.children().eq(i).children().eq(indexs[l]).css({"color": "#eee","background": "green" });
			}
			
		}
	}
	
}


//查询数据，渲染到表格中（top数据）
var getDataProTop = new Promise(function(resolve,reject){
	//需求变更，直接使用cell表中vip作为默认连表查询对象
	var getTopUrl = "";
	//如果当前位置在vip位置则查询vip小区信息，如果不在则默认查询所有top小区前20条信息
	if(navUrl.three == 0){
		if(localStorage.getItem("selectRange") == "VIP"){
			getTopUrl = "/main/getVipCellInfo.do";
		}else if(localStorage.getItem("selectRange") == "all"){
			getTopUrl = "/main/selectTopCell.do?threeName=null";
		}else{
			getTopUrl = "/main/selectTopCell.do?threeName="+localStorage.getItem("selectRange");
		}
	}
	if(navUrl.three == 1){
		getTopUrl = "/main/selectHourTopCell.do?tagName="+localStorage.getItem("selectRange");
	}
	//selectDayTopCell.do
	if(navUrl.three == 2){
		getTopUrl = "/main/selectDayTopCell.do?tagName="+localStorage.getItem("selectRange");
	}
	$.ajax({
		url: projectUrl + getTopUrl,
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
var getAllSum = new Promise(function(resolve,reject){
	//需求变更，直接使用cell表中vip作为默认连表查询对象
	var getAllUrl = "";
	//如果当前位置在vip位置则查询vip小区信息，如果不在则默认查询所有top小区前20条信息
	if(navUrl.three == 0){
		if(localStorage.getItem("selectRange") == "VIP"){
			getAllUrl = "/main/selectNewSumCell.do?threeName=null";
		}else if(localStorage.getItem("selectRange") == "all"){
			getAllUrl = "/main/selectNewSumCell.do?threeName=null";
		}else{
			getAllUrl = "/main/selectNewSumCell.do?threeName=null";
		}
	}
	if(navUrl.three == 1){
//		getAllUrl = "/main/selectHourNewSumCell.do?tagName="+localStorage.getItem("selectRange");
		getAllUrl = "/main/selectHourNewSumCell.do?tagName=all";
	}
	//selectDayTopCell.do
	if(navUrl.three == 2){
//		getAllUrl = "/main/selectDaySumCell.do?tagName="+localStorage.getItem("selectRange");
		getAllUrl = "/main/selectDayNewSumCell.do?tagName=all";
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
	$("#downloadExcel").on("click",function(){
		alert("进");
		
		
	});
});


getAllSum.then(function(data){
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
	//获取url对象
	var url = GetRequest();
	if (url.three == 2) {
		xField = "hh";
	}
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
		for (var l = 0; l < fields.length; l++) {
			fieldDom += "<td>" + data[i][fields[l]] + "</td>";
			
		}
		fieldDom += "</tr>";
		domB.append(fieldDom);
	}
	
})
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
/* 如果存在历史选择缓存则设置为默认 */
function keyPoint15(arr) {
	//查看是否存在本地缓存(15分钟)
//	if (localStorage.getItem("keyPoint15")) {
//		//查询本地缓存的小区组，在服务器中是否存在
//		var key = localStorage.getItem("keyPoint15");
//		if (arr.indexOf(key) != -1) {
//			$(".keyPoint15 a").html(key+" (15分钟)");
//		} else {
//			$(".keyPoint15 a").html("VIP小区	(15分钟)");
//		}
//	} else {
//		//如果不存在则设置则默认选择第一个
//		localStorage.setItem("keyPoint15", "VIP小区 (15分钟)");
//		$(".keyPoint15 a").html("VIP小区 (15分钟)");
//	}
//	//查看是否存在本地缓存(小时)
//	if (localStorage.getItem("HourMenu")) {
//		//查询本地缓存的小区组，在服务器中是否存在
//		var key = localStorage.getItem("HourMenu");
//		if (arr.indexOf(key) != -1) {
//			$(".keyPointHour a").html(key+" (小时)");
//		} else {
//			$(".keyPointHour a").html("VIP小区   (小时)");
//		}
//	} else {
//		//如果不存在则设置则默认选择第一个
//		localStorage.setItem("HourMenu", "VIP小区 (小时)");
//		
//		$(".keyPointHour a").html("VIP小区 (小时)");
//	}
	getDataProTop.then(function(data){
		//表格对象
		var domH =$("#allData2 thead"); 
		var domB = $("#allData2 tbody");
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
		var url = GetRequest();
		if (url.three == 2) {
			xField = "hh";
		}
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
			for (var l = 0; l < fields.length; l++) {
				fieldDom += "<td>" + data[i][fields[l]] + "</td>";
			}
			fieldDom += "</tr>";
			domB.append(fieldDom);
		}
		var criticalValues = [];
		var criticalValue = {
			//属性
			attribute:"无线接通率",
			//临界值
			compare:99.3,
			//0代表< 1代表>
			symbol:0
		};
		criticalValues.push(criticalValue);
		criticalValue = {
				attribute:"无线掉线率",
				compare:0.3,
				symbol:1
			};
		criticalValues.push(criticalValue);
		criticalValue = {
			attribute:"切换成功率",
			compare:95,
			symbol:0
		};
		criticalValues.push(criticalValue);
		 $.ajax({
				url:projectUrl + "/setValue/getJsonValue.do",
				dataType:"json",
				data:{
						flag:"topCell",
						username:thisUsername
					},
				success:function(datas){
					datas.data = JSON.parse(datas.data);
					drawDataCorol1(fields,data,domB,datas.data);
				}
			});
		//drawDataCorol1(fields,data,domB,criticalValues);
	})
}
//!!!
//获取小区组设置
function selectAllMapping() {
	$.ajax({
		url: projectUrl + "/excel/selectAllMapping.do",
		type: "post",
		success: function success(data) {
			console.log(data);
			keyPoint15(data.data);
			//十五分钟选项DOM容器
			var domB = $(".keyPoint");
			//小时级选项DOM容器
			var domBH = $(".HourMenu");
			//如果没有小区组设置，则进行提示，终端function操作
			if (data.data.length == 0) {
				domB.append("<li><a>您还没有添加小区组，请前往设置页面添加</a></li>");
				//hourMenu.append("<li><a>您还没有添加小区组，请前往设置页面添加</a></li>");
				//return;
			}
			//查找选择范围dom元素
			var selectDom = $("#selectRange");
			selectDom.html("");
			var fieldDom = "<option value = 'all'>全部小区</option><option value = 'VIP'>VIP小区</option>";
			for (var i = 0; i < data.data.length; i++) {
				fieldDom += "<option value="+data.data[i]+">" + data.data[i] + "</option>";
			}
			//添加范围选项
			selectDom.append(fieldDom);
			if (localStorage.getItem("selectRange")) {
				selectDom.val(localStorage.getItem("selectRange"));
			}else{
				localStorage.setItem("selectRange","all");
			}
			selectDom.on("change",function(){
				localStorage.setItem("selectRange",selectDom.val());
				location.reload();
			});
			
			//先对容器进行清空
			//domB.html("");
			//domBH.html("");
			//默认添加VIP选项
//			var fieldDom = "<li><a>VIP小区</a></li>";
//			for (var i = 0; i < data.data.length; i++) {
//				fieldDom += "<li><a>" + data.data[i] + "</a></li>";
//			}
			//十五分钟级选项
			//domB.append(fieldDom);
			//天级选项
			//domBH.append(fieldDom);
			/**
		    * 保存用户三级导航的选项
		    */
			//封装option 选项卡点击事件
			/**
			 * Dom 元素容器 字符串选择器
			 * flag 用于判断是否在当前页面
			 * key localStorage保存所用的key
			 */
//			var clickReload = function (Dom,DomContainer,flag,key,suffix){
//				$(Dom+" li").each(function (i) {
//					$(this).on("click", function () {
//						//将选项卡内容，存储进本地缓存
//						localStorage.setItem(key, $(Dom+" li a").eq(i).html());
//						//如果位置在当前页面 ，则直接刷新
//						if (navUrl.three == flag) {
//							//使页面进行刷新
//							location.reload();
//						}
//						//显示相应的选项卡
//						$(DomContainer+" a").html($(Dom+" li a").eq(i).html()+suffix);
//					});
//				});
//			};
			//十五分钟级选项卡点击事件
			//clickReload(".keyPoint",".keyPoint15",1,"keyPoint15","(15分钟)");
			//小时级选项卡点击事件
			//clickReload(".HourMenu",".keyPointHour",2,"HourMenu","(小时)");
		}
	});
};
//查询所有小区组，渲染到相应位置
selectAllMapping();
updatenumber();


$("#numbtn").on("click", function () {
	var number = $("#numbers").val();
	localStorage.setItem("numglobal",number);
	
	updatenumber();
});



	
	
		
		







