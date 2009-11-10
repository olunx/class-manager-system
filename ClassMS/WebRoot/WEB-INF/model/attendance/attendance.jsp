<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>考勤</title>
</head>
<body>

<a href="<%=path %>/jumpAddAttendance">添加考勤信息</a>
<a href="<%=path %>/jumpAddAttendance">修改考勤信息</a>
<a href="<%=path %>/jumpListAttendance">查看考勤信息</a>

		<c:choose>
			<c:when test="${attendances==null}">
					没有发现考勤信息！
			</c:when>
			<c:otherwise>
				<table>
					<c:forEach items="${attendances}" var="attendance">
						<tr>
							<td>
								${attendance.aid}
							</td>
							<td>
								${attendance.week}
							</td>
							<td>
								${attendance.day}
							</td>
							<td>
								${attendance.lesson}
							</td>
							<td>
								<a href="getAttendance?aid=${attendance.aid}">编辑</a>
							</td>
							<td>
								<a href="deleteAttendance?aid=${attendance.aid}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
</body>
</html>