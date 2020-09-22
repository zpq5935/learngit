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
				&nbsp;&nbsp;&nbsp;当前位置：用户管理 &gt; 用户查询
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
							<form name="selectUserform" id="empform" action="${ctx}/user/selectUsers">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">
											用户名：
											<input type="text" name="selectUserAccount" value="${selectUserAccount}">
											人员类别：
											<select name="selectUserHunmanType" id="selectUserHunmanType">
												<option value="${hunmanTypeManager }">管理员</option>
												<option value="${hunmanTypeCusService }">客服</option>
												<option value="${hunmanTypeMainMan }">维修人员</option>
												<option value="${hunmanTypeCustomer }">客户</option>
											</select>
											<input type="submit" value="搜索" />
											<input id="deleteManyBtn" type="button" value="删除" />
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
				<table width="98%" border="1" cellpadding="5" cellspacing="0" align="center"
					style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr class="main_trbg_tit" align="center">
						<td>
							<input type="checkbox" name="checkAll" id="checkAll">
						</td>
						<td>账号</td>
						<td>密码</td>
						<td>QQ</td>
						<td>邮箱</td>
						<td>手机</td>
						<td>昵称</td>
						<c:if test="${requestScope.selectUserHunmanType == hunmanTypeCustomer }">
							<td>一级地址</td>
							<td>详细地址</td>
						</c:if>
						<td width="80px">操作</td>
					</tr>
					<c:forEach items="${requestScope.pageInfo.list}" var="user" varStatus="stat">
						<tr id="data_${stat.index}" align="center" class="main_trbg">
							<td>
								<input type="checkbox" id="box_${stat.index}" value="${user.id}">
							</td>
							<td>${user.account }</td>
							<td>${user.password }</td>
							<td>${user.qq }</td>
							<td>${user.email }</td>
							<td>${user.mobile }</td>
							<td>${user.nickname }</td>
							<c:if test="${requestScope.selectUserHunmanType == hunmanTypeCustomer }">
								<td>${user.onelevelAddress }</td>
								<td>${user.detailedAddress }</td>
							</c:if>
							<td align="center" width="40px;">
								<a href="${ctx}/user/updateUser?id=${user.id}&selectUserHunmanType=${selectUserHunmanType}">
									<img title="修改" src="${ctx}/images/update.gif" />
								</a>
								<a title="删除" class="del_One_Btn" href="javascript:void(0)">删除</a>
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
								<input id="pageNumInput" value="${requestScope.pageInfo.pageNum }" type="text" style="width:20px;">
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
	/* 	此页页码 */		
	var pageNum = ${requestScope.pageInfo.pageNum};
	
	$(function() {
		tableMouseHover();
		saveInfo();
	})
	/******保存查询条件******/
	function saveInfo() {
		$('#selectUserHunmanType option[value="${selectUserHunmanType}"]').attr('selected', 'selected');
	}
	/************跳转按钮-单击功能***************/
	$('#PageToBtn').click(function() {
		alert($("#pageNumInput").val())
		var myHref = "${ctx}/user/selectUsers?pn=" + $('#pageNumInput').val()
				+'&selectUserHunmanType=${selectUserHunmanType}'
				+'&selectUserAccount=${selectUserAccount}';
		location.href = myHref;
	})
	/* 跳转功能 */
	function pageTo(pn){
		var myHref = "${ctx}/user/selectUsers?pn=" + pn
		+'&selectUserHunmanType=${selectUserHunmanType}'
		+'&selectUserAccount=${selectUserAccount}';
        location.href = myHref;
	}
	/*  */
	$('#firstPage').click(function(){
		pageTo(1);
	})
	$('#lastPage').click(function(){
		pageTo(1000);
	})
	$('#prePage').click(function(){
		pageTo(pageNum-1);
	})
	$('#nextPage').click(function(){
		pageTo(pageNum+1);
	})
	/* 每行的单个删除按钮 */
	$(document).on("click",".del_One_Btn",function(){
		var userName = $(this).parents("tr.main_trbg").find("td:eq(1)").text();
		var Id = $(this).parents("tr.main_trbg").find("td:eq(0) :input").val();
		/* console.log($(this)); */
		if(confirm("确认删除【"+userName+"】吗?")){
			 window.location = '${ctx}/user/deleteUser?id='+Id+'&selectUserHunmanType=${selectUserHunmanType}&pn=${pageInfo.pageNum}&selectUserAccount=${selectUserAccount}'; 
		}
	});
	/** 批量删除员工按钮单击的点击事件 */
	$("#deleteManyBtn").click(function() {
		var checkBoxs = $(":input[type='checkbox']").filter(":checked");
		var ids = checkBoxs.map(function(){
			return $(this).val();
			}).get();
		var users_Name = checkBoxs.map(function(){
			return  $(this).parents("tr.main_trbg").find("td:eq(1)").text();
		}).get();
		if(checkBoxs.length <= 0){
			alert("未选中任何人员");
			return;
		}
		if(confirm("确认删除【"+users_Name+"】吗?")){
			window.location = "${ctx}/user/deleteManyUsers?ids="+ids+"&selectUserHunmanType=${selectUserHunmanType}&pn=${pageInfo.pageNum}&selectUserAccount=${selectUserAccount}";
		}
	}) 
</script>
</html>