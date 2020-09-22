<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 添加jstl的core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 添加jstl的日期时间格式fmt -->

<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!-- easyUI -->
<%-- <script src="${ctx }/js/jquery-1.12.4.min.js"></script> --%>
<script type="text/javascript" src="${ctx}/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyUI/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/easyUI/themes/icon.css">

<!-- 添加自定义的css、js；与jQuery与bootstrap所需的js与css -->
<link href="${ctx}/css/cusService.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/my.js"></script>


<link href="${ctx}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<!-- 设置人员类别 -->
<%@ page import="zpq.constants.*" %>
<c:set var="hunmanTypeManager" scope="session" value="<%=Constrants.MANAGER%>"></c:set>
<c:set var="hunmanTypeMainMan" scope="session" value="<%=Constrants.MAINMAN%>"></c:set>
<c:set var="hunmanTypeCusService" scope="session" value="<%=Constrants.CUSSERVICER%>"></c:set>
<c:set var="hunmanTypeCustomer" scope="session" value="<%=Constrants.CUSTOMER%>"></c:set>
