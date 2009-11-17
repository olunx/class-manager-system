<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
	<h2 class="caption">加分申请审核，请选择</h2>
		<c:choose>
			<c:when test="${students eq null}">
				暂时没有信息
			</c:when>
			<c:otherwise>
				<c:forEach items="${students}" var="stu" varStatus="vs">
					<a href="listPage?sno=${stu.sno}">${stu.realName }</a> 
					<c:if test="${(vs.count%10)==0}"><br/><br/></c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</body>
</html>