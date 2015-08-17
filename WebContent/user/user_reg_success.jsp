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
	<link href="css/userreg.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
			function login()
			{	
				setTimeout(function(){window.location.href="user/user_login.jsp";},5000);
			}
	</script>
</head>
<body onload="login()">
	<%@ include file="/common/head.jsp"%>
	<div id="regmain">
		<div id="yiyang"><div></div></div>
		<div id="reginfo"><br />
			<div>
				<h1>恭喜你注册成功！</h1>
			</div>
			<div>
				<a href="user/user_login.jsp">点此为你跳转登录页面，或5秒后自动跳转！</a>
			</div>
		</div>
	</div>
	<br/>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>