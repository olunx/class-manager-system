<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
	<h2 class="caption">公告内容</h2>
		<div>
			<div id="notice">
				<h1>
					${notice.title } <span>${notice.author.realName }</span>
				</h1>
				<div class="content">
				${notice.content }
				</div>
			</div>

			<c:forEach items="${posts}" var="post" varStatus="i">
					<div class="post">
						<div class="post_info">
                        <a class="btn_del float_right"  href="delPost?id=${param.id }&pid=${post.pid }">删除</a>
                        <a class="btn_edit float_right" href="modifyPost?id=${param.id }&pid=${post.pid }">编辑</a>
                        ${i.count}.${post.author.realName} <fmt:formatDate value="${post.time}" pattern="yyyy-MM-dd HH:mm"/>
						
						</div>
						<div class="post_content">
						${post.content}
						</div>
					</div>
			</c:forEach>
		</div>
		<div id="notice_post">
			<form action="addPost" method="post">
				评论：<s:fielderror><s:param>content</s:param></s:fielderror>
				<input type="hidden" name="id" value="${param.id }" />
				<textarea rows="3" cols="40" name="content"></textarea>
				<input type="submit" value="写好了，保存" />
			</form>
		</div>
	</body>
</html>