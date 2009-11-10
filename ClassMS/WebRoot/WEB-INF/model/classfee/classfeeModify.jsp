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
		<div><h1>修改班费记录</h1> </div>
		<div>
			<form action="<%=path %>/modifyclassFee" method="post">
				班费串号：<input type="text" name="classFee.fid" value="${classFee.fid}" readonly="readonly"/> <br />
				班费事件：<input type="text" name="classFee.event" value="${classFee.event }"/> <br />
				班费费用：<input type="text" name="fee" value="${classFee.fee }" /> <br />
				&nbsp;&nbsp;&nbsp;&nbsp;备注：${classFee.remarks} <br />
				          <input type="submit" value="提交" />
				          <input type="reset" value="重置"/>
			</form>
		</div>
	</body>
</html>