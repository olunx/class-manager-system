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
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="<%=path %>/vote/addLink">添加</a>
			</div>
			<c:choose>
			
			<c:when test="${votes==null}">
					没有投票记录</a>
		</h2>
		</c:when>
		<c:otherwise>
			投票管理</h2>
			<form action="<%=path %>/vote/deleteMany" method="post">
				<table class="table">
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
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
								<input type="checkbox" name="vids" value="${vote.vid}" />
							</td>
							
							<td>
								<a href="<%=path %>/vote/query?vid=${vote.vid }">${vote.title }</a>
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
								<a href="<%=path %>/vote/delete?vid=${vote.vid }" class="btn_del"></a>
							</td>
							<td>
								<a href="<%=path %>/vote/votingLink?vid=${vote.vid }" >投票</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<select name="cmd">
					<option value="0" selected="selected">
						批量操作，请选择
					</option>
					<option value="1">
						删除
					</option>
				</select>
				<input type="submit" value="确定" />
				</form>
			</c:otherwise>
		</c:choose>
			
	</body>
</html>