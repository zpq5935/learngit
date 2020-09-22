<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
</head>
<body>
	<div style="margin: 10px; background-color: #FFFFFF; text-align: left;">
		<table width="200" height="100%" border="0" cellpadding="0" cellspacing="0" class="left_nav_bg">

			<tr valign="top">
				<td class="left_nav_bgshw" height="25">
					<p class="left_nav_link">
						<img src="${ctx}/images/left_nav_arrow.gif">
						&nbsp;&nbsp;
						<a href="${ctx}/userPage/myInfo" id="myInfo" target="main">个人信息</a>
					</p>
				</td>
			</tr>
			<!-- 管理员 -->
			<c:if test="${ hunmanType == hunmanTypeManager}">
				<!--1.用户管理  -->
				<tr>
					<td class="left_nav_top">
						<div class="font1">用户管理</div>
					</td>
				</tr>

				<tr valign="top">
					<td class="left_nav_bgshw" height="50">
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx}/user/selectUsers" target="main">用户查询</a>
						</p>
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx}/userPage/addUser" target="main">添加用户</a>
							<%-- <a href="${ctx}/left" target="main">添加用户</a> --%>
						</p>
					</td>
				</tr>
				<tr>
					<td height="2"></td>
				</tr>

				<!--2.客户管理  -->
				<tr>
					<td id="navbg1" class="left_nav_closed">
						<div class="font1">客户管理</div>
					</td>
				</tr>
				<tr valign="top" id="submenu1" style="display: none">
					<td class="left_nav_bgshw" height="50">
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx}/customer/selectCustomer" target="main">查询客户</a>
						</p>
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx}/customerPage/addCustomer" target="main">添加客户</a>
						</p>
					</td>
				</tr>
				<tr>
					<td height="2"></td>
				</tr>
			</c:if>

			<!--3.产品管理  -->
			<tr>
				<td id="navbg2" class="left_nav_closed">
					<div class="font1">产品管理</div>
				</td>
			</tr>
			<tr valign="top" id="submenu2" style="display: none">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="${ctx}/images/left_nav_arrow.gif">
						&nbsp;&nbsp;
						<a href="${ctx}/product/selectProduct" target="main">查询产品</a>
					</p>
					<c:if test="${ hunmanType == hunmanTypeCusService}">
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx }/productPage/addProduct" target="main">添加产品</a>
						</p>
					</c:if>

				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>

			<!-- 客服 -->
			<c:if test="${ hunmanType == hunmanTypeCusService || hunmanType == hunmanTypeCustomer}">
				<!--4.订单管理:客服功能  -->
				<tr>
					<td id="navbg3" class="left_nav_closed">
						<div class="font1">订单管理</div>
					</td>
				</tr>
				<tr valign="top" id="submenu3" style="display: none">
					<td class="left_nav_bgshw" height="50">
						<c:if test="${ hunmanType == hunmanTypeCusService }">
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx }/order/selectOrder" target="main">查询订单</a>
						</p>
							<p class="left_nav_link">
								<img src="${ctx}/images/left_nav_arrow.gif">
								&nbsp;&nbsp;
								<a href="${ctx }/orderPage/addOrder" target="main">添加订单</a>
							</p>
						</c:if>
						<c:if test="${ hunmanType == hunmanTypeCustomer }">
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx }/order/selectOrderByCusidAndProdname?cusid=${sessionScope.myInfo.id }" target="main">查询订单</a>
						</p>
						</c:if>
					</td>
				</tr>
				<tr>
					<td height="2"></td>
				</tr>
			</c:if>

			<!-- 客户，客服，维修人员 -->
			<!--5.售后管理  -->
			<c:if test="${ hunmanType != hunmanTypeManager}">
				<tr>
					<td id="navbg4" class="left_nav_closed">
						<div class="font1">售后管理</div>
					</td>
				</tr>
				<tr valign="top" id="submenu4" style="display: none">
					<td class="left_nav_bgshw tdbtmline" height="50">
						<c:if test="${ hunmanType == hunmanTypeCustomer}">
							<p class="left_nav_link">
								<img src="${ctx}/images/left_nav_arrow.gif">
								&nbsp;&nbsp;
								<a href="${ctx }/servicePage/applyService" target="main">申请售后</a>
							</p>
						</c:if>

						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="javascript:void(0)" id="sltService" target="main">查询售后</a>
						</p>

					</td>
				</tr>
			</c:if>
			<tr>

				<td height="2"></td>
			</tr>

			<!--6.统计报表  -->
			<c:if test="${ hunmanType == hunmanTypeManager}">
				<tr>
					<td id="navbg5" class="left_nav_closed">
						<div class="font1">报表统计</div>
					</td>
				</tr>
				<tr valign="top" id="submenu5" style="display: none">
					<td class="left_nav_bgshw tdbtmline" height="50">
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx}/reportPage/orderReport" target="main">订单统计</a>
						</p>
						<p class="left_nav_link">
							<img src="${ctx}/images/left_nav_arrow.gif">
							&nbsp;&nbsp;
							<a href="${ctx}/reportPage/serviceReport" target="main">售后统计</a>
						</p>
					</td>
				</tr>
			</c:if>

			<%-- <tr>

				<td height="50">
					&nbsp;&nbsp;&nbsp;
					<a style="color: #125741; font-size: 20px;" href="${ctx}/test" target="main">测试</a>
				</td>
			</tr> --%>
			<tr>
				<td align="center">
					<!-- <input id="text" type="text"/>
					<button onclick="send()">发送消息</button>
					<hr />
					<button id="btn1" onclick="closeOrNewWebSocket()">关闭WebSocket连接</button> -->
					<hr />
					<div id="message"></div>
					<div id="messageDialog" style="width: 100px;height:100px;"></div>
				</td>

			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<!--版权所有  -->
			<tr valign="top">
				<td height="20" align="center">
					<div class="copycct">
						<br>
						Copyright © 2019 &nbsp;
						<br>
						<a href="#">产品售后跟踪管理系统1.0</a>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100%">
					<img src="${ctx}/images/left_nav_bottom.gif" height="10"></img>
				</td>
			</tr>
			<tr>
				<td height="10" bgcolor="#e5f0ff">&nbsp;</td>
			</tr>
		</table>
		<hr>

	</div>
