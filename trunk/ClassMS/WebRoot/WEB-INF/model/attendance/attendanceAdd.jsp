<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>添加考勤信息</title>
	</head>
	<body>
		<h2 class="caption">
			添加考勤信息
		</h2>
		<form action="addAttendance" method="post">
			<div style="float: left">
				第
				<select size="1" name="week">
					<option selected="selected">
						1
					</option>
					<option>
						2
					</option>
					<option>
						3
					</option>
					<option>
						4
					</option>
					<option>
						5
					</option>
					<option>
						6
					</option>
					<option>
						7
					</option>
					<option>
						8
					</option>
				</select>
				周，
			</div>
			<div style="float: left">
				星期
				<select size="1" name="day">
					<option selected="selected">
						一
					</option>
					<option>
						二
					</option>
					<option>
						三
					</option>
					<option>
						四
					</option>
					<option>
						五
					</option>
					<option>
						六
					</option>
					<option>
						日
					</option>
				</select>
				，
			</div>
			<div style="float: left">
				第
				<select size="8" multiple="multiple" name="lesson">
					<option selected="selected">
						1
					</option>
					<option>
						2
					</option>
					<option>
						3
					</option>
					<option>
						4
					</option>
					<option>
						5
					</option>
					<option>
						6
					</option>
					<option>
						7
					</option>
					<option>
						8
					</option>
				</select>
				节
			</div>
			<br />
			逃课学生：
			<input type="text" name="students" />
			<s:fielderror><s:param>students</s:param></s:fielderror>
			录入人员：
			<input type="text" name="clerk" />
			<s:fielderror><s:param>clerk</s:param></s:fielderror>
			<br />
			<br />
			<button type="submit">
				提交
			</button>
		</form>
	</body>
</html>