//指定图标的配置和数据
var option = {
	title : {
		text : 'ECharts 数据统计'
	},
	tooltip : {},
	legend : {
		data : [ '用户来源' ]
	},
	xAxis : {
		data : [ "Android", "IOS", "PC", "Ohter" ]
	},
	yAxis : {

	},
	series : [ {
		name : '访问量',
		type : 'line',
		data : [ 500, 200, 360, 100 ]
	} ]
};
// 初始化echarts实例
var myChart = echarts.init(document.getElementById('chartContainer'));

// 使用制定的配置项和数据显示图表
myChart.setOption(option);
