<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	<body>
		<form action="<%=path %>/fetion/sendFetion" method="post">
			<p>
				你的手机号码：
				<input type="text" name="phone" value="" />
			</p>
			<p>
				你的飞信密码：
				<input type="password" name="pwd" value="" />
			</p>
			<p>
				发送手机号：
				<textarea rows="3" cols="60" name="tophones">用逗号隔开</textarea>
			</p>
			<p>
				发送内容:
				<textarea rows="5" cols="60" name="content">${content }</textarea>
			</p>
			<p>
				<input type="submit" value="发送" />
			</p>
		</form>
	</body>
</html>