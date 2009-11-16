<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
   		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班费系统</title>
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
    

  </head>
  
  <body>
  		<h2 class="caption">
			<div class="float_right">
					<a class="btn" href="<%=path %>/classfee/list">返回列表</a>
			</div>
			班费管理
		</h2>
  		
   		<c:choose>
   			<c:when test="${param.value eq 'add' }">
   				添加班费记录成功，<a href="<%=path %>/classfee/query?fid=${classFee.fid }">点击查看</a>
   			</c:when>
   			<c:when test="${param.value eq 'delete' }">
   				删除班费记录成功！
   			</c:when>
   			<c:when test="${param.value eq 'deleteMany' }">
   				删除班费记录成功！
   			</c:when>
   			<c:when test="${param.value eq 'modify' }">
   				修改班费记录成功，<a href="<%=path %>/classfee/query?fid=${classFee.fid }">点击查看</a>
   			</c:when>
   			<c:otherwise>
   			</c:otherwise>
   		</c:choose>
   		<br />
   		<a href="<%=path %>/classfee/list"> 》》》返回班费管理《《《 </a>
  </body>
</html>
