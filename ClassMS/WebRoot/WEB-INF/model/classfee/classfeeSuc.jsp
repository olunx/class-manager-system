<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<c:choose>
   			<c:when test="${param.value eq 'add' }">
   				添加班费记录成功，<a href="<%=path %>/classfee/queryclassFee?fid=${classFee.fid }">点击查看</a>
   			</c:when>
   			<c:when test="${param.value eq 'delete' }">
   				删除班费记录成功！
   			</c:when>
   			<c:when test="${param.value eq 'modify' }">
   				修改班费记录成功，<a href="<%=path %>/classfee/queryclassFee?fid=${classFee.fid }">点击查看</a>
   			</c:when>
   			<c:otherwise>
   			</c:otherwise>
   		</c:choose>
   		<br />
   		<a href="<%=path %>/classfee/listclassFee"> 》》》返回班费管理《《《 </a>
  </body>
</html>
