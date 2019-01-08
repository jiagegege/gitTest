
/**
 * 导入excel 并验证
 */
console.log("excel module Has been loaded");

$('#excel-file').change(function (e) {
	var timestamp1 =new Date().getTime();
	var files = e.target.files;
	var fileReader = new FileReader();
	fileReader.onload = function (ev) {
		try {
			var data = ev.target.result,
			    workbook = XLSX.read(data, {
				type: 'binary'
			}),
			    // 以二进制流方式读取得到整份excel表格对象
			cellgroup = []; // 存储获取到的数据
		} catch (e) {
			console.log('文件类型不正确');
			return;
		}
		// 表格的表格范围，可用于判断表头是否数量是否正确
		var fromTo = '';
		// 遍历每张表读取
		for (var sheet in workbook.Sheets) {
			if (workbook.Sheets.hasOwnProperty(sheet)) {
				fromTo = workbook.Sheets[sheet]['!ref'];
				console.log(fromTo);
				cellgroup = cellgroup.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
				 break; // 如果只取第一张表，就取消注释这行
			}
		}

		console.log(cellgroup);
		var timestamp2 =new Date().getTime();
		var timestamp3 = timestamp2 -timestamp1;
		console.log("所用时间："+timestamp3);
		getData(cellgroup, $("#excelTable thead"), $("#excelTable tbody"));
	};
	// 以二进制方式打开文件
	fileReader.readAsBinaryString(files[0]);
});

$('#excel-file1').change(function (e) {
	var timestamp1 =new Date().getTime();
	var files = e.target.files;
	var fileReader = new FileReader();
	fileReader.onload = function (ev) {
		try {
			var data = ev.target.result,
			    workbook = XLSX.read(data, {
				type: 'binary'
			}),
			    // 以二进制流方式读取得到整份excel表格对象
			cellgroup = []; // 存储获取到的数据
		} catch (e) {
			console.log('文件类型不正确');
			return;
		}
		// 表格的表格范围，可用于判断表头是否数量是否正确
		var fromTo = '';
		// 遍历每张表读取
		for (var sheet in workbook.Sheets) {
			if (workbook.Sheets.hasOwnProperty(sheet)) {
				fromTo = workbook.Sheets[sheet]['!ref'];
				console.log(fromTo);
				cellgroup = cellgroup.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
				 break; // 如果只取第一张表，就取消注释这行
			}
		}

		console.log(cellgroup);
		var timestamp2 =new Date().getTime();
		var timestamp3 = timestamp2 -timestamp1;
		console.log("所用时间："+timestamp3);
		getData(cellgroup, $("#excelTable thead"), $("#excelTable tbody"));
	};
	// 以二进制方式打开文件
	fileReader.readAsBinaryString(files[0]);
});

