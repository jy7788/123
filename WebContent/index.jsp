<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("homepage",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>南京易阳装饰</title>
	<link href="css/basic.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/myjs.js"></script>
</head>
<body>

<%@ include file="common/head.jsp"%>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div style="font-size:14px;">正在为你跳转建材商城，请稍候！</div>
<script language="JavaScript">
 window.location.href = "shopInit.action";
</script>

<%@ include file="common/foot.jsp" %>

</body>
</html>