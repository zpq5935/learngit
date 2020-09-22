<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/myDatetime.js"></script>
<title>产品售后跟踪管理系统</title>
<script type="text/javascript">
	/** 文档加载完成后立即执行的方法 */
	// var weeks = new Array();
	$(function() {
		$("#nowTime").runTimer();

		$("#exit").click(function() {
			/** parent从主界面进行退出,避免局部刷新*/
			top.location = "${ctx}/logout";
		})

		$("#mainPage").click(function() {
			/** parent从主界面进行退出,避免局部刷新*/
			parent.location = "${ctx}/main";
		})
	})
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="320" height="80" class="topbg">
				<%-- <img src="${ctx}/images/top_logo.gif" width="320" height="80"> --%>
				<div style="font-size: 30px;padding-left: 20px">产品售后跟踪管理系统</div>
			</td>
			<td class="topbg">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="50" class="toplink" align="right">
							<img src="${ctx}/images/top_home.gif">
							&nbsp;&nbsp;
							<a href="javascript:void(0);" id="mainPage">网站首页</a>
							<%-- <a href="${ctx}/main" >网站首页</a> --%>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="${ctx}/images/top_exit.gif">
							&nbsp;&nbsp;
							<a href="javascript:void(0);" id="exit">注销退出</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td height="30" class="topnavbg">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<%-- <td width="60">
										<img src="${ctx}/images/StatBarL.gif" width="60" height="30">
									</td> --%>
									<td width="60"></td>
									<td class="topnavlh" align="left">
										<img src="${ctx}/images/StatBar_admin.gif">
										&nbsp;&nbsp;当前用户：${sessionScope.myInfo.nickname}
										<c:choose>
											<c:when test="${sessionScope.hunmanType == sessionScope.hunmanTypeManager}">【管理员】</c:when>
											<c:when test="${sessionScope.hunmanType == sessionScope.hunmanTypeMainMan}">【维修人员】</c:when>
											<c:when test="${sessionScope.hunmanType == sessionScope.hunmanTypeCusService}">【客服】</c:when>
											<c:otherwise>【客户】</c:otherwise>
										</c:choose>


									</td>
									<td class="topnavlh" align="right">
										<img src="${ctx}/images/StatBar_time.gif">
										&nbsp;&nbsp;
										<span id="nowTime"></span>
									</td>
									<td width="3%"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		$(function(){
			
		})
	</script>
</body>
</html>