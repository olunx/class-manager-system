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
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
	
		<c:choose>
			
			<c:when test="${votes==null}">
					还没有投票记录呢！<a href="<%=path %>/vote/addLink">新建投票？</a>
			</c:when>
			<c:otherwise>
				<table class="table">
					<tr>
						<th>投票主题</th>
						<th>投票描述</th>
						<th>创建人</th>
						<th>创建日期</th>
						<th>结束日期</th>
						<th>删除</th>
						<th>投票</th>
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