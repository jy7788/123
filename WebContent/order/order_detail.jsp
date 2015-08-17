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
    <title>订单详情</title>
    <script type="text/javascript" src="js/page.js"></script>
    <link href="css/orderdetail.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/eshop_cizhuan.jsp">建材商城</a>><a href="order_findByCustomer.action">订单详情</a>
    </div>
</div>

<div class="blank"></div>

<!--订单详情-->
<div class="leftbanner"></div>
<div class="divinmiddle">
<div class="orders">
    
    <form name="form1" id="form1" method="post" action="order_findByCustomer.action">
			<input type="hidden" name="page.orderFlag" id="page.orderFlag"
				value="<s:property value="page.orderFlag" />">
			<input type="hidden" name="page.orderString" id="page.orderString" 
				value="<s:property value="page.orderString"/>">
    <table align="center" width="100%">
          <tr height="30" bgcolor="#971922" style="color:#fff;">   
                <td width="20%" height="30" align="center">             
                                                        商品</td>      
                <td width="20%" align="center">             
                                                        商品名称</td>
                <td width="20%" align="center">价格</td>
                <td width="20%" align="center">数量</td>
                <td width="20%" align="center">商品总价</td>
             
          </tr>
          <table border="0" width="100%">
	          <s:iterator  value="page.results" id="data">
	          <tr height="110">  
	                  <td width="20%" align="center"><img src=<s:property value="primPic"/>></img></td>
	                  <td width="20%" align="center"><s:property value="productName"/></td>
	                  <td width="20%" align="center">￥<s:property value="productPrice"/>元</td>
	                  <td width="20%" align="center"><s:property value="amount"/></td>
	                  <td width="20%" align="center">￥<s:property value="productPrice*amount"/></td>
	          </tr>
			</s:iterator>
		</table>
		<tr height="160px"></tr>
				<tr>
					<td align="center" colspan="10">
						<s:property value="page.pageSplit" escape="false"/>
					</td>
				</tr>
        </table>
    </form>
</div>
</div>
<div class="blank"></div>
<!--页脚-->
<%@ include file="/common/foot.jsp" %>

</body>
</html>