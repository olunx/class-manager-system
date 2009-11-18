<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
		<form class="form" action="<%=path %>/fetion/sendFetion" method="post">
			<p>
				<label>手机号：</label>
				<input type="text" name="phone" value="" />
			</p>
			<p>
				<label>飞信密码：</label>
				<input type="password" name="pwd" value="" />
			</p>
			<p>
				<label>发送手机号：</label>
				<textarea rows="5" cols="60" name="tophones">${stuphones }</textarea>
			</p>
			<p>
				<label>发送内容：</label>
				<textarea rows="10" cols="60" name="content">${content }</textarea>
			</p>
			<p class="paddingmin">
				<input type="submit" value="发送" />
			</p>
		</form>
	</body>
</html>