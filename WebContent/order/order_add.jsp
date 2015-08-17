<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>订单填写</title>
    <link href="css/eshop.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>&gt;<a href="shop/product_list.jsp">建材商城</a>&gt;<a href="shop/cart_list.jsp">购物车</a>
    </div>
</div>

<div class="blank"></div>

<!--购物车信息-->
<div class="leftbanner"></div>
<div class="divinmiddle">
<div class="orders">
    <s:if test="%{#session.userName==null}">
             请登录
    </s:if>
    <s:else>
   
 <s:form action="order_check"> 
 <div class="order"> 
 	<table border="0">
 		<tr><td colspan="2" style="color:red;">下单前，请务必确认填写信息正确！</td></tr>
	    <tr>
			<td align="right" width="90">收货人姓名：</td>
			<td align="left"><s:textfield name="name" size="40"></s:textfield></td>
		</tr>
		<tr>
			<td align="right" width="90">收货人地址：</td>
			<td align="left"><s:textarea name="address" cols="50" rows="3"></s:textarea></td>
		</tr>
		<tr>
			<td align="right" width="90">收货人电话：</td>
			<td align="left"><s:textfield name="mobile" size="40"></s:textfield></td>
		</tr>
		<tr>
			<td align="right" width="90">货款支付方式：</td>
			<td align="left"><input type="radio" name="paymentWay" value="货到付款" checked="checked">货到付款</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="下单" class="button red medium"/></td>
		</tr>
	</table>
</div>
   </s:form>
     </s:else>
    
</div>
</div>

<!--页脚-->
<%@ include file="/common/foot.jsp" %>

</body>
</html>