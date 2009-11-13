<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h2 class="caption">
			活动加分申请情况  - ${student.realName }
		</h2>
		
			<c:choose>
				<c:when test="${activityApplys eq null}">
							暂时没有信息
				</c:when>
				<c:otherwise>
					<form action="batch?sno=${sno}" method="post">
					<table class="table">
					<tr><th></th><th>类型</th><th>分数</th><th>加分原因</th><th>状态</th><th>删除</th></tr>
					<c:forEach items="${activityApplys}" var="activity">
						<tr>
							<td>
								<input type="checkbox" name="aids" value="${activity.aid }" />
							</td>
							<td>
								${activity.type }
							</td>
							<td>
								${activity.mark }
							</td>
							<td>
								${activity.reason }
							</td>
							<td>
								<c:if test="${activity.pass==0}">未审核</c:if>
								<c:if test="${activity.pass==1}">通过</c:if>
								<c:if test="${activity.pass==2}">拒绝</c:if>
							</td>
							<td><a href="del.action?aid=${activity.aid }&sno=${sno}">删除</a></td>
						</tr>
					</c:forEach>
					</table>
					<select name="cmd">
						<option value="0" selected="selected">批量操作，请选择</option>
						<option value="1">设为通过</option>
						<option value="2">设为拒绝</option>
						<option value="3">删除</option>
					</select>
					<input type="submit" value="确定" />
					</form>
				</c:otherwise>
			</c:choose>
	</body>
</html>