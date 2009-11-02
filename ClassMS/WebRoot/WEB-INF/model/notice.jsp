<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
	</head>
	<body>
		<a href="add.action">添加公告</a>
		<c:choose>
			<c:when test="${notices==null}">
					还没有公告呢！
			</c:when>
			<c:otherwise>
				<table>
					<c:forEach items="${notices}" var="notice">
						<tr>
							<td>
								<a href="detail.action?id=${notice.nid}">${notice.title}</a>
							</td>
							<td>
								${notice.content}
							</td>
							<td>
								${notice.time}
							</td>
							<td>
								<a href="modify.action?id=${notice.nid }">编辑</a>
							</td>
							<td>
								<a href="del.action?id=${notice.nid }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>