</body>
<script language="javascript" type="text/javascript">
	$(function() {
		/** 给左侧功能菜单绑定点击事件  */
		$("td[id^='navbg']").click(
			function() {
				/** 获取一级菜单的id */
				var navbgId = this.id;
				/** 获取对应的二级菜单id */
				var submenuId = navbgId.replace('navbg', 'submenu');
				/** 控制二级菜单显示或隐藏  */
				$("#" + submenuId).toggle();
				/** 控制关闭或者开启的图标*/
				$("#" + navbgId).toggleClass("left_nav_expand");

				/** 控制其他的一级菜单的二级菜单隐藏按钮都关闭  */
				$("tr[id^='submenu']").not("#" + submenuId).hide();
				/** 控制其他一级菜单的图片显示关闭  */
				$("td[id^='navbg']").not(this).removeClass().addClass("left_nav_closed");
			})
				
		/**********主视图左边树形图下的各链接的单击事件************/
	<%-- 	$("#myInfo").on(click,function() {
			alert('ad')
			var account = "<%=session.getAttribute("account")%>";
			if (loginname == null)
				parent.location = '${ctx}/main';
			else
				alert(account);
		})
 --%>		
		
	})
</script>
<script type="text/javascript">
	var myType = '${sessionScope.hunmanType}'; 
	var cssType = '${hunmanTypeCusService}';   
	var customerType = '${hunmanTypeCustomer}';
	var managerType = '${hunmanTypeManager}';
	var mainmanType = '${hunmanTypeMainMan}';
	var myId = '${sessionScope.myInfo.id}';
	$(function(){
	    changeSltService();
	})
	
	/*  查询售后相关的js */
    function changeSltService(){
		console.log(myType)		
		$('#sltService').attr('href','${ctx}/service/selectService_'+myType)
    }
</script>
</html>