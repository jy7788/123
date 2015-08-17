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
    <script type="text/javascript" src="js/page.js"></script>
     
</head>
<body>

<%@ include file="/common/head.jsp"%>


<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>&gt;<a href="shop/product_list.jsp">建材商城</a>
    </div>
</div>

<div class="blank"></div>

<!--商品分类-->

<div class="divinmiddle">
    <div class="left">
        <div class="leftbanner">全部商品</div>
        <div class="type">
            <div class="typebanner">
                <div>主材</div>
            </div>
            <div class="typedetail">
                <ul>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">1</s:param>      
									 	 </s:url>">瓷砖</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">2</s:param>      
									 	 </s:url>">地板</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">3</s:param>      
									 	 </s:url>">洁具</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">4</s:param>      
									 	 </s:url>">灯具</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">5</s:param>      
									 	 </s:url>">墙纸</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">6</s:param>      
									 	 </s:url>">开关面板</a></li>
					<li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">10</s:param>      
									 	 </s:url>">五金</a></li>
                    
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">12</s:param>      
									 	 </s:url>">集成吊顶</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">13</s:param>      
									 	 </s:url>">厨柜</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">14</s:param>      
									 	 </s:url>">楼梯</a></li>
					<li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">15</s:param>      
									 	 </s:url>">阳光房</a></li>
					<li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">16</s:param>      
					</s:url>">硅藻泥</a></li>
									 	  <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">7</s:param>      
									 	 </s:url>">窗帘</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">8</s:param>      
									 	 </s:url>">木门</a></li>
                    <li><a href="<s:url action="shopInit">  
									   	 <s:param name="categoryId">9</s:param>      
									 	 </s:url>">移门</a></li>
                </ul>
            </div>

            <div class="typebanner">
                <div>家具</div>
            </div>
            <div class="typedetail">
                	<ul>
	                    <li><a href="<s:url action="shopInit">  
										   	 <s:param name="categoryId">1</s:param>      
										 	 </s:url>">沙发</a></li>
	                    <li><a href="<s:url action="shopInit">  
										   	 <s:param name="categoryId">2</s:param>      
										 	 </s:url>">床</a></li>
					</ul>
            </div>
            

            <div class="typebanner">
                <div>智能家居</div>
            </div>
           
        </div>
    </div>
<!--商品查询-->
    <div class="right">
        <div class="rightbanner">高级查询</div>
        <div class="search">
		    	<div id="first">
		    		<ul>
	                    <li><a class="select" >品牌</a></li>
	                    <s:iterator value="#session.brandList">     		
				     		<li><a href="<s:url action="searchPage">  
									   	 <s:param name="brand"><s:property/></s:param>      
									 	 </s:url>"><s:property/></a></li>
			     		</s:iterator>
                	</ul>
		    	</div>
                
                <div id="second">
                	<ul>
	                   <li><a href="#" class="select">规格</a></li>
	                   <s:iterator value="#session.specifiList">     		
				     		<li><a href="<s:url action="searchPage">  
									   	 <s:param name="specifi"><s:property/></s:param>      
									 	 </s:url>"><s:property/></a></li>
			     		</s:iterator>
               	   </ul>
                </div>
               
               <div id="third">
               		<ul>
	                   <li><a href="#" class="select">默认排序</a></li>
	                   <li><a href="searchPage.action?order=price">按价格排序</a></li>
	                   <li><a href="searchPage.action?order=sellCount">按销量排序</a></li>
               		</ul> 
               </div> 
               
               <div id="four">
               		<ul>
	                   <li><a href="#" class="select">已选条件</a></li>
	                   <s:if test="%{#session.condition.brand!='all'}">
	                   		<li><a href="searchPage.action?brand=all"><s:property value="#session.condition.brand"/></a></li>
	                   </s:if>
	                   <s:if test="%{#session.condition.specifi!='all'}">
	                   		<li><a href="searchPage.action?specifi=all"><s:property value="#session.condition.specifi"/></a></li>
	                   </s:if>
	                   <s:if test="%{#session.condition.order=='price'}">
	                   		<li><a href="searchPage.action?order='all'">价格由低到高</a></li>
	                   </s:if>
	                   <s:elseif test="%{#session.condition.order=='sellCount'}">
	                   		<li><a href="searchPage.action?order='all'">销量由高到低</a></li>
	                   </s:elseif>
               		</ul> 
               </div>                
           </div>
        
<!--商品展示-->
	     <div class="goods">
     			<div id="detail">
     				<form action="searchPage" name="form1" id="form1" method="post">
	     			<input type="hidden" name="page.orderFlag" id="page.orderFlag" value="<s:property value="page.orderFlag"/>"/>
	     			<input type="hidden" name="page.orderString" id="page.orderString" value="<s:property value="page.orderString"/>"/>
	     			<div>
	     			<s:iterator value="page.results">     		
			     		<div class="goodsdetail">
			     			<div class="pic"><a href="<s:url action="searchById">  
											   	 	  <s:param name="id" value="id"></s:param>      
											 	 	  </s:url>
			     			"><img src=<s:property value="primPic"/>></img></a></div>
				     		<div class="marketprice"><center>市场价：<s:property value="marketPrice"/> <s:property value="modelNum"/></center></div>
				     		<div class="sellprice"><center>折扣价：<s:property value="sellPrice"/></center></div>
			     		</div>
	     			</s:iterator>
	     			</div>
     			</div>
     			<center><div>
     				<s:property value="page.pageSplit" escape="false"/>
     			</div></center>
     			</form>
    
     	
     </div>  
    </div>
    <div id="dialog">  
        <img width="311" height="213" border="0" src="images/pic_01b.jpg"/>  
    </div> 
</div>



<!--页脚-->
	<%@ include file="/common/foot.jsp"%>
</body>
</html>