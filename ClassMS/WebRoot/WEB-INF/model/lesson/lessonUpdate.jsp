<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改课程信息</title>
	</head>
	<body>
		<form class="form" action="updateLesson" method="post">
			<p>
				<label>
					ID号：
				</label>
				<input type="text" name="lessonId" value="${lesson.lessonId}" readonly="readonly" />
			</p>
			<p>
				<label>
					星期几：
				</label>
				<input type="text" name="day" value="${lesson.day}" />
				<s:fielderror><s:param>day</s:param></s:fielderror>
			</p>
			<p>
				<label>
					课程名称：
				</label>
				<input type="text" name="lessonName" value="${lesson.lessonName}" />
				<s:fielderror><s:param>lessonName</s:param></s:fielderror>
			</p>
			<p>
				<label>
					课程课时：
				</label>
				<input type="text" name="lessonPeriod" value="${lesson.lessonPeriod}" />
				<s:fielderror><s:param>lessonPeriod</s:param></s:fielderror>
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
	</body>
</html>