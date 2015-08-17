<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("homepage",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>预约成功</title>
    <link href="css/eshop.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/eshop_cizhuan.jsp">建材商城</a>><a href="shop/cart_list.jsp">购物车</a>
    </div>
</div>

<div class="blank"></div>

<div class="leftbanner"></div>
<div class="divinmiddle">
    预约成功
</div>

<!--页脚-->
<%@ include file="/common/foot.jsp" %>

</body>
</html>