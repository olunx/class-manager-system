<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改管理员信息</title>
	</head>
	<body>
		<h2 class="caption">
			修改管理员信息
		</h2>
		<form action="updateAdmin" method="post">
			adminId：
			<input type="text" name="adminId" value="${admin.adminId}" readonly="readonly" />
			<br />
			username：
			<input type="text" name="username" value="${admin.username}" />
			<br />
			password：
			<input type="text" name="password" value="${admin.password}" />
			<br />
			avatar：
			<input type="text" name="avatar" value="${admin.avatar}" />
			<br />
			realName：
			<input type="text" name="realName" value="${admin.realName}" />
			<br />
			remark：
			<input type="text" name="remark" value="${admin.remark}" />
			<br />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
		</form>
	</body>
</html>