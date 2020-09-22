<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
<script src="${ctx }/js/echarts.min.js" type="text/javascript"></script>
<script src="${ctx }/js/myChart.js" type="text/javascript"></script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locleft.gif" width="15" height="32">
			</td>
			<td class="main_locbg font2">
				<img src="${ctx}/images/pointer.gif">
				&nbsp;&nbsp;&nbsp;当前位置：统计报表 &gt; 订单统计
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<tr>
			<td>
				<select id="sel" style="float: right">
					<option value="product">以产品分类</option>
					<option value="month">以月份分类</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<div id="chartContainer" style="height: 600px; width: 600px"></div>
			</td>
		<tr>
	</table>


</body>
<script type="text/javascript">
    //指定图标的配置和数据
    var option = {
	title : {
	    text : '订单统计'
	},
	tooltip : {
	    feature: {
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
	    }
	},
	legend : {
	    data : [ '用户来源' ]
	},
	xAxis : {
	    data : []
	},
	yAxis : {

	},
	series : [ {
	    name : '订单次数',
	    type : 'line',
	    data : []
	} ]
    };
    // 初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartContainer'));
    // 使用制定的配置项和数据显示图表
    myChart.setOption(option);
</script>
<script>
	$(function() {
	    selDataByProduct();
	})
	/* 将数据data装换成echarts所需的数组类型 */
	function data2Arr(data, xDataArr, serDataArr) {
		$.each(data, function(index, item) {
		    serDataArr.push(item.size);
		    xDataArr.push(item.xAxis);
		});
	}
	/* 发送ajax请求，按产品分类获取维修记录 */
	function selDataByProduct(){
	    $.ajax({
		    url : "${ctx}/report/orderReportByProd",
		    type : "GET",
		    success : function(result) {
				console.log(result);
				option.title.text = "订单统计";
				var xDataArr = new Array();
				var serDataArr = new Array();
		
				data2Arr(result, serDataArr, xDataArr);
		
				console.log(xDataArr, serDataArr);
				option.xAxis.data = serDataArr;
				option.series[0].data = xDataArr;
				option.series[0].type = 'bar';
				// 使用制定的配置项和数据显示图表
				myChart.setOption(option);
		    }
		});
	}
	/* 发送ajax请求，按时间分类获取维修记录 */
	function selDataByMonth(){
	    $.ajax({
		    url : "${ctx}/report/orderReportByTime",
		    type : "GET",
		    success : function(result) {
				console.log(result);
				option.title.text = "订单统计";
				var xDataArr = new Array();
				var serDataArr = new Array();
		
				data2Arr(result, serDataArr, xDataArr);
		
				console.log(xDataArr, serDataArr);
				option.xAxis.data = serDataArr;
				option.series[0].data = xDataArr;
				option.series[0].type = 'line';
				// 使用制定的配置项和数据显示图表
				myChart.setOption(option);
		    }
		});
	}
	/* 当下拉列表框改变时调用对应的函数 */
	$('#sel').change(function(){
	    console.log($('option:selected').val())
	    if($('option:selected').val()=='product'){
			selDataByProduct();
	    }
	    else{
			selDataByMonth();
	    }
	});
</script>
    
   
</html>