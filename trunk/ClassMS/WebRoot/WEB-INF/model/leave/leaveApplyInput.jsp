<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<script language="JavaScript" type="text/javascript" src="../content/js/calendar/WdatePicker.js"></script> 
	</head>
	<body>
		<h2 class="caption">请假申请 - ${requestScope.student.realName }</h2>
		<form class="form" action="add.action" method="post">
		<input name="sno" type="hidden" value="${param.sno }" />
			<div id="activity_input">
			<p><label>原因：</label>
			<s:fielderror><s:param>reason</s:param></s:fielderror>
			<input class="inputmid" type="text" name="reason" /> </p>
			<p><label>开始时间：</label>
			<s:fielderror><s:param>airtime</s:param></s:fielderror>
			<input class="Wdate" type="text" name="airtime" onfocus="WdatePicker({startDate:'%y-%M-{%d+1} %H:%m:00',minDate:'%y-%M-%d %H:%m:00'})"/>  </p>
			<p><label>结束时间：</label>
			<s:fielderror><s:param>endtime</s:param></s:fielderror>
			<input class="Wdate" type="text" name="endtime" onfocus="WdatePicker({startDate:'%y-%M-{%d+1} %H:%m:00',minDate:'%y-%M-%d %H:%m:00'})"/> </p>
			</div>
			<p class="paddingmin">
				<input type="submit" value="提交申请" />
				<input type="reset" value="重置"/>
			</p>
		</form>
	</body>
</html>