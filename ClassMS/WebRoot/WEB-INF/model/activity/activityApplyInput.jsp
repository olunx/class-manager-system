<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
		<h2 class="caption">活动加分申请 - ${requestScope.student.realName }</h2>
		<form class="form" action="add.action" method="post">
		<input name="sno" type="hidden" value="${param.sno }" />
			<div id="activity_input">
			<div>
			原因：<input class="inputmid" type="text" name="reason" />
			分数：<input type="text" name="mark" />
			<select name="type">
				<option value="德育">德育</option>
				<option value="活动">活动</option>
				<option value="文体">文体</option>
			</select>
			<a href="#" class="btn_del" onclick="delActivity(this)">删除</a>
			</div>
			<div>
			原因：<input class="inputmid" type="text" name="reason" />
			分数：<input type="text" name="mark" />
			<select name="type">
				<option value="德育">德育</option>
				<option value="活动">活动</option>
				<option value="文体">文体</option>
			</select>
			<a href="#" class="btn_del" onclick="delActivity(this)">删除</a>
			</div>
			<div>
			原因：<input class="inputmid" type="text" name="reason" />
			分数：<input type="text" name="mark" />
			<select name="type">
				<option value="德育">德育</option>
				<option value="活动">活动</option>
				<option value="文体">文体</option>
			</select>
			<a href="#" class="btn_del" onclick="delActivity(this)">删除</a>
			</div>
			</div>
			<a href="#" class="btn_add" onclick="addNewActivity('activity_input');">再添加三项</a>
			<input type="submit" value="提交申请" />
		</form>
	</body>
</html>