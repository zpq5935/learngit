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
				&nbsp;&nbsp;&nbsp;当前位置：产品管理 &gt; 查询产品
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
							<form name="selectProductform" id="empform" action="${ctx}/product/selectProduct">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">
											产品名：
											<input type="text" name="prodname" value="${requestScope.prodname }">
											<input type="submit" value="搜索" />
											<c:if test="${ hunmanType == hunmanTypeCusService}">
												<input id="deleteManyBtn" type="button" value="删除" />
											</c:if>

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
						<td>产品名称</td>
						<td>价格(￥)</td>
						<td>功率</td>
						<td>额定电压</td>
						<td>重量</td>
						<c:if test="${ hunmanType == hunmanTypeCusService}">
							<td width="80px">操作</td>
						</c:if>
						
					</tr>
					<c:forEach items="${requestScope.pageInfo.list}" var="product" varStatus="stat">
						<tr id="data_${stat.index}" align="center" class="main_trbg">
							<td>
								<input type="checkbox" id="box_${stat.index}" value="${product.id}">
							</td>
							<td>${product.prodname }</td>
							<td>${product.para1 }</td>
							<td>${product.para2 }</td>
							<td>${product.para3 }</td>
							<td>${product.para4 }</td>
							<c:if test="${ hunmanType == hunmanTypeCusService}">
								<td align="center" width="40px;">
									<a href="${ctx}/product/updateProduct?flag=1&id=${product.id}">
										<img title="修改" src="${ctx}/images/update.gif" />
									</a>
									<a title="删除" class="del_One_Btn" href="javascript:void(0)">删除</a>
								</td>
							</c:if>

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
    /***************************/
    $(function() {
		tableMouseHover();
    })
    /******************/
    /* 跳转功能 */
    function pageTo(pn) {
	var myHref = "${ctx}/product/selectProduct?pn=" + pn
		+ '&proname=${requestScope.proname}';
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
    /* 每行的单个删除按钮 */
    $(document).on("click", ".del_One_Btn",function() {
		var proName = $(this).parents("tr.main_trbg").find("td:eq(1)").text();
		var Id = $(this).parents("tr.main_trbg").find("td:eq(0) :input").val();
		/* console.log($(this)); */
		if (confirm("确认删除【" + proName + "】吗?")) {
		    window.location = '${ctx}/product/deleteProduct?id=' + Id
			    + "&pn" + pageNum + "&prodname"
			    + '${requestScope.prodname}';
		}
	    })
    /** 批量删除员工按钮单击的点击事件 */
    $("#deleteManyBtn").click( function() {
			var checkBoxs = $(":input[type='checkbox']").filter(":checked");
			var ids = checkBoxs.map(function() {
			    return $(this).val();
			}).get();
			var products_Name = checkBoxs.map(function() {
				    return $(this).parents("tr.main_trbg").find("td:eq(1)").text();
				}).get();
			if (checkBoxs.length <= 0) {
			    alert("未选中任何产品");
			    return;
			}
			if (confirm("确认删除【" + products_Name + "】吗?")) {
			    window.location = '${ctx}/product/deleteProducts?ids='
				    + ids
				    + "&pn"
				    + pageNum
				    + "&prodname"
				    + '${requestScope.prodname}';
			}
    })
</script>
</html>