<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				&nbsp;&nbsp;&nbsp;当前位置：售后管理 &gt; 申请售后
			</td>
			<td width="15" height="32">
				<img src="${ctx}/images/main_locright.gif" width="15" height="32">
			</td>
		</tr>
	</table>
	<!--  -->
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form action="${ctx }/service/applyService" id="form" method="post">
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">
								<table>
									<tr>
										<td class="font3 fftd">
											订单产品详情：
											<select name="orderid" id="orderid"></select>
										</td>
										<td class="font3 fftd">
											申请描述：
											<textarea cols="50" rows="3" name="appremark" id="appremark"></textarea>
										</td>
										<td>
											<font color="red">${requestScope.msg}</font>
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
								<input type="submit" value="确认">
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
	//表示该用户是否具有订单，可以发起申请？
	var hasData = false;
    /* ready函数 */
    $(function() {
		getOrder('#orderid');
    })
   
    /** 表单提交 */
    $("form").submit(function() {
		/* console.log(hasData) */
		if(!hasData){
		    alert('你并不具备发起申请的条件')
		    return false;
		}
	    if(confirm('确认提交申请吗？')){
		    return true;
	    }else {
			return false;
	    }
		$("form").submit();
    })

    /* 获取产品 */
    function getOrder(ele) {
		$(ele).empty();
		$.ajax({
		    url : "${ctx}/order/selectOrderRetJson?cusid="+'${sessionScope.myInfo.id}',
		    type : "GET",
		    success : function(result) {
				if(result==""){
				    var optionEle = $("<option>空</option>");
				    optionEle.appendTo(ele);
				    /* console.log('数据为空') */
				    return;
				}
				/* console.log('数据非空') */
				hasData = true;
				$.each(result, function() {
				    var optionEle = $("<option></option>").append('订单编号:'+this.id+' || 产品名:'+this.product.prodname).attr("value", this.id);
				    optionEle.appendTo(ele);
				});
		    }
		});
    };
    
    
</script>
</html>