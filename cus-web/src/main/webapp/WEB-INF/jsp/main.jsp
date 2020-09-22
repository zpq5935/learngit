<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
<link href="${ctx}/css/cusService.css" type="text/css" rel="stylesheet" />


</head>

<frameset rows="80,*" cols="*" frameborder="no" border="0" framespacing="0" style="z-index:1">
	<frame src="${ctx}/top" name="title" scrolling="no" noresize="noresize">
	<frameset cols="220,*" frameborder="no" border="0" framespacing="0" style="z-index:1">
		<frame src="${ctx}/left" name="tree" scrolling="no" marginheight="0" marginwidth="0">
		<frame src="${ctx}/userPage/myInfo" name="main" scrolling="yes" frameborder="0" marginwidth="0"
			marginheight="0" noresize="noresize" style="z-index:1">
	</frameset>
</frameset>


</html>