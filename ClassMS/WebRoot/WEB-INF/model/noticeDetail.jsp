<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	<body>
	<a href="list.action">公告列表</a>
		<div>
			<div>
				<h1>
					${notice.title }
				</h1>
				${notice.content }
			</div>
			<hr />

			<c:forEach items="${posts}" var="post">
				
					<div>
						<div>
							${post.time}
						</div>
						${post.content}
						<a href="delPost.action?id=${param.id }&pid=${post.pid }">删除</a>
						<a href="modifyPost.action?id=${param.id }&pid=${post.pid }">编辑</a>
					</div>
			</c:forEach>
		</div>
		<div>
			<form action="addPost.action" method="post">
				评论：
				<input type="hidden" name="id" value="${param.id }" />
				<textarea rows="10" cols="10" name="content"></textarea>
				<input type="submit" value="写好了，保存" />
			</form>
		</div>
	</body>
</html>