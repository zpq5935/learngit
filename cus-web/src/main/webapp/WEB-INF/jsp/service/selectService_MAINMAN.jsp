<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
<style type="text/css">
.main_trbg_tit th {text-align: center;}
.main_trbg td {text-align: center;}
</style>
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
				&nbsp;&nbsp;&nbsp;当前位置：售后管理 &gt; 查询售后
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<!-- 查询区  -->
		<tr valign="top">
			<td height="30">
				<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
					<tr>
						<td class="fftd">
							<form name="recordform" id="recordform" action="${ctx}/service/selectService_MAINMAN">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">
											<!-- 状态： -->
											<select style="display: none" name="myStatus" id="status">
												<option value="null">----</option>
												<option value="A">申请中</option>
												<option value="B">分配中</option>
												<option value="C">动身中</option>
												<option value="D">维修中</option>
												<option value="E">维修完成</option>
											</select>
											<input style="display: none" type="submit" value="搜索" />
											<button type="button" id="btnNone" class="btn btn-xs " data-container="body" data-toggle="popover" data-placement="top" data-content="">
												<font style="background-color: black">---</font>
											</button>
											<button type="button" id="btnA" class="btn btn-xs " data-container="body" data-toggle="popover" data-placement="top" data-content="">
												<font style="background-color: yellow">申请中</font>
											</button>
											<button type="button" id="btnB" class="btn btn-xs " data-container="body" data-toggle="popover" data-placement="top" data-content="">
												<font color="blue">分配中</font>
											</button>
											<button type="button" id="btnC" class="btn btn-xs " data-container="body" data-toggle="popover" data-placement="top" data-content="">
												<font style="background-color:orange;">动身中</font>
											</button>
											<button type="button" id="btnD" class="btn btn-xs " data-container="body" data-toggle="popover" data-placement="top" data-content="">
												<font style="background-color: red">维修中</font>
											</button>
											<button type="button" id="btnE" class="btn btn-xs " data-container="body" data-toggle="popover" data-placement="top" data-content="">
												<font style="background-color: green;color:white;">维修完成</font>
											</button>
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<!-- <div style="width: 90%;margin: 20 auto;" > -->
					<!-- <table class="table table-bordered"  > -->
					<table width="98%" border="1" cellpadding="5" cellspacing="0" align="center" style="border: #c2c6cc 1px solid; border-collapse: collapse;">
						<tr class="main_trbg_tit" align="center">
							<th width="36px">序号</th>
							<th width="70px" >客户</th>
							<th width="52px" >订单</th>
							<th width="97px" >产品</th>
							<th width="49px" >客服</th>
							<th width="100px" >维修人员</th>
							<th width="125px" >申请时间</th>
							<!-- <td>维修人员确认</td> -->
							<th width="125px">创建时间</th>
							<!-- <td>客户确认</td> -->
							<th width="125px">维修起始时间</th>
							<th width="125px">维修结束时间</th>
							<th width="88px">状态</th>
							<th width="88px">申请描述</th>
							<th width="88px">评价</th>
							<th width="52px">操作</th>
						</tr>
						<c:forEach items="${requestScope.pageInfo.list}" var="record" varStatus="stat">
							<tr id="data_${stat.index}" align="center" class="main_trbg">
								<td >${stat.count }</td>
								<td class="service_td">${record.customer.nickname }</td>
								<td >${record.orderid }</td>
								<td class="service_td">${record.product.prodname}</td>
								<td class="service_td">${record.css.nickname }</td>
								<td class="service_td">${record.mainMan.nickname }</td>
								<td class="service_td">
									<fmt:formatDate value="${record.datetime }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<%-- <td>${record.mmagree}</td> --%>
								<td class="service_td">
									<fmt:formatDate value="${record.createdate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<%-- <td>${record.cusagree }</td> --%>
								<td class="service_td">
									<fmt:formatDate value="${record.maidatest }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td >
									<fmt:formatDate value="${record.maidateed }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td >
									<c:choose>
										<c:when test="${record.status == 'A' }"><font style="background-color: yellow">申请中</font></c:when>
										<c:when test="${record.status == 'B' }"><font color="blue">分配中</font></c:when>
										<c:when test="${record.status == 'C' }"><font style="background-color:orange;">动身中</font></c:when>
										<c:when test="${record.status == 'D' }"><font style="background-color: red">维修中</font></c:when>
										<c:when test="${record.status == 'E' && record.cuseva !=null}"><font  style="background-color: green;color:white;">维修完成,已评价</font></c:when>
										<c:otherwise><font style="background-color: green;color:white;">维修完成,待评价</font></c:otherwise>
									</c:choose>
								</td>
								<td>
									<button type="button" class="btn btn-xs btn-success" data-container="body" data-toggle="popover" data-placement="top" data-content="${record.appremark }">查看描述</button>
								</td>
								<td>
									<button type="button" class="btn btn-xs btn-success" data-container="body" data-toggle="popover" data-placement="top" data-content="${record.cuseva }">查看评价</button>
								</td>
								<td  align="center">
									<c:if test="${ record.status=='B'}">
										<a href="${ctx }/service/receiveService?id=${record.id }&cusid=${record.cusid}">接受分配</a>
									</c:if>
									<c:if test="${ record.status=='D'}">
										<a href="${ctx }/service/endService?id=${record.id }&cusid=${record.cusid}">结束维修</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
				<!-- </div> -->

			</td>
		</tr>
		<!-- 分页标签 -->
		<tr valign="top">
			<td height="30">
				<table align="center">
					<tr>
						<!-- 页面操作 -->
						<td class="">
							<input type="button" id="firstPage" value="首页">
						</td>
						<td class="">
							&nbsp;
							<input type="button" id="prePage" value="上一页">
						</td>
						<td>&nbsp;当前第${requestScope.pageInfo.pageNum }页</td>
						<td class="">
							&nbsp;
							<input type="button" id="nextPage" value="下一页">
						</td>
						<td class="">
							&nbsp;
							<input type="button" id="lastPage" value="尾页">
						</td>
						<td class="">
							&nbsp;跳转到
							<span>
								<input id="pageNumInput" value="${requestScope.pageInfo.pageNum }" type="text" style="width: 20px">
							</span>
							<input type="button" id="PageToBtn" value="确认">
						</td>
					</tr>
					<tr class="row">
						<!-- 页面信息 -->
						<td class=""></td>
						<td class="">共${requestScope.pageInfo.pages }页</td>
						<td class="">共${requestScope.pageInfo.total }条记录</td>

					</tr>
				</table>
			</td>
		</tr>

	</table>
	<div style="height: 10px;"></div>
