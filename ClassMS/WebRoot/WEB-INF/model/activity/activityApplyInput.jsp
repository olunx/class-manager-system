<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
	</head>
	<body>
		<form action="add.action" method="post">
		<input name="sno" type="hidden" value="${param.sno }" />
			原因：<input type="text" name="reason" />
			分数：<input type="text" name="mark" />
			<select name="type">
				<option value="德育">德育</option>
				<option value="活动">活动</option>
				<option value="文体">文体</option>
			</select>
			<br/>
			原因：<input type="text" name="reason" />
			分数：<input type="text" name="mark" />
			<select name="type">
				<option value="德育">德育</option>
				<option value="活动">活动</option>
				<option value="文体">文体</option>
			</select>
			<br/>
			原因：<input type="text" name="reason" />
			分数：<input type="text" name="mark" />
			<select name="type">
				<option value="德育">德育</option>
				<option value="活动">活动</option>
				<option value="文体">文体</option>
			</select>
			<br/>
			<input type="submit" value="提交申请" />
		</form>
	</body>
</html>