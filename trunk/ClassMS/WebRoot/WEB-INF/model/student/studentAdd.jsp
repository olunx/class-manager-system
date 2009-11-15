<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>添加学生</title>
	</head>
	<body>
		<h2 class="caption">
			添加学生
		</h2>
		<form action="addStudent" method="post">
			avatar：
			<input type="text" name="avatar" />
			<br />
			username：
			<input type="text" name="username" />
			<br />
			password：
			<input type="text" name="password" />
			<br />
			sno：
			<input type="text" name="sno" />
			<br />
			realName：
			<input type="text" name="realName" />
			<br />
			dorm：
			<input type="text" name="dorm" />
			<br />
			duty：
			<input type="text" name="duty" />
			<br />
			phoneNo：
			<input type="text" name="phoneNo" />
			<br />
			qq：
			<input type="text" name="qq" />
			<br />
			mail：
			<input type="text" name="mail" />
			<br />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
		</form>
		<h2>
			批量注册：
		</h2>
		<c:choose>
			<c:when test="${fileData==null}">
				<form action="fileUpload" method="post" enctype="multipart/form-data">
					<!-- file对应的input必须有name属性,name的值必须和action中的变量对应 -->
					<input type="file" name="documents" />
					<input type="submit" value="submit" />
				</form>
			</c:when>
			<c:otherwise>
				<div>
					${fileData}
				</div>
				<form action="addManyStudent" method="post">
					<input type="hidden" value="${fileName}" name="fileName" />
					<input type="submit" value="确定" />
				</form>
			</c:otherwise>
		</c:choose>
	</body>
</html>