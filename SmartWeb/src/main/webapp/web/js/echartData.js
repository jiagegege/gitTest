/*table1 为统一风格 全部使用option2*/
/*   table2*/
option2 = {
	title : {
		text : '链路故障'
	},
	color : [ '#3398DB' ],
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
	grid : {
		left : '3%',
		right : '4%',
		bottom : '3%',
		containLabel : true
	},
	toolbox : {
		feature : {
			saveAsImage : {},
			magicType : {
				type : [ 'line', 'bar' ]
			},
			dataZoom : {
				show : true
			},
			restore : {
				show : true
			}
		},
		right : "5%"
	},
	xAxis : [ {
		type : 'category',
		data : [],
		axisTick : {
			alignWithLabel : true
		}
	} ],
	yAxis : [ {
		type : 'value',
		splitNumber : 5,
		scale : false,
		axisLabel : {
			formatter : function(value, index) {
				console.log("indexa"+index);
				return value.toFixed(0);
			}
		}
	} ],
	series : [ {
		name : '链路故障',
		type : 'bar',
		barWidth : '60%',
		symbolSize : 10,
		data : []
	} ]
};

