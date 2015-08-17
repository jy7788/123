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
    <title>购物车</title>
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

<!--购物车信息-->
<div class="leftbanner"></div>
<div class="divinmiddle">
<div class="carts">

   <s:if test="%{#session.userName==null}">
         请登录
   </s:if>
  <s:else>
    <s:if test="%{#session.cart==null}">
    	<div  class="empty"></div>
    	<div style="font-size:15px;font-weight:bold;">您的购物车为空</div>
    	<div class="blank"></div>
    	<div style="font-size:15px;font-weight:bold;"><s:a style="color:red;" action="shopInit"> 前去购物　</s:a></div>
        <div class="empty"></div>     
    </s:if>
    <s:else>
    <s:set value="%{0}" var="sumall"></s:set>
    <table width="688" border="1" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" bgcolor="#971922"><table width="688" height="30" border="0" cellpadding="0" cellspacing="0" class="green">
              <tr>
                <td width="213" height="30" align="center" style="font-color:#fff;">商品名称</td>
                <td width="130" align="center">市场价</td>
                <td width="130" align="center">价格</td>
                <td width="104" align="center">数量</td>
                <td width="111" align="center">操作</td>
              </tr>
            </table></td>
          </tr>
          <s:iterator value="#session.cart">
          <s:set value="%{#sumall +productPrice*amount}" var="sumall"/>
          <tr>
            <td><div>
              <table width="688" height="30" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="213" height="30" align="center"><s:property value="productName"/></td>
                  <td width="130" align="center"><span style="text-decoration: line-through;">
                  ￥<s:property value="productMarketprice"/>元</span>
                  </td>
                  <td width="130" align="center">￥<s:property value="productPrice"/>元<br>
			为您节省：￥<s:property value="productMarketprice*amount - productPrice*amount"/>元</td>
                  <td width="104" align="center"><s:property value="amount"/></td>
                  <td width="111" align="center">
                  <s:a action="cart_delete">
					<s:param name="productId" value="productId"></s:param>
					删除
				</s:a>
                  </td>
                </tr>
               
              </table>
            </div></td>
          </tr>
           </s:iterator>           
          <tr>
          <td height="25" align="right">
            	总价：<span>￥<s:property value="#sumall"/></span>元　&nbsp;</td>
            	</tr>
           <tr>
            <td height="60" align="center" valign="middle">
            <s:a action="cart_clear">
					 清除
            </s:a>　　
			<s:a action="shopInit">
                                         继续挑选　
            </s:a>　　
            <s:a action="order_add">
                                         购买
            </s:a>
            </td>
          </tr>
        </table>
        </s:else>
    </s:else>
    
</div>
</div>

<!--页脚-->
<%@ include file="/common/foot.jsp" %>

</body>
</html>