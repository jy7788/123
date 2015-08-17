<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约</title>
<link rel="stylesheet" href="css/ybox.css" type="text/css" />

<script type="text/javascript" src="js/jquery.ybox-01.js"></script>
<script type="text/javascript" src="js/jquery.ybox-02.js"></script>
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript">
$(function(){
	$(".a_click").ybox();
});
</script>
<style type="text/css">
   #title{
     border:1px solid #000;
     width:700px;
     margin:auto;
     background:black;
     
   }
   #head{
     border:1px solid #000;
     border-bottom:1px dashed #000;
     width:700px;
     height:20px;
     background:gray;
     
     margin:auto;
   }
   #body{
     border:1px solid #000;
     border-top:none;
     width:700px;
     height:70px;
     
     margin:auto;
   }
   #time{
   text-align:right;
   margin-left:400px;
   }
   #word{
   text-align:left;
   margin:5px;
   }
</style>
</head>
<body>
<%@ include file="/common/head.jsp"%>

<!--现在所在网页位置-->
<div class="blank"></div>

<div id="location">
    <div>
        <a href="index.jsp">首页</a>><a href="shop/appointment_show.action">免费预约</a>
    </div>
</div>

<div class="blank"></div>

<SCRIPT language=javascript> 
function checkdata()
{
	if(document.form1.per_name.value=="")
	{
		alert("请填写留言者的姓名！");
		document.form1.per_name.focus();
		return false;
	}
	if(document.form1.per_tele.value=="")
	{
		alert("请填写联系电话！");
		document.form1.per_tele.focus();
		return false;
	}
	if(document.form1.mess_intr.value=="")
	{
		//alert("请填写留言内容！");
		//document.form1.mess_intr.focus();
		//return false;
	}
}
</SCRIPT>
<div class="leftbanner"></div>
<div >
    <s:form action="appointment_add" onSubmit="return checkdata()">
			<table width="100%" border="0" cellspacing="5" cellpadding="0" class="forms" >

			    <tr>
			        <td width="15%" align="right">您的姓名：</td>
			        <td width="44%"><s:textfield name="realName" type="text" size="40" maxlength="5"/></td>
			        <td ><font color="#FF0000">*</font>&nbsp;填写您的真实姓名,我们会保护您的个人信息安全</td>
			    </tr>
			    <tr>
			        <td   align="right">选择性别：</td>
			        <td><input name="sex" type="radio" value="先生" checked="checked" style="border: none;" /> 先生 &nbsp;&nbsp;<input name="per_sex" type="radio" value="女士" style="border: none;" /> 女士</td>
			        <td ></td>
			    </tr>
			    <tr>
			        <td  align="right">联系电话：</td>
			        <td><input name="mobile" type="text" onkeypress="if (event.keyCode!=46 &&event.keyCode!=45 &&(event.keyCode < 48 || event.keyCode > 57)) event.returnValue=false" size="40" maxlength="18"  class="s1" /> </td>
			        <td><font color="#FF0000">*</font>&nbsp;为了便捷的联系到您,请留下电话</td>
			    </tr>
			
			    <tr>
			        <td   align="right">装修地址：</td>
			        <td><input name="address" type="text" size="40" maxlength="100"  class="s1"/> </td>
			        <td ></td>
			    </tr>
			    <tr>
			        <td  align="right">装修面积：</td>
			        <td><input name="occupy" type="text" size="40" maxlength="50"  class="s1"/> </td>
			        <td >平方米</td>
			    </tr>
			    <tr>
			        <td   align="right" style="padding-bottom:10px;">装修要求：</td>
			        <td style="padding-bottom:20px;"><textarea name="requirement" cols="36" rows="6" style="height:auto;"></textarea></td>
			        <td valign="top"><font color="#FF0000">*</font>&nbsp; 欢迎填写提问和要求，有关设计、施工、用材、材料采购等方面的问题，我们都可以为您提供解答和帮助</td>
			    </tr>
			    <tr>
			        <td   align="right" style="border-top:1px dashed #d1d3d4;"> </td>
			        <td style="border-top:1px dashed #d1d3d4;padding:20px 0 10px 0"><input type="submit" name="Submit" value=" 提交  ">&nbsp;&nbsp; 
			        <input type="reset" name="cancel" value=" 重置 " > 
			        <input type="hidden" name="operate" value="savedata">&nbsp;&nbsp;</td>
			        <td style="border-top:1px dashed #d1d3d4;"></td>
			    </tr>
			    			</table>
		 </s:form>
	</div>


 <div id="title"><p id="word">成功预约</p></div>
 	<div>   
		<form name="form1" id="form1" method="post" action="appointment_show.action">
			<input type="hidden" name="page.orderFlag" id="page.orderFlag"
				value="<s:property value="page.orderFlag" />">
			<input type="hidden" name="page.orderString" id="page.orderString" 
				value="<s:property value="page.orderString"/>">
          <s:iterator  value="page.results" id="data">
     
      <div id="head"><p id="word">客户: <span><s:property value="realName"/></span>，你已经预约成功 <span id="time"><s:property value="createTime"/></span></p></div>
		          <div id="body">
		              <p id="word">预约需求：<s:property value="requirement"/> </p>
		            
		              <p id="word">易阳回复： <s:property value="realName"/>您好，感谢您对我们易阳装饰的信任，我们那边的设计师会及时与您取得联系。祝您家装修一切顺利！易阳装饰敬  ...</p>
                   </div>
		</s:iterator>
			<s:property value="page.pageSplit" escape="false"/>
    </form>
 </div>   
    <div class="blank"></div>
<!--页脚-->
<%@ include file="/common/foot.jsp" %>
</body>
</html>