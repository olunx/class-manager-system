<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改考勤信息</title>
</head>
<body>
<form action="updateAttendance" method="post">
考勤信息串号：<input type="text" name="aid" value="${attendance.aid}" readonly="readonly"/> <br />
记录人员：<input type="text" name="clerk" value="${clerk}" /> <br />
第几周：<input type="text" name="week" value="${attendance.week}" /> <br />
星期几：<input type="text" name="day" value="${attendance.day}" /> <br />
逃课课时：<input type="text" name="lesson" value="${attendance.lesson}" /> <br />
逃课人员：<input type="text" name="students" value="${students}" /> <br />
<input type="submit" value="提交" /><input type="reset" value="重置"/>
</form>
</body>
</html>