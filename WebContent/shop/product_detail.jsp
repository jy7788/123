<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>南京易阳装饰</title>
    <link href="css/productdetail.css" rel="stylesheet" type="text/css" />
    
    <script src="http://www.codefans.net//ajaxjs/jquery1.3.2.js"></script>
    <script>
    $(document).ready(function(){
    $("#add").click(function(){
    var n=$("#num").val();
      var num=parseInt(n)+1;
     if(num==0){alert("cc");}
      $("#num").val(num);
    });
 
    $("#jian").click(function(){
    var n=$("#num").val();
      var num=parseInt(n)-1;
       if(num==0){alert("不能为0!"); return}
      $("#num").val(num);
      });
 
    });
    </script>
    
</head>
<body>

<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/eshop_cizhuan.jsp">建材商城</a>><a href="#">商品详情</a>
    </div>
</div>

<div class="blank"></div>

<!-- 商品详情展示 -->
<div id="detail">
	<s:iterator value="#session.productList">
		<div id="main">			     		
    		<div id="pic">
    			<img src=<s:property value="primPic"/>></img>
    		</div>
    		<div id="goodsdetail">
    			<div id="name"><s:property value="name"/></div>
    			<div id="price">
    				<div id="left">
    					<div id="marketprice"><del>市场价: <s:property value="marketPrice"/></del></div>
    					<div id="sellprice">折扣价:¥ <s:property value="sellPrice"/></div>
				</div>
    				<div id="right">销量:<s:property value="sellCount"/></div>
    			</div>
    			<div class="details">品牌：<s:property value="brand"/></div>
    			<div class="details">型号：<s:property value="modelNum"/></div>
    			<div class="details">规格：<s:property value="specifi"/></div>
    			<div class="details">支付：货到付款</div>
    			<div class="details">计价单位：<s:property value="unit"/></div>
    			<div>
    				<form action="cart_add" method="post" name="addcart">
    					<div class="details">
    					数量 ：<input type="button" class="red" id="jian" style="width:20px;" value="-" />
    						  <input type="text" value="1" id="num" name="num" style="width:50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
							  <input type="button" class="red" id="add" style="width:20px;" value="+" />
							  <input type="hidden" name="id" id="id" value="<s:property value="id"/>"/>
		    			</div>
		    		<div><a href="javascript:addcart.submit();"><img src="images/cart.png"/></a></div> 
		    			
    				</form>  
     				
    			</div>
    			<div class="details">承诺：震天 反攻倒算上下左右五块石枯</div>
    			<div class="details">售后服务：震天 反攻倒算上下左右五块石枯</div>
    		</div>    		  		
		</div>	
		<div class="blank"></div>
		<div id="description">
			<div id="desdetail"><div>商品详情</div></div>
			<div id="contentdetail"><s:property value="description" escape="false"/></div>
		</div>
	</s:iterator>
</div>
 
<div id="return"><a href="javascript:scroll(0,0)">返回顶部</a></div>
<!--页脚-->
	<%@ include file="/common/foot.jsp"%>
</body>

</html>