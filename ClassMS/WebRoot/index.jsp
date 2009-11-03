<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	<body>

		<h1>
			学生对象
		</h1>
		<form action="<%=path %>/studentReg.action" method="post">
			用户名：
			<input type="text" name="username" />
			<br />
			密 码：
			<input type="password" name="password" />
			<br />
			<input type="submit" value="提交" />
		</form>
		<form action="fileUpload" method="post" enctype="multipart/form-data">
			<!-- file对应的input必须有name属性,name的值必须和action中的变量对应 -->
			<input type="file" name="documents" />
			<input type="submit" value="submit" />
		</form>
		<br />
		<a href="<%=path %>/classfee.jsp">班费管理</a>
	</body>
</html>