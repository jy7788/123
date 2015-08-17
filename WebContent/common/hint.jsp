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
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div>对不起，建设中</div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<div class="blank"></div>
<!--页脚-->
	<%@ include file="/common/foot.jsp"%>
</body>

</html>