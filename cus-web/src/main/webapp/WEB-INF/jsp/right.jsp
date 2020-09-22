<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
</head>
<body>
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
				&nbsp;&nbsp;&nbsp;当前位置：后台管理 &gt; 当前用户
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="10" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
					<tr>
						<td class="font3 fftd">
							用户姓名：
							<font color="red" size="2">${sessionScope.account}</font>
						</td>
					</tr>
					<tr>
						<td class="main_tdbor"></td>
					</tr>

					<%-- <tr>
						<td class="font3 fftd">
							用户状态：
							<font color="red" size="2">
								<c:choose>
									<c:when test="${sessionScope.user_session.status == 1}">
								已审核
							</c:when>
									<c:otherwise>
								未审核
							</c:otherwise>
								</c:choose>
							</font>
						</td>
					</tr> --%>
					<tr>
						<td class="main_tdbor"></td>
					</tr>

					
				</table>
			</td>
		</tr>
	</table>
</body>
</html>