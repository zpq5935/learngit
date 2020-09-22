<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
<style type="text/css">
.form {
	padding: 10px;
	margin: auto auto;
}

.touming {
	background: rgba(255, 255, 255, 0.2);
}

.fontWhite {
	color: #FFF;
}

body {
	background: url("${ctx}/images/1364205441188.jpg") repeat;
}
</style>
<!--  -->
<script type="text/javascript">
	$(function() {
		/** 按了回车键 */
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				$("#login-submit-btn").trigger("click");
			}
		})
		/** 给登录按钮绑定点击事件  */
		$("#login-submit-btn").on("click", function() {
			/** 校验登录参数 ctrl+K */
			var account = $("#account").val();
			var password = $("#password").val();
			var msg = "";
			if (!/^\w{4,20}$/.test(password)) {
				msg = "密码长度必须是6~20之间";
			}
			if (msg != "") {
				alert(msg);
				return;
			}
			/** 提交表单 */
			$("#loginForm").submit();
		})
		/******************/

	})
</script>
</head>
<body>
	<!-- <div class="dialog">
		<div class="panel panel-default"> -->
	<div class="panel-body col-md-offset-4 col-md-4 touming" style="margin-top: 100px">
		<h2 align="left" class="fontWhite">产品售后跟踪管理系统</h2>
		<form style="text-align: left" class="form-horizontal  form" action="${ctx}/login" method="post" id="loginForm">

			<div class="form-group">
				<label for="type" class="fontWhite">人员类别</label>
				<select name="hunmanType" id="hunmanType">
					<option value="${hunmanTypeManager}">管理员
					<option value="${hunmanTypeCusService}">客服
					<option value="${hunmanTypeMainMan}">维修人员
					<option value="${hunmanTypeCustomer}">客户
				</select>
			</div>
			<div>
				<c:choose>
					<c:when test="${requestScope.message == null }">
						<span style="padding-top: 5px" class="fontWhite">允许以中文名称登录</span>
					</c:when>
					<c:otherwise>
						<span style="padding-top: 5px">
							<font color="red">${requestScope.message}</font>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-group">
				<label class="fontWhite">账号</label>
				<input type="text" class="form-control " id="account" value="${account}" name="account" placeholder="账号">
			</div>
			<div class="form-group">
				<label class="fontWhite">密码</label>
				<input type="password" class="form-control col-md-5" id="password" value="${password}" name="password" placeholder="密码">
			</div>
			<div class="form-group">
				<button type="button" id="login-submit-btn" class="btn btn-default">登录</button>
			</div>

		</form>

	</div>


	<%-- <div class="page-lock log_div_1">
		<div style="margin-bottom: 2px">
			<a href="loginForm" style="font-size: 22px;"> 产品售后跟踪管理系统 </a>
		</div>
		<form class="form-horizontal" action="${ctx}/login" method="post" id="loginForm">
			<div class="form-group">
				<label for="type" class="col-sm-5  control-label">人员类别</label>
				<div class="col-sm-7">
					<select name="hunmanType" id="hunmanType">
						<option value="${hunmanTypeManager}">管理员
						<option value="${hunmanTypeCusService}">客服
						<option value="${hunmanTypeMainMan}">维修人员
						<option value="${hunmanTypeCustomer}">客户
					</select>
				</div>
			</div>
			<div>
				<c:choose>
					<c:when test="${requestScope.message == null }">
						<span style="padding-top: 5px">允许以中文名称登录</span>
					</c:when>
					<c:otherwise>
						<span style="padding-top: 5px">
							<font color="red">${requestScope.message}</font>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-group">
				<label for="account" class="col-sm-5  control-label">账号</label>
				<div class="col-sm-7">
					<i class="icon-lock"></i>
					<input type="text" class="form-control" id="account" value="${account}" name="account"
						placeholder="账号">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-5  control-label">密码</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" id="password" value="${password}" name="password"
						placeholder="密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<button type="button" id="login-submit-btn" class="btn btn-default">登录</button>
				</div>
			</div>
		</form>
	</div> --%>
</body>
</html>