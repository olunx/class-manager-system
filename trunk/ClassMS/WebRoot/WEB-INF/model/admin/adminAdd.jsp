<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>添加管理员</title>
	</head>
	<body>
		<h2 class="caption">
			添加管理员
		</h2>
		<form action="addAdmin" method="post">
			username：
			<input type="text" name="username" />
			<br />
			password：
			<input type="text" name="password" />
			<br />
			realName：
			<input type="text" name="realName" />
			<br />
			avatar：
			<input type="text" name="avatar" />
			<br />
			remark：
			<input type="text" name="remark" />
			<br />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
		</form>
	</body>
</html>