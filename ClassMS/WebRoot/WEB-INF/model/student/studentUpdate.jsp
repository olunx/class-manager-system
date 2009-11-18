<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form class="form" action="updateStudent" method="post">
			<p>
				<label>
					stuId：
				</label>
				<input type="text" name="stuId" value="${student.stuId}" readonly="readonly" />
			</p>
			<p>
				<label>
					avatar：
				</label>
				<input type="text" name="avatar" value="${student.avatar}" />
			</p>
			<p>
				<label>
					username：
				</label>
				<input type="text" name="username" value="${student.username}" />
			</p>
			<p>
				<label>
					password：
				</label>
				<input type="text" name="password" value="${student.password}" />
			</p>
			<p>
				<label>
					sno：
				</label>
				<input type="text" name="sno" value="${student.sno}" />
			</p>
			<p>
				<label>
					realName：
				</label>
				<input type="text" name="realName" value="${student.realName}" />
			</p>
			<p>
				<label>
					dorm：
				</label>
				<input type="text" name="dorm" value="${student.dorm}" />
			</p>
			<p>
				<label>
					duty：
				</label>
				<input type="text" name="dutys" value="<c:forEach items="${student.dutys}" var="d">${d.dutyName},</c:forEach>" />
			</p>
			<p>
				<label>
					phoneNo：
				</label>
				<input type="text" name="phoneNo" value="${student.phoneNo}" />
			</p>
			<p>
				<label>
					qq：
				</label>
				<input type="text" name="qq" value="${student.qq}" />
			</p>
			<p>
				<label>
					mail：
				</label>
				<input type="text" name="mail" value="${student.mail}" />
			</p>
			<p>
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
		<h2 class="caption">
			逃课记录
		</h2>
		<c:forEach items="${student.attendances}" var="a">
			<a href="../attendance/getAttendance?aid=${a.aid}">${a.aid}</a>
			<br />
		</c:forEach>
	</body>
</html>