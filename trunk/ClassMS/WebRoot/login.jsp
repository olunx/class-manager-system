<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>班务管理系统</title>
</head>
<body>
	<div>
		<form action="login.action" method="post">
			用户名：<input type="text" name="username" /><br/>
			密码：<input type="text" name="password" /><br/>
			身份：<select size="1" name="userType">
			<option value="0">学生</option>
			<option value="1">辅导员</option>
			<option value="2">管理员</option>
			</select>
			<br/>
			<input type="submit" value="登陆" /><a href="reg/regLink">注册</a>
		</form>
		
		<br />
		<h2>测试链接</h2>
		<a href="<%=path %>/classfee.jsp">班费管理</a>
		<a href="<%=path %>/vote.jsp">投票管理</a>
		<a href="f.jsp">fatkun</a> 	<br />
		<a href="<%=path %>/content/kissy/kissy.jsp">kissy test</a>
	</div>
</body>
</html>