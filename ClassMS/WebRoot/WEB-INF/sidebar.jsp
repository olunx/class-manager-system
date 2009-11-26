<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="content/images/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="content/js/jquery.min.js"></script>
<script type="text/javascript" src="content/js/jquery.tools.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#sidebar").tabs(".pane", {tabs: 'h2', effect: 'slide'});
});
</script>
<base target="content"></base>
</head>
<body id="sidebar_body">
<div id="sidebar">
	<h2 class="menu">人员管理</h2>
  <ul class="pane">
    <li class="icon3"><a href="<%=path %>/admin/listAdmin">管理员　</a> - <a href="<%=path %>/admin/addLinkAdmin">添加</a></li>
    <li class="icon1"><a href="<%=path %>/leader/listLeader">领导管理</a> - <a href="<%=path %>/leader/addLinkLeader">添加</a></li>
    <li class="icon1"><a href="<%=path %>/student/listStudent">学生管理</a> - <a href="<%=path %>/student/addLinkStudent">添加</a></li>
    <li class="icon4"><a href="<%=path %>/duty/listDuty">职务设置</a> - <a href="<%=path %>/duty/addLinkDuty">添加</a></li>
  </ul>
  <h2 class="menu">班务管理</h2>
  <ul class="pane">
    <li class="icon1"><a href="<%=path %>/notice/list">公告管理</a> - <a href="<%=path %>/notice/addLink">添加</a></li>
	<li class="icon5"><a href="<%=path %>/vote/list">投票管理</a> - <a href="<%=path %>/vote/addLink" >添加</a> </li>  
	<li class="icon1"><a href="<%=path %>/lesson/listLesson">课程设置</a> - <a href="<%=path %>/lesson/addLinkLesson" >添加</a></li>  
    <li class="icon2"><a href="<%=path %>/attendance/listAttendance">考勤管理</a> - <a href="<%=path %>/attendance/addLinkAttendance">添加</a> </li>
    <li class="icon3"><a href="<%=path %>/activity/listPage?sno=${sessionScope.student.sno}">加分申请</a> - <a href="<%=path %>/activity/addLink?sno=${sessionScope.student.sno}">添加</a></li>
    <li class="icon1"><a href="<%=path %>/classfee/list">班费管理</a> - <a href="<%=path %>/classfee/addLink">添加</a> </li>
 	<li class="icon2"><a href="<%=path %>/leave/listPage?sno=${sessionScope.student.sno}">请假申请</a> - <c:choose><c:when test="${sessionScope.userType==0}"><a class="btn btn_add" href="<%=path %>/leave/addLink?sno=${sno}">添加</a></c:when><c:otherwise><a class="btn" href="<%=path %>/leave/list">审核</a></c:otherwise></c:choose></li>
    <li class="icon4"><a href="<%=path %>/score/listScore">期末成绩发送</a></li>
  </ul>
</div>
</body>
</html>