/*提交数据*/
$(".submit").click(function () {
//	var subFlag = true;
	if (subFlag) {
		console.log(values.distinct());
		if($(".tagName").val() == "VIP小区"){
			$(".excelResult").html("VIP小区已经存在（保留字）");
			return;
		}
		if ($(".tagName").val().length > 22) {
			toastr.warning("小区组名称过长，在22个字符以内",'警告');
			return;
		}
		$.ajax({
			url: projectUrl + "/excel/setCell.do",
			data: {
				tagname: $(".tagName").val(),
				cellStr: values.distinct()
			},
			type: "post",
			success: function success(data) {
				console.log(data);
				$(".excelResult").html(data.message);
				selectAllMapping();
			}
		});
	} else {
		toastr.warning("excel文件未选择，或者excel数据格式还有错误",'警告');
		
	}
});
$(".upSubmit").click(function () {
	 
    

//	var subFlag = true;
	if (subFlag) {
		$("#myModalLabel").html("文件更新");
	    $("#modal_content").html("文件正在后台动态更新，（如果文件过大,可能时间较长）请耐心等待……");
	    //给模态框添加打开属性，使用户点击模态框外部，模态框不会关闭。
	    $('#myModal').modal({
	  	  backdrop: 'static'
	  	  });
	    $("#modalClose").hide();
	    $('#myModal').modal('show');
		console.log(values.distinct());

		$.ajax({
			url: projectUrl + "/excel/updateCellData.do",
			data: {
				tagname: localStorage.getItem("selectRange1"),
				cellStr: values.distinct()
			},
			type: "post",
			success: function success(data) {
				 $("#modal_content").html("文件更新成功，2秒后自动关闭提示框");
				   setTimeout(() => {
					   $('#myModal').modal('hide');
				   }, 2000);
				console.log(data);
				$(".excelResult").html(data.message);
				selectAllMapping();
				
			}
		});
	} else {
		
		toastr.warning("excel文件未选择，或者excel数据格式还有错误",'警告');
		
	}
});
//selectAllMapping 查询所有的小区表
function selectAllMapping() {
	$.ajax({
		url: projectUrl + "/excel/selectAllMapping.do",
		type: "post",
		success: function success(data) {
			console.log(data);
			var domB = $("#mappingTable tbody");
			domB.html("");
			var fieldDom = "";
			for (var i = 0; i < data.data.length; i++) {
				fieldDom += '<tr><td>' + data.data[i] + '</td><td><button onclick=deleteMappingBytagname("' + data.data[i] + '") type="button" class="btn btn-info">删除</button></td><td><button onclick=exportData("' + data.data[i] + '") type="button" class="btn btn-info">导出</button></td>\n\t\t\t\t\t</tr>';
				
			}
			domB.append(fieldDom);
			var selectDom = $("#selectRange1");
			selectDom.html("");
			var fieldDom = "";
			for (var i = 0; i < data.data.length; i++) {
				fieldDom += "<option value="+data.data[i]+">" + data.data[i] + "</option>";
			}
			//添加范围选项
			selectDom.append(fieldDom);
			if (localStorage.getItem("selectRange1")) {
				selectDom.val(localStorage.getItem("selectRange1"));
			}else{
				localStorage.setItem("selectRange1","all");
			}
			selectDom.on("change",function(){
				localStorage.setItem("selectRange1",selectDom.val());
//				location.reload();刷新页面
			});
		}
	});
};
selectAllMapping();

function exportData(tagName){
	var fileName = tagName;
	var getUrl = projectUrl 
	+ '/excel/generatetagNameExcel.do?tagName='+tagName+'&colors=0'+'&fileName='+fileName+'.xlsx';
	myDownload(getUrl);
	
	
	
};
function deleteMappingBytagname(tagname) {
	
	if (confirm("确定要删除" + tagname + "?")) {
		$.ajax({
			url: projectUrl + "/excel/deleteMappingByTagname.do",
			type: "post",
			data: {
				tagname: tagname
			},
			success: function success(data) {
				if (data.state) {
					toastr.success(data.message,'提示');
					selectAllMapping();
				}
			},
			error: function error() {
				toastr.warning("操作异常，可能是网络原因",'警告');
			}
		});
	}
}

