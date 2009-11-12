<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>注册</title>
	</head>
	<body>
		<h2>注册：</h2>
		<form action="oneStuReg" method="post">
			用户名：
			<input type="text" name="username" />
			<br />
			密 码：
			<input type="password" name="password" />
			<br />
			<input type="submit" value="提交" />
		</form>
		<h2>批量注册：</h2>
		<form action="fileUpload" method="post" enctype="multipart/form-data">
			<!-- file对应的input必须有name属性,name的值必须和action中的变量对应 -->
			<input type="file" name="documents" />
			<input type="submit" value="submit" />
		</form>
	</body>
</html>