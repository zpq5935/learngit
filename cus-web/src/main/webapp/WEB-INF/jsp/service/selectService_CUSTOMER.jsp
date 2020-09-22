<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
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
							<form name="recordform" id="recordform" action="${ctx}/service/selectService_CUSTOMER">
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
				<table width="98%" border="1" cellpadding="5" cellspacing="0" align="center" style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr class="main_trbg_tit" align="center">
						<td>序号</td>
						<!-- <td>客户</td> -->
						<td>订单</td>
						<td>产品</td>
						<td>客服</td>
						<td>维修人员</td>
						<td>申请时间</td>
						<!-- <td>维修人员确认</td> -->
						<td>创建时间</td>
						<!-- <td>客户确认</td> -->
						<td>维修起始时间</td>
						<td>维修结束时间</td>
						<td>状态</td>
						<td>申请描述</td>
						<td>评价</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${requestScope.pageInfo.list}" var="record" varStatus="stat">
						<tr id="data_${stat.index}" align="center" class="main_trbg">
							<td>${stat.count }</td>
							<%-- <td >${record.customer.nickname }</td> --%>
							<td>${record.orderid }</td>
							<td >${record.product.prodname}</td>
							<td >${record.css.nickname }</td>
							<td >${record.mainMan.nickname }</td>
							<td>
								<fmt:formatDate value="${record.datetime }" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<%-- <td>${record.mmagree}</td> --%>
							<td >
								<fmt:formatDate value="${record.createdate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<%-- <td>${record.cusagree }</td> --%>
							<td >
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
							<td align="center" >
								<c:if test="${ record.status=='C'}">
									<a href="${ctx }/service/startService?id=${record.id }&mmid=${record.mmid}">确认开始维修</a>
								</c:if>
								<c:if test="${record.status == 'E' && record.cuseva ==null}">
									<button onclick="openDialog(${record.id})">评价</button>
								</c:if>

							</td>
						</tr>
					</c:forEach>
				</table>
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

	<div id="dd" class="easyui-dialog" modal="true" closed="true" style="padding: 5px; width: 400px; height: 200px;" title="评价" iconCls="icon-ok" buttons="#dlg-buttons" style="padding:10px 20px 10px 40px;">
		<input type="hidden" id="submit_id" value="">
		<textarea cols="200" rows="5" id="myEva"></textarea>
	</div>

	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitEvalute()">提交</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dd').dialog('close')">取消</a>
	</div>
	
</body>
<script type="text/javascript">
    var pageNum = ${requestScope.pageInfo.pageNum};/* !=null ? */
    /***************************/
    $(function() {
		tableMouseHover();
		saveMyStatus();
		$("[data-toggle='popover']").popover();
    })
    /******************/
    /* 跳转功能 */
    function pageTo(pn) {
		var myHref = "${ctx}/service/selectService_CUSTOMER?pn=" + pn
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
    /* 保存订单状态 */
    function saveMyStatus() {
		$('option').each(function() {
		    if ($(this).val() == '${requestScope.myStatus}') {
				$(this).attr('selected', 'selected')
				return;
		    }
		})
    }
    /*  评价弹框*/
    function openDialog(id){
		$('#dd').dialog('open');
		$('#submit_id').val(id)
    }
    /* 确认提交 */
    function submitEvalute(){
		$('#dd').dialog('close')
    	console.log('${ctx}/service/evalute?id='+$('#submit_id').val()+'&myEva='+$('#myEva').val())
		window.location = '${ctx}/service/evalute?id='+$('#submit_id').val()+'&myEva='+$('#myEva').val();
		/* $('#dd').dialog('close')
		$('#myEva').val('') */
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