var subFlag = false;
var values = [];

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
function regExcel(data) {
	
//	if (fields.indexOf("eNodebid_Cellid") == -1) {
//	toastr.warning("excel参数非法,未包含eNodebid_Cellid",'警告');
//	return;
//}
//567761_129

	var fields = [];
	for (var field in data[0]) {
		fields.push(field);
	}
	console.log(fields);

	var reg = /^\d{6}_\d{0,3}/;
	
	for (var i = 0; i < data.length; i++) {
		
		values.push(data[i][fields[0]]);
		
	}
	console.log(values);
	/*$(".excelResult").html("数据格式正确");
	for (var i = 0; i < values.length; i++) {
		if (!reg.test(values[i])) {
			//alert("第"+(i+1)+"的eNodebid_Cellid不符合规则");
			$(".excelResult").html("序号为" + (i + 1) + "的eNodebid_Cellid字段不符合规则");
			subFlag = false;
			//$("#excelTable tbody").eq(i);
			console.log(fields.indexOf("eNodebid_Cellid"));
			console.log($("#excelTable tbody tr").eq(i).children().eq(fields.indexOf("eNodebid_Cellid") + 1));
			$("#excelTable tbody tr").eq(i).children().eq(fields.indexOf("eNodebid_Cellid") + 1).addClass("err");
		}
	}*/
	subFlag = true;
}
function getData(data, domH, domB) {
	var fields = [];
	var dom = '<tr><th>\u5E8F\u53F7</th>';
	for (var field in data[0]) {
		fields.push(field);
	}
	console.log(data[0]);
	for (var i = 0; i < fields.length; i++) {
		dom += '<th>' + fields[i] + '</th>';
	}
	console.log(fields);

	dom += '</tr>';
	domH.html(dom);
	domB.html("");
	for (var i = 0; i < data.length; i++) {
		var fieldDom = '<tr><td>' + (i + 1) + '</td>';
		for (var l = 0; l < fields.length; l++) {
			fieldDom += '<td>' + data[i][fields[l]] + '</td>';
		}
		fieldDom += '</tr>';
		domB.append(fieldDom);
	}
	regExcel(data);
}
//tab 选项卡
$(function () {
    $('#myTab a:first').tab('show');
  });
  $('#myTab a').click(function (e) {
  e.preventDefault();
  $(this).tab('show');
});
//模态框加载动画
 function initLoading(){
      $("body").append("<!-- loading -->" +
              "<div class='modal fade' id='loading' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' data-backdrop='static'>" +
              "<div class='modal-dialog' role='document'>" +
              "<div class='modal-content'>" +
              "<div class='modal-header'>" +
              "<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>"+
              "<h4 class='modal-title' id='myModalLabel'>数据正在处理</h4>" +
              "</div>" +
              "<div id='loadingText' class='modal-body'>" +
              "<span class='glyphicon glyphicon-refresh' aria-hidden='true'>1</span>" +
              "处理中，请稍候。。。" +
              "</div>" +
              "</div>" +
              "</div>" +
              "</div>"
      );
  }
 initLoading();
 $('#cell_file').change(function (e) {
	 	var fileName = e.target.files[0].name;
	 	$("#loadingText").html("<p>系统正在解析"+fileName+"文件……</p>");
	    $("#loading").modal("show");
		var files = e.target.files;
		var fileReader = new FileReader();
		fileReader.onload = function (ev) {
			try {
				var data = ev.target.result,
				    workbook = XLSX.read(data, {
					type: 'binary'
				}),
			// 以二进制流方式读取得到整份excel表格对象
				cell = []; // 存储获取到的数据
			} catch (e) {
				console.log('文件类型不正确');
				return;
			}
			// 表格的表格范围，可用于判断表头是否数量是否正确
			var fromTo = '';
			// 遍历每张表读取
			for (var sheet in workbook.Sheets) {
				if (workbook.Sheets.hasOwnProperty(sheet)) {
					fromTo = workbook.Sheets[sheet]['!ref'];
					cell = cell.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
					break; // 如果只取第一张表，就取消注释这行
				}
			}
			 $("#loadingText").append("<p>"+fileName+"数据解析完成</p>");
			 $("#loadingText").append("<p>正在校验"+fileName+"数据格式</p>");
			 var flag = true;
			//eCellName_Cn属性查重
			 var repit = unique(cell,"eCellName_Cn");
			 //数组长度为0 ，则属性验证通过
			 if(repit.length == 0 && $.type(repit) == "array"){
				 $("#loadingText").append("<p>eCellName_Cn通过验证</p>");
			 }else if($.type(repit) == "number"){
				 $("#loadingText").append("<p>第"+repit+"行的eCellName_Cn为空</p>");
				 flag = false;
			 }else{
				 flag = false;
			 }
			 for(var i = 0;i<repit.length;i++){
				 var index1 = repit[i][0];
				 var index2 = repit[i][1];
				 $("#loadingText").append(`<p>第${repit[i][0]+2}行和${repit[i][1]+2}行，eCellName_Cn为:"${cell[index1].eCellName_Cn}"的小区重复</p>`);
			 }
			 //"eNodebid","CELLID"属性组合查重
			 var repit1 =doubleUnique(cell,"eNodebid","CELLID");
			 if(repit1.length == 0 && $.type(repit) == "array"){
				 $("#loadingText").append("<p>eNodebid-CELLID通过验证</p>");
			 }else if($.type(repit) == "number"){
				 $("#loadingText").append("<p>第"+repit+"行的eNodebid或CELLID为空</p>");
				 flag = false;
			 }else{
				 flag = false;
			 }
			 for(var i = 0;i<repit1.length;i++){
				 var index1 = repit1[i][0];
				 var index2 = repit1[i][1];
				 $("#loadingText").append(`<p>第${repit[i][0]+2}行和${repit[i][1]+2}行，eNodebid_CELLID为:"${cell[index1].eNodebid}-${cell[index1].CELLID}"的小区重复</p>`);
			 };
			//"eNodebid","LCRID"属性组合查重
			 var repit2 =doubleUnique(cell,"eNodebid","LCRID");
			 if(repit2.length == 0 && $.type(repit) == "array"){
				 $("#loadingText").append("<p>eNodebid-LCRID通过验证</p>");
			 }else if($.type(repit) == "number"){
				 $("#loadingText").append("<p>第"+repit+"行的eNodebid或LCRID为空</p>");
				 flag = false;
			 }else{
				 flag = false;
			 }
			 for(var i = 0;i<repit2.length;i++){
				 var index1 = repit2[i][0];
				 var index2 = repit2[i][1];
				 $("#loadingText").append(`<p>第${repit[i][0]+2}行和${repit[i][1]+2}行，eNodebid_LCRID为:"${cell[index1].eNodebid}-${cell[index1].LCRID}"的小区重复</p>`);
			 };
			 //检查 Enodebid_Cellid,需求更改，不需要检查Enodebid_Cellid属性
//			 var repit3 = attributeCheck(cell,"eNodebid","CELLID");
//			 if(repit3.length == 0 && $.type(repit) == "array"){
//				 $("#loadingText").append("<p>Enodebid_Cellid通过验证</p>");
//			 }else{
//				 flag = false;
//			 }
//			 for(var i = 0;i<repit3.length;i++){
//				 $("#loadingText").append(`<p>第${repit3[i]+2}行的 Enodebid_Cellid未通过验证</p>`);
//			 };
			 if(flag){
				//提交文件到后台
				//提取excel的第一行，传递给后台，以供后台创建map，解析excel使用
				 var fields = Object.keys(cell[0]);
				 //添加没有解析到的属性
				 fields.push("覆盖区域");
				 fields.push("分组");
				 fields.push("VIP");
				 fields.push("VIP类型");
				 fields.push("基站类别");
				 //添加excel中可能没有出现的属性
				 fields.push("Lonx");
				 fields.push("LatY");
				 fields.push("SectXY");
				 fields.push("Enodebid_LCRID");
				 console.log(fields);
				 // 数组去重，因为excel是变化的,为了避免属性重复，进行数组去重
				 fields =  fields.distinct();
				 updateCell(fields,fileName);
			 }else{
				 $("#loadingText").append("<p>"+fileName+"文件未通过验证，请依据提示更改excel,再次提交</p>");
			 }
		};
		// 以二进制方式打开文件 readAsBinaryString此方法会将线程卡死，所以延后300毫秒，确保页面动画完成
		setTimeout(function(){
			fileReader.readAsBinaryString(files[0]);
		},300);
 });
 //显示模态框
  function showLoading(text){
      $("#loadingText").html(text);
      $("#loading").modal("show");
      console.log("已经执行了 model");
  }
