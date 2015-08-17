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
    <title>订单确认</title>
    <link href="css/eshop.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/eshop_cizhuan.jsp">建材商城</a>><a href="shop/cart_list.jsp">订单确认</a>
    </div>
</div>

<div class="blank"></div>

<!--购物车信息-->
<div class="leftbanner"></div>
<div class="divinmiddle">
<div class="carts">

   <s:if test="%{#session.userName==null}">
         请登录
   </s:if>
  <s:else>
    <s:if test="%{#session.cart==null}">
             您的订单为空
    </s:if>
     
    <s:else>
    <s:set value="%{0}" var="sumall"></s:set>
    <s:form action="order_save" method="post"> 
        <s:hidden  name="address" />
        <s:hidden  name="name" />
        <s:hidden  name="mobile" />
        <s:hidden  name="paymentWay" />
        <s:hidden  name="orderId" />    
    <div class="order">
    <table width="1000" border="0" cellpadding="0" cellspacing="0" id="address">
        <tr>
		    <td align="right" width="200">收货人姓名：</td>
		    <td align="left"><s:property value="name"/></td>
		    <td align="right" width="200">收货人电话：</td>
		    <td align="left"><s:property value="mobile"/></td>
	    </tr>
	    <tr>
		    <td align="right" width="200">收货人地址：</td>
		    <td align="left" colspan="3"><s:property value="address"/></td>		    
	    </tr>
	    <tr height="20px"><td colspan="4"></td></tr>
	    </table>
	    <table width="1000" border="1" cellpadding="0" cellspacing="0">
        <tr height="30" bgcolor="#971922" style="color:#fff;">
          <td width="260" height="30" align="center">商品名称</td>
          <td width="200" align="center">市场价</td>
          <td width="200" align="center">价格</td>
          <td width="200" align="center">数量</td>
        </tr>
          <s:iterator value="orderItems">
          <s:set value="%{#sumall +productPrice*amount}" var="sumall"/>
          <tr>                
                  <td width="213" height="30" align="center"><s:property value="productName"/></td>
                  <td width="130" align="center"><span style="text-decoration: line-through;">
                  ￥<s:property value="productMarketprice"/>元</span>
                  </td>
                  <td width="130" align="center">￥<s:property value="productPrice"/>元<br>
			为您节省：￥<s:property value="productMarketprice*amount - productPrice*amount"/>元</td>
                  <td width="104" align="center"><s:property value="amount"/></td>                    
          </tr>
           </s:iterator>
     
          <tr align="right">
          		<td></td>
            	<td></td>
            	<td align="center" width="90" style="font-size:14px;color:red;font-weight:bold;">应付款：￥<s:property value="#sumall"/>元</td>
				<td align="center">货款支付方式：<s:property value="paymentWay"/></td>
         </tr>
	</table>
	<div class="blank"></div>
	<input type="submit" value="确认订单" class="button red medium"/>
	</div>
	</s:form>
        </s:else>
    </s:else>
    
</div>
</div>
<div class="blank"></div>
<!--页脚-->
<%@ include file="/common/foot.jsp" %>

</body>
</html>