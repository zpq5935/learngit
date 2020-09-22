<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
</head>
<body>
	<h2>用户信息</h2>
	<%-- ${requestScope.user} --%>

	<div id="div_myInfo">


		<form action="" method="post" id="userInfoForm">
			<div class="form-group">
				<label for="info_id" class="col-sm-5  control-label">编号</label>
				<div class="col-sm-6">
					<input disabled="disabled"  type="text" class="form-control" id="info_id" value="${requestScope.user.id}" name="id">
				</div>
			</div>
			<div style="display: none;">
				<input name="oriAccount" value="${requestScope.user.account}">
			</div>
			<div class="form-group">
				<label for="info_account" class="col-sm-5  control-label">账号</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="info_account" value="${requestScope.user.account}"
						name="account">
				</div>
				<font color="red" id="accountTip">
					<c:choose>
						<c:when test="${requestScope.msg !=null}">${requestScope.msg}</c:when>
						<c:otherwise>*</c:otherwise>
					</c:choose>

				</font>
			</div>
			<div class="form-group">
				<label for="info_password" class="col-sm-5  control-label">密码</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="info_password"
						value="${requestScope.user.password}" name="password">
				</div>
				<font color="red" id="passwordTip">*</font>
			</div>
			<div class="form-group">
				<label for="info_qq" class="col-sm-5  control-label">QQ</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="info_qq" value="${requestScope.user.qq}" name="qq">
				</div>
			</div>
			<div class="form-group">
				<label for="info_email" class="col-sm-5  control-label">邮箱</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="info_email" value="${requestScope.user.email}"
						name="email">
				</div>
			</div>
			<div class="form-group">
				<label for="info_mobile" class="col-sm-5  control-label">手机</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="info_mobile" value="${requestScope.user.mobile}"
						name="mobile">
				</div>
				<font color="red" id="mobileTip">*</font>
			</div>
			<div class="form-group">
				<label for="info_nickname" class="col-sm-5  control-label">昵称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="info_nickname"
						value="${requestScope.user.nickname}" name="nickname">
				</div>
				<font color="red" id="nicknameTip">*</font>
			</div>

			<!-- 客户专有 -->
			<c:if test="${requestScope.selectUserHunmanType == hunmanTypeCustomer }">
				<c:set value="${requestScope.user.onelevelAddress }" var="request_onelevelAddress" scope="page"></c:set>
				<div class="form-group">
					<label for="info_onelevelAddress" class="col-sm-5  control-label">一级地址</label>
					<div class="col-sm-6">
						<select name="onelevelAddress" id="info_onelevelAddress" class="form-control" >
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
						<%-- <input type="text" class="form-control" id="info_onelevelAddress"
							value="${requestScope.user.onelevelAddress}" name="onelevelAddress"> --%>
					</div>
				</div>
				
				<div class="form-group">
					<label for="info_detailedAddress" class="col-sm-5  control-label">详细地址</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="info_detailedAddress" value="${requestScope.user.detailedAddress}"
							name="detailedAddress">
					</div>
				</div>
			</c:if>

			<div class="btn-group">
				<button class="btn btn-default" type="button" id="userForm_submitBtn">确认修改并提交</button>
			</div>
		</form>


	</div>
</body>
<script type="text/javascript">
	var selectUserHunmanType = '${requestScope.selectUserHunmanType}';
	var hunmanTypeManager = '${sessionScope.hunmanTypeManager}';
	var hunmanTypeMainMan = '${sessionScope.hunmanTypeMainMan}';
	var hunmanTypeCusService = '${sessionScope.hunmanTypeCusService}';
	var hunmanTypeCustomer = '${sessionScope.hunmanTypeCustomer}';
	$(function() {
	    saveOnelevelAddress();
	    initFormAction();
	})
	/* 动态修改表单提交地址 */
	function initFormAction(){
	    if( selectUserHunmanType == hunmanTypeManager){
		console.log(hunmanTypeManager);
		$("#userInfoForm").attr("action","${ctx}/user/updateManager");
		}
		else if(selectUserHunmanType == hunmanTypeMainMan ){
			console.log(hunmanTypeMainMan);
			$("#userInfoForm").attr("action","${ctx}/user/updateMainman");
		}
		else if(selectUserHunmanType == hunmanTypeCusService){
			console.log(hunmanTypeCusService);
			$("#userInfoForm").attr("action","${ctx}/user/updateCusService");
		}
		else if(selectUserHunmanType == hunmanTypeCustomer){
			console.log(hunmanTypeCustomer);
			$("#userInfoForm").attr("action","${ctx}/user/updateCustomer");
		}
		else{
		}
	}
	/*********'确认修改并提交'按钮单击事件************/
	$('#userForm_submitBtn').click(function() {
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
			$('#nicknameTip').text('昵称是必须的')
			return;
		}
		/* if (onelevelAddress == "") {
			alert('一级地址是必须的')
			return;
		} */
		if (detailedAddress == "") {
			alert('详细地址是必须的')
			return;
		}
		$("#userInfoForm").submit();
	})
	/*  保存一级地址信息,此处的el表达式不管注释与否都是会去执行的*/
	 function saveOnelevelAddress(){
	    if(selectUserHunmanType == hunmanTypeCustomer){
			 $('option').each(function(){
				if($(this).val() == '${pageScope.request_onelevelAddress}'){
				    $(this).attr('selected','selected');
				    return;
				}
		    }); 
	    }
	} 
</script>
</html>