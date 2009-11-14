<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../content/images/content.css" rel="stylesheet" type="text/css" /> 
<title>考勤</title>
</head>
<body>
<h2 class="caption"><div class="float_right"><a class="btn btn_add" href="addLinkAttendance">添加</a></div>
		<c:choose>
			<c:when test="${attendances==null}">
			没有数据	</h2> 
			</c:when>
			<c:otherwise>
			考勤管理	</h2> 
			<form action="deleteManyAttendance" method="post">
				<table class="table">
					<tr>
					<th></th>
					<th>ID</th>				
					<th>周次</th>
					<th>星期</th>
					<th>课时</th>
					<th>逃课人员</th>
					<th>记录者</th>
					<th>时间</th>
					<th>修改</th>
					<th>删除</th>
					</tr>
					
					<c:forEach items="${attendances}" var="attendance">
						<tr>
							<td><input type="checkbox" name="aids" value="${attendance.aid}" /></td>
							<td>${attendance.aid}</td>
							<td>${attendance.week}</td>
							<td>${attendance.day}</td>
							<td>${attendance.lesson}</td>
							<td><c:forEach items="${attendance.students}" var="s">${s.realName},</c:forEach></td>
							<td>${attendance.clerk.realName}</td>
							<td>${attendance.time}</td>
							<td><a href="getAttendance?aid=${attendance.aid}" class="btn_edit"></a></td>
							<td><a href="deleteAttendance?aid=${attendance.aid}" class="btn_del"></a></td>
						</tr>
					</c:forEach>
				</table>
					<select name="cmd"> 
						<option value="0" selected="selected">批量操作，请选择</option> 
						<option value="1">删除</option> 
					</select> 
					<input type="submit" value="确定" /> 
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>