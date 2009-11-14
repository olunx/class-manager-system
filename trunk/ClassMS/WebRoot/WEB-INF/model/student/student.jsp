<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学生</title>
</head>
<body>

<a href="addLinkStudent">注册学生</a>

		<c:choose>
			<c:when test="${students==null}">
					没有发现考勤信息！
			</c:when>
			<c:otherwise>
				<table>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>
								${student.stuId}
							</td>
							<td>
								${student.avatar}
							</td>
							<td>
								${student.username}
							</td>
							<td>
								${student.password}
							</td>
							<td>
								${student.sno}
							</td>
							<td>
								${student.realName}
							</td>
							<td>
								${student.dorm}
							</td>
							<td>
								${duty}
							</td>
							<td>
								${student.phoneNo}
							</td>
							<td>
								${student.qq}
							</td>
							<td>
								${student.mail}
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