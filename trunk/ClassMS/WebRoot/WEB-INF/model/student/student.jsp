<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<title>学生</title>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="addLinkStudent">添加</a>
			</div>
			<c:choose>
				<c:when test="${students==null}">
			没有数据			
		</h2>
		</c:when>
		<c:otherwise>
			学生管理</h2>
			<form action="deleteManyStudent" method="post">
				<table class="table">
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
						<th>
							ID
						</th>
						<th>
							学号
						</th>
						<th>
							姓名
						</th>
						<th>
							用户名
						</th>
						<th>
							密码
						</th>
						<th>
							头像
						</th>
						<th>
							宿舍
						</th>
						<th>
							职位
						</th>
						<th>
							手机
						</th>
						<th>
							QQ
						</th>
						<th>
							邮箱
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>
								<input type="checkbox" name="stuIds" value="${student.stuId}" />
							</td>
							<td>
								${student.stuId}
							</td>
							<td>
								${student.sno}
							</td>
							<td>
								${student.realName}
							</td>
							<td>
								${student.username}
							</td>
							<td>
								${student.password}
							</td>
							<td>
								${student.avatar}
							</td>
							<td>
								${student.dorm}
							</td>
							<td>
								${duty}
							</td>
							<td>
								${student.phoneNo}
							</td>
							<td>
								${student.qq}
							</td>
							<td>
								${student.mail}
							</td>
							<td>
								<a href="getStudent?stuId=${student.stuId}" class="btn_edit"></a>
							</td>
							<td>
								<a href="deleteStudent?aId=${student.stuId}" class="btn_del"></a>
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