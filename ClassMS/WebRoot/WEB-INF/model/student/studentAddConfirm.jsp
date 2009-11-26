<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>添加学生</title>
	</head>
	<body>
		<h2 class="caption">
			批量注册确认：
		</h2>
			<div>
				${fileData}
			</div>
			<form action="addManyStudent" method="post">
				<input type="hidden" value="${fileName}" name="fileName" />
				<input type="submit" value="确认添加" />
			</form>
	</body>
</html>