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
		<h2>${student.realName }</h2>
		<div><a href="addLink.action?sno=${sno}">添加</a></div>
		<c:choose>
			<c:when test="${activityApplys eq null}">
				暂时没有信息
			</c:when>
			<c:otherwise>
				<c:forEach items="${activityApplys}" var="activity">
					${activity.mark } - ${activity.reason } <a href="del.action?aid=${activity.aid }&sno=${sno}">删除</a>
					<br/>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</body>
</html>