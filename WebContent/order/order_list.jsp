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
    <title>订单信息</title>
    <script type="text/javascript" src="js/page.js"></script>
    <link href="css/eshop.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/eshop_cizhuan.jsp">建材商城</a>><a href="order_findByCustomer.action">订单信息</a>
    </div>
</div>

<div class="blank"></div>

<!--订单信息-->
<div class="leftbanner"></div>
<div class="divinmiddle">
<div class="orders">
    
    <form name="form1" id="form1" method="post" action="order_findByCustomer.action">
			<input type="hidden" name="page.orderFlag" id="page.orderFlag"
				value="<s:property value="page.orderFlag" />">
			<input type="hidden" name="page.orderString" id="page.orderString" 
				value="<s:property value="page.orderString"/>">
    <table align="center" width="100%">
          <tr>
            <td height="30" bgcolor="#971922">
            	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	              <tr style="color:#fff;">
	                <td width="15%" height="30" align="center">
	                <a href="javascript:SetOrder('orderId')" style="color:#fff;"> 
	                                                        订单号码</a></td>
	                <td width="10%" align="center">订单总金额</td>
	                <td width="10%" align="center">收货人</td>
	                <td width="28%" align="center">收货地址</td>
	                <td width="10%" align="center">支付方式</td>
					 <td width="15%" align="center">
					<a href="javascript:SetOrder('createTime')" style="color:#fff;">创建时间</a> 
					 </td>
					  <td width="6%" align="center">
					 <a href="javascript:SetOrder('orderState')" style="color:#fff;"> 
					  订单状态</a></td>
					  <td width="6%" align="center" >查看详情</td>
	              </tr>
            	</table>
            </td>
          </tr>
          <s:iterator  value="page.results" id="data">
          <tr>
            <td><div>
              <table border="0" width="100%" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="15%" height="30" align="center"><s:property value="orderId"/></td>
                  <td width="10%" align="center"><s:property value="totalPrice"/></td>
                  <td width="10%" align="center"><s:property value="name"/></td>
                  <td width="28%" align="center"><s:property value="address"/></td>
                  <td width="10%" align="center"><s:property value="paymentWay"/></td>
                  <td width="15%" align="center"><p><s:date name="createTime" format="yyyy年MM月d日 HH:mm"/></p>
                  </td>
                  <td width="6%" align="center"><s:property value="orderState"/></td>
                   <td width="6%" align="center">
                  <s:a action="order_detail">
					<s:param name="orderId" value="orderId"></s:param>
					详情
				</s:a>
                  </td>
                </tr>
              </table>
            </div></td>
          </tr>
		</s:iterator>
		<tr height="160px"><td colspan="8"></td></tr>
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