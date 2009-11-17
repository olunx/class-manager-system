<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改职务信息</title>
	</head>
	<body>
		<h2 class="caption">
			修改职务信息
		</h2>
		<form action="updateDuty" method="post">
			adminId：
			<input type="text" name="dutyId" value="${duty.dutyId}" readonly="readonly" />
			<br />
			student：
			<input type="text" name="students" value="<c:forEach items="${duty.students}" var="s">${s.sno},</c:forEach>" />
			<br />
			dutyName：
			<input type="text" name="dutyName" value="${duty.dutyName}" />
			<br />
			job：
			<input type="text" name="job" value="${duty.job}" />
			<br />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
		</form>
	</body>
</html>