<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>添加一个学生</title>
	</head>
	<body>
		<form action="addStudent" method="post">
avatar：<input type="text" name="avatar"  /> <br />
username：<input type="text" name="username"  /> <br />
password：<input type="text" name="password"  /> <br />
sno：<input type="text" name="sno"  /> <br />
realName：<input type="text" name="realName"  /> <br />
dorm：<input type="text" name="dorm"  /> <br />
duty：<input type="text" name="duty"  /> <br />
phoneNo：<input type="text" name="phoneNo"  /> <br />
qq：<input type="text" name="qq"  /> <br />
mail：<input type="text" name="mail"  /> <br />
<input type="submit" value="提交" /><input type="reset" value="重置"/>
		</form>
	</body>
</html>