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
		<title>班费系统</title>
	</head>
	<body>
	
		<c:choose>
			
			<c:when test="${classFees==null}">
					还没有班费记录呢！<a href="<%=path %>/classfee/addLink">新建班费记录？</a>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>班费串号</td>
						<td>班费事件</td>
						<td>费用</td>
						<td>经手人</td>
						<td>创建时间</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
					<c:forEach items="${classFees }" var="classFee">
						<tr>
							<td>
								<a href="<%=path %>/queryclassFee?fid=${classFee.fid }">${classFee.fid }</a>
							</td>
							<td>
								${classFee.event }
							</td>
							<td>
								${classFee.fee }
							</td>
							<td>
								${classFee.cmaker.realName }
							</td>
							<td>
								${classFee.time }
							</td>
							<td>
								<a href="<%=path %>/modifyLinkclassFee?fid=${classFee.fid }">修改</a>
							</td>
							<td>
								<a href="<%=path %>/deleteclassFee?fid=${classFee.fid }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
			
	</body>
</html>