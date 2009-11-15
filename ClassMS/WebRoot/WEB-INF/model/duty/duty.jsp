<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<title>职务信息</title>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="addLinkDuty">添加</a>
			</div>
			<c:choose>
				<c:when test="${dutys==null}">
			没有数据			
		</h2>
		</c:when>
		<c:otherwise>
			职务列表</h2>
			<form action="deleteManyDuty" method="post">
				<table class="table">
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
						<th>
							ID
						</th>
						<th>
							担任者
						</th>
						<th>
							职务名称
						</th>
						<th>
							工作介绍
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					<c:forEach items="${dutys}" var="duty">
						<tr>
							<td>
								<input type="checkbox" name="dutyIds" value="${duty.dutyId}" />
							</td>
							<td>
								${duty.dutyId}
							</td>
							<td>
								${duty.student.realName}
							</td>
							<td>
								${duty.dutyName}
							</td>
							<td>
								${duty.job}
							</td>
							<td>
								<a href="getDuty?dutyId=${duty.dutyId}" class="btn_edit"></a>
							</td>
							<td>
								<a href="deleteDuty?dutyId=${duty.dutyId}" class="btn_del"></a>
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