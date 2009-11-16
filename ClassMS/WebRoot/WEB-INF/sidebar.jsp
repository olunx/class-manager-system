<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="content/images/main.css" rel="stylesheet" type="text/css" />
<base target="content"></base>
</head>
<body id="sidebar_body">
<div id="sidebar">
	<h2 class="menu">用户管理</h2>
  <ul>
    <li><a href="<%=path %>/admin/listAdmin">管理员</a> - <a href="<%=path %>/admin/addLinkAdmin">添加</a></li>
    <li><a href="<%=path %>/student/listStudent">学生管理</a> - <a href="<%=path %>/student/addLinkStudent">添加</a></li>
    <li><a href="<%=path %>/leader/listLeader">领导管理</a> - <a href="<%=path %>/leader/addLinkLeader">添加</a></li>
    <li><a href="<%=path %>/duty/listDuty">职务管理</a> - <a href="<%=path %>/duty/addLinkDuty">添加</a></li>
    <li><a href="<%=path %>/attendance/listAttendance">考勤管理</a> - <a href="<%=path %>/attendance/addLinkAttendance">添加</a> </li>
    <li><a href="<%=path %>/notice/list">公告管理</a> - <a href="<%=path %>/notice/addLink">添加</a></li>
    <li><a href="<%=path %>/activity/listStu?sno=${sessionScope.student.sno}">活动加分</a> - <a href="<%=path %>/activity/addLink?sno=${sessionScope.student.sno}">添加</a></li>
    <li><a href="<%=path %>/classfee/listPage">班费管理</a> - <a href="<%=path %>/classfee/addLink">添加</a> </li>
	<li><a href="<%=path %>/vote/listPage">投票管理</a> - <a href="<%=path %>/vote/addLink" >添加</a> </li>  
  </ul>
</div>
</body>
</html>