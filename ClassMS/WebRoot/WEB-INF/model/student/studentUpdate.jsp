<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改学生信息</title>
	</head>
	<body>
		<h2 class="caption">
			修改学生信息
		</h2>
		<form action="updateStudent" method="post">
			stuId：
			<input type="text" name="stuId" value="${student.stuId}" readonly="readonly" />
			<br />
			avatar：
			<input type="text" name="avatar" value="${student.avatar}" />
			<br />
			username：
			<input type="text" name="username" value="${student.username}" />
			<br />
			password：
			<input type="text" name="password" value="${student.password}" />
			<br />
			sno：
			<input type="text" name="sno" value="${student.sno}" />
			<br />
			realName：
			<input type="text" name="realName" value="${student.realName}" />
			<br />
			dorm：
			<input type="text" name="dorm" value="${student.dorm}" />
			<br />
			duty：
			<input type="text" name="duty" value="${duty}" />
			<br />
			phoneNo：
			<input type="text" name="phoneNo" value="${student.phoneNo}" />
			<br />
			qq：
			<input type="text" name="qq" value="${student.qq}" />
			<br />
			mail：
			<input type="text" name="mail" value="${student.mail}" />
			<br />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
		</form>
	</body>
</html>