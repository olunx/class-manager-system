<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改职务信息</title>
	</head>
	<body>
		<form class="form" action="updateDuty" method="post">
			<p>
				<label>
					ID号：
				</label>
				<input type="text" name="dutyId" value="${duty.dutyId}" readonly="readonly" />
			</p>
			<p>
				<label>
					担任者：
				</label>
				<input type="text" name="students" value="<c:forEach items="${duty.students}" var="s">${s.sno},</c:forEach>" />
			</p>
			<p>
				<label>
					职务名称：
				</label>
				<input type="text" name="dutyName" value="${duty.dutyName}" />
				<s:fielderror><s:param>dutyName</s:param></s:fielderror>
			</p>
			<p>
				<label>
					职务描述：
				</label>
				<input type="text" name="job" value="${duty.job}" />
				<s:fielderror><s:param>job</s:param></s:fielderror>
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
	</body>
</html>