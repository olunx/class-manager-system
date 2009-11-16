<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>

	</head>
	<body>
		<h2 class="caption"><div class="float_right"><a class="btn btn_add" href="#">添加</a></div>
			公告管理
		</h2>
		<c:choose>
			<c:when test="${notices==null}">
					还没有公告呢！
			</c:when>
			<c:otherwise>
				<table class="table">
				<tr><th>标题</th><th>发布人</th><th>内容</th><th>时间</th><th>编辑</th><th>删除</th></tr>
					<c:forEach items="${notices}" var="notice">
						<tr>
							<td>
								<a href="detail?id=${notice.nid}">${notice.title}</a>
							</td>
							<td>
								${notice.author.realName}
							</td>
							<td>
								${fn:substring(notice.content,0,30)}...
							</td>
							<td>
								<fmt:formatDate value="${notice.time}" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>
								<a href="modify?id=${notice.nid }">编辑</a>
							</td>
							<td>
								<a href="del?id=${notice.nid }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>