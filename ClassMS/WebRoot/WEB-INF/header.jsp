<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="content/images/main.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="content/js/common.js"></script>
		<base target="content" />
	</head>
	<body>
		<div id="header">
			<div id="logo"><img src="content/images/header_logo.jpg" /></div>
			<div id="header_tool">
				<a id="btn_main" href="first">首页</a>
				<a id="btn_back" href="javascript:history.back();">后退</a>
				<a id="btn_forward" href="javascript:history.forward();">前进</a>
			</div>
			<div id="header_right">
				<div id="header_user">
					<a id="btn_logout" href="logout.action" target="top">退出登录</a><a id="btn_user" href="">用户信息</a><a id="btn_modifypass" href="">修改密码</a>
				</div>
				<span id="header_datetime">当前时间:<script language="javascript" type="text/javascript">getCurrentDate();</script></span>
			</div>
		</div>
		<div id="header_toolbar"><div id="header_toolbar_right"></div><div id="header_toolbar_menu"></div><div id="header_toolbar_content">当前登录用户：<c:choose><c:when test="${sessionScope.student!=null}">${sessionScope.student.realName}</c:when><c:when test="${sessionScope.leader!=null}">${sessionScope.leader.realName}</c:when><c:when test="${sessionScope.admin!=null}">${sessionScope.admin.realName}</c:when></c:choose>
  角色：<c:choose><c:when test="${sessionScope.userType==0}">学生</c:when><c:when test="${sessionScope.userType==1}">辅导员</c:when><c:when test="${sessionScope.userType==2}">管理员</c:when></c:choose></div></div>
	</body>
</html>