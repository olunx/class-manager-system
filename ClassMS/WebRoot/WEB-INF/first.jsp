<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<link href="content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="content/js/common.js"></script>
	</head>
<body>
<h2 class="caption">公告</h2>
<c:choose>
<c:when test="${notices==null}">
	暂时没有公告
</c:when>
<c:otherwise>
	<table class="table">
	<c:forEach items="${notices}" var="notice" begin="0" end="7" step="1">
		<tr><td><a href="<%=path %>/notice/detail?id=${notice.nid }">${notice.title }</a></td><td>${notice.author.realName}</td><td>${notice.time }</td></tr>
		<tr><td colspan="3">${notice.content}</td></tr>
	</c:forEach>
	</table>
</c:otherwise>
</c:choose>

</body>
</html>