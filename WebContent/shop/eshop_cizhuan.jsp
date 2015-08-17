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
    <link href="css/eshop.css" rel="stylesheet" type="text/css" />
   
    <script type="text/javascript">
$(function(){  
    //广告弹出层  
    $('#dialog').animate({  
        height:213+'px'  
    },2000);  
})
</script>
</head>
<body>

<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/eshop_cizhuan.jsp">建材商城</a>
    </div>
</div>

<div class="blank"></div>

<!--商品分类-->

<div class="divinmiddle">
    <div class="left">
        <div class="leftbanner">全部商品</div>
        <div class="type">
            <div class="typebanner">
                <div>厨卫主材</div>
            </div>
            <div class="typedetail">
                <ul>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                </ul>
            </div>

            <div class="typebanner">
                <div>客卧主材</div>
            </div>
            <div class="typedetail">
                <ul>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                </ul>
            </div>

            <div class="typebanner">
                <div>基础建材</div>
            </div>
            <div class="typedetail">
                <ul>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                    <li><a href="#">瓷砖</a></li>
                </ul>
            </div>
        </div>
    </div>
<!--商品查询-->
    <div class="right">
        <div class="rightbanner">高级查询</div>
        <div class="search">
		    	<div id="first">
		    		<ul>
	                    <li><a href="#" class="select" >品牌</a></li>
	                    <s:iterator value="#session.brandList">     		
				     		<li><a href="search.action?brand=<s:property/>"><s:property/></a></li>
			     		</s:iterator>
                	</ul>
		    	</div>
                
                <div id="second">
                	<ul>
	                   <li><a href="#" class="select">规格</a></li>
	                   <s:iterator value="#session.specifiList">     		
				     		<li><a href="search.action?specifi=<s:property/>"><s:property/></a></li>
			     		</s:iterator>
               	   </ul>
                </div>
               
               <div id="third">
               		<ul>
	                   <li><a href="#" class="select">默认排序</a></li>
	                   <li><a href="search.action?order=price">按价格排序</a></li>
	                   <li><a href="search.action?order=sellCount">按销量排序</a></li>
               		</ul> 
               </div> 
               
               <div id="four">
               		<ul>
	                   <li><a href="#" class="select">已选条件</a></li>
	                   <%
	                   		String brand = new String(session.getAttribute("brand").toString().getBytes("ISO-8859-1"),"UTF-8");	                   		
	                   %>
	                   <s:if test="%{#session.brand!='all'}">
	                   		<li><a href="search.action?brand=all"><%=brand %></a></li>
	                   </s:if>
	                   <s:if test="%{#session.specifi!='all'}">
	                   		<li><a href="search.action?specifi=all"><s:property value="#session.specifi"/></a></li>
	                   </s:if>
	                   <s:if test="%{#session.order=='price'}">
	                   		<li><a href="search.action?order='all'">价格由低到高</a></li>
	                   </s:if>
	                   <s:elseif test="%{#session.order=='sellCount'}">
	                   		<li><a href="search.action?order='all'">销量由高到低</a></li>
	                   </s:elseif>
               		</ul> 
               </div>                
           </div>
        
<!--商品展示-->
	     <div class="goods">
     		<div>
     			<s:iterator value="#session.productList">     		
	     		<div class="goodsdetail">
	     			<div class="pic"><img src=<s:property value="primPic"/>></img></div>
		     		<div class="marketprice"><center>市场价：<s:property value="marketPrice"/></center></div>
		     		<div class="sellprice"><center>折扣价：<s:property value="sellPrice"/></center></div>
	     		</div>
     		</s:iterator>
     	</div>
     	<div id="page"><center><a href="#">上一页</a> | <a href="#">下一页</a></center></div>
     </div>  
    </div>
</div>

 <div id="dialog">  
        <img width="311" height="213" border="0" src="images/pic_01b.jpg"/>  
    </div> 
<!--页脚-->
	<%@ include file="/common/foot.jsp"%>
</body>
</html>