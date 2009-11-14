<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>投票管理</title>
	</head>
	<body>
	
		<c:choose>
			
			<c:when test="${votes==null}">
					还没有投票记录呢！<a href="<%=path %>/vote/addLink">新建投票？</a>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>投票主题</td>
						<td>投票描述</td>
						<td>创建人</td>
						<td>创建日期</td>
						<td>结束日期</td>
						<td>删除</td>
						<td>投票</td>
					</tr>
					<c:forEach items="${votes }" var="vote">
						<tr>
							<td>
								<a href="<%=path %>/vote/queryvote?vid=${vote.vid }">${vote.title }</a>
							</td>
							<td>
								${vote.summary }
							</td>
							<td>
								${vote.author.realName }
							</td>
							<td>
								${vote.airTime }
							</td>
							<td>
								${vote.deadline }
							</td>
							<td>
								<a href="<%=path %>/vote/deletevote?vid=${vote.vid }">删除</a>
							</td>
							<td>
								<a href="<%=path %>/vote/votingLinkvote?vid=${vote.vid }" >投票</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
			
	</body>
</html>