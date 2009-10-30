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
		<s:form action="/<%=path %>/classfee.action" method="POST">
			<s:textfield name="cmaker" label="经手人" />
			<s:textfield name="event" label="班费使用记录" />
			<s:textfield name="fee" label="班费" />
			<s:textfield name="remarks" label="备注" />
			<s:submit value="提交" />
		</s:form>
	</body>
</html>