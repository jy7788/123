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
	<link href="css/userreg.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="/common/head.jsp"%>
	<div id="regmain">
		<div id="yiyang"><div></div></div>
		<div id="reginfo"><br />
			<s:form action="register" method="post">
				<table width="80%" border="0" cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td width="70" height="35" align="right">用 户 名：</td>
						<td>
							<s:textfield name="customer.userName" cssClass="bian"></s:textfield>
						</td>
						<td width="10" height="35" align="center">*</td>
						<td width="250" height="35" align="left"><div class="tips"><s:fielderror fieldName="customer.userName"/></div></td>
					</tr>
					
					<tr><td></td><td align="left" colspan="3"><div class="tips">4-20位字符，使用字母、数字及下划线</div></td></tr>
					
					<tr>
						<td width="70" height="35" align="right">真实姓名：</td>
						<td>
							<s:textfield name="customer.realName" cssClass="bian"></s:textfield>
						</td>
						<td width="10" height="35" align="center">*</td>
						<td width="150" height="35" align="left"><div class="tips"><s:fielderror fieldName="customer.realName"/></div></td>
					</tr>
					
					<tr>
						<td width="70" height="35" align="right">密　码：</td>
						<td>
							<s:password name="customer.password" cssClass="bian"></s:password>
						</td>
						<td width="10" height="35" align="center">*</td>
						<td width="150" height="35" align="left"><div class="tips"><s:fielderror fieldName="customer.password"/></div></td>
					</tr>
					
					<tr><td></td><td align="left" colspan="3"><div class="tips">6-20位字符，建议由字母、数字和符号两种以上组合</div></td></tr>
					
					<tr>
						<td width="70" height="35" align="right">确认密码：</td>
						<td>
							<s:password name="customer.rePassword" cssClass="bian"></s:password>
						</td>
						<td width="10" height="35" align="center">*</td>
					</tr>
					<tr>
						<td width="70" height="35" align="right">邮箱地址：</td>
						<td>
							<s:textfield name="customer.email" cssClass="bian"></s:textfield>
						</td>
						<td width="10" height="35" align="center"></td>
						
					</tr>
					<tr>
						<td width="70" height="35" align="right">住　址：</td>
						<td>
							<s:textfield name="customer.address" cssClass="bian"></s:textfield>
						</td>
						<td width="10" height="35" align="right"></td>
					</tr>
					<tr>
						<td width="70" height="35" align="right">手　机：</td>
						<td>
							<s:textfield name="customer.mobile" cssClass="bian"></s:textfield>
						</td>
						<td width="10" height="35" align="center">*</td>
						<td width="150" height="35" align="left"><div class="tips"><s:fielderror fieldName="customer.mobile"/></div></td>
					</tr>
					<tr><td></td><td align="left" colspan="3"><div class="tips">请填写正确的手机号码</div></td></tr>
					<tr>
						<td></td>
						<td height="50" valign="middle" align="center">
						<input type="submit" value="注册" class="button red medium"/>&nbsp;&nbsp;&nbsp;
						<input type="reset" class="button red medium"/>
						</td>
						<td></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<br/>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>