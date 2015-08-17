<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<link href="css/head.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/hzc/clock.js" charset="UTF-8"></script>

<div id="customercenter">
    <span id="date"></span>
	<s:if test="%{#session.userName==null}">
		<div class="customercenter_right"><a href="#" class="btn">登录</a> | <a href="user/user_reg.jsp">注册</a></div>
	</s:if>
	<s:else>
		<div id="customercenter_left">欢迎回来,<s:property value="%{#session.userName}"/></div>
		<div class="customercenter_right"><s:a action="cart_list">我的购物车</s:a> | <s:a action="order_findByCustomer">我的订单 | </s:a> <s:a action="safequit">安全退出</s:a></div>
	</s:else>
</div>

<div id="banner">
</div>

<div id="nav-div">
	<ul id="nav">
		<li><a href="common/hint.jsp">首页</a></li>
		<li><a href="common/hint.jsp">公司简介</a></li>
		<li><a href="common/hint.jsp">新闻中心</a></li>
		<li><a href="common/hint.jsp">设计团队</a></li>
		<li><a href="common/hint.jsp">服务项目</a></li>
		<li><a href="common/hint.jsp">成功案例</a></li>
		<li><a href="shopInit.action">建材商城</a></li>
		<li><a href="common/hint.jsp">客户留言</a></li>
		<li><a href="common/hint.jsp">联系我们</a></li>
		<li><a href="http://www.njyiyang.com/">公司原网</a></li>
		<li><a href="common/hint.jsp">免费预约</a></li>

	</ul>
</div>

<div class="blank"></div>

 <div class="dialog">  
        
    </div>