</body>
<script type="text/javascript">
    var pageNum = ${requestScope.pageInfo.pageNum};/* !=null ? */
    /***************************/
    $(function() {
		tableMouseHover();
		saveMyStatus();
		$('[data-toggle="popover"]').popover()
    })
    /******************/
    /* 跳转功能 */
    function pageTo(pn) {
	var myHref = "${ctx}/service/selectService_MAINMAN?pn=" + pn
		+ '&myStatus=${requestScope.myStatus}';
	window.location = myHref;
    }
    /*  */
    $('#firstPage').click(function() {
	pageTo(1);
    })
    $('#lastPage').click(function() {
	pageTo(1000);
    })
    $('#prePage').click(function() {
	pageTo(pageNum - 1);
    })
    $('#nextPage').click(function() {
	pageTo(pageNum + 1);
    })
    $("#PageToBtn").click(function() {
	pageTo($("#pageNumInput").val())
    });
    /*  */
    function saveMyStatus() {
	$('option').each(function() {
	    if ($(this).val() == '${requestScope.myStatus}') {
		$(this).attr('selected', 'selected')
		return;
	    }
	})
    }
</script>
<script type="text/javascript">
$('#btnA').click(function(){
    $('option[value!="A"]').removeAttr('selected')
    $('option[value="A"]').attr('selected','selected')
    $('#recordform').submit();
})
$('#btnB').click(function(){
    $('option[value!="B"]').removeAttr('selected')
    $('option[value="B"]').attr('selected','selected')
    $('#recordform').submit();
})
$('#btnC').click(function(){
    $('option[value!="C"]').removeAttr('selected')
    $('option[value="C"]').attr('selected','selected')
    $('#recordform').submit();
})
$('#btnD').click(function(){
    $('option[value!="D"]').removeAttr('selected')
    $('option[value="D"]').attr('selected','selected')
    $('#recordform').submit();
})
$('#btnE').click(function(){
    $('option[value!="E"]').removeAttr('selected')
    $('option[value="E"]').attr('selected','selected')
    $('#recordform').submit();
})
$('#btnNone').click(function(){
    $('option[value!="null"]').removeAttr('selected')
    $('option[value="null"]').attr('selected','selected')
    $('#recordform').submit();
})
</script>
</html>