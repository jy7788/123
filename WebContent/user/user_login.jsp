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
	<link href="css/userlogin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<div id="regmain">
		<div id="yiyang"><div></div></div>
		<div id="reginfo"><br />
			<s:form action="login" method="post">
				<table width="80%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="70" height="35" align="right">用 户 名：</td>
						<td>
							<s:textfield name="customer.userName" cssClass="bian"></s:textfield>
						</td>
						<td width="10" height="35" align="center"></td>
						<td width="150" height="35" align="left"><s:fielderror fieldName="customer.userName"/></td>
					</tr>
					
					<tr>
						<td width="70" height="35" align="right">密　码：</td>
						<td>
							<s:password name="customer.password" cssClass="bian"></s:password>
						</td>
						<td width="10" height="35" align="center"></td>
						<td width="150" height="35" align="left"><s:fielderror fieldName="customer.password"/> </td>
					</tr>
					
					<tr>
						<td></td>
						<td height="50" valign="middle" align="center">
						<input type="submit" value="登录" class="button red medium"/>&nbsp;&nbsp;&nbsp;
						<input type="reset" class="button red medium"/>
						</td>
						<td></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<br/>
	
</body>
</html>