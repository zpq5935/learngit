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
				&nbsp;&nbsp;&nbsp;当前位置：客户管理 &gt; 查询客户
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
							<form name="selectCustomerform" id="empform" action="${ctx}/customer/selectCustomer">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">
											用户名：
											<input type="text" name="account" value="${requestScope.account }">
											一级地址:
											<select name="onelevelAddress">
												<option value="">无限制</option>
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
				<table width="98%" border="1" cellpadding="5" cellspacing="0" align="center" style="border: #c2c6cc 1px solid; border-collapse: collapse;">
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
						<td>一级地址</td>
						<td>详细地址</td>
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
							<td>${user.onelevelAddress }</td>
							<td>${user.detailedAddress }</td>
							<td align="center" width="40px;">
								<a href="${ctx}/customer/updateCustomer?flag=1&id=${user.id}">
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
		/* (${requestScope.pageInfo.pageNum}) : 1 ; */
	/*  */
    $(function() {
		tableMouseHover();
		saveOnelevelAddress();
    })
    /* 跳转功能 */
	function pageTo(pn){
		var myHref = "${ctx}/customer/selectCustomer?pn=" + pn
		+'&account=${requestScope.account}'
		+'&onelevelAddress=${requestScope.onelevelAddress}';
    	window.location = myHref;
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
	$("#PageToBtn").click(function(){
	    pageTo($("#pageNumInput").val())
	});
	/*  保存一级地址信息*/
	function saveOnelevelAddress(){
	    $('option').each(function(){
			if($(this).val() == '${requestScope.onelevelAddress}'){
			    $(this).attr('selected','selected');
			    return;
			}
	    });
	}
	/* 每行的单个删除按钮 */
	$(document).on("click",".del_One_Btn",function(){
		var userName = $(this).parents("tr.main_trbg").find("td:eq(1)").text();
		var Id = $(this).parents("tr.main_trbg").find("td:eq(0) :input").val();
		/* console.log($(this)); */
		if(confirm("确认删除【"+userName+"】吗?")){
			 window.location = '${ctx}/customer/deleteCustomer?id='+Id+'&account=${requestScope.account}&pn=${pageInfo.pageNum}&onelevelAddress=${onelevelAddress}'; 
		}
	})
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
		    window.location = '${ctx}/customer/deleteCustomers?ids='+ids+'&account=${requestScope.account}&pn=${pageInfo.pageNum}&onelevelAddress=${onelevelAddress}';
		}
	}) 
	
</script>
</html>