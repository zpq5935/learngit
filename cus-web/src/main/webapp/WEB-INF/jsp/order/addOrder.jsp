<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				&nbsp;&nbsp;&nbsp;当前位置：订单管理 &gt; 添加订单
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form action="${ctx }/order/addOrder" id="orderForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">
								<table>
									<tr>
										<td class="font3 fftd">
											产品名：
											<select name="proid" id="proid"></select>
										</td>
										<td class="font3 fftd">
											客户名：
											<select name="cusid" id="cusid"></select>
										</td>
										<td class="font3 fftd">
											客服名：
											<input readonly="readonly" value="${sessionScope.myInfo.nickname}">
											<input style="display: none;" name="cssid" id="cssid" value="${sessionScope.myInfo.id }">
											<!-- <select name="cssid" id="cssid"></select> -->
										</td>
									</tr>

									<tr>
										<td class="font3 fftd">
											数量：
											<input name="amount"  id="amount" value="${myOrder.amount }" size="20" />
										</td>
									</tr>
									<tr>
										<td class="font3 fftd">
											备注：<br>
											<textarea rows="3" cols="40" name="remark" id="remark"></textarea>
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
    /* 加载函数 */
    $(function() {
		getProducts('#proid');
		getCustomers('#cusid');
		/* getCsses('#cssid'); */
    })
    $(window).load(function() {
    });
    /** 表单提交 */
    $("#orderForm").submit(function() {
		var amount = $("#amount");
		var cssid = $("#cssid");
		var msg = "";
		if ($.trim(amount.val()) == "") {
		    msg = "数量不能为空！";
		    amount.focus();
		}
		if ($.trim(cssid.val()) == "") {
		    msg = "客服不能为空！";
		    cssid.focus();
		}
		if (msg != "") {
		    alert(msg);
		    return false;
		} else {
		    return true;
		}
		$("#orderForm").submit();
    })

    /* 获取产品 */
    function getProducts(ele) {
		$(ele).empty();
		$.ajax({
		    url : "${ctx}/product/selectProductRetJson",
		    type : "GET",
		    success : function(result) {
			$.each(result, function() {
			    var optionEle = $("<option></option>")
				    .append(this.prodname).attr("value", this.id);
			    optionEle.appendTo(ele);
			});
		    }
		});
    };
    /* 获取客户 */
    function getCustomers(ele) {
		$(ele).empty();
		$.ajax({
		    url : "${ctx}/customer/selectCustomerRetJson",
		    type : "GET",
		    success : function(result) {
			$.each(result, function() {
			    var optionEle = $("<option></option>")
				    .append(this.nickname).attr("value", this.id);
			    optionEle.appendTo(ele);
			});
		    }
		});
    };
    /*  获取客服*/

    function getCsses(ele) {
		$(ele).empty();
		$.ajax({
		    url : "${ctx}/user/selectCssesRetJson",
		    type : "GET",
		    success : function(result) {
			$.each(result, function() {
			    var optionEle = $("<option></option>")
				    .append(this.nickname).attr("value", this.id);
			    optionEle.appendTo(ele);
			});
		    }
		});
    };
</script>
</html>