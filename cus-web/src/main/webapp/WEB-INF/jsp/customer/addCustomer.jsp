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
				&nbsp;&nbsp;&nbsp;当前位置：客户管理 &gt; 添加客户
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form action="${ctx }/customer/addCustomer" id="customerForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">
								<table>
									<tr>
										<td class="font3 fftd">
											账&nbsp;号：
											<input type="text" name="account" id="account" size="20" />
										</td>
										<td class="font3 fftd">
											密&nbsp;码：
											<input type="text" name="password" id="password" size="20" />
										</td>
									</tr>

									<tr>
										<td class="font3 fftd">
											QQ：
											<input name="qq" id="qq" size="20" />
										</td>
										<td class="font3 fftd">
											邮&nbsp;箱：
											<input name="email" id="email" size="20" />
										</td>
									</tr>

									<tr>
										<td class="font3 fftd">
											手机：
											<input name="mobile" id="mobile" size="20" />
										</td>
										<td class="font3 fftd">
											昵&nbsp;称：
											<input name="nickname" id="nickname" size="20" />
										</td>
									</tr>
									<tr>
										<td class="font3 fftd">
											一级地址：
											<select name="onelevelAddress">
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
										</td>
										<td class="font3 fftd">
											详细地址：
											<input name="detailedAddress" id="detailedAddress" size="20" />
										</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>

						<tr>
							<td align="left" class="fftd">
								<input type="submit" value="添加">
								&nbsp;&nbsp;
								<input type="reset" value="取消 ">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
</body>
<script type="text/javascript">
    $(function() {
	/** 员工表单提交 */
	$("#customerForm").submit(function() {
	    var account = $("#account");
	    var password = $("#password");
	    var mobile = $("#mobile");
	    var nickname = $("#nickname");
	    var onelevelAddress = $("#onelevelAddress");
	    var detailedAddress = $("#detailedAddress");
	    var msg = "";
	    if ($.trim(account.val()) == "") {
			msg = "账号不能为空！";
			account.focus();
	    } else if ($.trim(password.val()) == "") {
			msg = "密码不能为空！";
			password.focus();
	    } else if ($.trim(mobile.val()) == "") {
			msg = "手机不能为空！";
			mobile.focus();
	    } else if ($.trim(nickname.val()) == "") {
			msg = "昵称不能为空！";
			nickname.focus();
	    } else if ($.trim(detailedAddress.val()) == "") {
			msg = "详细地址不能为空！";
			detailedAddress.focus();
	    }
			/* console.log('msg='+msg) */
	    if (msg != "") {
			alert(msg);
			return false;
	    } else {
			return true;
	    }
	    $("#customerForm").submit();
	});
    });
</script>
</html>