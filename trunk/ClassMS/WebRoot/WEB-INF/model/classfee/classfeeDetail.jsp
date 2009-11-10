<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班费系统</title>
	</head>
	<body>
		<div> <a href="<%=path %>/classfee/queryAllclassFee">返回列表</a> </div>
		<div>
			<ol>
				<li>班费串号：${classFee.fid }</li>
				<li>班费事件：${classFee.event }</li>
				<li>费用：${classFee.fee }</li>
				<li>备注：${classFee.remarks }</li>
				<li>经手人：${classFee.cmaker.realName }</li>
				<li>创建时间：${classFee.time }</li>
			</ol>
		</div>
		<div>
			<a href="<%=path %>/modifyLinkclassFee.action?fid=${classFee.fid }">修改</a>						
			<a href="<%=path %>/deleteclassFee.action?fid=${classFee.fid }">删除</a>
		</div>
	</body>
</html>