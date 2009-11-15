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
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="<%=path %>/classfee/addLink">添加</a>
			</div>
			<c:choose>
			
			<c:when test="${classFees==null}">
					没有班费记录</a>
			</c:when>
		<c:otherwise>
			班费管理
			</h2>
			<form action="<%=path %>/classfee/deleteMany" method="post">
				<table class="table">
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
						<th>班费串号</th>
						<th>班费事件</th>
						<th>费用</th>
						<th>经手人</th>
						<th>创建时间</th>
						<th>修改</th>
						<th>删除</th>
					</tr>
					<c:forEach items="${classFees }" var="classFee">
						<tr>						
							<td>
								<input type="checkbox" name="fids" value="${classFee.fid}" />
							</td>
							<td>
								<a href="<%=path %>/classfee/query?fid=${classFee.fid }">${classFee.fid }</a>
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
								<a href="<%=path %>/classfee/modifyLink?fid=${classFee.fid }" class="btn_edit"></a>
							</td>
							<td>
								<a href="<%=path %>/classfee/delete?fid=${classFee.fid }" class="btn_del"></a>
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