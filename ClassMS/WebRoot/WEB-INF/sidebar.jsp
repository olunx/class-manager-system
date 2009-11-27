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
	// 鼠标移上表格变色
	$("#sidebar a").hover(function() {
		$(this).addClass("spanhover");
	}, function() {
		$(this).removeClass("spanhover");
	});
});
</script>
<base target="content"></base>
</head>
<body>
<div id="sidebar">
	<h2 class="menu">人员管理</h2>
  <ul class="pane">
    <li class="icon3"><a class="add" href="<%=path %>/admin/addLinkAdmin"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/admin/listAdmin"><span>管理员</span></a></li>
    <li class="icon1"><a class="add" href="<%=path %>/leader/addLinkLeader"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/leader/listLeader"><span>领导管理</span></a></li>
    <li class="icon1"><a class="add" href="<%=path %>/student/addLinkStudent"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/student/listStudent"><span>学生管理</span></a></li>
    <li class="icon4"><a class="add" href="<%=path %>/duty/addLinkDuty"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/duty/listDuty"><span>职务设置</span></a></li>
  </ul>
  <h2 class="menu">班务管理</h2>
  <ul class="pane">
    <li class="icon1"><a class="add" href="<%=path %>/notice/addLink"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/notice/list"><span>公告管理</span></a></li>
	<li class="icon5"><a class="add" href="<%=path %>/vote/addLink" ><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/vote/list"><span>投票管理</span></a></li>  
	<li class="icon1"><a class="add" href="<%=path %>/lesson/addLinkLesson" ><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/lesson/listLesson"><span>课程设置</span></a></li>  
    <li class="icon2"><a class="add" href="<%=path %>/attendance/addLinkAttendance"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/attendance/listAttendance"><span>考勤管理</span></a></li>
    <li class="icon3"><a class="add" href="<%=path %>/activity/addLink?sno=${sessionScope.student.sno}"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/activity/listPage?sno=${sessionScope.student.sno}"><span>加分申请</span></a></li>
    <li class="icon1"><a class="add" href="<%=path %>/classfee/addLink"><img src="content/images/add.gif" /></a><a class="url" href="<%=path %>/classfee/list"><span>班费管理</span></a></li>
 	<li class="icon2"><c:choose><c:when test="${sessionScope.userType==0}"><a class="add" href="<%=path %>/leave/addLink?sno=${sessionScope.student.sno}"><img src="content/images/add.gif" /></a></c:when><c:otherwise><a class="btn" href="<%=path %>/leave/list">审核</a></c:otherwise></c:choose><a class="url" href="<%=path %>/leave/listPage?sno=${sessionScope.student.sno}"><span>请假申请</span></a></li>
    <li class="icon4"><a class="url" href="<%=path %>/score/listScore"><span>期末成绩发送</span></a></li>
  </ul>
</div>
</body>
</html>