//隐藏模态框
  function hideLoading(){
      $("#loading").modal("hide");
  }
//  提交小区excel文件
function updateCell(fields,fileName){
	//创建表单数据对象
	$("#loadingText").append("<p>"+fileName+"文件正在提交服务器（解析数据时间可能过长，请耐心等待）……</p>");
	var formData = new FormData();
	var fileNode = document.getElementById("cell_file");
	formData.append("file", fileNode.files[0]);
	formData.append("fields", fields);
	$.ajax({
		url:projectUrl + "/excel/updateCell.do",
		type:"post",
		data:formData,
		contentType : false,
		processData : false,
		success:function(data){
			if(data.state == 1){
				//先给数据清空，这样醒目一点
				$("#loadingText").html("");
				$("#loadingText").append("<p>excel处理完成，解析成功</p>");
			}else{
				$("#loadingText").append("<p>"+data.message+"</p>");
			}
		},error:function(){
			$("#loadingText").append("<p>未知错误，可能是网络原因</p>");
		}
	});
}
  //数组查重 单属性检查 将检查结果放到二维数组中返回
  function unique(arr,attribute){
	  	var repet =[];
	    var hash = {};
	    for ( var i=0;i<arr.length;i++){
	        var key = arr[i][attribute];
	        //判断是否存在该属性
	        if(key == undefined){
	        	return i+1;
	        }
	        if(!hash[key]){
	            hash[key] = i;
	        }else{
	        	var resule = [];
	        	resule.push(i);
	        	resule.push(hash[key]);
	        	repet.push(resule);
	        }
	    }
	    return repet;
	}
  //数组查重 双重属性检查 将检查结果放到二维数组中返回
  function doubleUnique(arr,attribute1,attribute2){
	  	var repet =[];
	    var hash = {};
	    for (var i=0;i<arr.length;i++){
	        var key = arr[i][attribute1]+arr[i][attribute2];
	      //判断是否存在该属性
	        if(arr[i][attribute1] == undefined || arr[i][attribute2] == undefined ){
	        	return i+1;
	        }
	        if(!hash[key]){
	            hash[key] = i;
	        }else{
	        	var resule = [];
	        	resule.push(i);
	        	resule.push(hash[key]);
	        	repet.push(resule);
	        }
	    }
	    return repet;
  }
  //检查属性是否符合规则，检查数据的属性拼接是否正常，异常数据超过8，则直接返回错误数据，中断查询（提高性能）
  function attributeCheck(arr,attribute1,attribute2){
	  var repet =[];
	  for ( var i=0;i<arr.length;i++){
		  if(arr[i].eNodebid_Cellid != (arr[i][attribute1]+"_"+arr[i][attribute2])){
			  if(repet.length > 8){
				  return repet;
			  }
			  repet.push(i);
		  }
	  }
	  return repet;
  }
  //获取渲染表格的excel
  function getCriticalValue(){
	  $.ajax({
				url:projectUrl + "/setValue/getJsonValue.do",
				dataType:"json",
				data:{
						flag:"allNet",
						username:thisUsername
					},
				success:function(data){
					data.data = JSON.parse(data.data);
					console.log(data);
					var dom = $(".criticalAllNetTable tbody");
					showSetValue(data.data,dom);
					
					$("#allNetBtn").off("click").click(function(){
						serializeTable($(".criticalAllNetTable tbody tr"),"allNet");
					});
					
				}
			});
	  $.ajax({
			url:projectUrl + "/setValue/getJsonValue.do",
			data:{
					flag:"topCell",
					username:thisUsername
				},
			success:function(data){
				data.data = JSON.parse(data.data);
				console.log(data);
				var dom = $(".criticalTopCellTable tbody");
				showSetValue(data.data,dom);
				$("#topCellBtn").off("click").click(function(){
					serializeTable($(".criticalTopCellTable tbody tr"),"topCell");
				});
			}
		});
  }
  getCriticalValue();
  //显示告警值的表格数据
  function showSetValue(data,dom){
	  var domStr = "";
		dom.html("");
		for(var i = 0;i<data.length;i++){
			var doms = "";
			if(data[i].symbol == "0"){
				doms = "<option value='0' selected = \"selected\"><</option>"+
				"<option value='1'>></option>";
			}else{
				doms = "<option value='0'><</option>"+
				"<option value='1' selected = \"selected\">></option>";
			}
			domStr += "<tr>"+
				"<td class='attribute"+i+" htmltext'>"+data[i].attribute+"</td>"+
				"<td>"+
					"<input id='compare"+i+"' class='form-control input-sm' value='"+data[i].compare+"' type='number' placeholder='请输入临界值'>"+
				"</td>"+
				
			"</tr>";
		}
		dom.html(domStr);
  }
  /**
   * 整理表格中的报警值
   * @param dom 表格中的$(".criticalAllNetTable tbody tr") tr元素数组（jq对象）
   * @param flag 表示是全网级还是小区级的
   * @returns
   */
  function serializeTable(dom,flag){
	  var jsonvalue = serializationJSON(dom);
	  $.ajax({
				url:projectUrl + "/setValue/setJsonValue.do",
				data:{
						jsonValue:JSON.stringify(jsonvalue),
						flag:flag,
						username:thisUsername
					},
				success:function(data){
					if(data.state == 1){
						
						toastr.success(data.message, '提示');
						
					}
				}
			});
  }
  //serialization json for document
  var serializationJSON = function(dom){
	  var jsonvalue = [];
	  for(var i = 0;i<dom.length;i++ ){
		  var obj = {};
		  var attribute = dom.eq(i).find(".attribute"+i).html();
		  obj.attribute = attribute;
		  var compare = dom.eq(i).find("#compare"+i).val(); 
		  obj.compare = compare;
		  var symbol = dom.eq(i).find("#symbol"+i).val(); 
		  obj.symbol = 0;
		  jsonvalue.push(obj);
	  }
	  return jsonvalue;
  }