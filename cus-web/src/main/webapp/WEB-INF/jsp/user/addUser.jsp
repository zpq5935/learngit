<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				&nbsp;&nbsp;&nbsp;当前位置：用户管理 &gt; 添加用户
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<!--  -->
	<table width="100%" class="main_tabbor">
		<tr valign="top">
			<td >
				<form action="${ctx}/user/addMANAGER" class="form-horizontal" id="addUserForm" method="post">
					<c:set value="${hunmanTypeManager }" scope="page" var="addUserForm_hunmanType"></c:set>
					<div class="form-group">
						<label for="addUserForm_HunmanType" class="col-sm-5  control-label">人员类别</label>
						<div class="col-sm-6" id="addUserForm_hunmanType">
							<select name="addUserForm_HunmanType" id="addUserForm_select" class="form-control">
								<option value="${hunmanTypeManager }">管理员</option>
								<option value="${hunmanTypeMainMan }">维修人员</option>
								<option value="${hunmanTypeCusService }">客服</option>
								<option value="${hunmanTypeCustomer }" id="addUserForm_customer">客户</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="info_account" class="col-md-5  control-label">账号</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="info_account" name="account">
						</div>
						<font color="red" id="accMsg" class="col-md-1">
							<c:choose>
								<c:when test="${requestScope.accMsg !=null}">${requestScope.accMsg}</c:when>
								<c:otherwise>*</c:otherwise>
							</c:choose>

						</font>
					</div>
					<div class="form-group">
						<label for="info_password" class="col-sm-5  control-label">密码</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="info_password" name="password">
						</div>
						<font color="red" id="pwdMsg" class="col-md-1">
							<c:choose>
								<c:when test="${requestScope.pwdMsg !=null}">${requestScope.pwdMsg}</c:when>
								<c:otherwise>*</c:otherwise>
							</c:choose>

						</font>
					</div>

					<div class="form-group">
						<label for="info_qq" class="col-sm-5  control-label">QQ</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="info_qq" name="qq">
						</div>
					</div>
					<div class="form-group">
						<label for="info_email" class="col-sm-5  control-label">邮箱</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="info_email" name="email">
						</div>
					</div>
					<div class="form-group">
						<label for="info_mobile" class="col-sm-5  control-label">手机</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="info_mobile" name="mobile">
						</div>
						<font color="red" id="mobileTip" class="col-md-1">*</font>
					</div>
					<div class="form-group">
						<label for="info_nickname" class="col-sm-5  control-label">昵称</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="info_nickname" name="nickname">
						</div>
						<font color="red" id="nickMsg" class="col-md-1">
							<c:choose>
								<c:when test="${requestScope.nickMsg !=null}">${requestScope.nickMsg}</c:when>
								<c:otherwise>*</c:otherwise>
							</c:choose>

						</font>
					</div>

					<!-- 客户专有 -->
					<div style="display: none;" id="input_forCustomer">
						<div class="form-group">
							<label for="onelevelAddress" class="col-sm-5  control-label">一级地址</label>
							<div class="col-sm-6">
								<select name="onelevelAddress" id="info_onelevelAddress" class="form-control">
									<optgroup label="23个省">
										<option value="安徽省">安徽省</option>
										<option value="福建省">福建省</option>
										<option value="甘肃省">甘肃省</option>
										<option value="广东省">广东省</option>
										<option value="贵州省">贵州省</option>
										<option value="海南省">海南省</option>
										<option value="河北省">河北省</option>
										<option value="河南省">河南省</option>
										<option value="黑龙江省">黑龙江省</option>
										<option value="湖北省">湖北省</option>
										<option value="湖南省">湖南省</option>
										<option value="吉林省">吉林省</option>
										<option value="江苏省">江苏省</option>
										<option value="江西省">江西省</option>
										<option value="辽宁省">辽宁省</option>
										<option value="青海省">青海省</option>
										<option value="山东省">山东省</option>
										<option value="山西省">山西省</option>
										<option value="陕西省">陕西省</option>
										<option value="四川省">四川省</option>
										<option value="台湾省">台湾省</option>
										<option value="云南省">云南省</option>
										<option value="浙江省">浙江省</option>

									</optgroup>
									<optgroup label="4个直辖市">
										<option value="北京市">北京市</option>
										<option value="重庆市">重庆市</option>
										<option value="上海市">上海市</option>
										<option value="天津市">天津市</option>
									</optgroup>
									<optgroup label="5个自治区">
										<option value="广西壮族自治区">广西壮族自治区</option>
										<option value="内蒙古自治区">内蒙古自治区</option>
										<option value="宁夏回族自治区">宁夏回族自治区</option>
										<option value="西藏自治区">西藏自治区</option>
										<option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
									</optgroup>
									<optgroup label="2个特别行政区">
										<option value="香港">香港</option>
										<option value="澳门">澳门</option>
									</optgroup>
								</select>
								<!-- <input type="text" class="form-control" id="info_onelevelAddress" name="onelevelAddress"> -->
							</div>
						</div>

						<div class="form-group">
							<label for="detailedAddress" class="col-sm-5  control-label">详细地址</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="info_detailedAddress" name="detailedAddress">
							</div>
						</div>
					</div>


					<div class="btn-group col-md-5 col-md-offset-5">
						<button class="btn btn-default" type="button" id="addUserForm_submit">提交</button>
						<button class="btn btn-default" type="button" id="addUserForm_reset">取消</button>
					</div>
				</form>
				<div class="col-md-12">
					<font size="20px" class="" color="red">
						<c:if test="${requestScope.msg!=null}">${requestScope.msg }</c:if>
					</font>
				</div>
			</td>
		</tr>
	</table>


</body>
<script type="text/javascript">
	$(function() {
		var addUserForm_hunmanType = $('#addUserForm_select :selected');
		var content = '${ctx}'
		/* 人员类别选择改变事件 */
		$("#addUserForm_select").change(function() {
			var op = $('#addUserForm_select :selected');
			addUserForm_hunmanType = op.val();
			if (addUserForm_hunmanType == $('#addUserForm_customer').val()) {
				console.log('equal');
				$('#input_forCustomer').css("display", "");
				$("#addUserForm").attr('action',content + '/user/add'+ addUserForm_hunmanType);
			} else {
				$('#input_forCustomer').css("display", "none");
				$("#addUserForm").attr(	'action',content + '/user/add'	+ addUserForm_hunmanType);
			}
		});
		/** 员工表单提交 */
		
	    $("#addUserForm_submit").click(function() {
		    var account = $("#info_account").val();
		    var password = $("#info_password").val();
		    var qq = $("#info_qq").val();
		    var email = $("#info_email").val();
		    var mobile = $("#info_mobile").val();
		    var nickname = $("#info_nickname").val();
		    //外加客户地址数据
		    /* var onelevelAddress = $("#info_onelevelAddress").val(); */
		    var detailedAddress = $("#info_detailedAddress").val();
		    //
		    if (account == "") {
				alert('账户是必须的')
				return;
		    }
		    if (password == "") {
				alert('密码是必须的')
				return;
		    }
		    if (mobile == "") {
				alert('手机是必须的')
				return;
		    }
		    if (nickname == "") {
				alert('昵称是必须的')
				return;
		    }
		    if (addUserForm_hunmanType == $('#addUserForm_customer').val()) {
				/* if (onelevelAddress == "") {
				    alert('一级地址是必须的')
				    return;
				} */
				if (detailedAddress == "") {
				    alert('详细地址是必须的')
				    return;
				}
		    }
	
		    $("#addUserForm").submit();
		})
	/******************/

    })
</script>
</html>