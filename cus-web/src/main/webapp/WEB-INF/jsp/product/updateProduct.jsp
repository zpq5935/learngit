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
				&nbsp;&nbsp;&nbsp;当前位置：产品管理 &gt; 修改产品
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form action="${ctx }/product/updateProduct" id="productForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">
								<table>
									<tr style="display: none;">
										<td class="font3 fftd">
											<input type="hidden" name="flag" value="2">
											<input type="text" name="id" id="id" value="${product.id}" size="20" />
											<input name="oriProductName" value="${product.prodname}">
										</td>
									</tr>
									<tr>
										<td class="font3 fftd">
											产品名：
											<input type="text" name="prodname" id="prodname" value="${product.prodname}" size="20" />
										</td>
									</tr>
									<tr>
										<td class="font3 fftd">
											价&nbsp;格(￥)：
											<input name="para1" id="para1"  value="${product.para1 }" size="20" />
										</td>
										<td class="font3 fftd">
											功&nbsp;率：
											<input name="para2" id="para2" value="${product.para2 }" size="20" />
										</td>
									</tr>

									<tr>
										<td class="font3 fftd">
											额定电压：
											<input name="para3" id="para3" value="${product.para3 }" size="20" />
										</td>
										<td class="font3 fftd">
											重&nbsp;量：
											<input name="para4" id="para4" value="${product.para4 }" size="20" />
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
								<input type="submit" value="修改">
								&nbsp;&nbsp;
								<input type="reset" value="重置 ">
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
		
    })
	/** 产品表单提交 */
	$("#productForm").submit(function() {
	    var prodname = $("#prodname");
	    var para1 = $("#para1");
	    var para2 = $("#para2");
	    var para3 = $("#para3");
	    var para4 = $("#para4");
	    var msg = "";
	    if ($.trim(prodname.val()) == "") {
			msg = "产品名称不能为空！";
			prodname.focus();
	    } else if ($.trim(para1.val()) == "") {
			msg = "价格不能为空！";
			para1.focus();
	    } else if ($.trim(para2.val()) == "") {
			msg = "功率不能为空！";
			para2.focus();
    	} else if ($.trim(para3.val()) == "") {
			msg = "电压不能为空！";
			para3.focus();
	    } else if ($.trim(para4.val()) == "") {
			msg = "重量不能为空！";
			para4.focus();
		} 
	    if (msg != "") {
			alert(msg);
			return false;
	    } else {
			return true;
	    }
	    $("#productForm").submit();
	})
  
</script>
</html>