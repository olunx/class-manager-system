<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班费管理</title>
	</head>
	<body>
		<h1><s:text name="添加班费开支"></s:text> </h1>
		<div style="color:red">
    		<s:fielderror />
		</div>
		<s:form action="addclassFee.action" method="POST" >
			<s:textfield name="classFee.event" label="班费使用记录" />
			<s:textfield name="classFee.fee" label="班费" />
			<s:textfield name="classFee.remarks" label="备注" />
			<s:submit value="提交" />
		</s:form>
		<hr />
		<h1><s:text name="班费记录"/></h1>
		<a href="<%=path %>/queryAllclassFee.action" >查看全部班费记录</a>
		<br />
		<br />
		<s:form action="queryclassFee.action" method="POST" >
			<s:textfield name="fid" label="输入你想查询的班费记录的ID" />
			<s:submit value="提交" />
		</s:form>
		<hr />
		<h1><s:text name="删除班费记录"></s:text></h1>
		<s:form action="deleteclassFee.action" method="POST" >
			<s:textfield name="fid" label="输入你想删除的班费记录的ID" />
			<s:submit value="提交" />
		</s:form>
		<hr />
		<h1><s:text name="修改班费记录"/></h1>
		<s:form action="modifyclassFee.action" method="POST">
			<s:textfield name="classFee.fid" label="班费记录ID" />
			<s:textfield name="classFee.event" label="班费使用记录" />
			<s:textfield name="classFee.fee" label="班费" />
			<s:textfield name="classFee.remarks" label="备注" />
			<s:submit value="提交" />
		</s:form>
	</body>
</html>