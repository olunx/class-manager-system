<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务管理系统</title>
		<link href="<%=path %>/content/images/main.css" rel="stylesheet" type="text/css" />
		<base target="frame" />
	</head>
	<body>
	
		<div id="header">header</div>
		<div id="content">
			<div id="sidebar">
				<ul>
					<li><a href="<%=path %>/reg/regLink">注册学生</a></li>
					<li><a href="<%=path %>/notice/list">公告管理</a> - <a href="<%=path %>/notice/addLink">添加</a></li>
					<li><a href="<%=path %>/activity/listStu?sno=${sessionScope.student.sno}">活动加分</a> - <a href="<%=path %>/activity/addLink?sno=${sessionScope.student.sno}">申请</a></li>
					<li><a href="<%=path %>/classfee/queryAllclassFee">班费管理</a> - <a href="<%=path %>/classfee/addLink">新建</a> </li>
				</ul>
			</div>
			<div id="main"><iframe name="frame" id="frame" src="#"></iframe></div>
		</div>
	</body>
</html>